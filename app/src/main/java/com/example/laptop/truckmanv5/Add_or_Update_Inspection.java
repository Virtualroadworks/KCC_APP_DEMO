package com.example.laptop.truckmanv5;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.location.Geocoder;
import android.location.Location;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;


public class Add_or_Update_Inspection extends AppCompatActivity implements Popup_WAM.DefectRecordedListener, UserLocation.LocationCallback {

    MediaPlayer mp;
    Button bOK,bCancel,vehiclephoto;
    Person person;
    int position;
    EditText pReg;
    CoordinatorLayout cl;

    boolean internet_connected;
    TextView Onlinetext;
    ImageView onlineimage;

    private StorageReference mStorage;


    private static final int GALLARY_INTENT25 = 49;
    private static final int CAMERA_REQUEST_CODE25= 50;

    ProgressBar prg;

    private ProgressDialog mProgressDialog;

    Button outsideinspectionhidebutton,outsideinspectionshowbutton;
    Button insideinspectionhidebutton,insideinspectionshowbutton;
    Button drivinginspectionhidebutton,drivinginspectionshowbutton;

    ///New Database links (2 go in here)
    TextView winmirtempfixfill,winmirdescribedefectfill;
    TextView seatbelttempfixfill,seatbeltdescribedefectfill;
    TextView washerandwipertempfixfill,washerandwiperdescribedefectfill;
    TextView horntempfixfill,horndescribedefectfill;
    TextView breakwarninglighttempfixfill,breakwarninglightdescribedefectfill;
    TextView gaugetempfixfill,gaugedescribedefectfill;
    TextView tachotempfixfill,tachodescribedefectfill;
    TextView airleakstempfixfill,airleaksdescribedefectfill;
    //Driving Inspection
    TextView steeringbreakingtempfixfill,steeringbreakingdescribedefectfill;
    TextView loadsecuretempfixfill,loadsecuredescribedefectfill;
    TextView tachospeedotempfixfill,tachospeedodescribedefectfill;
    TextView nowarninglightstempfixfill,nowarninglightsdescribedefectfill;
    //Outside Inspection
    TextView taxinsurancetempfixfill,taxinsurancedescribedefectfill;
    TextView wheelstyrestempfixfill,wheelstyresdescribedefectfill;
    TextView lightsreflectorstempfixfill,lightsreflectorsdescribedefectfill;
    TextView exhausttempfixfill,exhaustdescribedefectfill;
    TextView sparetowtempfixfill,sparetowdescribedefectfill;
    TextView trailerbraketempfixfill,trailerbrakedescribedefectfill;
    TextView bodyguardstempfixfill,bodyguardsdescribedefectfill;
    TextView landinglegtempfixfill,landinglegdescribedefectfill;
    TextView regplatetempfixfill,regplatedescribedefectfill;
    TextView fluidleakstempfixfill,fluidleaksdescribedefectfill;
    TextView airelectrialtempfixfill,airelectrialdescribedefectfill;
    TextView airsuspensiontempfixfill,airsuspensiondescribedefectfill;

    ////////////////////////////////////////////////////////////////////////////////////////////


    LinearLayout taxandinsurancewholebox;
    LinearLayout regplatewholebox;
    LinearLayout airandelectrialwholebox;
    LinearLayout fluidleakswholebox;
    LinearLayout airsuspensionwholebox;
    LinearLayout wheelsandtyreswholebox;
    LinearLayout lightsreflectorswholebox;
    LinearLayout exhaustwholebox;
    LinearLayout bodyguardswholebox;
    LinearLayout landinglegwholebox;
    LinearLayout sparetowwholebox;
    LinearLayout trailerbrakewholebox;

    LinearLayout windowsandmirrorswholebox;
    LinearLayout seatbeltwholebox;
    LinearLayout washerandwiperwholebox;
    LinearLayout hornwholebox;
    LinearLayout breakwarninglightwholebox;
    LinearLayout gaugewholebox;
    LinearLayout tachowholebox;
    LinearLayout airleakswholebox;

    LinearLayout steeringbreakingwholebox;
    LinearLayout loadsecurewholebox;
    LinearLayout tachospeedowholebox;
    LinearLayout nowarninglightswholebox;


    //<<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    TextView user_name,user_email,etreport_email_recipient,user_company,user_contact_number;

    TextView time_stamp;

    // Checks Defects and Fixs Title (2 go in here)
    TextView windows_and_mirrors_describe_defect_text_view;
    TextView windows_and_mirrors_describe_tempfix_text_view;
    TextView seatbelt_describe_defect_text_view;
    TextView seatbelt_describe_tempfix_text_view;
    TextView washerandwiper_describe_defect_text_view;
    TextView washerandwiper_describe_tempfix_text_view;
    TextView horn_describe_defect_text_view;
    TextView horn_describe_tempfix_text_view;
    TextView breakwarninglight_describe_defect_text_view;
    TextView breakwarninglight_describe_tempfix_text_view;
    TextView gauge_describe_defect_text_view;
    TextView gauge_describe_tempfix_text_view;
    TextView tacho_describe_defect_text_view;
    TextView tacho_describe_tempfix_text_view;
    TextView airleaks_describe_defect_text_view;
    TextView airleaks_describe_tempfix_text_view;
    //Driving Inspection
    TextView steeringbreaking_describe_defect_text_view;
    TextView steeringbreaking_describe_tempfix_text_view;
    TextView loadsecure_describe_defect_text_view;
    TextView loadsecure_describe_tempfix_text_view;
    TextView tachospeedo_describe_defect_text_view;
    TextView tachospeedo_describe_tempfix_text_view;
    TextView nowarninglights_describe_defect_text_view;
    TextView nowarninglights_describe_tempfix_text_view;
    //Outside Inspection
    TextView taxinsurance_describe_defect_text_view;
    TextView taxinsurance_describe_tempfix_text_view;
    TextView wheelstyres_describe_defect_text_view;
    TextView wheelstyres_describe_tempfix_text_view;
    TextView lightsreflectors_describe_defect_text_view;
    TextView lightsreflectors_describe_tempfix_text_view;
    TextView exhaust_describe_defect_text_view;
    TextView exhaust_describe_tempfix_text_view;
    TextView sparetow_describe_defect_text_view;
    TextView sparetow_describe_tempfix_text_view;
    TextView trailerbrake_describe_defect_text_view;
    TextView trailerbrake_describe_tempfix_text_view;
    TextView bodyguards_describe_defect_text_view;
    TextView bodyguards_describe_tempfix_text_view;
    TextView landingleg_describe_defect_text_view;
    TextView landingleg_describe_tempfix_text_view;
    TextView regplate_describe_defect_text_view;
    TextView regplate_describe_tempfix_text_view;
    TextView fluidleaks_describe_defect_text_view;
    TextView fluidleaks_describe_tempfix_text_view;
    TextView airelectrial_describe_defect_text_view;
    TextView airelectrial_describe_tempfix_text_view;
    TextView airsuspension_describe_defect_text_view;
    TextView airsuspension_describe_tempfix_text_view;

    //Imagebutton Icons (1 go in here)
    ImageButton windowsandmirrors_icon_image;
    ImageButton seatbelt_icon_image;
    ImageButton washerandwiper_icon_image;
    ImageButton horn_icon_image;
    ImageButton breakwarninglight_icon_image;
    ImageButton gauge_icon_image;
    ImageButton tacho_icon_image;
    ImageButton airleaks_icon_image;
    //Driving Inspection
    ImageButton steeringbreaking_icon_image;
    ImageButton loadsecure_icon_image;
    ImageButton tachospeedo_icon_image;
    ImageButton nowarninglights_icon_image;
    //Outside Inspection
    ImageButton taxinsurance_icon_image;
    ImageButton wheelstyres_icon_image;
    ImageButton lightsreflectors_icon_image;
    ImageButton exhaust_icon_image;
    ImageButton sparetow_icon_image;
    ImageButton trailerbrake_icon_image;
    ImageButton bodyguards_icon_image;
    ImageButton landingleg_icon_image;
    ImageButton regplate_icon_image;
    ImageButton fluidleaks_icon_image;
    ImageButton airelectrial_icon_image;
    ImageButton airsuspension_icon_image;

    ImageButton locationbutton;


    //Image Default and tick Buttons (2 go in here)
    ImageButton windowsandmirrors_inspect_button_defect;
    ImageButton windowsandmirrors_inspect_button_tick_defect;
    ImageButton seatbelt_inspect_button_defect;
    ImageButton seatbelt_inspect_button_tick_defect;
    ImageButton washerandwiper_inspect_button_defect;
    ImageButton washerandwiper_inspect_button_tick_defect;
    ImageButton horn_inspect_button_defect;
    ImageButton horn_inspect_button_tick_defect;
    ImageButton breakwarninglight_inspect_button_defect;
    ImageButton breakwarninglight_inspect_button_tick_defect;
    ImageButton gauge_inspect_button_defect;
    ImageButton gauge_inspect_button_tick_defect;
    ImageButton tacho_inspect_button_defect;
    ImageButton tacho_inspect_button_tick_defect;
    ImageButton airleaks_inspect_button_defect;
    ImageButton airleaks_inspect_button_tick_defect;
    //Driving Inspection
    ImageButton steeringbreaking_inspect_button_defect;
    ImageButton steeringbreaking_inspect_button_tick_defect;
    ImageButton loadsecure_inspect_button_defect;
    ImageButton loadsecure_inspect_button_tick_defect;
    ImageButton tachospeedo_inspect_button_defect;
    ImageButton tachospeedo_inspect_button_tick_defect;
    ImageButton nowarninglights_inspect_button_defect;
    ImageButton nowarninglights_inspect_button_tick_defect;
    //Outside Inspection
    ImageButton taxinsurance_inspect_button_defect;
    ImageButton taxinsurance_inspect_button_tick_defect;
    ImageButton wheelstyres_inspect_button_defect;
    ImageButton wheelstyres_inspect_button_tick_defect;
    ImageButton lightsreflectors_inspect_button_defect;
    ImageButton lightsreflectors_inspect_button_tick_defect;
    ImageButton exhaust_inspect_button_defect;
    ImageButton exhaust_inspect_button_tick_defect;
    ImageButton sparetow_inspect_button_defect;
    ImageButton sparetow_inspect_button_tick_defect;
    ImageButton trailerbrake_inspect_button_defect;
    ImageButton trailerbrake_inspect_button_tick_defect;
    ImageButton bodyguards_inspect_button_defect;
    ImageButton bodyguards_inspect_button_tick_defect;
    ImageButton landingleg_inspect_button_defect;
    ImageButton landingleg_inspect_button_tick_defect;
    ImageButton regplate_inspect_button_defect;
    ImageButton regplate_inspect_button_tick_defect;
    ImageButton fluidleaks_inspect_button_defect;
    ImageButton fluidleaks_inspect_button_tick_defect;
    ImageButton airelectrial_inspect_button_defect;
    ImageButton airelectrial_inspect_button_tick_defect;
    ImageButton airsuspension_inspect_button_defect;
    ImageButton airsuspension_inspect_button_tick_defect;


    ImageButton taxinsurance_backbutton_defect;
    ImageButton regplate_backbutton_defect;
    ImageButton airelectrial_backbutton_defect;
    ImageButton fluidleaks_backbutton_defect;
    ImageButton airsuspension_backbutton_defect;
    ImageButton wheelsandtyres_backbutton_defect;
    ImageButton lightsreflectors_backbutton_defect;
    ImageButton exhaust_backbutton_defect;
    ImageButton bodyguards_backbutton_defect;
    ImageButton landingleg_backbutton_defect;
    ImageButton sparetow_backbutton_defect;
    ImageButton trailerbrake_backbutton_defect;
    ImageButton windowsandmirrors_backbutton_defect;
    ImageButton seatbelt_backbutton_defect;
    ImageButton washerandwiper_backbutton_defect;
    ImageButton horn_backbutton_defect;
    ImageButton breakwarninglight_backbutton_defect;
    ImageButton gauge_backbutton_defect;
    ImageButton tacho_backbutton_defect;
    ImageButton airleaks_backbutton_defect;
    ImageButton steeringbreaking_backbutton_defect;
    ImageButton loadsecure_backbutton_defect;
    ImageButton tachospeedo_backbutton_defect;
    ImageButton nowarninglights_backbutton_defect;

    //<<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /////////////////////////Camera Section///////////////////////////////////////////

    ImageView photoplace100x100vehiclephoto;

    ImageButton taxinsurance_report_done_without_inspect;
    ImageButton taxinsurance_report_done_with_inspect;
    ImageButton regplate_report_done_without_inspect;
    ImageButton regplate_report_done_with_inspect;
    ImageButton airelectrial_report_done_without_inspect;
    ImageButton airelectrial_report_done_with_inspect;
    ImageButton fluidleaks_report_done_without_inspect;
    ImageButton fluidleaks_report_done_with_inspect;
    ImageButton airsuspension_report_done_without_inspect;
    ImageButton airsuspension_report_done_with_inspect;
    ImageButton wheelsandtyres_report_done_without_inspect;
    ImageButton wheelsandtyres_report_done_with_inspect;
    ImageButton lightsreflectors_report_done_without_inspect;
    ImageButton lightsreflectors_report_done_with_inspect;
    ImageButton exhaust_report_done_without_inspect;
    ImageButton exhaust_report_done_with_inspect;
    ImageButton bodyguards_report_done_without_inspect;
    ImageButton bodyguards_report_done_with_inspect;
    ImageButton landingleg_report_done_without_inspect;
    ImageButton landingleg_report_done_with_inspect;
    ImageButton sparetow_report_done_without_inspect;
    ImageButton sparetow_report_done_with_inspect;
    ImageButton trailerbrake_report_done_without_inspect;
    ImageButton trailerbrake_report_done_with_inspect;
    ImageButton windowsandmirrors_report_done_without_inspect;
    ImageButton windowsandmirrors_report_done_with_inspect;
    ImageButton seatbelt_report_done_without_inspect;
    ImageButton seatbelt_report_done_with_inspect;
    ImageButton washerandwiper_report_done_without_inspect;
    ImageButton washerandwiper_report_done_with_inspect;
    ImageButton horn_report_done_without_inspect;
    ImageButton horn_report_done_with_inspect;
    ImageButton breakwarninglight_report_done_without_inspect;
    ImageButton breakwarninglight_report_done_with_inspect;
    ImageButton gauge_report_done_without_inspect;
    ImageButton gauge_report_done_with_inspect;
    ImageButton tacho_report_done_without_inspect;
    ImageButton tacho_report_done_with_inspect;
    ImageButton airleaks_report_done_without_inspect;
    ImageButton airleaks_report_done_with_inspect;
    ImageButton steeringbreaking_report_done_without_inspect;
    ImageButton steeringbreaking_report_done_with_inspect;
    ImageButton loadsecure_report_done_without_inspect;
    ImageButton loadsecure_report_done_with_inspect;
    ImageButton tachospeedo_report_done_without_inspect;
    ImageButton tachospeedo_report_done_with_inspect;
    ImageButton nowarninglights_report_done_without_inspect;
    ImageButton nowarninglights_report_done_with_inspect;

    //<<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



    String taxinsurancepictureuri;
    String taxinsurancepicturepath;
    String regplatepictureuri;
    String regplatepicturepath;
    String airelectrialpictureuri;
    String airelectrialpicturepath;
    String fluidleakspictureuri;
    String fluidleakspicturepath;
    String airsuspensionpictureuri;
    String airsuspensionpicturepath;
    String wheelsandtyrespictureuri;
    String wheelsandtyrespicturepath;
    String lightsreflectorspictureuri;
    String lightsreflectorspicturepath;
    String exhaustpictureuri;
    String exhaustpicturepath;
    String bodyguardspictureuri;
    String bodyguardspicturepath;
    String landinglegpictureuri;
    String landinglegpicturepath;
    String sparetowpictureuri;
    String sparetowpicturepath;
    String trailerbrakepictureuri;
    String trailerbrakepicturepath;

    String winmirpictureuri;
    String seatbeltspictureuri;
    String washerandwiperpictureuri;
    String hornpictureuri;
    String breakwarninglightpictureuri;
    String gaugepictureuri;
    String tachopictureuri;
    String airleakspictureuri;

    String winmirpicturepath;
    String seatbeltspicturepath;
    String washerandwiperpicturepath;
    String hornpicturepath;
    String breakwarninglightpicturepath;
    String gaugepicturepath;
    String tachopicturepath;
    String airleakspicturepath;

    String steeringbreakingpictureuri;
    String loadsecurepictureuri;
    String tachospeedopictureuri;
    String nowarninglightspictureuri;
    String steeringbreakingpicturepath;
    String loadsecurepicturepath;
    String tachospeedopicturepath;
    String nowarninglightspicturepath;

    String vehiclephotopictureuri;
    String vehiclephotopicturepath;

    double Locationlat = 0;
    double Locationlong = 0;

    Boolean taxinsurancebackbuttonPressed = false;
    Boolean regplatebackbuttonPressed = false;
    Boolean airelectrialbackbuttonPressed = false;
    Boolean fluidleaksbackbuttonPressed = false;
    Boolean airsuspensionbackbuttonPressed = false;
    Boolean wheelsandtyresbackbuttonPressed = false;
    Boolean lightsreflectorsbackbuttonPressed = false;
    Boolean bodyguardsbackbuttonPressed = false;
    Boolean exhaustbackbuttonPressed = false;
    Boolean landinglegbackbuttonPressed = false;
    Boolean sparetowbackbuttonPressed = false;
    Boolean trailerbrakebackbuttonPressed = false;
    Boolean windowsandmirrorsbackbuttonPressed = false;
    Boolean seatbeltbackbuttonPressed = false;
    Boolean washerandwiperbackbuttonPressed = false;
    Boolean hornbackbuttonPressed = false;
    Boolean breakwarninglightbackbuttonPressed = false;
    Boolean gaugebackbuttonPressed = false;
    Boolean tachobackbuttonPressed = false;
    Boolean airleaksbackbuttonPressed = false;
    Boolean steeringbreakingbackbuttonPressed = false;
    Boolean loadsecurebackbuttonPressed = false;
    Boolean tachospeedobackbuttonPressed = false;
    Boolean nowarninglightsbackbuttonPressed = false;


    //<<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    UserLocation userLocation;

    public void onFinishEditDialog(String caller, String description, String fix)
    {
        switch (caller) {

            case "windowsandmirrors_inspect_button_defect":
            {
                mp.start();
                winmirtempfixfill.setText(fix);
                winmirdescribedefectfill.setText(description);
                break;
            }

            case "seatbelt_inspect_button_defect":
            {
                mp.start();
                seatbelttempfixfill.setText(fix);
                seatbeltdescribedefectfill.setText(description);
                break;
            }

            case "washerandwiper_inspect_button_defect":
            {
                mp.start();
                washerandwipertempfixfill.setText(fix);
                washerandwiperdescribedefectfill.setText(description);
                break;
            }

            case "horn_inspect_button_defect":
            {
                mp.start();
                horntempfixfill.setText(fix);
                horndescribedefectfill.setText(description);
                break;
            }

            case "breakwarninglight_inspect_button_defect":
            {
                mp.start();
                breakwarninglighttempfixfill.setText(fix);
                breakwarninglightdescribedefectfill.setText(description);
                break;
            }

            case "gauge_inspect_button_defect":
            {
                mp.start();
                gaugetempfixfill.setText(fix);
                gaugedescribedefectfill.setText(description);
                break;
            }

            case "tacho_button_defect":
            {
                mp.start();
                tachotempfixfill.setText(fix);
                tachodescribedefectfill.setText(description);
                break;
            }
            case "airleaks_button_defect":
            {
                mp.start();
                airleakstempfixfill.setText(fix);
                airleaksdescribedefectfill.setText(description);
                break;
            }

            //Driving Inspection

            case "steeringbreaking_button_defect":
            {
                mp.start();
                steeringbreakingtempfixfill.setText(fix);
                steeringbreakingdescribedefectfill.setText(description);
                break;
            }
            case "loadsecure_button_defect":
            {
                mp.start();
                loadsecuretempfixfill.setText(fix);
                loadsecuredescribedefectfill.setText(description);
                break;
            }
            case "tachospeedo_button_defect":
            {
                mp.start();
                tachospeedotempfixfill.setText(fix);
                tachospeedodescribedefectfill.setText(description);
                break;
            }
            case "nowarninglights_button_defect":
            {
                mp.start();
                nowarninglightstempfixfill.setText(fix);
                nowarninglightsdescribedefectfill.setText(description);
                break;
            }
            //Outside Inspection
            case "taxinsurance_button_defect":
            {
                mp.start();
                taxinsurancetempfixfill.setText(fix);
                taxinsurancedescribedefectfill.setText(description);
                break;
            }
            case "wheelstyres_button_defect":
            {
                mp.start();
                wheelstyrestempfixfill.setText(fix);
                wheelstyresdescribedefectfill.setText(description);
                break;
            }
            case "lightsreflectors_button_defect":
            {
                mp.start();
                lightsreflectorstempfixfill.setText(fix);
                lightsreflectorsdescribedefectfill.setText(description);
                break;
            }
            case "exhaust_button_defect":
            {
                mp.start();
                exhausttempfixfill.setText(fix);
                exhaustdescribedefectfill.setText(description);
                break;
            }
            case "sparetow_button_defect":
            {
                mp.start();
                sparetowtempfixfill.setText(fix);
                sparetowdescribedefectfill.setText(description);
                break;
            }
            case "trailerbrake_button_defect":
            {
                mp.start();
                trailerbraketempfixfill.setText(fix);
                trailerbrakedescribedefectfill.setText(description);
                break;
            }
            case "bodyguards_button_defect":
            {
                mp.start();
                bodyguardstempfixfill.setText(fix);
                bodyguardsdescribedefectfill.setText(description);
                break;
            }
            case "landingleg_button_defect":
            {
                mp.start();
                landinglegtempfixfill.setText(fix);
                landinglegdescribedefectfill.setText(description);
                break;
            }
            case "regplate_button_defect":
            {
                mp.start();
                regplatetempfixfill.setText(fix);
                regplatedescribedefectfill.setText(description);
                break;
            }
            case "fluidleaks_button_defect":
            {
                mp.start();
                fluidleakstempfixfill.setText(fix);
                fluidleaksdescribedefectfill.setText(description);
                break;
            }
            case "airelectrial_button_defect":
            {
                mp.start();
                airelectrialtempfixfill.setText(fix);
                airelectrialdescribedefectfill.setText(description);
                break;
            }
            case "airsuspension_button_defect":
            {
                mp.start();
                airsuspensiontempfixfill.setText(fix);
                airsuspensiondescribedefectfill.setText(description);
                break;
            }
        }
    }

