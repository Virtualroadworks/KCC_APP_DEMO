package com.example.laptop.truckmanv5;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {


    TextView textView2;
    Animation animation;
    MediaPlayer mp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);





        mp = MediaPlayer.create(this, R.raw.beep_button);
        mp.start();

        setContentView(R.layout.activity_splash__screen);
        Thread myThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent startMainScreen = new Intent(getApplicationContext(), DCC_Login_or_Reg.class);
                    startActivity(startMainScreen);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        myThread.start();

        textView2 = (TextView)findViewById(R.id.textView2);


        animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        textView2.startAnimation(animation);
    }

}
