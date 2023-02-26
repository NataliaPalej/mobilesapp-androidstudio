package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TipsScreen extends AppCompatActivity {

    private Button menu_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_screen);

        // Back Button
        menu_btn3 = findViewById(R.id.menu_btn3);
        menu_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TipsScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });

    }
}