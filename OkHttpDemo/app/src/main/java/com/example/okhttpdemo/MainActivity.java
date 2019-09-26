package com.example.okhttpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "OkHttp3-MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request request = new Request.Builder()
                        .url("https://www.baidu.com")
                        .get()
                        .build();
                MyApplication.getInstance()
                        .getOkHttpClient()
                        .newCall(request)
                        .enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Log.w(TAG, Log.getStackTraceString(e));
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Log.d(TAG, "ThreadName = \"" + Thread.currentThread().getName()+ '\"');
                                Log.d(TAG, response.toString());
                            }
                        });
            }
        });
    }
}
