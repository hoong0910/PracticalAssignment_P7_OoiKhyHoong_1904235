package com.example.practicalassignment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

public class Level1 extends AppCompatActivity {
    TextView timerTextView;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        int[] textViewIds = {R.id.textView5, R.id.textView2, R.id.textView4, R.id.textView6};

        int randomIndex = (int) (Math.random() * textViewIds.length);
        TextView correctTextView = findViewById(textViewIds[randomIndex]);
        correctTextView.setBackgroundColor(Color.RED);

        timerTextView = findViewById(R.id.timerTextView);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Level1.this, GameOver.class);
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
                        Intent intent = new Intent(Level1.this, Level2.class);
                        startActivity(intent);
                        timer.cancel(); // cancel the timer
                        finish(); // finish the current activity
                    } else {
                        Toast.makeText(getApplicationContext(), "Game Over!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Level1.this, GameOver.class);
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
                            Intent intent = new Intent(Level1.this, GameOver.class);
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