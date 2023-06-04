package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class FishSearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,
        SearchView.OnCloseListener, ListView.OnItemClickListener {
    private Fish[] fishes;
    private ArrayList<Fish> resultArray = new ArrayList<>();
    private ListView listView;
    private FishViewAdapter fishAdapter;

    /**
     * Initialises the fish search activity and populates the list.
     */
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
            resultArray.add(fish);
        }

        fishAdapter = new FishViewAdapter(fishes, getApplicationContext());
        listView.setAdapter(fishAdapter);

        SearchView searchView = (SearchView) findViewById(R.id.fishSearch);
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);

        listView.setOnItemClickListener(this);
    }

    /**
     * Called when the submit button on the search bar is clicked.
     * Calls the search algorithm and displays the results.
     * @param s Text entered as the search query.
     * @return False.
     */
    @Override
    public boolean onQueryTextSubmit(String s) {
        Search search = new Search();
        resultArray = search.searchFish(s, fishes);
        TextView noResult = findViewById(R.id.no_results);

        if (resultArray.size() == 0) {
            String text = "No fish match your search";
            noResult.setText(text);
        } else {
            noResult.setText("");
        }

        // Updates list of diseases
        Fish[] fishArray = resultArray.toArray(new Fish[0]);
        fishAdapter = new FishViewAdapter(fishArray, getApplicationContext());
        listView.setAdapter(fishAdapter);

        return false;
    }

    /**
     * Necessary function to implement the search bar.
     * @param s Text entered in the search bar.
     * @return False.
     */
    @Override
    public boolean onQueryTextChange(String s) { return false; }

    /**
     * Called when the close button is clicked on the search bar.
     * Resets the list of fish to contain all the fish.
     * @return False.
     */
    @Override
    public boolean onClose() {
        fishAdapter = new FishViewAdapter(fishes, getApplicationContext());
        listView.setAdapter(fishAdapter);
        resultArray.clear();
        resultArray.addAll(Arrays.asList(fishes));

        TextView noResult = findViewById(R.id.no_results);
        noResult.setText("");

        return false;
    }

    /**
     * Called when a fish in the list is clicked.
     * Opens the fish activity for the selected fish.
     * @param parent AdapterView of the list.
     * @param view Current view.
     * @param position Index of the item selected in the list.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent openFishIntent = new Intent(getApplicationContext(), FishActivity.class);
        openFishIntent.putExtra("fish", resultArray.get(position));
        startActivity(openFishIntent);
    }

    /**
     * Used to open the main activity to return the user to the home page.
     * @param view Current View.
     */
    public void openMain(View view) {
        Intent openMainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openMainIntent);
    }
}