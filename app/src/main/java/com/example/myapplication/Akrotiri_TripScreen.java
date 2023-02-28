package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Akrotiri_TripScreen extends AppCompatActivity {

    private TextView tripDetails;
    private ImageView back_btn2;
    private Button menu_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akrotiri_trip_screen);

        tripDetails = findViewById(R.id.tripDetails);

        try{
            Bundle extras = getIntent().getExtras();
            String text1 = extras.getString("TextToSend");
            //String text2 = extras.getString("TextToSend");
            //String text3 = extras.getString("TextToSend");
            //String text4 = extras.getString("TextToSend");
            tripDetails.setText(text1);
            //tripDetails.setText(text2);
            //tripDetails.setText(text3);
            //tripDetails.setText(text4);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        menu_btn2 = findViewById(R.id.menu_btn2);
        menu_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Akrotiri_TripScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });
        back_btn2 = findViewById(R.id.back_btn2);
        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Akrotiri_TripScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });

    }
}