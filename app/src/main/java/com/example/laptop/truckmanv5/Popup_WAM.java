package com.example.laptop.truckmanv5;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Popup_WAM extends DialogFragment {

    Button buttonnodefect;

    EditText describedefect;
    EditText tempfix;

    ImageButton upload_button_defect;
    ImageButton windows_inspect_vehicle_unroadworthy_button;


    String caller;



    static Popup_WAM newInstance(String caller)
    {
        Popup_WAM dialogFragment = new Popup_WAM ();
        Bundle args = new Bundle();
        args.putString("Caller", caller);
        dialogFragment.setArguments(args);
        return dialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        caller = getArguments().getString("Caller");

        View rootView = inflater.inflate(R.layout.content_popup__wam, container, false);
        getDialog().setTitle("Simple Dialog");


        describedefect = (EditText) rootView.findViewById(R.id.describedefect);
        tempfix = (EditText) rootView.findViewById(R.id.tempfix);
        buttonnodefect = (Button) rootView.findViewById(R.id.buttonnodefect);
        upload_button_defect = (ImageButton) rootView.findViewById(R.id.upload_button_defect);
        windows_inspect_vehicle_unroadworthy_button = (ImageButton) rootView.findViewById(R.id.windows_inspect_vehicle_unroadworthy_button);



        //Buttons below

        windows_inspect_vehicle_unroadworthy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                describedefect.setText("Vehicle is Unroadworthy!");
                tempfix.setText("There is No Temporary Fix!");

            }
        });


        upload_button_defect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DefectRecordedListener activity = (DefectRecordedListener) getActivity();


                String describe_defect = describedefect.getText().toString();
                String describe_fix = tempfix.getText().toString();

                activity.onFinishEditDialog(caller, describe_defect, describe_fix);
                dismiss();
            }
        });

        buttonnodefect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });



        return rootView;
    }

    public interface DefectRecordedListener {

        void onFinishEditDialog(String caller, String description, String fix);
    }


}
