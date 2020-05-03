package com.example.yaz2lab2java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Map;

public class HighScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        setHighScoreTextView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setHighScoreTextView();
    }


    public void setHighScoreTextView(){
        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.highScoreLayout);
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
