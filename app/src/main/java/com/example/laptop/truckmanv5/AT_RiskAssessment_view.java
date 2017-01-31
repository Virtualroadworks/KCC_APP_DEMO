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
    EditText at0013_3ck_nature_works_other_description;
    EditText at0013_3ck_hazard_tmp_comments;

    CoordinatorLayout cl;
    Button bOK,bCancel;
    int position;
    AT_RiskAssessment_model AT_RiskAssessment_model;

    private static final int GALLARY_INTENT = 2;
    private static final int CAMERA_REQUEST_CODE = 1;

    private ProgressDialog mProgressDialog;

    private StorageReference mStorage;

    ImageButton at0013_3takephoto;
    ImageButton at0013_3gallary;
    ImageButton at0013_3selectmap;


    CheckBox at0013_3ck_tony_robinson;
    CheckBox at0013_3ck_mark_dixon;
    CheckBox at0013_3ck_brian_byrne;
    CheckBox at0013_3ck_declan_byrne;
    CheckBox at0013_3ck_michael_mccormack;
    CheckBox at0013_3ck_david_mcasey;
    CheckBox at0013_3ck_eamonn_storey;
    CheckBox at0013_3ck_thomas_martin;
    CheckBox at0013_3ck_richard_gilligan;
    CheckBox at0013_3ck_noel_perry;
    CheckBox at0013_3ck_willie_harris;
    CheckBox at0013_3ck_kieran_fitzgerald;
    CheckBox at0013_3ck_mark_dalton;
    CheckBox at0013_3ck_william_burke;
    CheckBox at0013_3ck_martin_maher;
    CheckBox at0013_3ck_graham_mcloghlin;
    CheckBox at0013_3ck_christy_oreilly;
    CheckBox at0013_3ck_ritchie_kavanagh;
    CheckBox at0013_3ck_river_cleaning;
    CheckBox at0013_3ck_debris_removal;
    CheckBox at0013_3ck_screen_cleaning;
    CheckBox at0013_3ck_tree_cutting;
    CheckBox at0013_3ck_weir_maintenance;
    CheckBox at0013_3ck_river_dredging;
    CheckBox at0013_3ck_nature_works_other;
    LinearLayout at0013_3ck_nature_works_commentsbox;

    LinearLayout takephotolayout,selectgallerylayout;


    CheckBox at0013_3ck_safepass;
    CheckBox at0013_3ck_manual_handling;
    CheckBox at0013_3ck_water_awareness;
    CheckBox at0013_3ck_chainsaw;
    CheckBox at0013_3ck_tirfor_winch;
    CheckBox at0013_3ck_confined_space;
    CheckBox at0013_3ck_safety_footware;
    CheckBox at0013_3ck_high_vis_vest;
    CheckBox at0013_3ck_gloves;
    CheckBox at0013_3ck_safety_helmet;
    CheckBox at0013_3ck_ear_protection;
    CheckBox at0013_3ck_eye_protection;
    CheckBox at0013_3ck_life_jacket;
    CheckBox at0013_3ck_chainsaw_suit;
    CheckBox at0013_3ck_waders;
    CheckBox at0013_3ck_throw_bags;
    CheckBox at0013_3ck_life_line;
    CheckBox at0013_3ck_hazard_life_jacket;
    CheckBox at0013_3ck_hazard_throw_bags;
    CheckBox at0013_3ck_hazard_na;
    CheckBox at0013_3ck_river_bank_life_line;
    CheckBox at0013_3ck_river_bank_laddders;
    CheckBox at0013_3ck_river_bank_safety_footware;
    CheckBox at0013_3ck_river_bank_na;
    CheckBox at0013_3ck_hazard_yes;
    CheckBox at0013_3ck_hazard_no;
    CheckBox at0013_3ck_barrier_na;
    CheckBox at0013_3ck_hazard_hog_avoid;
    CheckBox at0013_3ck_hazard_hog_ppe;
    CheckBox at0013_3ck_hazard_hog_na;
    CheckBox at0013_3ck_hazard_hygine_ppe;
    CheckBox at0013_3ck_hazard_washing_facilities;
    CheckBox at0013_3ck_hazard_canteen;
    CheckBox at0013_3ck_hazard_clean_tools;
    CheckBox at0013_3ck_hazard_sharp_prevention_pack;
    CheckBox at0013_3ck_hazard_hygiene_na;
    CheckBox at0013_3ck_hazard_tmp_number;
    CheckBox at0013_3ck_hazard_tmp_na;
    LinearLayout at0013_3ck_hazard_tmp_number_box;

    String at0013_3pictureuri;
    String at0013_3picturepath;

    ///////////////////////////////////////////////////////////////////////////////////

    Boolean ratrafficicon100x100pressed = false;
    Boolean raworkingatheightsicon100x100pressed = false;


    ImageButton ratrafficicon100x100;
    ImageButton rappeicon100x100;
    ImageButton raroadsicon100x100;
    ImageButton rafootpathicon100x100;

    ImageButton raworkingatheightsicon100x100;

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

    FrameLayout framelayout_traffic;
    FrameLayout framelayout_workingatheights;

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

        raworkingatheightsicon100x100 = (ImageButton) findViewById(R.id.raworkingatheightsicon100x100);

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


        framelayout_traffic = (FrameLayout) findViewById(R.id.framelayout_traffic);
        framelayout_workingatheights = (FrameLayout) findViewById(R.id.framelayout_workingatheights);

        ///////////////////////////////////////////////////////////////////////////////////

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


        framelayout_traffic.setVisibility(LinearLayout.GONE);
        rafootpathicon100x100.setVisibility(LinearLayout.GONE);

        ///////////////////////////////////////////////////////////////////////////////////

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







        ///////////////////////////////////////////////////////////////////////////////////


        mStorage = FirebaseStorage.getInstance().getReference();

        mProgressDialog = new ProgressDialog(this);



        at0013_3takephoto = (ImageButton) findViewById(R.id.at0013_3takephoto);
        at0013_3gallary = (ImageButton) findViewById(R.id.at0013_3gallary);
        at0013_3selectmap = (ImageButton) findViewById(R.id.at0013_3selectmap);

        at0013_3ck_nature_works_other_description = (EditText) findViewById(R.id.at0013_3ck_nature_works_other_description);
        at0013_3ck_hazard_tmp_comments = (EditText) findViewById(R.id.at0013_3ck_hazard_tmp_comments);

        String date = getIntent().getStringExtra("Date");
        time_stamp.setText(getIntent().getStringExtra("Date"));

        position = getIntent().getIntExtra("Position", -1);

        cl = (CoordinatorLayout) findViewById(R.id.cdlayout);

        takephotolayout = (LinearLayout) findViewById(R.id.takephotolayout);
        selectgallerylayout = (LinearLayout) findViewById(R.id.selectgallerylayout);

        at0013_3ck_nature_works_commentsbox = (LinearLayout) findViewById(R.id.at0013_3ck_nature_works_commentsbox);
        at0013_3ck_hazard_tmp_number_box = (LinearLayout) findViewById(R.id.at0013_3ck_hazard_tmp_number_box);

        at0013_3ck_nature_works_commentsbox.setVisibility(LinearLayout.GONE);
        at0013_3ck_hazard_tmp_number_box.setVisibility(LinearLayout.GONE);



        at0013_3ck_tony_robinson = (CheckBox) findViewById(R.id.at0013_3ck_tony_robinson);
        at0013_3ck_mark_dixon = (CheckBox) findViewById(R.id.at0013_3ck_mark_dixon);
        at0013_3ck_brian_byrne = (CheckBox) findViewById(R.id.at0013_3ck_brian_byrne);
        at0013_3ck_declan_byrne = (CheckBox) findViewById(R.id.at0013_3ck_declan_byrne);
        at0013_3ck_michael_mccormack = (CheckBox) findViewById(R.id.at0013_3ck_michael_mccormack);
        at0013_3ck_david_mcasey = (CheckBox) findViewById(R.id.at0013_3ck_david_mcasey);
        at0013_3ck_eamonn_storey = (CheckBox) findViewById(R.id.at0013_3ck_eamonn_storey);
        at0013_3ck_thomas_martin = (CheckBox) findViewById(R.id.at0013_3ck_thomas_martin);
        at0013_3ck_richard_gilligan = (CheckBox) findViewById(R.id.at0013_3ck_richard_gilligan);
        at0013_3ck_noel_perry = (CheckBox) findViewById(R.id.at0013_3ck_noel_perry);
        at0013_3ck_willie_harris = (CheckBox) findViewById(R.id.at0013_3ck_willie_harris);
        at0013_3ck_kieran_fitzgerald = (CheckBox) findViewById(R.id.at0013_3ck_kieran_fitzgerald);
        at0013_3ck_mark_dalton = (CheckBox) findViewById(R.id.at0013_3ck_mark_dalton);
        at0013_3ck_william_burke = (CheckBox) findViewById(R.id.at0013_3ck_william_burke);
        at0013_3ck_martin_maher = (CheckBox) findViewById(R.id.at0013_3ck_martin_maher);
        at0013_3ck_graham_mcloghlin = (CheckBox) findViewById(R.id.at0013_3ck_graham_mcloghlin);
        at0013_3ck_christy_oreilly = (CheckBox) findViewById(R.id.at0013_3ck_christy_oreilly);
        at0013_3ck_ritchie_kavanagh = (CheckBox) findViewById(R.id.at0013_3ck_ritchie_kavanagh);
        at0013_3ck_river_cleaning = (CheckBox) findViewById(R.id.at0013_3ck_river_cleaning);
        at0013_3ck_debris_removal = (CheckBox) findViewById(R.id.at0013_3ck_debris_removal);
        at0013_3ck_screen_cleaning = (CheckBox) findViewById(R.id.at0013_3ck_screen_cleaning);
        at0013_3ck_tree_cutting = (CheckBox) findViewById(R.id.at0013_3ck_tree_cutting);
        at0013_3ck_weir_maintenance = (CheckBox) findViewById(R.id.at0013_3ck_weir_maintenance);
        at0013_3ck_river_dredging = (CheckBox) findViewById(R.id.at0013_3ck_river_dredging);
        at0013_3ck_nature_works_other = (CheckBox) findViewById(R.id.at0013_3ck_nature_works_other);


        at0013_3ck_safepass = (CheckBox) findViewById(R.id.at0013_3ck_safepass);
        at0013_3ck_manual_handling = (CheckBox) findViewById(R.id.at0013_3ck_manual_handling);
        at0013_3ck_water_awareness = (CheckBox) findViewById(R.id.at0013_3ck_water_awareness);
        at0013_3ck_chainsaw = (CheckBox) findViewById(R.id.at0013_3ck_chainsaw);
        at0013_3ck_tirfor_winch = (CheckBox) findViewById(R.id.at0013_3ck_tirfor_winch);
        at0013_3ck_confined_space = (CheckBox) findViewById(R.id.at0013_3ck_confined_space);
        at0013_3ck_safety_footware = (CheckBox) findViewById(R.id.at0013_3ck_safety_footware);
        at0013_3ck_high_vis_vest = (CheckBox) findViewById(R.id.at0013_3ck_high_vis_vest);
        at0013_3ck_gloves = (CheckBox) findViewById(R.id.at0013_3ck_gloves);
        at0013_3ck_safety_helmet = (CheckBox) findViewById(R.id.at0013_3ck_safety_helmet);
        at0013_3ck_ear_protection = (CheckBox) findViewById(R.id.at0013_3ck_ear_protection);
        at0013_3ck_eye_protection = (CheckBox) findViewById(R.id.at0013_3ck_eye_protection);
        at0013_3ck_life_jacket = (CheckBox) findViewById(R.id.at0013_3ck_life_jacket);
        at0013_3ck_chainsaw_suit = (CheckBox) findViewById(R.id.at0013_3ck_chainsaw_suit);
        at0013_3ck_waders = (CheckBox) findViewById(R.id.at0013_3ck_waders);
        at0013_3ck_throw_bags = (CheckBox) findViewById(R.id.at0013_3ck_throw_bags);
        at0013_3ck_life_line = (CheckBox) findViewById(R.id.at0013_3ck_life_line);
        at0013_3ck_hazard_life_jacket = (CheckBox) findViewById(R.id.at0013_3ck_hazard_life_jacket);
        at0013_3ck_hazard_throw_bags = (CheckBox) findViewById(R.id.at0013_3ck_hazard_throw_bags);
        at0013_3ck_hazard_na = (CheckBox) findViewById(R.id.at0013_3ck_hazard_na);
        at0013_3ck_river_bank_life_line = (CheckBox) findViewById(R.id.at0013_3ck_river_bank_life_line);
        at0013_3ck_river_bank_laddders = (CheckBox) findViewById(R.id.at0013_3ck_river_bank_laddders);
        at0013_3ck_river_bank_safety_footware = (CheckBox) findViewById(R.id.at0013_3ck_river_bank_safety_footware);
        at0013_3ck_river_bank_na = (CheckBox) findViewById(R.id.at0013_3ck_river_bank_na);
        at0013_3ck_hazard_yes = (CheckBox) findViewById(R.id.at0013_3ck_hazard_yes);
        at0013_3ck_hazard_no = (CheckBox) findViewById(R.id.at0013_3ck_hazard_no);
        at0013_3ck_barrier_na = (CheckBox) findViewById(R.id.at0013_3ck_barrier_na);
        at0013_3ck_hazard_hog_avoid = (CheckBox) findViewById(R.id.at0013_3ck_hazard_hog_avoid);
        at0013_3ck_hazard_hog_ppe = (CheckBox) findViewById(R.id.at0013_3ck_hazard_hog_ppe);
        at0013_3ck_hazard_hog_na = (CheckBox) findViewById(R.id.at0013_3ck_hazard_hog_na);
        at0013_3ck_hazard_hygine_ppe = (CheckBox) findViewById(R.id.at0013_3ck_hazard_hygine_ppe);
        at0013_3ck_hazard_washing_facilities = (CheckBox) findViewById(R.id.at0013_3ck_hazard_washing_facilities);
        at0013_3ck_hazard_canteen = (CheckBox) findViewById(R.id.at0013_3ck_hazard_canteen);
        at0013_3ck_hazard_clean_tools = (CheckBox) findViewById(R.id.at0013_3ck_hazard_clean_tools);
        at0013_3ck_hazard_sharp_prevention_pack = (CheckBox) findViewById(R.id.at0013_3ck_hazard_sharp_prevention_pack);
        at0013_3ck_hazard_hygiene_na = (CheckBox) findViewById(R.id.at0013_3ck_hazard_hygiene_na);
        at0013_3ck_hazard_tmp_number = (CheckBox) findViewById(R.id.at0013_3ck_hazard_tmp_number);
        at0013_3ck_hazard_tmp_na = (CheckBox) findViewById(R.id.at0013_3ck_hazard_tmp_na);

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

        at0013_3ck_nature_works_other.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                                     @Override
                                                                     public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                                         at0013_3ck_nature_works_commentsbox.setVisibility(LinearLayout.VISIBLE);
                                                                     }
                                                                 }
        );
        at0013_3ck_hazard_tmp_number.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                                    @Override
                                                                    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                                        at0013_3ck_hazard_tmp_number_box.setVisibility(LinearLayout.VISIBLE);
                                                                    }
                                                                }
        );

        raform_trafficppe_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_trafficppe_yes.isChecked()) {
                    raform_trafficppe_yes.setChecked(true);
                    raform_trafficppe_no.setChecked(false);
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
                    raform_trafficroads.setChecked(true);
                    raform_trafficfootpath.setChecked(false);
                    raroadsicon100x100.setVisibility(LinearLayout.VISIBLE);
                    rafootpathicon100x100.setVisibility(LinearLayout.GONE);
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
                    raform_traffictmpguidelines_yes.setChecked(true);
                    raform_traffictmpguidelines_no.setChecked(false);
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
                    raform_trafficbeacon_yes.setChecked(true);
                    raform_trafficbeacon_no.setChecked(false);
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
                    raform_trafficleftsite_yes.setChecked(true);
                    raform_trafficleftsite_no.setChecked(false);
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

        raform_trafficfallsystem_yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (raform_trafficfallsystem_yes.isChecked()) {
                    raform_trafficfallsystem_yes.setChecked(true);
                    raform_trafficfallsystem_no.setChecked(false);
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

                    ///////////////////////////////////////Store Strings/////////////////////////////////////////////////
                    p.setat0013_3pictureuri(at0013_3pictureuri);
                    p.setat0013_3picturepath(at0013_3picturepath);
                    ///////////////////////////////////////1 Section 1 Location/////////////////////////////////////////////////


///////////////////////////////////////1 Section 1 Location/////////////////////////////////////////////////
                    if(raform_trafficppe_yes.isChecked()) {
                        p.setraform_trafficppe_yes("Yes");
                    }
                    else {
                        p.setraform_trafficppe_yes("No");
                    }

                    if(raform_trafficppe_no.isChecked()) {
                        p.setraform_trafficppe_no("Yes");
                    }
                    else {
                        p.setraform_trafficppe_no("No");
                    }

                    if(raform_trafficroads.isChecked()) {
                        p.setraform_trafficroads("Yes");
                    }
                    else {
                        p.setraform_trafficroads("No");
                    }

                    if(raform_trafficfootpath.isChecked()) {
                        p.setraform_trafficfootpath("Yes");
                    }
                    else {
                        p.setraform_trafficfootpath("No");
                    }
                    if(raform_traffictmpguidelines_yes.isChecked()) {
                        p.setraform_traffictmpguidelines_yes("Yes");
                    }
                    else {
                        p.setraform_traffictmpguidelines_yes("No");
                    }

                    if(raform_traffictmpguidelines_no.isChecked()) {
                        p.setraform_traffictmpguidelines_no("Yes");
                    }
                    else {
                        p.setraform_traffictmpguidelines_no("No");
                    }

                    if(raform_trafficbeacon_yes.isChecked()) {
                        p.setraform_trafficbeacon_yes("Yes");
                    }
                    else {
                        p.setraform_trafficbeacon_yes("No");
                    }
                    if(raform_trafficbeacon_no.isChecked()) {
                        p.setraform_trafficbeacon_no("Yes");
                    }
                    else {
                        p.setraform_trafficbeacon_no("No");
                    }
                    if(raform_trafficleftsite_yes.isChecked()) {
                        p.setraform_trafficleftsite_yes("Yes");
                    }
                    else {
                        p.setraform_trafficleftsite_yes("No");
                    }
                    if(raform_trafficleftsite_no.isChecked()) {
                        p.setraform_trafficleftsite_no("Yes");
                    }
                    else {
                        p.setraform_trafficleftsite_no("No");
                    }
                    if(raform_trafficfallsystem_yes.isChecked()) {
                        p.setraform_trafficfallsystem_yes("Yes");
                    }
                    else {
                        p.setraform_trafficfallsystem_yes("No");
                    }
                    if(raform_trafficfallsystem_no.isChecked()) {
                        p.setraform_trafficfallsystem_no("Yes");
                    }
                    else {
                        p.setraform_trafficfallsystem_no("No");
                    }

                    ///////////////////////////////////////1 Section 1 Location/////////////////////////////////////////////////

                    if(at0013_3ck_tony_robinson.isChecked()) {
                        p.setat0013_3ck_tony_robinson("Yes");
                    }
                    else {
                        p.setat0013_3ck_tony_robinson("No");
                    }
                    if(at0013_3ck_mark_dixon.isChecked()) {
                        p.setat0013_3ck_mark_dixon("Yes");
                    }
                    else {
                        p.setat0013_3ck_mark_dixon("No");
                    }
                    if(at0013_3ck_brian_byrne.isChecked()) {
                        p.setat0013_3ck_brian_byrne("Yes");
                    }
                    else {
                        p.setat0013_3ck_brian_byrne("No");
                    }
                    if(at0013_3ck_declan_byrne.isChecked()) {

                        p.setat0013_3ck_declan_byrne("Yes");
                    }
                    else {
                        p.setat0013_3ck_declan_byrne("No");
                    }
                    if(at0013_3ck_michael_mccormack.isChecked()) {
                        p.setat0013_3ck_michael_mccormack("Yes");
                    }
                    else {
                        p.setat0013_3ck_michael_mccormack("No");
                    }
                    if(at0013_3ck_david_mcasey.isChecked()) {
                        p.setat0013_3ck_david_mcasey("Yes");
                    }
                    else {
                        p.setat0013_3ck_david_mcasey("No");
                    }
                    if(at0013_3ck_eamonn_storey.isChecked()) {
                        p.setat0013_3ck_eamonn_storey("Yes");
                    }
                    else {
                        p.setat0013_3ck_eamonn_storey("No");
                    }
                    if(at0013_3ck_thomas_martin.isChecked()) {
                        p.setat0013_3ck_thomas_martin("Yes");
                    }
                    else {
                        p.setat0013_3ck_thomas_martin("No");
                    }
                    if(at0013_3ck_richard_gilligan.isChecked()) {
                        p.setat0013_3ck_richard_gilligan("Yes");
                    }
                    else {
                        p.setat0013_3ck_richard_gilligan("No");
                    }
                    if(at0013_3ck_noel_perry.isChecked()) {
                        p.setat0013_3ck_noel_perry("Yes");
                    }
                    else {
                        p.setat0013_3ck_noel_perry("No");
                    }
                    if(at0013_3ck_willie_harris.isChecked()) {
                        p.setat0013_3ck_willie_harris("Yes");
                    }
                    else {
                        p.setat0013_3ck_willie_harris("No");
                    }
                    if(at0013_3ck_kieran_fitzgerald.isChecked()) {
                        p.setat0013_3ck_kieran_fitzgerald("Yes");
                    }
                    else {
                        p.setat0013_3ck_kieran_fitzgerald("No");
                    }
                    if(at0013_3ck_mark_dalton.isChecked()) {
                        p.setat0013_3ck_mark_dalton("Yes");
                    }
                    else {
                        p.setat0013_3ck_mark_dalton("No");
                    }
                    if(at0013_3ck_william_burke.isChecked()) {
                        p.setat0013_3ck_william_burke("Yes");
                    }
                    else {
                        p.setat0013_3ck_william_burke("No");
                    }
                    if(at0013_3ck_martin_maher.isChecked()) {

                        p.setat0013_3ck_martin_maher("Yes");
                    }
                    else {
                        p.setat0013_3ck_martin_maher("No");
                    }
                    if(at0013_3ck_graham_mcloghlin.isChecked()) {
                        p.setat0013_3ck_graham_mcloghlin("Yes");
                    }
                    else {
                        p.setat0013_3ck_graham_mcloghlin("No");
                    }
                    if(at0013_3ck_christy_oreilly.isChecked()) {
                        p.setat0013_3ck_christy_oreilly("Yes");
                    }
                    else {
                        p.setat0013_3ck_christy_oreilly("No");
                    }
                    if(at0013_3ck_ritchie_kavanagh.isChecked()) {
                        p.setat0013_3ck_ritchie_kavanagh("Yes");
                    }
                    else {
                        p.setat0013_3ck_ritchie_kavanagh("No");
                    }

                    ///////////////////////////////////////2 Section 1 Nature of Works/////////////////////////////////////////////////

                    if(at0013_3ck_river_cleaning.isChecked()) {
                        p.setat0013_3ck_river_cleaning("Yes");
                    }
                    else {
                        p.setat0013_3ck_river_cleaning("No");
                    }
                    if(at0013_3ck_debris_removal.isChecked()) {
                        p.setat0013_3ck_debris_removal("Yes");
                    }
                    else {
                        p.setat0013_3ck_debris_removal("No");
                    }
                    if(at0013_3ck_screen_cleaning.isChecked()) {
                        p.setat0013_3ck_screen_cleaning("Yes");
                    }
                    else {
                        p.setat0013_3ck_screen_cleaning("No");
                    }
                    if(at0013_3ck_tree_cutting.isChecked()) {
                        p.setat0013_3ck_tree_cutting("Yes");
                    }
                    else {
                        p.setat0013_3ck_tree_cutting("No");
                    }
                    if(at0013_3ck_weir_maintenance.isChecked()) {
                        p.setat0013_3ck_weir_maintenance("Yes");
                    }
                    else {
                        p.setat0013_3ck_weir_maintenance("No");
                    }
                    if(at0013_3ck_river_dredging.isChecked()) {
                        p.setat0013_3ck_river_dredging("Yes");
                    }
                    else {
                        p.setat0013_3ck_river_dredging("No");
                    }
                    if(at0013_3ck_nature_works_other.isChecked()) {
                        p.setat0013_3ck_nature_works_other("Yes");
                    }
                    else {
                        p.setat0013_3ck_nature_works_other("No");
                    }

                    p.setat0013_3ck_nature_works_other_description(at0013_3ck_nature_works_other_description.getText().toString());

                    ///////////////////////////////////////2 Section 2 Are personnel trained/////////////////////////////////////////////////

                    if(at0013_3ck_safepass.isChecked()) {
                        p.setat0013_3ck_safepass("Yes");
                    }
                    else {
                        p.setat0013_3ck_safepass("No");
                    }
                    if(at0013_3ck_manual_handling.isChecked()) {
                        p.setat0013_3ck_manual_handling("Yes");
                    }
                    else {
                        p.setat0013_3ck_manual_handling("No");
                    }
                    if(at0013_3ck_water_awareness.isChecked()) {
                        p.setat0013_3ck_water_awareness("Yes");
                    }
                    else {
                        p.setat0013_3ck_water_awareness("No");
                    }
                    if(at0013_3ck_chainsaw.isChecked()) {
                        p.setat0013_3ck_chainsaw("Yes");
                    }
                    else {
                        p.setat0013_3ck_chainsaw("No");
                    }
                    if(at0013_3ck_tirfor_winch.isChecked()) {
                        p.setat0013_3ck_tirfor_winch("Yes");
                    }
                    else {
                        p.setat0013_3ck_tirfor_winch("No");
                    }
                    if(at0013_3ck_confined_space.isChecked()) {
                        p.setat0013_3ck_confined_space("Yes");
                    }
                    else {
                        p.setat0013_3ck_confined_space("No");
                    }

                    ///////////////////////////////////////2 Section 3 Personal Protective Equipement Required/////////////////////////////////////////////////
                    if(at0013_3ck_safety_footware.isChecked()) {
                        p.setat0013_3ck_safety_footware("Yes");
                    }
                    else {
                        p.setat0013_3ck_safety_footware("No");
                    }
                    if(at0013_3ck_high_vis_vest.isChecked()) {
                        p.setat0013_3ck_high_vis_vest("Yes");
                    }
                    else {
                        p.setat0013_3ck_high_vis_vest("No");
                    }
                    if(at0013_3ck_gloves.isChecked()) {
                        p.setat0013_3ck_gloves("Yes");
                    }
                    else {
                        p.setat0013_3ck_gloves("No");
                    }
                    if(at0013_3ck_safety_helmet.isChecked()) {
                        p.setat0013_3ck_safety_helmet("Yes");
                    }
                    else {
                        p.setat0013_3ck_safety_helmet("No");
                    }
                    if(at0013_3ck_ear_protection.isChecked()) {
                        p.setat0013_3ck_ear_protection("Yes");
                    }
                    else {
                        p.setat0013_3ck_ear_protection("No");
                    }
                    if(at0013_3ck_eye_protection.isChecked()) {
                        p.setat0013_3ck_eye_protection("Yes");
                    }
                    else {
                        p.setat0013_3ck_eye_protection("No");
                    }
                    if(at0013_3ck_life_jacket.isChecked()) {
                        p.setat0013_3ck_life_jacket("Yes");
                    }
                    else {
                        p.setat0013_3ck_life_jacket("No");
                    }
                    if(at0013_3ck_chainsaw_suit.isChecked()) {
                        p.setat0013_3ck_chainsaw_suit("Yes");
                    }
                    else {
                        p.setat0013_3ck_chainsaw_suit("No");
                    }
                    if(at0013_3ck_waders.isChecked()) {
                        p.setat0013_3ck_waders("Yes");
                    }
                    else {
                        p.setat0013_3ck_waders("No");
                    }
                    if(at0013_3ck_throw_bags.isChecked()) {
                        p.setat0013_3ck_throw_bags("Yes");
                    }
                    else {
                        p.setat0013_3ck_throw_bags("No");
                    }
                    ///////////////////////////////////////3 Section 1 Hazard and Controls/////////////////////////////////////////////////


                    if(at0013_3ck_life_line.isChecked()) {
                        p.setat0013_3ck_life_line("Yes");
                    }
                    else {
                        p.setat0013_3ck_life_line("No");
                    }
                    if(at0013_3ck_hazard_life_jacket.isChecked()) {
                        p.setat0013_3ck_hazard_life_jacket("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_life_jacket("No");
                    }
                    if(at0013_3ck_hazard_throw_bags.isChecked()) {
                        p.setat0013_3ck_hazard_throw_bags("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_throw_bags("No");
                    }
                    if(at0013_3ck_hazard_na.isChecked()) {
                        p.setat0013_3ck_hazard_na("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_na("No");
                    }
                    if(at0013_3ck_river_bank_life_line.isChecked()) {
                        p.setat0013_3ck_river_bank_life_line("Yes");
                    }
                    else {
                        p.setat0013_3ck_river_bank_life_line("No");
                    }
                    if(at0013_3ck_river_bank_laddders.isChecked()) {
                        p.setat0013_3ck_river_bank_laddders("Yes");
                    }
                    else {
                        p.setat0013_3ck_river_bank_laddders("No");
                    }
                    if(at0013_3ck_river_bank_safety_footware.isChecked()) {
                        p.setat0013_3ck_river_bank_safety_footware("Yes");
                    }
                    else {
                        p.setat0013_3ck_river_bank_safety_footware("No");
                    }
                    if(at0013_3ck_river_bank_na.isChecked()) {
                        p.setat0013_3ck_river_bank_na("Yes");
                    }
                    else {
                        p.setat0013_3ck_river_bank_na("No");
                    }
                    if(at0013_3ck_hazard_yes.isChecked()) {
                        p.setat0013_3ck_hazard_yes("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_yes("No");
                    }
                    if(at0013_3ck_hazard_no.isChecked()) {
                        p.setat0013_3ck_hazard_no("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_no("No");
                    }
                    if(at0013_3ck_barrier_na.isChecked()) {
                        p.setat0013_3ck_barrier_na("Yes");
                    }
                    else {
                        p.setat0013_3ck_barrier_na("No");
                    }
                    if(at0013_3ck_hazard_hog_avoid.isChecked()) {
                        p.setat0013_3ck_hazard_hog_avoid("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_hog_avoid("No");
                    }
                    if(at0013_3ck_hazard_hog_ppe.isChecked()) {
                        p.setat0013_3ck_hazard_hog_ppe("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_hog_ppe("No");
                    }
                    if(at0013_3ck_hazard_hog_na.isChecked()) {
                        p.setat0013_3ck_hazard_hog_na("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_hog_na("No");
                    }
                    if(at0013_3ck_hazard_hygine_ppe.isChecked()) {
                        p.setat0013_3ck_hazard_hygine_ppe("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_hygine_ppe("No");
                    }
                    if(at0013_3ck_hazard_washing_facilities.isChecked()) {
                        p.setat0013_3ck_hazard_washing_facilities("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_washing_facilities("No");
                    }
                    if(at0013_3ck_hazard_canteen.isChecked()) {
                        p.setat0013_3ck_hazard_canteen("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_canteen("No");
                    }
                    if(at0013_3ck_hazard_clean_tools.isChecked()) {
                        p.setat0013_3ck_hazard_clean_tools("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_clean_tools("No");
                    }
                    if(at0013_3ck_hazard_sharp_prevention_pack.isChecked()) {
                        p.setat0013_3ck_hazard_sharp_prevention_pack("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_sharp_prevention_pack("No");
                    }
                    if(at0013_3ck_hazard_hygiene_na.isChecked()) {
                        p.setat0013_3ck_hazard_hygiene_na("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_hygiene_na("No");
                    }
                    if(at0013_3ck_hazard_tmp_number.isChecked()) {
                        p.setat0013_3ck_hazard_tmp_number("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_tmp_number("No");
                    }
                    p.setat0013_3ck_hazard_tmp_comments(at0013_3ck_hazard_tmp_comments.getText().toString());

                    if(at0013_3ck_hazard_tmp_na.isChecked()) {
                        p.setat0013_3ck_hazard_tmp_na("Yes");
                    }
                    else {
                        p.setat0013_3ck_hazard_tmp_na("No");
                    }

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

        AT_RiskAssessment_database.getInstance().getmDatabase().child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT RiskAssessment Form").child(clickedKey).addListenerForSingleValueEvent(
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
