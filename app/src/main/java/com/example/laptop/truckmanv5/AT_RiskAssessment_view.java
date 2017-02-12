package com.example.laptop.truckmanv5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
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

public class AT_RiskAssessment_view extends AppCompatActivity {

    TextView user_name,user_email,user_department_area,user_contact_number,time_stamp;


    CoordinatorLayout cl;
    Button bOK,bCancel;
    int position;
    AT_RiskAssessment_model AT_RiskAssessment_model;


    private ProgressDialog mProgressDialog;

    private StorageReference mStorage;

    ///////////////////////////////////////////////////////////////////////////////////

    Boolean ratrafficicon100x100pressed = false;
    Boolean raworkingatheightsicon100x100pressed = false;
    Boolean rarivercleaningicon100x100pressed = false;

    Boolean rapowerlinesicon100x100pressed = false;
    Boolean raoverheadpowerlinesicon100x100pressed = false;


    ImageButton ratrafficicon100x100;
    ImageButton rappeicon100x100;
    ImageButton raroadsicon100x100;
    ImageButton rafootpathicon100x100;
    ImageButton rarivercleaningicon100x100;

    ImageButton raworkingatheightsicon100x100;
    ImageButton rapowerlinesicon100x100;
    ImageButton raoverheadpowerlinesicon100x100;
    ImageButton raoverheadpowerlinesalerticon100x100;
    ImageButton ramanhandleicon100x100;
    ImageButton raconspaceicon100x100;
    ImageButton rapowertoolsicon100x100;
    ImageButton rageneralppeicon100x100;

    ImageButton rariverlifejacketicon100x100;
    ImageButton rariverwadersicon100x100;
    ImageButton rarivertieoffpointicon100x100;
    ImageButton rariversafeaccessicon100x100;

    ///////////////////////////////////////////////////////////////////////////////////

    CheckBox raform_trafficppe_yes;
    CheckBox raform_trafficppe_no;
    CheckBox raform_trafficroads;
    CheckBox raform_trafficfootpath;
    CheckBox raform_traffictmpguidelines_yes;
    CheckBox raform_traffictmpguidelines_no;
    CheckBox raform_trafficbeacon_yes;
    CheckBox raform_trafficbeacon_no;
    CheckBox raform_trafficleftsite_yes;
    CheckBox raform_trafficleftsite_no;

    CheckBox raform_trafficfallsystem_yes;
    CheckBox raform_trafficfallsystem_no;
    CheckBox raform_heights_harnessinspect_yes;
    CheckBox raform_heights_harnessinspect_no;
    CheckBox raform_heights_ladderinspect_yes;
    CheckBox raform_heights_ladderinspect_no;
    CheckBox raform_heights_laddertie_yes;
    CheckBox raform_heights_laddertie_no;
    CheckBox raform_heights_manholebarriier_yes;
    CheckBox raform_heights_manholebarriier_no;

    CheckBox raform_riverlifejacket_yes;
    CheckBox raform_riverlifejacket_no;
    CheckBox raform_riverwaders_yes;
    CheckBox raform_riverwaders_no;
    CheckBox raform_rivertieoffpoint_yes;
    CheckBox raform_rivertieoffpoint_no;
    CheckBox raform_riversafeaccess_yes;
    CheckBox raform_riversafeaccess_no;

    CheckBox raform_overheadpowerlines_yes;
    CheckBox raform_overheadpowerlines_no;

    ///////////////////////////////////////////////////////////////////////////////////

    String traffic_ppe;
    String traffic_roads_or_footpath;
    String traffic_following_guidelines;
    String traffic_beacons;
    String traffic_left_site_in_good_order;

    String heights_fall_arrest_system;
    String heights_harness_inspection;
    String heights_ladder_inspection;
    String heights_laddertied;
    String heights_manholebarrier;

    String riverlifejacket;
    String riverwaders;
    String rivertieoffpoint;
    String riversafeaccess;

    String overheadpowerlines;

    ///////////////////////////////////////////////////////////////////////////////////

