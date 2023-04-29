package com.example.fishcompatibility;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;

public class FishViewAdapter extends ArrayAdapter<Fish>  {
    private Fish mFish;
    private final Context mContext;

    private static class ViewElements {
        ImageView image;
        TextView name;
        TextView sciName;
        TextView aliases;
    }

    public FishViewAdapter(Fish[] pFishes, Context pContext) {
        super(pContext, R.layout.fish_list_item, pFishes);
        this.mContext = pContext;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        mFish = getItem(position);
        ViewElements elements;

        final View result;

        // Checks if View is being reused or not
        if (convertView == null) {
            elements = new ViewElements();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fish_list_item, parent, false);
            elements.name = (TextView) convertView.findViewById(R.id.fishName);
            elements.aliases = (TextView) convertView.findViewById(R.id.alias);
            elements.sciName = (TextView) convertView.findViewById(R.id.scientificName);
            elements.image = (ImageView) convertView.findViewById(R.id.fishImage);

            result = convertView;
            convertView.setTag(elements);
        } else {
            elements = (ViewElements) convertView.getTag();
            result = convertView;
        }

        String aliasList = "";

        for (int i = 0; i < mFish.getAliases().length; i++) {
            aliasList = aliasList + mFish.getAliases()[i];

            if (i != mFish.getAliases().length - 1) {
                aliasList = aliasList + ", ";
            }
        }

        String imageUrl = mFish.getImageUrl();
        String drawableSource = "@drawable/" + imageUrl;
        int imageRes = mContext.getResources().getIdentifier(drawableSource, null, mContext.getPackageName());
        Drawable drawable = AppCompatResources.getDrawable(mContext, imageRes);
        elements.image.setImageDrawable(drawable);
        elements.name.setText(mFish.getName());
        elements.sciName.setText(mFish.getSciName());
        elements.aliases.setText(aliasList);

        return convertView;
    }

    public Fish getFish() {
        return mFish;
    }
}
