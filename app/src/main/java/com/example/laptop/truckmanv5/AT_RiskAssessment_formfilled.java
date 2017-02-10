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

public class AT_RiskAssessment_formfilled extends AppCompatActivity {

    TextView user_name,user_email,user_department_area,user_contact_number,startDate,endDate;

    private Button emailreport;


    ImageButton ratrafficicon100x100;
    ImageButton rappeicon100x100;
    ImageButton raroadsicon100x100;
    ImageButton rafootpathicon100x100;
    ImageButton rarivercleaningicon100x100;

    ImageButton raworkingatheightsicon100x100;
    ImageButton rapowerlinesicon100x100;
    ImageButton ramanhandleicon100x100;
    ImageButton raconspaceicon100x100;
    ImageButton rapowertoolsicon100x100;
    ImageButton rageneralppeicon100x100;

    String traffic_ppe;
    String traffic_roads_or_footpath;

    String raform_trafficppe_yes;
    String raform_trafficppe_no;
    String raform_trafficroads;
    String raform_trafficfootpath;
    String raform_traffictmpguidelines_yes;
    String raform_traffictmpguidelines_no;
    String raform_trafficbeacon_yes;
    String raform_trafficbeacon_no;
    String raform_trafficleftsite_yes;
    String raform_trafficleftsite_no;

    String raform_trafficfallsystem_yes;
    String raform_trafficfallsystem_no;
    String raform_heights_harnessinspect_yes;
    String raform_heights_harnessinspect_no;
    String raform_heights_ladderinspect_yes;
    String raform_heights_ladderinspect_no;
    String raform_heights_laddertie_yes;
    String raform_heights_laddertie_no;
    String raform_heights_manholebarriier_yes;
    String raform_heights_manholebarriier_no;



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
        ramanhandleicon100x100 = (ImageButton) findViewById(R.id.ramanhandleicon100x100);
        raconspaceicon100x100 = (ImageButton) findViewById(R.id.raconspaceicon100x100);
        rapowertoolsicon100x100 = (ImageButton) findViewById(R.id.rapowertoolsicon100x100);
        rageneralppeicon100x100 = (ImageButton) findViewById(R.id.rageneralppeicon100x100);

        raworkingatheightsicon100x100 = (ImageButton) findViewById(R.id.raworkingatheightsicon100x100);
        rapowerlinesicon100x100 = (ImageButton) findViewById(R.id.rapowerlinesicon100x100);



        ///////////////////////////////////////////////////////////////////////////////////



        ///////////////////////////////////////////////////////////////////////////////////

        ratrafficicon100x100 = (ImageButton) findViewById(R.id.ratrafficicon100x100);

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
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "1.1 : PPE REQUIRED?, " + ", " + raform_trafficppe_yes + ", " + raform_trafficppe_no + ", " +
                                "\n" +
                                "1.2 : Working on the Roads or Footpath?, " + ", " + raform_trafficroads + ", " + raform_trafficfootpath + ", " +
                                "\n" +
                                "1.3 : TM applied in accordance with TTM guidelines? " + ", " + raform_traffictmpguidelines_yes + ", " + raform_traffictmpguidelines_no + ", " +
                                "\n" +
                                "1.4 : Beacon switched on when parked at worksite? " + ", " + raform_trafficbeacon_yes + ", " + raform_trafficbeacon_no + ", " +
                                "\n" +
                                "1.5 : Site left in a safe manner? " + ", " + raform_trafficleftsite_yes + ", " + raform_trafficleftsite_no + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  2: Working at Heights  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "2.1 : Fall arrest system inspected and checks are in date?, " + ", " + raform_trafficfallsystem_yes + ", " + raform_trafficfallsystem_no + ", " +
                                "\n" +
                                "2.2 : Harness inspection and in date?, " + ", " + raform_heights_harnessinspect_yes + ", " + raform_heights_harnessinspect_no + ", " +
                                "\n" +
                                "2.3 : Ladder inspection before use?, " + ", " + raform_heights_ladderinspect_yes + ", " + raform_heights_ladderinspect_no + ", " +
                                "\n" +
                                "2.4 : Ladder tied off and correctly footed?, " + ", " + raform_heights_laddertie_yes + ", " + raform_trafficfallsystem_no + ", " +
                                "\n" +
                                "2.5 : Manhole opening barriered off?, " + ", " + raform_heights_manholebarriier_yes + ", " + raform_heights_manholebarriier_no + ", " +
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
                        CheckBox trafficppe_yes = (CheckBox) findViewById(R.id.raform_trafficppe_yes);

