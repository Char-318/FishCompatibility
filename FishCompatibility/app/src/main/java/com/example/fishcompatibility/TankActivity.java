 package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

 public class TankActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
     private final ArrayList<Fish> tankFish = new ArrayList<>();
     private final ArrayList<Integer> notCompTextIds = new ArrayList<>();
     private int paramId = -1;
     private final ArrayList<Integer> fragIds = new ArrayList<>();
     private Fish[] fishes;
     private LinearLayout listLayout;
     private double maxTemp;
     private double minTemp;
     private double maxAcid;
     private double minAcid;
     private double maxCarb;
     private double minCarb;
     private double maxGen;
     private double minGen;
     private int maxCurr;
     private int minCurr;
     private boolean paramsChecked = false;

     /**
      * Initialises the virtual tank activity and creates the dropdown menus.
      */
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tank);

        Spinner spinner = findViewById(R.id.fishSpinner);
        spinner.setOnItemSelectedListener(this);

        // Populating arrays
        Parcelable[] parcelable = getIntent().getExtras().getParcelableArray("fishes");
        fishes = new Fish[parcelable.length];
        String[] fishNames = new String[parcelable.length + 1];
        fishNames[0] = "Select a fish...";

        for (int i = 0; i < parcelable.length; i++) {
            Fish fish = (Fish) parcelable[i];
            String fishName = fish.getName();
            fishes[i] = fish;
            fishNames[i + 1] = fishName;
        }

        // Creating dropdown menus
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fishNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);
    }

     /**
      * What happens when an item from the dropdown menu is selected - overview of selected fish is
      * displayed, added to the virtual tank and the fish are compared.
      * @param adapterView AdapterView of the dropdown menu an item has been selected from.
      * @param view View of the current activity.
      * @param i Index of the item selected.
      */
     @Override
     public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         if (i != 0) {
             TextView fishAddedText = (TextView) findViewById(R.id.fishAdded);
             TextView isCompatText = (TextView) findViewById(R.id.fishIsCompat);
             Fish selectedFish = fishes[i - 1];

             // If virtual tank already contains the selected fish
             if (tankFish.contains(fishes[i - 1])) {
                 fishAddedText.setVisibility(View.VISIBLE);
             } else {
                 tankFish.add(selectedFish);
                 fishAddedText.setVisibility(View.INVISIBLE);
                 isCompatText.setVisibility(View.INVISIBLE);
                 LinearLayout linearLayout = findViewById(R.id.linearLayout);

                 // Removing water parameters
                 if (paramId != -1) {
                     TextView paramsTextView = (TextView) linearLayout.findViewById(paramId);
                     linearLayout.removeView(paramsTextView);
                     paramId = -1;
                 }

                 // Creating the fragment
                 FishFragment fragment = (FishFragment) getSupportFragmentManager()
                         .findFragmentByTag("fishFragment");

                 if (fragment == null) {
                     fragment = new FishFragment();
                 }

                 Bundle bundle = new Bundle();
                 bundle.putParcelable("fish", selectedFish);
                 bundle.putBoolean("isTank", true);
                 fragment.setArguments(bundle);

                 // Displaying the fragment
                 listLayout = findViewById(R.id.fragmentLayout);
                 LinearLayout fragLayout = new LinearLayout(this);
                 int fragId = View.generateViewId();
                 fragIds.add(fragId);
                 fragLayout.setId(fragId);
                 listLayout.addView(fragLayout);

                 FragmentManager manager = getSupportFragmentManager();
                 FragmentTransaction transaction = manager.beginTransaction();
                 transaction.replace(fragId, fragment).commit();

                 // Checking compatibility
                 boolean isCompatible = checkAllFish(selectedFish);
                 paramsChecked = false;

                 if (isCompatible) {
                     isCompatText.setVisibility(View.VISIBLE);
                     createParamsText();
                 }

                 // Sets selection to 'select fish...' so 'Fish already added' message can be
                 // displayed when the same fish is selected.
                 adapterView.setSelection(0);
             }
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
      * Removes a fish from the virtual tank by removing the fragment from the linear layout and
      * removing it from the list of fish.
      * @param fragmentManager Fragment manager containing the list of fragments in the virtual tank
      * @param id ID of the fragment to be removed
      */
     public void removeFragment(FragmentManager fragmentManager, int id) {
         TextView isCompatText = (TextView) findViewById(R.id.fishIsCompat);
         isCompatText.setVisibility(View.INVISIBLE);

         // Removing fragment from list
         Fragment fragment = fragmentManager.findFragmentById(id);
         FishFragment fishFrag = (FishFragment) fragment;
         Fish fish = fishFrag.getShownFish();
         tankFish.removeAll(Collections.singleton(fish));
         fragIds.removeAll(Collections.singleton(id));
         listLayout.removeView(listLayout.findViewById(id));
         LinearLayout linearLayout = findViewById(R.id.linearLayout);

         // Removing all TextViews that say which fish aren't compatible
         for (int textId : notCompTextIds) {
             TextView notCompText = (TextView) listLayout.findViewById(textId);
             listLayout.removeView(notCompText);
         }

         // Removing water parameters
         if (paramId != -1) {
             TextView paramsTextView = (TextView) linearLayout.findViewById(paramId);
             linearLayout.removeView(paramsTextView);
             paramId = -1;
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
         paramsChecked = false;

         if (tankFish.size() != 0 && isCompatible) {
             isCompatText.setVisibility(View.VISIBLE);
             createParamsText();
         }
     }

     /**
      * Removes all fish from the virtual tank by removing all fragments and text views.
      */
     public void clearList(View view) {
         listLayout = findViewById(R.id.fragmentLayout);
         LinearLayout linearLayout = findViewById(R.id.linearLayout);
         listLayout.removeAllViews();
         tankFish.clear();
         notCompTextIds.clear();
         fragIds.clear();

         // Removing water parameters
         if (paramId != -1) {
             TextView paramsTextView = (TextView) linearLayout.findViewById(paramId);
             linearLayout.removeView(paramsTextView);
             paramId = -1;
         }

         TextView fishAddedText = (TextView) findViewById(R.id.fishAdded);
         TextView isCompatText = (TextView) findViewById(R.id.fishIsCompat);
         fishAddedText.setVisibility(View.INVISIBLE);
         isCompatText.setVisibility(View.INVISIBLE);
     }

     /**
      * Calls comparison algorithm on every fish in the virtual tank
      * @param selectedFish Fish that will be compared to all other fish.
      * @return True if all fish are compatible, false if not.
      */
     public boolean checkAllFish(Fish selectedFish) {
         boolean isCompatible = true;

         for (int i = 0; i < tankFish.size(); i++) {
             Fish fishB = tankFish.get(i);

             // Calculates minimum and maximum parameters for fish in the virtual tank
             if (!paramsChecked) {
                 // paramsChecked used so code is not repeated for each fish in the tank when
                 // removing a fish
                 paramsChecked = true;

                 maxTemp = selectedFish.getMaxTemp();
                 minTemp = selectedFish.getMinTemp();
                 maxAcid = selectedFish.getMaxAcidity();
                 minAcid = selectedFish.getMinAcidity();
                 maxCarb = selectedFish.getMaxCarbHard();
                 minCarb = selectedFish.getMinCarbHard();
                 maxGen = selectedFish.getMaxGenHard();
                 minGen = selectedFish.getMinGenHard();
                 maxCurr = selectedFish.getMaxCurr();
                 minCurr = selectedFish.getMinCurr();

                 if (fishB.getMaxTemp() < maxTemp) {
                     maxTemp = fishB.getMaxTemp();
                 }
                 if (fishB.getMinTemp() > minTemp) {
                     minTemp = fishB.getMinTemp();
                 }
                 if (fishB.getMaxAcidity() < maxAcid) {
                     maxAcid = fishB.getMaxAcidity();
                 }
                 if (fishB.getMinAcidity() > minAcid) {
                     minAcid = fishB.getMinAcidity();
                 }
                 if (fishB.getMaxCarbHard() < maxCarb) {
                     maxCarb = fishB.getMaxCarbHard();
                 }
                 if (fishB.getMinCarbHard() > minCarb) {
                     minCarb = fishB.getMinCarbHard();
                 }
                 if (fishB.getMaxGenHard() < maxGen) {
                     maxGen = fishB.getMaxGenHard();
                 }
                 if (fishB.getMinGenHard() > minGen) {
                     minGen = fishB.getMinGenHard();
                 }
                 if (fishB.getMaxCurr() < maxCurr) {
                     maxCurr = fishB.getMaxCurr();
                 }
                 if (fishB.getMinCurr() > minCurr) {
                     minCurr = fishB.getMinCurr();
                 }
             }

             if (fishB == selectedFish) {
                 break;
             }

             Compatibility comp = selectedFish.areFishCompatible(fishB);

             // If fish are incompatible display error messages
             if (!comp.getIsComp()) {
                 isCompatible = false;

                 int selectedFishIndex = tankFish.indexOf(selectedFish);
                 int selectedFragId = fragIds.get(selectedFishIndex);
                 View selectedFragView = listLayout.findViewById(selectedFragId);
                 int selectedPosition = listLayout.indexOfChild(selectedFragView) + 1;
                 createNotCompText(fishB, selectedPosition, comp.getReason());

                 int fishBFragId = fragIds.get(i);
                 View fishBFragView = listLayout.findViewById(fishBFragId);
                 int fishBPosition = listLayout.indexOfChild(fishBFragView) + 1;
                 createNotCompText(selectedFish, fishBPosition, comp.getReason());
             }
         }

         return isCompatible;
     }

     /**
      * Create text views to contain the error messages.
      * @param fish Fish that is incompatible - message should be displayed
      *             after this fish's fragment.
      * @param position Position in the layout where the text view should be added.
      * @param reason String containing why the fish are incompatible.
      */
     private void createNotCompText(Fish fish, int position, String reason) {
         TextView notCompText = new TextView(this);
         int textId = View.generateViewId();
         notCompTextIds.add(textId);
         notCompText.setId(textId);
         notCompText.setTextColor(ContextCompat.getColor(this, R.color.red));

         notCompText.setText("This fish is not compatible with " + fish.getName() + " - " + reason);
         listLayout.addView(notCompText, position);
     }

     /**
      * Creating a text view that will display the possible water
      * parameters the virtual tank can have.
      */
     private void createParamsText() {
         LinearLayout linearLayout = findViewById(R.id.linearLayout);
         TextView isCompatText = (TextView) findViewById(R.id.fishIsCompat);
         int isCompatPos = linearLayout.indexOfChild(isCompatText) + 1;

         String params = "Water Parameters: \nTemperature: ";
         if (maxTemp == minTemp) {
             params = params + maxTemp + " \u00B0C \n";
         } else {
             params = params + minTemp + " \u00B0C - " + maxTemp + " \u00B0C \n";
         }

         params = params + "Acidity: ";
         if (maxAcid == minAcid) {
             params = params + maxAcid + " pH \n";
         } else {
             params = params + minAcid + " pH - " + maxAcid + " pH \n";
         }

         params = params + "General hardness: ";
         if (minGen == maxGen) {
             params = params + minGen + " dGH \n";
         } else {
             params = params + minGen + " dGH - " + maxGen + " dGH \n";
         }

         params = params + "Carbonate hardness: ";
         if (minCarb == maxCarb) {
             params = params + minCarb + " dKH \n";
         } else {
             params = params + minCarb + " dKH - " + maxCarb + " dKH \n";
         }

         params = params + "Water current: ";
         switch (minCurr) {
             case 1:
                 params = params + "Low";
                 break;
             case 2:
                 params = params + "Medium";
                 break;
             case 3:
                 params = params + "High";
                 break;
             default:
                 params = params + "None";
                 break;
         }
         if (minCurr == maxCurr) {
             switch (maxCurr) {
                 case 1:
                     params = params + " - low";
                     break;
                 case 2:
                     params = params + " - medium";
                     break;
                 case 3:
                     params = params + " - high";
                     break;
             }
         }

         // Displaying the text view
         TextView paramsTextView = new TextView(this);
         paramId = View.generateViewId();
         paramsTextView.setId(paramId);
         paramsTextView.setText(params);
         paramsTextView.setTextColor(ContextCompat.getColor(this, R.color.green));
         linearLayout.addView(paramsTextView, isCompatPos);
     }
 }