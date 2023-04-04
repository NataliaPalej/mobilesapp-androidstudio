package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        // Go to Transport Screen
        Button transportScreen = findViewById(R.id.btn1);
        transportScreen.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, TransportScreen.class);
            startActivity(i);
        });

        // Go to Adventure Screen
        Button adventureScreen = findViewById(R.id.btn3);
        adventureScreen.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, AdventureScreen.class);
            startActivity(i);
        });

        // Go to Beach Screen
        Button beachScreen = findViewById(R.id.btn4);
        beachScreen.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, BeachScreen.class);
            startActivity(i);
        });

        // Go to Tips Screen
        Button tipsScreen = findViewById(R.id.btn6);
        tipsScreen.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, TipsScreen.class);
            startActivity(i);
        });

        // Go to Map Screen
        Button mapScreen = findViewById(R.id.btn2);
        mapScreen.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, MapScreen.class);
            startActivity(i);
        });

        // Go to Restaurants Screen
        Button restaurantsbtn = findViewById(R.id.restaurantsbtn);
        restaurantsbtn.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, RestaurantsScreen.class);
            startActivity(i);
        });

        // Go to My To Do Screen
        Button myToDo = findViewById(R.id.myToDo);
        myToDo.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, MyToDoScreen.class);
            startActivity(i);
        });

        // Go to Attractions Screen
        Button attractionsbtn = findViewById(R.id.attractionsbtn);
        attractionsbtn.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, AttractionsScreen.class);
            startActivity(i);
        });

        // Exit the App
        ImageView exit = findViewById(R.id.btn5);
        exit.setOnClickListener(view -> {
            finish();
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            System.exit(0);
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
            Intent i = new Intent(MenuScreen.this, ContactScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mainMenu) {
            Intent i = new Intent(MenuScreen.this, MenuScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.transportMenu) {
            Intent i = new Intent(MenuScreen.this, TransportScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.beachMenu) {
            Intent i = new Intent(MenuScreen.this, BeachScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tipsMenu) {
            Intent i = new Intent(MenuScreen.this, TipsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.todoMenu) {
            Intent i = new Intent(MenuScreen.this, MyToDoScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.restaurantsMenu){
            Intent i = new Intent(MenuScreen.this, RestaurantsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.attractionsMenu){
            Intent i = new Intent(MenuScreen.this, AttractionsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuVulcano) {
            Intent i = new Intent(MenuScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuFira){
            Intent i = new Intent(MenuScreen.this, FiraScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuOia){
            Intent i = new Intent(MenuScreen.this, OiaScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuAkrotiri){
            Intent i = new Intent(MenuScreen.this, AkrotiriScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}