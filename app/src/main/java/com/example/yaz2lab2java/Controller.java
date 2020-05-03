package com.example.yaz2lab2java;

import android.graphics.Color;
import android.graphics.Point;

import java.util.ArrayList;

// omit setter getters

public class Controller {
    //TODO:
    // access modifieres !!!
    // after all letters selected automaticly evaluate in game logic

    static String selectedLetters = "";
    ControllerCircle okCircle;
    ControllerCircle scrambleCircle;
    ArrayList<ControllerCircle> subCircleList = new ArrayList<ControllerCircle>();
    // text point
    Point tp = new Point();

    int letterCount;

    //TODO:
    public static void scrambleSubCircles(){

    }


    public Controller(String letters, float density){
        // dpi
        letterCount = letters.length();
        Point c = new Point();
        c.x = 205;
        c.y = 450;

        // TODO: add letter margin
        tp.x = (int)(195 * density);
        tp.y = (int)(350 * density);

        int r = 160;
        okCircle = new ControllerCircle(c,r/2,"OK",Color.GRAY,density);
        c.x = 80;
        scrambleCircle = new ControllerCircle(c,(r/3),"KAR",Color.YELLOW,density);

        // width in dpi
        int w = 420;
        // left right margin
        int lrmargin = 0;
        //circle line
        int cline = w - 2*lrmargin;
        c.x = lrmargin;
        for (int i = 0; i < letters.length(); i++) {
            // TODO:
            // change alignment
            c.x += cline / (letters.length() + 1) ;
            c.y = 550;
            //could be easier
            String s = String.valueOf(letters.charAt(i));
            ControllerCircle circle = new ControllerCircle(c,r/4,s,Color.MAGENTA,density);
            subCircleList.add(circle);
        }

    }

}
