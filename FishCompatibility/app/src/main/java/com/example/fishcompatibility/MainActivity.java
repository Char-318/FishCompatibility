package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the search button is clicked */
    public void openSearch(View view) {
        Intent openSearchIntent = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(openSearchIntent);
    }
}