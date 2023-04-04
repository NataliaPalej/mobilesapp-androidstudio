package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RestaurantsScreen extends AppCompatActivity {

    private ImageView backbtn1, restImg;
    private TextView restTxt;
    private ArrayList<String> restaurantList;
    private ArrayList<Integer> restaurantImg;

    private ListView listView;

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

        // Create List View and Image View
        listView = findViewById(R.id.listView);

        restaurantList = new ArrayList<>();
        restaurantList.add("Fanari · €€\nRating: 4.4");
        restaurantList.add("Volcano Blue · €€€\nRating: 4.4");
        restaurantList.add("Idol Restaurant Bar · €€€\nRating: 4.2");
        restaurantList.add("Da Costa · €€\nRating: 4.3");
        restaurantList.add("La Scala · €€\nRating: 4.2");
        restaurantList.add("Aris Restaurants · unknown\nRating: 4.7");
        restaurantList.add("La Colline · unknown\nRating: 4.7");
        restaurantList.add("Lithos · €€\nRating: 4.0");
        restaurantList.add("Zafora · €€\nRating: 3.1");

        restaurantImg = new ArrayList<>();
        restaurantImg .add(R.drawable.fanari);
        restaurantImg .add(R.drawable.volcanoblue);
        restaurantImg .add(R.drawable.idolrestaurantbar);
        restaurantImg .add(R.drawable.dacosta);
        restaurantImg .add(R.drawable.lascala);
        restaurantImg .add(R.drawable.arisrestaurant);
        restaurantImg .add(R.drawable.lacolline);
        restaurantImg .add(R.drawable.lithos);
        restaurantImg .add(R.drawable.zafora);

        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }

    public class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return restaurantImg.size();  //added this
        }
        @Override
        public Object getItem(int i) {
            return null;
        }
        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.restaurants_list, viewGroup, false);
            ImageView myImageView = view.findViewById(R.id.restImg);
            TextView myTextView = view.findViewById(R.id.restTxt);

            myImageView.setImageResource(restaurantImg.get(i));
            myTextView.setText(restaurantList.get(i));
            return view;
        }
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
        if (id == R.id.attractionsMenu){
            Intent i = new Intent(RestaurantsScreen.this, AttractionsScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}