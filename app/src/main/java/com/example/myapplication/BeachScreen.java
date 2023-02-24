package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class BeachScreen extends AppCompatActivity {

    private ConstraintLayout cons_layout;

    //Back button
    private Button btn;

    // Radio buttons for different beaches
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;

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

    }
}