package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdventureScreen extends AppCompatActivity {

    private Button backbtn1;
    private Button next;
    private Button bookTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_screen);

        // Back Button
        backbtn1 = findViewById(R.id.backbtn1);
        backbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdventureScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });

        next = findViewById(R.id.backbtn1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdventureScreen.this, FiraScreen.class);
                startActivity(i);
            }
        });

        // Open link
        bookTrip = findViewById(R.id.volcanotrip);
        bookTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.viator.com/tours/Santorini/Santorini-Volcanic-Islands-Cruise-Volcano-Hot-Springs-and-Thirassia/d959-21977P13");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }



        });
    }
}