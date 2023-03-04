package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class DiseaseSearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener  {
    Disease[] diseases;
    DiseaseViewAdapter diseaseAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_search);

        // Populating disease list view
        listView = (ListView) findViewById(R.id.list);
        Parcelable[] parcelable = getIntent().getExtras().getParcelableArray("diseases");
        diseases = new Disease[parcelable.length];

        for (int i = 0; i < parcelable.length; i++) {
            Disease disease = (Disease) parcelable[i];
            diseases[i] = disease;
        }

        diseaseAdapter = new DiseaseViewAdapter(diseases, getApplicationContext());
        listView.setAdapter(diseaseAdapter);

        SearchView searchView = (SearchView) findViewById(R.id.diseaseSearch);
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                diseaseAdapter = new DiseaseViewAdapter(diseases, getApplicationContext());
                listView.setAdapter(diseaseAdapter);

                return false;
            }
        });

        // TODO: onClickListener
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        ArrayList<Disease> diseaseArrayList = searchDisease(s.toLowerCase());
        Disease[] diseaseArray = diseaseArrayList.toArray(new Disease[0]);
        diseaseAdapter = new DiseaseViewAdapter(diseaseArray, getApplicationContext());
        listView.setAdapter(diseaseAdapter);

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
     * Searches the disease data to check if a disease matches the searchText.
     * @param searchText Contains the input into the search text box in lower-case.
     * @return A list of all diseases that match the input string.
     */
    public ArrayList<Disease> searchDisease(String searchText) {
        ArrayList<Disease> resultArray = new ArrayList<>();

        for (Disease disease : diseases) {
            if (disease.getName().toLowerCase().contains(searchText)) {
                resultArray.add(disease);
            } else {
                for (String alias : disease.getAliases()) {
                    if (alias.toLowerCase().contains(searchText)) {
                        resultArray.add(disease);
                        break;
                    }
                }
            }
        }

        return resultArray;
    }
}