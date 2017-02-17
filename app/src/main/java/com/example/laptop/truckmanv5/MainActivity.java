package com.example.laptop.truckmanv5;

import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Firebase mRootRef;
    private Button start_inspection_button;

    boolean internet_connected;


    private TextView user_name,user_name2,Database_Synctime,access_level,database_check,online_check,gps_check;

    private String Level_0 = "Level 0";
    private String Level_1 = "Level 1";
    private String Level_2 = "Level 2";
    private String Level_3 = "Level 3";

    FrameLayout Lockoutuserframelayout;

    TextView Onlinetext;
    TextView GPSOnlinetext;
    ImageView onlineiconxl;
    ImageView gpsonlineiconxl;
    ImageView databaseonlineiconxl;


    public boolean  Online_check () {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Firebase.setAndroidContext(this);
        mRootRef = new Firebase("https://truckman-1dc51.firebaseio.com");
        firebaseAuth = FirebaseAuth.getInstance();

        Date date = new Date();
        String currentDateandTime = DateFormat.getDateTimeInstance().format(date);

        Firebase childRef = mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").child("Time User last connected");
        childRef.setValue(currentDateandTime);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        user_name = (TextView) findViewById(R.id.user_name);
        online_check = (TextView) findViewById(R.id.online_check);
        database_check = (TextView) findViewById(R.id.database_check);
        gps_check = (TextView) findViewById(R.id.gps_check);
        user_name2 = (TextView) findViewById(R.id.user_name2);
        access_level = (TextView) findViewById(R.id.access_level);
        Database_Synctime = (TextView) findViewById(R.id.Database_Synctime);
        Onlinetext = (TextView) findViewById(R.id.Onlinetext);
        GPSOnlinetext = (TextView) findViewById(R.id.GPSOnlinetext);

        onlineiconxl = (ImageView) findViewById(R.id.onlineiconxl);
        gpsonlineiconxl = (ImageView) findViewById(R.id.gpsonlineiconxl);
        databaseonlineiconxl = (ImageView) findViewById(R.id.databaseonlineiconxl);

        Lockoutuserframelayout = (FrameLayout) findViewById(R.id.Lockoutuserframelayout);
        Lockoutuserframelayout = (FrameLayout) findViewById(R.id.Lockoutuserframelayout);

        internet_connected = Online_check ();

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            gps_check.setText("Online");
            gpsonlineiconxl.setImageResource(R.drawable.gpsonlineiconxl);
            //Toast.makeText(this, "GPS is Enabled in your devide", Toast.LENGTH_SHORT).show();
        }else{
            gps_check.setText("Offline");
            gpsonlineiconxl.setImageResource(R.drawable.gpsofflineiconxl);
            showGPSDisabledAlertToUser();
        }


        if (internet_connected == false) {
            online_check.setText("Offline");
            onlineiconxl.setImageResource(R.drawable.offlineiconxl);
            databaseonlineiconxl.setImageResource(R.drawable.databaseofflineiconxl);
            database_check.setText("Awaiting sync");

        }
        else {
            online_check.setText("Online");
            onlineiconxl.setImageResource(R.drawable.onlineiconxl);
            databaseonlineiconxl.setImageResource(R.drawable.databaseonlineiconxl);
            database_check.setText("Synced");
            // onlineimage.setImageResource(R.drawable.onlineicon);
        }

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, Login_Page.class));
        }

        mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                String userName = dataSnapshot.child("User Name").getValue(String.class);
                String Database_Synced = dataSnapshot.child("Time User last connected").getValue(String.class);

                String userAccessLevel = dataSnapshot.child("User Access Level").getValue(String.class);

                if (Level_0.equals (userAccessLevel)) {
                    Lockoutuserframelayout.setVisibility(View.VISIBLE);
                    startActivity(new Intent(MainActivity.this, Userheldoutsideapp.class));
                } else if(Level_1.equals (userAccessLevel)) {
                    Lockoutuserframelayout.setVisibility(View.GONE);
                } else if(Level_2.equals (userAccessLevel)) {
                    Lockoutuserframelayout.setVisibility(View.GONE);
                } else if(Level_3.equals (userAccessLevel)) {
                    Lockoutuserframelayout.setVisibility(View.GONE);
                }
                access_level.setText(userAccessLevel);
                user_name.setText(userName);
                user_name2.setText(userName);
                Database_Synctime.setText(Database_Synced);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    //////////////////////////////Location Services Check////////////////////////////////////////////////////



    private void showGPSDisabledAlertToUser(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        alertDialogBuilder.setMessage("Would you like to turn on, Location Services?")
                .setCancelable(false)
                .setPositiveButton("Goto Settings Page To Enable Location Services",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                                gps_check.setText("Online");
                                gpsonlineiconxl.setImageResource(R.drawable.gpsonlineicon);

                            }
                        });

        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();


    }

    //////////////////////////////////////////////////////////////////////////////////



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public void onClick(View view) {

        if(view == start_inspection_button){
            finish();
            Intent nextView = new Intent(this, Vehicle_Reports.class);
            nextView.putExtra("CalledFromMainView", true);
            startActivity(nextView);

        }



    }
    //////////////////Tool Bar Nav Buttons/////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.vrdatabase:
                startActivity (new Intent(this, dccdrainageforms.class));
                break;
            case R.id.vrhome:

                startActivity (new Intent(this, MainActivity.class));
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_user_profile) {
            startActivity(new Intent(this, User_Profile.class));
            Toast.makeText(this, "User Profile Selected", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_user_profile_edit) {
            startActivity(new Intent(this, User_Profile_Edit.class));
            Toast.makeText(this, "User Profile Edit Selected", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.Videos) {
            startActivity(new Intent(this, Rsavideowebpage.class));
            Toast.makeText(this, "Videos Selected", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_vehicle_reports_database) {
            Intent nextView = new Intent(this, dccdrainageforms.class);
            startActivity(nextView);
            Toast.makeText(this, "Forms Database", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_truckman_app) {
            startActivity(new Intent(this, DCC_WEBSITE.class));
            Toast.makeText(this, "DCC Website", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_truckman_contact) {
            startActivity(new Intent(this, Virtualroadworkswebpage.class));
            Toast.makeText(this, "Contact Us", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_truckman_EULA) {
            startActivity(new Intent(this, EULA.class));
            Toast.makeText(this, "END USER LICENCE AGREEMENT ", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_truckman_instructions) {
            startActivity(new Intent(this, Apptutorial.class));
            Toast.makeText(this, "How to use App", Toast.LENGTH_SHORT).show();


        } else if (id == R.id.nav_log_out) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, Login_Page.class));
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}