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

public class AT_RiskAssessment_view extends AppCompatActivity implements UserLocation.LocationCallback {

    TextView user_name,user_email,user_department_area,user_contact_number,time_stamp;


    CoordinatorLayout cl;
    Button bOK,bCancel;
    int position;
    AT_RiskAssessment_model AT_RiskAssessment_model;

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


    Boolean ratrafficicon100x100pressed = false;
    Boolean raworkingatheightsicon100x100pressed = false;
    Boolean rarivercleaningicon100x100pressed = false;
    Boolean rapowerlinesicon100x100pressed = false;
    Boolean raundergroundservicesicon100x100pressed = false;
    Boolean ramanhandleicon100x100pressed = false;
    Boolean raconspaceicon100x100pressed = false;
    Boolean rapowertoolsicon100x100pressed = false;
    Boolean rageneralppeicon100x100pressed = false;



    ImageButton ratrafficicon100x100;
    ImageButton rappeicon100x100;
    ImageButton raroadsicon100x100;
    ImageButton rafootpathicon100x100;
    ImageButton rarivercleaningicon100x100;

    ImageButton raworkingatheightsicon100x100;
    ImageButton rapowerlinesicon100x100;
    ImageButton raoverheadpowerlinesicon100x100;
    ImageButton raoverheadpowerlinesalerticon100x100;

    ImageButton rariverlifejacketicon100x100;
    ImageButton rariverwadersicon100x100;
    ImageButton rarivertieoffpointicon100x100;
    ImageButton rariversafeaccessicon100x100;

    ImageButton raundergroundservicesicon100x100;
    ImageButton raundergrounddrawingsicon100x100;
    ImageButton raundergroundcaticon100x100;

    ImageButton ramanhandleicon100x100;
    ImageButton ramanhandleloadassessedicon100x100;
    ImageButton ramanhandlemechanicalicon100x100;
    ImageButton ramanhandletwomanlifticon100x100;

    ImageButton raconspaceicon100x100;
    ImageButton raconfinedspaceicon100x100;
    ImageButton raconfinedspacealert100x100;

    ImageButton rapowertoolsicon100x100;
    ImageButton rapowertools2icon100x100;
    ImageButton rapowertoolsiconalert100x100;

    ImageButton rageneralppeicon100x100;
    ImageButton rageneralppesafetygooglesicon100x100;
    ImageButton rageneralppehearing100x100;
    ImageButton rageneralppegloves100x100;
    ImageButton rageneralppedustoverallicon100x100;
    ImageButton rageneralppehivisicon100x100;
    ImageButton rageneralppehardhaticon100x100;
    ImageButton rageneralppedustmaskicon100x100;

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

    CheckBox raform_undergrounddrawings_yes;
    CheckBox raform_undergrounddrawings_no;
    CheckBox raform_undergroundcat_yes;
    CheckBox raform_undergroundcat_no;

    CheckBox raform_manhandleloadassessed_yes;
    CheckBox raform_manhandleloadassessed_no;
    CheckBox raform_manhandlemechanical_yes;
    CheckBox raform_manhandlemechanical_no;
    CheckBox raform_manhandletwomanlift_yes;
    CheckBox raform_manhandletwomanlift_no;

    CheckBox raform_confinedspace_yes;
    CheckBox raform_confinedspace_no;

    CheckBox raform_powertools_yes;
    CheckBox raform_powertools_no;

    CheckBox raform_generalppesafetygoogles_yes;
    CheckBox raform_generalppesafetygoogles_no;
    CheckBox raform_generalppehearing_yes;
    CheckBox raform_generalppehearing_no;
    CheckBox raform_generalppegloves_yes;
    CheckBox raform_generalppegloves_no;
    CheckBox raform_generalppedustoverall_yes;
    CheckBox raform_generalppedustoverall_no;
    CheckBox raform_generalppehivis_yes;
    CheckBox raform_generalppehivis_no;
    CheckBox raform_generalppehardhat_yes;
    CheckBox raform_generalppehardhat_no;
    CheckBox raform_generalppedustmask_yes;
    CheckBox raform_generalppedustmask_no;


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

    String undergrounddrawings;
    String undergroundcat;

    String manhandleloadassessed;
    String manhandlemechanical;
    String manhandletwomanlift;

    String confinedspace;

    String powertools;

    String generalppesafetygoogles;
    String generalppehearing;
    String generalppegloves;
    String generalppedustoverall;
    String generalppehivis;
    String generalppehardhat;
    String generalppedustmask;




    ///////////////////////////////////////////////////////////////////////////////////

    FrameLayout framelayout_traffic;
    FrameLayout framelayout_workingatheights;
    FrameLayout framelayout_rivercleaning;

    FrameLayout framelayout_overheadpowerlines;
    FrameLayout framelayout_overheadpowerlinesalert;

