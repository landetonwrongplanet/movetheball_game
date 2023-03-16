package com.example.movetheball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

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

    public GameView(Context context) {
        super(context);
        surfaceHolder =getHolder();
        paint = new Paint();
        ballRadius = 50;
        ballColor = Color.BLUE;
        ballGlowRadius = 11;
        ballGlowColor = Color.YELLOW;
    }

    @Override
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




            }
        }

    }
}
