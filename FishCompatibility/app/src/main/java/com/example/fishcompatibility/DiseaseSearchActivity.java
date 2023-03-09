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

public class DiseaseSearchActivity extends AppCompatActivity implements
        SearchView.OnQueryTextListener, SearchView.OnCloseListener, ListView.OnItemClickListener   {
    Disease[] diseases;
    ArrayList<Disease> resultArray = new ArrayList<>();
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
            resultArray.add(disease);
        }

        diseaseAdapter = new DiseaseViewAdapter(diseases, getApplicationContext());
        listView.setAdapter(diseaseAdapter);

        SearchView searchView = (SearchView) findViewById(R.id.diseaseSearch);
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);

        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        resultArray = searchDisease(s.toLowerCase());
        TextView noResult = findViewById(R.id.no_results);

        if (resultArray.size() == 0) {
            String text = "No diseases match your search";
            noResult.setText(text);
        } else {
            noResult.setText("");
        }

        Disease[] diseaseArray = resultArray.toArray(new Disease[0]);
        diseaseAdapter = new DiseaseViewAdapter(diseaseArray, getApplicationContext());
        listView.setAdapter(diseaseAdapter);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        return false;
    }

    @Override
    public boolean onClose() {
        diseaseAdapter = new DiseaseViewAdapter(diseases, getApplicationContext());
        listView.setAdapter(diseaseAdapter);
        resultArray.clear();
        resultArray.addAll(Arrays.asList(diseases));

        TextView noResult = findViewById(R.id.no_results);
        noResult.setText("");

        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent openDiseaseIntent = new Intent(getApplicationContext(), DiseaseActivity.class);
        openDiseaseIntent.putExtra("disease", resultArray.get(position));
        startActivity(openDiseaseIntent);
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