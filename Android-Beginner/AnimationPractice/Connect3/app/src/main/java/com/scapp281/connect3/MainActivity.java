package com.scapp281.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameIsActive = true;
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        counter.setTranslationY(-1000f);

        if (gameState[tappedCounter] == 2 && gameIsActive) {
            gameState[tappedCounter] = activePlayer;
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
        }
        counter.animate().translationYBy(1000f).rotation(360).setDuration(300);


        for (int[] winningPosition : winningPositions) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]] != 2) {

                gameIsActive = false;
                String winner = "Red";

                if (gameState[winningPosition[0]] == 0) {
                    winner = "Yellow";
                }

                TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);

                winnerMessage.setText(winner + " has won!");

                LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);

                Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slide_down);

                Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.slide_up);

                playAgainLayout.setVisibility(View.VISIBLE);
                playAgainLayout.startAnimation(slide_down);
            } else {

                boolean gameIsOver = true;

                for (int counterState : gameState) {

                    if (counterState == 2) gameIsOver = false;

                }

                if (gameIsOver) {

                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);

                    winnerMessage.setText("It's a draw");

                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

                    layout.setVisibility(View.VISIBLE);

                }
            }
        }
    }

    public void playAgain(View view) {

        gameIsActive = true;

        LinearLayout playAgainLayout = (LinearLayout) findViewById(R.id.playAgainLayout);

        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);

        playAgainLayout.setVisibility(View.INVISIBLE);
        playAgainLayout.startAnimation(slide_up);

        activePlayer = 0;

        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
