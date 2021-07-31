package com.example.newfitnessapp.Models;

public class Challenges_Model {
    private String Challenge_Img;
    private String Challenge_Type;
    private String Challenge_Desc;

    public Challenges_Model(String challenge_Img, String challenge_Type, String challenge_Desc) {
        Challenge_Img = challenge_Img;
        Challenge_Type = challenge_Type;
        Challenge_Desc = challenge_Desc;
    }

    public String getChallenge_Img() {
        return Challenge_Img;
    }

    public String getChallenge_Type() {
        return Challenge_Type;
    }

    public String getChallenge_Desc() {
        return Challenge_Desc;
    }
}
