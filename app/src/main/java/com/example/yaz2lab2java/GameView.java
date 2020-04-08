package com.example.yaz2lab2java;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.yaz2lab2java.LetterRect;

import java.util.ArrayList;

// View for game
class GameView extends View {
    // TODO: encapsulate LetterRect in levels
    ArrayList<LetterRect> LetterRectList = new ArrayList<LetterRect>();
    Controller controller;

    float deviceDensity;
    int screenW;
    int screenH;

    Paint paint = new Paint();
    TextPaint textPaint= new TextPaint();
    Path path = new Path();

    public GameView(Context context){
        super(context);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        Log.i("METRICS", metrics.toString());
        screenH = metrics.heightPixels;
        screenW = metrics.widthPixels;

        deviceDensity = getResources().getDisplayMetrics().density;
        LetterRect.density = this.deviceDensity;

        // crossword
        LetterRectList.add(new LetterRect(0,0,'S'));
        LetterRectList.add(new LetterRect(1,0,'E'));
        LetterRectList.add(new LetterRect(2,0,'R'));
        LetterRectList.add(new LetterRect(3,0,'R'));
        LetterRectList.add(new LetterRect(4,0,'A'));
        LetterRectList.add(new LetterRect(0,1,'K'));
        LetterRectList.add(new LetterRect(0,2,'U'));
        LetterRectList.add(new LetterRect(0,3,'M'));
        LetterRectList.add(new LetterRect(0,4,'R'));
        LetterRectList.add(new LetterRect(0,5,'U'));

        // controller
        int letterCircleCount = 3;
        controller = new Controller("AAAAA", deviceDensity);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // calculate if touch in circle

        float x = event.getX();
        float y = event.getY();
        //path.addCircle(x,y,10*deviceDensity, Path.Direction.CW);
        Log.d("TOUCH", "X:"+x+", Y:"+y);
        for (int i = 0; i < Controller.subCircleList.size(); i++) {
            ControllerCircle cc = Controller.subCircleList.get(i);
            // TODO:
            // check if touch in radius
            // BURADA KALDIM
            if (true) {
                cc.paint.setColor(Color.MAGENTA);
            }
        }

        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5*deviceDensity);

        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(16 * deviceDensity);

        canvas.drawPath(path,paint);

        for (int i = 0; i < LetterRectList.size(); i++) {
            LetterRect lr = LetterRectList.get(i);
            canvas.drawRect(lr.getRectangle(),LetterRect.paint);
            if (!lr.isVisible()){
                canvas.drawText(lr.getC(), lr.getCenterX(), lr.getCenterY(), LetterRect.textPaint);
            }


        }

        //draw main circle
        ControllerCircle oc = Controller.okCircle;

        canvas.drawCircle(oc.center.x,oc.center.y,oc.radius,oc.paint);

        for (int i = 0; i < Controller.subCircleList.size(); i++) {
            ControllerCircle c = Controller.subCircleList.get(i);
            canvas.drawCircle(c.center.x,c.center.y,c.radius,c.paint);
        }

        // draw ok circle

        // draw sub circles

        // if touch event point and letter origin diff  < radius than touched

    }

}