package com.example.laptop.truckmanv5;

import android.app.FragmentManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    MediaPlayer mp;
    MediaPlayer mp1;

    private FirebaseAuth firebaseAuth;
    private Firebase mRootRef;
    private Button start_inspection_button;

    private TextView user_name,user_name2,access_level;

    private String Level_0 = "Level 0";
    private String Level_1 = "Level 1";
    private String Level_2 = "Level 2";
    private String Level_3 = "Level 3";

    FrameLayout Lockoutuserframelayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mp = MediaPlayer.create(this, R.raw.beep_splash);
        mp1 = MediaPlayer.create(this, R.raw.beep_button_g);
        mp.start();

        firebaseAuth = FirebaseAuth.getInstance();
        Firebase.setAndroidContext(this);
        mRootRef = new Firebase("https://truckman-1dc51.firebaseio.com");

        user_name = (TextView) findViewById(R.id.user_name);
        user_name2 = (TextView) findViewById(R.id.user_name2);
        access_level = (TextView) findViewById(R.id.access_level);
        Lockoutuserframelayout = (FrameLayout) findViewById(R.id.Lockoutuserframelayout);


        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, Login_Page.class));
        }


        mRootRef.child("users").child(firebaseAuth.getCurrentUser().getUid()).child("Profile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {

                String userName = dataSnapshot.child("User Name").getValue(String.class);

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

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }



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
            mp1.start();
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
                return true;

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
            Toast.makeText(this, "About DCC APP", Toast.LENGTH_SHORT).show();

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