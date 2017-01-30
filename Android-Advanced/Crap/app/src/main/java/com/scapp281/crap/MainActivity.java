package com.scapp281.crap;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private enum Status {CONTINUE, WON, LOST}

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;

    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    private int x, y;

    public ImageView dice1;
    public ImageView dice2;
    public TextView point;
    public Button roll;

    public Dice dice;
    public int myPoint = 0, sumOfDice = 0;
    Status gameStatus;

    SoundPool dice_sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
    int sound_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice1 = (ImageView) findViewById(R.id.dice1);
        dice2 = (ImageView) findViewById(R.id.dice2);
        point = (TextView) findViewById(R.id.point);
        roll = (Button) findViewById(R.id.rollBtn);
        sound_id = dice_sound.load(this, R.raw.shake_dice, 1);
        dice = new Dice();

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice_sound.play(sound_id,1.0f,1.0f,0,0,1.0f);
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                dice1.startAnimation(rotate);
                dice2.startAnimation(rotate);

                sumOfDice = dice.rollDice();
                x = dice.getX();
                y = dice.getY();
                setDice(x, y);

                switch (sumOfDice) {
                    case SEVEN:
                    case YO_LEVEN:
                        gameStatus = Status.WON;
                        break;
                    case SNAKE_EYES:
                    case TREY:
                    case BOX_CARS:
                        gameStatus = Status.LOST;
                        break;
                    default:
                        gameStatus = Status.CONTINUE;
                        myPoint = sumOfDice;
                        point.setText(Integer.toString(myPoint));
                        break;
                }

                while (gameStatus == Status.CONTINUE) {

                    sumOfDice = dice.rollDice();
                    x = dice.getX();
                    y = dice.getY();
                    setDice(x, y);

                    if (myPoint == sumOfDice) {
                        gameStatus = Status.WON;
                    } else {
                        if (sumOfDice == SEVEN)
                            gameStatus = Status.LOST;
                    }
                }

                if (gameStatus == Status.WON) {
                    Toast.makeText(getApplicationContext(), "You won!", Toast.LENGTH_SHORT).show();
                    myPoint = 0;
                    sumOfDice = 0;
                } else {
                    Toast.makeText(getApplicationContext(), "You lost!", Toast.LENGTH_SHORT).show();
                    point.setText("0");
                    myPoint = 0;
                    sumOfDice = 0;
                }
            }
        });


    }

    public void setDice(int x, int y) {
        switch (x) {
            case 1:
                dice1.setImageResource(R.drawable.one);
                break;
            case 2:
                dice1.setImageResource(R.drawable.two);
                break;
            case 3:
                dice1.setImageResource(R.drawable.three);
                break;
            case 4:
                dice1.setImageResource(R.drawable.four);
                break;
            case 5:
                dice1.setImageResource(R.drawable.five);
                break;
            case 6:
                dice1.setImageResource(R.drawable.six);
                break;
            default:
                dice1.setImageResource(R.drawable.one);
                break;
        }
        switch (y) {
            case 1:
                dice2.setImageResource(R.drawable.one);
                break;
            case 2:
                dice2.setImageResource(R.drawable.two);
                break;
            case 3:
                dice2.setImageResource(R.drawable.three);
                break;
            case 4:
                dice2.setImageResource(R.drawable.four);
                break;
            case 5:
                dice2.setImageResource(R.drawable.five);
                break;
            case 6:
                dice2.setImageResource(R.drawable.six);
                break;
            default:
                dice2.setImageResource(R.drawable.one);
                break;
        }
    }
}
