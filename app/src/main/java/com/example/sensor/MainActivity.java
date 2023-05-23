package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle; 
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Implementing Proximity Sensor, Accelerometer Sensor and Ambient Light Sensor.

        Button P_btn, Ac_btn, Am_btn;


        P_btn = findViewById(R.id.btn1);
        Ac_btn = findViewById(R.id.btn2);
        Am_btn = findViewById(R.id.btn3);

        P_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(MainActivity.this, Proximity.class);
                startActivity(iNext);
            }
        });

        Ac_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(MainActivity.this, Accelerometer.class);
                startActivity(iNext);
            }
        });

        Am_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iNext = new Intent(MainActivity.this, Ambient_Light.class);
                startActivity(iNext);            }
        });
    }
}
