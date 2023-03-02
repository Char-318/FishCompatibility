package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;

public class SearchActivity extends AppCompatActivity {
    Fish[] fishes;
    Disease[] diseases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Populating fish list view
        ListView fishListView = (ListView) findViewById(R.id.fishList);
        Parcelable[] fishParcelable = getIntent().getExtras().getParcelableArray("fishes");
        fishes = new Fish[fishParcelable.length];

        for (int i = 0; i < fishParcelable.length; i++) {
            Fish fish = (Fish) fishParcelable[i];
            fishes[i] = fish;
        }

        FishViewAdapter fishAdapter = new FishViewAdapter(fishes, getApplicationContext());
        fishListView.setAdapter(fishAdapter);

        // Populating disease list view
        ListView diseaseListView = (ListView) findViewById(R.id.diseaseList);
        Parcelable[] diseaseParcelable = getIntent().getExtras().getParcelableArray("diseases");
        diseases = new Disease[diseaseParcelable.length];

        for (int i = 0; i < diseaseParcelable.length; i++) {
            Disease disease = (Disease) diseaseParcelable[i];
            diseases[i] = disease;
        }

        DiseaseViewAdapter diseaseAdapter = new DiseaseViewAdapter(diseases, getApplicationContext());

        diseaseListView.setAdapter(diseaseAdapter);

        // TODO: Create list of diseases - DiseaseViewAdapter.java - disease_list_item.xml
        // TODO: onClickListener
    }
}