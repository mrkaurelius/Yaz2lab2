package com.example.yaz2lab2java;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

// View for game
class GameView extends View {

    //TODO: encapsulate LetterRect in levels
    // make okcircle smart (if true than color green else red)
    // game logic in Game class(controler)
    // this activity starts and ends or resume with one level
    // !!! Create Game with Control and Level (game has this classes as var)
    // Game have Controller not GameView

    // ArrayList<LetterRect> LetterRectList = new ArrayList<LetterRect>();
    // Controller controller;

    float deviceDensity;

    static  Paint paint = new Paint();
    static  TextPaint textPaint= new TextPaint();

    Game game;
    boolean endSublevel=false;
    boolean endLevel=false;

    public GameView(Context context){
        super(context);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        Log.i("METRICS", metrics.toString());

        deviceDensity = getResources().getDisplayMetrics().density;
        LetterRect.density = this.deviceDensity;
        Game.deviceDensity = deviceDensity;

        setGameViewColors();
        game = new Game(1, 0);

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
        final Controller ctrl = game.getController();

        // letter circles
        for (int i = 0; i < ctrl.subCircleList.size(); i++) {
            ControllerCircle cc = ctrl.subCircleList.get(i);
            if (inCircle(cc,x,y)) {
                Controller.selectedLetters += cc.text;
                cc.paint.setColor(Color.CYAN);
                System.out.println(Controller.selectedLetters);
                invalidate();
            }
        }

        // ok circle
        if(inCircle(ctrl.okCircle,x,y)){
            // if nothing selected don't proceed
            // selected letters
            String sl = Controller.selectedLetters;
            if(Controller.selectedLetters.length() == 0) return  true;

            // best practices ???

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void  run() {
                    // dirty !
                    if (ctrl.okCircle == null || ctrl.subCircleList == null) return;
                    ctrl.okCircle.paint.setColor(Color.GRAY);
                    for (int i = 0; i < ctrl.subCircleList.size(); i++) {
                        ControllerCircle c = ctrl.subCircleList.get(i);
                        c.paint.setColor(Color.MAGENTA);
                    }
                    invalidate();
                }
            }, 500);

            // search in level worldlist
            List<Word> wl = game.currentLevel.getWordList();
            for (int i = 0; i < wl.size(); i++) {
                Word w = wl.get(i);
                if(w.word.equals(sl)){
                    ctrl.okCircle.paint.setColor(Color.GREEN);
                    Controller.selectedLetters = "";
                    w.solved = true;
                    List<LetterRect> lr =  w.LetterRects;
                    for (int j = 0; j < lr.size(); j++) {
                        lr.get(j).setVisible(true);
                        //TODO: end game and give score
                        // change game sub level with smart way
                        // if sublevels finished go back main activity
                        if (Game.checkFinish(wl)){
                            Log.d("GAME", "Sublevel ended");
                            endSublevel = true;
                            endLevel = game.endSubLevel();

                            if (endLevel){
                                Log.d("GAME", "Level ended");
                                // end activity

                            }
                            invalidate();
                            return true;
                            // game = new Game(1,1);
                        }
                    }
                    invalidate();
                    return true;

                }
            }

            Controller.selectedLetters = "";
            ctrl.okCircle.paint.setColor(Color.RED);
            invalidate();
        }


        return true;
    }

    //restructure
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        // BURADA KALDIM
        if (endLevel){
            // draw end level stuff end activity
            Activity activity = (Activity) getContext();
            activity.finish();
        }


        if (endSublevel){
            // draw end sublevel stuff

            canvas.drawColor(Color.WHITE);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void  run() {
                    // dirty !
                    invalidate();
                    endSublevel = false;
                }
            }, 3000);
            return;
        }



        //draw crossword
        drawSubLevel(canvas, game.getCurrentLevel());

        //draw ok circle
        // !!! Oxymoron here static there settergetter
        Controller ctrl = game.getController();
        ControllerCircle oc = ctrl.okCircle;
        canvas.drawCircle(oc.center.x,oc.center.y,oc.radius,oc.paint);
        canvas.drawText(oc.text,oc.center.x,oc.center.y,textPaint);
        ControllerCircle sc = ctrl.scrambleCircle;
        canvas.drawCircle(sc.center.x,sc.center.y,sc.radius,sc.paint);
        canvas.drawText(sc.text,sc.center.x,sc.center.y,textPaint);

        //draw sub circles
        for (int i = 0; i < ctrl.subCircleList.size(); i++) {
            ControllerCircle c = ctrl.subCircleList.get(i);
            canvas.drawCircle(c.center.x,c.center.y,c.radius,c.paint);
            // draw letters
            canvas.drawText(c.text,c.center.x,c.center.y,textPaint);
        }

        // draw selected letters
        Controller c = game.getController();
        canvas.drawText(c.selectedLetters,c.tp.x,c.tp.y,textPaint);
    }

    public static void drawSubLevelIntro (Canvas canvas){
    }

    public static void drawSubLevel(Canvas canvas, SubLevel subLevel){
        List<Word> wordList = subLevel.getWordList();

        for (int i = 0; i < wordList.size(); i++) {
            List<LetterRect> rList = wordList.get(i).getLetterRects();
            for (int j = 0; j < rList.size(); j++) {
                LetterRect r = rList.get(j);
                canvas.drawRect(r.getRectangle(),r.paint);
                if (r.isVisible()){
                    canvas.drawText(r.getC(), r.getCenterX(), r.getCenterY(), r.getTextPaint());
                }
            }
        }
        // TODO: draw score and time
    }

    public void setGameViewColors(){
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5*deviceDensity);

        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(16 * deviceDensity);
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