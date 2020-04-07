package com.example.yaz2lab2java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

//TODO:
// adjust graphics to device screen
// learn screen, graphic mechanics
// desgin levels
// design game logic

//TODO: Controller
// if controller hit answer than redrawn corssword
// gesture detection
// controller
// inner circle ok outer cicrle letters
// , use colors for letters and upper text screen for word

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new GameView(this));
    }
}

// View for game
class GameView extends View {
    Path path = new Path();
    Paint paint = new Paint();
    TextPaint textPaint= new TextPaint();

    //Rect rectangle = new Rect();

    ArrayList<LetterRect> LetterRectList = new ArrayList<LetterRect>();

    public GameView(Context context){
        super(context);

        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);

        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(16 * getResources().getDisplayMetrics().density);

        //rectangle = new Rect( 50, 50, 800,800);
        LetterRectList.add(new LetterRect(0,0,'S'));
        LetterRectList.add(new LetterRect(1,0,'E'));
        LetterRectList.add(new LetterRect(2,0,'R'));
        LetterRectList.add(new LetterRect(3,0,'R'));
        LetterRectList.add(new LetterRect(4,0,'A'));
        LetterRectList.add(new LetterRect(0,1,'K'));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //System.out.println();
        float x = event.getX();
        float y = event.getY();
        path.addCircle(x,y,10, Path.Direction.CW);
        Log.d("TOUCH", "X:"+x+", Y:"+y);
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
        //Log.d("DRAW", "Draw Runned");
        //canvas.drawRect(100, 100, 200, 200, paint);
        //canvas.drawRect(rectangle, paint);
        for (int i = 0; i < LetterRectList.size(); i++) {
            LetterRect lr = LetterRectList.get(i);
            canvas.drawRect(lr.getRectangle(),paint);
            if (!lr.isVisible()){
                canvas.drawText(lr.getC(), lr.getCenterX(), lr.getCenterY(), textPaint);
            }

        }
    }

}

class LetterRect{
    // configure

    private static int EDGE_SIZE = 150;
    private static int MARGIN = 100;

    private int x;
    private int y;
    private char c;
    private boolean visible;

    private Rect rectangle;

    public LetterRect(int x, int y, char c){
        this.x = x;
        this.y = y;
        this.c = c;

        int top = MARGIN + EDGE_SIZE * y;
        int left = MARGIN + EDGE_SIZE * x ;
        int bottom = top + EDGE_SIZE;
        int right = left + EDGE_SIZE;
        this.visible = false;

        this.rectangle = new Rect(left,top,right,bottom);

        Log.d("GFX", rectangle.toString());

    }

    public Rect getRectangle(){
        return  this.rectangle;
    }

    public int getCenterX(){
        return (this.rectangle.left + this.rectangle.right)/2;

    }

    public int getCenterY(){
        return (this.rectangle.top + this.rectangle.bottom)/2;
    }

    public String getC(){
        return String.valueOf(this.c);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}

class Controller {

}