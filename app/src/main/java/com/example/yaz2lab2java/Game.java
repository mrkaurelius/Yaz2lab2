package com.example.yaz2lab2java;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    //TODO:
    // game logic here
    // one game one level

    //public ArrayList<Level> levelList = new ArrayList<Level>();

    static  float deviceDensity;

    SubLevel currentLevel;
    List<SubLevel> subLevelList = null;
    Controller controller = null;

    long levelStartTime;
    int wrongSubmits;

    public Game(int level, int subLevel, Context context){
        switch (level) {
            case 1:
                subLevelList =  InitialState.LEVEL_1.getSubLevels();
                break;
            case 2:
                subLevelList =  InitialState.LEVEL_2.getSubLevels();
                break;
            case 3:
                subLevelList =  InitialState.LEVEL_3.getSubLevels();
                break;
        }

        currentLevel = subLevelList.get(subLevel);
        currentLevel.context = context;
        currentLevel.initHighestScore();
        setResumeLevel();

        String letters = currentLevel.getLetters();
        levelStartTime = System.currentTimeMillis();
        // end current level controller string to Controller
        controller = new Controller(letters, deviceDensity);
    }

    public void setResumeLevel(){
        SharedPreferences scores = currentLevel.
                context.getSharedPreferences("ResumeLevel", Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = scores.edit();

        edit.putInt("level",currentLevel.level);
        edit.putInt("sublevel",currentLevel.subLevel);
        Log.d("RESUMELEVEL", "level: "+currentLevel.level+" sublevel: "+currentLevel.subLevel);
        edit.commit();
    }

    public void nextSubLevel(){
        if (currentLevel.subLevel < subLevelList.size() - 1){
            // level index
            // dirty !!
            Context c = currentLevel.context;
            currentLevel = subLevelList.get(currentLevel.subLevel + 1);
            currentLevel.context = c;
            currentLevel.initHighestScore();
            setResumeLevel();

            levelStartTime = System.currentTimeMillis();
            wrongSubmits = 0;

            controller = new Controller(currentLevel.letters, deviceDensity);
        }
    }

    public boolean checkLevelEnd(){
        if (currentLevel.subLevel < subLevelList.size() - 1){
            return false;
        }
        return true;
    }

    public boolean checkEndSubLevel(List<Word> wl){
        for (int i = 0; i < wl.size(); i++) {
            if (!wl.get(i).solved){
                return false;
            }
        }
        return true;
    }

    // redundant getter
    public Controller getController() {
        return controller;
    }

    public SubLevel getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(SubLevel currentLevel) {
        this.currentLevel = currentLevel;
    }
}
