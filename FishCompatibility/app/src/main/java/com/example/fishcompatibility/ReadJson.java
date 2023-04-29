package com.example.fishcompatibility;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ReadJson {
    private JSONObject jsonObject;

    public ReadJson(Context context) {
        loadJsonAsString(context);
    }

    /**
     * Uses an InputStream to read data in from the json file.
     * @return String containing the contents of the json file.
     */
    private void loadJsonAsString(Context context) {
        String json;

        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.content);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Populates the global arrays fishes and diseases to contain the contents from the json file.
     */
    public Fish[] getFishFromJson() {
        Fish[] fishes;

        try {
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
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return fishes;
    }

    public Disease[] getDiseasesFromJson() {
        Disease[] diseases;

        try {
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
            return null;
        }

        return diseases;
    }
}
