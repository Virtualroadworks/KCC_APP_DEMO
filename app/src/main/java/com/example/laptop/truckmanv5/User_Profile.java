package com.example.laptop.truckmanv5;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class User_Profile extends AppCompatActivity implements View.OnClickListener {

    private TextView User_Name_tital;
    private TextView User_Name_tital_fill;
    private TextView User_Email_tital;
    private TextView User_Email_tital_fill;
    private TextView Report_email_recipient;
    private TextView etreport_email_recipient;
    private TextView User_Company_tital;
    private TextView User_Company_tital_fill;
    private TextView User_Contact_Number_tital;
    private TextView User_Contact_Number_tital_fill;


    private Button MainMenuButton;

    private Firebase mRootRef;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Firebase.setAndroidContext(this);
        mRootRef = new Firebase("https://truckman-1dc51.firebaseio.com/");
        firebaseAuth = FirebaseAuth.getInstance();

        User_Name_tital_fill = (TextView) findViewById(R.id.User_Name_tital_fill);
        User_Email_tital_fill = (TextView) findViewById(R.id.User_Email_tital_fill);
        Report_email_recipient = (TextView) findViewById(R.id.etreport_email_recipient);
        User_Company_tital_fill = (TextView) findViewById(R.id.User_Company_tital_fill);
        User_Contact_Number_tital_fill = (TextView) findViewById(R.id.User_Contact_Number_tital_fill);

        User_Name_tital = (TextView) findViewById(R.id.User_Name_tital);
        User_Email_tital = (TextView) findViewById(R.id.User_Email_tital);
        etreport_email_recipient = (TextView) findViewById(R.id.etreport_email_recipient);
        User_Company_tital = (TextView) findViewById(R.id.User_Company_tital);
        User_Contact_Number_tital = (TextView) findViewById(R.id.User_Contact_Number_tital);


        MainMenuButton = (Button) findViewById(R.id.MainMenuButton);
        MainMenuButton.setOnClickListener(this);



        mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                String userName  = dataSnapshot.child("User Name").getValue(String.class);
                String userEmail  = dataSnapshot.child("User Email").getValue(String.class);
                String report_email_recipient  = dataSnapshot.child("Report Email Recipient").getValue(String.class);
                String userCompany  = dataSnapshot.child("User Company").getValue(String.class);
                String userContactNumber  = dataSnapshot.child("User Contact Number").getValue(String.class);

                User_Name_tital_fill.setText(userName);
                User_Email_tital_fill.setText(userEmail);
                etreport_email_recipient.setText(report_email_recipient);
                User_Company_tital_fill.setText(userCompany);
                User_Contact_Number_tital_fill.setText(userContactNumber);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



    }




    public void onClick(View v) {
        // Do something when the button is clicked

        switch (v.getId()) {

            case R.id.MainMenuButton:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(this, "Welcome to the Main Menu", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    //////////////////Tool Bar Nav Buttons/////////////////////////////

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
                startActivity (new Intent(this, Vehicle_Reports.class));
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

}

