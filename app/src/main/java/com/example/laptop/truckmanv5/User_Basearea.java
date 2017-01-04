package com.example.laptop.truckmanv5;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class User_Basearea extends AppCompatActivity {

    ImageButton dublincitymapnorthsidebutton;
    ImageButton dublincitymapsouthsidebutton;


    TextView area_set_text;
    TextView address_set_text;
    TextView county_set_text;
    TextView phone_set_text;

    LinearLayout area_details_layout;

    FrameLayout dublincitymapsouthsidebuttonframelayout;
    FrameLayout dublincitymapnorthsidebuttonframelayout;

    LinearLayout dublincitymapsouthsidebuttonLinearlayout;
    LinearLayout dublincitymapnorthsidebuttonLinearlayout;



    Button Profile_upload_button;

    private Firebase mRootRef;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__basearea);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Firebase.setAndroidContext(this);
        mRootRef = new Firebase("https://truckman-1dc51.firebaseio.com");
        firebaseAuth = FirebaseAuth.getInstance();


        dublincitymapnorthsidebutton = (ImageButton) findViewById(R.id.dublincitymapnorthsidebutton);
        dublincitymapsouthsidebutton = (ImageButton) findViewById(R.id.dublincitymapsouthsidebutton);


        area_details_layout = (LinearLayout) findViewById(R.id.area_details_layout);

        dublincitymapsouthsidebuttonLinearlayout = (LinearLayout) findViewById(R.id.dublincitymapsouthsidebuttonLinearlayout);
        dublincitymapnorthsidebuttonLinearlayout = (LinearLayout) findViewById(R.id.dublincitymapnorthsidebuttonLinearlayout);

        area_details_layout .setVisibility(View.GONE);

        area_set_text = (TextView) findViewById(R.id. area_set_text);
        address_set_text = (TextView) findViewById(R.id. address_set_text);
        county_set_text = (TextView) findViewById(R.id. county_set_text);
        phone_set_text = (TextView) findViewById(R.id. phone_set_text);

        Profile_upload_button = (Button) findViewById(R.id.Profile_upload_button);

        addListenerOnButton();
    }
    public void addListenerOnButton() {


        dublincitymapsouthsidebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                area_details_layout.setVisibility(View.VISIBLE);
                dublincitymapnorthsidebuttonLinearlayout.setVisibility(View.GONE);
                dublincitymapnorthsidebutton.setVisibility(View.GONE);
                area_set_text.setText("Main Drainage Depot");
                address_set_text.setText("Marrowbone Lane");
                county_set_text.setText("Dublin 8");
                phone_set_text.setText("(0)1 453 1020");
                Toast.makeText(User_Basearea.this,

                        "Southside Maintenance is clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        dublincitymapnorthsidebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                area_details_layout.setVisibility(View.VISIBLE);
                dublincitymapsouthsidebuttonLinearlayout.setVisibility(View.GONE);
                dublincitymapsouthsidebutton.setVisibility(View.GONE);
                area_set_text.setText("Main Drainage Depot");
                address_set_text.setText("Bannow Road, Cabra");
                county_set_text.setText("Dublin 7");
                phone_set_text.setText("(0)1 838 3870");
                Toast.makeText(User_Basearea.this,

                        "Northside Maintenance is clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        Profile_upload_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String depot_area = area_set_text.getText().toString();

                Firebase childRef = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("Address Line 1");

                childRef.setValue(depot_area);

                String depot_address = address_set_text.getText().toString();

                Firebase childRef2 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("Address Line 2");

                childRef2.setValue(depot_address);

                String depot_county = county_set_text.getText().toString();

                Firebase childRef3 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("Address Line 3");

                childRef3.setValue(depot_county);

                String depot_contact_number = phone_set_text.getText().toString();

                Firebase childRef4 = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("Depot Contact Number");

                childRef4.setValue(depot_contact_number);

                startActivity(new Intent(getApplicationContext(), MainActivity.class));

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

}
