package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TransportScreen extends AppCompatActivity {

    private Button backbtn3;
    private ImageView buggyImage;
    private ImageView scooterImage;
    private ImageView carImage;
    private ImageView quadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_screen);

        // Change buggy image on click
        buggyImage = findViewById(R.id.buggyimage);
        buggyImage.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view){
              buggyImage.setImageResource(R.drawable.buggy2);
          }
        });

        // Change car image on click
        carImage = findViewById(R.id.carImage);
        carImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                carImage.setImageResource(R.drawable.car2);
            }
        });

        // Change scooter image on click
        scooterImage = findViewById(R.id.scooterImage);
        scooterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                scooterImage.setImageResource(R.drawable.scooter2);
            }
        });

        // Change quad image on click
        quadImage = findViewById(R.id.quadImage);
        quadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                quadImage.setImageResource(R.drawable.quad2);
            }
        });

        // Back Button
        backbtn3 = findViewById(R.id.backbtn3);
        backbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TransportScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });
    }
}