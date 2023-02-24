package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TransportScreen extends AppCompatActivity {

    private Button backbtn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_screen);


        // Back Button
        backbtn3 = findViewById(R.id.backbtn3);
        backbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TransportScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });
    }
}