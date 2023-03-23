package com.example.practicalassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String PLAYER_TABLE = "PLAYER_TABLE";
    public static final String COLUMN_PLAYER_NAME = "PLAYER_NAME";
    public static final String COLUMN_SCORE = "SCORE";
    public static final String COLUMN_ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context,"player.db", null, 1);
    }

    // first time access database objectt create new database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + PLAYER_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_PLAYER_NAME + " TEXT," + COLUMN_SCORE + " INT)";

        db.execSQL(createTableStatement);

    }
    //called if version number change
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(PlayerModel playerModel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(COLUMN_PLAYER_NAME,playerModel.getName());
        cv.put(COLUMN_SCORE,playerModel.getScore());

        long insert = db.insert(PLAYER_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public List<PlayerModel> getEveryone(){
        List<PlayerModel> returnList=new ArrayList<>();

        String queryString="SELECT * FROM "+PLAYER_TABLE;

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString,null);

        if(cursor.moveToFirst()){
            do{
                int id=cursor.getInt(0);
                String playerName=cursor.getString(1);
                int score=cursor.getInt(2);

                PlayerModel newPlayer= new PlayerModel(playerName,score);
                returnList.add(newPlayer);

            }while(cursor.moveToNext());

        }
        else{

        }
        cursor.close();
        db.close();
        return returnList;
    }
}
