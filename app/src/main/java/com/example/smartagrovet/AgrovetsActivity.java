package com.example.smartagrovet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AgrovetsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrovets);

        List<Agrovet> agrovet = new ArrayList<Agrovet>();
        agrovet.add(new Agrovet(R.drawable.a, "Kesho Agrovet", "keshoagrovet@gmail.com", 0702345654, "Kakamega"));
        agrovet.add(new Agrovet(R.drawable.b, "Kito Agrovet", "kitoagrovet@gmail.com", 0734255654, "Kakamega"));
        agrovet.add(new Agrovet(R.drawable.c, "Vihiga Agrovet", "vihigaagrovet@gmail.com", 0724345654, "Vihiga"));
        agrovet.add(new Agrovet(R.drawable.d, "Webuye Agrovet", "webuyeagrovet@gmail.com", 0720346554, "Webuye"));
        agrovet.add(new Agrovet(R.drawable.e, "Soko Agrovet", "sokoagrovet@gmail.com", 0712345654, "Kisumu"));
        agrovet.add(new Agrovet(R.drawable.f, "Umoja Agrovet", "umojaagrovet@gmail.com", 0723045654, "Bungoma"));
        agrovet.add(new Agrovet(R.drawable.g, "Mkulima Agrovet", "mkulimaagrovet@gmail.com", 0734205654, "Kitale"));
        agrovet.add(new Agrovet(R.drawable.h, "Farmers Choice Agrovet", "farmerschoiceagrovet@gmail.com", 0702345654, "Elgon"));
        agrovet.add(new Agrovet(R.drawable.c, "Baraka Agrovet", "Barakaagrovet@gmail.com", 0702345654, "Mmombasa"));

        RecyclerView recyclerView = findViewById(R.id.recycleView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAgrovetAdapter(getApplicationContext(), agrovet));

    }
}