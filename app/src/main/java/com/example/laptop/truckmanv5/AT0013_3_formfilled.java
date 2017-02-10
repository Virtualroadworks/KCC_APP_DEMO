package com.example.laptop.truckmanv5;

import android.app.FragmentManager;
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

public class AT0013_3_formfilled extends AppCompatActivity {

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



    LinearLayout at0013_3ck_hazard_tmp_number_box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at0013_3_formfilled);


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
        searchAT0013_3_model(position);

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
                    intent.putExtra(Intent.EXTRA_SUBJECT, ("DCC Inspections Form :- " + startDatestring + " Submitted by " + user_namestring));
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



    public void searchAT0013_3_model(int position) {
        String clickedKey = AT0013_3_database.getInstance().getKeysArray().get(position);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        AT0013_3_database.getInstance().getmDatabase().child("users").child(firebaseAuth.getCurrentUser().getUid()).child("AT General Inspections Form").child(clickedKey).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        AT0013_3_model personDetailsModel = dataSnapshot.getValue(AT0013_3_model.class);
                        user_name.setText(personDetailsModel.getuser_name());
                        user_email.setText(personDetailsModel.getuser_email());
                        user_department_area.setText(personDetailsModel.getuser_department_area());
                        user_contact_number.setText(personDetailsModel.getuser_contact_number());
                        endDate.setText(personDetailsModel.getendDate());
                        startDate.setText(personDetailsModel.getstartDate());
                        ///////////////////////////////////////Store Strings/////////////////////////////////////////////////
                        at0013_3pictureuri = personDetailsModel.getat0013_3pictureuri();

                        Picasso.with(AT0013_3_formfilled.this).load(at0013_3pictureuri).resize(300,300).centerCrop().into(at0013_3pictureuripicplace);

                        ///////////////////////////////////////1 Section 1 Location/////////////////////////////////////////////////


                        at0013_3ck_tony_robinson = personDetailsModel.getat0013_3ck_tony_robinson();
                        CheckBox tonyRobinson = (CheckBox) findViewById(R.id.at0013_3ck_tony_robinson);

                        if (at0013_3ck_tony_robinson.equals("Yes")) {

                            tonyRobinson.setChecked(true);
                        }
                        else {
                            tonyRobinson.setChecked(false);
                            at0013_3ck_tony_robinson_layout.setVisibility(LinearLayout.GONE);
                        }

                        at0013_3ck_mark_dixon = personDetailsModel.getat0013_3ck_mark_dixon();
                        CheckBox mark_dixon = (CheckBox) findViewById(R.id.at0013_3ck_mark_dixon);

                        if (at0013_3ck_mark_dixon.equals("Yes")) {
                            mark_dixon.setChecked(true);
                        }
                        else {
                            mark_dixon.setChecked(false);
                            at0013_3ck_mark_dixon_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_brian_byrne = personDetailsModel.getat0013_3ck_brian_byrne();
                        CheckBox brian_byrne = (CheckBox) findViewById(R.id.at0013_3ck_brian_byrne);

                        if (at0013_3ck_brian_byrne.equals("Yes")) {
                            brian_byrne.setChecked(true);
                        }
                        else {
                            brian_byrne.setChecked(false);
                            at0013_3ck_brian_byrne_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_declan_byrne = personDetailsModel.getat0013_3ck_declan_byrne();
                        CheckBox declan_byrne = (CheckBox) findViewById(R.id.at0013_3ck_declan_byrne);

                        if (at0013_3ck_declan_byrne.equals("Yes")) {
                            declan_byrne.setChecked(true);
                        }
                        else {
                            declan_byrne.setChecked(false);
                            at0013_3ck_declan_byrne_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_michael_mccormack = personDetailsModel.getat0013_3ck_michael_mccormack();
                        CheckBox michael_mccormack = (CheckBox) findViewById(R.id.at0013_3ck_michael_mccormack);

                        if (at0013_3ck_michael_mccormack.equals("Yes")) {
                            michael_mccormack.setChecked(true);
                        }
                        else {
                            michael_mccormack.setChecked(false);
                            at0013_3ck_michael_mccormack_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_david_mcasey = personDetailsModel.getat0013_3ck_david_mcasey();
                        CheckBox david_mcasey = (CheckBox) findViewById(R.id.at0013_3ck_david_mcasey);

                        if (at0013_3ck_david_mcasey.equals("Yes")) {
                            david_mcasey.setChecked(true);
                        }
                        else {
                            david_mcasey.setChecked(false);
                            at0013_3ck_david_mcasey_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_eamonn_storey = personDetailsModel.getat0013_3ck_eamonn_storey();
                        CheckBox eamonn_storey = (CheckBox) findViewById(R.id.at0013_3ck_eamonn_storey);

                        if (at0013_3ck_eamonn_storey.equals("Yes")) {
                            eamonn_storey.setChecked(true);
                        }
                        else {
                            eamonn_storey.setChecked(false);
                            at0013_3ck_eamonn_storey_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_thomas_martin = personDetailsModel.getat0013_3ck_thomas_martin();
                        CheckBox thomas_martin = (CheckBox) findViewById(R.id.at0013_3ck_thomas_martin);

                        if (at0013_3ck_thomas_martin.equals("Yes")) {
                            thomas_martin.setChecked(true);
                        }
                        else {

                            thomas_martin.setChecked(false);
                            at0013_3ck_thomas_martin_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_richard_gilligan = personDetailsModel.getat0013_3ck_richard_gilligan();
                        CheckBox richard_gilligan = (CheckBox) findViewById(R.id.at0013_3ck_richard_gilligan);

                        if (at0013_3ck_richard_gilligan.equals("Yes")) {
                            richard_gilligan.setChecked(true);
                        }
                        else {
                            richard_gilligan.setChecked(false);
                            at0013_3ck_richard_gilligan_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_noel_perry = personDetailsModel.getat0013_3ck_noel_perry();
                        CheckBox noel_perry = (CheckBox) findViewById(R.id.at0013_3ck_noel_perry);

                        if (at0013_3ck_noel_perry.equals("Yes")) {
                            noel_perry.setChecked(true);
                        }
                        else {
                            noel_perry.setChecked(false);
                            at0013_3ck_noel_perry_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_willie_harris = personDetailsModel.getat0013_3ck_willie_harris();
                        CheckBox willie_harris = (CheckBox) findViewById(R.id.at0013_3ck_willie_harris);

                        if (at0013_3ck_willie_harris.equals("Yes")) {
                            willie_harris.setChecked(true);
                        }
                        else {
                            willie_harris.setChecked(false);
                            at0013_3ck_willie_harris_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_kieran_fitzgerald = personDetailsModel.getat0013_3ck_kieran_fitzgerald();
                        CheckBox kieran_fitzgerald = (CheckBox) findViewById(R.id.at0013_3ck_kieran_fitzgerald);

                        if (at0013_3ck_kieran_fitzgerald.equals("Yes")) {
                            kieran_fitzgerald.setChecked(true);
                        }
                        else {
                            kieran_fitzgerald.setChecked(false);
                            at0013_3ck_kieran_fitzgerald_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_mark_dalton = personDetailsModel.getat0013_3ck_mark_dalton();
                        CheckBox mark_dalton = (CheckBox) findViewById(R.id.at0013_3ck_mark_dalton);

                        if (at0013_3ck_mark_dalton.equals("Yes")) {
                            mark_dalton.setChecked(true);
                        }
                        else {
                            mark_dalton.setChecked(false);
                            at0013_3ck_mark_dalton_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_william_burke = personDetailsModel.getat0013_3ck_william_burke();
                        CheckBox william_burke = (CheckBox) findViewById(R.id.at0013_3ck_william_burke);

                        if (at0013_3ck_william_burke.equals("Yes")) {
                            william_burke.setChecked(true);
                        }
                        else {
                            william_burke.setChecked(false);
                            at0013_3ck_william_burke_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_martin_maher = personDetailsModel.getat0013_3ck_martin_maher();
                        CheckBox martin_maher = (CheckBox) findViewById(R.id.at0013_3ck_martin_maher);

                        if (at0013_3ck_martin_maher.equals("Yes")) {
                            martin_maher.setChecked(true);
                        }
                        else {
                            martin_maher.setChecked(false);
                            at0013_3ck_martin_maher_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_graham_mcloghlin = personDetailsModel.getat0013_3ck_graham_mcloghlin();
                        CheckBox graham_mcloghlin = (CheckBox) findViewById(R.id.at0013_3ck_graham_mcloghlin);

                        if (at0013_3ck_graham_mcloghlin.equals("Yes")) {
                            graham_mcloghlin.setChecked(true);
                        }
                        else {
                            graham_mcloghlin.setChecked(false);
                            at0013_3ck_graham_mcloghlin_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_christy_oreilly = personDetailsModel.getat0013_3ck_christy_oreilly();
                        CheckBox christy_oreilly = (CheckBox) findViewById(R.id.at0013_3ck_christy_oreilly);

                        if (at0013_3ck_christy_oreilly.equals("Yes")) {
                            christy_oreilly.setChecked(true);
                        }
                        else {
                            christy_oreilly.setChecked(false);
                            at0013_3ck_christy_oreilly_layout.setVisibility(LinearLayout.GONE);
                        }
                        at0013_3ck_ritchie_kavanagh = personDetailsModel.getat0013_3ck_ritchie_kavanagh();
                        CheckBox ritchie_kavanagh = (CheckBox) findViewById(R.id.at0013_3ck_ritchie_kavanagh);

                        if (at0013_3ck_ritchie_kavanagh.equals("Yes")) {
                            ritchie_kavanagh.setChecked(true);
                        }
                        else {
                            ritchie_kavanagh.setChecked(false);
                            at0013_3ck_ritchie_kavanagh_layout.setVisibility(LinearLayout.GONE);
                        }

                        ///////////////////////////////////////2 Section 1 Nature of Works/////////////////////////////////////////////////

                        at0013_3ck_river_cleaning = personDetailsModel.getat0013_3ck_river_cleaning();
                        CheckBox river_cleaning = (CheckBox) findViewById(R.id.at0013_3ck_river_cleaning);

                        if (at0013_3ck_river_cleaning.equals("Yes")) {
                            river_cleaning.setChecked(true);
                        }
                        else {
                            river_cleaning.setChecked(false);
                        }
                        at0013_3ck_debris_removal = personDetailsModel.getat0013_3ck_debris_removal();
                        CheckBox debris_removal = (CheckBox) findViewById(R.id.at0013_3ck_debris_removal);

                        if (at0013_3ck_debris_removal.equals("Yes")) {
                            debris_removal.setChecked(true);
                        }
                        else {
                            debris_removal.setChecked(false);
                        }
                        at0013_3ck_screen_cleaning = personDetailsModel.getat0013_3ck_screen_cleaning();
                        CheckBox screen_cleaning = (CheckBox) findViewById(R.id.at0013_3ck_screen_cleaning);

                        if (at0013_3ck_screen_cleaning.equals("Yes")) {
                            screen_cleaning.setChecked(true);
                        }
                        else {
                            screen_cleaning.setChecked(false);
                        }
                        at0013_3ck_tree_cutting = personDetailsModel.getat0013_3ck_tree_cutting();
                        CheckBox tree_cutting = (CheckBox) findViewById(R.id.at0013_3ck_tree_cutting);

                        if (at0013_3ck_tree_cutting.equals("Yes")) {
                            tree_cutting.setChecked(true);
                        }
                        else {
                            tree_cutting.setChecked(false);
                        }
                        at0013_3ck_weir_maintenance = personDetailsModel.getat0013_3ck_weir_maintenance();
                        CheckBox weir_maintenance = (CheckBox) findViewById(R.id.at0013_3ck_weir_maintenance);

                        if (at0013_3ck_weir_maintenance.equals("Yes")) {
                            weir_maintenance.setChecked(true);
                        }
                        else {
                            weir_maintenance.setChecked(false);
                        }
                        at0013_3ck_river_dredging = personDetailsModel.getat0013_3ck_river_dredging();
                        CheckBox river_dredging = (CheckBox) findViewById(R.id.at0013_3ck_river_dredging);

                        if (at0013_3ck_river_dredging.equals("Yes")) {
                            river_dredging.setChecked(true);
                        }
                        else {
                            river_dredging.setChecked(false);
                        }
                        at0013_3ck_nature_works_other = personDetailsModel.getat0013_3ck_nature_works_other();
                        CheckBox nature_works_other = (CheckBox) findViewById(R.id.at0013_3ck_nature_works_other);

                        if (at0013_3ck_nature_works_other.equals("Yes")) {
                            at0013_3ck_nature_works_other_box = (TextView) findViewById(R.id.at0013_3ck_nature_works_other_box);
                            at0013_3ck_nature_works_other_box.setText(personDetailsModel.getat0013_3ck_nature_works_other_description());
                            nature_works_other.setChecked(true);
                        }
                        else {
                            nature_works_other.setChecked(false);
                            at0013_3ck_nature_works_commentsbox.setVisibility(LinearLayout.GONE);
                        }




                        ///////////////////////////////////////2 Section 2 Are personnel trained/////////////////////////////////////////////////

                        at0013_3ck_safepass = personDetailsModel.getat0013_3ck_safepass();
                        CheckBox safepass = (CheckBox) findViewById(R.id.at0013_3ck_safepass);

                        if (at0013_3ck_safepass.equals("Yes")) {
                            safepass.setChecked(true);
                        }
                        else {
                            safepass.setChecked(false);
                        }
                        at0013_3ck_manual_handling = personDetailsModel.getat0013_3ck_manual_handling();
                        CheckBox manual_handling = (CheckBox) findViewById(R.id.at0013_3ck_manual_handling);

                        if (at0013_3ck_manual_handling.equals("Yes")) {
                            manual_handling.setChecked(true);
                        }
                        else {
                            manual_handling.setChecked(false);
                        }
                        at0013_3ck_water_awareness = personDetailsModel.getat0013_3ck_water_awareness();
                        CheckBox water_awareness = (CheckBox) findViewById(R.id.at0013_3ck_water_awareness);

                        if (at0013_3ck_water_awareness.equals("Yes")) {
                            water_awareness.setChecked(true);
                        }
                        else {
                            water_awareness.setChecked(false);
                        }
                        at0013_3ck_chainsaw = personDetailsModel.getat0013_3ck_chainsaw();
                        CheckBox chainsaw = (CheckBox) findViewById(R.id.at0013_3ck_chainsaw);

                        if (at0013_3ck_chainsaw.equals("Yes")) {
                            chainsaw.setChecked(true);
                        }
                        else {
                            chainsaw.setChecked(false);
                        }
                        at0013_3ck_tirfor_winch = personDetailsModel.getat0013_3ck_tirfor_winch();
                        CheckBox tirfor_winch = (CheckBox) findViewById(R.id.at0013_3ck_tirfor_winch);

                        if (at0013_3ck_tirfor_winch.equals("Yes")) {
                            tirfor_winch.setChecked(true);
                        }
                        else {
                            tirfor_winch.setChecked(false);
                        }
                        at0013_3ck_confined_space = personDetailsModel.getat0013_3ck_confined_space();
                        CheckBox confined_space = (CheckBox) findViewById(R.id.at0013_3ck_confined_space);

                        if (at0013_3ck_confined_space.equals("Yes")) {
                            confined_space.setChecked(true);
                        }
                        else {
                            confined_space.setChecked(false);
                        }
                        ///////////////////////////////////////2 Section 3 Personal Protective Equipement Required/////////////////////////////////////////////////

                        at0013_3ck_safety_footware = personDetailsModel.getat0013_3ck_safety_footware();
                        CheckBox safety_footware = (CheckBox) findViewById(R.id.at0013_3ck_safety_footware);

                        if (at0013_3ck_safety_footware.equals("Yes")) {
                            safety_footware.setChecked(true);
                        }
                        else {
                            safety_footware.setChecked(false);
                        }
                        at0013_3ck_high_vis_vest = personDetailsModel.getat0013_3ck_high_vis_vest();
                        CheckBox high_vis_vest = (CheckBox) findViewById(R.id.at0013_3ck_high_vis_vest);

                        if (at0013_3ck_high_vis_vest.equals("Yes")) {
                            high_vis_vest.setChecked(true);
                        }
                        else {
                            high_vis_vest.setChecked(false);
                        }
                        at0013_3ck_gloves = personDetailsModel.getat0013_3ck_gloves();
                        CheckBox gloves = (CheckBox) findViewById(R.id.at0013_3ck_gloves);

                        if (at0013_3ck_gloves.equals("Yes")) {
                            gloves.setChecked(true);
                        }
                        else {
                            gloves.setChecked(false);
                        }
                        at0013_3ck_safety_helmet = personDetailsModel.getat0013_3ck_safety_helmet();
                        CheckBox safety_helmet = (CheckBox) findViewById(R.id.at0013_3ck_safety_helmet);

                        if (at0013_3ck_safety_helmet.equals("Yes")) {
                            safety_helmet.setChecked(true);
                        }
                        else {
                            safety_helmet.setChecked(false);
                        }
                        at0013_3ck_ear_protection = personDetailsModel.getat0013_3ck_ear_protection();
                        CheckBox ear_protection = (CheckBox) findViewById(R.id.at0013_3ck_ear_protection);

                        if (at0013_3ck_ear_protection.equals("Yes")) {
                            ear_protection.setChecked(true);
                        }
                        else {
                            ear_protection.setChecked(false);
                        }
                        at0013_3ck_eye_protection = personDetailsModel.getat0013_3ck_eye_protection();
                        CheckBox eye_protection = (CheckBox) findViewById(R.id.at0013_3ck_eye_protection);

                        if (at0013_3ck_eye_protection.equals("Yes")) {
                            eye_protection.setChecked(true);
                        }
                        else {
                            eye_protection.setChecked(false);
                        }
                        at0013_3ck_life_jacket = personDetailsModel.getat0013_3ck_life_jacket();
                        CheckBox life_jacket = (CheckBox) findViewById(R.id.at0013_3ck_life_jacket);

                        if (at0013_3ck_life_jacket.equals("Yes")) {
                            life_jacket.setChecked(true);
                        }
                        else {
                            life_jacket.setChecked(false);
                        }
                        at0013_3ck_chainsaw_suit = personDetailsModel.getat0013_3ck_chainsaw_suit();
                        CheckBox chainsaw_suit = (CheckBox) findViewById(R.id.at0013_3ck_chainsaw_suit);

                        if (at0013_3ck_chainsaw_suit.equals("Yes")) {
                            chainsaw_suit.setChecked(true);
                        }
                        else {
                            chainsaw_suit.setChecked(false);
                        }
                        at0013_3ck_waders = personDetailsModel.getat0013_3ck_waders();
                        CheckBox waders = (CheckBox) findViewById(R.id.at0013_3ck_waders);

                        if (at0013_3ck_waders.equals("Yes")) {
                            waders.setChecked(true);
                        }
                        else {
                            waders.setChecked(false);
                        }
                        at0013_3ck_throw_bags = personDetailsModel.getat0013_3ck_throw_bags();
                        CheckBox throw_bags = (CheckBox) findViewById(R.id.at0013_3ck_throw_bags);

                        if (at0013_3ck_throw_bags.equals("Yes")) {
                            throw_bags.setChecked(true);
                        }
                        else {
                            throw_bags.setChecked(false);
                        }
                        ///////////////////////////////////////3 Section 1 Hazard and Controls/////////////////////////////////////////////////
                        at0013_3ck_life_line = personDetailsModel.getat0013_3ck_life_line();
                        CheckBox life_line = (CheckBox) findViewById(R.id.at0013_3ck_life_line);

                        if (at0013_3ck_life_line.equals("Yes")) {
                            life_line.setChecked(true);
                        }
                        else {
                            life_line.setChecked(false);
                        }
                        at0013_3ck_hazard_life_jacket = personDetailsModel.getat0013_3ck_hazard_life_jacket();
                        CheckBox hazard_life_jacket = (CheckBox) findViewById(R.id.at0013_3ck_hazard_life_jacket);

                        if (at0013_3ck_hazard_life_jacket.equals("Yes")) {
                            hazard_life_jacket.setChecked(true);
                        }
                        else {
                            hazard_life_jacket.setChecked(false);
                        }
                        at0013_3ck_hazard_throw_bags = personDetailsModel.getat0013_3ck_hazard_throw_bags();
                        CheckBox hazard_throw_bags = (CheckBox) findViewById(R.id.at0013_3ck_hazard_throw_bags);

                        if (at0013_3ck_hazard_throw_bags.equals("Yes")) {
                            hazard_throw_bags.setChecked(true);
                        }
                        else {
                            hazard_throw_bags.setChecked(false);
                        }
                        at0013_3ck_hazard_na = personDetailsModel.getat0013_3ck_hazard_na();
                        CheckBox hazard_na = (CheckBox) findViewById(R.id.at0013_3ck_hazard_na);

                        if (at0013_3ck_hazard_na.equals("Yes")) {
                            hazard_na.setChecked(true);
                        }
                        else {
                            hazard_na.setChecked(false);
                        }
                        at0013_3ck_river_bank_life_line = personDetailsModel.getat0013_3ck_river_bank_life_line();
                        CheckBox river_bank_life_line = (CheckBox) findViewById(R.id.at0013_3ck_river_bank_life_line);

                        if (at0013_3ck_river_bank_life_line.equals("Yes")) {
                            river_bank_life_line.setChecked(true);
                        }
                        else {
                            river_bank_life_line.setChecked(false);
                        }

                        at0013_3ck_river_bank_laddders = personDetailsModel.getat0013_3ck_river_bank_laddders();
                        CheckBox river_bank_laddders = (CheckBox) findViewById(R.id.at0013_3ck_river_bank_laddders);

                        if (at0013_3ck_river_bank_laddders.equals("Yes")) {
                            river_bank_laddders.setChecked(true);
                        }
                        else {
                            river_bank_laddders.setChecked(false);
                        }
                        at0013_3ck_river_bank_safety_footware = personDetailsModel.getat0013_3ck_river_bank_safety_footware();
                        CheckBox river_bank_safety_footware = (CheckBox) findViewById(R.id.at0013_3ck_river_bank_safety_footware);

                        if (at0013_3ck_river_bank_safety_footware.equals("Yes")) {
                            river_bank_safety_footware.setChecked(true);
                        }
                        else {
                            river_bank_safety_footware.setChecked(false);
                        }
                        at0013_3ck_river_bank_na = personDetailsModel.getat0013_3ck_river_bank_na();
                        CheckBox river_bank_na = (CheckBox) findViewById(R.id.at0013_3ck_river_bank_na);

                        if (at0013_3ck_river_bank_na.equals("Yes")) {
                            river_bank_na.setChecked(true);
                        }
                        else {
                            river_bank_na.setChecked(false);
                        }
                        at0013_3ck_hazard_yes = personDetailsModel.getat0013_3ck_hazard_yes();
                        CheckBox hazard_yes = (CheckBox) findViewById(R.id.at0013_3ck_hazard_yes);

                        if (at0013_3ck_hazard_yes.equals("Yes")) {
                            hazard_yes.setChecked(true);
                        }
                        else {
                            hazard_yes.setChecked(false);
                        }
                        at0013_3ck_hazard_no = personDetailsModel.getat0013_3ck_hazard_no();
                        CheckBox hazard_no = (CheckBox) findViewById(R.id.at0013_3ck_hazard_no);

                        if (at0013_3ck_hazard_no.equals("Yes")) {
                            hazard_no.setChecked(true);
                        }
                        else {
                            hazard_no.setChecked(false);
                        }
                        at0013_3ck_barrier_na = personDetailsModel.getat0013_3ck_barrier_na();
                        CheckBox barrier_na = (CheckBox) findViewById(R.id.at0013_3ck_barrier_na);

                        if (at0013_3ck_barrier_na.equals("Yes")) {
                            barrier_na.setChecked(true);
                        }
                        else {
                            barrier_na.setChecked(false);
                        }
                        at0013_3ck_hazard_hog_avoid = personDetailsModel.getat0013_3ck_hazard_hog_avoid();
                        CheckBox hazard_hog_avoid = (CheckBox) findViewById(R.id.at0013_3ck_hazard_hog_avoid);

                        if (at0013_3ck_hazard_hog_avoid.equals("Yes")) {
                            hazard_hog_avoid.setChecked(true);
                        }
                        else {
                            hazard_hog_avoid.setChecked(false);
                        }
                        at0013_3ck_hazard_hog_ppe = personDetailsModel.getat0013_3ck_hazard_hog_ppe();
                        CheckBox hazard_hog_ppe = (CheckBox) findViewById(R.id.at0013_3ck_hazard_hog_ppe);

                        if (at0013_3ck_hazard_hog_ppe.equals("Yes")) {
                            hazard_hog_ppe.setChecked(true);
                        }
                        else {
                            hazard_hog_ppe.setChecked(false);
                        }
                        at0013_3ck_hazard_hog_na = personDetailsModel.getat0013_3ck_hazard_hog_na();
                        CheckBox hazard_hog_na = (CheckBox) findViewById(R.id.at0013_3ck_hazard_hog_na);

                        if (at0013_3ck_hazard_hog_na.equals("Yes")) {
                            hazard_hog_na.setChecked(true);
                        }
                        else {
                            hazard_hog_na.setChecked(false);
                        }
                        at0013_3ck_hazard_hygine_ppe = personDetailsModel.getat0013_3ck_hazard_hygine_ppe();
                        CheckBox hazard_hygine_ppe = (CheckBox) findViewById(R.id.at0013_3ck_hazard_hygine_ppe);

                        if (at0013_3ck_hazard_hygine_ppe.equals("Yes")) {
                            hazard_hygine_ppe.setChecked(true);
                        }
                        else {
                            hazard_hygine_ppe.setChecked(false);
                        }
                        at0013_3ck_hazard_washing_facilities = personDetailsModel.getat0013_3ck_hazard_washing_facilities();
                        CheckBox hazard_washing_facilities = (CheckBox) findViewById(R.id.at0013_3ck_hazard_washing_facilities);

                        if (at0013_3ck_hazard_washing_facilities.equals("Yes")) {
                            hazard_washing_facilities.setChecked(true);
                        }
                        else {
                            hazard_washing_facilities.setChecked(false);
                        }
                        at0013_3ck_hazard_canteen = personDetailsModel.getat0013_3ck_hazard_canteen();
                        CheckBox hazard_canteen = (CheckBox) findViewById(R.id.at0013_3ck_hazard_canteen);

                        if (at0013_3ck_hazard_canteen.equals("Yes")) {
                            hazard_canteen.setChecked(true);
                        }
                        else {
                            hazard_canteen.setChecked(false);
                        }
                        at0013_3ck_hazard_clean_tools = personDetailsModel.getat0013_3ck_hazard_clean_tools();
                        CheckBox hazard_clean_tools = (CheckBox) findViewById(R.id.at0013_3ck_hazard_clean_tools);

                        if (at0013_3ck_hazard_clean_tools.equals("Yes")) {
                            hazard_clean_tools.setChecked(true);
                        }
                        else {
                            hazard_clean_tools.setChecked(false);
                        }
                        at0013_3ck_hazard_sharp_prevention_pack = personDetailsModel.getat0013_3ck_hazard_sharp_prevention_pack();
                        CheckBox hazard_sharp_prevention_pack = (CheckBox) findViewById(R.id.at0013_3ck_hazard_sharp_prevention_pack);

                        if (at0013_3ck_hazard_sharp_prevention_pack.equals("Yes")) {
                            hazard_sharp_prevention_pack.setChecked(true);
                        }
                        else {
                            hazard_sharp_prevention_pack.setChecked(false);
                        }
                        at0013_3ck_hazard_hygiene_na = personDetailsModel.getat0013_3ck_hazard_hygiene_na();
                        CheckBox hazard_hygiene_na = (CheckBox) findViewById(R.id.at0013_3ck_hazard_hygiene_na);

                        if (at0013_3ck_hazard_hygiene_na.equals("Yes")) {
                            hazard_hygiene_na.setChecked(true);
                        }
                        else {
                            hazard_hygiene_na.setChecked(false);
                        }
                        at0013_3ck_hazard_tmp_number = personDetailsModel.getat0013_3ck_hazard_tmp_number();
                        CheckBox hazard_tmp_number = (CheckBox) findViewById(R.id.at0013_3ck_hazard_tmp_number);

                        if (at0013_3ck_hazard_tmp_number.equals("Yes")) {
                            at0013_3ck_hazard_tmp_comments = (TextView) findViewById(R.id.at0013_3ck_hazard_tmp_comments);
                            at0013_3ck_hazard_tmp_comments.setText(personDetailsModel.getat0013_3ck_hazard_tmp_comments());
                            hazard_tmp_number.setChecked(true);
                        }
                        else {
                            at0013_3ck_hazard_tmp_number_box.setVisibility(LinearLayout.GONE);
                            hazard_tmp_number.setChecked(false);
                        }
                        at0013_3ck_hazard_tmp_na = personDetailsModel.getat0013_3ck_hazard_tmp_na();
                        CheckBox hazard_tmp_na = (CheckBox) findViewById(R.id.at0013_3ck_hazard_tmp_na);

                        if (at0013_3ck_hazard_tmp_na.equals("Yes")) {
                            hazard_tmp_na.setChecked(true);
                        }
                        else {
                            hazard_tmp_na.setChecked(false);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }
}
