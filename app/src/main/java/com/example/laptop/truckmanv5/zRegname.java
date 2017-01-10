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

public class zRegname extends AppCompatActivity implements View.OnClickListener {


    private Firebase mRootRef;
    private FirebaseAuth firebaseAuth;


    private EditText etuser_name, etuser_access_level;
    private ImageButton z_regnamerightarrow,z_regnameleftarrow;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z_regname);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressDialog = new ProgressDialog(this);

        Firebase.setAndroidContext(this);
        mRootRef = new Firebase("https://truckman-1dc51.firebaseio.com");
        firebaseAuth = FirebaseAuth.getInstance();

        z_regnamerightarrow = (ImageButton) findViewById(R.id.z_regnamerightarrow);
        z_regnameleftarrow = (ImageButton) findViewById(R.id.z_regnameleftarrow);


        etuser_name = (EditText) findViewById(R.id.etuser_name);
        etuser_access_level = (EditText) findViewById(R.id.etuser_access_level);

        z_regnamerightarrow.setOnClickListener(this);
        z_regnameleftarrow.setOnClickListener(this);

        mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                String user_name = dataSnapshot.child("User Name").getValue(String.class);

                if (user_name == null) {
                    etuser_name.setText("");
                } else {
                    etuser_name.setText(user_name);
                }

                String user_access_level = dataSnapshot.child("User Access Level").getValue(String.class);

                if (user_access_level == null) {
                    etuser_access_level.setText("Level 0");
                } else {
                    etuser_access_level.setText(user_access_level);
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

            progressDialog.setMessage("Adding User Name...");
            progressDialog.show();

            String user_name = etuser_name.getText().toString();

            Firebase childRef = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("User Name");

            childRef.setValue(user_name);

            if(TextUtils.isEmpty(user_name)) {

                Toast.makeText(this, "Please enter User Name", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                return;
            }

            Firebase childRef2 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("User Access Level");
            String user_access_level = etuser_access_level.getText().toString();

            childRef2.setValue(user_access_level);


            startActivity(new Intent(getApplicationContext(), zRegphone.class));
            progressDialog.dismiss();

        }
        if (view == z_regnameleftarrow) {
            firebaseAuth.signOut();
            startActivity(new Intent(this, DCC_Login_or_Reg.class));

        }
    }

}