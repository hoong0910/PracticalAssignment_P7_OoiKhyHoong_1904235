package com.example.practicalassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ScoreTable extends AppCompatActivity {

    ListView ScoreList;
    ArrayAdapter playerArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_table);
        ScoreList=findViewById(R.id.ScoreList);

        DatabaseHelper databaseHelper= new DatabaseHelper(ScoreTable.this);
        List<PlayerModel> everyone=databaseHelper.getEveryone();

        Toast.makeText(ScoreTable.this,everyone.toString(),Toast.LENGTH_SHORT).show();
        playerArrayAdapter= new ArrayAdapter<PlayerModel>(ScoreTable.this, android.R.layout.simple_list_item_1,everyone);
        ScoreList.setAdapter(playerArrayAdapter);


    }
}