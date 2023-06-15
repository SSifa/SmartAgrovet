package com.example.smartagrovet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView detectionCdView;
    CardView diseaseControlCdView;
    CardView expertsCdView;
    CardView agrovetsCdView;
    CardView farmersCdView;
    CardView aboutCdView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detectionCdView = findViewById(R.id.detectionCdView);
        diseaseControlCdView = findViewById(R.id.diseaseControlCdView);
        expertsCdView = findViewById(R.id.expertsCdView);
        agrovetsCdView = findViewById(R.id.agrovetsCdView);
        farmersCdView = findViewById(R.id.farmersCdView);
        aboutCdView = findViewById(R.id.aboutCdView);

        detectionCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CropTypeActivity.class));
            }
        });
        diseaseControlCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ControlActivity.class));
            }
        });
        expertsCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ExpertsActivity.class));
            }
        });
        agrovetsCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AgrovetsActivity.class));
            }
        });
        farmersCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), FarmersActivity.class));
            }
        });
        aboutCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AboutusActivity.class));
            }
        });
    }
}