package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Akrotiri_TripScreen extends AppCompatActivity {

    private TextView tripDetails;
    private ImageView back_btn2;
    private Button menu_btn2;
    private SharedPreferences database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akrotiri_trip_screen);

        tripDetails = findViewById(R.id.tripDetails);

        try{
            Bundle extras = getIntent().getExtras();
            String date = extras.getString("TextToSend");
            String people = extras.getString("TextToSend2");
            String email = extras.getString("TextToSend3");
            String extra = extras.getString("TextToSend4");

            String bookingDetails = "Date: " + date + "\nPeople: " + people + "\nEmail: " + email + "\nExtra Info: " + extra;

            tripDetails.setText(bookingDetails);

            // show saved details on another screen
            // if wont work, need to create a button that will show the detials on click
            database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);
            String bookingSaved = database.getString("Booking Successful", null);
            Toast.makeText(Akrotiri_TripScreen.this, bookingSaved, Toast.LENGTH_SHORT).show();

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
                Intent i = new Intent(Akrotiri_TripScreen.this, AkrotiriScreen.class);
                startActivity(i);
            }
        });

    }
}