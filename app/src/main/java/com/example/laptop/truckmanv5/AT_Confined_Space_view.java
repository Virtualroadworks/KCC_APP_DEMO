package com.example.laptop.truckmanv5;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;



public class AT_Confined_Space_view extends AppCompatActivity implements UserLocation.LocationCallback{

    TextView user_name,user_email,user_department_area,user_contact_number,time_stamp;


    CoordinatorLayout cl;
    Button bOK,bCancel;
    int position;
    AT_Confined_Space_model AT_Confined_Space_model;

    boolean internet_connected;

    TextView Onlinetext;
    TextView GPSOnlinetext;
    ImageView onlineicon;
    ImageView gpsonlineicon;

    double Locationlat = 0;
    double Locationlong = 0;

    UserLocation userLocation;

    public boolean  Online_check () {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }




    private ProgressDialog mProgressDialog;

    private StorageReference mStorage;



    ///////////////////////////////////////////////////////////////////////////////////


    Boolean csform_cs_level_1_checkbox_pressed = false;
    Boolean csform_cs_level_2_checkbox_pressed = false;
    Boolean csform_cs_level_3_checkbox_pressed = false;

    ImageButton csgeneralppehivisicon100x100;
    ImageButton csgeneralppehardhaticon100x100;
    ImageButton csgeneralppesafetybootsicon100x100;
    ImageButton csgeneralppeglovesicon100x100;
    ImageButton csgeneralppedustoverallicon100x100;
    ImageButton csgeneralppegooglesicon100x100;

    CheckBox csform_generalppehivisvest;
    CheckBox csform_generalppehardhat;
    CheckBox csform_generalppesafetyboots;
    CheckBox csform_generalppegloves;
    CheckBox csform_generalppeoveralls;
    CheckBox csform_generalppeglasses;

    CheckBox csform_cs_level_1_checkbox;
    CheckBox csform_cs_level_2_checkbox;
    CheckBox csform_cs_level_3_checkbox;

    CheckBox csform_cs_overalls_checkbox_yes;
    CheckBox csform_cs_overalls_checkbox_no;
    CheckBox csform_cs_gasmonitor_checkbox_yes;
    CheckBox csform_cs_gasmonitor_checkbox_no;
    CheckBox csform_cs_emergencycall_checkbox_yes;
    CheckBox csform_cs_emergencycall_checkbox_no;
    CheckBox csform_cs_firstaid_checkbox_yes;
    CheckBox csform_cs_firstaid_checkbox_no;
    CheckBox csform_cs_explosivelight_checkbox_yes;
    CheckBox csform_cs_explosivelight_checkbox_no;
    CheckBox csform_cs_safetysigns_checkbox_yes;
    CheckBox csform_cs_safetysigns_checkbox_no;
    CheckBox csform_cs_isolationsources_checkbox_yes;
    CheckBox csform_cs_isolationsources_checkbox_no;
    CheckBox csform_cs_lifejacket_checkbox_yes;
    CheckBox csform_cs_lifejacket_checkbox_no;
    CheckBox csform_cs_bumphat_checkbox_yes;
    CheckBox csform_cs_bumphat_checkbox_no;
    CheckBox csform_cs_escapeset_checkbox_yes;
    CheckBox csform_cs_escapeset_checkbox_no;
    CheckBox csform_cs_tripodharness_checkbox_yes;
    CheckBox csform_cs_tripodharness_checkbox_no;
    CheckBox csform_cs_communication_checkbox_yes;
    CheckBox csform_cs_communication_checkbox_no;
    CheckBox csform_cs_rescue_checkbox_yes;
    CheckBox csform_cs_rescue_checkbox_no;

    FrameLayout framelayout_cs_level_1;
    FrameLayout framelayout_cs_level_2;
    FrameLayout framelayout_cs_level_3;

    FrameLayout FrameLayout_Equipment_Requirement_CS1;
    FrameLayout FrameLayout_Equipment_Requirement_CS2;
    FrameLayout FrameLayout_Equipment_Requirement_CS3;

    FrameLayout Framelayout_Buttons;



    ///////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at__confined__space_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        time_stamp = (TextView) findViewById(R.id.time_stamp);

        userLocation = new UserLocation(this, this);

