package com.example.yaz2lab2java;

import java.util.ArrayList;

public class Level {

    //TODO:
    // encapsulate CrossWord, SubLevels here


    // literal level
    int level;
    public ArrayList<CrossWord> crossWords = new ArrayList<CrossWord>();

    public Level(int level){
        this.level = level;

    }
}
