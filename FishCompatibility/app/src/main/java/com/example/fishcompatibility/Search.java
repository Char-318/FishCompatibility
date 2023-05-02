package com.example.fishcompatibility;

import java.util.ArrayList;

public class Search {
    public Search() {}

    /**
     * Searches the disease data to check if a disease matches the searchText.
     * @param searchText Contains the input into the search text box in lower-case.
     * @return A list of all diseases that match the input string.
     */
    public ArrayList<Disease> searchDisease(String searchText, Disease[] diseases) {
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

    /**
     * Searches the fish data to check if a fish matches the searchText.
     * @param searchText Contains the input into the search text box in lower-case.
     * @return A list of all fish that match the input string.
     */
    public ArrayList<Fish> searchFish(String searchText, Fish[] fishes) {
        ArrayList<Fish> resultArray = new ArrayList<>();

        for (Fish fish : fishes) {
            if (fish.getName().toLowerCase().contains(searchText)
                    || fish.getSciName().toLowerCase().contains(searchText)) {
                resultArray.add(fish);
            } else {
                for (String alias : fish.getAliases()) {
                    if (alias.toLowerCase().contains(searchText)) {
                        resultArray.add(fish);
                        break;
                    }
                }
            }
        }

        return resultArray;
    }
}