    public boolean  Online_check () {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or__update__inspection);

        userLocation = new UserLocation(this, this);

        prg = (ProgressBar) findViewById(R.id.progressBar);
        prg.setProgress(0);
        prg.setMax(100);
        prg.setProgressTintList(ColorStateList.valueOf(Color.GREEN));

        Onlinetext = (TextView) findViewById(R.id.Onlinetext);
        onlineimage = (ImageView) findViewById(R.id.onlineimage);


        mStorage = FirebaseStorage.getInstance().getReference();

        mProgressDialog = new ProgressDialog(this);

        mp = MediaPlayer.create(this, R.raw.beep_button_radio_button);


        time_stamp = (TextView) findViewById(R.id.time_stamp);

        String date = getIntent().getStringExtra("Date");
        time_stamp.setText(getIntent().getStringExtra("Date"));

        position = getIntent().getIntExtra("Position", -1);

        cl = (CoordinatorLayout) findViewById(R.id.cdlayout);

        user_name = (TextView) findViewById(R.id.user_name);
        user_email = (TextView) findViewById(R.id.user_email);
        user_company = (TextView) findViewById(R.id.user_company);
        etreport_email_recipient = (TextView) findViewById(R.id.etreport_email_recipient);
        user_contact_number = (TextView) findViewById(R.id.user_contact_number);
        pReg = (EditText) findViewById(R.id.pReg);

        bOK = (Button) findViewById(R.id.bOk);
        bCancel = (Button) findViewById(R.id.bCancel);
        vehiclephoto = (Button) findViewById(R.id.vehiclephoto);


        //Headings Boxes open and Close
        outsideinspectionshowbutton = (Button) findViewById(R.id.outsideinspectionshowbutton);
        outsideinspectionhidebutton = (Button) findViewById(R.id.outsideinspectionhidebutton);
        insideinspectionshowbutton = (Button) findViewById(R.id.insideinspectionshowbutton);
        insideinspectionhidebutton = (Button) findViewById(R.id.insideinspectionhidebutton);
        drivinginspectionshowbutton = (Button) findViewById(R.id.drivinginspectionshowbutton);
        drivinginspectionhidebutton = (Button) findViewById(R.id.drivinginspectionhidebutton);


        locationbutton = (ImageButton) findViewById(R.id.locationbutton);

        //Image Buttons Icons
        windowsandmirrors_icon_image = (ImageButton) findViewById(R.id.windowsandmirrors_icon_image);
        seatbelt_icon_image = (ImageButton) findViewById(R.id.seatbelt_icon_image);
        washerandwiper_icon_image = (ImageButton) findViewById(R.id.washerandwiper_icon_image);
        horn_icon_image = (ImageButton) findViewById(R.id.horn_icon_image);
        breakwarninglight_icon_image = (ImageButton) findViewById(R.id.breakwarninglight_icon_image);
        gauge_icon_image = (ImageButton) findViewById(R.id.gauge_icon_image);
        tacho_icon_image = (ImageButton) findViewById(R.id.tacho_icon_image);
        airleaks_icon_image = (ImageButton) findViewById(R.id.airleaks_icon_image);
        //Driving Inspection
        steeringbreaking_icon_image = (ImageButton) findViewById(R.id.steeringbreaking_icon_image);
        loadsecure_icon_image = (ImageButton) findViewById(R.id.loadsecure_icon_image);
        tachospeedo_icon_image = (ImageButton) findViewById(R.id.tachospeedo_icon_image);
        nowarninglights_icon_image = (ImageButton) findViewById(R.id.nowarninglights_icon_image);
        //Outside Inspection
        taxinsurance_icon_image = (ImageButton) findViewById(R.id.taxinsurance_icon_image);
        wheelstyres_icon_image = (ImageButton) findViewById(R.id.wheelstyres_icon_image);
        lightsreflectors_icon_image = (ImageButton) findViewById(R.id.lightsreflectors_icon_image);
        exhaust_icon_image = (ImageButton) findViewById(R.id.exhaust_icon_image);
        sparetow_icon_image = (ImageButton) findViewById(R.id.sparetow_icon_image);
        trailerbrake_icon_image = (ImageButton) findViewById(R.id.trailerbrake_icon_image);
        bodyguards_icon_image = (ImageButton) findViewById(R.id.bodyguards_icon_image);
        landingleg_icon_image = (ImageButton) findViewById(R.id.landingleg_icon_image);
        regplate_icon_image = (ImageButton) findViewById(R.id.regplate_icon_image);
        fluidleaks_icon_image = (ImageButton) findViewById(R.id.fluidleaks_icon_image);
        airelectrial_icon_image = (ImageButton) findViewById(R.id.airelectrial_icon_image);
        airsuspension_icon_image = (ImageButton) findViewById(R.id.airsuspension_icon_image);


        taxinsurance_backbutton_defect = (ImageButton) findViewById(R.id.taxinsurance_backbutton_defect);
        taxinsurance_backbutton_defect.setVisibility(View.GONE);
        regplate_backbutton_defect = (ImageButton) findViewById(R.id.regplate_backbutton_defect);
        regplate_backbutton_defect.setVisibility(View.GONE);
        airelectrial_backbutton_defect = (ImageButton) findViewById(R.id.airelectrial_backbutton_defect);
        airelectrial_backbutton_defect.setVisibility(View.GONE);
        fluidleaks_backbutton_defect = (ImageButton) findViewById(R.id.fluidleaks_backbutton_defect);
        fluidleaks_backbutton_defect.setVisibility(View.GONE);
        airsuspension_backbutton_defect = (ImageButton) findViewById(R.id.airsuspension_backbutton_defect);
        airsuspension_backbutton_defect.setVisibility(View.GONE);
        wheelsandtyres_backbutton_defect = (ImageButton) findViewById(R.id.wheelsandtyres_backbutton_defect);
        wheelsandtyres_backbutton_defect.setVisibility(View.GONE);
        lightsreflectors_backbutton_defect = (ImageButton) findViewById(R.id.lightsreflectors_backbutton_defect);
        lightsreflectors_backbutton_defect.setVisibility(View.GONE);
        exhaust_backbutton_defect = (ImageButton) findViewById(R.id.exhaust_backbutton_defect);
        exhaust_backbutton_defect.setVisibility(View.GONE);
        bodyguards_backbutton_defect = (ImageButton) findViewById(R.id.bodyguards_backbutton_defect);
        bodyguards_backbutton_defect.setVisibility(View.GONE);
        landingleg_backbutton_defect = (ImageButton) findViewById(R.id.landingleg_backbutton_defect);
        landingleg_backbutton_defect.setVisibility(View.GONE);
        sparetow_backbutton_defect = (ImageButton) findViewById(R.id.sparetow_backbutton_defect);
        sparetow_backbutton_defect.setVisibility(View.GONE);
        trailerbrake_backbutton_defect = (ImageButton) findViewById(R.id.trailerbrake_backbutton_defect);
        trailerbrake_backbutton_defect.setVisibility(View.GONE);
        windowsandmirrors_backbutton_defect = (ImageButton) findViewById(R.id.windowsandmirrors_backbutton_defect);
        windowsandmirrors_backbutton_defect.setVisibility(View.GONE);
        seatbelt_backbutton_defect = (ImageButton) findViewById(R.id.seatbelt_backbutton_defect);
        seatbelt_backbutton_defect.setVisibility(View.GONE);
        washerandwiper_backbutton_defect = (ImageButton) findViewById(R.id.washerandwiper_backbutton_defect);
        washerandwiper_backbutton_defect.setVisibility(View.GONE);
        horn_backbutton_defect = (ImageButton) findViewById(R.id.horn_backbutton_defect);
        horn_backbutton_defect.setVisibility(View.GONE);
        breakwarninglight_backbutton_defect = (ImageButton) findViewById(R.id.breakwarninglight_backbutton_defect);
        breakwarninglight_backbutton_defect.setVisibility(View.GONE);
        gauge_backbutton_defect = (ImageButton) findViewById(R.id.gauge_backbutton_defect);
        gauge_backbutton_defect.setVisibility(View.GONE);
        tacho_backbutton_defect = (ImageButton) findViewById(R.id.tacho_backbutton_defect);
        tacho_backbutton_defect.setVisibility(View.GONE);
        airleaks_backbutton_defect = (ImageButton) findViewById(R.id.airleaks_backbutton_defect);
        airleaks_backbutton_defect.setVisibility(View.GONE);
        steeringbreaking_backbutton_defect = (ImageButton) findViewById(R.id.steeringbreaking_backbutton_defect);
        steeringbreaking_backbutton_defect.setVisibility(View.GONE);
        loadsecure_backbutton_defect = (ImageButton) findViewById(R.id.loadsecure_backbutton_defect);
        loadsecure_backbutton_defect.setVisibility(View.GONE);
        tachospeedo_backbutton_defect = (ImageButton) findViewById(R.id.tachospeedo_backbutton_defect);
        tachospeedo_backbutton_defect.setVisibility(View.GONE);
        nowarninglights_backbutton_defect = (ImageButton) findViewById(R.id.nowarninglights_backbutton_defect);
        nowarninglights_backbutton_defect.setVisibility(View.GONE);


        //<<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //Text view Descriptions
        windows_and_mirrors_describe_defect_text_view = (TextView) findViewById(R.id.windows_and_mirrors_describe_defect_text_view);
        windows_and_mirrors_describe_tempfix_text_view = (TextView) findViewById(R.id.windows_and_mirrors_describe_tempfix_text_view);
        seatbelt_describe_defect_text_view = (TextView) findViewById(R.id.seatbelt_describe_defect_text_view);
        seatbelt_describe_tempfix_text_view = (TextView) findViewById(R.id.seatbelt_describe_tempfix_text_view);
        washerandwiper_describe_defect_text_view = (TextView) findViewById(R.id.washerandwiper_describe_defect_text_view);
        washerandwiper_describe_tempfix_text_view = (TextView) findViewById(R.id.washerandwiper_describe_tempfix_text_view);
        horn_describe_defect_text_view = (TextView) findViewById(R.id.horn_describe_defect_text_view);
        horn_describe_tempfix_text_view = (TextView) findViewById(R.id.horn_describe_tempfix_text_view);
        breakwarninglight_describe_defect_text_view = (TextView) findViewById(R.id.breakwarninglight_describe_defect_text_view);
        breakwarninglight_describe_tempfix_text_view = (TextView) findViewById(R.id.breakwarninglight_describe_tempfix_text_view);
        gauge_describe_defect_text_view = (TextView) findViewById(R.id.gauge_describe_defect_text_view);
        gauge_describe_tempfix_text_view = (TextView) findViewById(R.id.gauge_describe_tempfix_text_view);
        tacho_describe_defect_text_view = (TextView) findViewById(R.id.tacho_describe_defect_text_view);
        tacho_describe_tempfix_text_view = (TextView) findViewById(R.id.tacho_describe_tempfix_text_view);
        airleaks_describe_defect_text_view = (TextView) findViewById(R.id.airleaks_describe_defect_text_view);
        airleaks_describe_tempfix_text_view = (TextView) findViewById(R.id.airleaks_describe_tempfix_text_view);
        //Driving Inspection
        steeringbreaking_describe_defect_text_view = (TextView) findViewById(R.id.steeringbreaking_describe_defect_text_view);
        steeringbreaking_describe_tempfix_text_view = (TextView) findViewById(R.id.steeringbreaking_describe_tempfix_text_view);
        loadsecure_describe_defect_text_view = (TextView) findViewById(R.id.loadsecure_describe_defect_text_view);
        loadsecure_describe_tempfix_text_view = (TextView) findViewById(R.id.loadsecure_describe_tempfix_text_view);
        tachospeedo_describe_defect_text_view = (TextView) findViewById(R.id.tachospeedo_describe_defect_text_view);
        tachospeedo_describe_tempfix_text_view = (TextView) findViewById(R.id.tachospeedo_describe_tempfix_text_view);
        nowarninglights_describe_defect_text_view = (TextView) findViewById(R.id.nowarninglights_describe_defect_text_view);
        nowarninglights_describe_tempfix_text_view = (TextView) findViewById(R.id.nowarninglights_describe_tempfix_text_view);
        //Outside Inspection
        taxinsurance_describe_defect_text_view = (TextView) findViewById(R.id.taxinsurance_describe_defect_text_view);
        taxinsurance_describe_tempfix_text_view = (TextView) findViewById(R.id.taxinsurance_describe_tempfix_text_view);
        wheelstyres_describe_defect_text_view = (TextView) findViewById(R.id.wheelstyres_describe_defect_text_view);
        wheelstyres_describe_tempfix_text_view = (TextView) findViewById(R.id.wheelstyres_describe_tempfix_text_view);
        lightsreflectors_describe_defect_text_view = (TextView) findViewById(R.id.lightsreflectors_describe_defect_text_view);
        lightsreflectors_describe_tempfix_text_view = (TextView) findViewById(R.id.lightsreflectors_describe_tempfix_text_view);
        exhaust_describe_defect_text_view = (TextView) findViewById(R.id.exhaust_describe_defect_text_view);
        exhaust_describe_tempfix_text_view = (TextView) findViewById(R.id.exhaust_describe_tempfix_text_view);
        sparetow_describe_defect_text_view = (TextView) findViewById(R.id.sparetow_describe_defect_text_view);
        sparetow_describe_tempfix_text_view = (TextView) findViewById(R.id.sparetow_describe_tempfix_text_view);
        trailerbrake_describe_defect_text_view = (TextView) findViewById(R.id.trailerbrake_describe_defect_text_view);
        trailerbrake_describe_tempfix_text_view = (TextView) findViewById(R.id.trailerbrake_describe_tempfix_text_view);
        bodyguards_describe_defect_text_view = (TextView) findViewById(R.id.bodyguards_describe_defect_text_view);
        bodyguards_describe_tempfix_text_view = (TextView) findViewById(R.id.bodyguards_describe_tempfix_text_view);
        landingleg_describe_defect_text_view = (TextView) findViewById(R.id.landingleg_describe_defect_text_view);
        landingleg_describe_tempfix_text_view = (TextView) findViewById(R.id.landingleg_describe_tempfix_text_view);
        regplate_describe_defect_text_view = (TextView) findViewById(R.id.regplate_describe_defect_text_view);
        regplate_describe_tempfix_text_view = (TextView) findViewById(R.id.regplate_describe_tempfix_text_view);
        fluidleaks_describe_defect_text_view = (TextView) findViewById(R.id.fluidleaks_describe_defect_text_view);
        fluidleaks_describe_tempfix_text_view = (TextView) findViewById(R.id.fluidleaks_describe_tempfix_text_view);
        airelectrial_describe_defect_text_view = (TextView) findViewById(R.id.airelectrial_describe_defect_text_view);
        airelectrial_describe_tempfix_text_view = (TextView) findViewById(R.id.airelectrial_describe_tempfix_text_view);
        airsuspension_describe_defect_text_view = (TextView) findViewById(R.id.airsuspension_describe_defect_text_view);
        airsuspension_describe_tempfix_text_view = (TextView) findViewById(R.id.airsuspension_describe_tempfix_text_view);


        //Image Buttons
        windowsandmirrors_inspect_button_defect = (ImageButton) findViewById(R.id.windowsandmirrors_inspect_button_defect);
        windowsandmirrors_inspect_button_tick_defect = (ImageButton) findViewById(R.id.windowsandmirrors_inspect_button_tick_defect);
        seatbelt_inspect_button_defect = (ImageButton) findViewById(R.id.seatbelt_inspect_button_defect);
        seatbelt_inspect_button_tick_defect = (ImageButton) findViewById(R.id.seatbelt_inspect_button_tick_defect);
        washerandwiper_inspect_button_defect = (ImageButton) findViewById(R.id.washerandwiper_inspect_button_defect);
        washerandwiper_inspect_button_tick_defect = (ImageButton) findViewById(R.id.washerandwiper_inspect_button_tick_defect);
        horn_inspect_button_defect = (ImageButton) findViewById(R.id.horn_inspect_button_defect);
        horn_inspect_button_tick_defect = (ImageButton) findViewById(R.id.horn_inspect_button_tick_defect);
        breakwarninglight_inspect_button_defect = (ImageButton) findViewById(R.id.breakwarninglight_inspect_button_defect);
        breakwarninglight_inspect_button_tick_defect = (ImageButton) findViewById(R.id.breakwarninglight_inspect_button_tick_defect);
        gauge_inspect_button_defect = (ImageButton) findViewById(R.id.gauge_inspect_button_defect);
        gauge_inspect_button_tick_defect = (ImageButton) findViewById(R.id.gauge_inspect_button_tick_defect);
        tacho_inspect_button_defect = (ImageButton) findViewById(R.id.tacho_inspect_button_defect);
        tacho_inspect_button_tick_defect = (ImageButton) findViewById(R.id.tacho_inspect_button_tick_defect);
        airleaks_inspect_button_defect = (ImageButton) findViewById(R.id.airleaks_inspect_button_defect);
        airleaks_inspect_button_tick_defect = (ImageButton) findViewById(R.id.airleaks_inspect_button_tick_defect);
        //Driving Inspection
        steeringbreaking_inspect_button_defect = (ImageButton) findViewById(R.id.steeringbreaking_inspect_button_defect);
        steeringbreaking_inspect_button_tick_defect = (ImageButton) findViewById(R.id.steeringbreaking_inspect_button_tick_defect);
        loadsecure_inspect_button_defect = (ImageButton) findViewById(R.id.loadsecure_inspect_button_defect);
        loadsecure_inspect_button_tick_defect = (ImageButton) findViewById(R.id.loadsecure_inspect_button_tick_defect);
        tachospeedo_inspect_button_defect = (ImageButton) findViewById(R.id.tachospeedo_inspect_button_defect);
        tachospeedo_inspect_button_tick_defect = (ImageButton) findViewById(R.id.tachospeedo_inspect_button_tick_defect);
        nowarninglights_inspect_button_defect = (ImageButton) findViewById(R.id.nowarninglights_inspect_button_defect);
        nowarninglights_inspect_button_tick_defect = (ImageButton) findViewById(R.id.nowarninglights_inspect_button_tick_defect);
        //Outside Inspection
        taxinsurance_inspect_button_defect = (ImageButton) findViewById(R.id.taxinsurance_inspect_button_defect);
        taxinsurance_inspect_button_tick_defect = (ImageButton) findViewById(R.id.taxinsurance_inspect_button_tick_defect);
        wheelstyres_inspect_button_defect = (ImageButton) findViewById(R.id.wheelstyres_inspect_button_defect);
        wheelstyres_inspect_button_tick_defect = (ImageButton) findViewById(R.id.wheelstyres_inspect_button_tick_defect);
        lightsreflectors_inspect_button_defect = (ImageButton) findViewById(R.id.lightsreflectors_inspect_button_defect);
        lightsreflectors_inspect_button_tick_defect = (ImageButton) findViewById(R.id.lightsreflectors_inspect_button_tick_defect);
        exhaust_inspect_button_defect = (ImageButton) findViewById(R.id.exhaust_inspect_button_defect);
        exhaust_inspect_button_tick_defect = (ImageButton) findViewById(R.id.exhaust_inspect_button_tick_defect);
        sparetow_inspect_button_defect = (ImageButton) findViewById(R.id.sparetow_inspect_button_defect);
        sparetow_inspect_button_tick_defect = (ImageButton) findViewById(R.id.sparetow_inspect_button_tick_defect);
        trailerbrake_inspect_button_defect = (ImageButton) findViewById(R.id.trailerbrake_inspect_button_defect);
        trailerbrake_inspect_button_tick_defect = (ImageButton) findViewById(R.id.trailerbrake_inspect_button_tick_defect);
        bodyguards_inspect_button_defect = (ImageButton) findViewById(R.id.bodyguards_inspect_button_defect);
        bodyguards_inspect_button_tick_defect = (ImageButton) findViewById(R.id.bodyguards_inspect_button_tick_defect);
        landingleg_inspect_button_defect = (ImageButton) findViewById(R.id.landingleg_inspect_button_defect);
        landingleg_inspect_button_tick_defect = (ImageButton) findViewById(R.id.landingleg_inspect_button_tick_defect);
        regplate_inspect_button_defect = (ImageButton) findViewById(R.id.regplate_inspect_button_defect);
        regplate_inspect_button_tick_defect = (ImageButton) findViewById(R.id.regplate_inspect_button_tick_defect);
        fluidleaks_inspect_button_defect = (ImageButton) findViewById(R.id.fluidleaks_inspect_button_defect);
        fluidleaks_inspect_button_tick_defect = (ImageButton) findViewById(R.id.fluidleaks_inspect_button_tick_defect);
        airelectrial_inspect_button_defect = (ImageButton) findViewById(R.id.airelectrial_inspect_button_defect);
        airelectrial_inspect_button_tick_defect = (ImageButton) findViewById(R.id.airelectrial_inspect_button_tick_defect);
        airsuspension_inspect_button_defect = (ImageButton) findViewById(R.id.airsuspension_inspect_button_defect);
        airsuspension_inspect_button_tick_defect = (ImageButton) findViewById(R.id.airsuspension_inspect_button_tick_defect);

