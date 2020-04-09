package com.example.yaz2lab2java;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.TextPaint;

import java.util.ArrayList;

import javax.security.auth.Subject;

// omit setter getters

public class Controller {
    //TODO:
    // access modifieres !!!
    // after all letters selected automaticly evaluate

    public static  String selectedLetters = "";
    // text point
    Point tp = new Point();

    public static  ControllerCircle okCircle;
    public static ArrayList<ControllerCircle> subCircleList = new ArrayList<ControllerCircle>();

    public Controller(String letters, float density){
        // dpi
        Point c = new Point();
        c.x = 205;
        c.y = 450;

        // TODO: add letter margin
        tp.x = (int)(195 * density);
        tp.y = (int)(350 * density);

        int r = 160;
        okCircle = new ControllerCircle(c,r/2,"OK",Color.DKGRAY,density);

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
            c.y = 550;
            //could be easier
            String s = String.valueOf(letters.charAt(i));
            ControllerCircle circle = new ControllerCircle(c,r/4,s,Color.MAGENTA,density);
            subCircleList.add(circle);
        }

    }

}
