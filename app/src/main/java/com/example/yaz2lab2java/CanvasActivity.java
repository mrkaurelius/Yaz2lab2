package com.example.yaz2lab2java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new GameView(this));
    }
}




