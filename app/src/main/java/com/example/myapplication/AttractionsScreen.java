package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class AttractionsScreen extends AppCompatActivity {

    private ChipGroup chip_group_filter, chip_group_choice;
    private ListView attractionsViewList;
    private ArrayList<String> attractionsList;
    private ImageView backBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions_screen);

        // Attractions List
        attractionsViewList = findViewById(R.id.attractionsViewList);

        attractionsList = new ArrayList<>();
        attractionsList.add("Heart Of Santorini"); // Akrotiri, Thera
        attractionsList.add("Red Beach"); // Beach
        attractionsList.add("White Beach"); // Beach
        attractionsList.add("Akrotiri Ruins"); // Akrotiri
        attractionsList.add("Chapel of Panagia Katefiani"); // Perissa
        attractionsList.add("Akrotiri Light House"); // Akrotiri
        attractionsList.add("Perrisa Beach"); // Perissa, Beach
        attractionsList.add("Ancient Thera"); // Perissa
        attractionsList.add("Moni Profiti Ilia"); // Perissa
        attractionsList.add("Open Air Cinema Kamari"); // Kamari
        attractionsList.add("Three Bells of Fira"); // Thera
        attractionsList.add("Museum of Prehistoric Thera"); // Thera
        attractionsList.add("Cathedral of Saint John the Baptist"); // Thera
        attractionsList.add("Skaros Rock"); // Thera
        attractionsList.add("Castle of Oia"); // Oia
        attractionsList.add("Ammoudi Bay"); // Oia
        attractionsList.add("Windmill of Oia"); // Oia
        attractionsList.add("Maritime museum"); // Oia
        attractionsList.add("Perissa Beach"); // Beach, Perissa
        attractionsList.add("Kamari Beach"); // Beach, Kamari
        attractionsList.add("Church of Panagia Akathistos Hymn"); // Oia
        attractionsList.add("Oia Blue Dome Viewpoint"); // Oia
        attractionsList.add("The Volcanic Cinder Cone of Kokkino-Vouno Volcano"); // Oia
        attractionsList.add("The Assumption of the Virgin Mary Holy Chapel"); // Oia
        attractionsList.add("Maritime museum"); // Oia
        attractionsList.add("The Diamond Rock Venue"); // Thera
        attractionsList.add("Antik Necropolis"); // Kamari
        attractionsList.add("Spring of Zoodochos Pigi"); // Kamari
        attractionsList.add("Ancient cemetary Echidna"); // South of Santorini
        attractionsList.add("Black Beach"); // Akrotiri, Beach


        //Back Button
        backBtn2 = findViewById(R.id.backBtn2);
        backBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AttractionsScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });

        chip_group_filter = findViewById(R.id.chip_group_filter);
        chip_group_filter.setOnCheckedChangeListener { group, checkedId -> val chip: Chip? = group.findViewById(checkedId)
            chip?.let {chipView ->
                    val predicate: (Items) -> Boolean = {item->
                    item.category == chipView.text
            }
                val filter = prepareData().filter(predicate)
                adapter?.setData(filter)
            } ?: kotlin.run {
                adapter?.setData(prepareData())
            }
        }

        chip_group_choice = findViewById(R.id.chip_group_choice);
        chip_group_choice.setOnCheckedChangeListener { group, checkedId ->
                val chip: Chip? = group.findViewById(checkedId)
            chip?.let {chipView ->
                    Toast.makeText(context, chip.text, Toast.LENGTH_SHORT).show()
            } ?: kotlin.run {
            }
        }



    }
}