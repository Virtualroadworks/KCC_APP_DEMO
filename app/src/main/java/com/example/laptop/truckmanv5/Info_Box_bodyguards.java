package com.example.laptop.truckmanv5;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Info_Box_bodyguards extends DialogFragment {

    String caller2;
    Button closebutton;



    static Info_Box_bodyguards newInstance(String caller2)
    {
        Info_Box_bodyguards dialogFragment = new Info_Box_bodyguards();
        Bundle args = new Bundle();
        args.putString("Caller2", caller2);
        dialogFragment.setArguments(args);
        return dialogFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.content_info__box_bodyguards, container, false);
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