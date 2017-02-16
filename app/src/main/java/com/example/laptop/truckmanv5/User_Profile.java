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
import android.widget.CheckBox;
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

    private TextView User_Account_Created_on_tital_fill;
    private TextView Time_User_last_connected_tital_fill;

    private TextView User_Email_tital;
    private TextView User_Email_tital_fill;
    private TextView Report_email_recipient;
    private TextView etreport_email_recipient;
    private TextView User_Company_tital;
    private TextView User_Company_tital_fill;
    private TextView User_Contact_Number_tital;
    private TextView User_Contact_Number_tital_fill;

    private TextView User_Role_tital;
    private TextView User_Role_tital_fill;

    private TextView User_Access_tital;
    private TextView User_Access_tital_fill;

    private TextView Depot_Area_fill;
    private TextView Depot_Address_fill;
    private TextView Depot_County_fill;
    private TextView Depot_Contact_Number_fill;


    CheckBox User_qualification_Safepass;
    CheckBox User_qualification_1_Day_Health;
    CheckBox User_qualification_SLG;
    CheckBox User_qualification_HGV_licence;
    CheckBox User_qualification_Forklift;
    CheckBox User_qualification_Manual_handling;
    CheckBox User_qualification_First_aid;


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
        User_Account_Created_on_tital_fill = (TextView) findViewById(R.id.User_Account_Created_on_tital_fill);
        Time_User_last_connected_tital_fill = (TextView) findViewById(R.id.Time_User_last_connected_tital_fill);
        User_Email_tital_fill = (TextView) findViewById(R.id.User_Email_tital_fill);
        Report_email_recipient = (TextView) findViewById(R.id.etreport_email_recipient);
        User_Company_tital_fill = (TextView) findViewById(R.id.User_Company_tital_fill);
        User_Contact_Number_tital_fill = (TextView) findViewById(R.id.User_Contact_Number_tital_fill);

        User_Role_tital_fill = (TextView) findViewById(R.id.User_Role_tital_fill);
        User_Access_tital_fill = (TextView) findViewById(R.id.User_Access_tital_fill);

        Depot_Area_fill = (TextView) findViewById(R.id.Depot_Area_fill);
        Depot_Address_fill = (TextView) findViewById(R.id.Depot_Address_fill);
        Depot_County_fill= (TextView) findViewById(R.id.Depot_County_fill);
        Depot_Contact_Number_fill = (TextView) findViewById(R.id.Depot_Contact_Number_fill);

        User_Name_tital = (TextView) findViewById(R.id.User_Name_tital);
        User_Email_tital = (TextView) findViewById(R.id.User_Email_tital);
        etreport_email_recipient = (TextView) findViewById(R.id.etreport_email_recipient);
        User_Company_tital = (TextView) findViewById(R.id.User_Company_tital);
        User_Contact_Number_tital = (TextView) findViewById(R.id.User_Contact_Number_tital);


        MainMenuButton = (Button) findViewById(R.id.MainMenuButton);
        MainMenuButton.setOnClickListener(this);


        User_qualification_Safepass = (CheckBox) findViewById(R.id.User_qualification_Safepass);
        User_qualification_1_Day_Health = (CheckBox) findViewById(R.id.User_qualification_1_Day_Health);
        User_qualification_SLG = (CheckBox) findViewById(R.id.User_qualification_SLG);
        User_qualification_HGV_licence = (CheckBox) findViewById(R.id.User_qualification_HGV_licence);
        User_qualification_Forklift = (CheckBox) findViewById(R.id.User_qualification_Forklift);
        User_qualification_Manual_handling = (CheckBox) findViewById(R.id.User_qualification_Manual_handling);
        User_qualification_First_aid = (CheckBox) findViewById(R.id.User_qualification_First_aid);




        mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                String userName  = dataSnapshot.child("User Name").getValue(String.class);
                String Account_Created_on  = dataSnapshot.child("User Account Created on").getValue(String.class);
                String Time_User_last_connected  = dataSnapshot.child("Time User last connected").getValue(String.class);
                String userEmail  = dataSnapshot.child("User Email").getValue(String.class);
                String report_email_recipient  = dataSnapshot.child("Report Email Recipient").getValue(String.class);
                String userCompany  = dataSnapshot.child("User Company").getValue(String.class);
                String userContactNumber  = dataSnapshot.child("User Contact Number").getValue(String.class);

                String userRole  = dataSnapshot.child("User Security Level").getValue(String.class);
                String userAccess  = dataSnapshot.child("User Access Level").getValue(String.class);

                String depot_area = dataSnapshot.child("Address Line 1").getValue(String.class);
                String depot_address = dataSnapshot.child("Address Line 2").getValue(String.class);
                String depot_county = dataSnapshot.child("Address Line 3").getValue(String.class);
                String depot_contact_number = dataSnapshot.child("Depot Contact Number").getValue(String.class);

                User_Name_tital_fill.setText(userName);
                User_Account_Created_on_tital_fill.setText(Account_Created_on);
                Time_User_last_connected_tital_fill.setText(Time_User_last_connected);
                User_Email_tital_fill.setText(userEmail);
                etreport_email_recipient.setText(report_email_recipient);
                User_Company_tital_fill.setText(userCompany);
                User_Contact_Number_tital_fill.setText(userContactNumber);

                User_Role_tital_fill.setText(userRole);
                User_Access_tital_fill.setText(userAccess);

                Depot_Area_fill.setText(depot_area);
                Depot_Address_fill.setText(depot_address);
                Depot_County_fill.setText(depot_county);
                Depot_Contact_Number_fill.setText(depot_contact_number);



                String Safepass = dataSnapshot.child("Safepass").getValue(String.class);
                if (Safepass == null) {
                    User_qualification_Safepass.setChecked(false);
                } else {
                    if (Safepass.equals("Yes")) {
                        User_qualification_Safepass.setChecked(true);
                    }
                    else {
                        User_qualification_Safepass.setChecked(false);
                    }
                }

                String Day_Health = dataSnapshot.child("1_Day_Health").getValue(String.class);
                if (Day_Health == null) {
                    User_qualification_1_Day_Health.setChecked(false);
                } else {
                    if (Day_Health.equals("Yes")) {
                        User_qualification_1_Day_Health.setChecked(true);
                    }
                    else {
                        User_qualification_1_Day_Health.setChecked(false);
                    }
                }

                String SLG = dataSnapshot.child("SLG").getValue(String.class);
                if (SLG == null) {
                    User_qualification_SLG.setChecked(false);
                } else {
                    if (SLG.equals("Yes")) {
                        User_qualification_SLG.setChecked(true);
                    }
                    else {
                        User_qualification_SLG.setChecked(false);
                    }
                }

                String HGV_licence = dataSnapshot.child("HGV Licence").getValue(String.class);
                if (HGV_licence == null) {
                    User_qualification_HGV_licence.setChecked(false);
                } else {
                    if (HGV_licence.equals("Yes")) {
                        User_qualification_HGV_licence.setChecked(true);
                    }
                    else {
                        User_qualification_HGV_licence.setChecked(false);
                    }
                }

                String Forklift = dataSnapshot.child("Forklift").getValue(String.class);
                if (Forklift == null) {
                    User_qualification_Forklift.setChecked(false);
                } else {
                    if (Forklift.equals("Yes")) {
                        User_qualification_Forklift.setChecked(true);
                    }
                    else {
                        User_qualification_Forklift.setChecked(false);
                    }
                }

                String Manual_handling = dataSnapshot.child("Manual Handling").getValue(String.class);
                if (Manual_handling == null) {
                    User_qualification_Manual_handling.setChecked(false);
                } else {
                    if (Manual_handling.equals("Yes")) {
                        User_qualification_Manual_handling.setChecked(true);
                    }
                    else {
                        User_qualification_Manual_handling.setChecked(false);
                    }
                }

                String First_aid = dataSnapshot.child("First_aid").getValue(String.class);
                if (First_aid == null) {
                    User_qualification_First_aid.setChecked(false);
                } else {
                    if (First_aid.equals("Yes")) {
                        User_qualification_First_aid.setChecked(true);
                    }
                    else {
                        User_qualification_First_aid.setChecked(false);
                    }
                }

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
                finish();

            case R.id.vrdatabase:
                startActivity (new Intent(this, dccdrainageforms.class));
                finish();

        }

        return super.onOptionsItemSelected(item);
    }

}

