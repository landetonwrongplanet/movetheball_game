package com.example.movetheball;

import android.content.Context;
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
    }
    public void run(){

    }
}
