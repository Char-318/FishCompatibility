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
    private Fish mFish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);

        Parcelable parcelable = getIntent().getExtras().getParcelable("fish");
        mFish = (Fish) parcelable;

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
        String imageUrl = mFish.getImageUrl();
        String drawableSource = "@drawable/" + imageUrl;
        int imageRes = getApplicationContext().getResources().getIdentifier(drawableSource, null, getApplicationContext().getPackageName());
        Drawable drawable = AppCompatResources.getDrawable(getApplicationContext(), imageRes);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageDrawable(drawable);

        TextView title = findViewById(R.id.fishTitle);
        title.setText(mFish.getName());

        TextView sciName = findViewById(R.id.sci_name);
        sciName.setText(mFish.getSciName());

        TextView aliases = findViewById(R.id.alias);
        String aliasText = "";
        for (String alias : mFish.getAliases()) {
            aliasText = aliasText + "\n" + alias;
        }
        aliasText = aliasText.substring(1);
        aliases.setText(aliasText);

        TextView temp = findViewById(R.id.temp);
        String tempText = mFish.getMinTemp() + " \u00B0C - " + mFish.getMaxTemp() + " \u00B0C";
        temp.setText(tempText);

        TextView acidity = findViewById(R.id.acidity);
        String acidText = mFish.getMinAcidity() + " pH - " + mFish.getMaxAcidity() + " pH";
        acidity.setText(acidText);

        TextView genHard = findViewById(R.id.gen_hard);
        String genText = mFish.getMinGenHard() + " dGH - " + mFish.getMaxGenHard() + " dGH";
        genHard.setText(genText);

        TextView carbHard = findViewById(R.id.carb_hard);
        String carbText = mFish.getMinCarbHard() + " dKH - " + mFish.getMaxCarbHard() + " dKH";
        carbHard.setText(carbText);

        TextView vore = findViewById(R.id.vore);
        vore.setText(mFish.getVore());

        TextView foodType = findViewById(R.id.food_type);
        String foodText = "";
        for (String food : mFish.getFoodType()) {
            foodText = foodText + "\n" + food;
        }
        foodText = foodText.substring(1);
        foodType.setText(foodText);

        TextView avgSize = findViewById(R.id.avg_size);
        String sizeText = mFish.getSize() + " cm";
        avgSize.setText(sizeText);

        TextView lifeExp = findViewById(R.id.life_exp);
        String lifeExpText = mFish.getLifeExp() + " years";
        lifeExp.setText(lifeExpText);

        TextView curr = findViewById(R.id.curr);
        String currText;
        switch (mFish.getMinCurr()) {
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
        if (mFish.getMinCurr() != mFish.getMaxCurr()) {
            switch (mFish.getMaxCurr()) {
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
        for (String substrate : mFish.getSubstrate()) {
            substrateText = substrateText + "\n" + substrate;
        }
        substrateText = substrateText.substring(1);
        substrates.setText(substrateText);

        TextView swimLvl = findViewById(R.id.swim_lvl);
        String swimText;
        switch (mFish.getMinSwimLvl()) {
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
        if (mFish.getMinSwimLvl() != mFish.getMaxSwimLvl()) {
            switch (mFish.getMaxSwimLvl()) {
                case 1:
                    swimText = swimText + " - middle";
                    break;
                case 2:
                    swimText = swimText + " - top";
                    break;
            }
        }
        swimLvl.setText(swimText);

        TextView pop = findViewById(R.id.pop);
        String popText = mFish.getMinPop() + " - " + mFish.getMaxPop();
        pop.setText(popText);
    }
}