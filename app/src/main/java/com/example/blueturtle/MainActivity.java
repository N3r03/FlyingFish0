package com.example.blueturtle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import java.sql.Time;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    private flyingFishView gameView;
    private Handler handler = new Handler();
    private final static long Interval = 30;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new flyingFishView(this);
        setContentView(gameView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        gameView.invalidate();
                    }

                });
            }
        }, 0, Interval);
    }
}