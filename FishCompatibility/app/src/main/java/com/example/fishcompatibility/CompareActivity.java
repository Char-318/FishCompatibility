package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class CompareActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Fish[] fishes;
    String[] fishNames;
    ArrayAdapter<String> arrayAdapterA;
    ArrayAdapter<String> arrayAdapterB;
    Fish fishA;
    Fish fishB;


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
        fishNames = new String[parcelable.length];

        for (int i = 0; i < parcelable.length; i++) {
            Fish fish = (Fish) parcelable[i];
            String fishName = fish.getName();
            fishes[i] = fish;
            fishNames[i] = fishName;
        }

        arrayAdapterA = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fishNames);
        arrayAdapterB = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fishNames);
        arrayAdapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerA.setAdapter(arrayAdapterA);
        spinnerB.setAdapter(arrayAdapterB);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getAdapter() == arrayAdapterA) {
            fishA = fishes[i];
        } else {
            fishB = fishes[i];
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void openMain(View view) {
        Intent openMainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openMainIntent);
    }

    private boolean areFishCompatible(Fish fishA, Fish fishB) {
        // Checks if there is at least 3 degrees of overlapping temperatures that satisfy each fish
        double tempDiffA = fishA.getMaxTemp() - fishB.getMinTemp();
        double tempDiffB = fishB.getMaxTemp() - fishA.getMinTemp();

        if (tempDiffA < tempDiffB) {
            if (tempDiffA < 3) {
                return false;
            }
        } else {
            if (tempDiffB < 3) {
                return false;
            }
        }

        // Checks if there is a pH level that satisfies both fish
        double acidityDiffA = fishA.getMaxAcidity() - fishB.getMinAcidity();
        double acidityDiffB = fishB.getMaxAcidity() - fishA.getMinAcidity();

        if (acidityDiffA < acidityDiffB) {
            if (acidityDiffA < 0) {
                return false;
            }
        } else {
            if (acidityDiffB < 0) {
                return false;
            }
        }

        // Checks if there is a degree of general hardness that satisfies each fish
        double genDiffA = fishA.getMaxGenHard() - fishB.getMinGenHard();
        double genDiffB = fishB.getMaxGenHard() - fishA.getMinGenHard();

        if (genDiffA < genDiffB) {
            if (genDiffA < 0) {
                return false;
            }
        } else {
            if (genDiffB < 0) {
                return false;
            }
        }

        // Checks that there is a degree of carbonate hardness that satisfies each fish
        double carbDiffA = fishA.getMaxCarbHard() - fishB.getMinCarbHard();
        double carbDiffB = fishB.getMaxCarbHard() - fishA.getMinCarbHard();

        if (carbDiffA < carbDiffB) {
            if (carbDiffA < 0) {
                return false;
            }
        } else {
            if (carbDiffB < 0) {
                return false;
            }
        }

        // Checks if one fish may get eaten by the other
        if (fishA.getSize() < fishA.getEdibleSize() || fishB.getSize() < fishA.getEdibleSize()) {
            return false;
        }

        // Checks if one fish will nip the fins of the other
        if ((fishA.isFinNipper() && fishB.isLongFins()) ||
                (fishB.isFinNipper() && fishA.isLongFins())) {
            return false;
        }

        // Checks if one fish will attack and injure the other
        if ((fishA.isAggressive() && !fishB.isHardy()) ||
                (fishB.isAggressive() && !fishA.isHardy())) {
            return false;
        }

        // Checks if fish swim at the same level and if they are territorial
        int swimDiffA = fishA.getMaxSwimLvl() - fishB.getMinSwimLvl();
        int swimDiffB = fishB.getMaxSwimLvl() - fishA.getMinSwimLvl();

        if (swimDiffA < swimDiffB) {
            if (swimDiffA >= 0 && (fishA.isTerritorial() || fishB.isTerritorial())) {
                return false;
            }
        } else {
            if (swimDiffB >= 0 && (fishA.isTerritorial() || fishB.isTerritorial())) {
                return false;
            }
        }

        // Checks if fish can swim in the same current strength
        int currDiffA = fishA.getMaxCurr() - fishB.getMinCurr();
        int currDiffB = fishB.getMaxCurr() - fishA.getMinCurr();

        if (currDiffA < currDiffB) {
            if (currDiffA < 0) {
                return false;
            }
        } else {
            if (currDiffB < 0) {
                return false;
            }
        }

        // Checks if fish eat the same type of food and if one is faster than the other
        for (String fishAFood : fishA.getFoodType()) {
            for (String fishBFood : fishB.getFoodType()) {
                if (fishAFood.equalsIgnoreCase(fishBFood) && fishA.isFast() != fishB.isFast()) {
                    return false;
                }
            }
        }

        return true;
    }
}