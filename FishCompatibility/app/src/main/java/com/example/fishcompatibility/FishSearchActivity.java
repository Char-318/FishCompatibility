package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class FishSearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    Fish[] fishes;
    ListView listView;
    FishViewAdapter fishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_search);

        // Populating fish list view
        listView = (ListView) findViewById(R.id.list);
        Parcelable[] parcelable = getIntent().getExtras().getParcelableArray("fishes");
        fishes = new Fish[parcelable.length];

        for (int i = 0; i < parcelable.length; i++) {
            Fish fish = (Fish) parcelable[i];
            fishes[i] = fish;
        }

        fishAdapter = new FishViewAdapter(fishes, getApplicationContext());
        listView.setAdapter(fishAdapter);

        SearchView searchView = (SearchView) findViewById(R.id.fishSearch);
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                fishAdapter = new FishViewAdapter(fishes, getApplicationContext());
                listView.setAdapter(fishAdapter);

                return false;
            }
        });

        // TODO: onClickListener
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        ArrayList<Fish> fishArrayList = searchFish(s.toLowerCase());
        Fish[] fishArray = fishArrayList.toArray(new Fish[0]);
        fishAdapter = new FishViewAdapter(fishArray, getApplicationContext());
        listView.setAdapter(fishAdapter);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        return false;
    }

    public void openMain(View view) {
        Intent openMainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openMainIntent);
    }

    /**
     * Searches the fish data to check if a fish matches the searchText.
     * @param searchText Contains the input into the search text box in lower-case.
     * @return A list of all fish that match the input string.
     */
    public ArrayList<Fish> searchFish(String searchText) {
        ArrayList<Fish> resultArray = new ArrayList<>();

        for (Fish fish : fishes) {
            if (fish.getName().toLowerCase().contains(searchText)
                    || fish.getSciName().toLowerCase().contains(searchText)) {
                resultArray.add(fish);
            } else {
                for (String alias : fish.getAliases()) {
                    if (alias.toLowerCase().contains(searchText)) {
                        resultArray.add(fish);
                        break;
                    }
                }
            }
        }

        return resultArray;
    }
}