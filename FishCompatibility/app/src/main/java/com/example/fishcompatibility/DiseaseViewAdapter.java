package com.example.fishcompatibility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DiseaseViewAdapter extends ArrayAdapter<Disease> implements View.OnClickListener {
    private Disease[] diseases;
    Context mContext;

    private static class ViewElements {
        TextView name;
    }

    public DiseaseViewAdapter(Disease[] pDiseases, Context pContext) {
        super(pContext, R.layout.disease_list_item, pDiseases);
        this.diseases = pDiseases;
        this.mContext = pContext;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Disease disease = getItem(position);
        ViewElements elements;

        final View result;

        // Checks if View is being reused or not
        if (convertView == null) {
            elements = new ViewElements();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.disease_list_item, parent, false);
            elements.name = (TextView) convertView.findViewById(R.id.diseaseName);

            result = convertView;
            convertView.setTag(elements);
        } else {
            elements = (ViewElements) convertView.getTag();
            result = convertView;
        }

        elements.name.setText(disease.getName());

        return convertView;
    }

    @Override
    public void onClick(View view) {
        // TODO: Open disease profile page
    }
}
