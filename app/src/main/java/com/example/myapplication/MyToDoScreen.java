package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyToDoScreen extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Button saveDetails, showDetails, cameraBtn;
    private ImageView backButton, picView;
    private TextView todoDetails;
    private SharedPreferences database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_to_do_screen);

        saveDetails = findViewById(R.id.saveDetails);
        showDetails = findViewById(R.id.showDetails);
        todoDetails = findViewById(R.id.todoDetails);
        backButton = findViewById(R.id.backButton);
        picView = findViewById(R.id.picView);
        cameraBtn = findViewById(R.id.cameraBtn);

        saveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);
                SharedPreferences.Editor editor = database.edit();
                String todoList = todoDetails.getText().toString();
                editor.putString("key_saved_text", todoList);
                editor.commit();
                Toast.makeText(MyToDoScreen.this, "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });

        showDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);
                String todoList = database.getString("key_saved_text", null);
                Toast.makeText(MyToDoScreen.this, todoList, Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MyToDoScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                try {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                } catch (ActivityNotFoundException e) {
                    // display error state to the user
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            picView.setImageBitmap(imageBitmap);
        }
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
            Intent i = new Intent(MyToDoScreen.this, ContactScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mainMenu) {
            Intent i = new Intent(MyToDoScreen.this, MenuScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.transportMenu) {
            Intent i = new Intent(MyToDoScreen.this, TransportScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.beachMenu) {
            Intent i = new Intent(MyToDoScreen.this, BeachScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tipsMenu) {
            Intent i = new Intent(MyToDoScreen.this, TipsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.adventureMenu) {
            Intent i = new Intent(MyToDoScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.todoMenu) {
            Intent i = new Intent(MyToDoScreen.this, MyToDoScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.restaurantsMenu){
            Intent i = new Intent(MyToDoScreen.this, RestaurantsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.attractionsMenu){
            Intent i = new Intent(MyToDoScreen.this, AttractionsScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}