package com.example.smartagrovet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FarmersActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmers);

        List<Farmer> farmer = new ArrayList<Farmer>();
        farmer.add(new Farmer(R.drawable.a,"Ngombo", "sifangombo254@gmail.com", 701249103, "Malindi"));
        farmer.add(new Farmer(R.drawable.b, "Sifa", "sifangombo2@gmail.com", 701249103, "Nyeri"));
        farmer.add(new Farmer(R.drawable.c,"Stephen", "sifangombo25@gmail.com", 701249103, "Mombasa"));
        farmer.add(new Farmer(R.drawable.d, "Kithi", "sifangombo24@gmail.com", 701249103, "Vihiga"));
        farmer.add(new Farmer(R.drawable.e, "Kalu", "sifangombo54@gmail.com", 701249103, "Webuye"));
        farmer.add(new Farmer(R.drawable.f, "Rehema", "sifangombo524@gmail.com", 701249103, "Bungoma"));
        farmer.add(new Farmer(R.drawable.g, "Sidi", "sifangombo542@gmail.com", 701249103, "Mumias"));
        farmer.add(new Farmer(R.drawable.h, "Sanita", "sifangombo425@gmail.com", 701249103, "Kitale"));
        farmer.add(new Farmer(R.drawable.a, "Thinga", "sifangombo254@gmail.com", 701249103, "Matungu"));
        farmer.add(new Farmer(R.drawable.b, "Jefa", "sifangombo2@gmail.com", 701249103, "Shinyalu"));
        farmer.add(new Farmer(R.drawable.c, "Kache", "sifangombo25@gmail.com", 701249103, "Endebes"));
        farmer.add(new Farmer(R.drawable.d, "Mwango", "sifangombo24@gmail.com", 701249103, "Kimilili"));
        farmer.add(new Farmer(R.drawable.e, "Karembo", "sifangombo54@gmail.com", 701249103,"Kakamega"));

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recyclerView = findViewById(R.id.recyclerViewFarmer);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyFarmerAdapter(getApplicationContext(), farmer));
    }
}