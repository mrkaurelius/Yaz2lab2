package com.example.yaz2lab2java;

import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;

public class ControllerCircle {
    Point center = new Point();
    Paint paint = new Paint();
    String text;

    int radius;

    private float density;

    public ControllerCircle(Point p, int r,String text, int color, float density){
        center.x= p.x;
        center.y= p.y;
        center.x *= density;
        center.y *= density;
        radius = r * (int)density;
        paint.setColor(color);
        paint.setAntiAlias(true);
        this.text = text;
        this.density = density;

        Log.d("CC", this.toString());
    }

    @Override
    public String toString() {
        return "ControllerCircle{" +
                "center=" + center +
                ", paint=" + paint +
                ", text='" + text + '\'' +
                ", radius=" + radius +
                ", density=" + density +
                '}';
    }


}
