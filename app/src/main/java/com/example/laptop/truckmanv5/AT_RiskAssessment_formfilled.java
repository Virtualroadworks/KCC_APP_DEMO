package com.example.laptop.truckmanv5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.pdf.PrintedPdfDocument;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static com.example.laptop.truckmanv5.R.id.framelayout_workingatheights;

public class AT_RiskAssessment_formfilled extends AppCompatActivity {

    TextView user_name,user_email,user_department_area,user_contact_number,startDate,endDate;

    private Button emailreport;


    ///////////////////////////////////////////////////////////////////////////////////

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
    ImageButton rundergrounddrawingsicon100x100;
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

    private String traffic_ppe;
    private String traffic_roads_or_footpath;
    private String traffic_following_guidelines;
    private String traffic_beacons;
    private String traffic_left_site_in_good_order;

    private String heights_fall_arrest_system;
    private String heights_harness_inspection;
    private String heights_ladder_inspection;
    private String heights_laddertied;
    private String heights_manholebarrier;

    private String riverlifejacket;
    private String riverwaders;
    private String rivertieoffpoint;
    private String riversafeaccess;

    private String overheadpowerlines;

    private String undergrounddrawings;
    private String undergroundcat;

    private String manhandleloadassessed;
    private String manhandlemechanical;
    private String manhandletwomanlift;

    private String confinedspace;

    private String powertools;

    private String generalppesafetygoogles;
    private String generalppehearing;
    private String generalppegloves;
    private String generalppedustoverall;
    private String generalppehivis;
    private String generalppehardhat;
    private String generalppedustmask;

    ///////////////////////////////////////////////////////////////////////////////////

