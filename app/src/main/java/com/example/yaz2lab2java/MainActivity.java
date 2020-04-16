package com.example.yaz2lab2java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //TODO: Orginanise Classes with subdirs(package)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: show highscore dinamically
        // TODO: set current level

        setHighScoreTextView();

        Button level1 = (Button) findViewById(R.id.level1);
        Button level2 = (Button) findViewById(R.id.level2);
        Button level3 = (Button) findViewById(R.id.level3);

        Button resume = (Button) findViewById(R.id.resume);

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        setHighScoreTextView();

        Log.d("ACTIVITY", "onResume worked");

    }

    public void setHighScoreTextView(){

        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.linearLayout);
        linearLayout.removeAllViews();

        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        SharedPreferences scores = getSharedPreferences("HighScores", MODE_PRIVATE);

        Map<String, ?> map = scores.getAll();

        for (Map.Entry<String, ?> entry : map.entrySet()) {
                Log.d("SH_MAP", entry.getKey() + ": " + entry.getValue().toString());
                TextView tv = new TextView(this);
                tv.setLayoutParams(lparams);
                tv.setText("Leve" + entry.getKey() +" "+ scores.getString(entry.getKey(), ""));
                linearLayout.addView(tv);
        }


    }

}

