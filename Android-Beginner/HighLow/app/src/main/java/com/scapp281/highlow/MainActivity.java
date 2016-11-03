package com.scapp281.highlow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int currentNumber = 0;
    int pastNumber = 0;
    Random numberGenerator = new Random();

    public void generateNumber() {
        Button previous = (Button) findViewById(R.id.previous);
        Button current = (Button) findViewById(R.id.current);
        TextView previousText = (TextView) findViewById(R.id.previousText);

        previous.setVisibility(View.VISIBLE);
        previousText.setVisibility(View.VISIBLE);
        pastNumber = currentNumber;
        previous.setText(Integer.toString(pastNumber));
        currentNumber = numberGenerator.nextInt(11) + 10;
        current.setText(Integer.toString(currentNumber));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView previousText = (TextView) findViewById(R.id.previousText);
        Button previous = (Button) findViewById(R.id.previous);
        Button current = (Button) findViewById(R.id.current);
        Button highButton = (Button) findViewById(R.id.highButton);
        Button lowButton = (Button) findViewById(R.id.lowButton);

        previous.setVisibility(View.GONE);
        previousText.setVisibility(View.GONE);

        currentNumber = numberGenerator.nextInt(11) + 10;
        current.setText(Integer.toString(currentNumber));

        highButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNumber();
                if (currentNumber > pastNumber) {
                    Toast.makeText(getApplicationContext(),
                            "Yes, it is higher", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "No, it is lower", Toast.LENGTH_LONG).show();
                }
            }
        });

        lowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNumber();
                if (currentNumber < pastNumber) {
                    Toast.makeText(getApplicationContext(),
                            "Yes, it is lower", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "No, it is higher", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

}
