package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

public class DiseaseActivity extends AppCompatActivity {
    Disease mDisease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);

        Parcelable parcelable = getIntent().getExtras().getParcelable("disease");
        mDisease = (Disease) parcelable;

        setData();
    }

    private void setData() {
        TextView title = findViewById(R.id.diseaseTitle);
        title.setText(mDisease.getName());

        TextView aliases = findViewById(R.id.aliases);
        String aliasText = "";
        for (String alias : mDisease.getAliases()) {
            aliasText = aliasText + "\n" + alias;
        }
        if (aliasText.length() > 0) {
            aliasText = aliasText.substring(1);
            aliases.setText(aliasText);
        }

        TextView symptoms = findViewById(R.id.symptoms);
        String symptomText = "";
        for (String symptom : mDisease.getSymptoms()) {
            symptomText = symptomText + "\n" + symptom;
        }
        if (symptomText.length() > 0) {
            symptomText = symptomText.substring(1);
            symptoms.setText(symptomText);
        }

        TextView causes = findViewById(R.id.causes);
        String causesText = "";
        for (String cause : mDisease.getCauses()) {
            causesText = causesText + "\n" + cause;
        }
        if (causesText.length() > 0) {
            causesText = causesText.substring(1);
            causes.setText(causesText);
        }

        TextView treatments = findViewById(R.id.treatments);
        String treatmentsText = "";
        for (String treatment : mDisease.getTreatment()) {
            treatmentsText = treatmentsText + "\n" + treatment;
        }
        if (treatmentsText.length() > 0) {
            treatmentsText = treatmentsText.substring(1);
            treatments.setText(treatmentsText);
        }

        TextView preventions = findViewById(R.id.prevention);
        String preventionText = "";
        for (String prevention : mDisease.getPrevention()) {
            preventionText = preventionText + "\n" + prevention;
        }
        if (preventionText.length() > 0) {
            preventionText = preventionText.substring(1);
            preventions.setText(preventionText);
        }
    }
}