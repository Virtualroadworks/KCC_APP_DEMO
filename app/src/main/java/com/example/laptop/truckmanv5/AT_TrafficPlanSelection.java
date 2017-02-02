package com.example.laptop.truckmanv5;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class AT_TrafficPlanSelection extends AppCompatActivity {

    ScrollView scrollView;

    FrameLayout FrameLayoutSheet0_Road_RefertoInspector;

    FrameLayout FrameLayoutSheet0_Reinstatment;
    FrameLayout FrameLayoutSheet0_Reinstatment_minor;
    FrameLayout FrameLayoutSheet0_Reinstatment_Allstop;

    FrameLayout FrameLayoutSheetk_Reinstatment_Questions;

    FrameLayout FrameLayoutSheetk_Reinstatment_Q1;
    FrameLayout FrameLayoutSheetk_Reinstatment_Q2;
    FrameLayout FrameLayoutSheetk_Reinstatment_Q3;
    FrameLayout FrameLayoutSheetk_Reinstatment_Q4;
    FrameLayout FrameLayoutSheetk_Reinstatment_Q5;
    FrameLayout FrameLayoutSheetk_Reinstatment_Yes_Answer;
    FrameLayout FrameLayoutSheetk_Reinstatment_No_Answer;

    CheckBox CKSheet0_Road_Tickbox_No;
    CheckBox CKSheet0_Road_Tickbox_Yes;

    CheckBox CKSheet0_Reinstatment_Tickbox_No;
    CheckBox CKSheet0_Reinstatment_Tickbox_Yes;

    CheckBox CKSheet0_Reinstatment_Tickbox_minor_Yes;
    CheckBox CKSheet0_Reinstatment_Tickbox_minor_No;

    CheckBox CKSheet0_Reinstatment_Tickbox_Allstop_Yes;
    CheckBox CKSheet0_Reinstatment_Tickbox_Allstop_No;

    CheckBox FrameLayoutSheetk_Reinstatment_Q1_No;
    CheckBox FrameLayoutSheetk_Reinstatment_Q1_Yes;
    CheckBox FrameLayoutSheetk_Reinstatment_Q2_No;
    CheckBox FrameLayoutSheetk_Reinstatment_Q2_Yes;
    CheckBox FrameLayoutSheetk_Reinstatment_Q3_No;
    CheckBox FrameLayoutSheetk_Reinstatment_Q3_Yes;
    CheckBox FrameLayoutSheetk_Reinstatment_Q4_No;
    CheckBox FrameLayoutSheetk_Reinstatment_Q4_Yes;
    CheckBox FrameLayoutSheetk_Reinstatment_Q5_No;
    CheckBox FrameLayoutSheetk_Reinstatment_Q5_Yes;






    Boolean FrameLayoutSheet0_Road_RefertoInspectorpressed = false;
    Boolean FrameLayoutSheet0_Reinstatmentpressed = false;
    Boolean FrameLayoutSheet0_Reinstatment_minorpressed = false;
    Boolean FrameLayoutSheet0_Reinstatment_Allstoppressed = false;
    Boolean FrameLayoutSheetk_Reinstatment_Questionspressed = false;

    Boolean FrameLayoutSheetk_Reinstatment_Q1pressed = false;
    Boolean FrameLayoutSheetk_Reinstatment_Q2pressed = false;
    Boolean FrameLayoutSheetk_Reinstatment_Q3pressed = false;
    Boolean FrameLayoutSheetk_Reinstatment_Q4pressed = false;
    Boolean FrameLayoutSheetk_Reinstatment_Q5pressed = false;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at__traffic_plan_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        scrollView = (ScrollView) findViewById(R.id.scrollView);

        CKSheet0_Road_Tickbox_No = (CheckBox) findViewById(R.id.CKSheet0_Road_Tickbox_No);
        CKSheet0_Road_Tickbox_Yes = (CheckBox) findViewById(R.id.CKSheet0_Road_Tickbox_Yes);

        CKSheet0_Reinstatment_Tickbox_Yes = (CheckBox) findViewById(R.id.CKSheet0_Reinstatment_Tickbox_Yes);
        CKSheet0_Reinstatment_Tickbox_No = (CheckBox) findViewById(R.id.CKSheet0_Reinstatment_Tickbox_No);

        CKSheet0_Reinstatment_Tickbox_minor_Yes = (CheckBox) findViewById(R.id.CKSheet0_Reinstatment_Tickbox_minor_Yes);
        CKSheet0_Reinstatment_Tickbox_minor_No = (CheckBox) findViewById(R.id.CKSheet0_Reinstatment_Tickbox_minor_No);

        CKSheet0_Reinstatment_Tickbox_Allstop_Yes = (CheckBox) findViewById(R.id.CKSheet0_Reinstatment_Tickbox_Allstop_Yes);
        CKSheet0_Reinstatment_Tickbox_Allstop_No = (CheckBox) findViewById(R.id.CKSheet0_Reinstatment_Tickbox_Allstop_No);

        FrameLayoutSheetk_Reinstatment_Q1_No = (CheckBox) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q1_No);
        FrameLayoutSheetk_Reinstatment_Q1_Yes = (CheckBox) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q1_Yes);
        FrameLayoutSheetk_Reinstatment_Q2_No = (CheckBox) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q2_No);
        FrameLayoutSheetk_Reinstatment_Q2_Yes = (CheckBox) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q2_Yes);
        FrameLayoutSheetk_Reinstatment_Q3_No = (CheckBox) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q3_No);
        FrameLayoutSheetk_Reinstatment_Q3_Yes = (CheckBox) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q3_Yes);
        FrameLayoutSheetk_Reinstatment_Q4_No = (CheckBox) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q4_No);
        FrameLayoutSheetk_Reinstatment_Q4_Yes = (CheckBox) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q4_Yes);
        FrameLayoutSheetk_Reinstatment_Q5_No = (CheckBox) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q5_No);
        FrameLayoutSheetk_Reinstatment_Q5_Yes = (CheckBox) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q5_Yes);

        FrameLayoutSheet0_Road_RefertoInspector = (FrameLayout) findViewById(R.id.FrameLayoutSheet0_Road_RefertoInspector);
        FrameLayoutSheet0_Reinstatment = (FrameLayout) findViewById(R.id.FrameLayoutSheet0_Reinstatment);
        FrameLayoutSheet0_Reinstatment_minor = (FrameLayout) findViewById(R.id.FrameLayoutSheet0_Reinstatment_minor);
        FrameLayoutSheet0_Reinstatment_Allstop = (FrameLayout) findViewById(R.id.FrameLayoutSheet0_Reinstatment_Allstop);

        FrameLayoutSheetk_Reinstatment_Questions = (FrameLayout) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Questions);
        FrameLayoutSheetk_Reinstatment_Q1 = (FrameLayout) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q1);
        FrameLayoutSheetk_Reinstatment_Q2 = (FrameLayout) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q2);
        FrameLayoutSheetk_Reinstatment_Q3 = (FrameLayout) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q3);
        FrameLayoutSheetk_Reinstatment_Q4 = (FrameLayout) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q4);
        FrameLayoutSheetk_Reinstatment_Q5 = (FrameLayout) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Q5);
        FrameLayoutSheetk_Reinstatment_Yes_Answer = (FrameLayout) findViewById(R.id.FrameLayoutSheetk_Reinstatment_Yes_Answer);
        FrameLayoutSheetk_Reinstatment_No_Answer = (FrameLayout) findViewById(R.id.FrameLayoutSheetk_Reinstatment_No_Answer);




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// FrameLayoutSheet0_Road /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        FrameLayoutSheet0_Road_RefertoInspector.setVisibility(LinearLayout.GONE);
        FrameLayoutSheet0_Reinstatment.setVisibility(LinearLayout.GONE);
        FrameLayoutSheet0_Reinstatment_minor.setVisibility(LinearLayout.GONE);
        FrameLayoutSheet0_Reinstatment_Allstop.setVisibility(LinearLayout.GONE);
        FrameLayoutSheetk_Reinstatment_Questions.setVisibility(LinearLayout.GONE);

        CKSheet0_Road_Tickbox_Yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CKSheet0_Road_Tickbox_Yes.isChecked()) {
                    if (FrameLayoutSheet0_Road_RefertoInspectorpressed == false) ;
                    {
                        FrameLayoutSheet0_Road_RefertoInspector.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheet0_Reinstatment_minor.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheet0_Reinstatment_Allstop.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheetk_Reinstatment_Questions.setVisibility(LinearLayout.GONE);
                        CKSheet0_Road_Tickbox_No.setChecked(false);
                    }
                } else {
                    FrameLayoutSheet0_Road_RefertoInspector.setVisibility(LinearLayout.GONE);
                    CKSheet0_Road_Tickbox_No.setChecked(false);
                    CKSheet0_Reinstatment_Tickbox_No.setChecked(false);
                    CKSheet0_Reinstatment_Tickbox_Yes.setChecked(false);
                }
            }

        });

        CKSheet0_Road_Tickbox_No.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CKSheet0_Road_Tickbox_No.isChecked()) {
                    {
                        if (FrameLayoutSheet0_Reinstatmentpressed == false) ;
                        FrameLayoutSheet0_Road_RefertoInspector.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheet0_Reinstatment.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment_minor.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheet0_Reinstatment_Allstop.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheetk_Reinstatment_Questions.setVisibility(LinearLayout.GONE);
                        CKSheet0_Road_Tickbox_Yes.setChecked(false);
                    }
                } else {
                    FrameLayoutSheet0_Reinstatment.setVisibility(LinearLayout.GONE);
                    CKSheet0_Road_Tickbox_Yes.setChecked(false);
                    CKSheet0_Reinstatment_Tickbox_No.setChecked(false);
                    CKSheet0_Reinstatment_Tickbox_Yes.setChecked(false);
                }
            }

        });

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// FrameLayoutSheet0_Road /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        CKSheet0_Reinstatment_Tickbox_Yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CKSheet0_Reinstatment_Tickbox_Yes.isChecked()) {
                    {
                        if (FrameLayoutSheet0_Reinstatmentpressed == false) ;
                        FrameLayoutSheet0_Road_RefertoInspector.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheet0_Reinstatment.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment_minor.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment_Allstop.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheetk_Reinstatment_Questions.setVisibility(LinearLayout.GONE);
                        CKSheet0_Reinstatment_Tickbox_No.setChecked(false);
                        

                }
                } else {
                    FrameLayoutSheet0_Reinstatment_minor.setVisibility(LinearLayout.GONE);
                    CKSheet0_Reinstatment_Tickbox_No.setChecked(false);
                    CKSheet0_Reinstatment_Tickbox_minor_No.setChecked(false);
                    CKSheet0_Reinstatment_Tickbox_minor_Yes.setChecked(false);

                }
            }


        });

        CKSheet0_Reinstatment_Tickbox_No.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CKSheet0_Reinstatment_Tickbox_No.isChecked()) {
                    {
                        if (FrameLayoutSheet0_Reinstatmentpressed == false) ;
                        FrameLayoutSheet0_Road_RefertoInspector.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheet0_Reinstatment.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment_minor.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheet0_Reinstatment_Allstop.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheetk_Reinstatment_Questions.setVisibility(LinearLayout.GONE);
                        CKSheet0_Reinstatment_Tickbox_Yes.setChecked(false);

                    }
                } else {
                    FrameLayoutSheet0_Reinstatment_minor.setVisibility(LinearLayout.GONE);
                    CKSheet0_Reinstatment_Tickbox_Yes.setChecked(false);
                    CKSheet0_Reinstatment_Tickbox_minor_No.setChecked(false);
                    CKSheet0_Reinstatment_Tickbox_minor_Yes.setChecked(false);
                }
            }

        });

        CKSheet0_Reinstatment_Tickbox_minor_Yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CKSheet0_Reinstatment_Tickbox_minor_Yes.isChecked()) {
                    {
                        if (FrameLayoutSheet0_Reinstatment_minorpressed == false) ;
                        FrameLayoutSheet0_Road_RefertoInspector.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheet0_Reinstatment.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment_minor.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment_Allstop.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheetk_Reinstatment_Questions.setVisibility(LinearLayout.GONE);
                        CKSheet0_Reinstatment_Tickbox_minor_No.setChecked(false);

                    }
                } else {
                    CKSheet0_Reinstatment_Tickbox_minor_No.setChecked(false);
                }
            }


        });

        CKSheet0_Reinstatment_Tickbox_minor_No.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CKSheet0_Reinstatment_Tickbox_minor_No.isChecked()) {
                    {
                        if (FrameLayoutSheet0_Reinstatment_minorpressed == false) ;
                        FrameLayoutSheet0_Road_RefertoInspector.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheet0_Reinstatment.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment_minor.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment_Allstop.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheetk_Reinstatment_Questions.setVisibility(LinearLayout.GONE);
                        CKSheet0_Reinstatment_Tickbox_minor_Yes.setChecked(false);

                    }
                } else {
                    FrameLayoutSheet0_Reinstatment_Allstop.setVisibility(LinearLayout.GONE);
                    CKSheet0_Reinstatment_Tickbox_minor_Yes.setChecked(false);
                }
            }

        });

        CKSheet0_Reinstatment_Tickbox_Allstop_Yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CKSheet0_Reinstatment_Tickbox_Allstop_Yes.isChecked()) {
                    {
                        if (FrameLayoutSheet0_Reinstatment_Allstoppressed == false) ;
                        FrameLayoutSheet0_Road_RefertoInspector.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheet0_Reinstatment.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment_minor.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment_Allstop.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheetk_Reinstatment_Questions.setVisibility(LinearLayout.VISIBLE);
                        CKSheet0_Reinstatment_Tickbox_Allstop_No.setChecked(false);
                    }
                } else {
                    FrameLayoutSheetk_Reinstatment_Questions.setVisibility(LinearLayout.GONE);
                    CKSheet0_Reinstatment_Tickbox_Allstop_No.setChecked(false);
                }
            }


        });

        CKSheet0_Reinstatment_Tickbox_Allstop_No.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (CKSheet0_Reinstatment_Tickbox_Allstop_No.isChecked()) {
                    {
                        if (FrameLayoutSheet0_Reinstatment_Allstoppressed == false) ;
                        FrameLayoutSheet0_Road_RefertoInspector.setVisibility(LinearLayout.GONE);
                        FrameLayoutSheet0_Reinstatment.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment_minor.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheet0_Reinstatment_Allstop.setVisibility(LinearLayout.VISIBLE);
                        FrameLayoutSheetk_Reinstatment_Questions.setVisibility(LinearLayout.GONE);
                        CKSheet0_Reinstatment_Tickbox_Allstop_Yes.setChecked(false);
                    }
                } else {
                    FrameLayoutSheetk_Reinstatment_Questions.setVisibility(LinearLayout.GONE);
                    CKSheet0_Reinstatment_Tickbox_Allstop_Yes.setChecked(false);
                }
            }

        });

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// FrameLayoutSheet0_Road /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// FrameLayoutSheet K /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        FrameLayoutSheetk_Reinstatment_Q1.setVisibility(LinearLayout.GONE);
        FrameLayoutSheetk_Reinstatment_Q2.setVisibility(LinearLayout.GONE);
        FrameLayoutSheetk_Reinstatment_Q3.setVisibility(LinearLayout.GONE);
        FrameLayoutSheetk_Reinstatment_Q4.setVisibility(LinearLayout.GONE);
        FrameLayoutSheetk_Reinstatment_Q5.setVisibility(LinearLayout.GONE);
        FrameLayoutSheetk_Reinstatment_Yes_Answer.setVisibility(LinearLayout.GONE);
        FrameLayoutSheetk_Reinstatment_No_Answer.setVisibility(LinearLayout.GONE);

        FrameLayoutSheetk_Reinstatment_Q1_No.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ((FrameLayoutSheetk_Reinstatment_Q1_No.isChecked())
                        || (FrameLayoutSheetk_Reinstatment_Q2_No.isChecked())
                        || (FrameLayoutSheetk_Reinstatment_Q3_No.isChecked())
                        || (FrameLayoutSheetk_Reinstatment_Q4_No.isChecked())
                        || (FrameLayoutSheetk_Reinstatment_Q5_No.isChecked())) {

                    FrameLayoutSheetk_Reinstatment_No_Answer.setVisibility(LinearLayout.VISIBLE);
                }
                else {
                    FrameLayoutSheetk_Reinstatment_No_Answer.setVisibility(LinearLayout.GONE);
                }
            }

        });

        FrameLayoutSheetk_Reinstatment_Q1_Yes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ((FrameLayoutSheetk_Reinstatment_Q1_Yes.isChecked())
                        || (FrameLayoutSheetk_Reinstatment_Q2_Yes.isChecked())
                        || (FrameLayoutSheetk_Reinstatment_Q3_Yes.isChecked())
                        || (FrameLayoutSheetk_Reinstatment_Q4_Yes.isChecked())
                        || (FrameLayoutSheetk_Reinstatment_Q5_Yes.isChecked())) {

                    FrameLayoutSheetk_Reinstatment_Yes_Answer.setVisibility(LinearLayout.VISIBLE);
                }
                else {
                    FrameLayoutSheetk_Reinstatment_Yes_Answer.setVisibility(LinearLayout.GONE);
                }
            }

        });







///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// FrameLayoutSheet K /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////








    }

}
