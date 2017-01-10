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

public class AT0013_3_listadaptor extends BaseAdapter {
    private ArrayList<AT0013_3_model> arrayListAT0013_3 ;
    private Context context;
    private LayoutInflater inflater;

    public AT0013_3_listadaptor(Context context, ArrayList<AT0013_3_model> arrayListAT0013_3) {
        this.context = context;
        this.arrayListAT0013_3  = arrayListAT0013_3;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayListAT0013_3.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListAT0013_3.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        Holder holder;
        if (v == null) {
            v = inflater.inflate(R.layout.activity_at0013_3_listadaptor, null);
            holder = new Holder();
            holder.startdate = (TextView) v.findViewById(R.id.startdate);
            holder.user_name = (TextView) v.findViewById(R.id.user_name);
            holder.DeletePerson = (ImageView) v.findViewById(R.id.DeletePerson);
            v.setTag(holder);
        } else {
            holder = (Holder) v.getTag();
        }

        holder.user_name.setText(arrayListAT0013_3.get(position).getuser_name());
        holder.startdate.setText(String.valueOf(arrayListAT0013_3.get(position).getstartDate()));

        // Make a text area to hold the date, then get the date from the person class


        holder.DeletePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowConfirmDialog(context, position);
            }
        });
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
                        AT0013_3_database.getInstance().deletePerson(position);
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