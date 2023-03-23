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

public class Level4 extends AppCompatActivity {
    TextView timerTextView;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);

        int[] textViewIds = {R.id.textView39, R.id.textView40, R.id.textView41,R.id.textView42,R.id.textView43, R.id.textView45, R.id.textView46,R.id.textView47,
                R.id.textView48, R.id.textView49, R.id.textView50,R.id.textView51,R.id.textView52, R.id.textView53, R.id.textView54,R.id.textView55,R.id.textView56,
                R.id.textView57, R.id.textView58,R.id.textView59,R.id.textView60, R.id.textView61, R.id.textView62,R.id.textView63,
                R.id.textView64};

        int randomIndex = (int) (Math.random() * textViewIds.length);
        TextView correctTextView = findViewById(textViewIds[randomIndex]);
        correctTextView.setBackgroundColor(Color.RED);

        timerTextView = findViewById(R.id.timerTextView4);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Level4.this, GameOver.class);
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
                        Intent intent = new Intent(Level4.this, Level5.class);
                        startActivity(intent);
                        timer.cancel(); // cancel the timer
                        finish(); // finish the current activity
                    } else {
                        Toast.makeText(getApplicationContext(), "Game Over!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Level4.this, GameOver.class);
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
                            Intent intent = new Intent(Level4.this, GameOver.class);
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