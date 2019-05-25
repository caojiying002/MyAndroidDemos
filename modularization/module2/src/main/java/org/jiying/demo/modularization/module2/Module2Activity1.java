package org.jiying.demo.modularization.module2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Module2Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2_a1);
        getSupportActionBar().setTitle(getClass().getSimpleName());
    }
}
