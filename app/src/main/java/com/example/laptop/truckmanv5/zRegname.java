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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class zRegname extends AppCompatActivity implements View.OnClickListener {


    private Firebase mRootRef;
    private FirebaseAuth firebaseAuth;

    private EditText etuser_name, etuser_access_level,etuser_date;
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
        mRootRef = new Firebase("https://road-safety-contracts-demo.firebaseio.com");
        firebaseAuth = FirebaseAuth.getInstance();

        z_regnamerightarrow = (ImageButton) findViewById(R.id.z_regnamerightarrow);
        z_regnameleftarrow = (ImageButton) findViewById(R.id.z_regnameleftarrow);


        etuser_name = (EditText) findViewById(R.id.etuser_name);
        etuser_access_level = (EditText) findViewById(R.id.etuser_access_level);
        etuser_date = (EditText) findViewById(R.id.etuser_date);

        z_regnamerightarrow.setOnClickListener(this);
        z_regnameleftarrow.setOnClickListener(this);

        Date date = new Date();
        String currentDateandTime = DateFormat.getDateTimeInstance().format(date);

        Firebase childRef2 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("User Access Level");
        childRef2.setValue("Level 0");

        Firebase childRef3 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("User Account Created on");
        childRef3.setValue(currentDateandTime);

        Firebase childRef3a = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("Time User last connected");
        childRef3a.setValue(currentDateandTime);

        Firebase childRef4 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("1_Day_Health");
        childRef4.setValue("No");

        Firebase childRef5 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("First_aid");
        childRef5.setValue("No");

        Firebase childRef6 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("Forklift");
        childRef6.setValue("No");

        Firebase childRef7 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("HGV Licence");
        childRef7.setValue("No");

        Firebase childRef8 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("SLG");
        childRef8.setValue("No");

        Firebase childRef9 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("Safepass");
        childRef9.setValue("No");

        Firebase childRef10 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("User Company");
        childRef10.setValue("TBC");

        Firebase childRef11 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("User Security Level");
        childRef11.setValue("User");

        Firebase childRef12 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("Manual Handling");
        childRef12.setValue("No");

        mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                String user_name = dataSnapshot.child("User Name").getValue(String.class);

                if (user_name == null) {
                    etuser_name.setText("");
                } else {
                    etuser_name.setText(user_name);
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

            Firebase childRef = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("User Name");
            String user_name = etuser_name.getText().toString();
            childRef.setValue(user_name);

            if(TextUtils.isEmpty(user_name)) {

                Toast.makeText(this, "Please enter User Name", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                return;
            }

            startActivity(new Intent(getApplicationContext(), zRegphone.class));
            progressDialog.dismiss();

        }
        if (view == z_regnameleftarrow) {
            firebaseAuth.signOut();
            startActivity(new Intent(this, DCC_Login_or_Reg.class));

        }
    }

}