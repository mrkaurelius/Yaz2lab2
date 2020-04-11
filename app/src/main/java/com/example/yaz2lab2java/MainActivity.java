package com.example.yaz2lab2java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //TODO: Orginanise Classes with subdirs(package)

    //TODO: Activity Life Cycle

    //TODO: Game Menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startCanvasButton = (Button) findViewById(R.id.startCanvas);

        startCanvasButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                // start activity for result ??
                startActivity(intent);
            }
        });

    }


}

