package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.HardwareRenderer;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BeachScreen extends AppCompatActivity {

    private ConstraintLayout cons_layout;
    //Back button
    private ImageView btn, soundbtn;
    // Radio buttons for different beaches
    private RadioButton radio1, radio2, radio3, radio4;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach_screen);

        cons_layout = findViewById(R.id.cons_layout);

        // First Radio Button Caldera Beach
        radio1 = findViewById(R.id.radio1);
        radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cons_layout.setBackgroundResource(R.drawable.calderabeach);
            }
        });

        // Second Radio Button Eros Beach
        radio2 = findViewById(R.id.radio2);
        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cons_layout.setBackgroundResource(R.drawable.erosbeach);
            }
        });

        // Third Radio Button Red Beach
        radio3 = findViewById(R.id.radio3);
        radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cons_layout.setBackgroundResource(R.drawable.redbeach);
            }
        });

        // Forth Radio Button Red Beach
        radio4 = findViewById(R.id.radio4);
        radio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cons_layout.setBackgroundResource(R.drawable.whitebeach);
            }
        });

        // Back Button
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BeachScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });

        // Sound Effect
        soundbtn = findViewById(R.id.soundbtn);
        soundbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mp = MediaPlayer.create(BeachScreen.this, R.raw.seawaves);
                mp.start();
            }
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
            Intent i = new Intent(BeachScreen.this, ContactScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mainMenu) {
            Intent i = new Intent(BeachScreen.this, MenuScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.transportMenu) {
            Intent i = new Intent(BeachScreen.this, TransportScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.beachMenu) {
            Intent i = new Intent(BeachScreen.this, BeachScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tipsMenu) {
            Intent i = new Intent(BeachScreen.this, TipsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.todoMenu) {
            Intent i = new Intent(BeachScreen.this, MyToDoScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.restaurantsMenu){
            Intent i = new Intent(BeachScreen.this, RestaurantsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.attractionsMenu){
            Intent i = new Intent(BeachScreen.this, AttractionsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuVulcano) {
            Intent i = new Intent(BeachScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuFira){
            Intent i = new Intent(BeachScreen.this, FiraScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuOia){
            Intent i = new Intent(BeachScreen.this, OiaScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuAkrotiri){
            Intent i = new Intent(BeachScreen.this, AkrotiriScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}