package com.example.okhttpdemo;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class MyApplication extends Application {

    public static MyApplication getInstance() {
        return instance;
    }
    private static MyApplication instance;

    OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        // Create OkHttpClient instance
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        instance = this;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
