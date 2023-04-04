package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MenuScreen extends AppCompatActivity {
    private Button adventureScreen, beachScreen, mapScreen, transportScreen, tipsScreen,
            myToDo, restaurantsbtn, attractionsbtn;
    private ImageView exit;
    private TextView currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        // Go to Transport Screen
        transportScreen = findViewById(R.id.btn1);
        transportScreen.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, TransportScreen.class);
            startActivity(i);
        });

        // Go to Adventure Screen
        adventureScreen = findViewById(R.id.btn3);
        adventureScreen.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, AdventureScreen.class);
            startActivity(i);
        });

        // Go to Beach Screen
        beachScreen = findViewById(R.id.btn4);
        beachScreen.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, BeachScreen.class);
            startActivity(i);
        });

        // Go to Tips Screen
        tipsScreen = findViewById(R.id.btn6);
        tipsScreen.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, TipsScreen.class);
            startActivity(i);
        });

        // Go to Map Screen
        mapScreen = findViewById(R.id.btn2);
        mapScreen.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, MapScreen.class);
            startActivity(i);
        });

        // Go to Restaurants Screen
        restaurantsbtn = findViewById(R.id.restaurantsbtn);
        restaurantsbtn.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, RestaurantsScreen.class);
            startActivity(i);
        });

        // Go to My To Do Screen
        myToDo = findViewById(R.id.myToDo);
        myToDo.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, MyToDoScreen.class);
            startActivity(i);
        });

        // Go to Attractions Screen
        attractionsbtn = findViewById(R.id.attractionsbtn);
        attractionsbtn.setOnClickListener(view -> {
            Intent i = new Intent(MenuScreen.this, AttractionsScreen.class);
            startActivity(i);
        });

        // Exit the App
        exit = findViewById(R.id.btn5);
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
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
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
        if (id == R.id.adventureMenu) {
            Intent i = new Intent(MenuScreen.this, AdventureScreen.class);
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
        return super.onOptionsItemSelected(item);
    }
}