package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;

public class SearchActivity extends AppCompatActivity {
    Fish[] fishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ListView listView = (ListView) findViewById(R.id.list);
        Parcelable[] parcelable = getIntent().getExtras().getParcelableArray("fishes");
        fishes = new Fish[parcelable.length];

        for (int i = 0; i < parcelable.length; i++) {
            Fish fish = (Fish) parcelable[i];
            fishes[i] = fish;
        }

        FishViewAdapter adapter = new FishViewAdapter(fishes, getApplicationContext());

        listView.setAdapter(adapter);

        // TODO: Create list of diseases - DiseaseViewAdapter.java - disease_list_item.xml
        // TODO: onClickListener
    }
}