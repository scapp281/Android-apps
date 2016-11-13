package com.scapp281.audioplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    boolean resume = true;
    MediaPlayer mediaPlayer;

    public void playAudio(View view) {

        mediaPlayer.start();
    }

    public void pauseAudio(View view) {
        mediaPlayer.seekTo(mediaPlayer.getCurrentPosition());
        if (resume) {
            mediaPlayer.start();
            resume = false;
        } else {
            mediaPlayer.pause();
            resume = true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.de);
    }
}
