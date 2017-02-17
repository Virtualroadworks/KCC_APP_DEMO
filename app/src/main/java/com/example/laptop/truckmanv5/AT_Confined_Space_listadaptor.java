package com.example.laptop.truckmanv5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AT_Confined_Space_listadaptor extends BaseAdapter {
    private ArrayList<AT_Confined_Space_model> arrayListAT_Confined_Space ;
    private Context context;
    private LayoutInflater inflater;

    public AT_Confined_Space_listadaptor(Context context, ArrayList<AT_Confined_Space_model> arrayListAT_Confined_Space) {
        this.context = context;
        this.arrayListAT_Confined_Space  = arrayListAT_Confined_Space;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayListAT_Confined_Space.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListAT_Confined_Space.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        AT_Confined_Space_listadaptor.Holder holder;
        if (v == null) {
            v = inflater.inflate(R.layout.activity_at__risk_assessment_listadaptor, null);
            holder = new AT_Confined_Space_listadaptor.Holder();
            holder.startdate = (TextView) v.findViewById(R.id.startdate);
            holder.user_name = (TextView) v.findViewById(R.id.user_name);
            //holder.DeletePerson = (ImageView) v.findViewById(R.id.DeletePerson);
            v.setTag(holder);
        } else {
            holder = (AT_Confined_Space_listadaptor.Holder) v.getTag();
        }

        holder.user_name.setText(arrayListAT_Confined_Space.get(position).getuser_name());
        holder.startdate.setText(String.valueOf(arrayListAT_Confined_Space.get(position).getstartDate()));

        // Make a text area to hold the date, then get the date from the person class


//        holder.DeletePerson.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ShowConfirmDialog(context, position);
//            }
//        });
       return v;
    }

    class Holder {
        TextView user_name,startdate;
        ImageView DeletePerson;
    }
//////////////////////////////////pop-up box//////////////////////////////////////

    public static void ShowConfirmDialog(Context context, final int position) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder
                .setMessage("Are you sure you want to delete this entry?")
                .setCancelable(true)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AT_Confined_Space_database.getInstance().deletePerson(position);
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


}