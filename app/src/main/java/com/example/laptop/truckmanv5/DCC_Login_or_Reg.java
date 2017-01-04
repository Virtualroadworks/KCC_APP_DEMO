package com.example.laptop.truckmanv5;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class DCC_Login_or_Reg extends AppCompatActivity implements View.OnClickListener {


    MediaPlayer mp1,mp2;

    private Firebase mRootRef;
    private FirebaseAuth firebaseAuth;

    private ImageButton Register_new_user_button;
    private ImageButton Login_user_button;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcc__login_or__reg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Firebase.setAndroidContext(this);
        mRootRef = new Firebase("https://truckman-1dc51.firebaseio.com/");
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        Register_new_user_button = (ImageButton) findViewById(R.id.Register_new_user_button);
        Login_user_button = (ImageButton) findViewById(R.id.Login_user_button);

        Register_new_user_button.setOnClickListener(this);
        Login_user_button.setOnClickListener(this);

        mp1 = MediaPlayer.create(this, R.raw.beep_button_c);
        mp2 = MediaPlayer.create(this, R.raw.beep_button_h);

    }

    @Override
    public void onClick(View view) {
        if (view == Register_new_user_button) {

            progressDialog.setMessage("Register Screen");
            progressDialog.show();
            mp1.start();

            startActivity(new Intent(this, Register_Page.class));

            firebaseAuth.signOut();
            progressDialog.dismiss();


        }

        if (view == Login_user_button) {

            progressDialog.setMessage("Login Screen");
            progressDialog.show();
            mp2.start();

            startActivity(new Intent(this, Login_Page.class));

            progressDialog.dismiss();


        }
        finish();
    }

}