        taxinsurance_report_done_with_inspect = (ImageButton) findViewById(R.id.taxinsurance_report_done_with_inspect);
        taxinsurance_report_done_without_inspect = (ImageButton) findViewById(R.id.taxinsurance_report_done_without_inspect);
        regplate_report_done_with_inspect = (ImageButton) findViewById(R.id.regplate_report_done_with_inspect);
        regplate_report_done_without_inspect = (ImageButton) findViewById(R.id.regplate_report_done_without_inspect);
        airelectrial_report_done_with_inspect = (ImageButton) findViewById(R.id.airelectrial_report_done_with_inspect);
        airelectrial_report_done_without_inspect = (ImageButton) findViewById(R.id.airelectrial_report_done_without_inspect);
        fluidleaks_report_done_with_inspect = (ImageButton) findViewById(R.id.fluidleaks_report_done_with_inspect);
        fluidleaks_report_done_without_inspect = (ImageButton) findViewById(R.id.fluidleaks_report_done_without_inspect);
        airsuspension_report_done_with_inspect = (ImageButton) findViewById(R.id.airsuspension_report_done_with_inspect);
        airsuspension_report_done_without_inspect = (ImageButton) findViewById(R.id.airsuspension_report_done_without_inspect);
        wheelsandtyres_report_done_with_inspect = (ImageButton) findViewById(R.id.wheelsandtyres_report_done_with_inspect);
        wheelsandtyres_report_done_without_inspect = (ImageButton) findViewById(R.id.wheelsandtyres_report_done_without_inspect);
        lightsreflectors_report_done_with_inspect = (ImageButton) findViewById(R.id.lightsreflectors_report_done_with_inspect);
        lightsreflectors_report_done_without_inspect = (ImageButton) findViewById(R.id.lightsreflectors_report_done_without_inspect);
        exhaust_report_done_with_inspect = (ImageButton) findViewById(R.id.exhaust_report_done_with_inspect);
        exhaust_report_done_without_inspect = (ImageButton) findViewById(R.id.exhaust_report_done_without_inspect);
        bodyguards_report_done_with_inspect = (ImageButton) findViewById(R.id.bodyguards_report_done_with_inspect);
        bodyguards_report_done_without_inspect = (ImageButton) findViewById(R.id.bodyguards_report_done_without_inspect);
        landingleg_report_done_with_inspect = (ImageButton) findViewById(R.id.landingleg_report_done_with_inspect);
        landingleg_report_done_without_inspect = (ImageButton) findViewById(R.id.landingleg_report_done_without_inspect);
        sparetow_report_done_with_inspect = (ImageButton) findViewById(R.id.sparetow_report_done_with_inspect);
        sparetow_report_done_without_inspect = (ImageButton) findViewById(R.id.sparetow_report_done_without_inspect);
        trailerbrake_report_done_with_inspect = (ImageButton) findViewById(R.id.trailerbrake_report_done_with_inspect);
        trailerbrake_report_done_without_inspect = (ImageButton) findViewById(R.id.trailerbrake_report_done_without_inspect);
        windowsandmirrors_report_done_with_inspect = (ImageButton) findViewById(R.id.windowsandmirrors_report_done_with_inspect);
        windowsandmirrors_report_done_without_inspect = (ImageButton) findViewById(R.id.windowsandmirrors_report_done_without_inspect);
        seatbelt_report_done_with_inspect = (ImageButton) findViewById(R.id.seatbelt_report_done_with_inspect);
        seatbelt_report_done_without_inspect = (ImageButton) findViewById(R.id.seatbelt_report_done_without_inspect);
        washerandwiper_report_done_with_inspect = (ImageButton) findViewById(R.id.washerandwiper_report_done_with_inspect);
        washerandwiper_report_done_without_inspect = (ImageButton) findViewById(R.id.washerandwiper_report_done_without_inspect);
        horn_report_done_with_inspect = (ImageButton) findViewById(R.id.horn_report_done_with_inspect);
        horn_report_done_without_inspect = (ImageButton) findViewById(R.id.horn_report_done_without_inspect);
        breakwarninglight_report_done_with_inspect = (ImageButton) findViewById(R.id.breakwarninglight_report_done_with_inspect);
        breakwarninglight_report_done_without_inspect = (ImageButton) findViewById(R.id.breakwarninglight_report_done_without_inspect);
        gauge_report_done_with_inspect = (ImageButton) findViewById(R.id.gauge_report_done_with_inspect);
        gauge_report_done_without_inspect = (ImageButton) findViewById(R.id.gauge_report_done_without_inspect);
        tacho_report_done_with_inspect = (ImageButton) findViewById(R.id.tacho_report_done_with_inspect);
        tacho_report_done_without_inspect = (ImageButton) findViewById(R.id.tacho_report_done_without_inspect);
        airleaks_report_done_with_inspect = (ImageButton) findViewById(R.id.airleaks_report_done_with_inspect);
        airleaks_report_done_without_inspect = (ImageButton) findViewById(R.id.airleaks_report_done_without_inspect);
        steeringbreaking_report_done_with_inspect = (ImageButton) findViewById(R.id.steeringbreaking_report_done_with_inspect);
        steeringbreaking_report_done_without_inspect = (ImageButton) findViewById(R.id.steeringbreaking_report_done_without_inspect);
        loadsecure_report_done_with_inspect = (ImageButton) findViewById(R.id.loadsecure_report_done_with_inspect);
        loadsecure_report_done_without_inspect = (ImageButton) findViewById(R.id.loadsecure_report_done_without_inspect);
        tachospeedo_report_done_with_inspect = (ImageButton) findViewById(R.id.tachospeedo_report_done_with_inspect);
        tachospeedo_report_done_without_inspect = (ImageButton) findViewById(R.id.tachospeedo_report_done_without_inspect);
        nowarninglights_report_done_with_inspect = (ImageButton) findViewById(R.id.nowarninglights_report_done_with_inspect);
        nowarninglights_report_done_without_inspect = (ImageButton) findViewById(R.id.nowarninglights_report_done_without_inspect);

        //<<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //Popup
        winmirtempfixfill = (TextView) findViewById(R.id.winmirtempfixfill);
        winmirdescribedefectfill = (TextView) findViewById(R.id.winmirdescribedefectfill);
        seatbelttempfixfill = (TextView) findViewById(R.id.seatbelttempfixfill);
        seatbeltdescribedefectfill = (TextView) findViewById(R.id.seatbeltdescribedefectfill);
        washerandwipertempfixfill = (TextView) findViewById(R.id.washerandwipertempfixfill);
        washerandwiperdescribedefectfill = (TextView) findViewById(R.id.washerandwiperdescribedefectfill);
        horntempfixfill = (TextView) findViewById(R.id.horntempfixfill);
        horndescribedefectfill = (TextView) findViewById(R.id.horndescribedefectfill);
        breakwarninglighttempfixfill = (TextView) findViewById(R.id.breakwarninglighttempfixfill);
        breakwarninglightdescribedefectfill = (TextView) findViewById(R.id.breakwarninglightdescribedefectfill);
        gaugetempfixfill = (TextView) findViewById(R.id.gaugetempfixfill);
        gaugedescribedefectfill = (TextView) findViewById(R.id.gaugedescribedefectfill);
        tachotempfixfill = (TextView) findViewById(R.id.tachotempfixfill);
        tachodescribedefectfill = (TextView) findViewById(R.id.tachodescribedefectfill);
        airleakstempfixfill = (TextView) findViewById(R.id.airleakstempfixfill);
        airleaksdescribedefectfill = (TextView) findViewById(R.id.airleaksdescribedefectfill);
        //Driving Inspection
        steeringbreakingtempfixfill = (TextView) findViewById(R.id.steeringbreakingtempfixfill);
        steeringbreakingdescribedefectfill = (TextView) findViewById(R.id.steeringbreakingdescribedefectfill);
        loadsecuretempfixfill = (TextView) findViewById(R.id.loadsecuretempfixfill);
        loadsecuredescribedefectfill = (TextView) findViewById(R.id.loadsecuredescribedefectfill);
        tachospeedotempfixfill = (TextView) findViewById(R.id.tachospeedotempfixfill);
        tachospeedodescribedefectfill = (TextView) findViewById(R.id.tachospeedodescribedefectfill);
        nowarninglightstempfixfill = (TextView) findViewById(R.id.nowarninglightstempfixfill);
        nowarninglightsdescribedefectfill = (TextView) findViewById(R.id.nowarninglightsdescribedefectfill);
        //Outside Inspection
        taxinsurancetempfixfill = (TextView) findViewById(R.id.taxinsurancetempfixfill);
        taxinsurancedescribedefectfill = (TextView) findViewById(R.id.taxinsurancedescribedefectfill);
        wheelstyrestempfixfill = (TextView) findViewById(R.id.wheelstyrestempfixfill);
        wheelstyresdescribedefectfill = (TextView) findViewById(R.id.wheelstyresdescribedefectfill);
        lightsreflectorstempfixfill = (TextView) findViewById(R.id.lightsreflectorstempfixfill);
        lightsreflectorsdescribedefectfill = (TextView) findViewById(R.id.lightsreflectorsdescribedefectfill);
        exhausttempfixfill = (TextView) findViewById(R.id.exhausttempfixfill);
        exhaustdescribedefectfill = (TextView) findViewById(R.id.exhaustdescribedefectfill);
        sparetowtempfixfill = (TextView) findViewById(R.id.sparetowtempfixfill);
        sparetowdescribedefectfill = (TextView) findViewById(R.id.sparetowdescribedefectfill);
        trailerbraketempfixfill = (TextView) findViewById(R.id.trailerbraketempfixfill);
        trailerbrakedescribedefectfill = (TextView) findViewById(R.id.trailerbrakedescribedefectfill);
        bodyguardstempfixfill = (TextView) findViewById(R.id.bodyguardstempfixfill);
        bodyguardsdescribedefectfill = (TextView) findViewById(R.id.bodyguardsdescribedefectfill);
        landinglegtempfixfill = (TextView) findViewById(R.id.landinglegtempfixfill);
        landinglegdescribedefectfill = (TextView) findViewById(R.id.landinglegdescribedefectfill);
        regplatetempfixfill = (TextView) findViewById(R.id.regplatetempfixfill);
        regplatedescribedefectfill = (TextView) findViewById(R.id.regplatedescribedefectfill);
        fluidleakstempfixfill = (TextView) findViewById(R.id.fluidleakstempfixfill);
        fluidleaksdescribedefectfill = (TextView) findViewById(R.id.fluidleaksdescribedefectfill);
        airelectrialtempfixfill = (TextView) findViewById(R.id.airelectrialtempfixfill);
        airelectrialdescribedefectfill = (TextView) findViewById(R.id.airelectrialdescribedefectfill);
        airsuspensiontempfixfill = (TextView) findViewById(R.id.airsuspensiontempfixfill);
        airsuspensiondescribedefectfill = (TextView) findViewById(R.id.airsuspensiondescribedefectfill);


        /////////////////////////Camera Section///////////////////////////////////////////

        photoplace100x100vehiclephoto = (ImageView) findViewById(R.id.photoplace100x100vehiclephoto);



        /////////////////////////Whole Boxs///////////////////////////////////////////

        taxandinsurancewholebox = (LinearLayout) findViewById(R.id.taxandinsurancewholebox);
        regplatewholebox = (LinearLayout) findViewById(R.id.regplatewholebox);
        airandelectrialwholebox = (LinearLayout) findViewById(R.id.airandelectrialwholebox);
        fluidleakswholebox = (LinearLayout) findViewById(R.id.fluidleakswholebox);
        airsuspensionwholebox = (LinearLayout) findViewById(R.id.airsuspensionwholebox);
        wheelsandtyreswholebox = (LinearLayout) findViewById(R.id.wheelsandtyreswholebox);
        lightsreflectorswholebox = (LinearLayout) findViewById(R.id.lightsreflectorswholebox);
        exhaustwholebox = (LinearLayout) findViewById(R.id.exhaustwholebox );
        bodyguardswholebox = (LinearLayout) findViewById(R.id.bodyguardswholebox );
        landinglegwholebox = (LinearLayout) findViewById(R.id.landinglegwholebox);
        sparetowwholebox = (LinearLayout) findViewById(R.id.sparetowwholebox);
        trailerbrakewholebox = (LinearLayout) findViewById(R.id.trailerbrakewholebox);

        windowsandmirrorswholebox = (LinearLayout) findViewById(R.id.windowsandmirrorswholebox);
        seatbeltwholebox = (LinearLayout) findViewById(R.id.seatbeltwholebox);
        washerandwiperwholebox = (LinearLayout) findViewById(R.id.washerandwiperwholebox);
        hornwholebox = (LinearLayout) findViewById(R.id.hornwholebox);
        breakwarninglightwholebox = (LinearLayout) findViewById(R.id.breakwarninglightwholebox);
        gaugewholebox = (LinearLayout) findViewById(R.id.gaugewholebox);
        tachowholebox = (LinearLayout) findViewById(R.id.tachowholebox);
        airleakswholebox = (LinearLayout) findViewById(R.id.airleakswholebox);

        steeringbreakingwholebox = (LinearLayout) findViewById(R.id.steeringbreakingwholebox);
        loadsecurewholebox = (LinearLayout) findViewById(R.id.loadsecurewholebox);
        tachospeedowholebox = (LinearLayout) findViewById(R.id.tachospeedowholebox);
        nowarninglightswholebox = (LinearLayout) findViewById(R.id.nowarninglightswholebox);




        //<<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



        //On Create Set these Auto invisble :- Windows and Mirrors

        photoplace100x100vehiclephoto.setVisibility(View.GONE);

        taxinsurance_report_done_without_inspect.setVisibility(View.GONE);
        taxinsurance_report_done_with_inspect.setVisibility(View.GONE);
        taxinsurance_describe_defect_text_view.setVisibility(View.GONE);
        taxinsurance_describe_tempfix_text_view.setVisibility(View.GONE);
        taxinsurancedescribedefectfill.setVisibility(View.GONE);
        taxinsurancetempfixfill.setVisibility(View.GONE);



        regplate_report_done_without_inspect.setVisibility(View.GONE);
        regplate_report_done_with_inspect.setVisibility(View.GONE);
        regplate_describe_defect_text_view.setVisibility(View.GONE);
        regplate_describe_tempfix_text_view.setVisibility(View.GONE);
        regplatedescribedefectfill.setVisibility(View.GONE);
        regplatetempfixfill.setVisibility(View.GONE);




        airelectrial_report_done_without_inspect.setVisibility(View.GONE);
        airelectrial_report_done_with_inspect.setVisibility(View.GONE);
        airelectrial_describe_defect_text_view.setVisibility(View.GONE);
        airelectrial_describe_tempfix_text_view.setVisibility(View.GONE);
        airelectrialdescribedefectfill.setVisibility(View.GONE);
        airelectrialtempfixfill.setVisibility(View.GONE);



        fluidleaks_report_done_without_inspect.setVisibility(View.GONE);
        fluidleaks_report_done_with_inspect.setVisibility(View.GONE);
        fluidleaks_describe_defect_text_view.setVisibility(View.GONE);
        fluidleaks_describe_tempfix_text_view.setVisibility(View.GONE);
        fluidleaksdescribedefectfill.setVisibility(View.GONE);
        fluidleakstempfixfill.setVisibility(View.GONE);



        airsuspension_report_done_without_inspect.setVisibility(View.GONE);
        airsuspension_report_done_with_inspect.setVisibility(View.GONE);
        airsuspension_describe_defect_text_view.setVisibility(View.GONE);
        airsuspension_describe_tempfix_text_view.setVisibility(View.GONE);
        airsuspensiondescribedefectfill.setVisibility(View.GONE);
        airsuspensiontempfixfill.setVisibility(View.GONE);



        wheelsandtyres_report_done_without_inspect.setVisibility(View.GONE);
        wheelsandtyres_report_done_with_inspect.setVisibility(View.GONE);
        wheelstyres_describe_defect_text_view.setVisibility(View.GONE);
        wheelstyres_describe_tempfix_text_view.setVisibility(View.GONE);
        wheelstyresdescribedefectfill.setVisibility(View.GONE);
        wheelstyrestempfixfill.setVisibility(View.GONE);


        lightsreflectors_report_done_without_inspect.setVisibility(View.GONE);
        lightsreflectors_report_done_with_inspect.setVisibility(View.GONE);
        lightsreflectors_describe_defect_text_view.setVisibility(View.GONE);
        lightsreflectors_describe_tempfix_text_view.setVisibility(View.GONE);
        lightsreflectorsdescribedefectfill.setVisibility(View.GONE);
        lightsreflectorstempfixfill.setVisibility(View.GONE);



        exhaust_report_done_without_inspect.setVisibility(View.GONE);
        exhaust_report_done_with_inspect.setVisibility(View.GONE);
        exhaust_describe_defect_text_view.setVisibility(View.GONE);
        exhaust_describe_tempfix_text_view.setVisibility(View.GONE);
        exhaustdescribedefectfill.setVisibility(View.GONE);
        exhausttempfixfill.setVisibility(View.GONE);



        bodyguards_report_done_without_inspect.setVisibility(View.GONE);
        bodyguards_report_done_with_inspect.setVisibility(View.GONE);
        bodyguards_describe_defect_text_view.setVisibility(View.GONE);
        bodyguards_describe_tempfix_text_view.setVisibility(View.GONE);
        bodyguardsdescribedefectfill.setVisibility(View.GONE);
        bodyguardstempfixfill.setVisibility(View.GONE);



        landingleg_report_done_without_inspect.setVisibility(View.GONE);
        landingleg_report_done_with_inspect.setVisibility(View.GONE);
        landingleg_describe_defect_text_view.setVisibility(View.GONE);
        landingleg_describe_tempfix_text_view.setVisibility(View.GONE);
        landinglegdescribedefectfill.setVisibility(View.GONE);
        landinglegtempfixfill.setVisibility(View.GONE);



        sparetow_report_done_without_inspect.setVisibility(View.GONE);
        sparetow_report_done_with_inspect.setVisibility(View.GONE);
        sparetow_describe_defect_text_view.setVisibility(View.GONE);
        sparetow_describe_tempfix_text_view.setVisibility(View.GONE);
        sparetowdescribedefectfill.setVisibility(View.GONE);
        sparetowtempfixfill.setVisibility(View.GONE);



        trailerbrake_report_done_without_inspect.setVisibility(View.GONE);
        trailerbrake_report_done_with_inspect.setVisibility(View.GONE);
        trailerbrake_describe_defect_text_view.setVisibility(View.GONE);
        trailerbrake_describe_tempfix_text_view.setVisibility(View.GONE);
        trailerbrakedescribedefectfill.setVisibility(View.GONE);
        trailerbraketempfixfill.setVisibility(View.GONE);



