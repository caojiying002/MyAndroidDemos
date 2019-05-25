package org.jiying.demo.modularization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.jiying.demo.modularization.module1.Module1Activity1;
import org.jiying.demo.modularization.module2.Module2Activity1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().setTitle(getClass().getSimpleName());

        findViewById(R.id.button_m1_a1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Module1Activity1.class));
            }
        });
        findViewById(R.id.button_m2_a1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Module2Activity1.class));
            }
        });
    }
}
