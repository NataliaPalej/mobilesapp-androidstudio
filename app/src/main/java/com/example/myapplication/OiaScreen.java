package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OiaScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oia_screen);

        ImageView next = findViewById(R.id.next2);
        next.setOnClickListener(view -> {
            Intent i = new Intent(OiaScreen.this, AkrotiriScreen.class);
            startActivity(i);
            overridePendingTransition(R.transition.slideinright,R.transition.slideinleft);
        });

        ImageView previous = findViewById(R.id.back2);
        previous.setOnClickListener(view -> {
            Intent i = new Intent(OiaScreen.this, FiraScreen.class);
            startActivity(i);
            overridePendingTransition(R.transition.slideleft,R.transition.slideright);
        });

        Button hoteldelta = findViewById(R.id.hoteldelta_btn);
        hoteldelta.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://tinyurl.com/2x9ap3y5");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button hoteloiamare = findViewById(R.id.hoteloiamare_btn);
        hoteloiamare.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://tinyurl.com/3rfthr98");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button hotelpersa = findViewById(R.id.hotelpersa_btn);
        hotelpersa.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://tinyurl.com/pavdp8eu");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button hotelsecret = findViewById(R.id.hotelsecret_btn);
        hotelsecret.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://tinyurl.com/2dhhexuy");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button trip = findViewById(R.id.firaoiatrip);
        trip.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://www.viator.com/tours/Santorini/Santorini-Day-trip-with-Bus-tour-and-Boat-tour/d959-116941P64");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
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
            Intent i = new Intent(OiaScreen.this, ContactScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mainMenu) {
            Intent i = new Intent(OiaScreen.this, MenuScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.transportMenu) {
            Intent i = new Intent(OiaScreen.this, TransportScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.beachMenu) {
            Intent i = new Intent(OiaScreen.this, BeachScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tipsMenu) {
            Intent i = new Intent(OiaScreen.this, TipsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.todoMenu) {
            Intent i = new Intent(OiaScreen.this, MyToDoScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.restaurantsMenu){
            Intent i = new Intent(OiaScreen.this, RestaurantsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.attractionsMenu){
            Intent i = new Intent(OiaScreen.this, AttractionsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuVulcano) {
            Intent i = new Intent(OiaScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuFira){
            Intent i = new Intent(OiaScreen.this, FiraScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuOia){
            Intent i = new Intent(OiaScreen.this, OiaScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuAkrotiri){
            Intent i = new Intent(OiaScreen.this, AkrotiriScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}