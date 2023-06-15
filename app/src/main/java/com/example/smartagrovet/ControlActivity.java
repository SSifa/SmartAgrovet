package com.example.smartagrovet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ControlActivity extends AppCompatActivity {

    CardView maizeCdView;
    CardView bananaCdView;
    CardView beansCdView;
    CardView sugarcaneCdView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        maizeCdView = findViewById(R.id.cdViewMaize);
        bananaCdView = findViewById(R.id.cdViewBanana);
        beansCdView = findViewById(R.id.cdViewBeans);
        sugarcaneCdView = findViewById(R.id.cdViewSugarcane);

        maizeCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MaizeDiseasesActivity.class);
                startActivity(intent);
            }
        });

        bananaCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BananaDiseasesActivity.class);
                startActivity(intent);
            }
        });

        beansCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BeansDiseasesActivity.class);
                startActivity(intent);
            }
        });

        sugarcaneCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SugarcaneDiseasesActivity.class);
                startActivity(intent);
            }
        });
    }
}