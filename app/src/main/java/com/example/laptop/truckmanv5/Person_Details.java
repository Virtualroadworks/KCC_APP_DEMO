package com.example.laptop.truckmanv5;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.print.pdf.PrintedPdfDocument;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static android.R.attr.data;
import static com.example.laptop.truckmanv5.R.attr.background;
import static com.example.laptop.truckmanv5.R.drawable.photoplace100x100taxinsurance;
import static com.example.laptop.truckmanv5.R.id.imageView;

public class Person_Details extends AppCompatActivity {

    private TextView tvPersonDetailName,tvPersonDetailEmail,tvPersonDetailPhone,tvcompanyname,tvReg
            ,startDate,endDate,tvreport_email_recipient,tvlocation_address_view;



    private StorageReference mStorage;

    /////////////////////////////////////////////////////////////////////////
    //New Database Links
    private ImageView taxinsuranceImageviewpicplace;
    private ImageView regplateImageviewpicplace;
    private ImageView airelectrialImageviewpicplace;
    private ImageView fluidleaksImageviewpicplace;
    private ImageView airsuspensionImageviewpicplace;
    private ImageView wheelsandtyresImageviewpicplace;
    private ImageView lightsreflectorsImageviewpicplace;
    private ImageView exhaustImageviewpicplace;
    private ImageView bodyguardsImageviewpicplace;
    private ImageView landinglegImageviewpicplace;
    private ImageView sparetowImageviewpicplace;
    private ImageView trailerbrakeImageviewpicplace;

    private ImageView winmirImageviewpicplace;
    private ImageView seatbeltsImageviewpicplace;
    private ImageView washerandwiperImageviewpicplace;
    private ImageView hornImageviewpicplace;
    private ImageView breakwarninglightImageviewpicplace;
    private ImageView gaugeImageviewpicplace;
    private ImageView tachoImageviewpicplace;
    private ImageView airleaksImageviewpicplace;

    private ImageView steeringbreakingImageviewpicplace;
    private ImageView loadsecureImageviewpicplace;
    private ImageView tachospeedoImageviewpicplace;
    private ImageView nowarninglightsImageviewpicplace;

    private ImageView vehiclephotoImageviewpicplace;

    private TextView winmirtempfixfill_report;
    private TextView winmirdescribedefectfill_report;
    private TextView seatbelttempfixfill_report;
    private TextView seatbeltdescribedefectfill_report;
    private TextView washerandwipertempfixfill_report;
    private TextView washerandwiperdescribedefectfill_report;
    private TextView horntempfixfill_report;
    private TextView horndescribedefectfill_report;
    private TextView breakwarninglighttempfixfill_report;
    private TextView breakwarninglightdescribedefectfill_report;
    private TextView gaugetempfixfill_report;
    private TextView gaugedescribedefectfill_report;
    private TextView tachotempfixfill_report;
    private TextView tachodescribedefectfill_report;
    private TextView airleakstempfixfill_report;
    private TextView airleaksdescribedefectfill_report;
    //Driving Inspection
    private TextView steeringbreakingtempfixfill_report;
    private TextView steeringbreakingdescribedefectfill_report;
    private TextView loadsecuretempfixfill_report;
    private TextView loadsecuredescribedefectfill_report;
    private TextView tachospeedotempfixfill_report;
    private TextView tachospeedodescribedefectfill_report;
    private TextView nowarninglightstempfixfill_report;
    private TextView nowarninglightsdescribedefectfill_report;
    //Outside Inspection
    private TextView taxinsurancetempfixfill_report;
    private TextView taxinsurancedescribedefectfill_report;
    private TextView wheelstyrestempfixfill_report;
    private TextView wheelstyresdescribedefectfill_report;
    private TextView lightsreflectorstempfixfill_report;
    private TextView lightsreflectorsdescribedefectfill_report;
    private TextView exhausttempfixfill_report;
    private TextView exhaustdescribedefectfill_report;
    private TextView sparetowtempfixfill_report;
    private TextView sparetowdescribedefectfill_report;
    private TextView trailerbraketempfixfill_report;
    private TextView trailerbrakedescribedefectfill_report;
    private TextView bodyguardstempfixfill_report;
    private TextView bodyguardsdescribedefectfill_report;
    private TextView landinglegtempfixfill_report;
    private TextView landinglegdescribedefectfill_report;
    private TextView regplatetempfixfill_report;
    private TextView regplatedescribedefectfill_report;
    private TextView fluidleakstempfixfill_report;
    private TextView fluidleaksdescribedefectfill_report;
    private TextView airelectrialtempfixfill_report;
    private TextView airelectrialdescribedefectfill_report;
    private TextView airsuspensiontempfixfill_report;
    private TextView airsuspensiondescribedefectfill_report;


    /////////////////////////////////////////////////////////////////////////
    //Email Reports
    //Email In-Cab


    private ImageButton emailreport;

    /////////////////////////////////////////////////////////////////////////

    String emailsend_name;


    String taxinsurancepictureuri;
    String taxinsurancepicturepath;
    String regplatepictureuri;
    String regplatepicturepath;
    String airelectrialpictureuri;
    String fluidleakspictureuri;
    String airsuspensionpictureuri;
    String wheelsandtyrespictureuri;
    String lightsreflectorspictureuri;
    String exhaustpictureuri;
    String bodyguardspictureuri;
    String landinglegpictureuri;
    String sparetowpictureuri;
    String trailerbrakepictureuri;

    String winmirpictureuri;
    String seatbeltspictureuri;
    String washerandwiperpictureuri;
    String hornpictureuri;
    String breakwarninglightpictureuri;
    String gaugepictureuri;
    String tachopictureuri;
    String airleakspictureuri;

    String steeringbreakingpictureuri;
    String loadsecurepictureuri;
    String tachospeedopictureuri;
    String nowarninglightspictureuri;

    String vehiclephotopictureuri;

    String airelectrialpicturepath;
    String fluidleakspicturepath;
    String airsuspensionpicturepath;
    String wheelsandtyrespicturepath;
    String lightsreflectorspicturepath;
    String exhaustpicturepath;
    String bodyguardspicturepath;
    String landinglegpicturepath;
    String sparetowpicturepath;
    String trailerbrakepicturepath;

    String winmirpicturepath;
    String seatbeltspicturepath;
    String washerandwiperpicturepath;
    String hornpicturepath;
    String breakwarninglightpicturepath;
    String gaugepicturepath;
    String tachopicturepath;
    String airleakspicturepath;

    String steeringbreakingpicturepath;
    String loadsecurepicturepath;
    String tachospeedopicturepath;
    String nowarninglightspicturepath;


    String vehiclephotopicturepath;