    FrameLayout framelayout_undergroundservices;
    FrameLayout framelayout_manhandle;

    FrameLayout framelayout_confinedspace;
    FrameLayout framelayout_confinedspacealert;

    FrameLayout framelayout_powertools;
    FrameLayout framelayout_powertoolsalert;

    FrameLayout framelayout_generalppe;
    ///////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at__risk_assessment_view);
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

        ///////////////////////////////////////////////////////////////////////////////////

        ratrafficicon100x100 = (ImageButton) findViewById(R.id.ratrafficicon100x100);
        rappeicon100x100 = (ImageButton) findViewById(R.id.rappeicon100x100);
        raroadsicon100x100 = (ImageButton) findViewById(R.id.raroadsicon100x100);
        rafootpathicon100x100 = (ImageButton) findViewById(R.id.rafootpathicon100x100);
        rarivercleaningicon100x100 = (ImageButton) findViewById(R.id.rarivercleaningicon100x100);
        raworkingatheightsicon100x100 = (ImageButton) findViewById(R.id.raworkingatheightsicon100x100);


        rapowerlinesicon100x100 = (ImageButton) findViewById(R.id.rapowerlinesicon100x100);
        raoverheadpowerlinesicon100x100 = (ImageButton) findViewById(R.id.raoverheadpowerlinesicon100x100);
        raoverheadpowerlinesalerticon100x100 = (ImageButton) findViewById(R.id.raoverheadpowerlinesalerticon100x100);

        rariverlifejacketicon100x100 = (ImageButton) findViewById(R.id.rariverlifejacketicon100x100);
        rariverwadersicon100x100 = (ImageButton) findViewById(R.id.rariverwadersicon100x100);
        rarivertieoffpointicon100x100 = (ImageButton) findViewById(R.id.rarivertieoffpointicon100x100);
        rariversafeaccessicon100x100 = (ImageButton) findViewById(R.id.rariversafeaccessicon100x100);

        raundergroundservicesicon100x100 = (ImageButton) findViewById(R.id.raundergroundservicesicon100x100);
        raundergrounddrawingsicon100x100 = (ImageButton) findViewById(R.id.raundergrounddrawingsicon100x100);
        raundergroundcaticon100x100 = (ImageButton) findViewById(R.id.raundergroundcaticon100x100);

        ramanhandleicon100x100 = (ImageButton) findViewById(R.id.ramanhandleicon100x100);
        ramanhandleloadassessedicon100x100 = (ImageButton) findViewById(R.id.ramanhandleloadassessedicon100x100);
        ramanhandlemechanicalicon100x100 = (ImageButton) findViewById(R.id.ramanhandlemechanicalicon100x100);
        ramanhandletwomanlifticon100x100 = (ImageButton) findViewById(R.id.ramanhandletwomanlifticon100x100);

        raconspaceicon100x100 = (ImageButton) findViewById(R.id.raconspaceicon100x100);
        raconfinedspaceicon100x100 = (ImageButton) findViewById(R.id.raconfinedspaceicon100x100);
        raconfinedspacealert100x100 = (ImageButton) findViewById(R.id.raconfinedspacealert100x100);

        rapowertoolsicon100x100 = (ImageButton) findViewById(R.id.rapowertoolsicon100x100);
        rapowertools2icon100x100 = (ImageButton) findViewById(R.id.rapowertools2icon100x100);
        rapowertoolsiconalert100x100 = (ImageButton) findViewById(R.id.rapowertoolsiconalert100x100);

        rageneralppeicon100x100 = (ImageButton) findViewById(R.id.rageneralppeicon100x100);
        rageneralppesafetygooglesicon100x100 = (ImageButton) findViewById(R.id.rageneralppesafetygooglesicon100x100);
        rageneralppehearing100x100 = (ImageButton) findViewById(R.id.rageneralppehearing100x100);
        rageneralppegloves100x100 = (ImageButton) findViewById(R.id.rageneralppegloves100x100);
        rageneralppedustoverallicon100x100 = (ImageButton) findViewById(R.id.rageneralppedustoverallicon100x100);
        rageneralppehivisicon100x100 = (ImageButton) findViewById(R.id.rageneralppehivisicon100x100);
        rageneralppehardhaticon100x100 = (ImageButton) findViewById(R.id.rageneralppehardhaticon100x100);
        rageneralppedustmaskicon100x100 = (ImageButton) findViewById(R.id.rageneralppedustmaskicon100x100);

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

        raform_undergrounddrawings_yes = (CheckBox) findViewById(R.id.raform_undergrounddrawings_yes);
        raform_undergrounddrawings_no = (CheckBox) findViewById(R.id.raform_undergrounddrawings_no);
        raform_undergroundcat_yes = (CheckBox) findViewById(R.id.raform_undergroundcat_yes);
        raform_undergroundcat_no = (CheckBox) findViewById(R.id.raform_undergroundcat_no);

