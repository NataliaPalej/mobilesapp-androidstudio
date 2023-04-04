package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Akrotiri_TripScreen extends AppCompatActivity {

    private ViewFlipper flipImg;
    private SharedPreferences database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akrotiri_trip_screen);

        TextView tripDetails = findViewById(R.id.tripDetails);

        try{
            Bundle extras = getIntent().getExtras();
            String date = extras.getString("TextToSend");
            String people = extras.getString("TextToSend2");
            String email = extras.getString("TextToSend3");
            String extra = extras.getString("TextToSend4");

            String bookingDetails = "Date: " + date + "\nPeople: " + people + "\nEmail: " + email + "\nExtra Info: " + extra;

            tripDetails.setText(bookingDetails);

            Button detailsBtn = findViewById(R.id.detailsBtn);
            detailsBtn.setOnClickListener(view -> {
                database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);
                //String bookingSaved = database.getString("Booking Successful", null);
                Toast.makeText(Akrotiri_TripScreen.this, bookingDetails, Toast.LENGTH_SHORT).show();
            });

        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        Button menu_btn2 = findViewById(R.id.menu_btn2);
        menu_btn2.setOnClickListener(view -> {
            Intent i = new Intent(Akrotiri_TripScreen.this, MenuScreen.class);
            startActivity(i);
        });
        ImageView back_btn2 = findViewById(R.id.back_btn2);
        back_btn2.setOnClickListener(view -> {
            Intent i = new Intent(Akrotiri_TripScreen.this, AkrotiriScreen.class);
            startActivity(i);
            overridePendingTransition(R.transition.slideleft,R.transition.slideright);
        });

        flipImg = findViewById(R.id.flipImg);
        ImageView nextImg = findViewById(R.id.nextImg);
        ImageView backImg = findViewById(R.id.backImg);

        nextImg.setOnClickListener(v -> {
            flipImg.setInAnimation(Akrotiri_TripScreen.this,R.anim.slide_in_left);
            flipImg.setOutAnimation(Akrotiri_TripScreen.this,R.anim.slide_out_right);
            flipImg.showNext();
        });

        backImg.setOnClickListener(v -> {
            flipImg.setInAnimation(Akrotiri_TripScreen.this,R.anim.slide_in_right);
            flipImg.setOutAnimation(Akrotiri_TripScreen.this,R.anim.slide_out_left);
            flipImg.showPrevious();
        });
    }

    // Show menu tab on screen
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        MenuItem timeMenuItem = menu.findItem(R.id.currentTimeMenu);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                String currentTime = dateFormat.format(new Date());
                timeMenuItem.setTitle(currentTime);
                handler.postDelayed(this, 1000);
            }
        });
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
        if (id == R.id.todoMenu) {
            Intent i = new Intent(Akrotiri_TripScreen.this, MyToDoScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.restaurantsMenu){
            Intent i = new Intent(Akrotiri_TripScreen.this, RestaurantsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.attractionsMenu){
            Intent i = new Intent(Akrotiri_TripScreen.this, AttractionsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuVulcano) {
            Intent i = new Intent(Akrotiri_TripScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuFira){
            Intent i = new Intent(Akrotiri_TripScreen.this, FiraScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuOia){
            Intent i = new Intent(Akrotiri_TripScreen.this, OiaScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuAkrotiri){
            Intent i = new Intent(Akrotiri_TripScreen.this, AkrotiriScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}