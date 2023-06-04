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

    /**
     * Elements of the view adapter that will be used in the list.
     * Name of the disease.
     */
    private static class ViewElements {
        TextView name;
    }

    /**
     * Constructor for the view adapter.
     * @param pDiseases Array of diseases to be listed.
     * @param pContext Current context of the application.
     */
    public DiseaseViewAdapter(Disease[] pDiseases, Context pContext) {
        super(pContext, R.layout.disease_list_item, pDiseases);
    }

    /**
     * Creates the view for each item in the list of diseases.
     * @param position Index of the item in the list.
     * @param convertView View of the list item.
     * @param parent View group this item is contained in.
     * @return View of this disease for the search page.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Disease disease = getItem(position);
        ViewElements elements;

        // Checks if View is being reused or not
        if (convertView == null) {
            elements = new ViewElements();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.disease_list_item, parent, false);
            elements.name = (TextView) convertView.findViewById(R.id.diseaseName);

            convertView.setTag(elements);
        } else {
            elements = (ViewElements) convertView.getTag();
        }

        elements.name.setText(disease.getName());

        return convertView;
    }

    /**
     * Necessary method to implement the array adapter.
     */
    @Override
    public void onClick(View view) {}
}
