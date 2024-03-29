package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransportScreen extends AppCompatActivity {

    private ImageView buggyImage;
    private ImageView scooterImage;
    private ImageView carImage;
    private ImageView quadImage;
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_screen);

        // Change buggy image on click
        buggyImage = findViewById(R.id.buggyimage);
        buggyImage.setOnClickListener(view -> {
            count++;
            if(count==1){
                buggyImage.setImageResource(R.drawable.buggy);
            }
            if (count==2){
                buggyImage.setImageResource(R.drawable.buggy2);
            }
            if(count==3){
                buggyImage.setImageResource(R.drawable.buggy3);
                count = 0;
            }
        });

        // Change car image on click
        carImage = findViewById(R.id.carImage);
        carImage.setOnClickListener(view -> {
            count++;
            if(count==1){
                carImage.setImageResource(R.drawable.car);
            }
            if (count==2){
                carImage.setImageResource(R.drawable.car2);
            }
            if(count==3){
                carImage.setImageResource(R.drawable.car3);
                count = 0;
            }
        });

        // Change scooter image on click
        scooterImage = findViewById(R.id.scooterImage);
        scooterImage.setOnClickListener(view -> {
            count++;
            if(count==1){
                scooterImage.setImageResource(R.drawable.scooter);
            }
            if (count==2){
                scooterImage.setImageResource(R.drawable.scooter2);
            }
            if(count==3){
                scooterImage.setImageResource(R.drawable.scooter3);
                count = 0;
            }
        });

        // Change quad image on click
        quadImage = findViewById(R.id.quadImage);
        quadImage.setOnClickListener(view -> {
            count++;
            if(count==1){
                quadImage.setImageResource(R.drawable.quad);
            }
            if (count==2){
                quadImage.setImageResource(R.drawable.quad2);
            }
            if(count==3) {
                quadImage.setImageResource(R.drawable.quad3);
                count = 0;
            }
        });

        // Back Button
        ImageView backbtn3 = findViewById(R.id.backbtn3);
        backbtn3.setOnClickListener(view -> {
            Intent i = new Intent(TransportScreen.this, MenuScreen.class);
            startActivity(i);
        });

        // Call Img Button
        ImageView imgcall = findViewById(R.id.imgcall);
        imgcall.setOnClickListener(view -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" + "012 345 6789"));
            if (i.resolveActivity(getPackageManager()) != null)
                startActivity(i);
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
            Intent i = new Intent(TransportScreen.this, ContactScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mainMenu) {
            Intent i = new Intent(TransportScreen.this, MenuScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.transportMenu) {
            Intent i = new Intent(TransportScreen.this, TransportScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.beachMenu) {
            Intent i = new Intent(TransportScreen.this, BeachScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tipsMenu) {
            Intent i = new Intent(TransportScreen.this, TipsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.todoMenu) {
            Intent i = new Intent(TransportScreen.this, MyToDoScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.restaurantsMenu){
            Intent i = new Intent(TransportScreen.this, RestaurantsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.attractionsMenu){
            Intent i = new Intent(TransportScreen.this, AttractionsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuVulcano) {
            Intent i = new Intent(TransportScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuFira){
            Intent i = new Intent(TransportScreen.this, FiraScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuOia){
            Intent i = new Intent(TransportScreen.this, OiaScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.subMenuAkrotiri){
            Intent i = new Intent(TransportScreen.this, AkrotiriScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}