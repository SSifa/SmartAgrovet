package com.example.smartagrovet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView detectionCdView;
    CardView diseaseControlCdView;
    CardView expertsCdView;
    CardView agrovetsCdView;
    CardView farmersCdView;
    CardView userAccountCdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detectionCdView = findViewById(R.id.detectionCdView);
        diseaseControlCdView = findViewById(R.id.diseaseControlCdView);
        expertsCdView = findViewById(R.id.expertsCdView);
        agrovetsCdView = findViewById(R.id.agrovetsCdView);
        farmersCdView = findViewById(R.id.farmersCdView);
        userAccountCdView = findViewById(R.id.userAccountCdView);

        detectionCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CropTypeActivity.class);
                startActivity(intent);
            }
        });
    }
}