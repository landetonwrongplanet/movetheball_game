package com.example.movetheball;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SensorGameActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private GameView gameView;
    private int screenWidth;
    private int screenHeight;
    private int cornerRadius;
    private int cornerMargin;
    private int cornerPadding;
    private int[] cornerX;
    private int[] cornerY;
    private boolean cornerTouched;
    private int numCornersTouched;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        setContentView(gameView);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        cornerRadius = 100;
        cornerMargin = 200;
        cornerPadding = 20;
        cornerX = new int[] {cornerRadius + cornerMargin, screenWidth - cornerPadding};
        cornerY = new int[] {cornerRadius + cornerMargin, cornerRadius + cornerPadding};

    }
    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public void onSensorChanged(){

    }
    public boolean onTouchEvent(){}

    private void stopGame(){}

    private void takeScreenshot(){

    }

}
