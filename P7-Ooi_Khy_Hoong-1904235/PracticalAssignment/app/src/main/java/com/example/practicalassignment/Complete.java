package com.example.practicalassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Complete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
        EditText Player;

        Player=findViewById(R.id.Player);
        Button SubmitButton = findViewById(R.id.Submit);



        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayerModel playerModel;
                try{
                    playerModel=new PlayerModel(Player.getText().toString(),5);
                }
                catch(Exception e){
                    Toast.makeText(Complete.this,"Error dont have input name",Toast.LENGTH_SHORT).show();
                    playerModel=new PlayerModel("error",25);

                }
                DatabaseHelper databaseHelper = new DatabaseHelper(Complete.this);
                boolean success = databaseHelper.addOne(playerModel);

                // Create a new Intent to launch the target activity
                Submit();
            }
        });
    }
    public void Submit(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
