package com.scapp281.faderotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int start = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fade(View view) {
        ImageView bart = (ImageView) findViewById(R.id.bart);
        ImageView homer = (ImageView) findViewById(R.id.homer);

        if (start == 0) {
            bart.animate().alpha(0f)
                    .translationXBy(111f).rotationY(-180f).setDuration(2000);
            homer.animate().alpha(1f).setDuration(2000);
            start = 1;
        } else {
            homer.animate().alpha(0f).rotation(1800f).setDuration(2000);
            bart.animate().alpha(1f).setDuration(2000);
            start = 0;
        }
    }
}
