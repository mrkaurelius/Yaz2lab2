package com.example.yaz2lab2java;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.ArrayList;

import javax.security.auth.Subject;

// omit setter getters

public class Controller {
    //TODO:
    // h 4/1 w 1/1
    // !! encapsulate all circles
    // access modifieres !!!

    String selectedLetters;
    String controllerLetters;
    Point center = new Point();


    public static  ControllerCircle okCircle;
    public static ArrayList<ControllerCircle> subCircleList = new ArrayList<ControllerCircle>();

    public Controller(String letters, float density){
        // dpi
        center.x = 205;
        center.y = 400;

        int r = 160;
        okCircle = new ControllerCircle(center,r/2,"OK",Color.GREEN,density);

        Point c = new Point();
        // width in dpi
        int w = 410;
        // left right margin
        int lrmargin = 10;
        //circle line
        int cline = w - 2*lrmargin;
        c.x = lrmargin;
        for (int i = 0; i < letters.length(); i++) {
            // TODO:
            // change alignment
            c.x += cline / (letters.length() + 1) ;
            c.y = 500;
            //could be easier
            String s = String.valueOf(letters.charAt(i));
            ControllerCircle circle = new ControllerCircle(c,r/4,s,Color.BLACK,density);
            subCircleList.add(circle);
        }

    }

}
