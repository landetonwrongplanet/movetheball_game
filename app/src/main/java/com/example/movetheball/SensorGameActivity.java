package com.example.movetheball;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;
import java.util.Timer;
import androidx.appcompat.app.AppCompatActivity;

import com.example.view.GameView;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    private int corner1;
    private int corner2;
    private int corner3;
    private int corner4;

    private Timer timer;
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

        sensorManager.registerListener((android.hardware.SensorEventListener) this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener((android.hardware.SensorEventListener) this);
    }

    public void onSensorChanged(SensorEvent event){

        gameView.update(event.values[0], event.values[1]);

    }
    // public boolean onTouchEvent(MotionEvent event){
       // if(event.getAction() == MotionEvent.ACTION_DOWN){


      //  }

    //}

    @SuppressLint("DefaultLocale")
    private void stopGame(boolean gameRunning){
     gameRunning = false;


        if(timer != null) {
            timer.cancel();
            timer.purge();
            timer = null;

        }
        takeScreenshot();

        Toast.makeText(getApplicationContext(),"Game Over. You touched " , numCornersTouched);
    }

    private void takeScreenshot(){

        String timestamp = new SimpleDateFormat("HHmmddMMyyyy").format(new Date());
        String filename = "Screenshot_" + timestamp + ".png";

        DisplayMetrics metrics =new DisplayMetrics();

    }

}
