package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AkrotiriScreen extends AppCompatActivity {

    private ImageView previous;
    private Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akrotiri_screen);

        menu = findViewById(R.id.menu1);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AkrotiriScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });

        previous = findViewById(R.id.backbtn2);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AkrotiriScreen.this, OiaScreen.class);
                startActivity(i);
            }
        });


    }
}