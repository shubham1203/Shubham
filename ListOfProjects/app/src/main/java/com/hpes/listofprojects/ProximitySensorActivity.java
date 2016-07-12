package com.hpes.listofprojects;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class ProximitySensorActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager sm;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);
        iv = (ImageView)findViewById(R.id.imgProx);
        String ss = Context.SENSOR_SERVICE;
        sm = (SensorManager)getSystemService(ss);
        int sensorNo = Sensor.TYPE_PROXIMITY;
        Sensor s = sm.getDefaultSensor(sensorNo);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        Toast.makeText(ProximitySensorActivity.this, "Value from Sensor is "+f , Toast.LENGTH_SHORT).show();
        if(f == 0.0){
            iv.setImageResource(R.drawable.ironman);
        }
        else {
            iv.setImageResource(R.drawable.avengers);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(this);
    }
}
