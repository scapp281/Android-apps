package com.myapp.beforeaftercookie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int togglef = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        ImageView iv = (ImageView) findViewById(R.id.android_cookie_image_view);
        TextView tv = (TextView)findViewById(R.id.status_text_view);
        if(togglef==0) {
            iv.setImageResource(R.drawable.after_cookie);
            tv.setText("I'm so full.");
            togglef+=1;
        }else{
            iv.setImageResource(R.drawable.before_cookie);
            tv.setText("I'm so hungry.");
            togglef-=1;
        }
    }
}
