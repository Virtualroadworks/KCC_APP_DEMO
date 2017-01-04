package com.example.laptop.truckmanv5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

public class zRegemail extends AppCompatActivity implements View.OnClickListener  {

    private Firebase mRootRef;
    private FirebaseAuth firebaseAuth;


    private EditText etuser_email;
    private ImageButton z_regnamerightarrow,z_regnameleftarrow;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z_regemail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressDialog = new ProgressDialog(this);

        Firebase.setAndroidContext(this);
        mRootRef = new Firebase("https://truckman-1dc51.firebaseio.com");
        firebaseAuth = FirebaseAuth.getInstance();

        z_regnamerightarrow = (ImageButton) findViewById(R.id.z_regnamerightarrow);
        z_regnameleftarrow = (ImageButton) findViewById(R.id.z_regnameleftarrow);


        etuser_email = (EditText) findViewById(R.id.etuser_email);


        z_regnamerightarrow.setOnClickListener(this);
        z_regnameleftarrow.setOnClickListener(this);

        mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                String user_email = dataSnapshot.child("User Email").getValue(String.class);

                if (user_email == null) {
                    etuser_email.setText("");
                } else {
                    etuser_email.setText(user_email);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == z_regnamerightarrow) {

            progressDialog.setMessage("Adding User Email...");
            progressDialog.show();


            String user_email = etuser_email.getText().toString();

            Firebase childRef = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("User Email");

            childRef.setValue(user_email);

            if(TextUtils.isEmpty(user_email)) {

                Toast.makeText(this, "Please enter User Email Address", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                return;
            }


            startActivity(new Intent(getApplicationContext(), User_Basearea.class));
            progressDialog.dismiss();

        }
        if (view == z_regnameleftarrow) {
            startActivity(new Intent(this, zRegphone.class));

        }
    }

}