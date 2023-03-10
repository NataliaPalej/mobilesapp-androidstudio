package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Map;

public class MapScreen extends AppCompatActivity {

    private ImageView backbtn5;
    private Button mapView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_screen);

        backbtn5 = findViewById(R.id.backbtn5);
        backbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MapScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });

        // Go to maps
        mapView1 = findViewById(R.id.mapView1);
        mapView1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://tinyurl.com/2r9jj86d"));
                startActivity(i);
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
            Intent i = new Intent(MapScreen.this, ContactScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mainMenu) {
            Intent i = new Intent(MapScreen.this, MenuScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.transportMenu) {
            Intent i = new Intent(MapScreen.this, TransportScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.beachMenu) {
            Intent i = new Intent(MapScreen.this, BeachScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tipsMenu) {
            Intent i = new Intent(MapScreen.this, TipsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.adventureMenu) {
            Intent i = new Intent(MapScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}