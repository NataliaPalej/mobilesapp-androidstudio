package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class AttractionsScreen extends AppCompatActivity {

    private ChipGroup chip_group_choice;
    private ListView attractionsViewList;
    private List<String> attractionsList, filteredAttractionsList;
    private ImageView backBtn2;
    private ArrayAdapter<String> attractionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions_screen);

        // Attractions List
        attractionsViewList = findViewById(R.id.attractionsViewList);

        // Initialize the list of attractions
        attractionsList = new ArrayList<>();

        attractionsList.add("Heart Of Santorini, Akrotiri, Fira"); // Akrotiri, Thera
        attractionsList.add("Red Beach"); // Beach
        attractionsList.add("White Beach"); // Beach
        attractionsList.add("Akrotiri Ruins"); // Akrotiri
        attractionsList.add("Church of Panagia Katefiani, Perissa"); // Perissa
        attractionsList.add("Akrotiri Light House"); // Akrotiri
        attractionsList.add("Ancient Thera, Perissa"); // Perissa
        attractionsList.add("The Black Beach, Perissa"); // Beach, Perissa
        attractionsList.add("Moni Profiti Ilia, Perissa"); // Perissa
        attractionsList.add("Open Air Cinema Kamari"); // Kamari
        attractionsList.add("Monastery of Profitis Ilias, Perrisa, Church"); // Church, Perissa
        attractionsList.add("Three Bells of Fira"); // Thera
        attractionsList.add("Museum of Prehistoric Fira"); // Thera
        attractionsList.add("Church of Saint John the Baptist, Fira"); // Thera
        attractionsList.add("Skaros Rock, Fira"); // Thera
        attractionsList.add("Castle of Oia"); // Oia
        attractionsList.add("Ammoudi Bay, Oia"); // Oia
        attractionsList.add("Venetsanos Winery, Fira, Akrotiri"); // Thera, Akrotiri
        attractionsList.add("Windmill of Oia"); // Oia
        attractionsList.add("Vlychada Beach, Perissa"); // Beach, Perissa
        attractionsList.add("Maritime Museum, Oia"); // Oia
        attractionsList.add("Perissa Beach"); // Beach, Perissa
        attractionsList.add("The Orthodox Metropolitan Church, Fira"); // Church, Thera
        attractionsList.add("Kamari Beach"); // Beach, Kamari
        attractionsList.add("Megaron Gyzi Museum, Fira"); // Museum, Thera
        attractionsList.add("Church of Panagia Akathistos Hymn, Oia"); // Oia
        attractionsList.add("Oia Blue Dome Viewpoint, Oia"); // Oia
        attractionsList.add("The Volcanic Cinder Cone of Kokkino-Vouno Volcano, Oia"); // Oia
        attractionsList.add("The Assumption of the Virgin Mary Holy Church, Oia"); // Oia
        attractionsList.add("Maritime Museum, Oia"); // Oia
        attractionsList.add("The Church of Panagia Theoskepasti, Oia"); // Church, Oia
        attractionsList.add("Wine Museum Koutsogiannopoulos, Fira"); // Museum, Thera
        attractionsList.add("Naval Maritime Museum, Oia"); // Oia, Museum
        attractionsList.add("The Diamond Rock Venue, Fira"); // Thera
        attractionsList.add("Antik Necropolis, Kamari"); // Kamari
        attractionsList.add("The Church of Aghios Nikolaos, Fira"); // Fira, Church
        attractionsList.add("Spring of Zoodochos Pigi, Kamari"); // Kamari
        attractionsList.add("Ancient Cemetary Echidna, Perissa");
        attractionsList.add("Black Beach, Akrotiri"); // Akrotiri, Beach
        attractionsList.add("Archaeological Museum of Thera, Fira"); // Museum, Thera
        
        //Back Button
        backBtn2 = findViewById(R.id.backBtn2);
        backBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AttractionsScreen.this, MenuScreen.class);
                startActivity(i);
            }
        });

        // Get a reference to the ChipGroup and set an OnCheckedChangeListener
        chip_group_choice = findViewById(R.id.chip_group_choice);
        chip_group_choice.setOnCheckedChangeListener((chipGroup, i) -> {
            // Call the method to filter the attractions and update the list view
            filterAttractionsByChipGroup(attractionsList);
        });

        // Set the adapter to the attractions list
        attractionsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, attractionsList);
        attractionsViewList.setAdapter(attractionsAdapter);
    }

    private void filterAttractionsByChipGroup(List<String> fullAttractionsList) {
        // Get selected chip IDs from the chip group
        List<Integer> selectedChipIds = chip_group_choice.getCheckedChipIds();

        // Create a new list to hold the filtered attractions
        List<String> filteredAttractionsList = new ArrayList<>();

        // If no chip is selected, show all attractions
        if (selectedChipIds.isEmpty()) {
            filteredAttractionsList.addAll(fullAttractionsList);
        } else {
            // Otherwise, create a new filtered list
            List<String> tempAttractionsList = new ArrayList<>(fullAttractionsList);
            filteredAttractionsList.clear();

            for (String attraction : fullAttractionsList) {
                boolean shouldAddAttraction = true;
                for (Integer chipId : selectedChipIds) {
                    if (chipId != -1) {
                        // Filter the attractions based on the selected chips
                        Chip chip = findViewById(chipId);
                        String chipText = chip.getText().toString();
                        if (!attraction.contains(chipText)) {
                            // Attraction does not match a selected chip
                            shouldAddAttraction = false;
                            break;
                        }
                    }
                }
                if (shouldAddAttraction) {
                    // Attraction matches all selected chips
                    filteredAttractionsList.add(attraction);
                }
            }

            // Add empty position
            filteredAttractionsList.add("");
            // Add the remaining attractions not filtered by the selected chips to the bottom of the list
            for (String attraction : tempAttractionsList) {
                if (!filteredAttractionsList.contains(attraction)) {
                    filteredAttractionsList.add(attraction);
                }
            }
        }

        // Update the adapter with the new filtered list
        attractionsAdapter.clear();
        attractionsAdapter.addAll(filteredAttractionsList);
        attractionsAdapter.notifyDataSetChanged();
}

    // Show menu tab on screen
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    // Perform action when menu item selected
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.contactMenu) {
            Intent i = new Intent(AttractionsScreen.this, ContactScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.mainMenu) {
            Intent i = new Intent(AttractionsScreen.this, MenuScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.transportMenu) {
            Intent i = new Intent(AttractionsScreen.this, TransportScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.beachMenu) {
            Intent i = new Intent(AttractionsScreen.this, BeachScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.tipsMenu) {
            Intent i = new Intent(AttractionsScreen.this, TipsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.adventureMenu) {
            Intent i = new Intent(AttractionsScreen.this, AdventureScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.todoMenu) {
            Intent i = new Intent(AttractionsScreen.this, MyToDoScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.restaurantsMenu) {
            Intent i = new Intent(AttractionsScreen.this, RestaurantsScreen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.attractionsMenu) {
            Intent i = new Intent(AttractionsScreen.this, AttractionsScreen.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}