                        if (traffic_ppe.equals("Yes")) {

                            trafficppe_yes.setChecked(true);
                        }
                        else {
                            trafficppe_yes.setChecked(false);
                        }

                        CheckBox trafficppe_no = (CheckBox) findViewById(R.id.raform_trafficppe_no);

                        if (traffic_ppe.equals("No")) {

                            trafficppe_no.setChecked(true);
                        }
                        else {
                            trafficppe_no.setChecked(false);
                        }
                        traffic_roads_or_footpath = personDetailsModel.gettraffic_roads_or_footpath();
                        CheckBox trafficroads = (CheckBox) findViewById(R.id.raform_trafficroads);

                        if (traffic_roads_or_footpath.equals("Road")) {

                            trafficroads.setChecked(true);
                        }
                        else {
                            trafficroads.setChecked(false);
                        }

                        CheckBox trafficfootpath = (CheckBox) findViewById(R.id.raform_trafficfootpath);

                        if (traffic_roads_or_footpath.equals("Footpath")) {

                            trafficfootpath.setChecked(true);
                        }
                        else {
                            trafficfootpath.setChecked(false);
                        }
                        raform_traffictmpguidelines_yes = personDetailsModel.getraform_traffictmpguidelines_yes();
                        CheckBox traffictmpguidelines_yes = (CheckBox) findViewById(R.id.raform_traffictmpguidelines_yes);

                        if (raform_traffictmpguidelines_yes.equals("Yes")) {

                            traffictmpguidelines_yes.setChecked(true);
                        }
                        else {
                            traffictmpguidelines_yes.setChecked(false);
                        }
                        raform_traffictmpguidelines_no = personDetailsModel.getraform_traffictmpguidelines_no();
                        CheckBox traffictmpguidelines_no = (CheckBox) findViewById(R.id.raform_traffictmpguidelines_no);

                        if (raform_traffictmpguidelines_no.equals("Yes")) {

                            traffictmpguidelines_no.setChecked(true);
                        }
                        else {
                            traffictmpguidelines_no.setChecked(false);
                        }
                        raform_trafficbeacon_yes = personDetailsModel.getraform_trafficbeacon_yes();
                        CheckBox trafficbeacon_yes = (CheckBox) findViewById(R.id.raform_trafficbeacon_yes);

                        if (raform_trafficbeacon_yes.equals("Yes")) {

                            trafficbeacon_yes.setChecked(true);
                        }
                        else {
                            trafficbeacon_yes.setChecked(false);
                        }
                        raform_trafficbeacon_no = personDetailsModel.getraform_trafficbeacon_no();
                        CheckBox trafficbeacon_no = (CheckBox) findViewById(R.id.raform_trafficbeacon_no);

                        if (raform_trafficbeacon_no.equals("Yes")) {

                            trafficbeacon_no.setChecked(true);
                        }
                        else {
                            trafficbeacon_no.setChecked(false);
                        }
                        raform_trafficleftsite_yes = personDetailsModel.getraform_trafficleftsite_yes();
                        CheckBox trafficleftsite_yes = (CheckBox) findViewById(R.id.raform_trafficleftsite_yes);

                        if (raform_trafficleftsite_yes.equals("Yes")) {

                            trafficleftsite_yes.setChecked(true);
                        }
                        else {
                            trafficleftsite_yes.setChecked(false);
                        }
                        raform_trafficleftsite_no = personDetailsModel.getraform_trafficleftsite_no();
                        CheckBox trafficleftsite_no = (CheckBox) findViewById(R.id.raform_trafficleftsite_no);

                        if (raform_trafficleftsite_no.equals("Yes")) {

                            trafficleftsite_no.setChecked(true);
                        }
                        else {
                            trafficleftsite_no.setChecked(false);
                        }
                        ///////////////////////////////////////2: Working at Heights/////////////////////////////////////////////////

                        raform_trafficfallsystem_yes = personDetailsModel.getraform_trafficfallsystem_yes();
                        CheckBox trafficfallsystem_yes = (CheckBox) findViewById(R.id.raform_trafficfallsystem_yes);

