package com.example.yaz2lab2java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //TODO: Orginanise Classes with subdirs(package)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: show highscore dinamically
        // TODO: set current level

        Button level1 = (Button) findViewById(R.id.level1);
        Button level2 = (Button) findViewById(R.id.level2);
        Button level3 = (Button) findViewById(R.id.level3);

        Button resume = (Button) findViewById(R.id.resume);
        Button highScore = (Button) findViewById(R.id.highscore);
        Button goLevel = (Button) findViewById(R.id.golevel);

        level1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                // start activity for result ??
                startActivity(intent);
            }
        });

        level2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                intent.putExtra("LEVEL", 2);
                intent.putExtra("SUBLEVEL", 0);
                startActivity(intent);
            }
        });
        level3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                intent.putExtra("LEVEL", 3);
                intent.putExtra("SUBLEVEL", 0);
                startActivity(intent);
            }
        });

        resume.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                // start activity for result ??
                // TODO: read data from shared
                SharedPreferences resume = getSharedPreferences("ResumeLevel", MODE_PRIVATE);
                int level = resume.getInt("level",1);
                int subLevel = resume.getInt("sublevel",0);

                intent.putExtra("LEVEL", level);
                intent.putExtra("SUBLEVEL", subLevel);
                startActivity(intent);
            }
        });

        highScore.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HighScore.class);
                startActivity(intent);
            }
        });

        goLevel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                //read from input
                EditText levelEdit = (EditText) findViewById(R.id.level);
                EditText subLevelEdit = (EditText) findViewById(R.id.sublevel);

                if ((levelEdit.getText().toString().length() > 0 && subLevelEdit.getText().toString().length() > 0)){
                    int level = Integer.parseInt(levelEdit.getText().toString());
                    int subLevel = Integer.parseInt(subLevelEdit.getText().toString());
                    if (level > 3 || subLevel > 5){
                        Toast.makeText(MainActivity.this, "Level 1-3 Sublevel 0-5 arası olabilir",
                                Toast.LENGTH_LONG).show();
                    } else {
                        intent.putExtra("LEVEL", level);
                        intent.putExtra("SUBLEVEL", subLevel);
                        startActivity(intent);
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Level ve Sublevel boş olmamalı",
                            Toast.LENGTH_LONG).show();
                }


            }
        });


    }

}