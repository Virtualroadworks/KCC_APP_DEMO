package com.example.laptop.truckmanv5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

public class dccdrainageforms extends AppCompatActivity  {

    Button form_at0013_3;
    Button database_at0013_3;

    Button form_Vehicle_check;
    Button database_Vehicle_check;

    private FirebaseAuth firebaseAuth;
    private Firebase mRootRef;

    private String Level_0 = "Level 0";
    private String Level_1 = "Level 1";
    private String Level_2 = "Level 2";
    private String Level_3 = "Level 3";

    FrameLayout Dailyvehiclewalkaroundcheckframelayout;
    FrameLayout Inspectioncheckframelayout;
    FrameLayout Confinedspacecheckframelayout;
    FrameLayout Siteriskcheckframelayout;
    FrameLayout InspectManagementcheckframelayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dccdrainageforms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        form_at0013_3 = (Button) findViewById(R.id.form_at0013_3);
        database_at0013_3 = (Button) findViewById(R.id.database_at0013_3);

        form_Vehicle_check = (Button) findViewById(R.id.form_Vehicle_check);
        database_Vehicle_check = (Button) findViewById(R.id.database_Vehicle_check);

        firebaseAuth = FirebaseAuth.getInstance();
        Firebase.setAndroidContext(this);
        mRootRef = new Firebase("https://truckman-1dc51.firebaseio.com");

        Dailyvehiclewalkaroundcheckframelayout = (FrameLayout) findViewById(R.id.Dailyvehiclewalkaroundcheckframelayout);
        Inspectioncheckframelayout = (FrameLayout) findViewById(R.id.Inspectioncheckframelayout);
        Confinedspacecheckframelayout = (FrameLayout) findViewById(R.id.Confinedspacecheckframelayout);
        Siteriskcheckframelayout = (FrameLayout) findViewById(R.id.Siteriskcheckframelayout);
        InspectManagementcheckframelayout = (FrameLayout) findViewById(R.id.InspectManagementcheckframelayout);


        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, Login_Page.class));
        }

        mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                String userName = dataSnapshot.child("User Name").getValue(String.class);

                String userAccessLevel = dataSnapshot.child("User Access Level").getValue(String.class);

                if (Level_0.equals (userAccessLevel)) {
                    startActivity(new Intent(dccdrainageforms.this, Userheldoutsideapp.class));
                } else if(Level_1.equals (userAccessLevel)) {
                    Dailyvehiclewalkaroundcheckframelayout.setVisibility(View.VISIBLE);
                    Inspectioncheckframelayout.setVisibility(View.VISIBLE);
                    Confinedspacecheckframelayout.setVisibility(View.GONE);
                    Siteriskcheckframelayout.setVisibility(View.GONE);
                    InspectManagementcheckframelayout.setVisibility(View.GONE);
                } else if(Level_2.equals (userAccessLevel)) {
                    Dailyvehiclewalkaroundcheckframelayout.setVisibility(View.VISIBLE);
                    Inspectioncheckframelayout.setVisibility(View.VISIBLE);
                    Confinedspacecheckframelayout.setVisibility(View.VISIBLE);
                    Siteriskcheckframelayout.setVisibility(View.VISIBLE);
                    InspectManagementcheckframelayout.setVisibility(View.GONE);
                } else if(Level_3.equals (userAccessLevel)) {
                    Dailyvehiclewalkaroundcheckframelayout.setVisibility(View.VISIBLE);
                    Inspectioncheckframelayout.setVisibility(View.VISIBLE);
                    Confinedspacecheckframelayout.setVisibility(View.VISIBLE);
                    Siteriskcheckframelayout.setVisibility(View.VISIBLE);
                    InspectManagementcheckframelayout.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        database_at0013_3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(dccdrainageforms.this, AT0013_3_database.class));
            }
        });



        form_at0013_3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
                Intent nextView = new Intent(dccdrainageforms.this, AT0013_3_database.class);
                nextView.putExtra("CalledFromdccnorthsideforms", true);
                startActivity(nextView);
            }
        });

        database_Vehicle_check.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(dccdrainageforms.this, Vehicle_Reports.class));
            }
        });



        form_Vehicle_check.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
                Intent nextView = new Intent(dccdrainageforms.this, Vehicle_Reports.class);
                nextView.putExtra("CalledFromdccnorthsideforms", true);
                startActivity(nextView);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.vrhome:
                startActivity (new Intent(this, MainActivity.class));
                return true;

            case R.id.vrdatabase:
                startActivity (new Intent(this, dccdrainageforms.class));
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

}