package com.example.newfitnessapp.Models;

public class ExerciseModel {
    String Name;
    String ImagePath;

    public ExerciseModel(String name, String imagePath) {
        Name = name;
        ImagePath = imagePath;
    }

    public String getName() {
        return Name;
    }

    public String getImagePath() {
        return ImagePath;
    }
}
