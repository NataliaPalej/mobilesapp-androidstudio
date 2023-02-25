package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdventureScreen extends AppCompatActivity {

    private ImageView back;
    private ImageView next;
    private Button bookTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adventure_screen);

        // Back Button
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdventureScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });

        next = findViewById(R.id.next);
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