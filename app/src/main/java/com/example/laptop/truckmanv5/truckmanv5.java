package com.example.laptop.truckmanv5;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by White Ninga on 24/09/2016.
 */

public class truckmanv5  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}