        windowsandmirrors_report_done_without_inspect.setVisibility(View.GONE);
        windowsandmirrors_report_done_with_inspect.setVisibility(View.GONE);
        windows_and_mirrors_describe_defect_text_view.setVisibility(View.GONE);
        windows_and_mirrors_describe_tempfix_text_view.setVisibility(View.GONE);
        winmirdescribedefectfill.setVisibility(View.GONE);
        winmirtempfixfill.setVisibility(View.GONE);



        seatbelt_report_done_without_inspect.setVisibility(View.GONE);
        seatbelt_report_done_with_inspect.setVisibility(View.GONE);
        seatbelt_describe_defect_text_view.setVisibility(View.GONE);
        seatbelt_describe_tempfix_text_view.setVisibility(View.GONE);
        seatbeltdescribedefectfill.setVisibility(View.GONE);
        seatbelttempfixfill.setVisibility(View.GONE);


        washerandwiper_report_done_without_inspect.setVisibility(View.GONE);
        washerandwiper_report_done_with_inspect.setVisibility(View.GONE);
        washerandwiper_describe_defect_text_view.setVisibility(View.GONE);
        washerandwiper_describe_tempfix_text_view.setVisibility(View.GONE);
        washerandwiperdescribedefectfill.setVisibility(View.GONE);
        washerandwipertempfixfill.setVisibility(View.GONE);



        horn_report_done_without_inspect.setVisibility(View.GONE);
        horn_report_done_with_inspect.setVisibility(View.GONE);
        horn_describe_defect_text_view.setVisibility(View.GONE);
        horn_describe_tempfix_text_view.setVisibility(View.GONE);
        horndescribedefectfill.setVisibility(View.GONE);
        horntempfixfill.setVisibility(View.GONE);



        breakwarninglight_report_done_without_inspect.setVisibility(View.GONE);
        breakwarninglight_report_done_with_inspect.setVisibility(View.GONE);
        breakwarninglight_describe_defect_text_view.setVisibility(View.GONE);
        breakwarninglight_describe_tempfix_text_view.setVisibility(View.GONE);
        breakwarninglightdescribedefectfill.setVisibility(View.GONE);
        breakwarninglighttempfixfill.setVisibility(View.GONE);


        gauge_report_done_without_inspect.setVisibility(View.GONE);
        gauge_report_done_with_inspect.setVisibility(View.GONE);
        gauge_describe_defect_text_view.setVisibility(View.GONE);
        gauge_describe_tempfix_text_view.setVisibility(View.GONE);
        gaugedescribedefectfill.setVisibility(View.GONE);
        gaugetempfixfill.setVisibility(View.GONE);



        tacho_report_done_without_inspect.setVisibility(View.GONE);
        tacho_report_done_with_inspect.setVisibility(View.GONE);
        tacho_describe_defect_text_view.setVisibility(View.GONE);
        tacho_describe_tempfix_text_view.setVisibility(View.GONE);
        tachodescribedefectfill.setVisibility(View.GONE);
        tachotempfixfill.setVisibility(View.GONE);



        airleaks_report_done_without_inspect.setVisibility(View.GONE);
        airleaks_report_done_with_inspect.setVisibility(View.GONE);
        airleaks_describe_defect_text_view.setVisibility(View.GONE);
        airleaks_describe_tempfix_text_view.setVisibility(View.GONE);
        airleaksdescribedefectfill.setVisibility(View.GONE);
        airleakstempfixfill.setVisibility(View.GONE);



        steeringbreaking_report_done_without_inspect.setVisibility(View.GONE);
        steeringbreaking_report_done_with_inspect.setVisibility(View.GONE);
        steeringbreaking_describe_defect_text_view.setVisibility(View.GONE);
        steeringbreaking_describe_tempfix_text_view.setVisibility(View.GONE);
        steeringbreakingdescribedefectfill.setVisibility(View.GONE);
        steeringbreakingtempfixfill.setVisibility(View.GONE);



        loadsecure_report_done_without_inspect.setVisibility(View.GONE);
        loadsecure_report_done_with_inspect.setVisibility(View.GONE);
        loadsecure_describe_defect_text_view.setVisibility(View.GONE);
        loadsecure_describe_tempfix_text_view.setVisibility(View.GONE);
        loadsecuredescribedefectfill.setVisibility(View.GONE);
        loadsecuretempfixfill.setVisibility(View.GONE);



        tachospeedo_report_done_without_inspect.setVisibility(View.GONE);
        tachospeedo_report_done_with_inspect.setVisibility(View.GONE);
        tachospeedo_describe_defect_text_view.setVisibility(View.GONE);
        tachospeedo_describe_tempfix_text_view.setVisibility(View.GONE);
        tachospeedodescribedefectfill.setVisibility(View.GONE);
        tachospeedotempfixfill.setVisibility(View.GONE);



        nowarninglights_report_done_without_inspect.setVisibility(View.GONE);
        nowarninglights_report_done_with_inspect.setVisibility(View.GONE);
        nowarninglights_describe_defect_text_view.setVisibility(View.GONE);
        nowarninglights_describe_tempfix_text_view.setVisibility(View.GONE);
        nowarninglightsdescribedefectfill.setVisibility(View.GONE);
        nowarninglightstempfixfill.setVisibility(View.GONE);



        //<<--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------




        if (position != -1) {
            getSupportActionBar().setTitle("Edit Entry");
            searchPerson(position);
            person = new Person();
        } else {
            getSupportActionBar().setTitle("Add Entry");
            person = null;
        }


        windowsandmirrors_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_Windows_and_Mirrors dialogFragment2 = Info_Box_Windows_and_Mirrors.newInstance("windowsandmirrors_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        seatbelt_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_seatbelt dialogFragment2 = Info_Box_seatbelt.newInstance("seatbelt_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        washerandwiper_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_Washers_and_Wipers dialogFragment2 = Info_Box_Washers_and_Wipers.newInstance("washerandwiper_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        horn_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_Horn dialogFragment2 = Info_Box_Horn.newInstance("horn_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        breakwarninglight_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_breakwarninglight dialogFragment2 = Info_Box_breakwarninglight.newInstance("breakwarninglight_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        gauge_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_gauge dialogFragment2 = Info_Box_gauge.newInstance("gauge_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        tacho_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_tacho dialogFragment2 = Info_Box_tacho.newInstance("tacho_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        airleaks_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_airleaks dialogFragment2 = Info_Box_airleaks.newInstance("airleaks_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        //Driving Inspection

        steeringbreaking_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_steeringbreaking dialogFragment2 = Info_Box_steeringbreaking.newInstance("steeringbreaking_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        loadsecure_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_loadsecure dialogFragment2 = Info_Box_loadsecure.newInstance("loadsecure_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        tachospeedo_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_tachospeedo dialogFragment2 = Info_Box_tachospeedo.newInstance("tachospeedo_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        nowarninglights_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_nowarninglights dialogFragment2 = Info_Box_nowarninglights.newInstance("nowarninglights_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        //Outside Inspection

        taxinsurance_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_taxinsurance dialogFragment2 = Info_Box_taxinsurance.newInstance("taxinsurance_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        wheelstyres_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_wheelstyres dialogFragment2 = Info_Box_wheelstyres.newInstance("wheelstyres_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        lightsreflectors_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_lightsreflectors dialogFragment2 = Info_Box_lightsreflectors.newInstance("lightsreflectors_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });
        exhaust_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_exhaust dialogFragment2 = Info_Box_exhaust.newInstance("exhaust_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });
        sparetow_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_sparetow dialogFragment2 = Info_Box_sparetow.newInstance("sparetow_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });
        trailerbrake_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_trailerbrake dialogFragment2 = Info_Box_trailerbrake.newInstance("trailerbrake_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        bodyguards_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_bodyguards dialogFragment2 = Info_Box_bodyguards.newInstance("bodyguards_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        landingleg_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_landingleg dialogFragment2 = Info_Box_landingleg.newInstance("landingleg_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        regplate_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_regplate dialogFragment2 = Info_Box_regplate.newInstance("regplate_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });

        fluidleaks_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_fluidleaks dialogFragment2 = Info_Box_fluidleaks.newInstance("fluidleaks_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });
        airelectrial_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_airelectrial dialogFragment2 = Info_Box_airelectrial.newInstance("airelectrial_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });
        airsuspension_icon_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                Info_Box_airsuspension dialogFragment2 = Info_Box_airsuspension.newInstance("airsuspension_icon_image");
                dialogFragment2.show(fm, "Sample Fragment");
            }
        });


        ///////////////////////////////////////////////////////////////////////////////////


        // 2 Buttons , No Defect , Defect and Uroadworty

        if (position != -1) {
            getSupportActionBar().setTitle("Edit Entry");
            searchPerson(position);
            person = new Person();
        } else {
            getSupportActionBar().setTitle("Add Entry");
            person = null;
        }

        vehiclephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, CAMERA_REQUEST_CODE25);
                photoplace100x100vehiclephoto.setVisibility(View.VISIBLE);
            }
        });

//------------------------------------------------------------------------//------------------------------------------------------------------------Tax and Insurance------------------------------------------------



        taxinsurance_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                taxinsurance_icon_image.setVisibility(View.VISIBLE);



                taxinsurance_inspect_button_defect.setVisibility(View.VISIBLE);
                taxinsurance_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                taxinsurance_backbutton_defect.setVisibility(View.GONE);
                taxinsurance_report_done_with_inspect.setVisibility(View.GONE);
                taxinsurance_report_done_without_inspect.setVisibility(View.GONE);

                taxinsurance_describe_defect_text_view.setVisibility(View.GONE);
                taxinsurancedescribedefectfill.setVisibility(View.GONE);
                taxinsurance_describe_tempfix_text_view.setVisibility(View.GONE);
                taxinsurancetempfixfill.setVisibility(View.GONE);


            }
        });

        taxinsurance_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();


                if (taxinsurancebackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("taxinsurance_button_defect");
                    taxinsurance_icon_image.setVisibility(View.GONE);
                    taxinsurance_inspect_button_defect.setVisibility(View.GONE);
                    taxinsurance_inspect_button_tick_defect.setVisibility(View.GONE);
                    taxinsurance_backbutton_defect.setVisibility(View.VISIBLE);
                    taxinsurance_report_done_with_inspect.setVisibility(View.VISIBLE);
                    taxinsurance_describe_defect_text_view.setText("Describe Defect");
                    taxinsurance_describe_defect_text_view.setVisibility(View.VISIBLE);
                    taxinsurancedescribedefectfill.setVisibility(View.VISIBLE);
                    taxinsurance_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    taxinsurancetempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("taxinsurance_button_defect");
                    taxinsurance_icon_image.setVisibility(View.GONE);

                    taxinsurance_inspect_button_defect.setVisibility(View.GONE);
                    taxinsurance_inspect_button_tick_defect.setVisibility(View.GONE);
                    taxinsurance_backbutton_defect.setVisibility(View.VISIBLE);
                    taxinsurance_report_done_with_inspect.setVisibility(View.VISIBLE);
                    taxinsurance_describe_defect_text_view.setText("Describe Defect");
                    taxinsurance_describe_defect_text_view.setVisibility(View.VISIBLE);
                    taxinsurancedescribedefectfill.setVisibility(View.VISIBLE);
                    taxinsurance_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    taxinsurancetempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        taxinsurance_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                taxinsurance_icon_image.setVisibility(View.GONE);

                taxinsurance_inspect_button_defect.setVisibility(View.GONE);
                taxinsurance_inspect_button_tick_defect.setVisibility(View.GONE);
                taxinsurance_backbutton_defect.setVisibility(View.VISIBLE);
                taxinsurance_report_done_without_inspect.setVisibility(View.VISIBLE);
                taxinsurance_describe_defect_text_view.setText("Tax and Insurance has :");
                taxinsurance_describe_defect_text_view.setVisibility(View.VISIBLE);
                taxinsurancedescribedefectfill.setText("No Defects");
                taxinsurancedescribedefectfill.setVisibility(View.VISIBLE);
                taxinsurance_describe_tempfix_text_view.setVisibility(View.GONE);
                taxinsurancetempfixfill.setVisibility(View.GONE);
                taxinsurancetempfixfill.setText("None Required");

            }
        });
//------------------------------------------------------------------------//------------------------------------------------------------------------REG PLATE------------------------------------------------



        regplate_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                regplate_icon_image.setVisibility(View.VISIBLE);


                regplate_inspect_button_defect.setVisibility(View.VISIBLE);
                regplate_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                regplate_backbutton_defect.setVisibility(View.GONE);
                regplate_report_done_with_inspect.setVisibility(View.GONE);
                regplate_report_done_without_inspect.setVisibility(View.GONE);

                regplate_describe_defect_text_view.setVisibility(View.GONE);
                regplatedescribedefectfill.setVisibility(View.GONE);
                regplate_describe_tempfix_text_view.setVisibility(View.GONE);
                regplatetempfixfill.setVisibility(View.GONE);


            }
        });

        regplate_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();



                if (regplatebackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("regplate_button_defect");
                    regplate_icon_image.setVisibility(View.GONE);
                    regplate_inspect_button_defect.setVisibility(View.GONE);
                    regplate_inspect_button_tick_defect.setVisibility(View.GONE);
                    regplate_backbutton_defect.setVisibility(View.VISIBLE);
                    regplate_report_done_with_inspect.setVisibility(View.VISIBLE);
                    regplate_describe_defect_text_view.setText("Describe Defect");
                    regplate_describe_defect_text_view.setVisibility(View.VISIBLE);
                    regplatedescribedefectfill.setVisibility(View.VISIBLE);
                    regplate_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    regplatetempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("regplate_button_defect");
                    regplate_icon_image.setVisibility(View.GONE);

                    regplate_inspect_button_defect.setVisibility(View.GONE);
                    regplate_inspect_button_tick_defect.setVisibility(View.GONE);
                    regplate_backbutton_defect.setVisibility(View.VISIBLE);
                    regplate_report_done_with_inspect.setVisibility(View.VISIBLE);
                    regplate_describe_defect_text_view.setText("Describe Defect");
                    regplate_describe_defect_text_view.setVisibility(View.VISIBLE);
                    regplatedescribedefectfill.setVisibility(View.VISIBLE);
                    regplate_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    regplatetempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        regplate_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                regplate_icon_image.setVisibility(View.GONE);

                regplate_inspect_button_defect.setVisibility(View.GONE);
                regplate_inspect_button_tick_defect.setVisibility(View.GONE);
                regplate_backbutton_defect.setVisibility(View.VISIBLE);
                regplate_report_done_without_inspect.setVisibility(View.VISIBLE);
                regplate_describe_defect_text_view.setText("Reg Plate has :");
                regplate_describe_defect_text_view.setVisibility(View.VISIBLE);
                regplatedescribedefectfill.setText("No Defects");
                regplatedescribedefectfill.setVisibility(View.VISIBLE);
                regplate_describe_tempfix_text_view.setVisibility(View.GONE);
                regplatetempfixfill.setVisibility(View.GONE);
                regplatetempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------Air and Electrial------------------------------------------------



        airelectrial_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                airelectrial_icon_image.setVisibility(View.VISIBLE);


                airelectrial_inspect_button_defect.setVisibility(View.VISIBLE);
                airelectrial_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                airelectrial_backbutton_defect.setVisibility(View.GONE);
                airelectrial_report_done_with_inspect.setVisibility(View.GONE);
                airelectrial_report_done_without_inspect.setVisibility(View.GONE);

                airelectrial_describe_defect_text_view.setVisibility(View.GONE);
                airelectrialdescribedefectfill.setVisibility(View.GONE);
                airelectrial_describe_tempfix_text_view.setVisibility(View.GONE);
                airelectrialtempfixfill.setVisibility(View.GONE);


            }
        });

        airelectrial_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();


                if (airelectrialbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("airelectrial_button_defect");
                    airelectrial_icon_image.setVisibility(View.GONE);
                    airelectrial_inspect_button_defect.setVisibility(View.GONE);
                    airelectrial_inspect_button_tick_defect.setVisibility(View.GONE);
                    airelectrial_backbutton_defect.setVisibility(View.VISIBLE);
                    airelectrial_report_done_with_inspect.setVisibility(View.VISIBLE);
                    airelectrial_describe_defect_text_view.setText("Describe Defect");
                    airelectrial_describe_defect_text_view.setVisibility(View.VISIBLE);
                    airelectrialdescribedefectfill.setVisibility(View.VISIBLE);
                    airelectrial_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    airelectrialtempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("airelectrial_button_defect");
                    airelectrial_icon_image.setVisibility(View.GONE);

                    airelectrial_inspect_button_defect.setVisibility(View.GONE);
                    airelectrial_inspect_button_tick_defect.setVisibility(View.GONE);
                    airelectrial_backbutton_defect.setVisibility(View.VISIBLE);
                    airelectrial_report_done_with_inspect.setVisibility(View.VISIBLE);
                    airelectrial_describe_defect_text_view.setText("Describe Defect");
                    airelectrial_describe_defect_text_view.setVisibility(View.VISIBLE);
                    airelectrialdescribedefectfill.setVisibility(View.VISIBLE);
                    airelectrial_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    airelectrialtempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        airelectrial_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                airelectrial_icon_image.setVisibility(View.GONE);

                airelectrial_inspect_button_defect.setVisibility(View.GONE);
                airelectrial_inspect_button_tick_defect.setVisibility(View.GONE);
                airelectrial_backbutton_defect.setVisibility(View.VISIBLE);
                airelectrial_report_done_without_inspect.setVisibility(View.VISIBLE);
                airelectrial_describe_defect_text_view.setText("Air and Electrial has :");
                airelectrial_describe_defect_text_view.setVisibility(View.VISIBLE);
                airelectrialdescribedefectfill.setText("No Defects");
                airelectrialdescribedefectfill.setVisibility(View.VISIBLE);
                airelectrial_describe_tempfix_text_view.setVisibility(View.GONE);
                airelectrialtempfixfill.setVisibility(View.GONE);
                airelectrialtempfixfill.setText("None Required");

            }
        });

