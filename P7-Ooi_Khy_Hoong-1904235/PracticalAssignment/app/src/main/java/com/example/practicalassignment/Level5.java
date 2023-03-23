package com.example.practicalassignment;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
public class Level5 extends AppCompatActivity {
    TextView timerTextView;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level5);

        int[] textViewIds = {R.id.textView17, R.id.textView18, R.id.textView19,R.id.textView36,R.id.textView37, R.id.textView38, R.id.textView44,R.id.textView65,
                R.id.textView66, R.id.textView67, R.id.textView77,R.id.textView93,R.id.textView85, R.id.textView86, R.id.textView87,R.id.textView88,R.id.textView89,
                R.id.textView90, R.id.textView91,R.id.textView92,R.id.textView78, R.id.textView79, R.id.textView80,R.id.textView81,R.id.textView82, R.id.textView83,
                R.id.textView84,R.id.textView68,R.id.textView69, R.id.textView70, R.id.textView71,R.id.textView72,R.id.textView73,
                R.id.textView74, R.id.textView75,R.id.textView76};

        int randomIndex = (int) (Math.random() * textViewIds.length);
        TextView correctTextView = findViewById(textViewIds[randomIndex]);
        correctTextView.setBackgroundColor(Color.RED);

        timerTextView = findViewById(R.id.timerTextView5);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Level5.this, GameOver.class);
                startActivity(intent);
                finish();
            }
        }, 5000);

        for (int i = 0; i < textViewIds.length; i++) {
            TextView textView = findViewById(textViewIds[i]);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (textView == correctTextView) {
                        Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Level5.this, Complete.class);
                        startActivity(intent);
                        timer.cancel(); // cancel the timer
                        finish(); // finish the current activity
                    } else {
                        Toast.makeText(getApplicationContext(), " Times up ! Game Over!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Level5.this, GameOver.class);
                        startActivity(intent);
                        timer.cancel(); // cancel the timer
                        finish(); // finish the current activity
                    }
                }
            });
        }

        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 5;

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        timerTextView.setText("Time: " + i);
                        i--;

                        if (i < 0) {
                            // The timer has finished, show a game over message and exit the activity
                            Toast.makeText(getApplicationContext(), "Time's up! Game over.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Level5.this, GameOver.class);
                            startActivity(intent);
                            finish();
                            timer.cancel(); // cancel the timer
                        }
                    }
                });
            }
        }, 0, 1000);
    }
}