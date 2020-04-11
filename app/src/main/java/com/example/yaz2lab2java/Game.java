package com.example.yaz2lab2java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    //TODO:
    // game logic here
    // one game one level

    //public ArrayList<Level> levelList = new ArrayList<Level>();

    long elapsedTime;
    int wrongSubmits;
    static  float deviceDensity;

    SubLevel currentLevel;
    List<SubLevel> subLevelList = null;
    Controller controller = null;



    public Game(int level, int subLevel){
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

        subLevelList =  InitialState.LEVEL_1.getSubLevels();
        currentLevel = subLevelList.get(subLevel);
        String letters = currentLevel.getLetters();

        // end current level controller string to Controller
        controller = new Controller(letters, deviceDensity);
    }

    public boolean endSubLevel(){
        // calc score wrong submits, time
        // basepoint 100
        // wrong submit 5
        // 1 sec 0.5 minux
        // TODO: calc score
        int score = 0;
        if(score > currentLevel.getHighestScore()){
            currentLevel.setHighestScore(score);
        }

        if (currentLevel.level < subLevelList.size() - 1){
            // level index
            currentLevel = subLevelList.get(currentLevel.level + 1);

            controller = new Controller(currentLevel.letters, deviceDensity);
            return false;
        }
        return true;
    }

    public static boolean checkFinish(List<Word> wl){
        for (int i = 0; i < wl.size(); i++) {
            if (wl.get(i).solved == false){
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