                        if (raform_trafficfallsystem_yes.equals("Yes")) {

                            trafficfallsystem_yes.setChecked(true);
                        }
                        else {
                            trafficfallsystem_yes.setChecked(false);
                        }
                        raform_trafficfallsystem_no = personDetailsModel.getraform_trafficfallsystem_no();
                        CheckBox trafficfallsystem_no = (CheckBox) findViewById(R.id.raform_trafficfallsystem_no);

                        if (raform_trafficfallsystem_no.equals("Yes")) {

                            trafficfallsystem_no.setChecked(true);
                        }
                        else {
                            trafficfallsystem_no.setChecked(false);
                        }
                        raform_heights_harnessinspect_yes = personDetailsModel.getraform_heights_harnessinspect_yes();
                        CheckBox heights_harnessinspect_yes = (CheckBox) findViewById(R.id.raform_heights_harnessinspect_yes);

                        if (raform_heights_harnessinspect_yes.equals("Yes")) {

                            heights_harnessinspect_yes.setChecked(true);
                        }
                        else {
                            heights_harnessinspect_yes.setChecked(false);
                        }
                        raform_heights_harnessinspect_no = personDetailsModel.getraform_heights_harnessinspect_no();
                        CheckBox heights_harnessinspect_no = (CheckBox) findViewById(R.id.raform_heights_harnessinspect_no);

                        if (raform_heights_harnessinspect_no.equals("Yes")) {

                            heights_harnessinspect_no.setChecked(true);
                        }
                        else {
                            heights_harnessinspect_no.setChecked(false);
                        }
                        raform_heights_ladderinspect_yes = personDetailsModel.getraform_heights_ladderinspect_yes();
                        CheckBox heights_ladderinspect_yes = (CheckBox) findViewById(R.id.raform_heights_ladderinspect_yes);

                        if (raform_heights_ladderinspect_yes.equals("Yes")) {

                            heights_ladderinspect_yes.setChecked(true);
                        }
                        else {
                            heights_ladderinspect_yes.setChecked(false);
                        }
                        raform_heights_ladderinspect_no = personDetailsModel.getraform_heights_ladderinspect_no();
                        CheckBox heights_ladderinspect_no = (CheckBox) findViewById(R.id.raform_heights_ladderinspect_no);

                        if (raform_heights_ladderinspect_no.equals("Yes")) {

                            heights_ladderinspect_no.setChecked(true);
                        }
                        else {
                            heights_ladderinspect_no.setChecked(false);
                        }
                        raform_heights_laddertie_yes = personDetailsModel.getraform_heights_laddertie_yes();
                        CheckBox heights_laddertie_yes = (CheckBox) findViewById(R.id.raform_heights_laddertie_yes);

                        if (raform_heights_laddertie_yes.equals("Yes")) {

                            heights_laddertie_yes.setChecked(true);
                        }
                        else {
                            heights_laddertie_yes.setChecked(false);
                        }
                        raform_heights_laddertie_no = personDetailsModel.getraform_heights_laddertie_no();
                        CheckBox heights_laddertie_no = (CheckBox) findViewById(R.id.raform_heights_laddertie_no);

                        if (raform_heights_laddertie_no.equals("Yes")) {

                            heights_laddertie_no.setChecked(true);
                        }
                        else {
                            heights_laddertie_no.setChecked(false);
                        }
                        raform_heights_manholebarriier_yes = personDetailsModel.getraform_heights_manholebarriier_yes();
                        CheckBox heights_manholebarriier_yes = (CheckBox) findViewById(R.id.raform_heights_manholebarriier_yes);

                        if (raform_heights_manholebarriier_yes.equals("Yes")) {

                            heights_manholebarriier_yes.setChecked(true);
                        }
                        else {
                            heights_manholebarriier_yes.setChecked(false);
                        }
                        raform_heights_manholebarriier_no = personDetailsModel.getraform_heights_manholebarriier_no();
                        CheckBox heights_manholebarriier_no = (CheckBox) findViewById(R.id.raform_heights_manholebarriier_no);

                        if (raform_heights_manholebarriier_no.equals("Yes")) {

                            heights_manholebarriier_no.setChecked(true);
                        }
                        else {
                            heights_manholebarriier_no.setChecked(false);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }
}