package com.example.fishcompatibility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ViewAdapter extends ArrayAdapter<Fish> implements View.OnClickListener {
    private Fish[] fishes;
    Context mContext;

    private static class ViewElements {
        ImageView image;
        TextView name;
        TextView sciName;
        TextView aliases;
    }

    public ViewAdapter(Fish[] pFishes, Context pContext) {
        super(pContext, R.layout.fish_list_item, pFishes);
        this.fishes = pFishes;
        this.mContext = pContext;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fish fish = getItem(position);
        ViewElements elements;

        final View result;

        // Checks if View is being reused or not
        if (convertView == null) {
            elements = new ViewElements();
            LayoutInflater inflater = LayoutInflater.from(getContext());
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

        for (int i = 0; i < fish.getAliases().length; i++) {
            aliasList = aliasList + fish.getAliases()[i];

            if (i != fish.getAliases().length - 1) {
                aliasList = aliasList + ", ";
            }
        }

        elements.image.setImageDrawable(fish.getImage());
        elements.name.setText(fish.getName());
        elements.sciName.setText(fish.getSciName());
        elements.aliases.setText(aliasList);

        return convertView;
    }

    @Override
    public void onClick(View view) {
        // TODO: Open fish profile page
    }
}
