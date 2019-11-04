package com.example.rajaampat.network;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