    String locationlat;
    String locationlong;


    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }

    /////////////////////////////////////////////////////////////////////////



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person__details);

        mStorage = FirebaseStorage.getInstance().getReference();





        emailreport = (ImageButton) findViewById(R.id.emailreport);





        emailreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tvPersonDetailNameemailemail = (TextView) findViewById(R.id.tvPersonDetailName);
                String tvPersonDetailNameemailemailstring = tvPersonDetailNameemailemail.getText().toString();
                TextView tvreport_email_recipientmail = (TextView) findViewById(R.id.tvreport_email_recipient);
                String tvreport_email_recipientmailstring = tvreport_email_recipientmail.getText().toString();
                TextView tvlocation_address_viewmail = (TextView) findViewById(R.id.tvlocation_address_view);
                String tvlocation_address_viewmailstring = tvlocation_address_viewmail.getText().toString();
                TextView tvPersonDetailEmailemail = (TextView) findViewById(R.id.tvPersonDetailEmail);
                String tvPersonDetailEmailemailstring = tvPersonDetailEmailemail.getText().toString();
                TextView tvcompanynameemail = (TextView) findViewById(R.id.tvcompanyname);
                String tvcompanynameemailstring = tvcompanynameemail.getText().toString();
                TextView tvPersonDetailPhoneemail = (TextView) findViewById(R.id.tvPersonDetailPhone);
                String tvPersonDetailPhoneemailstring = tvPersonDetailPhoneemail.getText().toString();
                TextView startDateemail = (TextView) findViewById(R.id.startDate);
                String startDateemailstring = startDateemail.getText().toString();
                TextView endDateemail = (TextView) findViewById(R.id.endDate);
                String endDateemailstring = endDateemail.getText().toString();
                TextView tvRegemail = (TextView) findViewById(R.id.tvReg);
                String tvRegemailstring = tvRegemail.getText().toString();

                //Outside Inspection

                TextView taxinsurancedescribedefectfill_reportemail = (TextView) findViewById(R.id.taxinsurancedescribedefectfill_report);
                String taxinsurancedescribedefectfill_reportemailstring = taxinsurancedescribedefectfill_reportemail.getText().toString();
                TextView taxinsurancetempfixfill_reportemail = (TextView) findViewById(R.id.taxinsurancetempfixfill_report);
                String taxinsurancetempfixfill_reportemailstring = taxinsurancetempfixfill_reportemail.getText().toString();

                TextView regplatedescribedefectfill_reportemail = (TextView) findViewById(R.id.regplatedescribedefectfill_report);
                String regplatedescribedefectfill_reportemailstring = regplatedescribedefectfill_reportemail.getText().toString();
                TextView regplatetempfixfill_reportemail = (TextView) findViewById(R.id.regplatetempfixfill_report);
                String regplatetempfixfill_reportemailstring = regplatetempfixfill_reportemail.getText().toString();

                TextView airelectrialdescribedefectfill_reportemail = (TextView) findViewById(R.id.airelectrialdescribedefectfill_report);
                String airelectrialdescribedefectfill_reportemailstring = airelectrialdescribedefectfill_reportemail.getText().toString();
                TextView airelectrialtempfixfill_reportemail = (TextView) findViewById(R.id.airelectrialtempfixfill_report);
                String airelectrialtempfixfill_reportemailstring = airelectrialtempfixfill_reportemail.getText().toString();

                TextView fluidleaksdescribedefectfill_reportemail = (TextView) findViewById(R.id.fluidleaksdescribedefectfill_report);
                String fluidleaksdescribedefectfill_reportemailstring = fluidleaksdescribedefectfill_reportemail.getText().toString();
                TextView fluidleakstempfixfill_reportemail = (TextView) findViewById(R.id.fluidleakstempfixfill_report);
                String fluidleakstempfixfill_reportemailstring = fluidleakstempfixfill_reportemail.getText().toString();

                TextView airsuspensiondescribedefectfill_reportemail = (TextView) findViewById(R.id.airsuspensiondescribedefectfill_report);
                String airsuspensiondescribedefectfill_reportemailstring = airsuspensiondescribedefectfill_reportemail.getText().toString();
                TextView airsuspensiontempfixfill_reportemail = (TextView) findViewById(R.id.airsuspensiontempfixfill_report);
                String airsuspensiontempfixfill_reportemailstring = airsuspensiontempfixfill_reportemail.getText().toString();

                TextView wheelstyresdescribedefectfill_reportemail = (TextView) findViewById(R.id.wheelstyresdescribedefectfill_report);
                String wheelstyresdescribedefectfill_reportemailstring = wheelstyresdescribedefectfill_reportemail.getText().toString();
                TextView wheelstyrestempfixfill_reportemail = (TextView) findViewById(R.id.wheelstyrestempfixfill_report);
                String wheelstyrestempfixfill_reportemailstring = wheelstyrestempfixfill_reportemail.getText().toString();

                TextView exhaustdescribedefectfill_reportemail = (TextView) findViewById(R.id.exhaustdescribedefectfill_report);
                String exhaustdescribedefectfill_reportemailstring = exhaustdescribedefectfill_reportemail.getText().toString();
                TextView exhausttempfixfill_reportemail = (TextView) findViewById(R.id.exhausttempfixfill_report);
                String exhausttempfixfill_reportemailstring = exhausttempfixfill_reportemail.getText().toString();

                TextView lightsreflectorsdescribedefectfill_reportemail = (TextView) findViewById(R.id.lightsreflectorsdescribedefectfill_report);
                String lightsreflectorsdescribedefectfill_reportemailstring = lightsreflectorsdescribedefectfill_reportemail.getText().toString();
                TextView lightsreflectorstempfixfill_reportemail = (TextView) findViewById(R.id.lightsreflectorstempfixfill_report);
                String lightsreflectorstempfixfill_reportemailstring = lightsreflectorstempfixfill_reportemail.getText().toString();

                TextView bodyguardsdescribedefectfill_reportemail = (TextView) findViewById(R.id.bodyguardsdescribedefectfill_report);
                String bodyguardsdescribedefectfill_reportemailstring = bodyguardsdescribedefectfill_reportemail.getText().toString();
                TextView bodyguardstempfixfill_reportemail = (TextView) findViewById(R.id.bodyguardstempfixfill_report);
                String bodyguardstempfixfill_reportemailstring = bodyguardstempfixfill_reportemail.getText().toString();

                TextView landinglegdescribedefectfill_reportemail = (TextView) findViewById(R.id.landinglegdescribedefectfill_report);
                String landinglegdescribedefectfill_reportemailstring = landinglegdescribedefectfill_reportemail.getText().toString();
                TextView landinglegtempfixfill_reportemail = (TextView) findViewById(R.id.landinglegtempfixfill_report);
                String landinglegtempfixfill_reportemailstring = landinglegtempfixfill_reportemail.getText().toString();

                TextView sparetowdescribedefectfill_reportemail = (TextView) findViewById(R.id.sparetowdescribedefectfill_report);
                String sparetowdescribedefectfill_reportemailstring = sparetowdescribedefectfill_reportemail.getText().toString();
                TextView sparetowtempfixfill_reportemail = (TextView) findViewById(R.id.sparetowtempfixfill_report);
                String sparetowtempfixfill_reportemailstring = sparetowtempfixfill_reportemail.getText().toString();

                TextView trailerbrakedescribedefectfill_reportemail = (TextView) findViewById(R.id.trailerbrakedescribedefectfill_report);
                String trailerbrakedescribedefectfill_reportemailstring = trailerbrakedescribedefectfill_reportemail.getText().toString();
                TextView trailerbraketempfixfill_reportemail = (TextView) findViewById(R.id.trailerbraketempfixfill_report);
                String trailerbraketempfixfill_reportemailstring = trailerbraketempfixfill_reportemail.getText().toString();

                //In-Cab Inspection

                TextView winmirdescribedefectfill_reportemail = (TextView) findViewById(R.id.winmirdescribedefectfill_report);
                String winmirdescribedefectfill_reportemailstring = winmirdescribedefectfill_reportemail.getText().toString();
                TextView winmirtempfixfill_reportemail = (TextView) findViewById(R.id.winmirtempfixfill_report);
                String winmirtempfixfill_reportemailstring = winmirtempfixfill_reportemail.getText().toString();

                TextView seatbeltdescribedefectfill_reportemail = (TextView) findViewById(R.id.seatbeltdescribedefectfill_report);
                String seatbeltdescribedefectfill_reportemailstring = seatbeltdescribedefectfill_reportemail.getText().toString();
                TextView seatbelttempfixfill_reportemail = (TextView) findViewById(R.id.seatbelttempfixfill_report);
                String seatbelttempfixfill_reportemailstring = seatbelttempfixfill_reportemail.getText().toString();

                TextView washerandwiperdescribedefectfill_reportemail = (TextView) findViewById(R.id.washerandwiperdescribedefectfill_report);
                String washerandwiperdescribedefectfill_reportemailstring = washerandwiperdescribedefectfill_reportemail.getText().toString();
                TextView washerandwipertempfixfill_reportemail = (TextView) findViewById(R.id.washerandwipertempfixfill_report);
                String washerandwipertempfixfill_reportemailstring = washerandwipertempfixfill_reportemail.getText().toString();

                TextView horndescribedefectfill_reportemail = (TextView) findViewById(R.id.horndescribedefectfill_report);
                String horndescribedefectfill_reportemailstring = horndescribedefectfill_reportemail.getText().toString();
                TextView horntempfixfill_reportemail = (TextView) findViewById(R.id.horntempfixfill_report);
                String horntempfixfill_reportemailstring = horntempfixfill_reportemail.getText().toString();

                TextView breakwarninglightdescribedefectfill_reportemail = (TextView) findViewById(R.id.breakwarninglightdescribedefectfill_report);
                String breakwarninglightdescribedefectfill_reportemailstring = breakwarninglightdescribedefectfill_reportemail.getText().toString();
                TextView breakwarninglighttempfixfill_reportemail = (TextView) findViewById(R.id.breakwarninglighttempfixfill_report);
                String breakwarninglighttempfixfill_reportemailstring = breakwarninglighttempfixfill_reportemail.getText().toString();

                TextView gaugedescribedefectfill_reportemail = (TextView) findViewById(R.id.gaugedescribedefectfill_report);
                String gaugedescribedefectfill_reportemailstring = gaugedescribedefectfill_reportemail.getText().toString();
                TextView gaugetempfixfill_reportemail = (TextView) findViewById(R.id.gaugetempfixfill_report);
                String gaugetempfixfill_reportemailstring = gaugetempfixfill_reportemail.getText().toString();

                TextView tachodescribedefectfill_reportemail = (TextView) findViewById(R.id.tachodescribedefectfill_report);
                String tachodescribedefectfill_reportemailstring = tachodescribedefectfill_reportemail.getText().toString();
                TextView tachotempfixfill_reportemail = (TextView) findViewById(R.id.tachotempfixfill_report);
                String tachotempfixfill_reportemailstring = tachotempfixfill_reportemail.getText().toString();

                TextView airleaksdescribedefectfill_reportemail = (TextView) findViewById(R.id.airleaksdescribedefectfill_report);
                String airleaksdescribedefectfill_reportemailstring = airleaksdescribedefectfill_reportemail.getText().toString();
                TextView airleakstempfixfill_reportemail = (TextView) findViewById(R.id.airleakstempfixfill_report);
                String airleakstempfixfill_reportemailstring = airleakstempfixfill_reportemail.getText().toString();

                //Driving Inspection

                TextView steeringbreakingdescribedefectfill_reportemail = (TextView) findViewById(R.id.steeringbreakingdescribedefectfill_report);
                String steeringbreakingdescribedefectfill_reportemailstring = steeringbreakingdescribedefectfill_reportemail.getText().toString();
                TextView steeringbreakingtempfixfill_reportemail = (TextView) findViewById(R.id.steeringbreakingtempfixfill_report);
                String steeringbreakingtempfixfill_reportemailstring = steeringbreakingtempfixfill_reportemail.getText().toString();

                TextView loadsecuredescribedefectfill_reportemail = (TextView) findViewById(R.id.loadsecuredescribedefectfill_report);
                String loadsecuredescribedefectfill_reportemailstring = loadsecuredescribedefectfill_reportemail.getText().toString();
                TextView loadsecuretempfixfill_reportemail = (TextView) findViewById(R.id.loadsecuretempfixfill_report);
                String loadsecuretempfixfill_reportemailstring = loadsecuretempfixfill_reportemail.getText().toString();

                TextView tachospeedodescribedefectfill_reportemail = (TextView) findViewById(R.id.tachospeedodescribedefectfill_report);
                String tachospeedodescribedefectfill_reportemailstring = tachospeedodescribedefectfill_reportemail.getText().toString();
                TextView tachospeedotempfixfill_reportemail = (TextView) findViewById(R.id.tachospeedotempfixfill_report);
                String tachospeedotempfixfill_reportemailstring = tachospeedotempfixfill_reportemail.getText().toString();

                TextView nowarninglightsdescribedefectfill_reportemail = (TextView) findViewById(R.id.nowarninglightsdescribedefectfill_report);
                String nowarninglightsdescribedefectfill_reportemailstring = nowarninglightsdescribedefectfill_reportemail.getText().toString();
                TextView nowarninglightstempfixfill_reportemail = (TextView) findViewById(R.id.nowarninglightstempfixfill_report);
                String nowarninglightstempfixfill_reportemailstring = nowarninglightstempfixfill_reportemail.getText().toString();

                //uri Address

                Intent intent=null, chooser=null;

                intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto;"));

                String [] username= { emailsend_name };

                final String template_message =
                        ">>>>>>> Truckman Report <<<<<<<"
                        + '\n'
                        + '\n' + "This is a Vehicle inspection report, filled by " + tvPersonDetailNameemailemailstring + " using the Truckman App."
                        + '\n'
                        + '\n' + "An inspection has just been filled out and compleated on vehicle reg number "
                        + '\n'
                        + tvRegemailstring + "."
                        + '\n'
                        + '\n'
                        + tvPersonDetailNameemailemailstring + " works for " + tvcompanynameemailstring + ", their contact number is " + tvPersonDetailPhoneemailstring + "."
                        + '\n'
                        + '\n' + "The time this vehicle Inspection started was on the " + startDateemailstring + "."
                        + '\n'
                        + '\n' + "The time this vehicle Inspection ended was on the " + endDateemailstring + "."
                        + '\n'
                        + '\n' + "Vehicle Photo : " + "."
                        + '\n' + vehiclephotopictureuri
                        + '\n'
                        + '\n' + "Attached you will find the inspection results."
                        + '\n'
                        + '\n'
                        + '\n' + ">>>>>>> End of vehicle report <<<<<<<"
                        + '\n'
                        + '\n' + "Thank you for using the DCC App"
                        + '\n'
                        + '\n' + "Kind Regards"
                        + '\n'
                        + '\n' + "The Truckman Team.";


                final String csvString =

                         ", " + "Truckman Report"+ "\n" +
                        "Date of Inspection, " + startDateemailstring + '\n' +
                        "Inspector Name, " + tvPersonDetailNameemailemailstring + '\n' +
                        "Vehicle reg number, " + tvRegemailstring + "\n" +
                        "Email Address, " + tvPersonDetailEmailemailstring + "\n" +
                        "Company Name, " + tvcompanynameemailstring + "\n" +
                        "Contact Number, " + tvPersonDetailPhoneemailstring + "\n" +
                        "Start Inspection time, " + startDateemailstring + "\n" +
                        "Finish Inspection time, " + endDateemailstring + "\n" +
                        "Vehicle Photo, " + vehiclephotopictureuri + "\n" +
                        "\n" +
                        "Below you will find the inspection results" + "\n" +
                        "\n" +
                        ">>>>>>> OutSide Inspection <<<<<<<" + "\n" +
                                 "\n" +
                                 "Tax Insurance defect fill, " + taxinsurancedescribedefectfill_reportemailstring + "\n" +
                                 "Tax Insurance Temp defect fill, " + taxinsurancetempfixfill_reportemailstring + "\n" +
                                 "Tax Insurance Photo, " + taxinsurancepictureuri + "\n" +
                                 "Reg Plate defect fill, " + regplatedescribedefectfill_reportemailstring + "\n" +
                                 "Reg Plate Temp defect fill, " + regplatetempfixfill_reportemailstring + "\n" +
                                 "Reg Plate Photo, " + regplatepictureuri + "\n" +
                                 "Air Electrial defect fill, " + airelectrialdescribedefectfill_reportemailstring + "\n" +
                                 "Air Electrial Temp defect fill, " + airelectrialtempfixfill_reportemailstring + "\n" +
                                 "Air Electrial Photo, " + airelectrialpictureuri + "\n" +
                                 "Fluid leaks defect fill, " + fluidleaksdescribedefectfill_reportemailstring + "\n" +
                                 "Fluid leaks Temp defect fill, " + fluidleakstempfixfill_reportemailstring + "\n" +
                                 "Fluid Leaks Photo, " + fluidleakspictureuri + "\n" +
                                 "Air Suspension defect fill, " + airsuspensiondescribedefectfill_reportemailstring + "\n" +
                                 "Air Suspension Temp defect fill, " + airsuspensiontempfixfill_reportemailstring + "\n" +
                                 "Air Suspension Photo, " + airsuspensionpictureuri + "\n" +
                                 "Wheels and Tyres defect fill, " + wheelstyresdescribedefectfill_reportemailstring + "\n" +
                                 "Wheels and Tyres Temp defect fill, " + wheelstyrestempfixfill_reportemailstring + "\n" +
                                 "Wheels and Tyres Photo, " + wheelsandtyrespictureuri + "\n" +
                                 "Lights and Reflectors defect fill, " + lightsreflectorsdescribedefectfill_reportemailstring + "\n" +
                                 "Lights and Reflectors Temp defect fill, " + lightsreflectorstempfixfill_reportemailstring + "\n" +
                                 "Lights and Reflectors Photo, " + lightsreflectorspictureuri + "\n" +
                                 "Exhaust defect fill, " + exhaustdescribedefectfill_reportemailstring + "\n" +
                                 "Exhaust Temp defect fill, " + exhausttempfixfill_reportemailstring + "\n" +
                                 "Exhaust Photo, " + exhaustpictureuri + "\n" +
                                 "Body and Guards defect fill, " + bodyguardsdescribedefectfill_reportemailstring + "\n" +
                                 "Body and Guards Temp defect fill, " + bodyguardstempfixfill_reportemailstring + "\n" +
                                 "Body Guards Photo, " + bodyguardspictureuri + "\n" +
                                 "Landing Leg defect fill, " + landinglegdescribedefectfill_reportemailstring + "\n" +
                                 "Landing Leg defect fill, " + landinglegtempfixfill_reportemailstring + "\n" +
                                 "Landing Leg Photo, " + landinglegpictureuri + "\n" +
                                 "Spare Tow defect fill, " + sparetowdescribedefectfill_reportemailstring + "\n" +
                                 "Spare Tow Temp defect fill, " + sparetowtempfixfill_reportemailstring + "\n" +
                                 "Spare Tow Photo, " + sparetowpictureuri + "\n" +
                                 "Trailer break defect fill, " + trailerbrakedescribedefectfill_reportemailstring + "\n" +
                                 "Trailer break defect fill, " + trailerbraketempfixfill_reportemailstring + "\n" +
                                 "Trailer Brake Photo, " + trailerbrakepictureuri + "\n" +
                                 "\n" +
                                 ">>>>>>> In-Cab Inspection <<<<<<<" + "\n" +
                                 "\n" +
                                 "Windows and Mirrors defect fill, " + winmirdescribedefectfill_reportemailstring + "\n" +
                                 "Windows and Mirrors Temp defect fill, " + winmirtempfixfill_reportemailstring + "\n" +
                                 "Windows and Mirrors Photo, " + winmirpictureuri + "\n" +
                                 "Seatbelt defect fill, " + seatbeltdescribedefectfill_reportemailstring + "\n" +
                                 "Seatbelt break defect fill, " + seatbelttempfixfill_reportemailstring + "\n" +
                                 "Seatbelts Photo, " + seatbeltspictureuri + "\n" +
                                 "Washer and Wiper defect fill, " + washerandwiperdescribedefectfill_reportemailstring + "\n" +
                                 "Washer and Wiper Temp defect fill, " + washerandwipertempfixfill_reportemailstring + "\n" +
                                 "Washer and Wiper Photo, " + washerandwiperpictureuri + "\n" +
                                 "Horn defect fill, " + horndescribedefectfill_reportemailstring + "\n" +
                                 "Horn defect fill, " + horntempfixfill_reportemailstring + "\n" +
                                 "Horn Photo, " + hornpictureuri + "\n" +
                                 "Break Warning Lights defect fill, " + breakwarninglightdescribedefectfill_reportemailstring + "\n" +
                                 "Break Warning Lights Temp defect fill, " +  breakwarninglighttempfixfill_reportemailstring + "\n" +
                                 "Break Warning Lights Photo, " + breakwarninglightpictureuri + "\n" +
                                 "Gauges defect fill, " + gaugedescribedefectfill_reportemailstring + "\n" +
                                 "Gauges defect fill, " + gaugetempfixfill_reportemailstring + "\n" +
                                 "Gauges Photo, " + gaugepictureuri + "\n" +
                                 "Tacho defect fill, " + tachodescribedefectfill_reportemailstring + "\n" +
                                 "Tacho Temp defect fill, " +  tachotempfixfill_reportemailstring + "\n" +
                                 "Tacho Photo, " + tachopictureuri + "\n" +
                                 "Air Leaks defect fill, " + airleaksdescribedefectfill_reportemailstring + "\n" +
                                 "Air Leaks defect fill, " + airleakstempfixfill_reportemailstring + "\n" +
                                 "Airleaks Photo, " + airleakspictureuri + "\n" +
                                 "\n" +
                                 ">>>>>>> Driving Inspection <<<<<<<" + "\n" +
                                 "\n" +
                                 "Steering and Breaking defect fill, " + steeringbreakingdescribedefectfill_reportemailstring + "\n" +
                                 "Steering and Breaking Temp defect fill, " +  steeringbreakingtempfixfill_reportemailstring + "\n" +
                                 "Steering and Breaking Photo, " + steeringbreakingpictureuri + "\n" +
                                 "Load secure defect fill, " + loadsecuredescribedefectfill_reportemailstring + "\n" +
                                 "Load secure fill, " + loadsecuretempfixfill_reportemailstring + "\n" +
                                 "Load secure Photo, " + loadsecurepictureuri + "\n" +
                                 "Tacho and Speedo defect fill, " + tachospeedodescribedefectfill_reportemailstring + "\n" +
                                 "Tacho and Speedo Temp defect fill, " +  tachospeedotempfixfill_reportemailstring + "\n" +
                                 "Tacho and Speedo limiter Photo, " + tachospeedopictureuri + "\n" +
                                 "No Warning lights defect fill, " + nowarninglightsdescribedefectfill_reportemailstring + "\n" +
                                 "No Warning lights  fill, " + nowarninglightstempfixfill_reportemailstring + "\n" +
                                "No Warning Lights limiter Photo, " + nowarninglightspictureuri + "\n"
                                + "\n" + ", "
                                + "\n" + ", ";


                File outputDir = getApplicationContext().getExternalCacheDir();

                ScrollView u = (ScrollView) findViewById(R.id.scrollView3);
                Bitmap screen = Bitmap.createBitmap(u.getChildAt(0).getWidth(), u.getChildAt(0).getHeight(),  Bitmap.Config.ARGB_8888);

                Canvas canvas = new Canvas(screen);
                Drawable bgDrawable = u.getBackground();
                if (bgDrawable != null)
                    bgDrawable.draw(canvas);
                else
                    canvas.drawColor(Color.WHITE);
                u.draw(canvas);


                File pdfFile = new File(outputDir, "Vehicle Report" + startDateemailstring + ".pdf");

                try {

                    PrintAttributes printAttributes = new PrintAttributes.Builder().
                            setMediaSize(PrintAttributes.MediaSize.ISO_A4).
                            setResolution(new PrintAttributes.Resolution("zooey", "test", 450, 700)).
                            setMinMargins(PrintAttributes.Margins.NO_MARGINS).build();
                    PrintedPdfDocument  document = new PrintedPdfDocument(u.getContext(), printAttributes);
                    PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(screen.getWidth(), screen.getHeight(), 1).create();
                    PdfDocument.Page page = document.startPage(pageInfo);

                    canvas = page.getCanvas();
                    Rect src = new Rect(0, 0, u.getChildAt(0).getWidth(), u.getChildAt(0).getHeight());
                    // get the page canvas and measure it.
                    Canvas pageCanvas = page.getCanvas();
                    float pageWidth = pageCanvas.getWidth();
                    float pageHeight = pageCanvas.getHeight();
                    // how can we fit the Rect src onto this page while maintaining aspect ratio?
                    float scale = Math.min(pageWidth/src.width(), pageHeight/src.height());
                    float left = pageWidth / 2 - src.width() * scale / 2;
                    float top = pageHeight / 2 - src.height() * scale / 2;
                    float right = pageWidth / 2 + src.width() * scale / 2;
                    float bottom = pageHeight / 2 + src.height() * scale / 2;
                    RectF dst = new RectF(left, top, right, bottom);

                    pageCanvas.drawBitmap(screen, src, dst, null);

                 //   canvas.drawBitmap(screen, 0, 0, null);

                    document.finishPage(page);
                    FileOutputStream fos = new FileOutputStream(pdfFile);
                    document.writeTo(fos);
                    document.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }


                File csvfile;
                try {
                    csvfile = File.createTempFile("report", ".csv", outputDir);
                    FileWriter fileWriter = new FileWriter(csvfile, true);
                    fileWriter.write(csvString);
                    fileWriter.flush();
                    fileWriter.close();

                    intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                    intent.putExtra(Intent.EXTRA_EMAIL, tvPersonDetailEmailemailstring);
                    intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { tvreport_email_recipientmailstring });
                    intent.putExtra(Intent.EXTRA_SUBJECT, ("Truckman Vehicle Report :- " + startDateemailstring + " Submitted By " + tvPersonDetailNameemailemailstring));
                    intent.putExtra(Intent.EXTRA_TEXT, template_message);

                    ArrayList<Uri> uris = new ArrayList<Uri>();
                    uris.add(Uri.fromFile(csvfile));
                    uris.add(Uri.fromFile(pdfFile));
                    intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);

                    intent.setType("message/rfc822");
                    chooser=Intent.createChooser(intent,"Send Email");
                    startActivity(chooser);

                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });


        taxinsuranceImageviewpicplace = (ImageView) findViewById(R.id.taxinsuranceImageviewpicplace);
        regplateImageviewpicplace = (ImageView) findViewById(R.id.regplateImageviewpicplace);
        airelectrialImageviewpicplace = (ImageView) findViewById(R.id.airelectrialImageviewpicplace);
        fluidleaksImageviewpicplace = (ImageView) findViewById(R.id.fluidleaksImageviewpicplace);
        airsuspensionImageviewpicplace = (ImageView) findViewById(R.id.airsuspensionImageviewpicplace);
        wheelsandtyresImageviewpicplace = (ImageView) findViewById(R.id.wheelsandtyresImageviewpicplace);
        lightsreflectorsImageviewpicplace = (ImageView) findViewById(R.id.lightsreflectorsImageviewpicplace);
        exhaustImageviewpicplace = (ImageView) findViewById(R.id.exhaustImageviewpicplace);
        bodyguardsImageviewpicplace = (ImageView) findViewById(R.id.bodyguardsImageviewpicplace);
        landinglegImageviewpicplace = (ImageView) findViewById(R.id.landinglegImageviewpicplace);
        sparetowImageviewpicplace = (ImageView) findViewById(R.id.sparetowImageviewpicplace);
        trailerbrakeImageviewpicplace = (ImageView) findViewById(R.id.trailerbrakeImageviewpicplace);

        winmirImageviewpicplace = (ImageView) findViewById(R.id.winmirImageviewpicplace);
        seatbeltsImageviewpicplace = (ImageView) findViewById(R.id.seatbeltsImageviewpicplace);
        washerandwiperImageviewpicplace = (ImageView) findViewById(R.id.washerandwiperImageviewpicplace);
        hornImageviewpicplace = (ImageView) findViewById(R.id.hornImageviewpicplace);
        breakwarninglightImageviewpicplace = (ImageView) findViewById(R.id.breakwarninglightImageviewpicplace);
        gaugeImageviewpicplace = (ImageView) findViewById(R.id.gaugeImageviewpicplace);
        tachoImageviewpicplace = (ImageView) findViewById(R.id.tachoImageviewpicplace);
        airleaksImageviewpicplace = (ImageView) findViewById(R.id.airleaksImageviewpicplace);

        steeringbreakingImageviewpicplace = (ImageView) findViewById(R.id.steeringbreakingImageviewpicplace);
        loadsecureImageviewpicplace = (ImageView) findViewById(R.id.loadsecureImageviewpicplace);
        tachospeedoImageviewpicplace = (ImageView) findViewById(R.id.tachospeedoImageviewpicplace);
        nowarninglightsImageviewpicplace = (ImageView) findViewById(R.id.nowarninglightsImageviewpicplace);

        vehiclephotoImageviewpicplace = (ImageView) findViewById(R.id.vehiclephotoImageviewpicplace);



        tvPersonDetailName= (TextView) findViewById(R.id.tvPersonDetailName);
        tvPersonDetailEmail= (TextView) findViewById(R.id.tvPersonDetailEmail);
        tvPersonDetailPhone= (TextView) findViewById(R.id.tvPersonDetailPhone);
        tvreport_email_recipient= (TextView) findViewById(R.id.tvreport_email_recipient);
        tvlocation_address_view= (TextView) findViewById(R.id.tvlocation_address_view);


        tvcompanyname= (TextView) findViewById(R.id.tvcompanyname);
        tvReg= (TextView) findViewById(R.id.tvReg);
        startDate= (TextView) findViewById(R.id.startDate);
        endDate= (TextView) findViewById(R.id.endDate);
        winmirtempfixfill_report= (TextView) findViewById(R.id.winmirtempfixfill_report);
        winmirdescribedefectfill_report= (TextView) findViewById(R.id.winmirdescribedefectfill_report);
        seatbelttempfixfill_report= (TextView) findViewById(R.id.seatbelttempfixfill_report);
        seatbeltdescribedefectfill_report= (TextView) findViewById(R.id.seatbeltdescribedefectfill_report);
        washerandwipertempfixfill_report= (TextView) findViewById(R.id.washerandwipertempfixfill_report);
        washerandwiperdescribedefectfill_report= (TextView) findViewById(R.id.washerandwiperdescribedefectfill_report);
        horntempfixfill_report= (TextView) findViewById(R.id.horntempfixfill_report);
        horndescribedefectfill_report= (TextView) findViewById(R.id.horndescribedefectfill_report);
        breakwarninglighttempfixfill_report= (TextView) findViewById(R.id.breakwarninglighttempfixfill_report);
        breakwarninglightdescribedefectfill_report= (TextView) findViewById(R.id.breakwarninglightdescribedefectfill_report);
        gaugetempfixfill_report= (TextView) findViewById(R.id.gaugetempfixfill_report);
        gaugedescribedefectfill_report= (TextView) findViewById(R.id.gaugedescribedefectfill_report);
        tachotempfixfill_report= (TextView) findViewById(R.id.tachotempfixfill_report);
        tachodescribedefectfill_report= (TextView) findViewById(R.id.tachodescribedefectfill_report);
        airleakstempfixfill_report= (TextView) findViewById(R.id.airleakstempfixfill_report);
        airleaksdescribedefectfill_report= (TextView) findViewById(R.id.airleaksdescribedefectfill_report);
        //Driving Inspection
        steeringbreakingtempfixfill_report= (TextView) findViewById(R.id.steeringbreakingtempfixfill_report);
        steeringbreakingdescribedefectfill_report= (TextView) findViewById(R.id.steeringbreakingdescribedefectfill_report);
        loadsecuretempfixfill_report= (TextView) findViewById(R.id.loadsecuretempfixfill_report);
        loadsecuredescribedefectfill_report= (TextView) findViewById(R.id.loadsecuredescribedefectfill_report);
        tachospeedotempfixfill_report= (TextView) findViewById(R.id.tachospeedotempfixfill_report);
        tachospeedodescribedefectfill_report= (TextView) findViewById(R.id.tachospeedodescribedefectfill_report);
        nowarninglightstempfixfill_report= (TextView) findViewById(R.id.nowarninglightstempfixfill_report);
        nowarninglightsdescribedefectfill_report= (TextView) findViewById(R.id.nowarninglightsdescribedefectfill_report);
        //Outside Inspection
        taxinsurancetempfixfill_report= (TextView) findViewById(R.id.taxinsurancetempfixfill_report);
        taxinsurancedescribedefectfill_report= (TextView) findViewById(R.id.taxinsurancedescribedefectfill_report);
        wheelstyrestempfixfill_report= (TextView) findViewById(R.id.wheelstyrestempfixfill_report);
        wheelstyresdescribedefectfill_report= (TextView) findViewById(R.id.wheelstyresdescribedefectfill_report);
        lightsreflectorstempfixfill_report= (TextView) findViewById(R.id.lightsreflectorstempfixfill_report);
        lightsreflectorsdescribedefectfill_report= (TextView) findViewById(R.id.lightsreflectorsdescribedefectfill_report);
        exhausttempfixfill_report= (TextView) findViewById(R.id.exhausttempfixfill_report);
        exhaustdescribedefectfill_report= (TextView) findViewById(R.id.exhaustdescribedefectfill_report);
        sparetowtempfixfill_report= (TextView) findViewById(R.id.sparetowtempfixfill_report);
        sparetowdescribedefectfill_report= (TextView) findViewById(R.id.sparetowdescribedefectfill_report);
        trailerbraketempfixfill_report= (TextView) findViewById(R.id.trailerbraketempfixfill_report);
        trailerbrakedescribedefectfill_report= (TextView) findViewById(R.id.trailerbrakedescribedefectfill_report);
        bodyguardstempfixfill_report= (TextView) findViewById(R.id.bodyguardstempfixfill_report);
        bodyguardsdescribedefectfill_report= (TextView) findViewById(R.id.bodyguardsdescribedefectfill_report);
        landinglegtempfixfill_report= (TextView) findViewById(R.id.landinglegtempfixfill_report);
        landinglegdescribedefectfill_report= (TextView) findViewById(R.id.landinglegdescribedefectfill_report);
        regplatetempfixfill_report= (TextView) findViewById(R.id.regplatetempfixfill_report);
        regplatedescribedefectfill_report= (TextView) findViewById(R.id.regplatedescribedefectfill_report);
        fluidleakstempfixfill_report= (TextView) findViewById(R.id.fluidleakstempfixfill_report);
        fluidleaksdescribedefectfill_report= (TextView) findViewById(R.id.fluidleaksdescribedefectfill_report);
        airelectrialtempfixfill_report= (TextView) findViewById(R.id.airelectrialtempfixfill_report);
        airelectrialdescribedefectfill_report= (TextView) findViewById(R.id.airelectrialdescribedefectfill_report);
        airsuspensiontempfixfill_report= (TextView) findViewById(R.id.airsuspensiontempfixfill_report);
        airsuspensiondescribedefectfill_report= (TextView) findViewById(R.id.airsuspensiondescribedefectfill_report);


        int position = getIntent().getIntExtra("Position", -1);
        searchPerson(position);

    }


    public void searchPerson(int position) {
        String clickedKey = Vehicle_Reports.getInstance().getKeysArray().get(position);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        Vehicle_Reports.getInstance().getmDatabase().child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Vehicle Inspection Form").child(clickedKey).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override

                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        Person personDetailsModel = dataSnapshot.getValue(Person.class);
                        tvPersonDetailName.setText(personDetailsModel.getuser_name());
                        tvPersonDetailEmail.setText(personDetailsModel.getuser_email());
                        tvreport_email_recipient.setText(personDetailsModel.getreport_email_recipient());
                        tvlocation_address_view.setText(personDetailsModel.getlocation_address_view());
                        tvPersonDetailPhone.setText(personDetailsModel.getuser_contact_number());
                        tvcompanyname.setText(personDetailsModel.getuser_company());
                        tvReg.setText(personDetailsModel.getReg());
                        endDate.setText(personDetailsModel.getendDate());
                        startDate.setText(personDetailsModel.getstartDate());
                        winmirtempfixfill_report.setText(personDetailsModel.getwinmirtempfixfill());
                        winmirdescribedefectfill_report.setText(personDetailsModel.getwinmirdescribedefectfill());
                        seatbelttempfixfill_report.setText(personDetailsModel.getseatbeltstempfixfill());
                        seatbeltdescribedefectfill_report.setText(personDetailsModel.getseatbeltsdescribedefectfill());
                        washerandwipertempfixfill_report.setText(personDetailsModel.getwasherandwipertempfixfill());
                        washerandwiperdescribedefectfill_report.setText(personDetailsModel.getwasherandwiperdescribedefectfill());
                        horntempfixfill_report.setText(personDetailsModel.gethorntempfixfill());
                        horndescribedefectfill_report.setText(personDetailsModel.gethorndescribedefectfill());
                        breakwarninglighttempfixfill_report.setText(personDetailsModel.getbreakwarninglighttempfixfill());
                        breakwarninglightdescribedefectfill_report.setText(personDetailsModel.getbreakwarninglightdescribedefectfill());
                        gaugetempfixfill_report.setText(personDetailsModel.getgaugetempfixfill());
                        gaugedescribedefectfill_report.setText(personDetailsModel.getgaugedescribedefectfill());
                        tachotempfixfill_report.setText(personDetailsModel.gettachotempfixfill());
                        tachodescribedefectfill_report.setText(personDetailsModel.gettachodescribedefectfill());
                        airleakstempfixfill_report.setText(personDetailsModel.getairleakstempfixfill());
                        airleaksdescribedefectfill_report.setText(personDetailsModel.getairleaksdescribedefectfill());
                        //Driving Inspection
                        steeringbreakingtempfixfill_report.setText(personDetailsModel.getsteeringbreakingtempfixfill());
                        steeringbreakingdescribedefectfill_report.setText(personDetailsModel.getsteeringbreakingdescribedefectfill());
                        loadsecuretempfixfill_report.setText(personDetailsModel.getloadsecuretempfixfill());
                        loadsecuredescribedefectfill_report.setText(personDetailsModel.getloadsecuredescribedefectfill());
                        tachospeedotempfixfill_report.setText(personDetailsModel.gettachospeedotempfixfill());
                        tachospeedodescribedefectfill_report.setText(personDetailsModel.gettachospeedodescribedefectfill());
                        nowarninglightstempfixfill_report.setText(personDetailsModel.getnowarninglightstempfixfill());
                        nowarninglightsdescribedefectfill_report.setText(personDetailsModel.getnowarninglightsdescribedefectfill());
                        //Outside Inspection
                        taxinsurancetempfixfill_report.setText(personDetailsModel.gettaxinsurancetempfixfill());
                        taxinsurancedescribedefectfill_report.setText(personDetailsModel.gettaxinsurancedescribedefectfill());
                        wheelstyrestempfixfill_report.setText(personDetailsModel.getwheelstyrestempfixfill());
                        wheelstyresdescribedefectfill_report.setText(personDetailsModel.getwheelstyresdescribedefectfill());
                        lightsreflectorstempfixfill_report.setText(personDetailsModel.getlightsreflectorstempfixfill());
                        lightsreflectorsdescribedefectfill_report.setText(personDetailsModel.getlightsreflectorsdescribedefectfill());
                        exhausttempfixfill_report.setText(personDetailsModel.getexhausttempfixfill());
                        exhaustdescribedefectfill_report.setText(personDetailsModel.getexhaustdescribedefectfill());
                        sparetowtempfixfill_report.setText(personDetailsModel.getsparetowtempfixfill());
                        sparetowdescribedefectfill_report.setText(personDetailsModel.getsparetowdescribedefectfill());
                        trailerbraketempfixfill_report.setText(personDetailsModel.gettrailerbraketempfixfill());
                        trailerbrakedescribedefectfill_report.setText(personDetailsModel.gettrailerbrakedescribedefectfill());
                        bodyguardstempfixfill_report.setText(personDetailsModel.getbodyguardstempfixfill());
                        bodyguardsdescribedefectfill_report.setText(personDetailsModel.getbodyguardsdescribedefectfill());
                        landinglegtempfixfill_report.setText(personDetailsModel.getlandinglegtempfixfill());
                        landinglegdescribedefectfill_report.setText(personDetailsModel.getlandinglegdescribedefectfill());
                        regplatetempfixfill_report.setText(personDetailsModel.getregplatetempfixfill());
                        regplatedescribedefectfill_report.setText(personDetailsModel.getregplatedescribedefectfill());
                        fluidleakstempfixfill_report.setText(personDetailsModel.getfluidleakstempfixfill());
                        fluidleaksdescribedefectfill_report.setText(personDetailsModel.getfluidleaksdescribedefectfill());
                        airelectrialtempfixfill_report.setText(personDetailsModel.getairelectrialtempfixfill());
                        airelectrialdescribedefectfill_report.setText(personDetailsModel.getairelectrialdescribedefectfill());
                        airsuspensiontempfixfill_report.setText(personDetailsModel.getairsuspensiontempfixfill());
                        airsuspensiondescribedefectfill_report.setText(personDetailsModel.getairsuspensiondescribedefectfill());
                        //url address
                        taxinsurancepictureuri = personDetailsModel.gettaxinsurancepictureuri();
                        taxinsurancepicturepath = personDetailsModel.gettaxinsurancepicturepath();
                        regplatepictureuri = personDetailsModel.getregplatepictureuri();
                        regplatepicturepath = personDetailsModel.getregplatepicturepath();
                        airelectrialpictureuri = personDetailsModel.getairelectrialpictureuri();
                        fluidleakspictureuri = personDetailsModel.getfluidleakspictureuri();
                        airsuspensionpictureuri = personDetailsModel.getairsuspensionpictureuri();
                        wheelsandtyrespictureuri = personDetailsModel.getwheelsandtyrespictureuri();
                        lightsreflectorspictureuri = personDetailsModel.getlightsreflectorspictureuri();
                        exhaustpictureuri = personDetailsModel.getexhaustpictureuri();
                        bodyguardspictureuri = personDetailsModel.getbodyguardspictureuri();
                        landinglegpictureuri = personDetailsModel.getlandinglegpictureuri();
                        sparetowpictureuri = personDetailsModel.getsparetowpictureuri();
                        trailerbrakepictureuri = personDetailsModel.gettrailerbrakepictureuri();

                        winmirpictureuri = personDetailsModel.getwinmirpictureuri();
                        seatbeltspictureuri = personDetailsModel.getseatbeltspictureuri();
                        washerandwiperpictureuri = personDetailsModel.getwasherandwiperpictureuri();
                        hornpictureuri = personDetailsModel.gethornpictureuri();
                        breakwarninglightpictureuri = personDetailsModel.getbreakwarninglightpictureuri();
                        gaugepictureuri = personDetailsModel.getgaugepictureuri();
                        tachopictureuri = personDetailsModel.gettachopictureuri();
                        airleakspictureuri = personDetailsModel.getairleakspictureuri();

                        steeringbreakingpictureuri = personDetailsModel.getsteeringbreakingpictureuri();
                        loadsecurepictureuri = personDetailsModel.getloadsecurepictureuri();
                        tachospeedopictureuri = personDetailsModel.gettachospeedopictureuri();
                        nowarninglightspictureuri = personDetailsModel.getnowarninglightspictureuri();

                        vehiclephotopictureuri = personDetailsModel.getvehiclephotopictureuri();

                        airelectrialpicturepath = personDetailsModel.getairelectrialpicturepath();
                        fluidleakspicturepath = personDetailsModel.getfluidleakspicturepath();
                        airsuspensionpicturepath = personDetailsModel.getairsuspensionpicturepath();
                        wheelsandtyrespicturepath = personDetailsModel.getwheelsandtyrespicturepath();
                        lightsreflectorspicturepath = personDetailsModel.getlightsreflectorspicturepath();
                        exhaustpicturepath = personDetailsModel.getexhaustpicturepath();
                        bodyguardspicturepath = personDetailsModel.getbodyguardspicturepath();
                        landinglegpicturepath = personDetailsModel.getlandinglegpicturepath();
                        sparetowpicturepath = personDetailsModel.getsparetowpicturepath();
                        trailerbrakepicturepath = personDetailsModel.gettrailerbrakepicturepath();

                        winmirpicturepath = personDetailsModel.getwinmirpicturepath();
                        seatbeltspicturepath = personDetailsModel.getseatbeltspicturepath();
                        washerandwiperpicturepath = personDetailsModel.getwasherandwiperpicturepath();
                        hornpicturepath = personDetailsModel.gethornpicturepath();
                        breakwarninglightpicturepath = personDetailsModel.getbreakwarninglightpicturepath();
                        gaugepicturepath = personDetailsModel.getgaugepicturepath();
                        tachopicturepath = personDetailsModel.gettachopicturepath();
                        airleakspicturepath = personDetailsModel.getairleakspicturepath();
                        steeringbreakingpicturepath = personDetailsModel.getsteeringbreakingpicturepath();
                        loadsecurepicturepath = personDetailsModel.getloadsecurepicturepath();
                        tachospeedopicturepath= personDetailsModel.gettachospeedopicturepath();
                        nowarninglightspicturepath = personDetailsModel.getnowarninglightspicturepath();
                        vehiclephotopicturepath = personDetailsModel.getvehiclephotopicturepath();

                        Picasso.with(Person_Details.this).load(taxinsurancepictureuri).resize(300,300).centerCrop().into(taxinsuranceImageviewpicplace);
                        Picasso.with(Person_Details.this).load(regplatepictureuri).resize(300,300).centerCrop().into(regplateImageviewpicplace);
                        Picasso.with(Person_Details.this).load(airelectrialpictureuri).resize(300,300).centerCrop().into(airelectrialImageviewpicplace);
                        Picasso.with(Person_Details.this).load(fluidleakspictureuri).resize(300,300).centerCrop().into(fluidleaksImageviewpicplace);
                        Picasso.with(Person_Details.this).load(airsuspensionpictureuri).resize(300,300).centerCrop().into(airsuspensionImageviewpicplace);
                        Picasso.with(Person_Details.this).load(wheelsandtyrespictureuri).resize(300,300).centerCrop().into(wheelsandtyresImageviewpicplace);
                        Picasso.with(Person_Details.this).load(lightsreflectorspictureuri).resize(300,300).centerCrop().into(lightsreflectorsImageviewpicplace);
                        Picasso.with(Person_Details.this).load(exhaustpictureuri).resize(300,300).centerCrop().into(exhaustImageviewpicplace);
                        Picasso.with(Person_Details.this).load(bodyguardspictureuri).resize(300,300).centerCrop().into(bodyguardsImageviewpicplace);
                        Picasso.with(Person_Details.this).load(landinglegpictureuri).resize(300,300).centerCrop().into(landinglegImageviewpicplace);
                        Picasso.with(Person_Details.this).load(sparetowpictureuri).resize(300,300).centerCrop().into(sparetowImageviewpicplace);
                        Picasso.with(Person_Details.this).load(trailerbrakepictureuri).resize(300,300).centerCrop().into(trailerbrakeImageviewpicplace);


                        Picasso.with(Person_Details.this).load(winmirpictureuri).resize(300,300).centerCrop().into(winmirImageviewpicplace);
                        Picasso.with(Person_Details.this).load(seatbeltspictureuri).resize(300,300).centerCrop().into(seatbeltsImageviewpicplace);
                        Picasso.with(Person_Details.this).load(washerandwiperpictureuri).resize(300,300).centerCrop().into(washerandwiperImageviewpicplace);
                        Picasso.with(Person_Details.this).load(hornpictureuri).resize(300,300).centerCrop().into(hornImageviewpicplace);
                        Picasso.with(Person_Details.this).load(breakwarninglightpictureuri).resize(300,300).centerCrop().into(breakwarninglightImageviewpicplace);
                        Picasso.with(Person_Details.this).load(gaugepictureuri).resize(300,300).centerCrop().into(gaugeImageviewpicplace);
                        Picasso.with(Person_Details.this).load(tachopictureuri).resize(300,300).centerCrop().into(tachoImageviewpicplace);
                        Picasso.with(Person_Details.this).load(airleakspictureuri).resize(300,300).centerCrop().into(airleaksImageviewpicplace);

                        Picasso.with(Person_Details.this).load(steeringbreakingpictureuri).resize(300,300).centerCrop().into(steeringbreakingImageviewpicplace);
                        Picasso.with(Person_Details.this).load(loadsecurepictureuri).resize(300,300).centerCrop().into(loadsecureImageviewpicplace);
                        Picasso.with(Person_Details.this).load(tachospeedopictureuri).resize(300,300).centerCrop().into(tachospeedoImageviewpicplace);
                        Picasso.with(Person_Details.this).load(nowarninglightspictureuri).resize(300,300).centerCrop().into(nowarninglightsImageviewpicplace);


                        Picasso.with(Person_Details.this).load(vehiclephotopictureuri).fit().centerCrop().into(vehiclephotoImageviewpicplace);
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


}

