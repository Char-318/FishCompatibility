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

        Fish[] fishArray = resultArray.toArray(new Fish[0]);
        fishAdapter = new FishViewAdapter(fishArray, getApplicationContext());
        listView.setAdapter(fishAdapter);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        return false;
    }

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent openFishIntent = new Intent(getApplicationContext(), FishActivity.class);
        openFishIntent.putExtra("fish", resultArray.get(position));
        startActivity(openFishIntent);
    }

    public void openMain(View view) {
        Intent openMainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openMainIntent);
    }
}