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

public class AT_Confined_Space_formfilled extends AppCompatActivity {

    TextView user_name,user_email,user_department_area,user_contact_number,startDate,endDate;

    private Button emailreport;

    private String csform_generalppehivisvest;
    private String csform_generalppehardhat;
    private String csform_generalppesafetyboots;
    private String csform_generalppegloves;
    private String csform_generalppeoveralls;
    private String csform_generalppeglasses;

    private String csform_cs_level_1;
    private String csform_cs_level_2;
    private String csform_cs_level_3;

    ImageButton csgeneralppehivisicon100x100;
    ImageButton csgeneralppehardhaticon100x100;
    ImageButton csgeneralppesafetybootsicon100x100;
    ImageButton csgeneralppeglovesicon100x100;
    ImageButton csgeneralppedustoverallicon100x100;
    ImageButton csgeneralppegooglesicon100x100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at__confined__space_formfilled);


        user_name = (TextView) findViewById(R.id.user_name);
        user_email = (TextView) findViewById(R.id.user_email);
        user_department_area = (TextView) findViewById(R.id.user_department_area);
        user_contact_number = (TextView) findViewById(R.id.user_contact_number);
        startDate = (TextView) findViewById(R.id.startDate);
        endDate = (TextView) findViewById(R.id.endDate);

        emailreport = (Button) findViewById(R.id.emailreport);


        int position = getIntent().getIntExtra("Position", -1);
        searchAT_Confined_Space_model(position);


        csgeneralppehivisicon100x100 = (ImageButton) findViewById(R.id.csgeneralppehivisicon100x100);
        csgeneralppehardhaticon100x100 = (ImageButton) findViewById(R.id.csgeneralppehardhaticon100x100);
        csgeneralppesafetybootsicon100x100 = (ImageButton) findViewById(R.id.raroadsicon100x100);
        csgeneralppeglovesicon100x100 = (ImageButton) findViewById(R.id.csgeneralppeglovesicon100x100);
        csgeneralppedustoverallicon100x100 = (ImageButton) findViewById(R.id.csgeneralppedustoverallicon100x100);
        csgeneralppegooglesicon100x100 = (ImageButton) findViewById(R.id.csgeneralppegooglesicon100x100);



        ///////////////////////////////////////////////////////////////////////////////////


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
                        ">>>>>>> Confined Space Report - CHECKLIST<<<<<<<"
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

                        "Report Form, " + "Confined Space" + ", " +
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
                                ">>>>>>>  Appropriate Box for PPE  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "1.1 : His Vis Jacket, " + ", " + csform_generalppehivisvest + ", " +
                                "\n" +
                                "1.2 : Hard Hat, " + ", " + csform_generalppehardhat + ", " +
                                "\n" +
                                "1.3 : Safety Boots, " + ", " + csform_generalppesafetyboots + ", " +
                                "\n" +
                                "1.4 : Safety Gloves, " + ", " + csform_generalppegloves + ", " +
                                "\n" +
                                "1.5 : Safety Overalls, " + ", " + csform_generalppeoveralls + ", " +
                                "\n" +
                                "1.6 : Safety Glasses, " + ", " + csform_generalppeglasses + ", " +
                                "\n" +
                                "\n" +
                                "\n" +
                                ">>>>>>>  End of Report  <<<<<<<" +
                                "\n" +
                                "\n" +
                                ">>>>>>>  Thank you for using DCC App  <<<<<<<" +
                                ", " ;






                File outputDir = getApplicationContext().getExternalCacheDir();

                ScrollView u = (ScrollView) findViewById(R.id.scrollview_confined_space);
                Bitmap screen = Bitmap.createBitmap(u.getChildAt(0).getWidth(), u.getChildAt(0).getHeight(),  Bitmap.Config.ARGB_8888);

                Canvas canvas = new Canvas(screen);
                Drawable bgDrawable = u.getBackground();
                if (bgDrawable != null)
                    bgDrawable.draw(canvas);
                else
                    canvas.drawColor(Color.WHITE);
                u.draw(canvas);

                File pdfFile = new File(outputDir, "Confined_Space_Checklist" + startDatestring + ".pdf");

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
                    intent.putExtra(Intent.EXTRA_SUBJECT, ("DCC Confined Space Checklist :- " + startDatestring + " Submitted by " + user_namestring));
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



    public void searchAT_Confined_Space_model(int position) {
        String clickedKey = AT_Confined_Space_database.getInstance().getKeysArray().get(position);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        AT_Confined_Space_database.getInstance().getmDatabase().child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT Confined Space Form").child(clickedKey).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        AT_Confined_Space_model personDetailsModel = dataSnapshot.getValue(AT_Confined_Space_model.class);
                        user_name.setText(personDetailsModel.getuser_name());
                        user_email.setText(personDetailsModel.getuser_email());
                        user_department_area.setText(personDetailsModel.getuser_department_area());
                        user_contact_number.setText(personDetailsModel.getuser_contact_number());
                        endDate.setText(personDetailsModel.getendDate());
                        startDate.setText(personDetailsModel.getstartDate());

                        ///////////////////////////////////////1: Traffic/////////////////////////////////////////////////

                        csform_generalppehivisvest = personDetailsModel.getcsform_generalppehivisvest();
                        csform_generalppehardhat = personDetailsModel.getcsform_generalppehardhat();
                        csform_generalppesafetyboots = personDetailsModel.getcsform_generalppesafetyboots();
                        csform_generalppegloves = personDetailsModel.getcsform_generalppegloves();
                        csform_generalppeoveralls = personDetailsModel.getcsform_generalppeoveralls();
                        csform_generalppeglasses = personDetailsModel.getcsform_generalppeglasses();

                        csform_cs_level_1 = personDetailsModel.getcsform_cs_level_1();
                        csform_cs_level_2 = personDetailsModel.getcsform_cs_level_2();
                        csform_cs_level_3 = personDetailsModel.getcsform_cs_level_3();


                        CheckBox CK_csform_generalppehivisvest = (CheckBox) findViewById(R.id.csform_generalppehivisvest);
                        CheckBox CK_csform_generalppehardhat = (CheckBox) findViewById(R.id.csform_generalppehardhat);
                        CheckBox CK_csform_generalppesafetyboots = (CheckBox) findViewById(R.id.csform_generalppesafetyboots);
                        CheckBox CK_csform_generalppegloves = (CheckBox) findViewById(R.id.csform_generalppegloves);
                        CheckBox CK_csform_generalppeoveralls = (CheckBox) findViewById(R.id.csform_generalppeoveralls);
                        CheckBox CK_csform_generalppeglasses = (CheckBox) findViewById(R.id.csform_generalppeglasses);

                        CheckBox csform_cs_level_1_checkbox = (CheckBox) findViewById(R.id.csform_cs_level_1_checkbox);
                        CheckBox csform_cs_level_2_checkbox = (CheckBox) findViewById(R.id.csform_cs_level_2_checkbox);
                        CheckBox csform_cs_level_3_checkbox = (CheckBox) findViewById(R.id.csform_cs_level_3_checkbox);


                        if (csform_generalppehivisvest.equals("Yes")) {

                            CK_csform_generalppehivisvest.setChecked(true);
                        }
                        else {
                            CK_csform_generalppehivisvest.setChecked(false);
                        }

                        if (csform_generalppehardhat.equals("Yes")) {

                            CK_csform_generalppehardhat.setChecked(true);
                        }
                        else {
                            CK_csform_generalppehardhat.setChecked(false);
                        }
                        if (csform_generalppesafetyboots.equals("Yes")) {

                            CK_csform_generalppesafetyboots.setChecked(true);
                        }
                        else {
                            CK_csform_generalppesafetyboots.setChecked(false);
                        }
                        if (csform_generalppegloves.equals("Yes")) {

                            CK_csform_generalppegloves.setChecked(true);
                        }
                        else {
                            CK_csform_generalppegloves.setChecked(false);
                        }
                        if (csform_generalppeoveralls.equals("Yes")) {

                            CK_csform_generalppeoveralls.setChecked(true);
                        }
                        else {
                            CK_csform_generalppeoveralls.setChecked(false);
                        }

                        if (csform_generalppeglasses.equals("Yes")) {

                            CK_csform_generalppeglasses.setChecked(true);
                        }
                        else {
                            CK_csform_generalppeglasses.setChecked(false);
                        }


///////////////////////////////////////1: Traffic/////////////////////////////////////////////////
                        if (csform_cs_level_1.equals("Yes")) {

                            csform_cs_level_1_checkbox.setChecked(true);
                        }
                        else {
                            csform_cs_level_1_checkbox.setChecked(false);
                        }

                        if (csform_cs_level_2.equals("Yes")) {

                            csform_cs_level_2_checkbox.setChecked(true);
                        }
                        else {
                            csform_cs_level_2_checkbox.setChecked(false);
                        }

                        if (csform_cs_level_3.equals("Yes")) {

                            csform_cs_level_3_checkbox.setChecked(true);
                        }
                        else {
                            csform_cs_level_3_checkbox.setChecked(false);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }
}