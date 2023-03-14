package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Akrotiri_TripScreen extends AppCompatActivity {

    private TextView tripDetails;
    private ImageView back_btn2;
    private Button menu_btn2, detailsBtn;
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

            detailsBtn = findViewById(R.id.detailsBtn);
            detailsBtn.setOnClickListener(view -> {
                database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);
                //String bookingSaved = database.getString("Booking Successful", null);
                Toast.makeText(Akrotiri_TripScreen.this, bookingDetails, Toast.LENGTH_SHORT).show();
            });

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
                overridePendingTransition(R.transition.slideleft,R.transition.slideright);
            }
        });
    }

    // Show menu tab on screen
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    // Perform action when menu item selected
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.contactMenu) {
            Intent i = new Intent(Akrotiri_TripScreen.this, ContactScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mainMenu) {
            Intent i = new Intent(Akrotiri_TripScreen.this, MenuScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.transportMenu) {
            Intent i = new Intent(Akrotiri_TripScreen.this, TransportScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.beachMenu) {
            Intent i = new Intent(Akrotiri_TripScreen.this, BeachScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tipsMenu) {
            Intent i = new Intent(Akrotiri_TripScreen.this, TipsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.adventureMenu) {
            Intent i = new Intent(Akrotiri_TripScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.todoMenu) {
            Intent i = new Intent(Akrotiri_TripScreen.this, MyToDoScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}