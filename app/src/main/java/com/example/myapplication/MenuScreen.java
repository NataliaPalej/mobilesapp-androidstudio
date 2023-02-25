package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuScreen extends AppCompatActivity {

    private Button adventureScreen;
    private Button beachScreen;
    private Button todoScreen;
    private Button transportScreen;
    private Button tipsScreen;
    private ImageView exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        // Go to Transport Screen
        transportScreen = findViewById(R.id.btn1);
        transportScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuScreen.this, TransportScreen.class);
                startActivity(i);
            }
        });

        // Go to Hotel Screen
        todoScreen = findViewById(R.id.btn2);
        todoScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuScreen.this, TODOScreen.class);
                startActivity(i);
            }
        });

        // Go to Adventure Screen
        adventureScreen = findViewById(R.id.btn3);
        adventureScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuScreen.this, AdventureScreen.class);
                startActivity(i);
            }
        });

        // Go to Beach Screen
        beachScreen = findViewById(R.id.btn4);
        beachScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuScreen.this, BeachScreen.class);
                startActivity(i);
            }
        });

        // Go to Tips Screen
        tipsScreen = findViewById(R.id.btn6);
        tipsScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuScreen.this, TipsScreen.class);
                startActivity(i);
            }
        });

        // Exit the App
        exit = findViewById(R.id.btn5);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

    }
}