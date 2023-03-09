package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class SignUpScreen extends AppCompatActivity {

    // TODO -> create id_email and id_sms image view on activity_sign_up_screen
    private ImageView id_email, id_sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        id_email = findViewById(R.id.id_email);
        id_sms = findViewById(R.id.id_sms);

        id_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"tom@ait.ie"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Hello from my app");
                email.putExtra(Intent.EXTRA_TEXT, "Bla bla Bla bla  Bla bla  Bla bla  Bla bla ");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Send Mail Using :"));
            }
        });

        id_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:2345612345");
                Intent msg = new Intent(Intent.ACTION_SENDTO, uri);
                msg.putExtra("sms_body", "The SMS text");
                startActivity(Intent.createChooser(msg, "Send sms Using :"));
            }
        });
    }

    // Show menu tab on first screen
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    // Perform action when menu item selected
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mapMenu) {
            Intent i = new Intent(SignUpScreen.this, MapScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mainMenu) {
            Intent i = new Intent(SignUpScreen.this, MenuScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.transportMenu) {
            Intent i = new Intent(SignUpScreen.this, TransportScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.beachMenu) {
            Intent i = new Intent(SignUpScreen.this, BeachScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tipsMenu) {
            Intent i = new Intent(SignUpScreen.this, TipsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.adventureMenu) {
            Intent i = new Intent(SignUpScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}