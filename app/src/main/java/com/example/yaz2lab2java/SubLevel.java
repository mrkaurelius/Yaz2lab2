package com.example.yaz2lab2java;

import java.util.ArrayList;
import java.util.List;

public class SubLevel {
    //TODO:
    // encapsulate LetterRect Here
    // encapsulate words in nested class
    // map strings to rects
    // read/write highest scores from file

    int highestScore = 0;
    //
    int level;

    String letters;
    List<Word> wordList = new ArrayList<Word>();


    public SubLevel(int level){
        this.level = level;

    }



    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        // do read/write
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
