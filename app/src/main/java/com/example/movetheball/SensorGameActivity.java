package com.example.movetheball;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
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


    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    public void onSensorChanged(SensorEvent event){

        gameView.update()

    }
    public boolean onTouchEvent(){}

    private void stopGame(){}

    private void takeScreenshot(){

    }

}
