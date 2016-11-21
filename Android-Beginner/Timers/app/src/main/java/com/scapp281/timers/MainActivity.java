package com.scapp281.timers;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //option 1
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.i("Runnable:", "A Second Passed...");
                handler.postDelayed(this, 1000);
            }
        };

        handler.post(runnable);

        //option 2 (args: duration, ticks)
        new CountDownTimer(10000, 2000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("Second left:", String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                Log.i("Countdown","Done!");
            }
        }.start();
    }
}
