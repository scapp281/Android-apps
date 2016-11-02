package com.scapp281.highlow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int currentNumber = 0;
    int passNumber = 0;
    Random numberGenerator = new Random();
    Button numberButton;
    Button highButton;
    Button lowButton;

    public void generateNumber(){
        passNumber = currentNumber;
        currentNumber = numberGenerator.nextInt(11)+10;

        numberButton.setText(Integer.toString(currentNumber));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberButton = (Button) findViewById(R.id.numberButton);
        highButton = (Button) findViewById(R.id.highButton);
        lowButton = (Button) findViewById(R.id.lowButton);

        currentNumber = numberGenerator.nextInt(11)+10;
        numberButton.setText(Integer.toString(currentNumber));

        highButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNumber();
                if(currentNumber>passNumber){
                    Toast.makeText(getApplicationContext(),
                            "Yes, it is higher", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),
                            "No, it is lower", Toast.LENGTH_LONG).show();
                }
            }
        });

        lowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNumber();
                if(currentNumber<passNumber){
                    Toast.makeText(getApplicationContext(),
                            "Yes, it is lower", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),
                            "No, it is higher", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

}
