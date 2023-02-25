package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OiaScreen extends AppCompatActivity {

    private ImageView previous;
    private ImageView next;
    private Button trip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akrotiri_screen);

        next = findViewById(R.id.nextbtn2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OiaScreen.this, AkrotiriScreen.class);
                startActivity(i);
            }
        });

        previous = findViewById(R.id.backbtn2);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OiaScreen.this, FiraScreen.class);
                startActivity(i);
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