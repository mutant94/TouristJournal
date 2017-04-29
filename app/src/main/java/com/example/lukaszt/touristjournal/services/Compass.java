package com.example.lukaszt.touristjournal.services;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import com.example.lukaszt.touristjournal.activity.MenuPlaceActivity;

/**
 * Created by lukaszt on 29.04.2017.
 */

public class Compass implements SensorEventListener {
    private SensorManager sensorManager;
    private MenuPlaceActivity activity;
    private float currentDegree = 0f;

    public Compass(MenuPlaceActivity activity){
        this.activity = activity;
        sensorManager = (SensorManager) this.activity.getSystemService(this.activity.SENSOR_SERVICE);
    }

    public void startRegister(){
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_GAME);

    }
    public void stopRegister(){
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        float degree = Math.round(event.values[0]);
        RotateAnimation ra = new RotateAnimation(currentDegree, -degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(210);
        ra.setFillAfter(true);
        currentDegree = -degree;
        activity.changeCompass(ra);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
