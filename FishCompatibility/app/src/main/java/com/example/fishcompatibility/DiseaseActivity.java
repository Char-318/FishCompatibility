package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
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

    public void openMain(View view) {
        Intent openMainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openMainIntent);
    }

    /**
     * Uses data contained in Disease object to populate TextViews.
     */
    private void setData() {
        TextView title = findViewById(R.id.diseaseTitle);
        title.setText(mDisease.getName());

        TextView aliases = findViewById(R.id.aliases);
        String aliasText = "";
        for (String alias : mDisease.getAliases()) {
            aliasText = aliasText + alias + "\n\n";
        }
        aliases.setText(aliasText);

        TextView symptoms = findViewById(R.id.symptoms);
        String symptomText = "";
        for (String symptom : mDisease.getSymptoms()) {
            symptomText = symptomText + symptom + "\n\n";
        }
        symptoms.setText(symptomText);

        TextView causes = findViewById(R.id.causes);
        String causesText = "";
        for (String cause : mDisease.getCauses()) {
            causesText = causesText + cause + "\n\n";
        }
        causes.setText(causesText);

        TextView treatments = findViewById(R.id.treatments);
        String treatmentsText = "";
        for (String treatment : mDisease.getTreatment()) {
            treatmentsText = treatmentsText + treatment + "\n\n";
        }
        treatments.setText(treatmentsText);

        TextView preventions = findViewById(R.id.prevention);
        String preventionText = "";
        for (String prevention : mDisease.getPrevention()) {
            preventionText = preventionText + prevention + "\n\n";
        }
        preventions.setText(preventionText);
    }
}