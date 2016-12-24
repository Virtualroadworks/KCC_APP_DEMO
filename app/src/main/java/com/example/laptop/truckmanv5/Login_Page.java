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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Login_Page extends AppCompatActivity implements View.OnClickListener {

    private EditText lgemail;
    private EditText lgpassword;
    private Button blogin;
    private TextView regherelink;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        if (firebaseAuth.getCurrentUser() != null) {
            //Profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }

        lgemail = (EditText) findViewById(R.id.lgemail);
        lgpassword = (EditText) findViewById(R.id.lgpassword);
        blogin = (Button) findViewById(R.id.blogin);
        regherelink = (TextView) findViewById(R.id.regherelink);

        progressDialog = new ProgressDialog(this);

        blogin.setOnClickListener(this);
        regherelink.setOnClickListener(this);
    }



    private void userLogin() {
        final String Email = lgemail.getText().toString().trim();
        String Password = lgpassword.getText().toString().trim();

        if (TextUtils.isEmpty(Email)) {
            //email is empty
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }

        if (TextUtils.isEmpty(Password)) {
            //email is empty
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            //stopping the function execution further
            return;
        }
        // if validations are ok
        //we will first show a progressbar

        progressDialog.setMessage("Login user...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()) {
                            //start the profile activity
                            Map<String, Object> map = new HashMap<String, Object>();
                            map.put("email", Email);
                            databaseReference.child("users").child(firebaseAuth.getCurrentUser().getUid()).updateChildren(map);
                            finish();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));



                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == blogin){
            userLogin();
        }

        if(view == regherelink){
            finish();
            startActivity(new Intent(this, Register_Page.class));
        }
    }
}