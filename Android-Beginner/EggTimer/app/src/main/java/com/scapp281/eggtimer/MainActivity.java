package com.scapp281.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    SeekBar timerSeekBar;
    NumberPicker minutePicker;
    NumberPicker onesPicker;
    NumberPicker tenthPicker;
    Button controllerButton;
    Boolean counterIsActive = false;
    CountDownTimer countDownTimer;
    int currentMinPicker;
    int currentTenthPicker;
    int currentOnesPicker;
    int total;

    public void resetTimer() {
        tenthPicker.setValue(3);
        onesPicker.setValue(0);
        minutePicker.setValue(0);
        timerSeekBar.setProgress(30);
        countDownTimer.cancel();
        controllerButton.setText("Go!");
        timerSeekBar.setEnabled(true);
        counterIsActive = false;

    }

    public void updateTimer(int secondsLeft) {

        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        int ones = seconds % 10;
        int tenth = (int) seconds / 10;

        minutePicker.setValue(minutes);
        onesPicker.setValue(ones);
        tenthPicker.setValue(tenth);

    }

    public void controlTimer(View view) {
        if (counterIsActive == false) {

            counterIsActive = true;
            timerSeekBar.setEnabled(false);
            controllerButton.setText("Stop");

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {

                    updateTimer((int) millisUntilFinished / 1000);

                }

                @Override
                public void onFinish() {

                    resetTimer();
                    MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mplayer.start();

                }
            }.start();

        } else {

            resetTimer();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = (SeekBar) findViewById(R.id.timerSeekbar);
        controllerButton = (Button) findViewById(R.id.controllerButton);
        minutePicker = (NumberPicker) findViewById(R.id.minutePicker);
        tenthPicker = (NumberPicker) findViewById(R.id.tenthPicker);
        onesPicker = (NumberPicker) findViewById(R.id.onesPicker);

        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);
        minutePicker.setMinValue(0);
        minutePicker.setMaxValue(10);
        minutePicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);  // disable soft keyboard
        tenthPicker.setMinValue(0);
        tenthPicker.setMaxValue(5);
        tenthPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        onesPicker.setMinValue(0);
        onesPicker.setMaxValue(9);
        onesPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        tenthPicker.setValue(3);
        onesPicker.setValue(0);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        minutePicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                currentMinPicker = newVal * 60;
                timerSeekBar.setProgress(currentMinPicker + currentOnesPicker + currentTenthPicker);
            }
        });

        tenthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                currentTenthPicker = newVal * 10;
                timerSeekBar.setProgress(currentMinPicker + currentOnesPicker + currentTenthPicker);
            }
        });

        onesPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                currentOnesPicker = newVal;
                timerSeekBar.setProgress(currentMinPicker + currentOnesPicker + currentTenthPicker);
            }
        });
        timerSeekBar.setProgress(currentMinPicker + currentOnesPicker + currentTenthPicker);

    }
}
