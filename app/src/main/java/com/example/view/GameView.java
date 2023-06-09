package com.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.movetheball.Runnable;

public class GameView extends SurfaceView implements Runnable {
    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private Thread gameThread;
    private boolean isRunning;
    private int ballX;
    private int ballY;
    private int ballRadius;
    private int ballColor;
    private int ballGlowRadius;
    private int ballGlowColor;
    private boolean[] cornerTouched;
    private int cornerX;
    private int cornerY;
    private int cornerRadius;


    public GameView(Context context) {
        super(context);
        surfaceHolder =getHolder();
        paint = new Paint();
        ballRadius = 50;
        ballColor = Color.BLUE;
        ballGlowRadius = 11;
        ballGlowColor = Color.YELLOW;
    }

    public void run(){
        while(isRunning){
            if (surfaceHolder.getSurface().isValid()){
                Canvas canvas = surfaceHolder.lockCanvas();
                canvas.drawColor(Color.WHITE);

                paint.setColor(ballGlowColor);
                paint.setAlpha(128);
                canvas.drawCircle(ballX, ballY, ballGlowRadius, paint);

                paint.setColor(ballColor);
                paint.setAlpha(255);
                canvas.drawCircle(ballX, ballY, ballRadius, paint);

                paint.setColor(Color.RED);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(10);
                for(int i = 0; i < 4; i++){
                    if(cornerTouched[i]){
                        paint.setColor(Color.GREEN);
                    }else{
                        paint.setColor(Color.RED);
                    }
                    canvas.drawCircle(cornerX,cornerY, cornerRadius, paint);
                }

            }
        }

    }

    public void update(float value, float value1) {
    }
}
