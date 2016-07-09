package com.myapps.scorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void add3(View v) {
        scoreA += 3;
        displayForTeamA(scoreA);
    }

    public void add2(View v) {
        scoreA += 2;
        displayForTeamA(scoreA);
    }

    public void add1(View v) {
        scoreA += 1;
        displayForTeamA(scoreA);
    }

    public void addB3(View v) {
        scoreB += 3;
        displayForTeamB(scoreB);
    }

    public void addB2(View v) {
        scoreB += 2;
        displayForTeamB(scoreB);
    }

    public void addB1(View v) {
        scoreB += 1;
        displayForTeamB(scoreB);
    }
    public void reset(View v) {
        scoreA=0;
        scoreB=0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }


}
