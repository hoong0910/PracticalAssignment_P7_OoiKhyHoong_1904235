package com.example.practicalassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView startButton = findViewById(R.id.StartGame);
        TextView score = findViewById(R.id.ScoreTable);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Intent to launch the target activity
                openLevel1();
            }
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Intent to launch the target activity
                openScoreTable();
            }
        });
    }
    public void openLevel1(){
        Intent intent=new Intent(this,Level1.class);
        startActivity(intent);
    }
    public void openScoreTable(){
        Intent intent=new Intent(this,ScoreTable.class);
        startActivity(intent);
    }
}