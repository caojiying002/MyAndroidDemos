package com.example.picassodemo;

import android.app.Application;

public class MyApplication extends Application {

    private static MyApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static MyApplication getInstance() {
        return INSTANCE;
    }
}
