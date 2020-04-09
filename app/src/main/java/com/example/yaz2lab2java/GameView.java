package com.example.yaz2lab2java;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

// View for game
class GameView extends View {

    //TODO: encapsulate LetterRect in levels
    // make okcircle smart (if true than color green else red)
    // game logic in Game class(controler)
    // this activity starts and ends or resume with one level
    // !!! Create Game with Control and Level (game has this classes as var)
    // Game have Controller not GameView

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


        Game game = new Game(0);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5*deviceDensity);

        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(16 * deviceDensity);

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
            canvas.drawRect(lr.getRectangle(),lr.getPaint());
            if (!lr.isVisible()){
                canvas.drawText(lr.getC(), lr.getCenterX(), lr.getCenterY(), lr.getTextPaint());
            }
        }
        //draw ok circle
        ControllerCircle oc = Controller.okCircle;
        canvas.drawCircle(oc.center.x,oc.center.y,oc.radius,oc.paint);
        canvas.drawText(oc.text,oc.center.x,oc.center.y,textPaint);
        ControllerCircle sc = Controller.scrambleCircle;
        canvas.drawCircle(sc.center.x,sc.center.y,sc.radius,sc.paint);
        canvas.drawText(sc.text,sc.center.x,sc.center.y,textPaint);

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