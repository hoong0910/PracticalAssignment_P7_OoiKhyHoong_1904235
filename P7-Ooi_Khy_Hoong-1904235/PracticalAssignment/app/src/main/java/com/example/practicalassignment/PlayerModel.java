package com.example.practicalassignment;

public class PlayerModel {
    private String name;
    private int score;



    public PlayerModel(String name,int score){
        this.name=name;
        this.score=score;
    }

    public PlayerModel(){
    }

    @Override
    public String toString() {
        return "PlayerModel{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
