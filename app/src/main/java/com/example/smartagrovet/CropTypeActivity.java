package com.example.smartagrovet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CropTypeActivity extends AppCompatActivity {

    CardView maizeCdView;
    CardView bananaCdView;
    CardView beansCdView;
    CardView sugarcaneCdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_type);

        maizeCdView = findViewById(R.id.maizeCdView);
        bananaCdView = findViewById(R.id.bananaCdView);
        beansCdView = findViewById(R.id.beansCdView);
        sugarcaneCdView = findViewById(R.id.sugarcaneCdView);

        maizeCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MaizeActivity.class);
                startActivity(intent);
            }
        });

        bananaCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BananaActivity.class);
                startActivity(intent);
            }
        });

        beansCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BeansActivity.class);
                startActivity(intent);
            }
        });

        sugarcaneCdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SugarcaneActivity.class);
                startActivity(intent);
            }
        });
    }
}