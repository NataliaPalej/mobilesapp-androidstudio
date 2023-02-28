package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AkrotiriScreen extends AppCompatActivity {
    private ImageView backbtn_4, akrotiri_ruins, akrotiri_lighthouse;
    private Button mainmenu_btn, booknow;
    private EditText editDate, editPeople, editEmail, editExtra;

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

        booknow = findViewById(R.id.booknow);
        editDate = findViewById(R.id.editDate);
        editPeople = findViewById(R.id.editPeople);
        editEmail = findViewById(R.id.editEmail);
        editExtra = findViewById(R.id.editExtra);

        booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(AkrotiriScreen.this, Akrotiri_TripScreen.class);
                String date = editDate.getText().toString();
                //String people = editPeople.getText().toString();
                //String email = editEmail.getText().toString();
                //String extra = editExtra.getText().toString();

                i.putExtra("TextToSend", date);
                //i.putExtra("TextToSend2", people);
                //i.putExtra("TextToSend3", email);
                //i.putExtra("TextToSend4", extra);

                startActivity(i);
            }
        });

        // Change car image on click
        akrotiri_ruins = findViewById(R.id.akrotiri_ruins);
        akrotiri_ruins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                akrotiri_ruins.setImageResource(R.drawable.akrotiri3);
            }
        });

        akrotiri_lighthouse = findViewById(R.id.akrotiri_lighthouse);
        akrotiri_lighthouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                akrotiri_lighthouse.setImageResource(R.drawable.akrotiri4);
            }
        });
    }
}