package com.example.laptop.truckmanv5;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Info_Box_Windows_and_Mirrors extends DialogFragment {

    String caller2;
    Button closebutton;



    static Info_Box_Windows_and_Mirrors newInstance(String caller2)
    {
        Info_Box_Windows_and_Mirrors dialogFragment = new Info_Box_Windows_and_Mirrors ();
        Bundle args = new Bundle();
        args.putString("Caller2", caller2);
        dialogFragment.setArguments(args);
        return dialogFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.content_info__box__windows_and__mirrors, container, false);
        getDialog().setTitle("Simple Dialog");

        closebutton = (Button) rootView.findViewById(R.id.closebutton);

        //Buttons below

        closebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }


        });



        return rootView;

    }

}
