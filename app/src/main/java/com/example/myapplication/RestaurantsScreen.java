package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RestaurantsScreen extends AppCompatActivity {

    private ImageView backbtn1;
    private ListView listView;
    private ArrayList<String> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_screen);

        // Back Button
        backbtn1 = findViewById(R.id.backbtn1);
        backbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RestaurantsScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });

        // TODO: In 3rd App to enhance the listView, restaurant price and rating will display on click
        // Create List View
        listView = findViewById(R.id.listView);
        restaurantList = new ArrayList<>();
        restaurantList.add("Fanari · €€ · Rating: 4.4");
        restaurantList.add("Volcano Blue · €€€ · Rating: 4.4");
        restaurantList.add("Idol Restaurant Bar · €€€ · Rating: 4.2");
        restaurantList.add("Da Costa · €€ · Rating: 4.3");
        restaurantList.add("La Scala · €€ · Rating: 4.2");
        restaurantList.add("Aris Restaurants · unknown · Rating: 4.7");
        restaurantList.add("La Colline · unknown · Rating: 4.7");
        restaurantList.add("Lithos · €€ · Rating: 4.0");
        restaurantList.add("Zafora · €€ · Rating: 3.1");

        ArrayAdapter<String> restaurantAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                restaurantList
        );

        listView.setAdapter(restaurantAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView < ? > adapterView, View view,int i, long l){
                Toast.makeText(RestaurantsScreen.this, restaurantList.get(i), Toast.LENGTH_SHORT).show();
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
            Intent i = new Intent(RestaurantsScreen.this, ContactScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mainMenu) {
            Intent i = new Intent(RestaurantsScreen.this, MenuScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.transportMenu) {
            Intent i = new Intent(RestaurantsScreen.this, TransportScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.beachMenu) {
            Intent i = new Intent(RestaurantsScreen.this, BeachScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tipsMenu) {
            Intent i = new Intent(RestaurantsScreen.this, TipsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.adventureMenu) {
            Intent i = new Intent(RestaurantsScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.todoMenu) {
            Intent i = new Intent(RestaurantsScreen.this, MyToDoScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.restaurantsMenu){
            Intent i = new Intent(RestaurantsScreen.this, RestaurantsScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}