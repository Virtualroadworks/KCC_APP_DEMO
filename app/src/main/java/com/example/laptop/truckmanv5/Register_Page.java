package com.example.laptop.truckmanv5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_Page extends AppCompatActivity implements View.OnClickListener{

    private EditText Regemail;
    private EditText RegPassword;
    private Button bRegister;
    private TextView Loginherelink;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__page);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();


        if (firebaseAuth.getCurrentUser() != null) {
            //Profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        Regemail = (EditText) findViewById(R.id.lgemail);
        RegPassword = (EditText) findViewById(R.id.RegPassword);
        bRegister = (Button) findViewById(R.id.blogin);
        Loginherelink = (TextView) findViewById(R.id.Loginherelink);

        bRegister.setOnClickListener(this);
        Loginherelink.setOnClickListener(this);
    }

    private void registerUser(){
        String Email = Regemail.getText().toString().trim();
        String Password = RegPassword.getText().toString().trim();

        if(TextUtils.isEmpty(Email)) {
            //email is empty
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }

        if(TextUtils.isEmpty(Password)) {
            //email is empty
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }
        // if validations are ok
        //we will first show a progressbar

        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //user is successfully registered and loggin in
                            finish();
                            startActivity(new Intent(getApplicationContext(),zRegname.class));
                            //we will start the profile activit here
                            //right now lets display a toast only
                            Toast.makeText(Register_Page.this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(Register_Page.this, "Registered Failed, Please try again", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });


    }

    @Override
    public void onClick(View view) {
        if (view == bRegister) {
            registerUser();
        }
        if (view == Loginherelink) {
            startActivity(new Intent(this, Login_Page.class));
            //will open Login activity
        }
    }
}
