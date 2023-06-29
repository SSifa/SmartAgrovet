package com.example.smartagrovet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyFarmerAdapter extends RecyclerView.Adapter<MyFarmerHolder> {
    Context context;
    List<Farmer> farmer;
    public MyFarmerAdapter(Context context, List<Farmer> farmer) {
        this.context = context;
        this.farmer = farmer;
    }
    @NonNull
    @Override
    public MyFarmerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyFarmerHolder(LayoutInflater.from(context).inflate(R.layout.farmer_view, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull MyFarmerHolder holder, int position) {
        holder.imgView.setImageResource(farmer.get(position).getImg());
        holder.nameView.setText(farmer.get(position).getName());
        holder.emailView.setText(farmer.get(position).getEmail());
        holder.phoneView.setText(String.valueOf(farmer.get(position).getPhone()));
        holder.locationView.setText(farmer.get(position).getLocation());
    }
    @Override
    public int getItemCount() {
        return farmer.size();
    }
}
