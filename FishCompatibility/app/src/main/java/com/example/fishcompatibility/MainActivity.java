package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private Fish[] fishes;
    private Disease[] diseases;

    /**
     * Initialises application and reads data from JSON file.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReadJson readJson = new ReadJson(this);
        fishes = readJson.getFishFromJson();
        diseases = readJson.getDiseasesFromJson();
    }

    /** Called when the fish search button is clicked */
    public void openFishSearch(View view) {
        Intent openSearchIntent = new Intent(getApplicationContext(), FishSearchActivity.class);
        openSearchIntent.putExtra("fishes", fishes);
        startActivity(openSearchIntent);
    }

    /** Called when the disease search button is clicked */
    public void openDiseaseSearch(View view) {
        Intent openSearchIntent = new Intent(getApplicationContext(), DiseaseSearchActivity.class);
        openSearchIntent.putExtra("diseases", diseases);
        startActivity(openSearchIntent);
    }

    /** Called when the compare button is clicked */
    public void openCompare(View view) {
        Intent openCompareIntent = new Intent(getApplicationContext(), CompareActivity.class);
        openCompareIntent.putExtra("fishes", fishes);
        startActivity(openCompareIntent);
    }

    /** Called when the virtual tank button is clicked */
    public void openTank(View view) {
        Intent openTankIntent = new Intent(getApplicationContext(), TankActivity.class);
        openTankIntent.putExtra("fishes", fishes);
        startActivity(openTankIntent);
    }
}