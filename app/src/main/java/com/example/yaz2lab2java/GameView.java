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

import androidx.core.content.ContextCompat;

import com.example.yaz2lab2java.LetterRect;

import java.util.ArrayList;

// View for game
class GameView extends View {
    // TODO: encapsulate LetterRect in levels
    // encapsulate game logic
    // make okcircle smart (if true than color green else red)
    // game logic in Game class(controler)

    ArrayList<LetterRect> LetterRectList = new ArrayList<LetterRect>();
    Controller controller;

    float deviceDensity;
    int screenW;
    int screenH;

    Paint paint = new Paint();
    TextPaint textPaint= new TextPaint();

    public GameView(Context context){
        super(context);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        Log.i("METRICS", metrics.toString());
        screenH = metrics.heightPixels;
        screenW = metrics.widthPixels;

        deviceDensity = getResources().getDisplayMetrics().density;
        LetterRect.density = this.deviceDensity;

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5*deviceDensity);

        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(16 * deviceDensity);

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
        controller = new Controller("ABC", deviceDensity);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() != MotionEvent.ACTION_DOWN ){
            return  true;
        }

        float x = event.getX();
        float y = event.getY();
        //path.addCircle(x,y,10*deviceDensity, Path.Direction.CW);
        Log.d("TOUCH", "X:" + x + ", Y:" + y);

        // letter circles
        for (int i = 0; i < Controller.subCircleList.size(); i++) {
            ControllerCircle cc = Controller.subCircleList.get(i);
            if (inCircle(cc,x,y)) {
                Controller.selectedLetters += cc.text;
                cc.paint.setColor(Color.CYAN);
                System.out.println(Controller.selectedLetters);
                invalidate();
            }
        }

        // ok circle
        if(inCircle(Controller.okCircle,x,y)){
            Controller.okCircle.paint.setColor(Color.GREEN);
            invalidate();
        }

        return true;
    }


    //restructure
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));

        //draw crossword
        for (int i = 0; i < LetterRectList.size(); i++) {
            LetterRect lr = LetterRectList.get(i);
            canvas.drawRect(lr.getRectangle(),LetterRect.paint);
            if (!lr.isVisible()){
                canvas.drawText(lr.getC(), lr.getCenterX(), lr.getCenterY(), LetterRect.textPaint);
            }
        }
        //draw ok circle
        ControllerCircle oc = Controller.okCircle;
        canvas.drawCircle(oc.center.x,oc.center.y,oc.radius,oc.paint);
        canvas.drawText(oc.text,oc.center.x,oc.center.y,textPaint);

        //draw sub circles
        for (int i = 0; i < Controller.subCircleList.size(); i++) {
            ControllerCircle c = Controller.subCircleList.get(i);
            canvas.drawCircle(c.center.x,c.center.y,c.radius,c.paint);
            // draw letters
            canvas.drawText(c.text,c.center.x,c.center.y,textPaint);
        }
        // draw selected letters

        canvas.drawText(controller.selectedLetters,controller.tp.x,controller.tp.y,textPaint);
    }


    // touch x touch y circle c
    private static boolean inCircle(ControllerCircle cc, float tx, float ty){
        // distance between two point
        double dist = Math.sqrt(Math.pow(cc.center.x - tx,2) + Math.pow(cc.center.y - ty,2));
        if (dist < cc.radius) {
            Log.d("INCIRCLE",cc.toString() + tx +","+ ty );
            return true;
        }
        Log.d("INCIRCLE", "OUT");
        return false;

    }

}