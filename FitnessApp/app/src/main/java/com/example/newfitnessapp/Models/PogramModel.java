package com.example.newfitnessapp.Models;

public class PogramModel {
    private String Name;
    private String Img;

    public PogramModel(String name, String img) {
        Name = name;
        Img = img;
    }

    public String getName() {
        return Name;
    }

    public String getImg() {
        return Img;
    }
}
