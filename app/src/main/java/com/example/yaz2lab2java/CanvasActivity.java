package com.example.yaz2lab2java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;


//TODO:
// adjusting screen scale omitted ! (retry if have time)
// try density
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
    // pas intent data



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getIntent().hasExtra("LEVEL") && getIntent().hasExtra("SUBLEVEL")){
            int level = getIntent().getIntExtra("LEVEL",1);
            int subLevel = getIntent().getIntExtra("SUBLEVEL",0);
            Log.d("CANVASCREATE", "level "+level+", sublevel: "+subLevel);

            setContentView(new GameView(this,level,subLevel));
        } else {
            setContentView(new GameView(this));
        }

    }

}




