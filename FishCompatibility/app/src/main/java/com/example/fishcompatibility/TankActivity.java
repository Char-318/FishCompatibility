 package com.example.fishcompatibility;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

 public class TankActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
     ArrayList<Fish> tankFish = new ArrayList<>();
     Fish[] fishes;
     String[] fishNames;
     TextView notCompText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tank);

        Spinner spinner = findViewById(R.id.fishSpinner);
        spinner.setOnItemSelectedListener(this);

        // Populating arrays
        Parcelable[] parcelable = getIntent().getExtras().getParcelableArray("fishes");
        fishes = new Fish[parcelable.length];
        fishNames = new String[parcelable.length + 1];
        fishNames[0] = "Select a fish...";

        for (int i = 0; i < parcelable.length; i++) {
            Fish fish = (Fish) parcelable[i];
            String fishName = fish.getName();
            fishes[i] = fish;
            fishNames[i + 1] = fishName;
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fishNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);
    }

     @Override
     public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         if (i != 0) {
             TextView fishAddedText = (TextView) findViewById(R.id.fishAdded);
             TextView isCompatText = (TextView) findViewById(R.id.fishIsCompat);
             Fish selectedFish = fishes[i - 1];

             if (tankFish.contains(fishes[i - 1])) {
                 fishAddedText.setVisibility(View.VISIBLE);
             } else {
                 tankFish.add(selectedFish);
                 fishAddedText.setVisibility(View.INVISIBLE);
                 isCompatText.setVisibility(View.INVISIBLE);

                 if (notCompText != null) {
                     ((ViewGroup) notCompText.getParent()).removeView(notCompText);
                     notCompText = null;
                 }

                 FishFragment fragment = (FishFragment) getSupportFragmentManager()
                         .findFragmentByTag("fishFragment");

                 if (fragment == null) {
                     fragment = new FishFragment();
                 }

                 Bundle bundle = new Bundle();
                 bundle.putParcelable("fish", selectedFish);
                 bundle.putBoolean("isTank", true);
                 fragment.setArguments(bundle);

                 LinearLayout listLayout = findViewById(R.id.fragmentLayout);
                 LinearLayout fragLayout = new LinearLayout(this);
                 int fragId = View.generateViewId();
                 fragLayout.setId(fragId);
                 listLayout.addView(fragLayout);

                 FragmentManager manager = getSupportFragmentManager();
                 FragmentTransaction transaction = manager.beginTransaction();
                 transaction.replace(fragId, fragment).commit();

                 Boolean isCompatible = true;

                 for (Fish fishB : tankFish) {
                     if (!selectedFish.areFishCompatible(fishB)) {
                         isCompatible = false;

                         notCompText = new TextView(this);
                         notCompText.setText("This fish is not compatible with " + fishB.getName());
                         notCompText.setTextColor(ContextCompat.getColor(this, R.color.red));
                         listLayout.addView(notCompText);

                         break;
                     }
                 }

                 if (isCompatible) {
                    isCompatText.setVisibility(View.VISIBLE);
                 }

                 // Sets selection to 'select fish...' so 'Fish already added' message can be
                 // displayed when the same fish is selected.
                 adapterView.setSelection(0);
             }
         }
     }

     @Override
     public void onNothingSelected(AdapterView<?> adapterView) {

     }

     public void openMain(View view) {
         Intent openMainIntent = new Intent(getApplicationContext(), MainActivity.class);
         startActivity(openMainIntent);
     }

     public void removeFragment(FragmentManager fragmentManager, int id) {
        Fragment fragment = fragmentManager.findFragmentById(id);
        FishFragment fishFrag = (FishFragment) fragment;
        Fish fish = fishFrag.getShownFish();
        tankFish.removeAll(Collections.singleton(fish));

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment).commit();

        if (notCompText != null) {
            ((ViewGroup) notCompText.getParent()).removeView(notCompText);
            notCompText = null;
        }
     }
}