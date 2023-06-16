package com.example.smartagrovet;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAgrovetHolder extends RecyclerView.ViewHolder {

    ImageView imgView;
    TextView nameView, emailView, specialization, phoneView, locationView;

    public MyAgrovetHolder(@NonNull View itemView) {
        super(itemView);

        imgView  = itemView.findViewById(R.id.imageView);
        nameView = itemView.findViewById(R.id.nameTxtView);
        emailView = itemView.findViewById(R.id.emailTxtView);
        specialization = itemView.findViewById(R.id.specialityTxtView);
        phoneView = itemView.findViewById(R.id.phoneTxtView);
        locationView = itemView.findViewById(R.id.locationTxtView);
    }
}