    FrameLayout framelayout_traffic;
    FrameLayout framelayout_workingatheights;
    FrameLayout framelayout_rivercleaning;

    FrameLayout framelayout_overheadpowerlines;
    FrameLayout framelayout_overheadpowerlinesalert;

    ///////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at__risk_assessment_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        time_stamp = (TextView) findViewById(R.id.time_stamp);

        ///////////////////////////////////////////////////////////////////////////////////

        ratrafficicon100x100 = (ImageButton) findViewById(R.id.ratrafficicon100x100);
        rappeicon100x100 = (ImageButton) findViewById(R.id.rappeicon100x100);
        raroadsicon100x100 = (ImageButton) findViewById(R.id.raroadsicon100x100);
        rafootpathicon100x100 = (ImageButton) findViewById(R.id.rafootpathicon100x100);
        rarivercleaningicon100x100 = (ImageButton) findViewById(R.id.rarivercleaningicon100x100);
        ramanhandleicon100x100 = (ImageButton) findViewById(R.id.ramanhandleicon100x100);
        raconspaceicon100x100 = (ImageButton) findViewById(R.id.raconspaceicon100x100);
        rapowertoolsicon100x100 = (ImageButton) findViewById(R.id.rapowertoolsicon100x100);
        rageneralppeicon100x100 = (ImageButton) findViewById(R.id.rageneralppeicon100x100);
        raworkingatheightsicon100x100 = (ImageButton) findViewById(R.id.raworkingatheightsicon100x100);


        rapowerlinesicon100x100 = (ImageButton) findViewById(R.id.rapowerlinesicon100x100);
        raoverheadpowerlinesicon100x100 = (ImageButton) findViewById(R.id.raoverheadpowerlinesicon100x100);
        raoverheadpowerlinesalerticon100x100 = (ImageButton) findViewById(R.id.raoverheadpowerlinesalerticon100x100);

        rariverlifejacketicon100x100 = (ImageButton) findViewById(R.id.rariverlifejacketicon100x100);
        rariverwadersicon100x100 = (ImageButton) findViewById(R.id.rariverwadersicon100x100);
        rarivertieoffpointicon100x100 = (ImageButton) findViewById(R.id.rarivertieoffpointicon100x100);
        rariversafeaccessicon100x100 = (ImageButton) findViewById(R.id.rariversafeaccessicon100x100);

        ///////////////////////////////////////////////////////////////////////////////////

        raform_trafficppe_yes = (CheckBox) findViewById(R.id.raform_trafficppe_yes);
        raform_trafficppe_no = (CheckBox) findViewById(R.id.raform_trafficppe_no);
        raform_trafficroads = (CheckBox) findViewById(R.id.raform_trafficroads);
        raform_trafficfootpath = (CheckBox) findViewById(R.id.raform_trafficfootpath);
        raform_traffictmpguidelines_yes = (CheckBox) findViewById(R.id.raform_traffictmpguidelines_yes);
        raform_traffictmpguidelines_no = (CheckBox) findViewById(R.id.raform_traffictmpguidelines_no);
        raform_trafficbeacon_yes = (CheckBox) findViewById(R.id.raform_trafficbeacon_yes);
        raform_trafficbeacon_no = (CheckBox) findViewById(R.id.raform_trafficbeacon_no);
        raform_trafficleftsite_yes = (CheckBox) findViewById(R.id.raform_trafficleftsite_yes);
        raform_trafficleftsite_no = (CheckBox) findViewById(R.id.raform_trafficleftsite_no);

