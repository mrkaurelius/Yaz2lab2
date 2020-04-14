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
import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    //TODO: Orginanise Classes with subdirs(package)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: show highscore dinamically
        // TODO: set current level

        setHighScoreTextView();

        Button startCanvasButton = (Button) findViewById(R.id.startCanvas);
        Button resume = (Button) findViewById(R.id.resume);

        startCanvasButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                // start activity for result ??
                startActivity(intent);
            }
        });

        resume.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                // start activity for result ??
                // TODO: read data from file
                intent.putExtra("LEVEL", 1);
                intent.putExtra("SUBLEVEL", 1);
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
                tv.setText("Leve" + entry.getKey() +" "+ scores.getString("L1-0", ""));
                linearLayout.addView(tv);
        }





    }

}

