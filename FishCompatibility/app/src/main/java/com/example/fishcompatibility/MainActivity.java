package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Fish[] fishes;
    private Disease[] diseases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataFromJson();
    }

    /** Called when the search button is clicked */
    public void openSearch(View view) {
        Intent openSearchIntent = new Intent(getApplicationContext(), SearchActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelableArray("fishes", fishes);
        extras.putParcelableArray("diseases", diseases);
        openSearchIntent.putExtras(extras);
        startActivity(openSearchIntent);
    }

    /**
     * Uses an InputStream to read data in from the json file.
     * @return String containing the contents of the json file.
     */
    private String loadJsonAsString() {
        String json;

        try {
            InputStream inputStream = getResources().openRawResource(R.raw.content);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }

    /**
     * Populates the global arrays fishes and diseases to contain the contents from the json file.
     */
    private void getDataFromJson() {
        try {
            JSONObject jsonObject = new JSONObject(loadJsonAsString());

            // Getting data for each fish
            JSONArray fishJsonArray = jsonObject.getJSONArray("fish");
            fishes = new Fish[fishJsonArray.length()];

            for (int i = 0; i < fishes.length; i++) {
                JSONObject fishObject = fishJsonArray.getJSONObject(i);

                String name = fishObject.getString("name");
                String sciName = fishObject.getString("scientificName");
                String vore = fishObject.getString("vore");
                String imageUrl = fishObject.getString("image");

                JSONArray jsonAliases = fishObject.getJSONArray("aliases");
                String[] aliases = new String[jsonAliases.length()];
                for (int j = 0; j < aliases.length; j++) {
                    aliases[j] = jsonAliases.getString(j);
                }

                JSONArray jsonFoodTypes = fishObject.getJSONArray("foodType");
                String[] foodTypes = new String[jsonFoodTypes.length()];
                for (int j = 0; j < foodTypes.length; j++) {
                    foodTypes[j] = jsonFoodTypes.getString(j);
                }

                JSONArray jsonSubstrates = fishObject.getJSONArray("substrate");
                String[] substrates = new String[jsonSubstrates.length()];
                for (int j = 0; j < substrates.length; j++) {
                    substrates[j] = jsonSubstrates.getString(j);
                }

                int minCurr = fishObject.getInt("minWaterCurrent");
                int maxCurr = fishObject.getInt("maxWaterCurrent");
                int minSwimLvl = fishObject.getInt("minSwimLevel");
                int maxSwimLvl = fishObject.getInt("maxSwimLevel");
                int minPop = fishObject.getInt("minPopulation");
                int maxPop = fishObject.getInt("maxPopulation");

                double minTemp = fishObject.getDouble("minTemp");
                double maxTemp = fishObject.getDouble("maxTemp");
                double minAcidity = fishObject.getDouble("minAcidity");
                double maxAcidity = fishObject.getDouble("maxAcidity");
                double minGenHard = fishObject.getDouble("minGenHard");
                double maxGenHard = fishObject.getDouble("maxGenHard");
                double minCarbHard = fishObject.getDouble("minCarbHard");
                double maxCarbHard = fishObject.getDouble("maxCarbHard");
                double size = fishObject.getDouble("averageSize");
                double edibleSize = fishObject.getDouble("edibleSize");
                double lifeExp = fishObject.getDouble("lifeExpectancy");

                boolean finNipper = fishObject.getBoolean("finNipper");
                boolean longFins = fishObject.getBoolean("longFins");
                boolean aggressive = fishObject.getBoolean("aggressive");
                boolean hardy = fishObject.getBoolean("hardy");
                boolean territorial = fishObject.getBoolean("territorial");
                boolean fast = fishObject.getBoolean("fast");

                // Populating fishes array
                Fish fish = new Fish(name, sciName, vore, imageUrl, aliases, foodTypes, substrates, minCurr,
                        maxCurr, minSwimLvl, maxSwimLvl, minPop, maxPop, minTemp, maxTemp, 
                        minAcidity, maxAcidity, minGenHard, maxGenHard, minCarbHard, maxCarbHard, 
                        size, edibleSize, lifeExp, finNipper, longFins, aggressive, hardy, 
                        territorial, fast);
                fishes[i] = fish;
            }

            // Getting data for each disease
            JSONArray diseaseJsonArray = jsonObject.getJSONArray("diseases");
            diseases = new Disease[diseaseJsonArray.length()];
            
            for (int i = 0; i < diseases.length; i++) {
                JSONObject diseaseObject = diseaseJsonArray.getJSONObject(i);

                String name = diseaseObject.getString("name");

                JSONArray jsonAliases = diseaseObject.getJSONArray("alias");
                String[] aliases = new String[jsonAliases.length()];
                for (int j = 0; j < aliases.length; j++) {
                    aliases[j] = jsonAliases.getString(j);
                }

                JSONArray jsonSymptoms = diseaseObject.getJSONArray("symptoms");
                String[] symptoms = new String[jsonSymptoms.length()];
                for (int j = 0; j < symptoms.length; j++) {
                    symptoms[j] = jsonSymptoms.getString(j);
                }

                JSONArray jsonCauses = diseaseObject.getJSONArray("causes");
                String[] causes = new String[jsonCauses.length()];
                for (int j = 0; j < causes.length; j++) {
                    causes[j] = jsonCauses.getString(j);
                }

                JSONArray jsonPreventions = diseaseObject.getJSONArray("prevention");
                String[] preventions = new String[jsonPreventions.length()];
                for (int j = 0; j < preventions.length; j++) {
                    preventions[j] = jsonPreventions.getString(j);
                }

                JSONArray jsonTreatments = diseaseObject.getJSONArray("treatment");
                String[] treatments = new String[jsonTreatments.length()];
                for (int j = 0; j < treatments.length; j++) {
                    treatments[j] = jsonTreatments.getString(j);
                }

                // Populating diseases array
                Disease disease = new Disease(
                        name, aliases, symptoms, causes, preventions, treatments);
                diseases[i] = disease;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Uses image url to select a .png image from the resource file.
     * @param pUrl Url of the image to be selected. Comes from the json file.
     * @return Drawable of the image.
     */
    private Drawable urlToDrawable(String pUrl) {
        int imageResource = getResources().getIdentifier(
                "@drawable/" + pUrl, null, getPackageName());

        return AppCompatResources.getDrawable(getApplicationContext(), imageResource);
    }
}