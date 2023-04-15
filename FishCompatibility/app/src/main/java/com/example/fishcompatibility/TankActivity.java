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
     ArrayList<Integer> notCompTextIds = new ArrayList<>();
     ArrayList<Integer> fragIds = new ArrayList<>();

     Fish[] fishes;
     String[] fishNames;
     LinearLayout listLayout;

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

                 FishFragment fragment = (FishFragment) getSupportFragmentManager()
                         .findFragmentByTag("fishFragment");

                 if (fragment == null) {
                     fragment = new FishFragment();
                 }

                 Bundle bundle = new Bundle();
                 bundle.putParcelable("fish", selectedFish);
                 bundle.putBoolean("isTank", true);
                 fragment.setArguments(bundle);

                 listLayout = findViewById(R.id.fragmentLayout);
                 LinearLayout fragLayout = new LinearLayout(this);
                 int fragId = View.generateViewId();
                 fragIds.add(fragId);
                 fragLayout.setId(fragId);
                 listLayout.addView(fragLayout);

                 FragmentManager manager = getSupportFragmentManager();
                 FragmentTransaction transaction = manager.beginTransaction();
                 transaction.replace(fragId, fragment).commit();

                 boolean isCompatible = checkAllFish(selectedFish);

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
         TextView isCompatText = (TextView) findViewById(R.id.fishIsCompat);
         isCompatText.setVisibility(View.INVISIBLE);

         Fragment fragment = fragmentManager.findFragmentById(id);
         FishFragment fishFrag = (FishFragment) fragment;
         Fish fish = fishFrag.getShownFish();
         tankFish.removeAll(Collections.singleton(fish));
         fragIds.removeAll(Collections.singleton(id));
         listLayout.removeView(listLayout.findViewById(id));

         // Removing all TextViews that say which fish aren't compatible
         for (int textId : notCompTextIds) {
             TextView notCompText = (TextView) listLayout.findViewById(textId);
             listLayout.removeView(notCompText);
         }

         notCompTextIds.clear();
         boolean isCompatible = true;

         // Checks if all remaining fish are compatible
         for (int i = 0; i < tankFish.size(); i++) {
             boolean thisCompatible = checkAllFish(tankFish.get(i));

             if (isCompatible) {
                 isCompatible = thisCompatible;
             }
         }

         if (tankFish.size() != 0 && isCompatible) {
             isCompatText.setVisibility(View.VISIBLE);
         }
     }

     public void clearList(View view) {
         listLayout = findViewById(R.id.fragmentLayout);
         listLayout.removeAllViews();
         tankFish.clear();
         notCompTextIds.clear();
         fragIds.clear();
         TextView fishAddedText = (TextView) findViewById(R.id.fishAdded);
         TextView isCompatText = (TextView) findViewById(R.id.fishIsCompat);
         fishAddedText.setVisibility(View.INVISIBLE);
         isCompatText.setVisibility(View.INVISIBLE);
     }

     public boolean checkAllFish(Fish selectedFish) {
         boolean isCompatible = true;

         for (int i = 0; i < tankFish.size(); i++) {
             Fish fishB = tankFish.get(i);

             if (fishB == selectedFish) {
                 break;
             }

             if (!selectedFish.areFishCompatible(fishB)) {
                 isCompatible = false;

                 int selectedFishIndex = tankFish.indexOf(selectedFish);
                 int selectedFragId = fragIds.get(selectedFishIndex);
                 View selectedFragView = listLayout.findViewById(selectedFragId);
                 int selectedPosition = listLayout.indexOfChild(selectedFragView) + 1;
                 createNotCompText(fishB, selectedPosition);

                 int fishBFragId = fragIds.get(i);
                 View fishBFragView = listLayout.findViewById(fishBFragId);
                 int fishBPosition = listLayout.indexOfChild(fishBFragView) + 1;
                 createNotCompText(selectedFish, fishBPosition);
             }
         }

         return isCompatible;
     }

     private void createNotCompText(Fish fish, int position) {
         TextView notCompText = new TextView(this);
         int textId = View.generateViewId();
         notCompTextIds.add(textId);
         notCompText.setId(textId);
         notCompText.setText("This fish is not compatible with " + fish.getName());
         notCompText.setTextColor(ContextCompat.getColor(this, R.color.red));
         listLayout.addView(notCompText, position);
     }
 }