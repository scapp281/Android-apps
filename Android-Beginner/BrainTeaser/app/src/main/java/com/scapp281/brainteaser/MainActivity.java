package com.scapp281.brainteaser;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView timerTextview;
    TextView pointsTextview;
    TextView sumTextview;
    TextView resultTextview;
    GridLayout answersGrid;
    Button button0, button1, button2, button3, playAgainButton;
    CountDownTimer showMainGameScreen;
    RelativeLayout mainScreen;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;


    private void shouldEnableButtons(GridLayout layout, boolean shouldEnable) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (shouldEnable) {
                child.setEnabled(true);
            } else {
                child.setEnabled(false);
            }
        }
    }

    public void playAgain(View view) {
        timerTextview.setText("30s");
        pointsTextview.setText("0/0");
        resultTextview.setText(" ");
        resultTextview.setVisibility(View.VISIBLE);
        playAgainButton.setVisibility(View.GONE);
        score = 0;
        numberOfQuestions = 0;
        generateQuestion();
        shouldEnableButtons(answersGrid, true);
        new CountDownTimer(15000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextview.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                timerTextview.setText("0s");
                resultTextview.setText("Your score is: " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
                playAgainButton.setVisibility(View.VISIBLE);
                shouldEnableButtons(answersGrid, false);
            }
        }.start();

    }

    public void generateQuestion() {
        Random random = new Random();

        int a = random.nextInt(50);
        int b = random.nextInt(50);

        sumTextview.setText(Integer.toString(a) + " + " + Integer.toString(b));
        locationOfCorrectAnswer = random.nextInt(4);
        answers.clear();

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a + b);
            } else {
                int incorrectAnswer = random.nextInt(41);
                while (incorrectAnswer == a + b) {
                    incorrectAnswer = random.nextInt(41);
                }
                answers.add(incorrectAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void chooseAnswer(View view) {
        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {
            resultTextview.setVisibility(View.VISIBLE);
            resultTextview.animate().scaleX(0.5f).setDuration(3000);
            resultTextview.setText("Correct!");

            score++;
        } else {
            resultTextview.setVisibility(View.VISIBLE);
            resultTextview.animate().scaleX(0.5f).setDuration(3000);
            resultTextview.setText("Incorrect!");
        }
        numberOfQuestions++;
        pointsTextview.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        generateQuestion();
    }

    public void start(View view) {
        // TODO: Learn to do sets of animation
        startButton.animate().alpha(0f).rotation(2000f).translationXBy(1800f).setDuration(4000);

        showMainGameScreen = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mainScreen.setVisibility(RelativeLayout.VISIBLE);
            }
        }.start();
        playAgain(findViewById(R.id.playAgainButton));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainScreen = (RelativeLayout) findViewById(R.id.mainScreen);
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setVisibility(View.VISIBLE);
        timerTextview = (TextView) findViewById(R.id.timerTextview);
        pointsTextview = (TextView) findViewById(R.id.pointsTextView);
        sumTextview = (TextView) findViewById(R.id.sumTextview);
        resultTextview = (TextView) findViewById(R.id.resultTextview);
        answersGrid = (GridLayout) findViewById(R.id.answersGrid);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        playAgainButton = (Button) findViewById(R.id.playAgainButton);
    }
}
