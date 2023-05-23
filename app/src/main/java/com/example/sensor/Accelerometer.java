package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventCallback;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

            // To Start with Sensor we need a Sensor manager and we will assign it with a Service

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager != null)
        {
            // Making object of Sensor
            Sensor acceleroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            if(acceleroSensor != null)
            {
                // There a listner for manager thet we need to implement
                sensorManager.registerListener(this, acceleroSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        // Here on every use of 'any' Sensor, This method get Called.

        // Checcking that event should for ACCELERAOTOR SENSOR
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            ((TextView)findViewById(R.id.value)).setText("X : " + event.values[0] + " Y : " + event.values[1] + " Z : " + event.values[2]);

            if(event.values[0] <= -7)
            {
                Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show();
            }

            if(event.values[0] >= 7)
            {
                Toast.makeText(this, "Left", Toast.LENGTH_SHORT).show();
            }

            if(event.values[1] <= -7)
            {
                Toast.makeText(this, "Upside Down", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}