package org.jiying.demo.modularization.module1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Module1Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1_a1);
        getSupportActionBar().setTitle(getClass().getSimpleName());
    }
}
