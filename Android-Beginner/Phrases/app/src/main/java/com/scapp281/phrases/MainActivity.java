package com.scapp281.phrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public void tap(View view) throws IOException {
//        Log.i("S", Integer.toString(view.getId()));
//        Log.i("S", resourceId);
//        Log.i("S",getApplicationContext().getPackageName());
        String PACKAGE_NAME = getApplicationContext().getPackageName();
        int ID_number = view.getId();
        String ourID = view.getResources().getResourceEntryName(ID_number);
        int resourceID = getResources().getIdentifier(ourID,"raw",PACKAGE_NAME);
        MediaPlayer mediaPlayer = MediaPlayer.create(this,resourceID);
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
