package com.example.laptop.truckmanv5;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

public class Userheldoutsideapp extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Firebase mRootRef;

    private TextView user_name2,access_level;

    private String Level_0 = "Level 0";
    private String Level_1 = "Level 1";
    private String Level_2 = "Level 2";
    private String Level_3 = "Level 3";

    FrameLayout Lockoutuserframelayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userheldoutsideapp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();
        Firebase.setAndroidContext(this);
        mRootRef = new Firebase("https://truckman-1dc51.firebaseio.com");

        user_name2 = (TextView) findViewById(R.id.user_name2);
        access_level = (TextView) findViewById(R.id.access_level);
        Lockoutuserframelayout = (FrameLayout) findViewById(R.id.Lockoutuserframelayout);

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
                    Lockoutuserframelayout.setVisibility(View.VISIBLE);
                } else if(Level_1.equals (userAccessLevel)) {
                    Lockoutuserframelayout.setVisibility(View.GONE);
                    startActivity(new Intent(Userheldoutsideapp.this, MainActivity.class));
                } else if(Level_2.equals (userAccessLevel)) {
                    Lockoutuserframelayout.setVisibility(View.GONE);
                    startActivity(new Intent(Userheldoutsideapp.this, MainActivity.class));
                } else if(Level_3.equals (userAccessLevel)) {
                    Lockoutuserframelayout.setVisibility(View.GONE);
                    startActivity(new Intent(Userheldoutsideapp.this, MainActivity.class));
                }

                access_level.setText(userAccessLevel);
                user_name2.setText(userName);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }

}
