package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;

public class FishSearchActivity extends AppCompatActivity {
    Fish[] fishes;
    Disease[] diseases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_search);

        // Populating fish list view
        ListView listView = (ListView) findViewById(R.id.list);
        Parcelable[] parcelable = getIntent().getExtras().getParcelableArray("fishes");
        fishes = new Fish[parcelable.length];

        for (int i = 0; i < parcelable.length; i++) {
            Fish fish = (Fish) parcelable[i];
            fishes[i] = fish;
        }

        FishViewAdapter fishAdapter = new FishViewAdapter(fishes, getApplicationContext());
        listView.setAdapter(fishAdapter);

        // TODO: onClickListener
    }
}