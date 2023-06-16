package com.example.smartagrovet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAgrovetAdapter extends RecyclerView.Adapter<MyAgrovetHolder> {

    Context context;
    List<Agrovet> agrovet;

    public MyAgrovetAdapter(Context context, List<Agrovet> agrovet) {
        this.context = context;
        this.agrovet = agrovet;
    }

    @NonNull
    @Override
    public MyAgrovetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyAgrovetHolder(LayoutInflater.from(context).inflate(R.layout.agrovet_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAgrovetHolder holder, int position) {
        holder.imgView.setImageResource(agrovet.get(position).getImage());
        holder.nameView.setText(agrovet.get(position).getName());
        holder.emailView.setText(agrovet.get(position).getEmail());
        holder.phoneView.setText(String.valueOf(agrovet.get(position).getPhone()));
        holder.locationView.setText(agrovet.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return agrovet.size();
    }
}
