package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ContactScreen extends AppCompatActivity {
    private ImageView id_email, id_sms;
    private Button menubtn11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_screen);

        id_email = findViewById(R.id.id_email);
        id_sms = findViewById(R.id.id_sms);
        menubtn11 = findViewById(R.id.menubtn11);

        id_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"email@address.ie"});
                email.putExtra(Intent.EXTRA_SUBJECT, "SantoriniGuide Querry");
                email.putExtra(Intent.EXTRA_TEXT, "[type_in_your_question_here]");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Send Mail Using :"));
            }
        });

        id_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:0123456789");
                Intent msg = new Intent(Intent.ACTION_SENDTO, uri);
                msg.putExtra("sms_body", "Write_Your_Txt_Here");
                startActivity(Intent.createChooser(msg, "Send sms Using :"));
            }
        });

        // Menu Button
        menubtn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ContactScreen.this, MenuScreen.class);
                startActivity(i);
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
        if (id == R.id.mainMenu) {
            Intent i = new Intent(ContactScreen.this, MenuScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.transportMenu) {
            Intent i = new Intent(ContactScreen.this, TransportScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.beachMenu) {
            Intent i = new Intent(ContactScreen.this, BeachScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tipsMenu) {
            Intent i = new Intent(ContactScreen.this, TipsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.adventureMenu) {
            Intent i = new Intent(ContactScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.contactMenu) {
            Intent i = new Intent(ContactScreen.this, ContactScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}