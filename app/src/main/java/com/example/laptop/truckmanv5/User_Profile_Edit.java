package com.example.laptop.truckmanv5;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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


public class User_Profile_Edit extends AppCompatActivity {

    private TextView User_Name_tital;
    private EditText etuser_name;

    private TextView User_Email_tital;
    private EditText etuser_email;

    private TextView report_email_recipient;
    private EditText etreport_email_recipient;


    private TextView User_Company_tital;
    private EditText etuser_company;

    private TextView User_Contact_Number_tital;
    private EditText etuser_contact_number;

    Button Profile_upload_button;

    private Firebase mRootRef;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile__edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Firebase.setAndroidContext(this);
        mRootRef = new Firebase("https://truckman-1dc51.firebaseio.com");
        firebaseAuth = FirebaseAuth.getInstance();


        //getmDatabase().child("users").child(firebaseAuth.getCurrentUser().getUid()).

        etuser_name = (EditText) findViewById(R.id.etuser_name);
        etuser_email = (EditText) findViewById(R.id.etuser_email);
        etreport_email_recipient = (EditText) findViewById(R.id.etreport_email_recipient);
        etuser_company = (EditText) findViewById(R.id.etuser_company);
        etuser_contact_number = (EditText) findViewById(R.id.etuser_contact_number);

        User_Name_tital = (TextView) findViewById(R.id.User_Name_tital);
        User_Email_tital = (TextView) findViewById(R.id.User_Email_tital);
        User_Company_tital = (TextView) findViewById(R.id.User_Company_tital);
        User_Contact_Number_tital = (TextView) findViewById(R.id.User_Contact_Number_tital);

        Profile_upload_button = (Button) findViewById(R.id.Profile_upload_button);
        Profile_upload_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String Value1 = etuser_name.getText().toString();

                Firebase childRef = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("User Name");

                childRef.setValue(Value1);

                String Value2 = etuser_email.getText().toString();

                Firebase childRef2 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("User Email");

                childRef2.setValue(Value2);

                String Value3 = etuser_company.getText().toString();

                Firebase childRef3 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("User Company");

                childRef3.setValue(Value3);

                String Value4 = etuser_contact_number.getText().toString();

                Firebase childRef4 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("User Contact Number");

                childRef4.setValue(Value4);

                String Value5 = etreport_email_recipient.getText().toString();

                Firebase childRef5 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("Report Email Recipient");

                childRef5.setValue(Value5);

                startActivity(new Intent(getApplicationContext(), User_Profile.class));

            }
        });
        mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                String userName  = dataSnapshot.child("User Name").getValue(String.class);
                String userEmail  = dataSnapshot.child("User Email").getValue(String.class);
                String report_email_recipient  = dataSnapshot.child("Report Email Recipient").getValue(String.class);
                String userCompany  = dataSnapshot.child("User Company").getValue(String.class);
                String userContactNumber  = dataSnapshot.child("User Contact Number").getValue(String.class);

                etuser_name.setText(userName);
                etuser_email.setText(userEmail);
                etreport_email_recipient.setText(report_email_recipient );
                etuser_company.setText(userCompany);
                etuser_contact_number.setText(userContactNumber);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
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
