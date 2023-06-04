package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class CompareActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {
    private Fish[] fishes;
    private ArrayAdapter<String> arrayAdapterA;
    private Fish fishA;
    private Fish fishB;

    /**
     * Initialising the compare activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        Spinner spinnerA = findViewById(R.id.fishASpinner);
        spinnerA.setOnItemSelectedListener(this);
        Spinner spinnerB = findViewById(R.id.fishBSpinner);
        spinnerB.setOnItemSelectedListener(this);

        // Populating arrays
        Parcelable[] parcelable = getIntent().getExtras().getParcelableArray("fishes");
        fishes = new Fish[parcelable.length];
        String[] fishNames = new String[parcelable.length];

        for (int i = 0; i < parcelable.length; i++) {
            Fish fish = (Fish) parcelable[i];
            String fishName = fish.getName();
            fishes[i] = fish;
            fishNames[i] = fishName;
        }

        arrayAdapterA = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fishNames);
        ArrayAdapter<String> arrayAdapterB = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fishNames);
        arrayAdapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerA.setAdapter(arrayAdapterA);
        spinnerB.setAdapter(arrayAdapterB);
    }

    /**
     * What happens when an item from a dropdown menu is selected - overview of selected fish is
     * displayed.
     * @param adapterView AdapterView of the dropdown menu an item has been selected from.
     * @param view View of the current activity.
     * @param i Index of the item selected.
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView textView = findViewById(R.id.compatibleText);
        textView.setText("");

        // Checks which dropdown menu has been used
        if (adapterView.getAdapter() == arrayAdapterA) {
            fishA = fishes[i];

            // Displaying fragment of the selected fish
            FishFragment fragmentA = (FishFragment) getSupportFragmentManager()
                    .findFragmentByTag("fishAFragment");

            if (fragmentA == null) {
                fragmentA = new FishFragment();
            }

            Bundle bundleA = new Bundle();
            bundleA.putParcelable("fish", fishA);
            fragmentA.setArguments(bundleA);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fishAFragment, fragmentA).commit();
        } else {
            fishB = fishes[i];

            // Displaying fragment of selected fish
            FishFragment fragmentB = (FishFragment) getSupportFragmentManager()
                    .findFragmentByTag("fishBFragment");

            if (fragmentB == null) {
                fragmentB = new FishFragment();
            }

            Bundle bundleB = new Bundle();
            bundleB.putParcelable("fish", fishB);
            fragmentB.setArguments(bundleB);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fishBFragment, fragmentB).commit();
        }
    }

    /**
     * Necessary method to implement OnItemSelectedListener.
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    /**
     * Used to open the main activity to return the user to the home page.
     * @param view Current View.
     */
    public void openMain(View view) {
        Intent openMainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openMainIntent);
    }

    /**
     * Checks if two fish selected are compatible or not and informs the user with a text view.
     * @param view Current View.
     */
    public void compareFish(View view) {
        Compatibility comp = fishA.areFishCompatible(fishB);
        boolean isCompatible = comp.getIsComp();
        TextView textView = findViewById(R.id.compatibleText);

        if (isCompatible) {
            textView.setTextColor(ContextCompat.getColor(this, R.color.green));
            textView.setText("Fish are compatible");
        } else {
            textView.setTextColor(ContextCompat.getColor(this, R.color.red));
            textView.setText("Fish are incompatible - " + comp.getReason());
        }
    }
}