    FrameLayout framelayout_overheadpowerlinesalert;
    FrameLayout framelayout_confinedspacealert;
    FrameLayout framelayout_powertoolsalert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at__risk_assessment_formfilled);


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

        ///////////////////////////////////////////////////////////////////////////////////

        rariverlifejacketicon100x100 = (ImageButton) findViewById(R.id.rariverlifejacketicon100x100);
        rariverwadersicon100x100 = (ImageButton) findViewById(R.id.rariverwadersicon100x100);
        rarivertieoffpointicon100x100 = (ImageButton) findViewById(R.id.rarivertieoffpointicon100x100);
        rariversafeaccessicon100x100 = (ImageButton) findViewById(R.id.rariversafeaccessicon100x100);

        ///////////////////////////////////////////////////////////////////////////////////

        framelayout_overheadpowerlinesalert = (FrameLayout) findViewById(R.id.framelayout_overheadpowerlinesalert);
        framelayout_confinedspacealert = (FrameLayout) findViewById(R.id.framelayout_confinedspacealert);
        framelayout_powertoolsalert = (FrameLayout) findViewById(R.id.framelayout_powertoolsalert);

        ///////////////////////////////////////////////////////////////////////////////////

        raundergroundservicesicon100x100 = (ImageButton) findViewById(R.id.raundergroundservicesicon100x100);
        rundergrounddrawingsicon100x100 = (ImageButton) findViewById(R.id.rundergrounddrawingsicon100x100);
        raundergroundcaticon100x100 = (ImageButton) findViewById(R.id.raundergroundcaticon100x100);

        ///////////////////////////////////////////////////////////////////////////////////

        ramanhandleicon100x100 = (ImageButton) findViewById(R.id.ramanhandleicon100x100);
        ramanhandleloadassessedicon100x100 = (ImageButton) findViewById(R.id.ramanhandleloadassessedicon100x100);
        ramanhandlemechanicalicon100x100 = (ImageButton) findViewById(R.id.ramanhandlemechanicalicon100x100);
        ramanhandletwomanlifticon100x100 = (ImageButton) findViewById(R.id.ramanhandletwomanlifticon100x100);

        ///////////////////////////////////////////////////////////////////////////////////

        raconspaceicon100x100 = (ImageButton) findViewById(R.id.raconspaceicon100x100);
        raconfinedspaceicon100x100 = (ImageButton) findViewById(R.id.raconfinedspaceicon100x100);
        raconfinedspacealert100x100 = (ImageButton) findViewById(R.id.raconfinedspacealert100x100);

        ///////////////////////////////////////////////////////////////////////////////////

        rapowertoolsicon100x100 = (ImageButton) findViewById(R.id.rapowertoolsicon100x100);
        rapowertools2icon100x100 = (ImageButton) findViewById(R.id.rapowertools2icon100x100);
        rapowertoolsiconalert100x100 = (ImageButton) findViewById(R.id.rapowertoolsiconalert100x100);

        ///////////////////////////////////////////////////////////////////////////////////

        rageneralppeicon100x100 = (ImageButton) findViewById(R.id.rageneralppeicon100x100);
        rageneralppesafetygooglesicon100x100 = (ImageButton) findViewById(R.id.rageneralppesafetygooglesicon100x100);
        rageneralppehearing100x100 = (ImageButton) findViewById(R.id.rageneralppehearing100x100);
        rageneralppegloves100x100 = (ImageButton) findViewById(R.id.rageneralppegloves100x100);
        rageneralppedustoverallicon100x100 = (ImageButton) findViewById(R.id.rageneralppedustoverallicon100x100);
        rageneralppehivisicon100x100 = (ImageButton) findViewById(R.id.rageneralppehivisicon100x100);
        rageneralppehardhaticon100x100 = (ImageButton) findViewById(R.id.rageneralppehardhaticon100x100);
        rageneralppedustmaskicon100x100 = (ImageButton) findViewById(R.id.rageneralppedustmaskicon100x100);

        ///////////////////////////////////////////////////////////////////////////////////

        framelayout_overheadpowerlinesalert.setVisibility(LinearLayout.GONE);
        framelayout_confinedspacealert.setVisibility(LinearLayout.GONE);
        framelayout_powertoolsalert.setVisibility(LinearLayout.GONE);


        user_name = (TextView) findViewById(R.id.user_name);
        user_email = (TextView) findViewById(R.id.user_email);
        user_department_area = (TextView) findViewById(R.id.user_department_area);
        user_contact_number = (TextView) findViewById(R.id.user_contact_number);
        startDate = (TextView) findViewById(R.id.startDate);
        endDate = (TextView) findViewById(R.id.endDate);

        emailreport = (Button) findViewById(R.id.emailreport);


        int position = getIntent().getIntExtra("Position", -1);
        searchAT_RiskAssessment_model(position);

        emailreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //uri Address

                TextView user_contact_number = (TextView) findViewById(R.id.user_contact_number);
                String user_contact_numberstring = user_contact_number.getText().toString();
                TextView user_name = (TextView) findViewById(R.id.user_name);
                String user_namestring = user_name.getText().toString();
                TextView startDate = (TextView) findViewById(R.id.startDate);
                String startDatestring = startDate.getText().toString();
                TextView endDate = (TextView) findViewById(R.id.endDate);
                String endDatestring = endDate.getText().toString();
                TextView user_email = (TextView) findViewById(R.id.user_email);
                String user_emailstring = user_email.getText().toString();
                TextView user_department_area = (TextView) findViewById(R.id.user_department_area);
                String user_department_areastring = user_department_area.getText().toString();



                Intent intent=null, chooser=null;

                intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto;"));

                String [] username= { user_emailstring };

                final String template_message =
                        ">>>>>>> Risk Assessment Report - CHECKLIST<<<<<<<"
                                + '\n'
                                + '\n' + "This is a checklist report, filled on " + startDatestring + " using the DCC App."
                                + '\n'
                                + '\n' + "It was compleated and sent in by " + user_namestring
                                + '\n'
                                + '\n' + user_namestring + " works in the " + user_department_areastring + " Department"
                                + '\n'
                                + '\n' + user_namestring + " can be contacted on " + user_contact_numberstring + " if you need to call. "
                                + '\n'
                                + '\n' + ">>>>>>> Attached below is the Excel and PDF of the Report (if Required)<<<<<<<"
                                + '\n'
                                + '\n' + "This email was generated using the DCC App"
                                + '\n'
                                + '\n' + "Kind Regards"
                                + '\n'
                                + '\n' + user_namestring + " (" + user_department_areastring + ")" + " Department"
                                + '\n'
                                + '\n' + "Email : " + user_emailstring;

                final String csvString =

                        "Report Form, " + "Risk Assessment" + ", " +
                                "\n" +
                                "Inspection done by, " + user_namestring + ", " +
                                "\n" +
                                "Email Address, " + user_emailstring + ", " +
                                "\n" +
                                "Date of Inspection, " + startDatestring + ", " +
                                "\n" +
                                "Inspection done by, " + endDatestring + ", " +
                                "\n" +
                                "User Department, " + user_department_areastring + ", " +
                                "\n" +
                                "User Contact number, " + user_contact_numberstring + ", " +
                                "\n" +
                                "\n" +
                                "\n" +
                                ">>>>>>>  1: Traffic  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + ", " + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "1.1 : PPE REQUIRED?, " + ", " + ", " + traffic_ppe + ", " +
                                "\n" +
                                "1.2 : Working on the Roads or Footpath?, " + ", " + ", " + traffic_roads_or_footpath + ", "  +
                                "\n" +
                                "1.3 : TM applied in accordance with TTM guidelines?, " + ", " + ", " + traffic_following_guidelines + ", " +
                                "\n" +
                                "1.4 : Beacon switched on when parked at worksite?, " + ", " + ", " + traffic_beacons + ", " +
                                "\n" +
                                "1.5 : Site left in a safe manner?, " + ", " + ", " + traffic_left_site_in_good_order + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  2: Working at Heights  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + ", " + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "2.1 : Fall arrest system inspected and checks are in date?, " + ", " + ", " + heights_fall_arrest_system + ", " +
                                "\n" +
                                "2.2 : Harness inspection and in date?, " + ", " + ", " + heights_harness_inspection + ", " +
                                "\n" +
                                "2.3 : Ladder inspection before use?, " + ", " + ", " + heights_ladder_inspection + ", " +
                                "\n" +
                                "2.4 : Ladder tied off and correctly footed?, " + ", " + ", " + heights_laddertied + ", " +
                                "\n" +
                                "2.5 : Manhole opening barriered off?, " + ", " + ", " + heights_manholebarrier + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  End of Report  <<<<<<<" +
                                "\n" +
                                "\n" +
                                ">>>>>>>  Thank you for using DCC App  <<<<<<<" +
                                ", " ;



                File outputDir = getApplicationContext().getExternalCacheDir();

                ScrollView u = (ScrollView) findViewById(R.id.scrollview_risk_assessment);
                Bitmap screen = Bitmap.createBitmap(u.getChildAt(0).getWidth(), u.getChildAt(0).getHeight(),  Bitmap.Config.ARGB_8888);

                Canvas canvas = new Canvas(screen);
                Drawable bgDrawable = u.getBackground();
                if (bgDrawable != null)
                    bgDrawable.draw(canvas);
                else
                    canvas.drawColor(Color.WHITE);
                u.draw(canvas);

                File pdfFile = new File(outputDir, "Risk_Assessment_Checklist" + startDatestring + ".pdf");

                try {

                    PrintAttributes printAttributes = new PrintAttributes.Builder().
                            setMediaSize(PrintAttributes.MediaSize.ISO_A4).
                            setResolution(new PrintAttributes.Resolution("zooey", "test", 450, 700)).
                            setMinMargins(PrintAttributes.Margins.NO_MARGINS).build();
                    PrintedPdfDocument document = new PrintedPdfDocument(u.getContext(), printAttributes);
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
                    intent.putExtra(Intent.EXTRA_EMAIL, user_emailstring);
                    intent.putExtra(Intent.EXTRA_SUBJECT, ("DCC Risk Assessment Checklist :- " + startDatestring + " Submitted by " + user_namestring));
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
    }



    public void searchAT_RiskAssessment_model(int position) {
        String clickedKey = AT_RiskAssessment_database.getInstance().getKeysArray().get(position);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        AT_RiskAssessment_database.getInstance().getmDatabase().child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Risk Assessment Form").child(clickedKey).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        AT_RiskAssessment_model personDetailsModel = dataSnapshot.getValue(AT_RiskAssessment_model.class);
                        user_name.setText(personDetailsModel.getuser_name());
                        user_email.setText(personDetailsModel.getuser_email());
                        user_department_area.setText(personDetailsModel.getuser_department_area());
                        user_contact_number.setText(personDetailsModel.getuser_contact_number());
                        endDate.setText(personDetailsModel.getendDate());
                        startDate.setText(personDetailsModel.getstartDate());

                        ///////////////////////////////////////1: Traffic/////////////////////////////////////////////////

                        traffic_ppe = personDetailsModel.gettraffic_ppe();
                        traffic_roads_or_footpath = personDetailsModel.gettraffic_roads_or_footpath();
                        traffic_following_guidelines = personDetailsModel.gettraffic_following_guidelines();
                        traffic_beacons = personDetailsModel.gettraffic_beacons();
                        traffic_left_site_in_good_order = personDetailsModel.gettraffic_left_site_in_good_order();

                        heights_fall_arrest_system = personDetailsModel.getheights_fall_arrest_system();
                        heights_harness_inspection = personDetailsModel.getheights_harness_inspection();
                        heights_ladder_inspection = personDetailsModel.getheights_ladder_inspection();
                        heights_laddertied = personDetailsModel.getheights_laddertied();
                        heights_manholebarrier = personDetailsModel.getheights_manholebarrier();

                        riverlifejacket = personDetailsModel.getriverlifejacket();
                        riverwaders = personDetailsModel.getriverwaders();
                        rivertieoffpoint = personDetailsModel.getrivertieoffpoint();
                        riversafeaccess = personDetailsModel.getriversafeaccess();

                        overheadpowerlines = personDetailsModel.getoverheadpowerlines();

                        undergrounddrawings = personDetailsModel.getundergrounddrawings();
                        undergroundcat = personDetailsModel.getundergroundcat();

                        manhandleloadassessed = personDetailsModel.getmanhandleloadassessed();
                        manhandlemechanical = personDetailsModel.getmanhandlemechanical();
                        manhandletwomanlift = personDetailsModel.getmanhandletwomanlift();

                        confinedspace = personDetailsModel.getconfinedspace();

                        powertools = personDetailsModel.getpowertools();

                        generalppesafetygoogles = personDetailsModel.getgeneralppesafetygoogles();
                        generalppehearing = personDetailsModel.getgeneralppehearing();
                        generalppegloves = personDetailsModel.getgeneralppegloves();
                        generalppedustoverall = personDetailsModel.getgeneralppedustoverall();
                        generalppehivis = personDetailsModel.getgeneralppehivis();
                        generalppehardhat = personDetailsModel.getgeneralppehardhat();
                        generalppedustmask = personDetailsModel.getgeneralppedustmask();


                        CheckBox raform_trafficppe_yes = (CheckBox) findViewById(R.id.raform_trafficppe_yes);
                        CheckBox raform_trafficppe_no = (CheckBox) findViewById(R.id.raform_trafficppe_no);
                        CheckBox raform_trafficroads = (CheckBox) findViewById(R.id.raform_trafficroads);
                        CheckBox raform_trafficfootpath = (CheckBox) findViewById(R.id.raform_trafficfootpath);
                        CheckBox raform_traffictmpguidelines_yes = (CheckBox) findViewById(R.id.raform_traffictmpguidelines_yes);
                        CheckBox raform_traffictmpguidelines_no = (CheckBox) findViewById(R.id.raform_traffictmpguidelines_no);
                        CheckBox raform_trafficbeacon_yes = (CheckBox) findViewById(R.id.raform_trafficbeacon_yes);
                        CheckBox raform_trafficbeacon_no = (CheckBox) findViewById(R.id.raform_trafficbeacon_no);
                        CheckBox raform_trafficleftsite_yes = (CheckBox) findViewById(R.id.raform_trafficleftsite_yes);
                        CheckBox raform_trafficleftsite_no = (CheckBox) findViewById(R.id.raform_trafficleftsite_no);

                        CheckBox raform_trafficfallsystem_yes = (CheckBox) findViewById(R.id.raform_trafficfallsystem_yes);
                        CheckBox raform_trafficfallsystem_no = (CheckBox) findViewById(R.id.raform_trafficfallsystem_no);
                        CheckBox raform_heights_harnessinspect_yes = (CheckBox) findViewById(R.id.raform_heights_harnessinspect_yes);
                        CheckBox raform_heights_harnessinspect_no = (CheckBox) findViewById(R.id.raform_heights_harnessinspect_no);
                        CheckBox raform_heights_ladderinspect_yes = (CheckBox) findViewById(R.id.raform_heights_ladderinspect_yes);
                        CheckBox raform_heights_ladderinspect_no = (CheckBox) findViewById(R.id.raform_heights_ladderinspect_no);
                        CheckBox raform_heights_laddertie_yes = (CheckBox) findViewById(R.id.raform_heights_laddertie_yes);
                        CheckBox raform_heights_laddertie_no = (CheckBox) findViewById(R.id.raform_heights_laddertie_no);
                        CheckBox raform_heights_manholebarriier_yes = (CheckBox) findViewById(R.id.raform_heights_manholebarriier_yes);
                        CheckBox raform_heights_manholebarriier_no = (CheckBox) findViewById(R.id.raform_heights_manholebarriier_no);

                        CheckBox raform_riverlifejacket_yes = (CheckBox) findViewById(R.id.raform_riverlifejacket_yes);
                        CheckBox raform_riverlifejacket_no = (CheckBox) findViewById(R.id.raform_riverlifejacket_no);
                        CheckBox raform_riverwaders_yes = (CheckBox) findViewById(R.id.raform_riverwaders_yes);
                        CheckBox raform_riverwaders_no = (CheckBox) findViewById(R.id.raform_riverwaders_no);
                        CheckBox raform_rivertieoffpoint_yes = (CheckBox) findViewById(R.id.raform_rivertieoffpoint_yes);
                        CheckBox raform_rivertieoffpoint_no = (CheckBox) findViewById(R.id.raform_rivertieoffpoint_no);
                        CheckBox raform_riversafeaccess_yes = (CheckBox) findViewById(R.id.raform_riversafeaccess_yes);
                        CheckBox raform_riversafeaccess_no = (CheckBox) findViewById(R.id.raform_riversafeaccess_no);

                        CheckBox raform_overheadpowerlines_yes = (CheckBox) findViewById(R.id.raform_overheadpowerlines_yes);
                        CheckBox raform_overheadpowerlines_no = (CheckBox) findViewById(R.id.raform_overheadpowerlines_no);

                        CheckBox raform_undergrounddrawings_yes = (CheckBox) findViewById(R.id.raform_undergrounddrawings_yes);
                        CheckBox raform_undergrounddrawings_no = (CheckBox) findViewById(R.id.raform_undergrounddrawings_no);
                        CheckBox raform_undergroundcat_yes = (CheckBox) findViewById(R.id.raform_undergroundcat_yes);
                        CheckBox raform_undergroundcat_no = (CheckBox) findViewById(R.id.raform_undergroundcat_no);

                        CheckBox raform_manhandleloadassessed_yes = (CheckBox) findViewById(R.id.raform_manhandleloadassessed_yes);
                        CheckBox raform_manhandleloadassessed_no = (CheckBox) findViewById(R.id.raform_manhandleloadassessed_no);
                        CheckBox raform_manhandlemechanical_yes = (CheckBox) findViewById(R.id.raform_manhandlemechanical_yes);
                        CheckBox raform_manhandlemechanical_no = (CheckBox) findViewById(R.id.raform_manhandlemechanical_no);
                        CheckBox raform_manhandletwomanlift_yes = (CheckBox) findViewById(R.id.raform_manhandletwomanlift_yes);
                        CheckBox raform_manhandletwomanlift_no = (CheckBox) findViewById(R.id.raform_manhandletwomanlift_no);

                        CheckBox raform_confinedspace_yes = (CheckBox) findViewById(R.id.raform_confinedspace_yes);
                        CheckBox raform_confinedspace_no = (CheckBox) findViewById(R.id.raform_confinedspace_no);

                        CheckBox raform_powertools_yes = (CheckBox) findViewById(R.id.raform_powertools_yes);
                        CheckBox raform_powertools_no = (CheckBox) findViewById(R.id.raform_powertools_no);

                        CheckBox raform_generalppesafetygoogles_yes = (CheckBox) findViewById(R.id.raform_generalppesafetygoogles_yes);
                        CheckBox raform_generalppesafetygoogles_no = (CheckBox) findViewById(R.id.raform_generalppesafetygoogles_no);
                        CheckBox raform_generalppehearing_yes = (CheckBox) findViewById(R.id.raform_generalppehearing_yes);
                        CheckBox raform_generalppehearing_no = (CheckBox) findViewById(R.id.raform_generalppehearing_no);
                        CheckBox raform_generalppegloves_yes = (CheckBox) findViewById(R.id.raform_generalppegloves_yes);
                        CheckBox raform_generalppegloves_no = (CheckBox) findViewById(R.id.raform_generalppegloves_no);
                        CheckBox raform_generalppedustoverall_yes = (CheckBox) findViewById(R.id.raform_generalppedustoverall_yes);
                        CheckBox raform_generalppedustoverall_no = (CheckBox) findViewById(R.id.raform_generalppedustoverall_no);
                        CheckBox raform_generalppehivis_yes = (CheckBox) findViewById(R.id.raform_generalppehivis_yes);
                        CheckBox raform_generalppehivis_no = (CheckBox) findViewById(R.id.raform_generalppehivis_no);
                        CheckBox raform_generalppehardhat_yes = (CheckBox) findViewById(R.id.raform_generalppehardhat_yes);
                        CheckBox raform_generalppehardhat_no = (CheckBox) findViewById(R.id.raform_generalppehardhat_no);
                        CheckBox raform_generalppedustmask_yes = (CheckBox) findViewById(R.id.raform_generalppedustmask_yes);
                        CheckBox raform_generalppedustmask_no = (CheckBox) findViewById(R.id.raform_generalppedustmask_no);

                        ///////////////////////////////////////1: Traffic/////////////////////////////////////////////////


                        if (traffic_ppe.equals("Yes")) {
                            raform_trafficppe_yes.setChecked(true);
                        } else { raform_trafficppe_yes.setChecked(false);
                        }
                        if (traffic_ppe.equals("No")) {
                            raform_trafficppe_no.setChecked(true);
                        } else { raform_trafficppe_no.setChecked(false);
                        }
                        if (traffic_roads_or_footpath.equals("Road")) {
                            raform_trafficroads.setChecked(true);
                        } else { raform_trafficroads.setChecked(false);
                        }
                        if (traffic_roads_or_footpath.equals("Footpath")) {
                            raform_trafficfootpath.setChecked(true);
                        } else { raform_trafficfootpath.setChecked(false);
                        }
                        if (traffic_following_guidelines.equals("Yes")) {
                            raform_traffictmpguidelines_yes.setChecked(true);
                        } else { raform_traffictmpguidelines_yes.setChecked(false);
                        }
                        if (traffic_following_guidelines.equals("No")) {
                            raform_traffictmpguidelines_no.setChecked(true);
                        } else { raform_traffictmpguidelines_no.setChecked(false);
                        }
                        if (traffic_beacons.equals("Yes")) {
                            raform_trafficbeacon_yes.setChecked(true);
                        } else { raform_trafficbeacon_yes.setChecked(false);
                        }
                        if (traffic_beacons.equals("No")) {
                            raform_trafficbeacon_no.setChecked(true);
                        } else { raform_trafficbeacon_no.setChecked(false);
                        }
                        if (traffic_left_site_in_good_order.equals("Yes")) {
                            raform_trafficleftsite_yes.setChecked(true);
                        } else { raform_trafficleftsite_yes.setChecked(false);
                        }
                        if (traffic_left_site_in_good_order.equals("No")) {
                            raform_trafficleftsite_no.setChecked(true);
                        } else { raform_trafficleftsite_no.setChecked(false);
                        }

                        ///////////////////////////////////////2: Heights/////////////////////////////////////////////////

                        if (heights_fall_arrest_system.equals("Yes")) {
                            raform_trafficfallsystem_yes.setChecked(true);
                        } else { raform_trafficfallsystem_yes.setChecked(false);
                        }
                        if (heights_fall_arrest_system.equals("No")) {
                            raform_trafficfallsystem_no.setChecked(true);
                        } else { raform_trafficfallsystem_no.setChecked(false);
                        }
                        if (heights_harness_inspection.equals("Yes")) {
                            raform_heights_harnessinspect_yes.setChecked(true);
                        } else { raform_heights_harnessinspect_yes.setChecked(false);
                        }
                        if (heights_harness_inspection.equals("No")) {
                            raform_heights_harnessinspect_no.setChecked(true);
                        } else { raform_heights_harnessinspect_no.setChecked(false);
                        }
                        if (heights_ladder_inspection.equals("Yes")) {
                            raform_heights_ladderinspect_yes.setChecked(true);
                        } else { raform_heights_ladderinspect_yes.setChecked(false);
                        }
                        if (heights_ladder_inspection.equals("No")) {
                            raform_heights_ladderinspect_no.setChecked(true);
                        } else { raform_heights_ladderinspect_no.setChecked(false);
                        }
                        if (heights_laddertied.equals("Yes")) {
                            raform_heights_laddertie_yes.setChecked(true);
                        } else { raform_heights_laddertie_yes.setChecked(false);
                        }
                        if (heights_laddertied.equals("No")) {
                            raform_heights_laddertie_no.setChecked(true);
                        } else { raform_heights_laddertie_no.setChecked(false);
                        }
                        if (heights_manholebarrier.equals("Yes")) {
                            raform_heights_manholebarriier_yes.setChecked(true);
                        } else { raform_heights_manholebarriier_yes.setChecked(false);
                        }
                        if (heights_manholebarrier.equals("No")) {
                            raform_heights_manholebarriier_no.setChecked(true);
                        } else { raform_heights_manholebarriier_no.setChecked(false);
                        }

                        ///////////////////////////////////////3: River Cleaning/////////////////////////////////////////////////

                        if (riverlifejacket.equals("Yes")) {
                            raform_riverlifejacket_yes.setChecked(true);
                        } else { raform_riverlifejacket_yes.setChecked(false);
                        }
                        if (riverlifejacket.equals("No")) {
                            raform_riverlifejacket_no.setChecked(true);
                        } else { raform_riverlifejacket_no.setChecked(false);
                        }
                        if (riverwaders.equals("Yes")) {
                            raform_riverwaders_yes.setChecked(true);
                        } else { raform_riverwaders_yes.setChecked(false);
                        }
                        if (riverwaders.equals("No")) {
                            raform_riverwaders_no.setChecked(true);
                        } else { raform_riverwaders_no.setChecked(false);
                        }
                        if (rivertieoffpoint.equals("Yes")) {
                            raform_rivertieoffpoint_yes.setChecked(true);
                        } else { raform_rivertieoffpoint_yes.setChecked(false);
                        }
                        if (rivertieoffpoint.equals("No")) {
                            raform_rivertieoffpoint_no.setChecked(true);
                        } else { raform_rivertieoffpoint_no.setChecked(false);
                        }
                        if (riversafeaccess.equals("Yes")) {
                            raform_riversafeaccess_yes.setChecked(true);
                        } else { raform_riversafeaccess_yes.setChecked(false);
                        }
                        if (riversafeaccess.equals("No")) {
                            raform_riversafeaccess_no.setChecked(true);
                        } else { raform_riversafeaccess_no.setChecked(false);
                        }

                        ///////////////////////////////////////4: Overhead Powerlines/////////////////////////////////////////////////
                        if (overheadpowerlines.equals("Yes")) {
                            raform_overheadpowerlines_yes.setChecked(true);
                            framelayout_overheadpowerlinesalert.setVisibility(LinearLayout.VISIBLE);
                        } else { raform_overheadpowerlines_yes.setChecked(false);
                        }
                        if (overheadpowerlines.equals("No")) {
                            raform_overheadpowerlines_no.setChecked(true);
                            framelayout_overheadpowerlinesalert.setVisibility(LinearLayout.GONE);
                        } else { raform_overheadpowerlines_no.setChecked(false);
                        }

                        ///////////////////////////////////////5 underground services/////////////////////////////////////////////////

                        if (undergrounddrawings.equals("Yes")) {
                            raform_undergrounddrawings_yes.setChecked(true);
                        } else { raform_undergrounddrawings_yes.setChecked(false);
                        }
                        if (undergrounddrawings.equals("No")) {
                            raform_undergrounddrawings_no.setChecked(true);
                        } else { raform_undergrounddrawings_no.setChecked(false);
                        }

                        if (undergroundcat.equals("Yes")) {
                            raform_undergroundcat_yes.setChecked(true);
                        } else { raform_undergroundcat_yes.setChecked(false);
                        }
                        if (undergroundcat.equals("No")) {
                            raform_undergroundcat_no.setChecked(true);
                        } else { raform_undergroundcat_no.setChecked(false);
                        }

                        ///////////////////////////////////////6 Manual Handling/////////////////////////////////////////////////

                        if (manhandleloadassessed.equals("Yes")) {
                            raform_manhandleloadassessed_yes.setChecked(true);
                        } else { raform_manhandleloadassessed_yes.setChecked(false);
                        }
                        if (manhandleloadassessed.equals("No")) {
                            raform_manhandleloadassessed_no.setChecked(true);
                        } else { raform_manhandleloadassessed_no.setChecked(false);
                        }

                        if (manhandlemechanical.equals("Yes")) {
                            raform_manhandlemechanical_yes.setChecked(true);
                        } else { raform_manhandlemechanical_yes.setChecked(false);
                        }
                        if (manhandlemechanical.equals("No")) {
                            raform_manhandlemechanical_no.setChecked(true);
                        } else { raform_manhandlemechanical_no.setChecked(false);
                        }

                        if (manhandletwomanlift.equals("Yes")) {
                            raform_manhandletwomanlift_yes.setChecked(true);
                        } else { raform_manhandletwomanlift_yes.setChecked(false);
                        }
                        if (manhandletwomanlift.equals("No")) {
                            raform_manhandletwomanlift_no.setChecked(true);
                        } else { raform_manhandletwomanlift_no.setChecked(false);
                        }
                        ///////////////////////////////////////7: Confined Space/////////////////////////////////////////////////

                        if (confinedspace.equals("Yes")) {
                            raform_confinedspace_yes.setChecked(true);
                            framelayout_confinedspacealert.setVisibility(LinearLayout.VISIBLE);
                        } else { raform_confinedspace_yes.setChecked(false);
                        }
                        if (confinedspace.equals("No")) {
                            raform_confinedspace_no.setChecked(true);
                            framelayout_confinedspacealert.setVisibility(LinearLayout.GONE);
                        } else { raform_confinedspace_no.setChecked(false);
                        }

                        ///////////////////////////////////////8: Power Tools/////////////////////////////////////////////////

                        if (powertools.equals("Yes")) {
                            raform_powertools_yes.setChecked(true);
                            framelayout_powertoolsalert.setVisibility(LinearLayout.VISIBLE);
                        } else { raform_powertools_yes.setChecked(false);
                        }
                        if (powertools.equals("No")) {
                            raform_powertools_no.setChecked(true);
                            framelayout_powertoolsalert.setVisibility(LinearLayout.GONE);
                        } else { raform_powertools_no.setChecked(false);
                        }

                        ///////////////////////////////////////9: General PPE/////////////////////////////////////////////////

                        if (generalppesafetygoogles.equals("Yes")) {
                            raform_generalppesafetygoogles_yes.setChecked(true);
                        } else { raform_generalppesafetygoogles_yes.setChecked(false);
                        }
                        if (generalppesafetygoogles.equals("No")) {
                            raform_generalppesafetygoogles_no.setChecked(true);
                        } else { raform_generalppesafetygoogles_no.setChecked(false);
                        }
                        if (generalppehearing.equals("Yes")) {
                            raform_generalppehearing_yes.setChecked(true);
                        } else { raform_generalppehearing_yes.setChecked(false);
                        }
                        if (generalppehearing.equals("No")) {
                            raform_generalppehearing_no.setChecked(true);
                        } else { raform_generalppehearing_no.setChecked(false);
                        }
                        if (generalppegloves.equals("Yes")) {
                            raform_generalppegloves_yes.setChecked(true);
                        } else { raform_generalppegloves_yes.setChecked(false);
                        }
                        if (generalppegloves.equals("No")) {
                            raform_generalppegloves_no.setChecked(true);
                        } else { raform_generalppegloves_no.setChecked(false);
                        }
                        if (generalppedustoverall.equals("Yes")) {
                            raform_generalppedustoverall_yes.setChecked(true);
                        } else { raform_generalppedustoverall_yes.setChecked(false);
                        }
                        if (generalppedustoverall.equals("No")) {
                            raform_generalppedustoverall_no.setChecked(true);
                        } else { raform_generalppedustoverall_no.setChecked(false);
                        }
                        if (generalppehivis.equals("Yes")) {
                            raform_generalppehivis_yes.setChecked(true);
                        } else { raform_generalppehivis_yes.setChecked(false);
                        }
                        if (generalppehivis.equals("No")) {
                            raform_generalppehivis_no.setChecked(true);
                        } else { raform_generalppehivis_no.setChecked(false);
                        }
                        if (generalppehardhat.equals("Yes")) {
                            raform_generalppehardhat_yes.setChecked(true);
                        } else { raform_generalppehardhat_yes.setChecked(false);
                        }
                        if (generalppehardhat.equals("No")) {
                            raform_generalppehardhat_no.setChecked(true);
                        } else { raform_generalppehardhat_no.setChecked(false);
                        }
                        if (generalppedustmask.equals("Yes")) {
                            raform_generalppedustmask_yes.setChecked(true);
                        } else { raform_generalppedustmask_yes.setChecked(false);
                        }
                        if (generalppedustmask.equals("No")) {
                            raform_generalppedustmask_no.setChecked(true);
                        } else { raform_generalppedustmask_no.setChecked(false);
                        }





                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }
}