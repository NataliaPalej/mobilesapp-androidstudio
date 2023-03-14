package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AkrotiriScreen extends AppCompatActivity {
    private ImageView backbtn_4, akrotiri_ruins, akrotiri_lighthouse;
    private Button mainmenu_btn, booknow;
    private EditText editPeople, editEmail, editExtra;
    private SharedPreferences database;
    private int count = 0;
    CalendarView calendarView;
    private TextView editDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akrotiri_screen);

        backbtn_4 = findViewById(R.id.backbtn_4);
        backbtn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AkrotiriScreen.this, OiaScreen.class);
                startActivity(i);
                overridePendingTransition(R.transition.slideleft,R.transition.slideright);
            }
        });

        mainmenu_btn = findViewById(R.id.mainmenu_btn);
        mainmenu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AkrotiriScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });

        calendarView = findViewById(R.id.calendarView);
        editDate = findViewById(R.id.editDate);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                // Month starts as zero, hence why we add 1 to it
                String fullDate = day + "/" + (month+1) + "/" + year;
                editDate.setText(fullDate);
            }
        });

        booknow = findViewById(R.id.booknow);
        editPeople = findViewById(R.id.editPeople);
        editEmail = findViewById(R.id.editEmail);
        editExtra = findViewById(R.id.editExtra);

        booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(AkrotiriScreen.this, Akrotiri_TripScreen.class);
                String date = editDate.getText().toString();
                String people = editPeople.getText().toString();
                String email = editEmail.getText().toString();
                String extra = editExtra.getText().toString();

                i.putExtra("TextToSend", date);
                i.putExtra("TextToSend2", people);
                i.putExtra("TextToSend3", email);
                i.putExtra("TextToSend4", extra);

                startActivity(i);
            }
        });

        // Change car image on click
        akrotiri_ruins = findViewById(R.id.akrotiri_ruins);
        akrotiri_ruins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                count++;
                if (count==1){
                    akrotiri_ruins.setImageResource(R.drawable.akrotiri1);
                }
                if (count==2){
                    akrotiri_ruins.setImageResource(R.drawable.akrotiri2);
                    count=0;
                }
            }
        });

        akrotiri_lighthouse = findViewById(R.id.akrotiri_lighthouse);
        akrotiri_lighthouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                count++;
                if(count==1){
                    akrotiri_lighthouse.setImageResource(R.drawable.akrotiri3);
                }
                if (count==2){
                    akrotiri_lighthouse.setImageResource(R.drawable.akrotiri4);
                    count = 0;
                }
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
            Intent i = new Intent(AkrotiriScreen.this, ContactScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mainMenu) {
            Intent i = new Intent(AkrotiriScreen.this, MenuScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.transportMenu) {
            Intent i = new Intent(AkrotiriScreen.this, TransportScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.beachMenu) {
            Intent i = new Intent(AkrotiriScreen.this, BeachScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tipsMenu) {
            Intent i = new Intent(AkrotiriScreen.this, TipsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.adventureMenu) {
            Intent i = new Intent(AkrotiriScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.todoMenu) {
            Intent i = new Intent(AkrotiriScreen.this, MyToDoScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}