        raform_trafficfallsystem_yes = (CheckBox) findViewById(R.id.raform_trafficfallsystem_yes);
        raform_trafficfallsystem_no = (CheckBox) findViewById(R.id.raform_trafficfallsystem_no);
        raform_heights_harnessinspect_yes = (CheckBox) findViewById(R.id.raform_heights_harnessinspect_yes);
        raform_heights_harnessinspect_no = (CheckBox) findViewById(R.id.raform_heights_harnessinspect_no);
        raform_heights_ladderinspect_yes = (CheckBox) findViewById(R.id.raform_heights_ladderinspect_yes);
        raform_heights_ladderinspect_no = (CheckBox) findViewById(R.id.raform_heights_ladderinspect_no);
        raform_heights_laddertie_yes = (CheckBox) findViewById(R.id.raform_heights_laddertie_yes);
        raform_heights_laddertie_no = (CheckBox) findViewById(R.id.raform_heights_laddertie_no);
        raform_heights_manholebarriier_yes = (CheckBox) findViewById(R.id.raform_heights_manholebarriier_yes);
        raform_heights_manholebarriier_no = (CheckBox) findViewById(R.id.raform_heights_manholebarriier_no);

        raform_riverlifejacket_yes = (CheckBox) findViewById(R.id.raform_riverlifejacket_yes);
        raform_riverlifejacket_no = (CheckBox) findViewById(R.id.raform_riverlifejacket_no);
        raform_riverwaders_yes = (CheckBox) findViewById(R.id.raform_riverwaders_yes);
        raform_riverwaders_no = (CheckBox) findViewById(R.id.raform_riverwaders_no);
        raform_rivertieoffpoint_yes = (CheckBox) findViewById(R.id.raform_rivertieoffpoint_yes);
        raform_rivertieoffpoint_no = (CheckBox) findViewById(R.id.raform_rivertieoffpoint_no);
        raform_riversafeaccess_yes = (CheckBox) findViewById(R.id.raform_riversafeaccess_yes);
        raform_riversafeaccess_no = (CheckBox) findViewById(R.id.raform_riversafeaccess_no);

        raform_overheadpowerlines_yes = (CheckBox) findViewById(R.id.raform_overheadpowerlines_yes);
        raform_overheadpowerlines_no = (CheckBox) findViewById(R.id.raform_overheadpowerlines_no);


        framelayout_traffic = (FrameLayout) findViewById(R.id.framelayout_traffic);
        framelayout_workingatheights = (FrameLayout) findViewById(R.id.framelayout_workingatheights);
        framelayout_rivercleaning = (FrameLayout) findViewById(R.id.framelayout_rivercleaning);
        framelayout_overheadpowerlines = (FrameLayout) findViewById(R.id.framelayout_overheadpowerlines);
        framelayout_overheadpowerlinesalert = (FrameLayout) findViewById(R.id.framelayout_overheadpowerlinesalert);

        ///////////////////////////////////////////////////////////////////////////////////

        framelayout_traffic.setVisibility(LinearLayout.GONE);
        rafootpathicon100x100.setVisibility(LinearLayout.GONE);
        framelayout_rivercleaning.setVisibility(LinearLayout.GONE);
        framelayout_overheadpowerlines.setVisibility(LinearLayout.GONE);
        framelayout_overheadpowerlinesalert.setVisibility(LinearLayout.GONE);

        if (ratrafficicon100x100pressed == false) {
            framelayout_traffic.setVisibility(LinearLayout.GONE);
        }
        if (ratrafficicon100x100pressed == true) {
            framelayout_traffic.setVisibility(LinearLayout.VISIBLE);
        }

        if (raworkingatheightsicon100x100pressed == false) {
            framelayout_workingatheights.setVisibility(LinearLayout.GONE);
        }
        if (raworkingatheightsicon100x100pressed == true) {
            framelayout_workingatheights.setVisibility(LinearLayout.VISIBLE);
        }

        if (rarivercleaningicon100x100pressed == false) {
            framelayout_rivercleaning.setVisibility(LinearLayout.GONE);
        }
        if (rarivercleaningicon100x100pressed == true) {
            framelayout_rivercleaning.setVisibility(LinearLayout.VISIBLE);
        }

        if (rapowerlinesicon100x100pressed == false) {
            framelayout_overheadpowerlines.setVisibility(LinearLayout.GONE);
        }
        if (rapowerlinesicon100x100pressed == true) {
            framelayout_overheadpowerlines.setVisibility(LinearLayout.VISIBLE);
        }

