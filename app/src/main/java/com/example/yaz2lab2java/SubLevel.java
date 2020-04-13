package com.example.yaz2lab2java;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.egl.EGLDisplay;

public class SubLevel {
    //TODO:
    // read/write highest scores from file

    int highestScore = 0;

    int level;
    int subLevel;
    String letters;
    List<Word> wordList = new ArrayList<Word>();
    Context context;

    public SubLevel(int level, int subLevel){
        this.level = level;
        this.subLevel = subLevel;
        // set high scores here
    }

    public void initHighestScore() {
        SharedPreferences scores = context.getSharedPreferences("HighScores", context.MODE_PRIVATE);
        String s = "L"+this.level+"-"+this.subLevel;

        String hs = scores.getString(s, "0");
        Log.d("HIGHSCORE", "key: "+s+" highscore: " + Integer.valueOf(hs));
        highestScore = Integer.valueOf(hs);
    }

    public void setHighestScore(Context context, int highestScore) {
        // do read/write
        Log.d("HIGHSCORE", "highscore setted");
        SharedPreferences scores = context.getSharedPreferences("HighScores", Context.MODE_PRIVATE);

        SharedPreferences.Editor edit = scores.edit();
        String s = "L"+this.level+"-"+this.subLevel;
        String hs = String.valueOf(highestScore);
        edit.putString(s, hs);
        edit.commit();
        this.highestScore = highestScore;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

}

class Word{

    public List<LetterRect> LetterRects = new ArrayList<LetterRect>();
    String word;
    boolean solved = false;

    public  Word(String word){
        this.word = word;
    }



    public List<LetterRect> getLetterRects() {
        return LetterRects;
    }

    public void setLetterRects(List<LetterRect> letterRects) {
        LetterRects = letterRects;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
