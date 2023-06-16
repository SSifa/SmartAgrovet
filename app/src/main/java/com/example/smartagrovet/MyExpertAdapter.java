package com.example.smartagrovet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyExpertAdapter extends RecyclerView.Adapter<MyExpertHolder> {

    Context context;
    List<Expert> experts;

    public MyExpertAdapter(Context context, List<Expert> experts) {
        this.context = context;
        this.experts = experts;
    }

    @NonNull
    @Override
    public MyExpertHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyExpertHolder(LayoutInflater.from(context).inflate(R.layout.expert_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyExpertHolder holder, int position) {
        holder.imgView.setImageResource(experts.get(position).getImage());
        holder.nameView.setText(experts.get(position).getName());
        holder.emailView.setText(experts.get(position).getEmail());
        holder.specialization.setText(experts.get(position).getSpeciality());
        holder.phoneView.setText(String.valueOf(experts.get(position).getPhone()));
        holder.locationView.setText(experts.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return experts.size();
    }
}
