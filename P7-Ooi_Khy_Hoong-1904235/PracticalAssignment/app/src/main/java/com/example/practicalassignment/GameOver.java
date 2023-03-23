package com.example.practicalassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Button BackMenu = findViewById(R.id.Return);
        BackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Intent to launch the target activity
                openMenu();
            }
        });
    }
    public void openMenu(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}