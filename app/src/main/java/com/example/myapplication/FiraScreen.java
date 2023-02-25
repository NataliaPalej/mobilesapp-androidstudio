package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FiraScreen extends AppCompatActivity {

    private ImageView previous;
    private ImageView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fira_screen);

        next = findViewById(R.id.nextbtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FiraScreen.this, OiaScreen.class);
                startActivity(i);
            }
        });

        previous = findViewById(R.id.backbtn);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FiraScreen.this, AdventureScreen.class);
                startActivity(i);
            }
        });
    }
}