package com.camon.checkmydevice.app;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class SensorTestActivity extends Activity implements SensorEventListener {
    private SensorManager sensorManager;
    private TextView textX;
    private TextView textY;
    private TextView textZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_test);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        textX = (TextView) findViewById(R.id.text_x);
        textY = (TextView) findViewById(R.id.text_y);
        textZ = (TextView) findViewById(R.id.text_z);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (Sensor.TYPE_ACCELEROMETER  == sensorEvent.sensor.getType()) {
            Log.i("onSensorChanged", "Sensor.TYPE_ACCELEROMETER");
            getAccelerometer(sensorEvent);
        }
    }

    private void getAccelerometer(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        textX.setText(String.valueOf(x));
        textY.setText(String.valueOf(y));
        textZ.setText(String.valueOf(z));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        Log.i("onAccuracyChanged", "onAccuracyChanged");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // register this class as a listener or the orientation and
        // accelerometer sensorsf
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
