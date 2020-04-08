package com.example.yaz2lab2java;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.Log;

class LetterRect{
    // configure

    private static int EDGE_SIZE = 30;
    private static int MARGIN = 20;

    private int x;
    private int y;
    private char c;
    private boolean visible;

    private Rect rectangle;

    public static float density;
    public static Paint paint = new Paint();
    public static TextPaint textPaint= new TextPaint();

    public LetterRect(int x, int y, char c){
        this.x = x;
        this.y = y;
        this.c = c;

        int top = MARGIN + EDGE_SIZE * y;
        int left = MARGIN + EDGE_SIZE * x ;
        int bottom = top + EDGE_SIZE;
        int right = left + EDGE_SIZE;
        this.visible = false;
        top *= density;
        left *= density;
        bottom *= density;
        right *= density;

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5*density);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(16 * density);

        this.rectangle = new Rect(left,top,right,bottom);

        Log.d("GFX", rectangle.toString());

    }

    public Rect getRectangle(){ return  this.rectangle; }

    public int getCenterX(){ return (this.rectangle.left + this.rectangle.right)/2; }

    public int getCenterY(){ return (this.rectangle.top + this.rectangle.bottom)/2; }

    public String getC(){ return String.valueOf(this.c); }

    public boolean isVisible() { return visible; }

    public void setVisible(boolean visible) { this.visible = visible; }
}