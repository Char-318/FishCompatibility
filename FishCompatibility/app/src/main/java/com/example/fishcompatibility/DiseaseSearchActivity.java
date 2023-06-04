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
    private Disease[] diseases;
    private ArrayList<Disease> resultArray = new ArrayList<>();
    private DiseaseViewAdapter diseaseAdapter;
    private ListView listView;

    /**
     * Initialises the disease search activity and creates a list of diseases.
     */
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

    /**
     * Called when the submit button on the search bar is clicked.
     * Calls the search algorithm and displays the results.
     * @param s Text entered as the search query.
     * @return False.
     */
    @Override
    public boolean onQueryTextSubmit(String s) {
        Search search = new Search();
        resultArray = search.searchDisease(s, diseases);
        TextView noResult = findViewById(R.id.no_results);

        if (resultArray.size() == 0) {
            String text = "No diseases match your search";
            noResult.setText(text);
        } else {
            noResult.setText("");
        }

        // Updates list of diseases
        Disease[] diseaseArray = resultArray.toArray(new Disease[0]);
        diseaseAdapter = new DiseaseViewAdapter(diseaseArray, getApplicationContext());
        listView.setAdapter(diseaseAdapter);

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
     * Resets the list of diseases to contain all the diseases.
     * @return False.
     */
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

    /**
     * Called when a disease in the list is clicked.
     * Opens the disease activity for the selected disease.
     * @param parent AdapterView of the list.
     * @param view Current view.
     * @param position Index of the item selected in the list.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent openDiseaseIntent = new Intent(getApplicationContext(), DiseaseActivity.class);
        openDiseaseIntent.putExtra("disease", resultArray.get(position));
        startActivity(openDiseaseIntent);
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