package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OiaScreen extends AppCompatActivity {

    private ImageView previous, next;
    private Button trip, hoteldelta, hotelpersa, hoteloiamare, hotelsecret;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akrotiri_screen);

        next = findViewById(R.id.next2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OiaScreen.this, AkrotiriScreen.class);
                startActivity(i);
            }
        });

        previous = findViewById(R.id.back2);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OiaScreen.this, FiraScreen.class);
                startActivity(i);
            }
        });

        hoteldelta = findViewById(R.id.hoteldelta_btn);
        hoteldelta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("https://tinyurl.com/2x9ap3y5");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        hoteloiamare = findViewById(R.id.hoteloiamare_btn);
        hoteloiamare.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("https://tinyurl.com/3rfthr98");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        hotelpersa = findViewById(R.id.hotelpersa_btn);
        hotelpersa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://tinyurl.com/pavdp8eu");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        hotelsecret = findViewById(R.id.hotelsecret_btn);
        hotelsecret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://tinyurl.com/2dhhexuy");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        trip = findViewById(R.id.firaoiatrip);
        trip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.viator.com/tours/Santorini/Santorini-Day-trip-with-Bus-tour-and-Boat-tour/d959-116941P64");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}