//------------------------------------------------------------------------//------------------------------------------------------------------------FLUID LEAKS------------------------------------------------



        fluidleaks_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                fluidleaks_icon_image.setVisibility(View.VISIBLE);


                fluidleaks_inspect_button_defect.setVisibility(View.VISIBLE);
                fluidleaks_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                fluidleaks_backbutton_defect.setVisibility(View.GONE);
                fluidleaks_report_done_with_inspect.setVisibility(View.GONE);
                fluidleaks_report_done_without_inspect.setVisibility(View.GONE);

                fluidleaks_describe_defect_text_view.setVisibility(View.GONE);
                fluidleaksdescribedefectfill.setVisibility(View.GONE);
                fluidleaks_describe_tempfix_text_view.setVisibility(View.GONE);
                fluidleakstempfixfill.setVisibility(View.GONE);


            }
        });

        fluidleaks_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();


                if (fluidleaksbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("fluidleaks_button_defect");
                    fluidleaks_icon_image.setVisibility(View.GONE);
                    fluidleaks_inspect_button_defect.setVisibility(View.GONE);
                    fluidleaks_inspect_button_tick_defect.setVisibility(View.GONE);
                    fluidleaks_backbutton_defect.setVisibility(View.VISIBLE);
                    fluidleaks_report_done_with_inspect.setVisibility(View.VISIBLE);
                    fluidleaks_describe_defect_text_view.setText("Describe Defect");
                    fluidleaks_describe_defect_text_view.setVisibility(View.VISIBLE);
                    fluidleaksdescribedefectfill.setVisibility(View.VISIBLE);
                    fluidleaks_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    fluidleakstempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("fluidleaks_button_defect");
                    fluidleaks_icon_image.setVisibility(View.GONE);

                    fluidleaks_inspect_button_defect.setVisibility(View.GONE);
                    fluidleaks_inspect_button_tick_defect.setVisibility(View.GONE);
                    fluidleaks_backbutton_defect.setVisibility(View.VISIBLE);
                    fluidleaks_report_done_with_inspect.setVisibility(View.VISIBLE);
                    fluidleaks_describe_defect_text_view.setText("Describe Defect");
                    fluidleaks_describe_defect_text_view.setVisibility(View.VISIBLE);
                    fluidleaksdescribedefectfill.setVisibility(View.VISIBLE);
                    fluidleaks_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    fluidleakstempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        fluidleaks_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                fluidleaks_icon_image.setVisibility(View.GONE);

                fluidleaks_inspect_button_defect.setVisibility(View.GONE);
                fluidleaks_inspect_button_tick_defect.setVisibility(View.GONE);
                fluidleaks_backbutton_defect.setVisibility(View.VISIBLE);
                fluidleaks_report_done_without_inspect.setVisibility(View.VISIBLE);
                fluidleaks_describe_defect_text_view.setText("Fluid and Leaks has :");
                fluidleaks_describe_defect_text_view.setVisibility(View.VISIBLE);
                fluidleaksdescribedefectfill.setText("No Defects");
                fluidleaksdescribedefectfill.setVisibility(View.VISIBLE);
                fluidleaks_describe_tempfix_text_view.setVisibility(View.GONE);
                fluidleakstempfixfill.setVisibility(View.GONE);
                fluidleakstempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------ Air Suspension------------------------------------------------


        airsuspension_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                airsuspension_icon_image.setVisibility(View.VISIBLE);


                airsuspension_inspect_button_defect.setVisibility(View.VISIBLE);
                airsuspension_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                airsuspension_backbutton_defect.setVisibility(View.GONE);
                airsuspension_report_done_with_inspect.setVisibility(View.GONE);
                airsuspension_report_done_without_inspect.setVisibility(View.GONE);

                airsuspension_describe_defect_text_view.setVisibility(View.GONE);
                airsuspensiondescribedefectfill.setVisibility(View.GONE);
                airsuspension_describe_tempfix_text_view.setVisibility(View.GONE);
                airsuspensiontempfixfill.setVisibility(View.GONE);


            }
        });

        airsuspension_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();


                if ( airsuspensionbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("airsuspension_button_defect");
                    airsuspension_icon_image.setVisibility(View.GONE);
                    airsuspension_inspect_button_defect.setVisibility(View.GONE);
                    airsuspension_inspect_button_tick_defect.setVisibility(View.GONE);
                    airsuspension_backbutton_defect.setVisibility(View.VISIBLE);
                    airsuspension_report_done_with_inspect.setVisibility(View.VISIBLE);
                    airsuspension_describe_defect_text_view.setText("Describe Defect");
                    airsuspension_describe_defect_text_view.setVisibility(View.VISIBLE);
                    airsuspensiondescribedefectfill.setVisibility(View.VISIBLE);
                    airsuspension_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    airsuspensiontempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("airsuspension_button_defect");
                    airsuspension_icon_image.setVisibility(View.GONE);

                    airsuspension_inspect_button_defect.setVisibility(View.GONE);
                    airsuspension_inspect_button_tick_defect.setVisibility(View.GONE);
                    airsuspension_backbutton_defect.setVisibility(View.VISIBLE);
                    airsuspension_report_done_with_inspect.setVisibility(View.VISIBLE);
                    airsuspension_describe_defect_text_view.setText("Describe Defect");
                    airsuspension_describe_defect_text_view.setVisibility(View.VISIBLE);
                    airsuspensiondescribedefectfill.setVisibility(View.VISIBLE);
                    airsuspension_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    airsuspensiontempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        airsuspension_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                airsuspension_icon_image.setVisibility(View.GONE);

                airsuspension_inspect_button_defect.setVisibility(View.GONE);
                airsuspension_inspect_button_tick_defect.setVisibility(View.GONE);
                airsuspension_backbutton_defect.setVisibility(View.VISIBLE);
                airsuspension_report_done_without_inspect.setVisibility(View.VISIBLE);
                airsuspension_describe_defect_text_view.setText("Air Suspension has :");
                airsuspension_describe_defect_text_view.setVisibility(View.VISIBLE);
                airsuspensiondescribedefectfill.setText("No Defects");
                airsuspensiondescribedefectfill.setVisibility(View.VISIBLE);
                airsuspension_describe_tempfix_text_view.setVisibility(View.GONE);
                airsuspensiontempfixfill.setVisibility(View.GONE);
                airsuspensiontempfixfill.setText("None Required");

            }
        });



        //------------------------------------------------------------------------//------------------------------------------------------------------------Wheels and Tyres ------------------------------------------------



        wheelsandtyres_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                wheelstyres_icon_image.setVisibility(View.VISIBLE);


                wheelstyres_inspect_button_defect.setVisibility(View.VISIBLE);
                wheelstyres_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                wheelsandtyres_backbutton_defect.setVisibility(View.GONE);
                wheelsandtyres_report_done_with_inspect.setVisibility(View.GONE);
                wheelsandtyres_report_done_without_inspect.setVisibility(View.GONE);

                wheelstyres_describe_defect_text_view.setVisibility(View.GONE);
                wheelstyresdescribedefectfill.setVisibility(View.GONE);
                wheelstyres_describe_tempfix_text_view.setVisibility(View.GONE);
                wheelstyrestempfixfill.setVisibility(View.GONE);


            }
        });

        wheelstyres_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();


                if ( wheelsandtyresbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("wheelstyres_button_defect");
                    wheelstyres_icon_image.setVisibility(View.GONE);
                    wheelstyres_inspect_button_defect.setVisibility(View.GONE);
                    wheelstyres_inspect_button_tick_defect.setVisibility(View.GONE);
                    wheelsandtyres_backbutton_defect.setVisibility(View.VISIBLE);
                    wheelsandtyres_report_done_with_inspect.setVisibility(View.VISIBLE);
                    wheelstyres_describe_defect_text_view.setText("Describe Defect");
                    wheelstyres_describe_defect_text_view.setVisibility(View.VISIBLE);
                    wheelstyresdescribedefectfill.setVisibility(View.VISIBLE);
                    wheelstyres_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    wheelstyrestempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("wheelstyres_button_defect");
                    wheelstyres_icon_image.setVisibility(View.GONE);

                    wheelstyres_inspect_button_defect.setVisibility(View.GONE);
                    wheelstyres_inspect_button_tick_defect.setVisibility(View.GONE);
                    wheelsandtyres_backbutton_defect.setVisibility(View.VISIBLE);
                    wheelsandtyres_report_done_with_inspect.setVisibility(View.VISIBLE);
                    wheelstyres_describe_defect_text_view.setText("Describe Defect");
                    wheelstyres_describe_defect_text_view.setVisibility(View.VISIBLE);
                    wheelstyresdescribedefectfill.setVisibility(View.VISIBLE);
                    wheelstyres_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    wheelstyrestempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        wheelstyres_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                wheelstyres_icon_image.setVisibility(View.GONE);

                wheelstyres_inspect_button_defect.setVisibility(View.GONE);
                wheelstyres_inspect_button_tick_defect.setVisibility(View.GONE);
                wheelsandtyres_backbutton_defect.setVisibility(View.VISIBLE);
                wheelsandtyres_report_done_without_inspect.setVisibility(View.VISIBLE);
                wheelstyres_describe_defect_text_view.setText("Wheels and Tyres has :");
                wheelstyres_describe_defect_text_view.setVisibility(View.VISIBLE);
                wheelstyresdescribedefectfill.setText("No Defects");
                wheelstyresdescribedefectfill.setVisibility(View.VISIBLE);
                wheelstyres_describe_tempfix_text_view.setVisibility(View.GONE);
                wheelstyrestempfixfill.setVisibility(View.GONE);
                wheelstyrestempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------Lights and Reflectors ------------------------------------------------



        lightsreflectors_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                lightsreflectors_icon_image.setVisibility(View.VISIBLE);

                lightsreflectors_inspect_button_defect.setVisibility(View.VISIBLE);
                lightsreflectors_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                lightsreflectors_backbutton_defect.setVisibility(View.GONE);
                lightsreflectors_report_done_with_inspect.setVisibility(View.GONE);
                lightsreflectors_report_done_without_inspect.setVisibility(View.GONE);

                lightsreflectors_describe_defect_text_view.setVisibility(View.GONE);
                lightsreflectorsdescribedefectfill.setVisibility(View.GONE);
                lightsreflectors_describe_tempfix_text_view.setVisibility(View.GONE);
                lightsreflectorstempfixfill.setVisibility(View.GONE);


            }
        });

        lightsreflectors_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();


                if ( lightsreflectorsbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("lightsreflectors_button_defect");
                    lightsreflectors_icon_image.setVisibility(View.GONE);
                    lightsreflectors_inspect_button_defect.setVisibility(View.GONE);
                    lightsreflectors_inspect_button_tick_defect.setVisibility(View.GONE);
                    lightsreflectors_backbutton_defect.setVisibility(View.VISIBLE);
                    lightsreflectors_report_done_with_inspect.setVisibility(View.VISIBLE);
                    lightsreflectors_describe_defect_text_view.setText("Describe Defect");
                    lightsreflectors_describe_defect_text_view.setVisibility(View.VISIBLE);
                    lightsreflectorsdescribedefectfill.setVisibility(View.VISIBLE);
                    lightsreflectors_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    lightsreflectorstempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("lightsreflectors_button_defect");
                    lightsreflectors_icon_image.setVisibility(View.GONE);

                    lightsreflectors_inspect_button_defect.setVisibility(View.GONE);
                    lightsreflectors_inspect_button_tick_defect.setVisibility(View.GONE);
                    lightsreflectors_backbutton_defect.setVisibility(View.VISIBLE);
                    lightsreflectors_report_done_with_inspect.setVisibility(View.VISIBLE);
                    lightsreflectors_describe_defect_text_view.setText("Describe Defect");
                    lightsreflectors_describe_defect_text_view.setVisibility(View.VISIBLE);
                    lightsreflectorsdescribedefectfill.setVisibility(View.VISIBLE);
                    lightsreflectors_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    lightsreflectorstempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        lightsreflectors_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                lightsreflectors_icon_image.setVisibility(View.GONE);

                lightsreflectors_inspect_button_defect.setVisibility(View.GONE);
                lightsreflectors_inspect_button_tick_defect.setVisibility(View.GONE);
                lightsreflectors_backbutton_defect.setVisibility(View.VISIBLE);
                lightsreflectors_report_done_without_inspect.setVisibility(View.VISIBLE);
                lightsreflectors_describe_defect_text_view.setText("Lights and Reflectors has :");
                lightsreflectors_describe_defect_text_view.setVisibility(View.VISIBLE);
                lightsreflectorsdescribedefectfill.setText("No Defects");
                lightsreflectorsdescribedefectfill.setVisibility(View.VISIBLE);
                lightsreflectors_describe_tempfix_text_view.setVisibility(View.GONE);
                lightsreflectorstempfixfill.setVisibility(View.GONE);
                lightsreflectorstempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------Exhaust------------------------------------------------



        exhaust_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                exhaust_icon_image.setVisibility(View.VISIBLE);

                exhaust_inspect_button_defect.setVisibility(View.VISIBLE);
                exhaust_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                exhaust_backbutton_defect.setVisibility(View.GONE);
                exhaust_report_done_with_inspect.setVisibility(View.GONE);
                exhaust_report_done_without_inspect.setVisibility(View.GONE);

                exhaust_describe_defect_text_view.setVisibility(View.GONE);
                exhaustdescribedefectfill.setVisibility(View.GONE);
                exhaust_describe_tempfix_text_view.setVisibility(View.GONE);
                exhausttempfixfill.setVisibility(View.GONE);


            }
        });

        exhaust_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();


                if ( exhaustbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("exhaust_button_defect");
                    exhaust_icon_image.setVisibility(View.GONE);
                    exhaust_inspect_button_defect.setVisibility(View.GONE);
                    exhaust_inspect_button_tick_defect.setVisibility(View.GONE);
                    exhaust_backbutton_defect.setVisibility(View.VISIBLE);
                    exhaust_report_done_with_inspect.setVisibility(View.VISIBLE);
                    exhaust_describe_defect_text_view.setText("Describe Defect");
                    exhaust_describe_defect_text_view.setVisibility(View.VISIBLE);
                    exhaustdescribedefectfill.setVisibility(View.VISIBLE);
                    exhaust_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    exhausttempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("exhaust_button_defect");
                    exhaust_icon_image.setVisibility(View.GONE);

                    exhaust_inspect_button_defect.setVisibility(View.GONE);
                    exhaust_inspect_button_tick_defect.setVisibility(View.GONE);
                    exhaust_backbutton_defect.setVisibility(View.VISIBLE);
                    exhaust_report_done_with_inspect.setVisibility(View.VISIBLE);
                    exhaust_describe_defect_text_view.setText("Describe Defect");
                    exhaust_describe_defect_text_view.setVisibility(View.VISIBLE);
                    exhaustdescribedefectfill.setVisibility(View.VISIBLE);
                    exhaust_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    exhausttempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        exhaust_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                exhaust_icon_image.setVisibility(View.GONE);

                exhaust_inspect_button_defect.setVisibility(View.GONE);
                exhaust_inspect_button_tick_defect.setVisibility(View.GONE);
                exhaust_backbutton_defect.setVisibility(View.VISIBLE);
                exhaust_report_done_without_inspect.setVisibility(View.VISIBLE);
                exhaust_describe_defect_text_view.setText("Exhaust has :");
                exhaust_describe_defect_text_view.setVisibility(View.VISIBLE);
                exhaustdescribedefectfill.setText("No Defects");
                exhaustdescribedefectfill.setVisibility(View.VISIBLE);
                exhaust_describe_tempfix_text_view.setVisibility(View.GONE);
                exhausttempfixfill.setVisibility(View.GONE);
                exhausttempfixfill.setText("None Required");

            }
        });


        //------------------------------------------------------------------------//------------------------------------------------------------------------ Body Guards------------------------------------------------



        bodyguards_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                bodyguards_icon_image.setVisibility(View.VISIBLE);


                bodyguards_inspect_button_defect.setVisibility(View.VISIBLE);
                bodyguards_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                bodyguards_backbutton_defect.setVisibility(View.GONE);
                bodyguards_report_done_with_inspect.setVisibility(View.GONE);
                bodyguards_report_done_without_inspect.setVisibility(View.GONE);

                bodyguards_describe_defect_text_view.setVisibility(View.GONE);
                bodyguardsdescribedefectfill.setVisibility(View.GONE);
                bodyguards_describe_tempfix_text_view.setVisibility(View.GONE);
                bodyguardstempfixfill.setVisibility(View.GONE);


            }
        });

        bodyguards_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();

                if ( bodyguardsbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("bodyguards_button_defect");
                    bodyguards_icon_image.setVisibility(View.GONE);
                    bodyguards_inspect_button_defect.setVisibility(View.GONE);
                    bodyguards_inspect_button_tick_defect.setVisibility(View.GONE);
                    bodyguards_backbutton_defect.setVisibility(View.VISIBLE);
                    bodyguards_report_done_with_inspect.setVisibility(View.VISIBLE);
                    bodyguards_describe_defect_text_view.setText("Describe Defect");
                    bodyguards_describe_defect_text_view.setVisibility(View.VISIBLE);
                    bodyguardsdescribedefectfill.setVisibility(View.VISIBLE);
                    bodyguards_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    bodyguardstempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("bodyguards_button_defect");
                    bodyguards_icon_image.setVisibility(View.GONE);

                    bodyguards_inspect_button_defect.setVisibility(View.GONE);
                    bodyguards_inspect_button_tick_defect.setVisibility(View.GONE);
                    bodyguards_backbutton_defect.setVisibility(View.VISIBLE);
                    bodyguards_report_done_with_inspect.setVisibility(View.VISIBLE);
                    bodyguards_describe_defect_text_view.setText("Describe Defect");
                    bodyguards_describe_defect_text_view.setVisibility(View.VISIBLE);
                    bodyguardsdescribedefectfill.setVisibility(View.VISIBLE);
                    bodyguards_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    bodyguardstempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        bodyguards_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                bodyguards_icon_image.setVisibility(View.GONE);

                bodyguards_inspect_button_defect.setVisibility(View.GONE);
                bodyguards_inspect_button_tick_defect.setVisibility(View.GONE);
                bodyguards_backbutton_defect.setVisibility(View.VISIBLE);
                bodyguards_report_done_without_inspect.setVisibility(View.VISIBLE);
                bodyguards_describe_defect_text_view.setText("Body and Guards has :");
                bodyguards_describe_defect_text_view.setVisibility(View.VISIBLE);
                bodyguardsdescribedefectfill.setText("No Defects");
                bodyguardsdescribedefectfill.setVisibility(View.VISIBLE);
                bodyguards_describe_tempfix_text_view.setVisibility(View.GONE);
                bodyguardstempfixfill.setVisibility(View.GONE);
                bodyguardstempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------ Landing Leg ------------------------------------------------



        landingleg_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                landingleg_icon_image.setVisibility(View.VISIBLE);


                landingleg_inspect_button_defect.setVisibility(View.VISIBLE);
                landingleg_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                landingleg_backbutton_defect.setVisibility(View.GONE);
                landingleg_report_done_with_inspect.setVisibility(View.GONE);
                landingleg_report_done_without_inspect.setVisibility(View.GONE);

                landingleg_describe_defect_text_view.setVisibility(View.GONE);
                landinglegdescribedefectfill.setVisibility(View.GONE);
                landingleg_describe_tempfix_text_view.setVisibility(View.GONE);
                landinglegtempfixfill.setVisibility(View.GONE);


            }
        });

        landingleg_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();


                if ( landinglegbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("landingleg_button_defect");
                    landingleg_icon_image.setVisibility(View.GONE);
                    landingleg_inspect_button_defect.setVisibility(View.GONE);
                    landingleg_inspect_button_tick_defect.setVisibility(View.GONE);
                    landingleg_backbutton_defect.setVisibility(View.VISIBLE);
                    landingleg_report_done_with_inspect.setVisibility(View.VISIBLE);
                    landingleg_describe_defect_text_view.setText("Describe Defect");
                    landingleg_describe_defect_text_view.setVisibility(View.VISIBLE);
                    landinglegdescribedefectfill.setVisibility(View.VISIBLE);
                    landingleg_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    landinglegtempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("landingleg_button_defect");
                    landingleg_icon_image.setVisibility(View.GONE);

                    landingleg_inspect_button_defect.setVisibility(View.GONE);
                    landingleg_inspect_button_tick_defect.setVisibility(View.GONE);
                    landingleg_backbutton_defect.setVisibility(View.VISIBLE);
                    landingleg_report_done_with_inspect.setVisibility(View.VISIBLE);
                    landingleg_describe_defect_text_view.setText("Describe Defect");
                    landingleg_describe_defect_text_view.setVisibility(View.VISIBLE);
                    landinglegdescribedefectfill.setVisibility(View.VISIBLE);
                    landingleg_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    landinglegtempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        landingleg_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                landingleg_icon_image.setVisibility(View.GONE);

                landingleg_inspect_button_defect.setVisibility(View.GONE);
                landingleg_inspect_button_tick_defect.setVisibility(View.GONE);
                landingleg_backbutton_defect.setVisibility(View.VISIBLE);
                landingleg_report_done_without_inspect.setVisibility(View.VISIBLE);
                landingleg_describe_defect_text_view.setText("Landing Leg has :");
                landingleg_describe_defect_text_view.setVisibility(View.VISIBLE);
                landinglegdescribedefectfill.setText("No Defects");
                landinglegdescribedefectfill.setVisibility(View.VISIBLE);
                landingleg_describe_tempfix_text_view.setVisibility(View.GONE);
                landinglegtempfixfill.setVisibility(View.GONE);
                landinglegtempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------Spare Tow ------------------------------------------------



        sparetow_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                sparetow_icon_image.setVisibility(View.VISIBLE);

                sparetow_inspect_button_defect.setVisibility(View.VISIBLE);
                sparetow_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                sparetow_backbutton_defect.setVisibility(View.GONE);
                sparetow_report_done_with_inspect.setVisibility(View.GONE);
                sparetow_report_done_without_inspect.setVisibility(View.GONE);

                sparetow_describe_defect_text_view.setVisibility(View.GONE);
                sparetowdescribedefectfill.setVisibility(View.GONE);
                sparetow_describe_tempfix_text_view.setVisibility(View.GONE);
                sparetowtempfixfill.setVisibility(View.GONE);


            }
        });

        sparetow_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();

                if ( sparetowbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("sparetow_button_defect");
                    sparetow_icon_image.setVisibility(View.GONE);
                    sparetow_inspect_button_defect.setVisibility(View.GONE);
                    sparetow_inspect_button_tick_defect.setVisibility(View.GONE);
                    sparetow_backbutton_defect.setVisibility(View.VISIBLE);
                    sparetow_report_done_with_inspect.setVisibility(View.VISIBLE);
                    sparetow_describe_defect_text_view.setText("Describe Defect");
                    sparetow_describe_defect_text_view.setVisibility(View.VISIBLE);
                    sparetowdescribedefectfill.setVisibility(View.VISIBLE);
                    sparetow_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    sparetowtempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("sparetow_button_defect");
                    sparetow_icon_image.setVisibility(View.GONE);

                    sparetow_inspect_button_defect.setVisibility(View.GONE);
                    sparetow_inspect_button_tick_defect.setVisibility(View.GONE);
                    sparetow_backbutton_defect.setVisibility(View.VISIBLE);
                    sparetow_report_done_with_inspect.setVisibility(View.VISIBLE);
                    sparetow_describe_defect_text_view.setText("Describe Defect");
                    sparetow_describe_defect_text_view.setVisibility(View.VISIBLE);
                    sparetowdescribedefectfill.setVisibility(View.VISIBLE);
                    sparetow_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    sparetowtempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        sparetow_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                sparetow_icon_image.setVisibility(View.GONE);

                sparetow_inspect_button_defect.setVisibility(View.GONE);
                sparetow_inspect_button_tick_defect.setVisibility(View.GONE);
                sparetow_backbutton_defect.setVisibility(View.VISIBLE);
                sparetow_report_done_without_inspect.setVisibility(View.VISIBLE);
                sparetow_describe_defect_text_view.setText("Spare Tow has :");
                sparetow_describe_defect_text_view.setVisibility(View.VISIBLE);
                sparetowdescribedefectfill.setText("No Defects");
                sparetowdescribedefectfill.setVisibility(View.VISIBLE);
                sparetow_describe_tempfix_text_view.setVisibility(View.GONE);
                sparetowtempfixfill.setVisibility(View.GONE);
                sparetowtempfixfill.setText("None Required");

            }
        });



        //------------------------------------------------------------------------//------------------------------------------------------------------------Trailer Brake------------------------------------------------



        trailerbrake_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                trailerbrake_icon_image.setVisibility(View.VISIBLE);


                trailerbrake_inspect_button_defect.setVisibility(View.VISIBLE);
                trailerbrake_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                trailerbrake_backbutton_defect.setVisibility(View.GONE);
                trailerbrake_report_done_with_inspect.setVisibility(View.GONE);
                trailerbrake_report_done_without_inspect.setVisibility(View.GONE);

                trailerbrake_describe_defect_text_view.setVisibility(View.GONE);
                trailerbrakedescribedefectfill.setVisibility(View.GONE);
                trailerbrake_describe_tempfix_text_view.setVisibility(View.GONE);
                trailerbraketempfixfill.setVisibility(View.GONE);


            }
        });

        trailerbrake_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();


                if ( trailerbrakebackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("trailerbrake_button_defect");
                    trailerbrake_icon_image.setVisibility(View.GONE);
                    trailerbrake_inspect_button_defect.setVisibility(View.GONE);
                    trailerbrake_inspect_button_tick_defect.setVisibility(View.GONE);
                    trailerbrake_backbutton_defect.setVisibility(View.VISIBLE);
                    trailerbrake_report_done_with_inspect.setVisibility(View.VISIBLE);
                    trailerbrake_describe_defect_text_view.setText("Describe Defect");
                    trailerbrake_describe_defect_text_view.setVisibility(View.VISIBLE);
                    trailerbrakedescribedefectfill.setVisibility(View.VISIBLE);
                    trailerbrake_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    trailerbraketempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("trailerbrake_button_defect");
                    trailerbrake_icon_image.setVisibility(View.GONE);

                    trailerbrake_inspect_button_defect.setVisibility(View.GONE);
                    trailerbrake_inspect_button_tick_defect.setVisibility(View.GONE);
                    trailerbrake_backbutton_defect.setVisibility(View.VISIBLE);
                    trailerbrake_report_done_with_inspect.setVisibility(View.VISIBLE);
                    trailerbrake_describe_defect_text_view.setText("Describe Defect");
                    trailerbrake_describe_defect_text_view.setVisibility(View.VISIBLE);
                    trailerbrakedescribedefectfill.setVisibility(View.VISIBLE);
                    trailerbrake_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    trailerbraketempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        trailerbrake_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                trailerbrake_icon_image.setVisibility(View.GONE);

                trailerbrake_inspect_button_defect.setVisibility(View.GONE);
                trailerbrake_inspect_button_tick_defect.setVisibility(View.GONE);
                trailerbrake_backbutton_defect.setVisibility(View.VISIBLE);
                trailerbrake_report_done_without_inspect.setVisibility(View.VISIBLE);
                trailerbrake_describe_defect_text_view.setText("Trailer Brake has :");
                trailerbrake_describe_defect_text_view.setVisibility(View.VISIBLE);
                trailerbrakedescribedefectfill.setText("No Defects");
                trailerbrakedescribedefectfill.setVisibility(View.VISIBLE);
                trailerbrake_describe_tempfix_text_view.setVisibility(View.GONE);
                trailerbraketempfixfill.setVisibility(View.GONE);
                trailerbraketempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------     Windows and Mirrors       ------------------------------------------------



        windowsandmirrors_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                windowsandmirrors_icon_image.setVisibility(View.VISIBLE);


                windowsandmirrors_inspect_button_defect.setVisibility(View.VISIBLE);
                windowsandmirrors_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                windowsandmirrors_backbutton_defect.setVisibility(View.GONE);
                windowsandmirrors_report_done_with_inspect.setVisibility(View.GONE);
                windowsandmirrors_report_done_without_inspect.setVisibility(View.GONE);

                windows_and_mirrors_describe_defect_text_view.setVisibility(View.GONE);
                winmirdescribedefectfill.setVisibility(View.GONE);
                windows_and_mirrors_describe_tempfix_text_view.setVisibility(View.GONE);
                winmirtempfixfill.setVisibility(View.GONE);


            }
        });

        windowsandmirrors_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();


                if ( windowsandmirrorsbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("windowsandmirrors_inspect_button_defect");
                    windowsandmirrors_icon_image.setVisibility(View.GONE);
                    windowsandmirrors_inspect_button_defect.setVisibility(View.GONE);
                    windowsandmirrors_inspect_button_tick_defect.setVisibility(View.GONE);
                    windowsandmirrors_backbutton_defect.setVisibility(View.VISIBLE);
                    windowsandmirrors_report_done_with_inspect.setVisibility(View.VISIBLE);
                    windows_and_mirrors_describe_defect_text_view.setText("Describe Defect");
                    windows_and_mirrors_describe_defect_text_view.setVisibility(View.VISIBLE);
                    winmirdescribedefectfill.setVisibility(View.VISIBLE);
                    windows_and_mirrors_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    winmirtempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("windowsandmirrors_inspect_button_defect");
                    windowsandmirrors_icon_image.setVisibility(View.GONE);

                    windowsandmirrors_inspect_button_defect.setVisibility(View.GONE);
                    windowsandmirrors_inspect_button_tick_defect.setVisibility(View.GONE);
                    windowsandmirrors_backbutton_defect.setVisibility(View.VISIBLE);
                    windowsandmirrors_report_done_with_inspect.setVisibility(View.VISIBLE);
                    windows_and_mirrors_describe_defect_text_view.setText("Describe Defect");
                    windows_and_mirrors_describe_defect_text_view.setVisibility(View.VISIBLE);
                    winmirdescribedefectfill.setVisibility(View.VISIBLE);
                    windows_and_mirrors_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    winmirtempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        windowsandmirrors_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                windowsandmirrors_icon_image.setVisibility(View.GONE);

                windowsandmirrors_inspect_button_defect.setVisibility(View.GONE);
                windowsandmirrors_inspect_button_tick_defect.setVisibility(View.GONE);
                windowsandmirrors_backbutton_defect.setVisibility(View.VISIBLE);
                windowsandmirrors_report_done_without_inspect.setVisibility(View.VISIBLE);
                windows_and_mirrors_describe_defect_text_view.setText("Windows and Mirrors has :");
                windows_and_mirrors_describe_defect_text_view.setVisibility(View.VISIBLE);
                winmirdescribedefectfill.setText("No Defects");
                winmirdescribedefectfill.setVisibility(View.VISIBLE);
                windows_and_mirrors_describe_tempfix_text_view.setVisibility(View.GONE);
                winmirtempfixfill.setVisibility(View.GONE);
                winmirtempfixfill.setText("None Required");

            }
        });


        //------------------------------------------------------------------------//------------------------------------------------------------------------       Seat Belt     ------------------------------------------------



        seatbelt_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                seatbelt_icon_image.setVisibility(View.VISIBLE);

                seatbelt_inspect_button_defect.setVisibility(View.VISIBLE);
                seatbelt_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                seatbelt_backbutton_defect.setVisibility(View.GONE);
                seatbelt_report_done_with_inspect.setVisibility(View.GONE);
                seatbelt_report_done_without_inspect.setVisibility(View.GONE);

                seatbelt_describe_defect_text_view.setVisibility(View.GONE);
                seatbeltdescribedefectfill.setVisibility(View.GONE);
                seatbelt_describe_tempfix_text_view.setVisibility(View.GONE);
                seatbelttempfixfill.setVisibility(View.GONE);


            }
        });

        seatbelt_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();

                if ( seatbeltbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("seatbelt_inspect_button_defect");
                    seatbelt_icon_image.setVisibility(View.GONE);
                    seatbelt_inspect_button_defect.setVisibility(View.GONE);
                    seatbelt_inspect_button_tick_defect.setVisibility(View.GONE);
                    seatbelt_backbutton_defect.setVisibility(View.VISIBLE);
                    seatbelt_report_done_with_inspect.setVisibility(View.VISIBLE);
                    seatbelt_describe_defect_text_view.setText("Describe Defect");
                    seatbelt_describe_defect_text_view.setVisibility(View.VISIBLE);
                    seatbeltdescribedefectfill.setVisibility(View.VISIBLE);
                    seatbelt_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    seatbelttempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("seatbelt_inspect_button_defect");
                    seatbelt_icon_image.setVisibility(View.GONE);

                    seatbelt_inspect_button_defect.setVisibility(View.GONE);
                    seatbelt_inspect_button_tick_defect.setVisibility(View.GONE);
                    seatbelt_backbutton_defect.setVisibility(View.VISIBLE);
                    seatbelt_report_done_with_inspect.setVisibility(View.VISIBLE);
                    seatbelt_describe_defect_text_view.setText("Describe Defect");
                    seatbelt_describe_defect_text_view.setVisibility(View.VISIBLE);
                    seatbeltdescribedefectfill.setVisibility(View.VISIBLE);
                    seatbelt_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    seatbelttempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        seatbelt_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                seatbelt_icon_image.setVisibility(View.GONE);

                seatbelt_inspect_button_defect.setVisibility(View.GONE);
                seatbelt_inspect_button_tick_defect.setVisibility(View.GONE);
                seatbelt_backbutton_defect.setVisibility(View.VISIBLE);
                seatbelt_report_done_without_inspect.setVisibility(View.VISIBLE);
                seatbelt_describe_defect_text_view.setText("Belt,Seat and Controls has :");
                seatbelt_describe_defect_text_view.setVisibility(View.VISIBLE);
                seatbeltdescribedefectfill.setText("No Defects");
                seatbeltdescribedefectfill.setVisibility(View.VISIBLE);
                seatbelt_describe_tempfix_text_view.setVisibility(View.GONE);
                seatbelttempfixfill.setVisibility(View.GONE);
                seatbelttempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------ Washer and Wiper ------------------------------------------------



        washerandwiper_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                washerandwiper_icon_image.setVisibility(View.VISIBLE);


                washerandwiper_inspect_button_defect.setVisibility(View.VISIBLE);
                washerandwiper_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                washerandwiper_backbutton_defect.setVisibility(View.GONE);
                washerandwiper_report_done_with_inspect.setVisibility(View.GONE);
                washerandwiper_report_done_without_inspect.setVisibility(View.GONE);

                washerandwiper_describe_defect_text_view.setVisibility(View.GONE);
                washerandwiperdescribedefectfill.setVisibility(View.GONE);
                washerandwiper_describe_tempfix_text_view.setVisibility(View.GONE);
                washerandwipertempfixfill.setVisibility(View.GONE);


            }
        });

        washerandwiper_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();


                if ( washerandwiperbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("washerandwiper_inspect_button_defect");
                    washerandwiper_icon_image.setVisibility(View.GONE);
                    washerandwiper_inspect_button_defect.setVisibility(View.GONE);
                    washerandwiper_inspect_button_tick_defect.setVisibility(View.GONE);
                    washerandwiper_backbutton_defect.setVisibility(View.VISIBLE);
                    washerandwiper_report_done_with_inspect.setVisibility(View.VISIBLE);
                    washerandwiper_describe_defect_text_view.setText("Describe Defect");
                    washerandwiper_describe_defect_text_view.setVisibility(View.VISIBLE);
                    washerandwiperdescribedefectfill.setVisibility(View.VISIBLE);
                    washerandwiper_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    washerandwipertempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("washerandwiper_inspect_button_defect");
                    washerandwiper_icon_image.setVisibility(View.GONE);

                    washerandwiper_inspect_button_defect.setVisibility(View.GONE);
                    washerandwiper_inspect_button_tick_defect.setVisibility(View.GONE);
                    washerandwiper_backbutton_defect.setVisibility(View.VISIBLE);
                    washerandwiper_report_done_with_inspect.setVisibility(View.VISIBLE);
                    washerandwiper_describe_defect_text_view.setText("Describe Defect");
                    washerandwiper_describe_defect_text_view.setVisibility(View.VISIBLE);
                    washerandwiperdescribedefectfill.setVisibility(View.VISIBLE);
                    washerandwiper_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    washerandwipertempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        washerandwiper_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                washerandwiper_icon_image.setVisibility(View.GONE);

                washerandwiper_inspect_button_defect.setVisibility(View.GONE);
                washerandwiper_inspect_button_tick_defect.setVisibility(View.GONE);
                washerandwiper_backbutton_defect.setVisibility(View.VISIBLE);
                washerandwiper_report_done_without_inspect.setVisibility(View.VISIBLE);
                washerandwiper_describe_defect_text_view.setText("Washers and Wipers has :");
                washerandwiper_describe_defect_text_view.setVisibility(View.VISIBLE);
                washerandwiperdescribedefectfill.setText("No Defects");
                washerandwiperdescribedefectfill.setVisibility(View.VISIBLE);
                washerandwiper_describe_tempfix_text_view.setVisibility(View.GONE);
                washerandwipertempfixfill.setVisibility(View.GONE);
                washerandwipertempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------ Horn  ------------------------------------------------



        horn_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                horn_icon_image.setVisibility(View.VISIBLE);


                horn_inspect_button_defect.setVisibility(View.VISIBLE);
                horn_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                horn_backbutton_defect.setVisibility(View.GONE);
                horn_report_done_with_inspect.setVisibility(View.GONE);
                horn_report_done_without_inspect.setVisibility(View.GONE);

                horn_describe_defect_text_view.setVisibility(View.GONE);
                horndescribedefectfill.setVisibility(View.GONE);
                horn_describe_tempfix_text_view.setVisibility(View.GONE);
                horntempfixfill.setVisibility(View.GONE);


            }
        });

        horn_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();

                if ( hornbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("horn_inspect_button_defect");
                    horn_icon_image.setVisibility(View.GONE);
                    horn_inspect_button_defect.setVisibility(View.GONE);
                    horn_inspect_button_tick_defect.setVisibility(View.GONE);
                    horn_backbutton_defect.setVisibility(View.VISIBLE);
                    horn_report_done_with_inspect.setVisibility(View.VISIBLE);
                    horn_describe_defect_text_view.setText("Describe Defect");
                    horn_describe_defect_text_view.setVisibility(View.VISIBLE);
                    horndescribedefectfill.setVisibility(View.VISIBLE);
                    horn_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    horntempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("horn_inspect_button_defect");
                    horn_icon_image.setVisibility(View.GONE);

                    horn_inspect_button_defect.setVisibility(View.GONE);
                    horn_inspect_button_tick_defect.setVisibility(View.GONE);
                    horn_backbutton_defect.setVisibility(View.VISIBLE);
                    horn_report_done_with_inspect.setVisibility(View.VISIBLE);
                    horn_describe_defect_text_view.setText("Describe Defect");
                    horn_describe_defect_text_view.setVisibility(View.VISIBLE);
                    horndescribedefectfill.setVisibility(View.VISIBLE);
                    horn_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    horntempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        horn_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                horn_icon_image.setVisibility(View.GONE);

                horn_inspect_button_defect.setVisibility(View.GONE);
                horn_inspect_button_tick_defect.setVisibility(View.GONE);
                horn_backbutton_defect.setVisibility(View.VISIBLE);
                horn_report_done_without_inspect.setVisibility(View.VISIBLE);
                horn_describe_defect_text_view.setText("Horn has :");
                horn_describe_defect_text_view.setVisibility(View.VISIBLE);
                horndescribedefectfill.setText("No Defects");
                horndescribedefectfill.setVisibility(View.VISIBLE);
                horn_describe_tempfix_text_view.setVisibility(View.GONE);
                horntempfixfill.setVisibility(View.GONE);
                horntempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------      Break warning light      ------------------------------------------------



        breakwarninglight_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                breakwarninglight_icon_image.setVisibility(View.VISIBLE);


                breakwarninglight_inspect_button_defect.setVisibility(View.VISIBLE);
                breakwarninglight_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                breakwarninglight_backbutton_defect.setVisibility(View.GONE);
                breakwarninglight_report_done_with_inspect.setVisibility(View.GONE);
                breakwarninglight_report_done_without_inspect.setVisibility(View.GONE);

                breakwarninglight_describe_defect_text_view.setVisibility(View.GONE);
                breakwarninglightdescribedefectfill.setVisibility(View.GONE);
                breakwarninglight_describe_tempfix_text_view.setVisibility(View.GONE);
                breakwarninglighttempfixfill.setVisibility(View.GONE);


            }
        });

        breakwarninglight_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();

                if ( hornbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("breakwarninglight_inspect_button_defect");
                    breakwarninglight_icon_image.setVisibility(View.GONE);
                    breakwarninglight_inspect_button_defect.setVisibility(View.GONE);
                    breakwarninglight_inspect_button_tick_defect.setVisibility(View.GONE);
                    breakwarninglight_backbutton_defect.setVisibility(View.VISIBLE);
                    breakwarninglight_report_done_with_inspect.setVisibility(View.VISIBLE);
                    breakwarninglight_describe_defect_text_view.setText("Describe Defect");
                    breakwarninglight_describe_defect_text_view.setVisibility(View.VISIBLE);
                    breakwarninglightdescribedefectfill.setVisibility(View.VISIBLE);
                    breakwarninglight_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    breakwarninglighttempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("breakwarninglight_inspect_button_defect");
                    breakwarninglight_icon_image.setVisibility(View.GONE);

                    breakwarninglight_inspect_button_defect.setVisibility(View.GONE);
                    breakwarninglight_inspect_button_tick_defect.setVisibility(View.GONE);
                    breakwarninglight_backbutton_defect.setVisibility(View.VISIBLE);
                    breakwarninglight_report_done_with_inspect.setVisibility(View.VISIBLE);
                    breakwarninglight_describe_defect_text_view.setText("Describe Defect");
                    breakwarninglight_describe_defect_text_view.setVisibility(View.VISIBLE);
                    breakwarninglightdescribedefectfill.setVisibility(View.VISIBLE);
                    breakwarninglight_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    breakwarninglighttempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        breakwarninglight_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                breakwarninglight_icon_image.setVisibility(View.GONE);

                breakwarninglight_inspect_button_defect.setVisibility(View.GONE);
                breakwarninglight_inspect_button_tick_defect.setVisibility(View.GONE);
                breakwarninglight_backbutton_defect.setVisibility(View.VISIBLE);
                breakwarninglight_report_done_without_inspect.setVisibility(View.VISIBLE);
                breakwarninglight_describe_defect_text_view.setText("Brake and Warning has :");
                breakwarninglight_describe_defect_text_view.setVisibility(View.VISIBLE);
                breakwarninglightdescribedefectfill.setText("No Defects");
                breakwarninglightdescribedefectfill.setVisibility(View.VISIBLE);
                breakwarninglight_describe_tempfix_text_view.setVisibility(View.GONE);
                breakwarninglighttempfixfill.setVisibility(View.GONE);
                breakwarninglighttempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------ Gauge ------------------------------------------------



        gauge_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                gauge_icon_image.setVisibility(View.VISIBLE);


                gauge_inspect_button_defect.setVisibility(View.VISIBLE);
                gauge_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                gauge_backbutton_defect.setVisibility(View.GONE);
                gauge_report_done_with_inspect.setVisibility(View.GONE);
                gauge_report_done_without_inspect.setVisibility(View.GONE);

                gauge_describe_defect_text_view.setVisibility(View.GONE);
                gaugedescribedefectfill.setVisibility(View.GONE);
                gauge_describe_tempfix_text_view.setVisibility(View.GONE);
                gaugetempfixfill.setVisibility(View.GONE);


            }
        });

        gauge_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();

                if ( hornbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("gauge_inspect_button_defect");
                    gauge_icon_image.setVisibility(View.GONE);
                    gauge_inspect_button_defect.setVisibility(View.GONE);
                    gauge_inspect_button_tick_defect.setVisibility(View.GONE);
                    gauge_backbutton_defect.setVisibility(View.VISIBLE);
                    gauge_report_done_with_inspect.setVisibility(View.VISIBLE);
                    gauge_describe_defect_text_view.setText("Describe Defect");
                    gauge_describe_defect_text_view.setVisibility(View.VISIBLE);
                    gaugedescribedefectfill.setVisibility(View.VISIBLE);
                    gauge_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    gaugetempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("gauge_inspect_button_defect");
                    gauge_icon_image.setVisibility(View.GONE);

                    gauge_inspect_button_defect.setVisibility(View.GONE);
                    gauge_inspect_button_tick_defect.setVisibility(View.GONE);
                    gauge_backbutton_defect.setVisibility(View.VISIBLE);
                    gauge_report_done_with_inspect.setVisibility(View.VISIBLE);
                    gauge_describe_defect_text_view.setText("Describe Defect");
                    gauge_describe_defect_text_view.setVisibility(View.VISIBLE);
                    gaugedescribedefectfill.setVisibility(View.VISIBLE);
                    gauge_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    gaugetempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        gauge_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                gauge_icon_image.setVisibility(View.GONE);

                gauge_inspect_button_defect.setVisibility(View.GONE);
                gauge_inspect_button_tick_defect.setVisibility(View.GONE);
                gauge_backbutton_defect.setVisibility(View.VISIBLE);
                gauge_report_done_without_inspect.setVisibility(View.VISIBLE);
                gauge_describe_defect_text_view.setText("Gauge and Warnings has :");
                gauge_describe_defect_text_view.setVisibility(View.VISIBLE);
                gaugedescribedefectfill.setText("No Defects");
                gaugedescribedefectfill.setVisibility(View.VISIBLE);
                gauge_describe_tempfix_text_view.setVisibility(View.GONE);
                gaugetempfixfill.setVisibility(View.GONE);
                gaugetempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------ Tacho  ------------------------------------------------



        tacho_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                tacho_icon_image.setVisibility(View.VISIBLE);

                tacho_inspect_button_defect.setVisibility(View.VISIBLE);
                tacho_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                tacho_backbutton_defect.setVisibility(View.GONE);
                tacho_report_done_with_inspect.setVisibility(View.GONE);
                tacho_report_done_without_inspect.setVisibility(View.GONE);

                tacho_describe_defect_text_view.setVisibility(View.GONE);
                tachodescribedefectfill.setVisibility(View.GONE);
                tacho_describe_tempfix_text_view.setVisibility(View.GONE);
                tachotempfixfill.setVisibility(View.GONE);


            }
        });

        tacho_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();

                if ( hornbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("tacho_button_defect");
                    tacho_icon_image.setVisibility(View.GONE);
                    tacho_inspect_button_defect.setVisibility(View.GONE);
                    tacho_inspect_button_tick_defect.setVisibility(View.GONE);
                    tacho_backbutton_defect.setVisibility(View.VISIBLE);
                    tacho_report_done_with_inspect.setVisibility(View.VISIBLE);
                    tacho_describe_defect_text_view.setText("Describe Defect");
                    tacho_describe_defect_text_view.setVisibility(View.VISIBLE);
                    tachodescribedefectfill.setVisibility(View.VISIBLE);
                    tacho_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    tachotempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("tacho_button_defect");
                    tacho_icon_image.setVisibility(View.GONE);

                    tacho_inspect_button_defect.setVisibility(View.GONE);
                    tacho_inspect_button_tick_defect.setVisibility(View.GONE);
                    tacho_backbutton_defect.setVisibility(View.VISIBLE);
                    tacho_report_done_with_inspect.setVisibility(View.VISIBLE);
                    tacho_describe_defect_text_view.setText("Describe Defect");
                    tacho_describe_defect_text_view.setVisibility(View.VISIBLE);
                    tachodescribedefectfill.setVisibility(View.VISIBLE);
                    tacho_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    tachotempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        tacho_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                tacho_icon_image.setVisibility(View.GONE);

                tacho_inspect_button_defect.setVisibility(View.GONE);
                tacho_inspect_button_tick_defect.setVisibility(View.GONE);
                tacho_backbutton_defect.setVisibility(View.VISIBLE);
                tacho_report_done_without_inspect.setVisibility(View.VISIBLE);
                tacho_describe_defect_text_view.setText("Tacho has :");
                tacho_describe_defect_text_view.setVisibility(View.VISIBLE);
                tachodescribedefectfill.setText("No Defects");
                tachodescribedefectfill.setVisibility(View.VISIBLE);
                tacho_describe_tempfix_text_view.setVisibility(View.GONE);
                tachotempfixfill.setVisibility(View.GONE);
                tachotempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------ Airleaks ------------------------------------------------



        airleaks_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-4);
                airleaks_icon_image.setVisibility(View.VISIBLE);


                airleaks_inspect_button_defect.setVisibility(View.VISIBLE);
                airleaks_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                airleaks_backbutton_defect.setVisibility(View.GONE);
                airleaks_report_done_with_inspect.setVisibility(View.GONE);
                airleaks_report_done_without_inspect.setVisibility(View.GONE);

                airleaks_describe_defect_text_view.setVisibility(View.GONE);
                airleaksdescribedefectfill.setVisibility(View.GONE);
                airleaks_describe_tempfix_text_view.setVisibility(View.GONE);
                airleakstempfixfill.setVisibility(View.GONE);


            }
        });

        airleaks_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);
                FragmentManager fm = getFragmentManager();


                if ( hornbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("airleaks_button_defect");
                    airleaks_icon_image.setVisibility(View.GONE);
                    airleaks_inspect_button_defect.setVisibility(View.GONE);
                    airleaks_inspect_button_tick_defect.setVisibility(View.GONE);
                    airleaks_backbutton_defect.setVisibility(View.VISIBLE);
                    airleaks_report_done_with_inspect.setVisibility(View.VISIBLE);
                    airleaks_describe_defect_text_view.setText("Describe Defect");
                    airleaks_describe_defect_text_view.setVisibility(View.VISIBLE);
                    airleaksdescribedefectfill.setVisibility(View.VISIBLE);
                    airleaks_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    airleakstempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("airleaks_button_defect");
                    airleaks_icon_image.setVisibility(View.GONE);

                    airleaks_inspect_button_defect.setVisibility(View.GONE);
                    airleaks_inspect_button_tick_defect.setVisibility(View.GONE);
                    airleaks_backbutton_defect.setVisibility(View.VISIBLE);
                    airleaks_report_done_with_inspect.setVisibility(View.VISIBLE);
                    airleaks_describe_defect_text_view.setText("Describe Defect");
                    airleaks_describe_defect_text_view.setVisibility(View.VISIBLE);
                    airleaksdescribedefectfill.setVisibility(View.VISIBLE);
                    airleaks_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    airleakstempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        airleaks_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(4);

                airleaks_icon_image.setVisibility(View.GONE);

                airleaks_inspect_button_defect.setVisibility(View.GONE);
                airleaks_inspect_button_tick_defect.setVisibility(View.GONE);
                airleaks_backbutton_defect.setVisibility(View.VISIBLE);
                airleaks_report_done_without_inspect.setVisibility(View.VISIBLE);
                airleaks_describe_defect_text_view.setText("Airleaks has :");
                airleaks_describe_defect_text_view.setVisibility(View.VISIBLE);
                airleaksdescribedefectfill.setText("No Defects");
                airleaksdescribedefectfill.setVisibility(View.VISIBLE);
                airleaks_describe_tempfix_text_view.setVisibility(View.GONE);
                airleakstempfixfill.setVisibility(View.GONE);
                airleakstempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------Steering breaking------------------------------------------------



        steeringbreaking_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-5);
                steeringbreaking_icon_image.setVisibility(View.VISIBLE);


                steeringbreaking_inspect_button_defect.setVisibility(View.VISIBLE);
                steeringbreaking_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                steeringbreaking_backbutton_defect.setVisibility(View.GONE);
                steeringbreaking_report_done_with_inspect.setVisibility(View.GONE);
                steeringbreaking_report_done_without_inspect.setVisibility(View.GONE);

                steeringbreaking_describe_defect_text_view.setVisibility(View.GONE);
                steeringbreakingdescribedefectfill.setVisibility(View.GONE);
                steeringbreaking_describe_tempfix_text_view.setVisibility(View.GONE);
                steeringbreakingtempfixfill.setVisibility(View.GONE);


            }
        });

        steeringbreaking_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(5);
                FragmentManager fm = getFragmentManager();


                if ( hornbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("steeringbreaking_button_defect");
                    steeringbreaking_icon_image.setVisibility(View.GONE);
                    steeringbreaking_inspect_button_defect.setVisibility(View.GONE);
                    steeringbreaking_inspect_button_tick_defect.setVisibility(View.GONE);
                    steeringbreaking_backbutton_defect.setVisibility(View.VISIBLE);
                    steeringbreaking_report_done_with_inspect.setVisibility(View.VISIBLE);
                    steeringbreaking_describe_defect_text_view.setText("Describe Defect");
                    steeringbreaking_describe_defect_text_view.setVisibility(View.VISIBLE);
                    steeringbreakingdescribedefectfill.setVisibility(View.VISIBLE);
                    steeringbreaking_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    steeringbreakingtempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("steeringbreaking_button_defect");
                    steeringbreaking_icon_image.setVisibility(View.GONE);

                    steeringbreaking_inspect_button_defect.setVisibility(View.GONE);
                    steeringbreaking_inspect_button_tick_defect.setVisibility(View.GONE);
                    steeringbreaking_backbutton_defect.setVisibility(View.VISIBLE);
                    steeringbreaking_report_done_with_inspect.setVisibility(View.VISIBLE);
                    steeringbreaking_describe_defect_text_view.setText("Describe Defect");
                    steeringbreaking_describe_defect_text_view.setVisibility(View.VISIBLE);
                    steeringbreakingdescribedefectfill.setVisibility(View.VISIBLE);
                    steeringbreaking_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    steeringbreakingtempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        steeringbreaking_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(5);

                steeringbreaking_icon_image.setVisibility(View.GONE);

                steeringbreaking_inspect_button_defect.setVisibility(View.GONE);
                steeringbreaking_inspect_button_tick_defect.setVisibility(View.GONE);
                steeringbreaking_backbutton_defect.setVisibility(View.VISIBLE);
                steeringbreaking_report_done_without_inspect.setVisibility(View.VISIBLE);
                steeringbreaking_describe_defect_text_view.setText("Steering and Brakes has :");
                steeringbreaking_describe_defect_text_view.setVisibility(View.VISIBLE);
                steeringbreakingdescribedefectfill.setText("No Defects");
                steeringbreakingdescribedefectfill.setVisibility(View.VISIBLE);
                steeringbreaking_describe_tempfix_text_view.setVisibility(View.GONE);
                steeringbreakingtempfixfill.setVisibility(View.GONE);
                steeringbreakingtempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------Load Secure------------------------------------------------


        loadsecure_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-5);
                loadsecure_icon_image.setVisibility(View.VISIBLE);


                loadsecure_inspect_button_defect.setVisibility(View.VISIBLE);
                loadsecure_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                loadsecure_backbutton_defect.setVisibility(View.GONE);
                loadsecure_report_done_with_inspect.setVisibility(View.GONE);
                loadsecure_report_done_without_inspect.setVisibility(View.GONE);

                loadsecure_describe_defect_text_view.setVisibility(View.GONE);
                loadsecuredescribedefectfill.setVisibility(View.GONE);
                loadsecure_describe_tempfix_text_view.setVisibility(View.GONE);
                loadsecuretempfixfill.setVisibility(View.GONE);


            }
        });

        loadsecure_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(5);
                FragmentManager fm = getFragmentManager();


                if ( hornbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("loadsecure_button_defect");
                    loadsecure_icon_image.setVisibility(View.GONE);
                    loadsecure_inspect_button_defect.setVisibility(View.GONE);
                    loadsecure_inspect_button_tick_defect.setVisibility(View.GONE);
                    loadsecure_backbutton_defect.setVisibility(View.VISIBLE);
                    loadsecure_report_done_with_inspect.setVisibility(View.VISIBLE);
                    loadsecure_describe_defect_text_view.setText("Describe Defect");
                    loadsecure_describe_defect_text_view.setVisibility(View.VISIBLE);
                    loadsecuredescribedefectfill.setVisibility(View.VISIBLE);
                    loadsecure_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    loadsecuretempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("loadsecure_button_defect");
                    loadsecure_icon_image.setVisibility(View.GONE);

                    loadsecure_inspect_button_defect.setVisibility(View.GONE);
                    loadsecure_inspect_button_tick_defect.setVisibility(View.GONE);
                    loadsecure_backbutton_defect.setVisibility(View.VISIBLE);
                    loadsecure_report_done_with_inspect.setVisibility(View.VISIBLE);
                    loadsecure_describe_defect_text_view.setText("Describe Defect");
                    loadsecure_describe_defect_text_view.setVisibility(View.VISIBLE);
                    loadsecuredescribedefectfill.setVisibility(View.VISIBLE);
                    loadsecure_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    loadsecuretempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        loadsecure_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(5);

                loadsecure_icon_image.setVisibility(View.GONE);

                loadsecure_inspect_button_defect.setVisibility(View.GONE);
                loadsecure_inspect_button_tick_defect.setVisibility(View.GONE);
                loadsecure_backbutton_defect.setVisibility(View.VISIBLE);
                loadsecure_report_done_without_inspect.setVisibility(View.VISIBLE);
                loadsecure_describe_defect_text_view.setText("Load Secure has :");
                loadsecure_describe_defect_text_view.setVisibility(View.VISIBLE);
                loadsecuredescribedefectfill.setText("No Defects");
                loadsecuredescribedefectfill.setVisibility(View.VISIBLE);
                loadsecure_describe_tempfix_text_view.setVisibility(View.GONE);
                loadsecuretempfixfill.setVisibility(View.GONE);
                loadsecuretempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------Tacho Speedo ------------------------------------------------



        tachospeedo_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-5);
                tachospeedo_icon_image.setVisibility(View.VISIBLE);


                tachospeedo_inspect_button_defect.setVisibility(View.VISIBLE);
                tachospeedo_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                tachospeedo_backbutton_defect.setVisibility(View.GONE);
                tachospeedo_report_done_with_inspect.setVisibility(View.GONE);
                tachospeedo_report_done_without_inspect.setVisibility(View.GONE);

                tachospeedo_describe_defect_text_view.setVisibility(View.GONE);
                tachospeedodescribedefectfill.setVisibility(View.GONE);
                tachospeedo_describe_tempfix_text_view.setVisibility(View.GONE);
                tachospeedotempfixfill.setVisibility(View.GONE);


            }
        });

        tachospeedo_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(5);
                FragmentManager fm = getFragmentManager();


                if ( hornbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("tachospeedo_button_defect");
                    tachospeedo_icon_image.setVisibility(View.GONE);
                    tachospeedo_inspect_button_defect.setVisibility(View.GONE);
                    tachospeedo_inspect_button_tick_defect.setVisibility(View.GONE);
                    tachospeedo_backbutton_defect.setVisibility(View.VISIBLE);
                    tachospeedo_report_done_with_inspect.setVisibility(View.VISIBLE);
                    tachospeedo_describe_defect_text_view.setText("Describe Defect");
                    tachospeedo_describe_defect_text_view.setVisibility(View.VISIBLE);
                    tachospeedodescribedefectfill.setVisibility(View.VISIBLE);
                    tachospeedo_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    tachospeedotempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("tachospeedo_button_defect");
                    tachospeedo_icon_image.setVisibility(View.GONE);

                    tachospeedo_inspect_button_defect.setVisibility(View.GONE);
                    tachospeedo_inspect_button_tick_defect.setVisibility(View.GONE);
                    tachospeedo_backbutton_defect.setVisibility(View.VISIBLE);
                    tachospeedo_report_done_with_inspect.setVisibility(View.VISIBLE);
                    tachospeedo_describe_defect_text_view.setText("Describe Defect");
                    tachospeedo_describe_defect_text_view.setVisibility(View.VISIBLE);
                    tachospeedodescribedefectfill.setVisibility(View.VISIBLE);
                    tachospeedo_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    tachospeedotempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        tachospeedo_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(5);

                tachospeedo_icon_image.setVisibility(View.GONE);

                tachospeedo_inspect_button_defect.setVisibility(View.GONE);
                tachospeedo_inspect_button_tick_defect.setVisibility(View.GONE);
                tachospeedo_backbutton_defect.setVisibility(View.VISIBLE);
                tachospeedo_report_done_without_inspect.setVisibility(View.VISIBLE);
                tachospeedo_describe_defect_text_view.setText("Tacho Speedo has :");
                tachospeedo_describe_defect_text_view.setVisibility(View.VISIBLE);
                tachospeedodescribedefectfill.setText("No Defects");
                tachospeedodescribedefectfill.setVisibility(View.VISIBLE);
                tachospeedo_describe_tempfix_text_view.setVisibility(View.GONE);
                tachospeedotempfixfill.setVisibility(View.GONE);
                tachospeedotempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------ No Warning Light ------------------------------------------------


        nowarninglights_backbutton_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(-5);
                nowarninglights_icon_image.setVisibility(View.VISIBLE);

                nowarninglights_inspect_button_defect.setVisibility(View.VISIBLE);
                nowarninglights_inspect_button_tick_defect.setVisibility(View.VISIBLE);

                nowarninglights_backbutton_defect.setVisibility(View.GONE);
                nowarninglights_report_done_with_inspect.setVisibility(View.GONE);
                nowarninglights_report_done_without_inspect.setVisibility(View.GONE);

                nowarninglights_describe_defect_text_view.setVisibility(View.GONE);
                nowarninglightsdescribedefectfill.setVisibility(View.GONE);
                nowarninglights_describe_tempfix_text_view.setVisibility(View.GONE);
                nowarninglightstempfixfill.setVisibility(View.GONE);


            }
        });

        nowarninglights_inspect_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(5);
                FragmentManager fm = getFragmentManager();


                if ( hornbackbuttonPressed == false) {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("nowarninglights_button_defect");
                    nowarninglights_icon_image.setVisibility(View.GONE);
                    nowarninglights_inspect_button_defect.setVisibility(View.GONE);
                    nowarninglights_inspect_button_tick_defect.setVisibility(View.GONE);
                    nowarninglights_backbutton_defect.setVisibility(View.VISIBLE);
                    nowarninglights_report_done_with_inspect.setVisibility(View.VISIBLE);
                    nowarninglights_describe_defect_text_view.setText("Describe Defect");
                    nowarninglights_describe_defect_text_view.setVisibility(View.VISIBLE);
                    nowarninglightsdescribedefectfill.setVisibility(View.VISIBLE);
                    nowarninglights_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    nowarninglightstempfixfill.setVisibility(View.VISIBLE);

                    dialogFragment.show(fm, "Sample Fragment");
                } else {

                    Popup_WAM dialogFragment = Popup_WAM.newInstance("nowarninglights_button_defect");
                    nowarninglights_icon_image.setVisibility(View.GONE);

                    nowarninglights_inspect_button_defect.setVisibility(View.GONE);
                    nowarninglights_inspect_button_tick_defect.setVisibility(View.GONE);
                    nowarninglights_backbutton_defect.setVisibility(View.VISIBLE);
                    nowarninglights_report_done_with_inspect.setVisibility(View.VISIBLE);
                    nowarninglights_describe_defect_text_view.setText("Describe Defect");
                    nowarninglights_describe_defect_text_view.setVisibility(View.VISIBLE);
                    nowarninglightsdescribedefectfill.setVisibility(View.VISIBLE);
                    nowarninglights_describe_tempfix_text_view.setVisibility(View.VISIBLE);
                    nowarninglightstempfixfill.setVisibility(View.VISIBLE);


                    dialogFragment.show(fm, "Sample Fragment");
                }
            }
        });

        nowarninglights_inspect_button_tick_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prg.incrementProgressBy(5);

                nowarninglights_icon_image.setVisibility(View.GONE);

                nowarninglights_inspect_button_defect.setVisibility(View.GONE);
                nowarninglights_inspect_button_tick_defect.setVisibility(View.GONE);
                nowarninglights_backbutton_defect.setVisibility(View.VISIBLE);
                nowarninglights_report_done_without_inspect.setVisibility(View.VISIBLE);
                nowarninglights_describe_defect_text_view.setText("No Warning Lights has :");
                nowarninglights_describe_defect_text_view.setVisibility(View.VISIBLE);
                nowarninglightsdescribedefectfill.setText("No Defects");
                nowarninglightsdescribedefectfill.setVisibility(View.VISIBLE);
                nowarninglights_describe_tempfix_text_view.setVisibility(View.GONE);
                nowarninglightstempfixfill.setVisibility(View.GONE);
                nowarninglightstempfixfill.setText("None Required");

            }
        });

        //------------------------------------------------------------------------//------------------------------------------------------------------------            ------------------------------------------------

        //------------------------------------------------------------------------//------------------------------------------------------------------------            ------------------------------------------------






        outsideinspectionhidebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taxandinsurancewholebox.setVisibility(LinearLayout.GONE);
                regplatewholebox.setVisibility(LinearLayout.GONE);
                airandelectrialwholebox.setVisibility(LinearLayout.GONE);
                fluidleakswholebox.setVisibility(LinearLayout.GONE);
                airsuspensionwholebox.setVisibility(LinearLayout.GONE);
                wheelsandtyreswholebox.setVisibility(LinearLayout.GONE);
                lightsreflectorswholebox.setVisibility(LinearLayout.GONE);
                exhaustwholebox.setVisibility(LinearLayout.GONE);
                bodyguardswholebox.setVisibility(LinearLayout.GONE);
                landinglegwholebox.setVisibility(LinearLayout.GONE);
                sparetowwholebox.setVisibility(LinearLayout.GONE);
                trailerbrakewholebox.setVisibility(LinearLayout.GONE);
            }
        });

        outsideinspectionhidebutton.performClick();

        outsideinspectionshowbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taxandinsurancewholebox.setVisibility(LinearLayout.VISIBLE);
                regplatewholebox.setVisibility(LinearLayout.VISIBLE);
                airandelectrialwholebox.setVisibility(LinearLayout.VISIBLE);
                fluidleakswholebox.setVisibility(LinearLayout.VISIBLE);
                airsuspensionwholebox.setVisibility(LinearLayout.VISIBLE);
                wheelsandtyreswholebox.setVisibility(LinearLayout.VISIBLE);
                lightsreflectorswholebox.setVisibility(LinearLayout.VISIBLE);
                exhaustwholebox.setVisibility(LinearLayout.VISIBLE);
                bodyguardswholebox.setVisibility(LinearLayout.VISIBLE);
                landinglegwholebox.setVisibility(LinearLayout.VISIBLE);
                sparetowwholebox.setVisibility(LinearLayout.VISIBLE);
                trailerbrakewholebox.setVisibility(LinearLayout.VISIBLE);
            }
        });

        insideinspectionhidebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                windowsandmirrorswholebox.setVisibility(LinearLayout.GONE);
                seatbeltwholebox.setVisibility(LinearLayout.GONE);
                washerandwiperwholebox.setVisibility(LinearLayout.GONE);
                hornwholebox.setVisibility(LinearLayout.GONE);
                breakwarninglightwholebox.setVisibility(LinearLayout.GONE);
                gaugewholebox.setVisibility(LinearLayout.GONE);
                tachowholebox.setVisibility(LinearLayout.GONE);
                airleakswholebox.setVisibility(LinearLayout.GONE);

            }
        });

        insideinspectionhidebutton.performClick();

        insideinspectionshowbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                windowsandmirrorswholebox.setVisibility(LinearLayout.VISIBLE);
                seatbeltwholebox.setVisibility(LinearLayout.VISIBLE);
                washerandwiperwholebox.setVisibility(LinearLayout.VISIBLE);
                hornwholebox.setVisibility(LinearLayout.VISIBLE);
                breakwarninglightwholebox.setVisibility(LinearLayout.VISIBLE);
                gaugewholebox.setVisibility(LinearLayout.VISIBLE);
                tachowholebox.setVisibility(LinearLayout.VISIBLE);
                airleakswholebox.setVisibility(LinearLayout.VISIBLE);

            }
        });

        drivinginspectionhidebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                steeringbreakingwholebox.setVisibility(LinearLayout.GONE);
                loadsecurewholebox.setVisibility(LinearLayout.GONE);
                tachospeedowholebox.setVisibility(LinearLayout.GONE);
                nowarninglightswholebox.setVisibility(LinearLayout.GONE);

            }
        });

        drivinginspectionhidebutton.performClick();

        drivinginspectionshowbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                FragmentManager fm = getFragmentManager();
                inspection_driving_warning_box dialogFragment2 = inspection_driving_warning_box .newInstance("inspection_driving_warning_box");
                dialogFragment2.show(fm, "Sample Fragment");

                steeringbreakingwholebox.setVisibility(LinearLayout.VISIBLE);
                loadsecurewholebox.setVisibility(LinearLayout.VISIBLE);
                tachospeedowholebox.setVisibility(LinearLayout.VISIBLE);
                nowarninglightswholebox.setVisibility(LinearLayout.VISIBLE);

            }
        });

        locationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userLocation.disconnect();
                userLocation.connect();
