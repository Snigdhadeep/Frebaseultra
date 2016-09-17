package com.techpenta.firebaseultra;

import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;

/**
 * Created by Snikdha on 9/14/2016.
 */
public class CrowdWeather extends android.app.Application {




    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }



}
