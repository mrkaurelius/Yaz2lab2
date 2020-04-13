package com.example.yaz2lab2java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //TODO: Orginanise Classes with subdirs(package)

    //TODO: Game Menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set sharedvalues
        SharedPreferences scores = getSharedPreferences("HighScores", MODE_PRIVATE);

        TextView sc2 = (TextView) findViewById(R.id.textView2);
        TextView sc3 = (TextView) findViewById(R.id.textView3);

        sc2.setText("Level 1, 0 " + scores.getString("L1-0", ""));
        sc3.setText("Level 1, 1 " + scores.getString("L1-1", ""));


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
        SharedPreferences scores = getSharedPreferences("HighScores", MODE_PRIVATE);

        TextView sc2 = (TextView) findViewById(R.id.textView2);
        TextView sc3 = (TextView) findViewById(R.id.textView3);

        sc2.setText("Level 1, 0 " + scores.getString("L1-0", ""));
        sc3.setText("Level 1, 1 " + scores.getString("L1-1", ""));

        Log.d("ACTIVITY", "onResume worked");

    }
}

