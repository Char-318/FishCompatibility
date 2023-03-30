 package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;
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

import java.util.ArrayList;

 public class TankActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
     ArrayList<Fish> tankFish = new ArrayList<>();
     Fish[] fishes;
     String[] fishNames;

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
             tankFish.add(fishes[i - 1]);

             FishFragment fragment = (FishFragment) getSupportFragmentManager()
                     .findFragmentByTag("fishFragment");

             if (fragment == null) {
                 fragment = new FishFragment();
             }

             Bundle bundle = new Bundle();
             bundle.putParcelable("fish", fishes[i - 1]);
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
         }
     }

     @Override
     public void onNothingSelected(AdapterView<?> adapterView) {

     }

     public void openMain(View view) {
         Intent openMainIntent = new Intent(getApplicationContext(), MainActivity.class);
         startActivity(openMainIntent);
     }
}