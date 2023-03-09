package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FiraScreen extends AppCompatActivity {

    private ImageView previous, next, firaPictures, firaMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fira_screen);

        next = findViewById(R.id.nextbtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FiraScreen.this, OiaScreen.class);
                startActivity(i);
            }
        });

        previous = findViewById(R.id.backbtn);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FiraScreen.this, AdventureScreen.class);
                startActivity(i);
            }
        });

        // Iterate through Fira pictures
        firaPictures = findViewById(R.id.firaPictures);
        firaPictures.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View view){
                count++;
                if(count==1){
                    firaPictures.setImageResource(R.drawable.fira1);
                }
                if (count==2){
                    firaPictures.setImageResource(R.drawable.fira2);
                }
                if(count==3){
                    firaPictures.setImageResource(R.drawable.fira3);
                }
                if(count==4){
                    firaPictures.setImageResource(R.drawable.fira4);
                }
                if(count==5){
                    firaPictures.setImageResource(R.drawable.fira5);
                }
                if(count==6){
                    firaPictures.setImageResource(R.drawable.fira6);
                }
                if(count==7){
                    firaPictures.setImageResource(R.drawable.fira7);
                }
                if(count==8){
                    firaPictures.setImageResource(R.drawable.fira8);
                }
                if(count==9){
                    firaPictures.setImageResource(R.drawable.fira9);
                    count=0;
                }
            }
        });
    }
}