        ratrafficicon100x100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ratrafficicon100x100pressed == false) {
                    framelayout_traffic.setVisibility(LinearLayout.VISIBLE);
                    ratrafficicon100x100pressed ^= true;
                } else if
                    (ratrafficicon100x100pressed == true) {
                        framelayout_traffic.setVisibility(LinearLayout.GONE);
                        ratrafficicon100x100pressed ^= true;
                    }
                }

        });

        raworkingatheightsicon100x100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raworkingatheightsicon100x100pressed == false) {
                    framelayout_workingatheights.setVisibility(LinearLayout.VISIBLE);
                    raworkingatheightsicon100x100pressed ^= true;
                } else if
                        (raworkingatheightsicon100x100pressed == true) {
                    framelayout_workingatheights.setVisibility(LinearLayout.GONE);
                    raworkingatheightsicon100x100pressed ^= true;
                }
            }

        });

        rarivercleaningicon100x100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rarivercleaningicon100x100pressed == false) {
                    framelayout_rivercleaning.setVisibility(LinearLayout.VISIBLE);
                    rarivercleaningicon100x100pressed ^= true;
                } else if
                        (rarivercleaningicon100x100pressed == true) {
                    framelayout_rivercleaning.setVisibility(LinearLayout.GONE);
                    rarivercleaningicon100x100pressed ^= true;
                }
            }

        });

        rapowerlinesicon100x100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rapowerlinesicon100x100pressed == false) {
                    framelayout_overheadpowerlines.setVisibility(LinearLayout.VISIBLE);
                    rapowerlinesicon100x100pressed ^= true;
                } else if
                        (rapowerlinesicon100x100pressed == true) {
                    framelayout_overheadpowerlines.setVisibility(LinearLayout.GONE);
                    rapowerlinesicon100x100pressed ^= true;
                }
            }

        });

        ///////////////////////////////////////////////////////////////////////////////////


        mStorage = FirebaseStorage.getInstance().getReference();

        mProgressDialog = new ProgressDialog(this);

        String date = getIntent().getStringExtra("Date");
        time_stamp.setText(getIntent().getStringExtra("Date"));

        position = getIntent().getIntExtra("Position", -1);

        cl = (CoordinatorLayout) findViewById(R.id.cdlayout);

        user_name = (TextView) findViewById(R.id.user_name);
        user_email = (TextView) findViewById(R.id.user_email);
        user_department_area = (TextView) findViewById(R.id.user_department_area);
        user_contact_number = (TextView) findViewById(R.id.user_contact_number);

        bOK = (Button) findViewById(R.id.bOK);
        bCancel = (Button) findViewById(R.id.bCancel);

        if (position != -1) {
            getSupportActionBar().setTitle("Edit Entry");
            searchAT_RiskAssessment_model(position);
            AT_RiskAssessment_model = new AT_RiskAssessment_model();
        } else {
            getSupportActionBar().setTitle("Add Entry");
            AT_RiskAssessment_model = null;
        }

        ///////////////////////////////////////1 Traffic/////////////////////////////////////////////////

        raform_trafficppe_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_trafficppe_yes.isChecked()) {
                    traffic_ppe = "Yes";
                    raform_trafficppe_yes.setChecked(true);
                    raform_trafficppe_no.setChecked(false);
                } else { traffic_ppe = "No";
                    raform_trafficppe_yes.setChecked(true);
                }
            }

        });
        raform_trafficppe_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_trafficppe_no.isChecked()) {
                    raform_trafficppe_no.setChecked(true);
                    raform_trafficppe_yes.setChecked(false);
                }
            }

        });

        raform_trafficroads.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_trafficroads.isChecked()) {
                    traffic_roads_or_footpath = "Roads";
                    raform_trafficroads.setChecked(true);
                    raform_trafficfootpath.setChecked(false);
                    raroadsicon100x100.setVisibility(LinearLayout.VISIBLE);
                    rafootpathicon100x100.setVisibility(LinearLayout.GONE);
                } else { traffic_roads_or_footpath = "Footpath";
                    raform_trafficroads.setChecked(true);
                }
            }

        });

        raform_trafficfootpath.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_trafficfootpath.isChecked()) {
                    raform_trafficfootpath.setChecked(true);
                    raform_trafficroads.setChecked(false);
                    raroadsicon100x100.setVisibility(LinearLayout.GONE);
                    rafootpathicon100x100.setVisibility(LinearLayout.VISIBLE);
                }
            }

        });

        raform_traffictmpguidelines_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_traffictmpguidelines_yes.isChecked()) {
                    traffic_following_guidelines = "Yes";
                    raform_traffictmpguidelines_yes.setChecked(true);
                    raform_traffictmpguidelines_no.setChecked(false);
                }else { traffic_following_guidelines = "No";
                    raform_traffictmpguidelines_yes.setChecked(true);
                }
            }

        });

        raform_traffictmpguidelines_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_traffictmpguidelines_no.isChecked()) {
                    raform_traffictmpguidelines_no.setChecked(true);
                    raform_traffictmpguidelines_yes.setChecked(false);
                }
            }

        });

        raform_trafficbeacon_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_trafficbeacon_yes.isChecked()) {
                    traffic_beacons = "Yes";
                    raform_trafficbeacon_yes.setChecked(true);
                    raform_trafficbeacon_no.setChecked(false);
                }
                else { traffic_beacons = "No";
                    raform_trafficbeacon_yes.setChecked(true);
                }
            }

        });

        raform_trafficbeacon_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_trafficbeacon_no.isChecked()) {
                    raform_trafficbeacon_no.setChecked(true);
                    raform_trafficbeacon_yes.setChecked(false);
                }
            }

        });

        raform_trafficleftsite_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_trafficleftsite_yes.isChecked()) {
                    traffic_left_site_in_good_order = "Yes";
                    raform_trafficleftsite_yes.setChecked(true);
                    raform_trafficleftsite_no.setChecked(false);
                }else { traffic_left_site_in_good_order = "No";
                    raform_trafficleftsite_yes.setChecked(true);
                }
            }

        });

        raform_trafficleftsite_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_trafficleftsite_no.isChecked()) {
                    raform_trafficleftsite_no.setChecked(true);
                    raform_trafficleftsite_yes.setChecked(false);
                }
            }

        });

        ///////////////////////////////////////2 Heights/////////////////////////////////////////////////



        raform_trafficfallsystem_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_trafficfallsystem_yes.isChecked()) {
                    heights_fall_arrest_system = "Yes";
                    raform_trafficfallsystem_yes.setChecked(true);
                    raform_trafficfallsystem_no.setChecked(false);
                }else { heights_fall_arrest_system = "No";
                    raform_trafficfallsystem_yes.setChecked(true);
                }
            }

        });

        raform_trafficfallsystem_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_trafficfallsystem_no.isChecked()) {
                    raform_trafficfallsystem_no.setChecked(true);
                    raform_trafficfallsystem_yes.setChecked(false);
                }
            }

        });

        raform_heights_harnessinspect_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_heights_harnessinspect_yes.isChecked()) {
                    heights_harness_inspection = "Yes";
                    raform_heights_harnessinspect_yes.setChecked(true);
                    raform_heights_harnessinspect_no.setChecked(false);
                }else { heights_harness_inspection = "No";
                    raform_heights_harnessinspect_yes.setChecked(true);
                }
            }

        });

        raform_heights_harnessinspect_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_heights_harnessinspect_no.isChecked()) {
                    raform_heights_harnessinspect_no.setChecked(true);
                    raform_heights_harnessinspect_yes.setChecked(false);
                }
            }

        });

        raform_heights_ladderinspect_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_heights_ladderinspect_yes.isChecked()) {
                    heights_ladder_inspection = "Yes";
                    raform_heights_ladderinspect_yes.setChecked(true);
                    raform_heights_ladderinspect_no.setChecked(false);
                }else { heights_ladder_inspection = "No";
                    raform_heights_ladderinspect_yes.setChecked(true);
                }
            }

        });

        raform_heights_ladderinspect_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_heights_ladderinspect_no.isChecked()) {
                    raform_heights_ladderinspect_no.setChecked(true);
                    raform_heights_ladderinspect_yes.setChecked(false);
                }
            }

        });
        raform_heights_laddertie_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_heights_laddertie_yes.isChecked()) {
                    heights_laddertied = "Yes";
                    raform_heights_laddertie_yes.setChecked(true);
                    raform_heights_laddertie_no.setChecked(false);
                }else { heights_laddertied = "No";
                    raform_heights_laddertie_yes.setChecked(true);
                }
            }

        });

        raform_heights_laddertie_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_heights_laddertie_no.isChecked()) {
                    raform_heights_laddertie_no.setChecked(true);
                    raform_heights_laddertie_yes.setChecked(false);
                }
            }

        });
        raform_heights_manholebarriier_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_heights_manholebarriier_yes.isChecked()) {
                    heights_manholebarrier = "Yes";
                    raform_heights_manholebarriier_yes.setChecked(true);
                    raform_heights_manholebarriier_no.setChecked(false);
                }else { heights_manholebarrier = "No";
                    raform_heights_manholebarriier_yes.setChecked(true);
                }
            }

        });

        raform_heights_manholebarriier_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_heights_manholebarriier_no.isChecked()) {
                    raform_heights_manholebarriier_no.setChecked(true);
                    raform_heights_manholebarriier_yes.setChecked(false);
                }
            }

        });

        ///////////////////////////////////////3 River Cleaning/////////////////////////////////////////////////

        raform_riverlifejacket_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_riverlifejacket_yes.isChecked()) {
                    riverlifejacket = "Yes";
                    raform_riverlifejacket_yes.setChecked(true);
                    raform_riverlifejacket_no.setChecked(false);
                }else { riverlifejacket = "No";
                    raform_riverlifejacket_yes.setChecked(true);
                }
            }

        });

        raform_riverlifejacket_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_riverlifejacket_no.isChecked()) {
                    raform_riverlifejacket_no.setChecked(true);
                    raform_riverlifejacket_yes.setChecked(false);
                }
            }

        });

        raform_riverwaders_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_riverwaders_yes.isChecked()) {
                    riverwaders = "Yes";
                    raform_riverwaders_yes.setChecked(true);
                    raform_riverwaders_no.setChecked(false);
                }else { riverwaders = "No";
                    raform_riverwaders_yes.setChecked(true);
                }
            }

        });

        raform_riverwaders_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_riverwaders_no.isChecked()) {
                    raform_riverwaders_no.setChecked(true);
                    raform_riverwaders_yes.setChecked(false);
                }
            }

        });
        raform_rivertieoffpoint_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_rivertieoffpoint_yes.isChecked()) {
                    rivertieoffpoint = "Yes";
                    raform_rivertieoffpoint_yes.setChecked(true);
                    raform_rivertieoffpoint_no.setChecked(false);
                }else { rivertieoffpoint = "No";
                    raform_rivertieoffpoint_yes.setChecked(true);
                }
            }

        });

        raform_rivertieoffpoint_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_rivertieoffpoint_no.isChecked()) {
                    raform_rivertieoffpoint_no.setChecked(true);
                    raform_rivertieoffpoint_yes.setChecked(false);
                }
            }

        });
        raform_riversafeaccess_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_riversafeaccess_yes.isChecked()) {
                    riversafeaccess = "Yes";
                    raform_riversafeaccess_yes.setChecked(true);
                    raform_riversafeaccess_no.setChecked(false);
                }else { riversafeaccess = "No";
                    raform_riversafeaccess_yes.setChecked(true);
                }
            }

        });

        raform_riversafeaccess_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_riversafeaccess_no.isChecked()) {
                    raform_riversafeaccess_no.setChecked(true);
                    raform_riversafeaccess_yes.setChecked(false);
                }
            }

        });

        ///////////////////////////////////////4 Overhead Pwerlines/////////////////////////////////////////////////

        raform_overheadpowerlines_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_overheadpowerlines_yes.isChecked()) {
                    overheadpowerlines = "Yes";
                    raform_overheadpowerlines_yes.setChecked(true);
                    raform_overheadpowerlines_no.setChecked(false);
                    framelayout_overheadpowerlinesalert.setVisibility(LinearLayout.VISIBLE);
                }else { overheadpowerlines = "No";
                    raform_overheadpowerlines_yes.setChecked(true);
                    framelayout_overheadpowerlinesalert.setVisibility(LinearLayout.GONE);
                }
            }

        });

        raform_overheadpowerlines_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_overheadpowerlines_no.isChecked()) {
                    raform_overheadpowerlines_no.setChecked(true);
                    raform_overheadpowerlines_yes.setChecked(false);
                    framelayout_overheadpowerlinesalert.setVisibility(LinearLayout.GONE);
                }
            }

        });


                ///////////////////////////////////////Risk Assessment/////////////////////////////////////////////////

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
                    AT_RiskAssessment_model p = new AT_RiskAssessment_model();
                    p.setstartDate(getIntent().getStringExtra("Date"));
                    p.setuser_email(user_email.getText().toString());
                    p.setuser_name(user_name.getText().toString());
                    p.setuser_department_area(user_department_area.getText().toString());
                    p.setuser_contact_number(user_contact_number.getText().toString());

                    ///////////////////////////////////////1 Traffic/////////////////////////////////////////////////

                    if(raform_trafficppe_yes.isChecked()) {
                        p.settraffic_ppe("Yes");
                    } else {p.settraffic_ppe("No");
                    }if(raform_trafficppe_no.isChecked()) {
                        p.settraffic_ppe("No");
                    } else {p.settraffic_ppe("Yes");}

                    if(raform_trafficroads.isChecked()) {
                        p.settraffic_roads_or_footpath("Road");
                    } else {p.settraffic_roads_or_footpath("Footpath");
                    }if(raform_trafficfootpath.isChecked()) {
                        p.settraffic_roads_or_footpath("Footpath");
                    } else {p.settraffic_roads_or_footpath("Road");}

                    if(raform_traffictmpguidelines_yes.isChecked()) {
                        p.settraffic_following_guidelines("Yes");
                    } else {p.settraffic_following_guidelines("No");
                    }if(raform_traffictmpguidelines_no.isChecked()) {
                        p.settraffic_following_guidelines("No");
                    } else {p.settraffic_following_guidelines("Yes");}

                    if(raform_trafficbeacon_yes.isChecked()) {
                        p.settraffic_beacons("Yes");
                    } else {p.settraffic_beacons("No");
                    }if(raform_trafficbeacon_no.isChecked()) {
                        p.settraffic_beacons("No");
                    } else {p.settraffic_beacons("Yes");}

                    if(raform_trafficleftsite_yes.isChecked()) {
                        p.settraffic_left_site_in_good_order("Yes");
                    } else {p.settraffic_left_site_in_good_order("No");
                    }if(raform_trafficleftsite_no.isChecked()) {
                        p.settraffic_left_site_in_good_order("No");
                    } else {p.settraffic_left_site_in_good_order("Yes");}


                    ///////////////////////////////////////2 Heights/////////////////////////////////////////////////

                    if(raform_trafficfallsystem_yes.isChecked()) {
                        p.setheights_fall_arrest_system("Yes");
                    } else {p.setheights_fall_arrest_system("No");
                    }if(raform_trafficfallsystem_no.isChecked()) {
                        p.setheights_fall_arrest_system("No");
                    } else {p.setheights_fall_arrest_system("Yes");}

                    if(raform_heights_harnessinspect_yes.isChecked()) {
                        p.setheights_harness_inspection("Yes");
                    } else {p.setheights_harness_inspection("No");
                    }if(raform_heights_harnessinspect_no.isChecked()) {
                        p.setheights_harness_inspection("No");
                    } else {p.setheights_harness_inspection("Yes");}

                    if(raform_heights_ladderinspect_yes.isChecked()) {
                        p.setheights_ladder_inspection("Yes");
                    } else {p.setheights_ladder_inspection("No");
                    }if(raform_heights_ladderinspect_no.isChecked()) {
                        p.setheights_ladder_inspection("No");
                    } else {p.setheights_ladder_inspection("Yes");}

                    if(raform_heights_laddertie_yes.isChecked()) {
                        p.setheights_laddertied("Yes");
                    } else {p.setheights_laddertied("No");
                    }if(raform_heights_laddertie_no.isChecked()) {
                        p.setheights_laddertied("No");
                    } else {p.setheights_laddertied("Yes");}

                    if(raform_heights_manholebarriier_yes.isChecked()) {
                        p.setheights_manholebarrier("Yes");
                    } else {p.setheights_manholebarrier("No");
                    }if(raform_heights_manholebarriier_no.isChecked()) {
                        p.setheights_manholebarrier("No");
                    } else {p.setheights_manholebarrier("Yes");}

                    ///////////////////////////////////////2 Heights/////////////////////////////////////////////////

                    if(raform_riverlifejacket_yes.isChecked()) {
                        p.setriverlifejacket("Yes");
                    } else {p.setriverlifejacket("No");
                    }if(raform_riverlifejacket_no.isChecked()) {
                        p.setriverlifejacket("No");
                    } else {p.setriverlifejacket("Yes");}

                    if(raform_riverwaders_yes.isChecked()) {
                        p.setriverwaders("Yes");
                    } else {p.setriverwaders("No");
                    }if(raform_riverwaders_no.isChecked()) {
                        p.setriverwaders("No");
                    } else {p.setriverwaders("Yes");}

                    if(raform_rivertieoffpoint_yes.isChecked()) {
                        p.setrivertieoffpoint("Yes");
                    } else {p.setrivertieoffpoint("No");
                    }if(raform_rivertieoffpoint_no.isChecked()) {
                        p.setrivertieoffpoint("No");
                    } else {p.setrivertieoffpoint("Yes");}

                    if(raform_riversafeaccess_yes.isChecked()) {
                        p.setriversafeaccess("Yes");
                    } else {p.setriversafeaccess("No");
                    }if(raform_riversafeaccess_no.isChecked()) {
                        p.setriversafeaccess("No");
                    } else {p.setriversafeaccess("Yes");}

                    ///////////////////////////////////////4 Overhead Powerline/////////////////////////////////////////////////

                    if(raform_overheadpowerlines_yes.isChecked()) {
                        p.setoverheadpowerlines("Yes");
                    } else {p.setoverheadpowerlines("No");
                    }if(raform_overheadpowerlines_no.isChecked()) {
                        p.setoverheadpowerlines("No");
                    } else {p.setoverheadpowerlines("Yes");}

                    ///////////////////////////////////////1 Section 1 Location/////////////////////////////////////////////////


                    if (AT_RiskAssessment_model == null)
                        AT_RiskAssessment_database.getInstance().addAT_RiskAssessment_model(p);
                    startActivity (new Intent(AT_RiskAssessment_view.this, MainActivity.class));
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
        Firebase mRootRef = new Firebase("https://truckman-1dc51.firebaseio.com/");
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
    }



    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public void searchAT_RiskAssessment_model(int position) {
        String clickedKey = AT_RiskAssessment_database.getInstance().getKeysArray().get(position);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        AT_RiskAssessment_database.getInstance().getmDatabase().child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Risk Assessment Form").child(clickedKey).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        AT_RiskAssessment_model AT_RiskAssessment_model = dataSnapshot.getValue(AT_RiskAssessment_model.class);
                        user_name.setText(AT_RiskAssessment_model.getuser_name());
                        user_email.setText(AT_RiskAssessment_model.getuser_email());
                        user_department_area.setText(AT_RiskAssessment_model.getuser_department_area());
                        user_contact_number.setText(AT_RiskAssessment_model.getuser_contact_number());

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }
}
