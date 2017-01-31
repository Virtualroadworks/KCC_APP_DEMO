package com.example.laptop.truckmanv5;

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
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AT_RiskAssessment_formfilled extends AppCompatActivity {

    TextView user_name,user_email,user_department_area,user_contact_number,startDate,endDate;
    TextView at0013_3ck_nature_works_other_box;
    TextView at0013_3ck_hazard_tmp_comments;

    private Button emailreport;

    LinearLayout at0013_3ck_tony_robinson_layout;
    LinearLayout at0013_3ck_mark_dixon_layout;
    LinearLayout at0013_3ck_brian_byrne_layout;
    LinearLayout at0013_3ck_declan_byrne_layout;
    LinearLayout at0013_3ck_michael_mccormack_layout;
    LinearLayout at0013_3ck_david_mcasey_layout;
    LinearLayout at0013_3ck_eamonn_storey_layout;
    LinearLayout at0013_3ck_thomas_martin_layout;
    LinearLayout at0013_3ck_richard_gilligan_layout;
    LinearLayout at0013_3ck_noel_perry_layout;
    LinearLayout at0013_3ck_willie_harris_layout;
    LinearLayout at0013_3ck_kieran_fitzgerald_layout;
    LinearLayout at0013_3ck_mark_dalton_layout;
    LinearLayout at0013_3ck_william_burke_layout;
    LinearLayout at0013_3ck_martin_maher_layout;
    LinearLayout at0013_3ck_graham_mcloghlin_layout;
    LinearLayout at0013_3ck_christy_oreilly_layout;
    LinearLayout at0013_3ck_ritchie_kavanagh_layout;

    String at0013_3ck_tony_robinson;
    String at0013_3ck_mark_dixon;
    String at0013_3ck_brian_byrne;
    String at0013_3ck_declan_byrne;
    String at0013_3ck_michael_mccormack;
    String at0013_3ck_david_mcasey;
    String at0013_3ck_eamonn_storey;
    String at0013_3ck_thomas_martin;
    String at0013_3ck_richard_gilligan;
    String at0013_3ck_noel_perry;
    String at0013_3ck_willie_harris;
    String at0013_3ck_kieran_fitzgerald;
    String at0013_3ck_mark_dalton;
    String at0013_3ck_william_burke;
    String at0013_3ck_martin_maher;
    String at0013_3ck_graham_mcloghlin;
    String at0013_3ck_christy_oreilly;
    String at0013_3ck_ritchie_kavanagh;

    String at0013_3ck_river_cleaning;
    String at0013_3ck_debris_removal;
    String at0013_3ck_screen_cleaning;
    String at0013_3ck_tree_cutting;
    String at0013_3ck_weir_maintenance;
    String at0013_3ck_river_dredging;
    String at0013_3ck_nature_works_other;
    LinearLayout at0013_3ck_nature_works_commentsbox;


    String at0013_3ck_safepass;
    String at0013_3ck_manual_handling;
    String at0013_3ck_water_awareness;
    String at0013_3ck_chainsaw;
    String at0013_3ck_tirfor_winch;
    String at0013_3ck_confined_space;

    String at0013_3ck_safety_footware;
    String at0013_3ck_high_vis_vest;
    String at0013_3ck_gloves;
    String at0013_3ck_safety_helmet;
    String at0013_3ck_ear_protection;
    String at0013_3ck_eye_protection;
    String at0013_3ck_life_jacket;
    String at0013_3ck_chainsaw_suit;
    String at0013_3ck_waders;
    String at0013_3ck_throw_bags;

    String at0013_3ck_life_line;
    String at0013_3ck_hazard_life_jacket;
    String at0013_3ck_hazard_throw_bags;
    String at0013_3ck_hazard_na;

    String at0013_3ck_river_bank_life_line;
    String at0013_3ck_river_bank_laddders;
    String at0013_3ck_river_bank_safety_footware;
    String at0013_3ck_river_bank_na;
    String at0013_3ck_hazard_yes;
    String at0013_3ck_hazard_no;
    String at0013_3ck_barrier_na;
    String at0013_3ck_hazard_hog_avoid;
    String at0013_3ck_hazard_hog_ppe;
    String at0013_3ck_hazard_hog_na;
    String at0013_3ck_hazard_hygine_ppe;
    String at0013_3ck_hazard_washing_facilities;
    String at0013_3ck_hazard_canteen;
    String at0013_3ck_hazard_clean_tools;
    String at0013_3ck_hazard_sharp_prevention_pack;
    String at0013_3ck_hazard_hygiene_na;
    String at0013_3ck_hazard_tmp_number;
    String at0013_3ck_hazard_tmp_na;

    String at0013_3pictureuri;
    String at0013_3picturepath;

    ImageView at0013_3pictureuripicplace;

    ImageButton ratrafficicon100x100;


    LinearLayout at0013_3ck_hazard_tmp_number_box;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at__risk_assessment_formfilled);

        ratrafficicon100x100 = (ImageButton) findViewById(R.id.ratrafficicon100x100);

        user_name = (TextView) findViewById(R.id.user_name);
        user_email = (TextView) findViewById(R.id.user_email);
        user_department_area = (TextView) findViewById(R.id.user_department_area);
        user_contact_number = (TextView) findViewById(R.id.user_contact_number);
        startDate = (TextView) findViewById(R.id.startDate);
        endDate = (TextView) findViewById(R.id.endDate);

        emailreport = (Button) findViewById(R.id.emailreport);

        at0013_3ck_nature_works_commentsbox = (LinearLayout) findViewById(R.id.at0013_3ck_nature_works_commentsbox);
        at0013_3ck_hazard_tmp_number_box = (LinearLayout) findViewById(R.id.at0013_3ck_hazard_tmp_number_box);

        at0013_3ck_tony_robinson_layout = (LinearLayout) findViewById(R.id.at0013_3ck_tony_robinson_layout);
        at0013_3ck_mark_dixon_layout = (LinearLayout) findViewById(R.id.at0013_3ck_mark_dixon_layout);
        at0013_3ck_brian_byrne_layout = (LinearLayout) findViewById(R.id.at0013_3ck_brian_byrne_layout);
        at0013_3ck_declan_byrne_layout = (LinearLayout) findViewById(R.id.at0013_3ck_declan_byrne_layout);
        at0013_3ck_michael_mccormack_layout = (LinearLayout) findViewById(R.id.at0013_3ck_michael_mccormack_layout);
        at0013_3ck_david_mcasey_layout = (LinearLayout) findViewById(R.id.at0013_3ck_david_mcasey_layout);
        at0013_3ck_eamonn_storey_layout = (LinearLayout) findViewById(R.id.at0013_3ck_eamonn_storey_layout);
        at0013_3ck_thomas_martin_layout = (LinearLayout) findViewById(R.id.at0013_3ck_thomas_martin_layout);
        at0013_3ck_richard_gilligan_layout = (LinearLayout) findViewById(R.id.at0013_3ck_richard_gilligan_layout);
        at0013_3ck_noel_perry_layout = (LinearLayout) findViewById(R.id.at0013_3ck_noel_perry_layout);
        at0013_3ck_willie_harris_layout = (LinearLayout) findViewById(R.id.at0013_3ck_willie_harris_layout);
        at0013_3ck_kieran_fitzgerald_layout = (LinearLayout) findViewById(R.id.at0013_3ck_kieran_fitzgerald_layout);
        at0013_3ck_mark_dalton_layout = (LinearLayout) findViewById(R.id.at0013_3ck_mark_dalton_layout);
        at0013_3ck_william_burke_layout = (LinearLayout) findViewById(R.id.at0013_3ck_william_burke_layout);
        at0013_3ck_martin_maher_layout = (LinearLayout) findViewById(R.id.at0013_3ck_martin_maher_layout);
        at0013_3ck_graham_mcloghlin_layout = (LinearLayout) findViewById(R.id.at0013_3ck_graham_mcloghlin_layout);
        at0013_3ck_christy_oreilly_layout = (LinearLayout) findViewById(R.id.at0013_3ck_christy_oreilly_layout);
        at0013_3ck_ritchie_kavanagh_layout = (LinearLayout) findViewById(R.id.at0013_3ck_ritchie_kavanagh_layout);


        at0013_3pictureuripicplace = (ImageView) findViewById(R.id.at0013_3pictureuripicplace);

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

                //String at0013_3ck_tony_robinsonstring = at0013_3ck_tony_robinson.toString();
                TextView at0013_3ck_nature_works_other_box = (TextView) findViewById(R.id.at0013_3ck_nature_works_other_box);
                String at0013_3ck_nature_works_other_boxstring = at0013_3ck_nature_works_other_box.getText().toString();
                TextView at0013_3ck_hazard_tmp_comments = (TextView) findViewById(R.id.at0013_3ck_hazard_tmp_comments);
                String at0013_3ck_hazard_tmp_commentsstring = at0013_3ck_hazard_tmp_comments.getText().toString();


                Intent intent=null, chooser=null;

                intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto;"));

                String [] username= { user_emailstring };

                final String template_message =
                        ">>>>>>> AT0013_3 Report - RIVERGANG CREW DAILY CHECKLIST<<<<<<<"
                                + '\n'
                                + '\n' + "This is a Rivergang crew checklist report, filled on " + startDatestring + " using the DCC App."
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

                        "Report Form, " + "AT0013_3" + ", " +
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
                                ">>>>>>>  Staff Selection  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "Tony Robinson, " + at0013_3ck_tony_robinson + ", " +
                                "\n" +
                                "Mark Dixon, " + at0013_3ck_mark_dixon + ", " +
                                "\n" +
                                "Brian Byrne, " + at0013_3ck_brian_byrne + ", " +
                                "\n" +
                                "Declan Byrne, " + at0013_3ck_declan_byrne + ", " +
                                "\n" +
                                "Michael Mc Cormack, " + at0013_3ck_michael_mccormack + ", " +
                                "\n" +
                                "David Mc Asey, " + at0013_3ck_david_mcasey + ", " +
                                "\n" +
                                "Eamonn Storey, " + at0013_3ck_eamonn_storey + ", " +
                                "\n" +
                                "Thomas Martin, " + at0013_3ck_thomas_martin + ", " +
                                "\n" +
                                "Richard Gilligan, " + at0013_3ck_richard_gilligan + ", " +
                                "\n" +
                                "Noel Perry, " + at0013_3ck_noel_perry + ", " +
                                "\n" +
                                "Willie Harris, " + at0013_3ck_willie_harris + ", " +
                                "\n" +
                                "Kieran Fitzgerald, " + at0013_3ck_kieran_fitzgerald + ", " +
                                "\n" +
                                "Mark Dalton, " + at0013_3ck_mark_dalton + ", " +
                                "\n" +
                                "William Burke, " + at0013_3ck_william_burke + ", " +
                                "\n" +
                                "Martin Maher, " + at0013_3ck_martin_maher + ", " +
                                "\n" +
                                "Graham Mc Loghlin, " + at0013_3ck_graham_mcloghlin + ", " +
                                "\n" +
                                "Christy O'Reilly, " + at0013_3ck_christy_oreilly + ", " +
                                "\n" +
                                "Ritchie Kavanagh, " + at0013_3ck_ritchie_kavanagh + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  Nature of Works  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "River Cleaning, " + at0013_3ck_river_cleaning + ", " +
                                "\n" +
                                "Debris Removal, " + at0013_3ck_debris_removal + ", " +
                                "\n" +
                                "Screen Cleaning, " + at0013_3ck_screen_cleaning + ", " +
                                "\n" +
                                "Tree Cutting, " + at0013_3ck_tree_cutting + ", " +
                                "\n" +
                                "Weir Maintenance, " + at0013_3ck_weir_maintenance + ", " +
                                "\n" +
                                "River Dredging, " + at0013_3ck_river_dredging + ", " +
                                "\n" +
                                "Nature Works other, " + at0013_3ck_nature_works_other + ", " +
                                "\n" +
                                "Nature Works Comment Box, " + at0013_3ck_nature_works_other_boxstring + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  Personal Trained in Following  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "Safepass, " + at0013_3ck_safepass + ", " +
                                "\n" +
                                "Manual Handling, " + at0013_3ck_manual_handling + ", " +
                                "\n" +
                                "Water Awareness, " + at0013_3ck_water_awareness + ", " +
                                "\n" +
                                "Chainsaw, " + at0013_3ck_chainsaw + ", " +
                                "\n" +
                                "Tirfor Winch, " + at0013_3ck_tirfor_winch + ", " +
                                "\n" +
                                "Confined Space, " + at0013_3ck_confined_space + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  Personal Protective Equipement  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "Safety Footware, " + at0013_3ck_safety_footware + ", " +
                                "\n" +
                                "High Vis Vest, " + at0013_3ck_high_vis_vest + ", " +
                                "\n" +
                                "Gloves, " + at0013_3ck_gloves + ", " +
                                "\n" +
                                "Safety Helmet, " + at0013_3ck_safety_helmet + ", " +
                                "\n" +
                                "Ear Protection, " + at0013_3ck_ear_protection + ", " +
                                "\n" +
                                "Eye Protection, " + at0013_3ck_eye_protection + ", " +
                                "\n" +
                                "Life Jacket, " + at0013_3ck_life_jacket + ", " +
                                "\n" +
                                "Chainsaw Suit, " + at0013_3ck_chainsaw_suit + ", " +
                                "\n" +
                                "Waders, " + at0013_3ck_waders + ", " +
                                "\n" +
                                "Throw bags, " + at0013_3ck_throw_bags + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  Hazard :- Working at height  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "Life Line, " + at0013_3ck_life_line + ", " +
                                "\n" +
                                "life Jacket, " + at0013_3ck_hazard_life_jacket + ", " +
                                "\n" +
                                "Throw Bags, " + at0013_3ck_hazard_throw_bags + ", " +
                                "\n" +
                                "Hazard N/A, " + at0013_3ck_hazard_na + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  Hazard :- Working at Steep River/Slippy Banks  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "Life Line/Harrness, " + at0013_3ck_river_bank_life_line + ", " +
                                "\n" +
                                "River bank Landers, " + at0013_3ck_river_bank_laddders + ", " +
                                "\n" +
                                "River Safety Boots, " + at0013_3ck_river_bank_safety_footware + ", " +
                                "\n" +
                                "Rivverbank N/A, " + at0013_3ck_river_bank_na + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  Hazard :- Work Area Barriered off?  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "Barrier Required, " + at0013_3ck_hazard_yes + ", " +
                                "\n" +
                                "No Barrier Required, " + at0013_3ck_hazard_no + ", " +
                                "\n" +
                                "Barrier N/A, " + at0013_3ck_barrier_na + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  Hazard :- Hogweed Encountered?  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "Hogweed Avoid, " + at0013_3ck_hazard_hog_avoid + ", " +
                                "\n" +
                                "Hogweed PPE, " + at0013_3ck_hazard_hog_ppe + ", " +
                                "\n" +
                                "Hogweed N/A, " + at0013_3ck_hazard_hog_na + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  Adequate Hygiene procedures followed?  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "Hygiene, " + at0013_3ck_hazard_hygine_ppe + ", " +
                                "\n" +
                                "Washing Facilities on-site, " + at0013_3ck_hazard_washing_facilities + ", " +
                                "\n" +
                                "Canteen Facilities, " + at0013_3ck_hazard_canteen + ", " +
                                "\n" +
                                "Cleaning Tools, " + at0013_3ck_hazard_clean_tools + ", " +
                                "\n" +
                                "Sharp Prevention Pack, " + at0013_3ck_hazard_sharp_prevention_pack + ", " +
                                "\n" +
                                "Hazard Hygiene N/A, " + at0013_3ck_hazard_hygiene_na + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  Working with/close to live Traffic  <<<<<<<" +
                                "\n" +
                                "\n" + ", " + "Yes/No" +
                                "\n" +
                                "\n" +
                                "Traffic Plan required?, " + at0013_3ck_hazard_tmp_number + ", " +
                                "\n" +
                                "Traffic Plan Number, " + at0013_3ck_hazard_tmp_commentsstring + ", " +
                                "\n" +
                                "Traffic Plan N/A, " + at0013_3ck_hazard_tmp_na + ", " +
                                "\n" +
                                "\n" +
                                ">>>>>>>  End of Report  <<<<<<<" +
                                "\n" +
                                "\n" +
                                ">>>>>>>  Thank you for using DCC App  <<<<<<<" +
                                ", " ;








                File outputDir = getApplicationContext().getExternalCacheDir();

                ScrollView u = (ScrollView) findViewById(R.id.scrollviewat0013_3_report);
                Bitmap screen = Bitmap.createBitmap(u.getChildAt(0).getWidth(), u.getChildAt(0).getHeight(),  Bitmap.Config.ARGB_8888);

                Canvas canvas = new Canvas(screen);
                Drawable bgDrawable = u.getBackground();
                if (bgDrawable != null)
                    bgDrawable.draw(canvas);
                else
                    canvas.drawColor(Color.WHITE);
                u.draw(canvas);

                File pdfFile = new File(outputDir, "AT0013_3" + startDatestring + ".pdf");

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
                    intent.putExtra(Intent.EXTRA_SUBJECT, ("DCC AT0013_3 Form :- " + startDatestring + " Submitted by " + user_namestring));
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
        AT_RiskAssessment_database.getInstance().getmDatabase().child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT RiskAssessment Form").child(clickedKey).addListenerForSingleValueEvent(
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
                        ///////////////////////////////////////Store Strings/////////////////////////////////////////////////

                        ///////////////////////////////////////1 Section 1 Location/////////////////////////////////////////////////

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }
}