package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FishActivity extends AppCompatActivity {
    private Fish fish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);

        Parcelable parcelable = getIntent().getExtras().getParcelable("fish");
        fish = (Fish) parcelable;

        setData();
    }

    public void openMain(View view) {
        Intent openMainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openMainIntent);
    }

    /**
     * Uses data contained in Fish object to populate TextViews and ImageView.
     */
    private void setData() {
        String imageUrl = fish.getImageUrl();
        String drawableSource = "@drawable/" + imageUrl;
        int imageRes = getApplicationContext().getResources().getIdentifier(drawableSource, null, getApplicationContext().getPackageName());
        Drawable drawable = AppCompatResources.getDrawable(getApplicationContext(), imageRes);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageDrawable(drawable);

        TextView title = findViewById(R.id.fishTitle);
        title.setText(fish.getName());

        TextView sciName = findViewById(R.id.sci_name);
        sciName.setText(fish.getSciName());

        TextView aliases = findViewById(R.id.alias);
        String aliasText = "";
        for (String alias : fish.getAliases()) {
            aliasText = aliasText + "\n" + alias;
        }
        if (aliasText.length() > 0) {
            aliasText = aliasText.substring(1);
            aliases.setText(aliasText);
        }

        TextView temp = findViewById(R.id.temp);
        String tempText = fish.getMinTemp() + " \u00B0C - " + fish.getMaxTemp() + " \u00B0C";
        temp.setText(tempText);

        TextView acidity = findViewById(R.id.acidity);
        String acidText = fish.getMinAcidity() + " pH - " + fish.getMaxAcidity() + " pH";
        acidity.setText(acidText);

        TextView genHard = findViewById(R.id.gen_hard);
        String genText = fish.getMinGenHard() + " dGH - " + fish.getMaxGenHard() + " dGH";
        genHard.setText(genText);

        TextView carbHard = findViewById(R.id.carb_hard);
        String carbText = fish.getMinCarbHard() + " dKH - " + fish.getMaxCarbHard() + " dKH";
        carbHard.setText(carbText);

        TextView vore = findViewById(R.id.vore);
        vore.setText(fish.getVore());

        TextView foodType = findViewById(R.id.food_type);
        String foodText = "";
        for (String food : fish.getFoodType()) {
            foodText = foodText + "\n" + food;
        }
        if (foodText.length() > 0) {
            foodText = foodText.substring(1);
            foodType.setText(foodText);
        }

        TextView avgSize = findViewById(R.id.avg_size);
        String sizeText = fish.getSize() + " cm";
        avgSize.setText(sizeText);

        TextView lifeExp = findViewById(R.id.life_exp);
        String lifeExpText = fish.getLifeExp() + " years";
        lifeExp.setText(lifeExpText);

        TextView curr = findViewById(R.id.curr);
        String currText;
        switch (fish.getMinCurr()) {
            case 1:
                currText = "Low";
                break;
            case 2:
                currText = "Medium";
                break;
            case 3:
                currText = "High";
                break;
            default:
                currText = "None";
                break;
        }
        if (fish.getMinCurr() != fish.getMaxCurr()) {
            switch (fish.getMaxCurr()) {
                case 1:
                    currText = currText + " - low";
                    break;
                case 2:
                    currText = currText + " - medium";
                    break;
                case 3:
                    currText = currText + " - high";
                    break;
            }
        }
        curr.setText(currText);

        TextView substrates = findViewById(R.id.substrate);
        String substrateText = "";
        for (String substrate : fish.getSubstrate()) {
            substrateText = substrateText + "\n" + substrate;
        }
        if (substrateText.length() > 0) {
            substrateText = substrateText.substring(1);
            substrates.setText(substrateText);
        }

        TextView swimLvl = findViewById(R.id.swim_lvl);
        String swimText;
        switch (fish.getMinSwimLvl()) {
            case 1:
                swimText = "Middle";
                break;
            case 2:
                swimText = "Top";
                break;
            default:
                swimText = "Bottom";
                break;
        }
        if (fish.getMinSwimLvl() != fish.getMaxSwimLvl()) {
            switch (fish.getMaxSwimLvl()) {
                case 1:
                    swimText = swimText + " - middle";
                    break;
                case 2:
                    swimText = swimText + " - top";
                    break;
            }
        }
        swimText = swimText + " of the tank";
        swimLvl.setText(swimText);

        TextView pop = findViewById(R.id.pop);
        String popText;
        if (fish.getMaxPop() != 0) {
            popText = fish.getMinPop() + " - " + fish.getMaxPop();
        } else {
            popText = fish.getMinPop() + "+";
        }
        pop.setText(popText);

        TextView finNipper = findViewById(R.id.fin_nipper);
        String finNipperText;
        if (fish.isFinNipper()) {
            finNipperText = "Yes";
        } else {
            finNipperText = "No";
        }
        finNipper.setText(finNipperText);

        TextView aggressive = findViewById(R.id.aggressive);
        String aggressiveText;
        if (fish.isAggressive()) {
            aggressiveText = "Yes";
        } else {
            aggressiveText = "No";
        }
        aggressive.setText(aggressiveText);
    }
}