package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;

public class DiseaseSearchActivity extends AppCompatActivity {
    Disease[] diseases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_search);

        // Populating disease list view
        ListView listView = (ListView) findViewById(R.id.list);
        Parcelable[] parcelable = getIntent().getExtras().getParcelableArray("diseases");
        diseases = new Disease[parcelable.length];

        for (int i = 0; i < parcelable.length; i++) {
            Disease disease = (Disease) parcelable[i];
            diseases[i] = disease;
        }

        DiseaseViewAdapter diseaseAdapter = new DiseaseViewAdapter(diseases, getApplicationContext());
        listView.setAdapter(diseaseAdapter);

        // TODO: onClickListener
    }

    public void openMain(View view) {
        Intent openMainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openMainIntent);
    }
}