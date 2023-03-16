package com.example.movetheball;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import androidx.appcompat.app.AppCompatActivity;

public class SensorGameActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensormanager;
    private Sensor accelerometer;
    private GameView gameView;
    private int screenWidth;
    private int screenHeight;
    private int cornerRadius;
    private int cornerMargin;
    private int cornerPadding;
    private int cornerX;
    private int cornerY;
    private boolean cornerTouched;
    private int numCornersTouched;

}