        raform_manhandleloadassessed_yes = (CheckBox) findViewById(R.id.raform_manhandleloadassessed_yes);
        raform_manhandleloadassessed_no = (CheckBox) findViewById(R.id.raform_manhandleloadassessed_no);
        raform_manhandlemechanical_yes = (CheckBox) findViewById(R.id.raform_manhandlemechanical_yes);
        raform_manhandlemechanical_no = (CheckBox) findViewById(R.id.raform_manhandlemechanical_no);
        raform_manhandletwomanlift_yes = (CheckBox) findViewById(R.id.raform_manhandletwomanlift_yes);
        raform_manhandletwomanlift_no = (CheckBox) findViewById(R.id.raform_manhandletwomanlift_no);

        raform_confinedspace_yes = (CheckBox) findViewById(R.id.raform_confinedspace_yes);
        raform_confinedspace_no = (CheckBox) findViewById(R.id.raform_confinedspace_no);

        raform_powertools_yes = (CheckBox) findViewById(R.id.raform_powertools_yes);
        raform_powertools_no = (CheckBox) findViewById(R.id.raform_powertools_no);

        raform_generalppesafetygoogles_yes = (CheckBox) findViewById(R.id.raform_generalppesafetygoogles_yes);
        raform_generalppesafetygoogles_no = (CheckBox) findViewById(R.id.raform_generalppesafetygoogles_no);
        raform_generalppehearing_yes = (CheckBox) findViewById(R.id.raform_generalppehearing_yes);
        raform_generalppehearing_no = (CheckBox) findViewById(R.id.raform_generalppehearing_no);
        raform_generalppegloves_yes = (CheckBox) findViewById(R.id.raform_generalppegloves_yes);
        raform_generalppegloves_no = (CheckBox) findViewById(R.id.raform_generalppegloves_no);
        raform_generalppedustoverall_yes = (CheckBox) findViewById(R.id.raform_generalppedustoverall_yes);
        raform_generalppedustoverall_no = (CheckBox) findViewById(R.id.raform_generalppedustoverall_no);
        raform_generalppehivis_yes = (CheckBox) findViewById(R.id.raform_generalppehivis_yes);
        raform_generalppehivis_no = (CheckBox) findViewById(R.id.raform_generalppehivis_no);
        raform_generalppehardhat_yes = (CheckBox) findViewById(R.id.raform_generalppehardhat_yes);
        raform_generalppehardhat_no = (CheckBox) findViewById(R.id.raform_generalppehardhat_no);
        raform_generalppedustmask_yes = (CheckBox) findViewById(R.id.raform_generalppedustmask_yes);
        raform_generalppedustmask_no = (CheckBox) findViewById(R.id.raform_generalppedustmask_no);



        framelayout_traffic = (FrameLayout) findViewById(R.id.framelayout_traffic);
        framelayout_workingatheights = (FrameLayout) findViewById(R.id.framelayout_workingatheights);
        framelayout_rivercleaning = (FrameLayout) findViewById(R.id.framelayout_rivercleaning);
        framelayout_overheadpowerlines = (FrameLayout) findViewById(R.id.framelayout_overheadpowerlines);
        framelayout_overheadpowerlinesalert = (FrameLayout) findViewById(R.id.framelayout_overheadpowerlinesalert);
        framelayout_undergroundservices = (FrameLayout) findViewById(R.id.framelayout_undergroundservices);
        framelayout_manhandle = (FrameLayout) findViewById(R.id.framelayout_manhandle);

        framelayout_confinedspace = (FrameLayout) findViewById(R.id.framelayout_confinedspace);
        framelayout_confinedspacealert = (FrameLayout) findViewById(R.id.framelayout_confinedspacealert);

        framelayout_powertools = (FrameLayout) findViewById(R.id.framelayout_powertools);
        framelayout_powertoolsalert = (FrameLayout) findViewById(R.id.framelayout_powertoolsalert);

        framelayout_generalppe = (FrameLayout) findViewById(R.id.framelayout_generalppe);

        ///////////////////////////////////////////////////////////////////////////////////

