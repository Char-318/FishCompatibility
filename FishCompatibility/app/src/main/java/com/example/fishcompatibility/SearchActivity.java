package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    Fish[] fishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ListView listView = (ListView) findViewById(R.id.list);
        fishes = (Fish[]) getIntent().getExtras().getParcelableArray("fishes");

        ViewAdapter adapter = new ViewAdapter(fishes, getApplicationContext());

        listView.setAdapter(adapter);

        // TODO: onClickListener
    }
}