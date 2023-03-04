package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

public class FishActivity extends AppCompatActivity {
    private Fish mFish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);

        Parcelable parcelable = getIntent().getExtras().getParcelable("fish");
        mFish = (Fish) parcelable;

        TextView title = findViewById(R.id.fishTitle);
        title.setText(mFish.getName());
    }

    public void openMain(View view) {
        Intent openMainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(openMainIntent);
    }
}