        framelayout_traffic.setVisibility(LinearLayout.GONE);
        rafootpathicon100x100.setVisibility(LinearLayout.GONE);
        framelayout_rivercleaning.setVisibility(LinearLayout.GONE);
        framelayout_overheadpowerlines.setVisibility(LinearLayout.GONE);
        framelayout_overheadpowerlinesalert.setVisibility(LinearLayout.GONE);
        framelayout_undergroundservices.setVisibility(LinearLayout.GONE);
        framelayout_manhandle.setVisibility(LinearLayout.GONE);
        framelayout_confinedspace.setVisibility(LinearLayout.GONE);
        framelayout_confinedspacealert.setVisibility(LinearLayout.GONE);
        framelayout_powertools.setVisibility(LinearLayout.GONE);
        framelayout_powertoolsalert.setVisibility(LinearLayout.GONE);
        framelayout_generalppe.setVisibility(LinearLayout.GONE);

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
        if (raundergroundservicesicon100x100pressed == false) {
            framelayout_undergroundservices.setVisibility(LinearLayout.GONE);
        }
        if (raundergroundservicesicon100x100pressed == true) {
            framelayout_undergroundservices.setVisibility(LinearLayout.VISIBLE);
        }
        if (ramanhandleicon100x100pressed == false) {
            framelayout_manhandle.setVisibility(LinearLayout.GONE);
        }
        if (ramanhandleicon100x100pressed == true) {
            framelayout_manhandle.setVisibility(LinearLayout.VISIBLE);
        }
        if (raconspaceicon100x100pressed == false) {
            framelayout_confinedspace.setVisibility(LinearLayout.GONE);
        }
        if (raconspaceicon100x100pressed == true) {
            framelayout_confinedspace.setVisibility(LinearLayout.VISIBLE);
        }
        if (rapowertoolsicon100x100pressed == false) {
            framelayout_powertools.setVisibility(LinearLayout.GONE);
        }
        if (rapowertoolsicon100x100pressed == true) {
            framelayout_powertools.setVisibility(LinearLayout.VISIBLE);
        }
        if (rageneralppeicon100x100pressed == false) {
            framelayout_generalppe.setVisibility(LinearLayout.GONE);
        }
        if (rageneralppeicon100x100pressed == true) {
            framelayout_generalppe.setVisibility(LinearLayout.VISIBLE);
        }
        ///////////////////////////////////////////////////////////////////////////////////

        ratrafficicon100x100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLocation.disconnect();
                userLocation.connect();
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

