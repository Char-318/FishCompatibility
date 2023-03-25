 package com.example.fishcompatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

 public class TankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tank);
    }

     public void openMain(View view) {
         Intent openMainIntent = new Intent(getApplicationContext(), MainActivity.class);
         startActivity(openMainIntent);
     }
}