//                mp.start();
//                startActivity(new Intent(Add_or_Update_Inspection.this, MyLocationDemoActivity.class));

            }
        });



        // Database

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pReg.getText().toString().trim().equals("") ||
                        user_name.getText().toString().trim().equals("") ||
                        user_email.getText().toString().trim().equals("") ||
                        etreport_email_recipient.getText().toString().trim().equals("") ||
                        user_company.getText().toString().trim().equals("") ||
                        user_contact_number.getText().toString().trim().equals("") ||
                        winmirtempfixfill.getText().toString().trim().equals("") ||
                        winmirdescribedefectfill.getText().toString().trim().equals("") ||
                        seatbelttempfixfill.getText().toString().trim().equals("") ||
                        seatbeltdescribedefectfill.getText().toString().trim().equals("") ||
                        washerandwipertempfixfill.getText().toString().trim().equals("") ||
                        washerandwiperdescribedefectfill.getText().toString().trim().equals("") ||
                        horntempfixfill.getText().toString().trim().equals("") ||
                        horndescribedefectfill.getText().toString().trim().equals("") ||
                        gaugetempfixfill.getText().toString().trim().equals("") ||
                        gaugedescribedefectfill.getText().toString().trim().equals("") ||
                        tachotempfixfill.getText().toString().trim().equals("") ||
                        tachodescribedefectfill.getText().toString().trim().equals("") ||
                        airleakstempfixfill.getText().toString().trim().equals("") ||
                        airleaksdescribedefectfill.getText().toString().trim().equals("") ||
                        breakwarninglighttempfixfill.getText().toString().trim().equals("") ||
                        breakwarninglightdescribedefectfill.getText().toString().trim().equals("") ||
                        //Driving Inspection
                        loadsecuretempfixfill.getText().toString().trim().equals("") ||
                        loadsecuredescribedefectfill.getText().toString().trim().equals("") ||
                        tachospeedotempfixfill.getText().toString().trim().equals("") ||
                        tachospeedodescribedefectfill.getText().toString().trim().equals("") ||
                        nowarninglightstempfixfill.getText().toString().trim().equals("") ||
                        nowarninglightsdescribedefectfill.getText().toString().trim().equals("") ||
                        steeringbreakingtempfixfill.getText().toString().trim().equals("") ||
                        steeringbreakingdescribedefectfill.getText().toString().trim().equals("") ||
                        //Outside Inspection
                        airelectrialdescribedefectfill.getText().toString().trim().equals("") ||
                        airsuspensiondescribedefectfill.getText().toString().trim().equals("") ||
                        regplatedescribedefectfill.getText().toString().trim().equals("") ||
                        fluidleaksdescribedefectfill.getText().toString().trim().equals("") ||
                        exhaustdescribedefectfill.getText().toString().trim().equals("") ||
                        bodyguardsdescribedefectfill.getText().toString().trim().equals("") ||
                        landinglegdescribedefectfill.getText().toString().trim().equals("") ||
                        sparetowdescribedefectfill.getText().toString().trim().equals("") ||
                        trailerbrakedescribedefectfill.getText().toString().trim().equals("") ||
                        lightsreflectorsdescribedefectfill.getText().toString().trim().equals("") ||
                        taxinsurancedescribedefectfill.getText().toString().trim().equals("") ||
                        wheelstyresdescribedefectfill.getText().toString().trim().equals("")) {


                    final Snackbar snackBar = Snackbar.make(cl, "Please enter all the fields.", Snackbar.LENGTH_LONG);
                    snackBar.setAction("CLOSE", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            snackBar.dismiss();
                        }
                    });
                    snackBar.show();
                } else {
                    Person p = new Person();
                    p.setReg(pReg.getText().toString());
                    p.setstartDate(getIntent().getStringExtra("Date"));
                    p.setuser_email(user_email.getText().toString());
                    p.setreport_email_recipient(etreport_email_recipient.getText().toString());
                    p.setuser_name(user_name.getText().toString());
                    p.setuser_company(user_company.getText().toString());
                    p.setuser_contact_number(user_contact_number.getText().toString());
                    p.setwinmirtempfixfill(winmirtempfixfill.getText().toString());
                    p.setwinmirdescribedefectfill(winmirdescribedefectfill.getText().toString());
                    p.setseatbeltstempfixfill(seatbelttempfixfill.getText().toString());
                    p.setseatbeltsdescribedefectfill(seatbeltdescribedefectfill.getText().toString());
                    p.setwasherandwipertempfixfill(washerandwipertempfixfill.getText().toString());
                    p.setwasherandwiperdescribedefectfill(washerandwiperdescribedefectfill.getText().toString());
                    p.sethorntempfixfill(horntempfixfill.getText().toString());
                    p.sethorndescribedefectfill(horndescribedefectfill.getText().toString());
                    p.setbreakwarninglighttempfixfill(breakwarninglighttempfixfill.getText().toString());
                    p.setbreakwarninglightdescribedefectfill(breakwarninglightdescribedefectfill.getText().toString());
                    p.setgaugetempfixfill(gaugetempfixfill.getText().toString());
                    p.setgaugedescribedefectfill(gaugedescribedefectfill.getText().toString());
                    p.settachotempfixfill(tachotempfixfill.getText().toString());
                    p.settachodescribedefectfill(tachodescribedefectfill.getText().toString());
                    p.setairleakstempfixfill(airleakstempfixfill.getText().toString());
                    p.setairleaksdescribedefectfill(airleaksdescribedefectfill.getText().toString());
                    //Driving Inspection
                    p.setsteeringbreakingtempfixfill(steeringbreakingtempfixfill.getText().toString());
                    p.setsteeringbreakingdescribedefectfill(steeringbreakingdescribedefectfill.getText().toString());
                    p.setloadsecuretempfixfill(loadsecuretempfixfill.getText().toString());
                    p.setloadsecuredescribedefectfill(loadsecuredescribedefectfill.getText().toString());
                    p.settachospeedotempfixfill(tachospeedotempfixfill.getText().toString());
                    p.settachospeedodescribedefectfill(tachospeedodescribedefectfill.getText().toString());
                    p.setnowarninglightstempfixfill(nowarninglightstempfixfill.getText().toString());
                    p.setnowarninglightsdescribedefectfill(nowarninglightsdescribedefectfill.getText().toString());
                    //Outside Inspection
                    p.settaxinsurancetempfixfill(taxinsurancetempfixfill.getText().toString());
                    p.settaxinsurancedescribedefectfill(taxinsurancedescribedefectfill.getText().toString());
                    p.setwheelstyrestempfixfill(wheelstyrestempfixfill.getText().toString());
                    p.setwheelstyresdescribedefectfill(wheelstyresdescribedefectfill.getText().toString());
                    p.setlightsreflectorstempfixfill(lightsreflectorstempfixfill.getText().toString());
                    p.setlightsreflectorsdescribedefectfill(lightsreflectorsdescribedefectfill.getText().toString());
                    p.setexhausttempfixfill(exhausttempfixfill.getText().toString());
                    p.setexhaustdescribedefectfill(exhaustdescribedefectfill.getText().toString());
                    p.setsparetowtempfixfill(sparetowtempfixfill.getText().toString());
                    p.setsparetowdescribedefectfill(sparetowdescribedefectfill.getText().toString());
                    p.settrailerbraketempfixfill(trailerbraketempfixfill.getText().toString());
                    p.settrailerbrakedescribedefectfill(trailerbrakedescribedefectfill.getText().toString());
                    p.setbodyguardstempfixfill(bodyguardstempfixfill.getText().toString());
                    p.setbodyguardsdescribedefectfill(bodyguardsdescribedefectfill.getText().toString());
                    p.setlandinglegtempfixfill(landinglegtempfixfill.getText().toString());
                    p.setlandinglegdescribedefectfill(landinglegdescribedefectfill.getText().toString());
                    p.setregplatetempfixfill(regplatetempfixfill.getText().toString());
                    p.setregplatedescribedefectfill(regplatedescribedefectfill.getText().toString());
                    p.setfluidleakstempfixfill(fluidleakstempfixfill.getText().toString());
                    p.setfluidleaksdescribedefectfill(fluidleaksdescribedefectfill.getText().toString());
                    p.setairelectrialtempfixfill(airelectrialtempfixfill.getText().toString());
                    p.setairelectrialdescribedefectfill(airelectrialdescribedefectfill.getText().toString());
                    p.setairsuspensiontempfixfill(airsuspensiontempfixfill.getText().toString());
                    p.setairsuspensiondescribedefectfill(airsuspensiondescribedefectfill.getText().toString());


                    p.setvehiclephotopicturepath(vehiclephotopicturepath);

                    p.setlocationlat(Double.toString(Locationlat));
                    p.setlocationlong(Double.toString(Locationlong));



                    //if (person == null)
                       Vehicle_Reports.getInstance().addPerson(p);

                    new AlertDialog.Builder(Add_or_Update_Inspection.this)
                            .setTitle("Inspection Saved")
                            .setMessage("Would you like to Read/Email this report now?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent nextView2 = new Intent(Add_or_Update_Inspection.this, Person_Details_emailreport.class);
                                    nextView2.putExtra("CalledFromAdd_or_Update_Inspection", true);
                                    startActivity(nextView2);

                                    // continue with delete
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity (new Intent(Add_or_Update_Inspection.this, MainActivity.class));
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }
            }
        });


        Firebase.setAndroidContext(this);
        Firebase mRootRef = new Firebase("https://truckman-1dc51.firebaseio.com/");
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        ///////////////////////////////////////////////////////////////////////////////////

        // User profile getter and setter

        mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                String userName = dataSnapshot.child("User Name").getValue(String.class);
                String userEmail = dataSnapshot.child("User Email").getValue(String.class);
                String Report_email_recipient = dataSnapshot.child("Report Email Recipient").getValue(String.class);
                String userCompany = dataSnapshot.child("User Company").getValue(String.class);
                String userContactNumber = dataSnapshot.child("User Contact Number").getValue(String.class);

                user_name.setText(userName);
                user_email.setText(userEmail);
                etreport_email_recipient.setText(Report_email_recipient);
                user_company.setText(userCompany);
                user_contact_number.setText(userContactNumber);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        internet_connected = Online_check ();

        if (internet_connected == false) {
            Onlinetext.setText("Offline");
            onlineimage.setImageResource(R.drawable.offlineicon);
        }
        else {
            Onlinetext.setText("Online");
            onlineimage.setImageResource(R.drawable.onlineicon);
        }
        ///////////////////////////////////////////////////////////////////////////////////

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
   //////////////////////////////////////////////////////////////////////////////////



    //////////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLARY_INTENT25 || requestCode  == CAMERA_REQUEST_CODE25 && resultCode == RESULT_OK) {
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

            mProgressDialog.setMessage("Uploading...");
            mProgressDialog.show();

            Uri uri = data.getData();
            String startDate = getIntent().getStringExtra("Date");
            StorageReference filepath = mStorage.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Photos").child(startDate).child(uri.getLastPathSegment());

            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Uri downloadUri = taskSnapshot.getDownloadUrl();
                    vehiclephotopictureuri = downloadUri.toString();
                    Picasso.with(Add_or_Update_Inspection.this).load(downloadUri).fit().centerCrop().into(photoplace100x100vehiclephoto);

                    Toast.makeText(Add_or_Update_Inspection.this, "Vehicle Photo Upload Done.", Toast.LENGTH_LONG).show();
                    mProgressDialog.dismiss();
                }
            });
        }
    }

    public void searchPerson(int position) {
        String clickedKey = Vehicle_Reports.getInstance().getKeysArray().get(position);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        Vehicle_Reports.getInstance().getmDatabase().child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Vehicle Inspection Form").child(clickedKey).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value

                        Person person = dataSnapshot.getValue(Person.class);
                        user_name.setText(person.getuser_name());
                        user_email.setText(person.getuser_email());
                        etreport_email_recipient.setText(person.getreport_email_recipient());
                        user_company.setText(person.getuser_company());
                        user_contact_number.setText(person.getuser_contact_number());
                        pReg.setText(person.getReg());
                        winmirtempfixfill.setText(person.getwinmirtempfixfill());
                        winmirdescribedefectfill.setText(person.getwinmirdescribedefectfill());
                        seatbelttempfixfill.setText(person.getseatbeltstempfixfill());
                        seatbeltdescribedefectfill.setText(person.getseatbeltsdescribedefectfill());
                        washerandwipertempfixfill.setText(person.getwasherandwipertempfixfill());
                        washerandwiperdescribedefectfill.setText(person.getwasherandwiperdescribedefectfill());
                        horntempfixfill.setText(person.gethorntempfixfill());
                        horndescribedefectfill.setText(person.gethorndescribedefectfill());
                        breakwarninglighttempfixfill.setText(person.getbreakwarninglighttempfixfill());
                        breakwarninglightdescribedefectfill.setText(person.getbreakwarninglightdescribedefectfill());
                        gaugetempfixfill.setText(person.getgaugetempfixfill());
                        gaugedescribedefectfill.setText(person.getgaugedescribedefectfill());
                        tachotempfixfill.setText(person.gettachotempfixfill());
                        tachodescribedefectfill.setText(person.gettachodescribedefectfill());
                        airleakstempfixfill.setText(person.getairleakstempfixfill());
                        airleaksdescribedefectfill.setText(person.getairleaksdescribedefectfill());
                        //Driving Inspection
                        steeringbreakingtempfixfill.setText(person.getsteeringbreakingtempfixfill());
                        steeringbreakingdescribedefectfill.setText(person.getsteeringbreakingdescribedefectfill());
                        loadsecuretempfixfill.setText(person.getloadsecuretempfixfill());
                        loadsecuredescribedefectfill.setText(person.getloadsecuredescribedefectfill());
                        tachospeedotempfixfill.setText(person.gettachospeedotempfixfill());
                        tachospeedodescribedefectfill.setText(person.gettachospeedodescribedefectfill());
                        nowarninglightstempfixfill.setText(person.getnowarninglightstempfixfill());
                        nowarninglightsdescribedefectfill.setText(person.getnowarninglightsdescribedefectfill());
                        //Outside Inspection
                        taxinsurancetempfixfill.setText(person.gettaxinsurancetempfixfill());
                        taxinsurancedescribedefectfill.setText(person.gettaxinsurancedescribedefectfill());
                        wheelstyrestempfixfill.setText(person.getwheelstyrestempfixfill());
                        wheelstyresdescribedefectfill.setText(person.getwheelstyresdescribedefectfill());
                        lightsreflectorstempfixfill.setText(person.getlightsreflectorstempfixfill());
                        lightsreflectorsdescribedefectfill.setText(person.getlightsreflectorsdescribedefectfill());
                        exhausttempfixfill.setText(person.getexhausttempfixfill());
                        exhaustdescribedefectfill.setText(person.getexhaustdescribedefectfill());
                        sparetowtempfixfill.setText(person.getsparetowtempfixfill());
                        sparetowdescribedefectfill.setText(person.getsparetowdescribedefectfill());
                        trailerbraketempfixfill.setText(person.gettrailerbraketempfixfill());
                        trailerbrakedescribedefectfill.setText(person.gettrailerbrakedescribedefectfill());
                        bodyguardstempfixfill.setText(person.getbodyguardstempfixfill());
                        bodyguardsdescribedefectfill.setText(person.getbodyguardsdescribedefectfill());
                        landinglegtempfixfill.setText(person.getlandinglegtempfixfill());
                        landinglegdescribedefectfill.setText(person.getlandinglegdescribedefectfill());
                        regplatetempfixfill.setText(person.getregplatetempfixfill());
                        regplatedescribedefectfill.setText(person.getregplatedescribedefectfill());
                        fluidleakstempfixfill.setText(person.getfluidleakstempfixfill());
                        fluidleaksdescribedefectfill.setText(person.getfluidleaksdescribedefectfill());
                        airelectrialtempfixfill.setText(person.getairelectrialtempfixfill());
                        airelectrialdescribedefectfill.setText(person.getairelectrialdescribedefectfill());
                        airsuspensiontempfixfill.setText(person.getairsuspensiontempfixfill());
                        airsuspensiondescribedefectfill.setText(person.getairsuspensiondescribedefectfill());


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
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
                startActivity (new Intent(this, dccdrainageforms.class));
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    public void handleNewLocation(Location location) {

        System.out.println(location);



        Locationlat = location.getLatitude();
        Locationlong = location.getLongitude();





    }

}