        raundergroundservicesicon100x100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raundergroundservicesicon100x100pressed == false) {
                    framelayout_undergroundservices.setVisibility(LinearLayout.VISIBLE);
                    raundergroundservicesicon100x100pressed ^= true;
                } else if
                        (raundergroundservicesicon100x100pressed == true) {
                    framelayout_undergroundservices.setVisibility(LinearLayout.GONE);
                    raundergroundservicesicon100x100pressed ^= true;
                }
            }

        });

        ramanhandleicon100x100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ramanhandleicon100x100pressed == false) {
                    framelayout_manhandle.setVisibility(LinearLayout.VISIBLE);
                    ramanhandleicon100x100pressed ^= true;
                } else if
                        (ramanhandleicon100x100pressed == true) {
                    framelayout_manhandle.setVisibility(LinearLayout.GONE);
                    ramanhandleicon100x100pressed ^= true;
                }
            }

        });

        raconspaceicon100x100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raconspaceicon100x100pressed == false) {
                    framelayout_confinedspace.setVisibility(LinearLayout.VISIBLE);
                    raconspaceicon100x100pressed ^= true;
                } else if
                        (raconspaceicon100x100pressed == true) {
                    framelayout_confinedspace.setVisibility(LinearLayout.GONE);
                    raconspaceicon100x100pressed ^= true;
                }
            }

        });

        rapowertoolsicon100x100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rapowertoolsicon100x100pressed == false) {
                    framelayout_powertools.setVisibility(LinearLayout.VISIBLE);
                    rapowertoolsicon100x100pressed ^= true;
                } else if
                        (rapowertoolsicon100x100pressed == true) {
                    framelayout_powertools.setVisibility(LinearLayout.GONE);
                    rapowertoolsicon100x100pressed ^= true;
                }
            }

        });

        rageneralppeicon100x100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rageneralppeicon100x100pressed == false) {
                    framelayout_generalppe.setVisibility(LinearLayout.VISIBLE);
                    rageneralppeicon100x100pressed ^= true;
                } else if
                        (rageneralppeicon100x100pressed == true) {
                    framelayout_generalppe.setVisibility(LinearLayout.GONE);
                    rageneralppeicon100x100pressed ^= true;
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
                    raform_trafficppe_no.setChecked(false);}
            }
        });
        raform_trafficppe_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_trafficppe_no.isChecked()) {
                    raform_trafficppe_yes.setChecked(false);}
            }
        });

        raform_trafficroads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_trafficroads.isChecked()) {
                    raroadsicon100x100.setVisibility(LinearLayout.VISIBLE);
                    rafootpathicon100x100.setVisibility(LinearLayout.GONE);
                    raform_trafficfootpath.setChecked(false);}
            }
        });
        raform_trafficfootpath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_trafficfootpath.isChecked()) {
                    raroadsicon100x100.setVisibility(LinearLayout.GONE);
                    rafootpathicon100x100.setVisibility(LinearLayout.VISIBLE);
                    raform_trafficroads.setChecked(false);}
            }
        });

        raform_traffictmpguidelines_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_traffictmpguidelines_yes.isChecked()) {
                    raform_traffictmpguidelines_no.setChecked(false);}
            }
        });
        raform_traffictmpguidelines_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_traffictmpguidelines_no.isChecked()) {
                    raform_traffictmpguidelines_yes.setChecked(false);}
            }
        });

        raform_trafficbeacon_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_trafficbeacon_yes.isChecked()) {
                    raform_trafficbeacon_no.setChecked(false);}
            }
        });
        raform_trafficbeacon_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_trafficbeacon_no.isChecked()) {
                    raform_trafficbeacon_yes.setChecked(false);}
            }
        });

        raform_trafficleftsite_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_trafficleftsite_yes.isChecked()) {
                    raform_trafficleftsite_no.setChecked(false);}
            }
        });
        raform_trafficleftsite_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_trafficleftsite_no.isChecked()) {
                    raform_trafficleftsite_yes.setChecked(false);}
            }
        });


        ///////////////////////////////////////2 Heights/////////////////////////////////////////////////

        raform_trafficfallsystem_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_trafficfallsystem_yes.isChecked()) {
                    raform_trafficfallsystem_no.setChecked(false);}
            }
        });
        raform_trafficfallsystem_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_trafficfallsystem_no.isChecked()) {
                    raform_trafficfallsystem_yes.setChecked(false);}
            }
        });

        raform_heights_harnessinspect_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_heights_harnessinspect_yes.isChecked()) {
                    raform_heights_harnessinspect_no.setChecked(false);}
            }
        });
        raform_heights_harnessinspect_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_heights_harnessinspect_no.isChecked()) {
                    raform_heights_harnessinspect_yes.setChecked(false);}
            }
        });

        raform_heights_ladderinspect_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_heights_ladderinspect_yes.isChecked()) {
                    raform_heights_ladderinspect_no.setChecked(false);}
            }
        });
        raform_heights_ladderinspect_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_heights_ladderinspect_no.isChecked()) {
                    raform_heights_ladderinspect_yes.setChecked(false);}
            }
        });

        raform_heights_laddertie_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_heights_laddertie_yes.isChecked()) {
                    raform_heights_laddertie_no.setChecked(false);}
            }
        });
        raform_heights_laddertie_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_heights_laddertie_no.isChecked()) {
                    raform_heights_laddertie_yes.setChecked(false);}
            }
        });

        raform_heights_manholebarriier_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_heights_manholebarriier_yes.isChecked()) {
                    raform_heights_manholebarriier_no.setChecked(false);}
            }
        });
        raform_heights_manholebarriier_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_heights_manholebarriier_no.isChecked()) {
                    raform_heights_manholebarriier_yes.setChecked(false);}
            }
        });



        ///////////////////////////////////////3 River Cleaning/////////////////////////////////////////////////

        raform_riverlifejacket_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_riverlifejacket_yes.isChecked()) {
                    raform_riverlifejacket_no.setChecked(false);}
            }
        });
        raform_riverlifejacket_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_riverlifejacket_no.isChecked()) {
                    raform_riverlifejacket_yes.setChecked(false);}
            }
        });


        raform_riverwaders_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_riverwaders_yes.isChecked()) {
                    raform_riverwaders_no.setChecked(false);}
            }
        });
        raform_riverwaders_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_riverwaders_no.isChecked()) {
                    raform_riverwaders_yes.setChecked(false);}
            }
        });

        raform_rivertieoffpoint_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_rivertieoffpoint_yes.isChecked()) {
                    raform_rivertieoffpoint_no.setChecked(false);}
            }
        });
        raform_rivertieoffpoint_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_rivertieoffpoint_no.isChecked()) {
                    raform_rivertieoffpoint_yes.setChecked(false);}
            }
        });
        raform_riversafeaccess_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_riversafeaccess_yes.isChecked()) {
                    raform_riversafeaccess_no.setChecked(false);}
            }
        });
        raform_riversafeaccess_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_riversafeaccess_no.isChecked()) {
                    raform_riversafeaccess_yes.setChecked(false);}
            }
        });


        ///////////////////////////////////////4 Overhead Pwerlines/////////////////////////////////////////////////


        raform_overheadpowerlines_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_overheadpowerlines_yes.isChecked()) {
                    framelayout_overheadpowerlinesalert.setVisibility(LinearLayout.VISIBLE);
                    raform_overheadpowerlines_no.setChecked(false);}
            }
        });
        raform_overheadpowerlines_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_overheadpowerlines_no.isChecked()) {
                    framelayout_overheadpowerlinesalert.setVisibility(LinearLayout.GONE);
                    raform_overheadpowerlines_yes.setChecked(false);}
            }
        });

        ///////////////////////////////////////5 Underground Services/////////////////////////////////////////////////


        raform_undergrounddrawings_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_undergrounddrawings_yes.isChecked()) {
                    raform_undergrounddrawings_no.setChecked(false);}
            }
        });
        raform_undergrounddrawings_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_undergrounddrawings_no.isChecked()) {
                    raform_undergrounddrawings_yes.setChecked(false);}
            }
        });

        raform_undergroundcat_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_undergroundcat_yes.isChecked()) {
                    raform_undergroundcat_no.setChecked(false);}
            }
        });
        raform_undergroundcat_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_undergroundcat_no.isChecked()) {
                    raform_undergroundcat_yes.setChecked(false);}
            }
        });


        ///////////////////////////////////////6 Manual Handling/////////////////////////////////////////////////


        raform_manhandleloadassessed_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_manhandleloadassessed_yes.isChecked()) {
                    raform_manhandleloadassessed_no.setChecked(false);}
            }
        });
        raform_manhandleloadassessed_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_manhandleloadassessed_no.isChecked()) {
                    raform_manhandleloadassessed_yes.setChecked(false);}
            }
        });

        raform_manhandlemechanical_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_manhandlemechanical_yes.isChecked()) {
                    raform_manhandlemechanical_no.setChecked(false);}
            }
        });
        raform_manhandlemechanical_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_manhandlemechanical_no.isChecked()) {
                    raform_manhandlemechanical_yes.setChecked(false);}
            }
        });

        raform_manhandletwomanlift_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_manhandletwomanlift_yes.isChecked()) {
                    raform_manhandletwomanlift_no.setChecked(false);}
            }
        });
        raform_manhandletwomanlift_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_manhandletwomanlift_no.isChecked()) {
                    raform_manhandletwomanlift_yes.setChecked(false);}
            }
        });


        ///////////////////////////////////////7 Confined Space/////////////////////////////////////////////////

        raform_confinedspace_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_confinedspace_yes.isChecked()) {
                    raform_confinedspace_no.setChecked(false);
                framelayout_confinedspacealert.setVisibility(LinearLayout.VISIBLE);}
            }
        });
        raform_confinedspace_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_confinedspace_no.isChecked()) {
                    framelayout_confinedspacealert.setVisibility(LinearLayout.GONE);
                    raform_confinedspace_yes.setChecked(false);}
            }
        });


        ///////////////////////////////////////8 Power Tools/////////////////////////////////////////////////


        raform_powertools_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_powertools_yes.isChecked()) {
                    framelayout_powertoolsalert.setVisibility(LinearLayout.VISIBLE);
                    raform_powertools_no.setChecked(false);}
            }
        });
        raform_powertools_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_powertools_no.isChecked()) {
                    framelayout_powertoolsalert.setVisibility(LinearLayout.GONE);
                    raform_powertools_yes.setChecked(false);}
            }
        });



        ///////////////////////////////////////9 General PPE/////////////////////////////////////////////////


        raform_generalppesafetygoogles_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppesafetygoogles_yes.isChecked()) {
                    raform_generalppesafetygoogles_no.setChecked(false);}
            }
        });
        raform_generalppesafetygoogles_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppesafetygoogles_no.isChecked()) {
                    raform_generalppesafetygoogles_yes.setChecked(false);}
            }
        });

        raform_generalppehearing_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppehearing_yes.isChecked()) {
                    raform_generalppehearing_no.setChecked(false);}
            }
        });
        raform_generalppehearing_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppehearing_no.isChecked()) {
                    raform_generalppehearing_yes.setChecked(false);}
            }
        });

        raform_generalppegloves_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppegloves_yes.isChecked()) {
                    raform_generalppegloves_no.setChecked(false);}
            }
        });
        raform_generalppegloves_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppegloves_no.isChecked()) {
                    raform_generalppegloves_yes.setChecked(false);}
            }
        });

        raform_generalppegloves_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppegloves_yes.isChecked()) {
                    raform_generalppegloves_no.setChecked(false);}
            }
        });
        raform_generalppegloves_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppegloves_no.isChecked()) {
                    raform_generalppegloves_yes.setChecked(false);}
            }
        });

        raform_generalppedustoverall_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppedustoverall_yes.isChecked()) {
                    raform_generalppedustoverall_no.setChecked(false);}
            }
        });
        raform_generalppedustoverall_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppedustoverall_no.isChecked()) {
                    raform_generalppedustoverall_yes.setChecked(false);}
            }
        });

        raform_generalppehivis_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppehivis_yes.isChecked()) {
                    raform_generalppehivis_no.setChecked(false);}
            }
        });
        raform_generalppehivis_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppehivis_no.isChecked()) {
                    raform_generalppehivis_yes.setChecked(false);}
            }
        });

        raform_generalppehardhat_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppehardhat_yes.isChecked()) {
                    raform_generalppehardhat_no.setChecked(false);}
            }
        });
        raform_generalppehardhat_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppehardhat_no.isChecked()) {
                    raform_generalppehardhat_yes.setChecked(false);}
            }
        });

        raform_generalppedustmask_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppedustmask_yes.isChecked()) {
                    raform_generalppedustmask_no.setChecked(false);}
            }
        });
        raform_generalppedustmask_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (raform_generalppedustmask_no.isChecked()) {
                    raform_generalppedustmask_yes.setChecked(false);}
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
                    } else if(raform_trafficppe_no.isChecked()) {
                        p.settraffic_ppe("No");
                    } else { p.settraffic_ppe("N/A");}

                    if(raform_trafficroads.isChecked()) {
                        p.settraffic_roads_or_footpath("Road");
                    } else if(raform_trafficfootpath.isChecked()) {
                        p.settraffic_roads_or_footpath("Footpath");
                    } else { p.settraffic_roads_or_footpath("N/A");}

                    if(raform_traffictmpguidelines_yes.isChecked()) {
                        p.settraffic_following_guidelines("Yes");
                    } else if(raform_traffictmpguidelines_no.isChecked()) {
                        p.settraffic_following_guidelines("No");
                    } else { p.settraffic_following_guidelines("N/A");}

                    if(raform_trafficbeacon_yes.isChecked()) {
                        p.settraffic_beacons("Yes");
                    } else if(raform_trafficbeacon_no.isChecked()) {
                        p.settraffic_beacons("No");
                    } else { p.settraffic_beacons("N/A");}

                    if(raform_trafficleftsite_yes.isChecked()) {
                        p.settraffic_left_site_in_good_order("Yes");
                    } else if(raform_trafficleftsite_no.isChecked()) {
                        p.settraffic_left_site_in_good_order("No");
                    } else { p.settraffic_left_site_in_good_order("N/A");}


                    ///////////////////////////////////////2 Heights/////////////////////////////////////////////////


                    if(raform_trafficfallsystem_yes.isChecked()) {
                        p.setheights_fall_arrest_system("Yes");
                    } else if(raform_trafficfallsystem_no.isChecked()) {
                        p.setheights_fall_arrest_system("No");
                    } else { p.setheights_fall_arrest_system("N/A");}

                    if(raform_heights_harnessinspect_yes.isChecked()) {
                        p.setheights_harness_inspection("Yes");
                    } else if(raform_heights_harnessinspect_no.isChecked()) {
                        p.setheights_harness_inspection("No");
                    } else { p.setheights_harness_inspection("N/A");}

                    if(raform_heights_ladderinspect_yes.isChecked()) {
                        p.setheights_ladder_inspection("Yes");
                    } else if(raform_heights_ladderinspect_no.isChecked()) {
                        p.setheights_ladder_inspection("No");
                    } else { p.setheights_ladder_inspection("N/A");}

                    if(raform_heights_laddertie_yes.isChecked()) {
                        p.setheights_laddertied("Yes");
                    } else if(raform_heights_laddertie_no.isChecked()) {
                        p.setheights_laddertied("No");
                    } else { p.setheights_laddertied("N/A");}

                    if(raform_heights_manholebarriier_yes.isChecked()) {
                        p.setheights_manholebarrier("Yes");
                    } else if(raform_heights_manholebarriier_no.isChecked()) {
                        p.setheights_manholebarrier("No");
                    } else { p.setheights_manholebarrier("N/A");}

                    ///////////////////////////////////////2 Heights/////////////////////////////////////////////////

                    if(raform_riverlifejacket_yes.isChecked()) {
                        p.setriverlifejacket("Yes");
                    } else if(raform_riverlifejacket_no.isChecked()) {
                        p.setriverlifejacket("No");
                    } else { p.setriverlifejacket("N/A");}

                    if(raform_riverwaders_yes.isChecked()) {
                        p.setriverwaders("Yes");
                    } else if(raform_riverwaders_no.isChecked()) {
                        p.setriverwaders("No");
                    } else { p.setriverwaders("N/A");}

                    if(raform_rivertieoffpoint_yes.isChecked()) {
                        p.setrivertieoffpoint("Yes");
                    } else if(raform_rivertieoffpoint_no.isChecked()) {
                        p.setrivertieoffpoint("No");
                    } else { p.setrivertieoffpoint("N/A");}

                    if(raform_riversafeaccess_yes.isChecked()) {
                        p.setriversafeaccess("Yes");
                    } else if(raform_riversafeaccess_no.isChecked()) {
                        p.setriversafeaccess("No");
                    } else { p.setriversafeaccess("N/A");}


                    ///////////////////////////////////////4 Overhead Powerline/////////////////////////////////////////////////


                    if(raform_overheadpowerlines_yes.isChecked()) {
                        p.setoverheadpowerlines("Yes");
                    } else if(raform_overheadpowerlines_no.isChecked()) {
                        p.setoverheadpowerlines("No");
                    } else { p.setoverheadpowerlines("N/A");}


                    ///////////////////////////////////////5 Underground Services/////////////////////////////////////////////////


                    if(raform_undergrounddrawings_yes.isChecked()) {
                        p.setundergrounddrawings("Yes");
                    } else if(raform_undergrounddrawings_no.isChecked()) {
                        p.setundergrounddrawings("No");
                    } else { p.setundergrounddrawings("N/A");}


                    if(raform_undergroundcat_yes.isChecked()) {
                        p.setundergroundcat("Yes");
                    } else if(raform_undergroundcat_no.isChecked()) {
                        p.setundergroundcat("No");
                    } else { p.setundergroundcat("N/A");}



                    ///////////////////////////////////////6 Manual Handling/////////////////////////////////////////////////



                    if(raform_manhandleloadassessed_yes.isChecked()) {
                        p.setmanhandleloadassessed("Yes");
                    } else if(raform_manhandleloadassessed_no.isChecked()) {
                        p.setmanhandleloadassessed("No");
                    } else { p.setmanhandleloadassessed("N/A");}


                    if(raform_manhandlemechanical_yes.isChecked()) {
                        p.setmanhandlemechanical("Yes");
                    } else if(raform_manhandlemechanical_no.isChecked()) {
                        p.setmanhandlemechanical("No");
                    } else { p.setmanhandlemechanical("N/A");}

                    if(raform_manhandletwomanlift_yes.isChecked()) {
                        p.setmanhandletwomanlift("Yes");
                    } else if(raform_manhandletwomanlift_no.isChecked()) {
                        p.setmanhandletwomanlift("No");
                    } else { p.setmanhandletwomanlift("N/A");}


                    ///////////////////////////////////////7 Confined Space/////////////////////////////////////////////////


                    if(raform_confinedspace_yes.isChecked()) {
                        p.setconfinedspace("Yes");
                    } else if(raform_confinedspace_no.isChecked()) {
                        p.setconfinedspace("No");
                    } else { p.setconfinedspace("N/A");}


                    ///////////////////////////////////////8 Power tools/////////////////////////////////////////////////

                    if(raform_powertools_yes.isChecked()) {
                        p.setpowertools("Yes");
                    } else if(raform_powertools_no.isChecked()) {
                        p.setpowertools("No");
                    } else { p.setpowertools("N/A");}

                    ///////////////////////////////////////9 General PPE/////////////////////////////////////////////////


                    if(raform_generalppesafetygoogles_yes.isChecked()) {
                        p.setgeneralppesafetygoogles("Yes");
                    } else if(raform_generalppesafetygoogles_no.isChecked()) {
                        p.setgeneralppesafetygoogles("No");
                    } else { p.setgeneralppesafetygoogles("N/A");}

                    if(raform_generalppehearing_yes.isChecked()) {
                        p.setgeneralppehearing("Yes");
                    } else if(raform_generalppehearing_no.isChecked()) {
                        p.setgeneralppehearing("No");
                    } else { p.setgeneralppehearing("N/A");}


                    if(raform_generalppegloves_yes.isChecked()) {
                        p.setgeneralppegloves("Yes");
                    } else if(raform_generalppegloves_no.isChecked()) {
                        p.setgeneralppegloves("No");
                    } else { p.setgeneralppegloves("N/A");}

                    if(raform_generalppedustoverall_yes.isChecked()) {
                        p.setgeneralppedustoverall("Yes");
                    } else if(raform_generalppedustoverall_no.isChecked()) {
                        p.setgeneralppedustoverall("No");
                    } else { p.setgeneralppedustoverall("N/A");}

                    if(raform_generalppehivis_yes.isChecked()) {
                        p.setgeneralppehivis("Yes");
                    } else if(raform_generalppehivis_no.isChecked()) {
                        p.setgeneralppehivis("No");
                    } else { p.setgeneralppehivis("N/A");}

                    if(raform_generalppehardhat_yes.isChecked()) {
                        p.setgeneralppehardhat("Yes");
                    } else if(raform_generalppehardhat_no.isChecked()) {
                        p.setgeneralppehardhat("No");
                    } else { p.setgeneralppehardhat("N/A");}

                    if(raform_generalppedustmask_yes.isChecked()) {
                        p.setgeneralppedustmask("Yes");
                    } else if(raform_generalppedustmask_no.isChecked()) {
                        p.setgeneralppedustmask("No");
                    } else { p.setgeneralppedustmask("N/A");}

                    p.setlocationlat(Double.toString(Locationlat));
                    p.setlocationlong(Double.toString(Locationlong));


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

    public void handleNewLocation(Location location) {

        System.out.println(location);

        Locationlat = location.getLatitude();
        Locationlong = location.getLongitude();

    }

}