        Onlinetext = (TextView) findViewById(R.id.Onlinetext);
        GPSOnlinetext = (TextView) findViewById(R.id.GPSOnlinetext);
        onlineicon = (ImageView) findViewById(R.id.onlineicon);
        gpsonlineicon = (ImageView) findViewById(R.id.gpsonlineicon);

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            GPSOnlinetext.setText("GPS Online");
            gpsonlineicon.setImageResource(R.drawable.gpsonlineicon);
        }else{
            GPSOnlinetext.setText("GPS Offline");
            gpsonlineicon.setImageResource(R.drawable.gpsofflineicon);
            showGPSDisabledAlertToUser();

        }

        mStorage = FirebaseStorage.getInstance().getReference();

        mProgressDialog = new ProgressDialog(this);

        String date = getIntent().getStringExtra("Date");
        time_stamp.setText(getIntent().getStringExtra("Date"));

        position = getIntent().getIntExtra("Position", -1);

        cl = (CoordinatorLayout) findViewById(R.id.cdlayout);

        if (position != -1) {
            getSupportActionBar().setTitle("Edit Entry");
            searchAT_Confined_Space_model(position);
            AT_Confined_Space_model = new AT_Confined_Space_model();
        } else {
            getSupportActionBar().setTitle("Add Entry");
            AT_Confined_Space_model = null;
        }



        ///////////////////////////////////////////////////////////////////////////////////


        user_name = (TextView) findViewById(R.id.user_name);
        user_email = (TextView) findViewById(R.id.user_email);
        user_department_area = (TextView) findViewById(R.id.user_department_area);
        user_contact_number = (TextView) findViewById(R.id.user_contact_number);

        bOK = (Button) findViewById(R.id.bOK);
        bCancel = (Button) findViewById(R.id.bCancel);


        csgeneralppehivisicon100x100 = (ImageButton) findViewById(R.id.csgeneralppehivisicon100x100);
        csgeneralppehardhaticon100x100 = (ImageButton) findViewById(R.id.csgeneralppehardhaticon100x100);
        csgeneralppesafetybootsicon100x100 = (ImageButton) findViewById(R.id.raroadsicon100x100);
        csgeneralppeglovesicon100x100 = (ImageButton) findViewById(R.id.csgeneralppeglovesicon100x100);
        csgeneralppedustoverallicon100x100 = (ImageButton) findViewById(R.id.csgeneralppedustoverallicon100x100);
        csgeneralppegooglesicon100x100 = (ImageButton) findViewById(R.id.csgeneralppegooglesicon100x100);

        csform_generalppehivisvest = (CheckBox) findViewById(R.id.csform_generalppehivisvest);
        csform_generalppehardhat = (CheckBox) findViewById(R.id.csform_generalppehardhat);
        csform_generalppesafetyboots = (CheckBox) findViewById(R.id.csform_generalppesafetyboots);
        csform_generalppegloves = (CheckBox) findViewById(R.id.csform_generalppegloves);
        csform_generalppeoveralls = (CheckBox) findViewById(R.id.csform_generalppeoveralls);
        csform_generalppeglasses = (CheckBox) findViewById(R.id.csform_generalppeglasses);

        csform_cs_level_1_checkbox = (CheckBox) findViewById(R.id.csform_cs_level_1_checkbox);
        csform_cs_level_2_checkbox = (CheckBox) findViewById(R.id.csform_cs_level_2_checkbox);
        csform_cs_level_3_checkbox = (CheckBox) findViewById(R.id.csform_cs_level_3_checkbox);

        csform_cs_overalls_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_overalls_checkbox_yes);
        csform_cs_overalls_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_overalls_checkbox_no);
        csform_cs_gasmonitor_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_gasmonitor_checkbox_yes);
        csform_cs_gasmonitor_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_gasmonitor_checkbox_no);
        csform_cs_emergencycall_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_emergencycall_checkbox_yes);
        csform_cs_emergencycall_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_emergencycall_checkbox_no);
        csform_cs_firstaid_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_firstaid_checkbox_yes);
        csform_cs_firstaid_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_firstaid_checkbox_no);
        csform_cs_explosivelight_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_explosivelight_checkbox_yes);
        csform_cs_explosivelight_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_explosivelight_checkbox_no);
        csform_cs_safetysigns_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_safetysigns_checkbox_yes);
        csform_cs_safetysigns_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_safetysigns_checkbox_no);
        csform_cs_isolationsources_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_isolationsources_checkbox_yes);
        csform_cs_isolationsources_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_isolationsources_checkbox_no);
        csform_cs_lifejacket_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_lifejacket_checkbox_yes);
        csform_cs_lifejacket_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_lifejacket_checkbox_no);
        csform_cs_bumphat_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_bumphat_checkbox_yes);
        csform_cs_bumphat_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_bumphat_checkbox_no);
        csform_cs_escapeset_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_escapeset_checkbox_yes);
        csform_cs_escapeset_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_escapeset_checkbox_no);
        csform_cs_tripodharness_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_tripodharness_checkbox_yes);
        csform_cs_tripodharness_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_tripodharness_checkbox_no);
        csform_cs_communication_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_communication_checkbox_yes);
        csform_cs_communication_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_communication_checkbox_no);
        csform_cs_rescue_checkbox_yes = (CheckBox) findViewById(R.id.csform_cs_rescue_checkbox_yes);
        csform_cs_rescue_checkbox_no = (CheckBox) findViewById(R.id.csform_cs_rescue_checkbox_no);

        FrameLayout_Equipment_Requirement_CS1 = (FrameLayout) findViewById(R.id.FrameLayout_Equipment_Requirement_CS1);
        FrameLayout_Equipment_Requirement_CS2 = (FrameLayout) findViewById(R.id.FrameLayout_Equipment_Requirement_CS2);
        FrameLayout_Equipment_Requirement_CS3 = (FrameLayout) findViewById(R.id.FrameLayout_Equipment_Requirement_CS3);


        ///////////////////////////////////////////////////////////////////////////////////

        framelayout_cs_level_1 = (FrameLayout) findViewById(R.id.framelayout_cs_level_1);
        framelayout_cs_level_2 = (FrameLayout) findViewById(R.id.framelayout_cs_level_2);
        framelayout_cs_level_3 = (FrameLayout) findViewById(R.id.framelayout_cs_level_3);

        Framelayout_Buttons = (FrameLayout) findViewById(R.id.Framelayout_Buttons);

        ///////////////////////////////////////////////////////////////////////////////////

        FrameLayout_Equipment_Requirement_CS1.setVisibility(LinearLayout.GONE);
        FrameLayout_Equipment_Requirement_CS2.setVisibility(LinearLayout.GONE);
        FrameLayout_Equipment_Requirement_CS3.setVisibility(LinearLayout.GONE);

        Framelayout_Buttons.setVisibility(LinearLayout.GONE);

        ///////////////////////////////////////PPE/////////////////////////////////////////////////


        csform_generalppehivisvest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (csform_generalppehivisvest.isChecked()) {
                    csform_generalppehivisvest.setChecked(true);
                }
            }

        });

        csform_generalppehardhat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (csform_generalppehardhat.isChecked()) {
                    csform_generalppehardhat.setChecked(true);
                }
            }

        });

        csform_generalppesafetyboots.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (csform_generalppesafetyboots.isChecked()) {
                    csform_generalppesafetyboots.setChecked(true);
                }
            }

        });

        csform_generalppegloves.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (csform_generalppegloves.isChecked()) {
                    csform_generalppegloves.setChecked(true);
                }
            }

        });

        csform_generalppeoveralls.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (csform_generalppeoveralls.isChecked()) {
                    csform_generalppeoveralls.setChecked(true);
                }
            }

        });

        csform_generalppeglasses.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (csform_generalppeglasses.isChecked()) {
                    csform_generalppeglasses.setChecked(true);
                }
            }

        });

        ///////////////////////////////////////Confined Space Level/////////////////////////////////////////////////



        csform_cs_level_1_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_level_1_checkbox_pressed == false) {
                    FrameLayout_Equipment_Requirement_CS1.setVisibility(LinearLayout.VISIBLE);
                    FrameLayout_Equipment_Requirement_CS2.setVisibility(LinearLayout.GONE);
                    FrameLayout_Equipment_Requirement_CS3.setVisibility(LinearLayout.GONE);
                    framelayout_cs_level_2.setVisibility(LinearLayout.GONE);
                    framelayout_cs_level_3.setVisibility(LinearLayout.GONE);
                    Framelayout_Buttons.setVisibility(LinearLayout.VISIBLE);
                    csform_cs_level_1_checkbox_pressed ^= true;
                } else if
                        (csform_cs_level_1_checkbox_pressed == true) {
                    FrameLayout_Equipment_Requirement_CS1.setVisibility(LinearLayout.GONE);
                    FrameLayout_Equipment_Requirement_CS2.setVisibility(LinearLayout.GONE);
                    FrameLayout_Equipment_Requirement_CS3.setVisibility(LinearLayout.GONE);
                    framelayout_cs_level_2.setVisibility(LinearLayout.VISIBLE);
                    framelayout_cs_level_3.setVisibility(LinearLayout.VISIBLE);
                    Framelayout_Buttons.setVisibility(LinearLayout.GONE);
                    csform_cs_level_1_checkbox_pressed ^= true;
                }
            }

        });

        csform_cs_level_2_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_level_2_checkbox_pressed == false) {
                    FrameLayout_Equipment_Requirement_CS1.setVisibility(LinearLayout.VISIBLE);
                    FrameLayout_Equipment_Requirement_CS2.setVisibility(LinearLayout.VISIBLE);
                    FrameLayout_Equipment_Requirement_CS3.setVisibility(LinearLayout.GONE);
                    framelayout_cs_level_1.setVisibility(LinearLayout.GONE);
                    framelayout_cs_level_3.setVisibility(LinearLayout.GONE);
                    Framelayout_Buttons.setVisibility(LinearLayout.VISIBLE);
                    csform_cs_level_2_checkbox_pressed ^= true;
                } else if
                        (csform_cs_level_2_checkbox_pressed == true) {

                    FrameLayout_Equipment_Requirement_CS1.setVisibility(LinearLayout.GONE);
                    FrameLayout_Equipment_Requirement_CS2.setVisibility(LinearLayout.GONE);
                    FrameLayout_Equipment_Requirement_CS3.setVisibility(LinearLayout.GONE);
                    framelayout_cs_level_1.setVisibility(LinearLayout.VISIBLE);
                    framelayout_cs_level_3.setVisibility(LinearLayout.VISIBLE);
                    Framelayout_Buttons.setVisibility(LinearLayout.GONE);
                    csform_cs_level_2_checkbox_pressed ^= true;
                }
            }

        });

        csform_cs_level_3_checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_level_3_checkbox_pressed == false) {
                    FrameLayout_Equipment_Requirement_CS1.setVisibility(LinearLayout.VISIBLE);
                    FrameLayout_Equipment_Requirement_CS2.setVisibility(LinearLayout.VISIBLE);
                    FrameLayout_Equipment_Requirement_CS3.setVisibility(LinearLayout.VISIBLE);
                    framelayout_cs_level_1.setVisibility(LinearLayout.GONE);
                    framelayout_cs_level_2.setVisibility(LinearLayout.GONE);
                    Framelayout_Buttons.setVisibility(LinearLayout.VISIBLE);
                    csform_cs_level_3_checkbox_pressed ^= true;
                } else if
                        (csform_cs_level_3_checkbox_pressed == true) {
                    FrameLayout_Equipment_Requirement_CS1.setVisibility(LinearLayout.GONE);
                    FrameLayout_Equipment_Requirement_CS2.setVisibility(LinearLayout.GONE);
                    FrameLayout_Equipment_Requirement_CS3.setVisibility(LinearLayout.GONE);
                    framelayout_cs_level_1.setVisibility(LinearLayout.VISIBLE);
                    framelayout_cs_level_2.setVisibility(LinearLayout.VISIBLE);
                    Framelayout_Buttons.setVisibility(LinearLayout.GONE);
                    csform_cs_level_3_checkbox_pressed ^= true;
                }
            }

        });



        ///////////////////////////////////////Confined Space Level/////////////////////////////////////////////////


        csform_cs_overalls_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_overalls_checkbox_yes.isChecked()) {
                    csform_cs_overalls_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_overalls_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_overalls_checkbox_no.isChecked()) {
                    csform_cs_overalls_checkbox_yes.setChecked(false);}
            }
        });

        csform_cs_gasmonitor_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_gasmonitor_checkbox_yes.isChecked()) {
                    csform_cs_gasmonitor_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_gasmonitor_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_gasmonitor_checkbox_no.isChecked()) {
                    csform_cs_gasmonitor_checkbox_yes.setChecked(false);}
            }
        });

        csform_cs_emergencycall_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_emergencycall_checkbox_yes.isChecked()) {
                    csform_cs_emergencycall_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_emergencycall_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_emergencycall_checkbox_no.isChecked()) {
                    csform_cs_emergencycall_checkbox_yes.setChecked(false);}
            }
        });

        csform_cs_firstaid_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_firstaid_checkbox_yes.isChecked()) {
                    csform_cs_firstaid_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_firstaid_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_firstaid_checkbox_no.isChecked()) {
                    csform_cs_firstaid_checkbox_yes.setChecked(false);}
            }
        });

        csform_cs_explosivelight_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_explosivelight_checkbox_yes.isChecked()) {
                    csform_cs_explosivelight_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_explosivelight_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_explosivelight_checkbox_no.isChecked()) {
                    csform_cs_explosivelight_checkbox_yes.setChecked(false);}
            }
        });

        csform_cs_safetysigns_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_safetysigns_checkbox_yes.isChecked()) {
                    csform_cs_explosivelight_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_explosivelight_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_explosivelight_checkbox_no.isChecked()) {
                    csform_cs_safetysigns_checkbox_yes.setChecked(false);}
            }
        });

        csform_cs_isolationsources_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_isolationsources_checkbox_yes.isChecked()) {
                    csform_cs_isolationsources_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_isolationsources_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_isolationsources_checkbox_no.isChecked()) {
                    csform_cs_isolationsources_checkbox_yes.setChecked(false);}
            }
        });

        csform_cs_lifejacket_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_lifejacket_checkbox_yes.isChecked()) {
                    csform_cs_lifejacket_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_lifejacket_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_lifejacket_checkbox_no.isChecked()) {
                    csform_cs_lifejacket_checkbox_yes.setChecked(false);}
            }
        });

        csform_cs_bumphat_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_bumphat_checkbox_yes.isChecked()) {
                    csform_cs_bumphat_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_bumphat_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_bumphat_checkbox_no.isChecked()) {
                    csform_cs_bumphat_checkbox_yes.setChecked(false);}
            }
        });

        csform_cs_escapeset_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_escapeset_checkbox_yes.isChecked()) {
                    csform_cs_escapeset_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_escapeset_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_escapeset_checkbox_no.isChecked()) {
                    csform_cs_escapeset_checkbox_yes.setChecked(false);}
            }
        });

        csform_cs_tripodharness_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_tripodharness_checkbox_yes.isChecked()) {
                    csform_cs_tripodharness_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_tripodharness_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_tripodharness_checkbox_no.isChecked()) {
                    csform_cs_tripodharness_checkbox_yes.setChecked(false);}
            }
        });

        csform_cs_communication_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_communication_checkbox_yes.isChecked()) {
                    csform_cs_communication_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_communication_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_communication_checkbox_no.isChecked()) {
                    csform_cs_communication_checkbox_yes.setChecked(false);}
            }
        });
        csform_cs_rescue_checkbox_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_rescue_checkbox_yes.isChecked()) {
                    csform_cs_rescue_checkbox_no.setChecked(false);}
            }
        });
        csform_cs_rescue_checkbox_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csform_cs_rescue_checkbox_no.isChecked()) {
                    csform_cs_rescue_checkbox_yes.setChecked(false);}
            }
        });

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user_name.getText().toString().trim().equals("") ||
                        user_email.getText().toString().trim().equals("") ||
                        user_department_area.getText().toString().trim().equals("") ||
                        user_contact_number.getText().toString().trim().equals("")) {

                    final Snackbar snackBar = Snackbar.make(cl, "Please enter all the fields.", Snackbar.LENGTH_LONG);
                    snackBar.setAction("CLOSE", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            snackBar.dismiss();
                        }
                    });
                    snackBar.show();

                } else {
                    AT_Confined_Space_model p = new AT_Confined_Space_model();
                    p.setstartDate(getIntent().getStringExtra("Date"));
                    p.setuser_email(user_email.getText().toString());
                    p.setuser_name(user_name.getText().toString());
                    p.setuser_department_area(user_department_area.getText().toString());
                    p.setuser_contact_number(user_contact_number.getText().toString());




                    ///////////////////////////////////////1 Section 1 Location/////////////////////////////////////////////////


                    if(csform_generalppehivisvest.isChecked()) {
                        p.setcsform_generalppehivisvest("Yes");
                    }
                    else {
                        p.setcsform_generalppehivisvest("No");
                    }


                    if(csform_generalppehardhat.isChecked()) {
                        p.setcsform_generalppehardhat("Yes");
                    }
                    else {
                        p.setcsform_generalppehardhat("No");
                    }

                    if(csform_generalppesafetyboots.isChecked()) {
                        p.setcsform_generalppesafetyboots("Yes");
                    }
                    else {
                        p.setcsform_generalppesafetyboots("No");
                    }

                    if(csform_generalppegloves.isChecked()) {
                        p.setcsform_generalppegloves("Yes");
                    }
                    else {
                        p.setcsform_generalppegloves("No");
                    }

                    if(csform_generalppeoveralls.isChecked()) {
                        p.setcsform_generalppeoveralls("Yes");
                    }
                    else {
                        p.setcsform_generalppeoveralls("No");
                    }

                    if(csform_generalppeglasses.isChecked()) {
                        p.setcsform_generalppeglasses("Yes");
                    }
                    else {
                        p.setcsform_generalppeglasses("No");
                    }

                    ///////////////////////////////////////Confined Space Level/////////////////////////////////////////////////

                    if(csform_cs_level_1_checkbox.isChecked()) {
                        p.setcsform_cs_level_1("Yes");
                    }
                    else {
                        p.setcsform_cs_level_1("No");
                    }

                    if(csform_cs_level_2_checkbox.isChecked()) {
                        p.setcsform_cs_level_2("Yes");
                    }
                    else {
                        p.setcsform_cs_level_2("No");
                    }

                    if(csform_cs_level_3_checkbox.isChecked()) {
                        p.setcsform_cs_level_3("Yes");
                    }
                    else {
                        p.setcsform_cs_level_3("No");
                    }

                    ///////////////////////////////////////Confined Space Level/////////////////////////////////////////////////

                    if(csform_cs_overalls_checkbox_yes.isChecked()) {
                        p.setcs_overalls("Yes");
                    } else if(csform_cs_overalls_checkbox_no.isChecked()) {
                        p.setcs_overalls("No");
                    } else { p.setcs_overalls("N/A");}

                    if(csform_cs_gasmonitor_checkbox_yes.isChecked()) {
                        p.setcs_gasmonitor("Yes");
                    } else if(csform_cs_gasmonitor_checkbox_no.isChecked()) {
                        p.setcs_gasmonitor("No");
                    } else { p.setcs_gasmonitor("N/A");}

                    if(csform_cs_emergencycall_checkbox_yes.isChecked()) {
                        p.setcs_emergencycall("Yes");
                    } else if(csform_cs_emergencycall_checkbox_no.isChecked()) {
                        p.setcs_emergencycall("No");
                    } else { p.setcs_emergencycall("N/A");}

                    if(csform_cs_firstaid_checkbox_yes.isChecked()) {
                        p.setcs_firstaid("Yes");
                    } else if(csform_cs_firstaid_checkbox_no.isChecked()) {
                        p.setcs_firstaid("No");
                    } else { p.setcs_firstaid("N/A");}

                    if(csform_cs_explosivelight_checkbox_yes.isChecked()) {
                        p.setcs_explosivelight("Yes");
                    } else if(csform_cs_explosivelight_checkbox_no.isChecked()) {
                        p.setcs_explosivelight("No");
                    } else { p.setcs_explosivelight("N/A");}

                    if(csform_cs_safetysigns_checkbox_yes.isChecked()) {
                        p.setcs_safetysigns("Yes");
                    } else if(csform_cs_safetysigns_checkbox_no.isChecked()) {
                        p.setcs_safetysigns("No");
                    } else { p.setcs_safetysigns("N/A");}

                    if(csform_cs_isolationsources_checkbox_yes.isChecked()) {
                        p.setcs_isolationsources("Yes");
                    } else if(csform_cs_isolationsources_checkbox_no.isChecked()) {
                        p.setcs_isolationsources("No");
                    } else { p.setcs_isolationsources("N/A");}

                    if(csform_cs_lifejacket_checkbox_yes.isChecked()) {
                        p.setcs_lifejacket("Yes");
                    } else if(csform_cs_lifejacket_checkbox_no.isChecked()) {
                        p.setcs_lifejacket("No");
                    } else { p.setcs_lifejacket("N/A");}

                    if(csform_cs_bumphat_checkbox_yes.isChecked()) {
                        p.setcs_bumphat("Yes");
                    } else if(csform_cs_bumphat_checkbox_no.isChecked()) {
                        p.setcs_bumphat("No");
                    } else { p.setcs_bumphat("N/A");}

                    if(csform_cs_escapeset_checkbox_yes.isChecked()) {
                        p.setcs_escapeset("Yes");
                    } else if(csform_cs_escapeset_checkbox_no.isChecked()) {
                        p.setcs_escapeset("No");
                    } else { p.setcs_escapeset("N/A");}

                    if(csform_cs_tripodharness_checkbox_yes.isChecked()) {
                        p.setcs_tripodharness("Yes");
                    } else if(csform_cs_tripodharness_checkbox_no.isChecked()) {
                        p.setcs_tripodharness("No");
                    } else { p.setcs_tripodharness("N/A");}

                    if(csform_cs_communication_checkbox_yes.isChecked()) {
                        p.setcs_communication("Yes");
                    } else if(csform_cs_communication_checkbox_no.isChecked()) {
                        p.setcs_communication("No");
                    } else { p.setcs_communication("N/A");}

                    if(csform_cs_rescue_checkbox_yes.isChecked()) {
                        p.setcs_rescue("Yes");
                    } else if(csform_cs_rescue_checkbox_no.isChecked()) {
                        p.setcs_rescue("No");
                    } else { p.setcs_rescue("N/A");}

                    p.setlocationlat(Double.toString(Locationlat));
                    p.setlocationlong(Double.toString(Locationlong));







                    if (AT_Confined_Space_model == null)
                        AT_Confined_Space_database.getInstance().addAT_Confined_Space_model(p);
                    startActivity (new Intent(AT_Confined_Space_view.this, MainActivity.class));
                }
            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Firebase.setAndroidContext(this);
        Firebase mRootRef = new Firebase("https://kcc-app-c2be0.firebaseio.com/");
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                String userName = dataSnapshot.child("User Name").getValue(String.class);
                String userEmail = dataSnapshot.child("User Email").getValue(String.class);
                String userDepartment_area = dataSnapshot.child("User Company").getValue(String.class);
                String userContactNumber = dataSnapshot.child("User Contact Number").getValue(String.class);

                user_name.setText(userName);
                user_email.setText(userEmail);
                user_department_area.setText(userDepartment_area);
                user_contact_number.setText(userContactNumber);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        internet_connected = Online_check ();

        if (internet_connected == false) {
            Onlinetext.setText("Offline");
            onlineicon.setImageResource(R.drawable.offlineicon);
        }
        else {
            Onlinetext.setText("Online");
            onlineicon.setImageResource(R.drawable.onlineicon);
        }
    }
    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        alertDialogBuilder.setMessage("Would you like to turn on, Location Services?")
                .setCancelable(false)
                .setPositiveButton("Goto Settings Page To Enable Location Services",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                                GPSOnlinetext.setText("GPS Online");
                                gpsonlineicon.setImageResource(R.drawable.gpsonlineicon);

                            }
                        });

        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();


    }
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public void searchAT_Confined_Space_model(int position) {
        String clickedKey = AT_Confined_Space_database.getInstance().getKeysArray().get(position);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        AT_Confined_Space_database.getInstance().getmDatabase().child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Confined Space Form").child(clickedKey).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        AT_Confined_Space_model AT_Confined_Space_model = dataSnapshot.getValue(AT_Confined_Space_model.class);
                        user_name.setText(AT_Confined_Space_model.getuser_name());
                        user_email.setText(AT_Confined_Space_model.getuser_email());
                        user_department_area.setText(AT_Confined_Space_model.getuser_department_area());
                        user_contact_number.setText(AT_Confined_Space_model.getuser_contact_number());

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }

    public void handleNewLocation(Location location) {

        System.out.println(location);

        Locationlat = location.getLatitude();
        Locationlong = location.getLongitude();

    }

}
