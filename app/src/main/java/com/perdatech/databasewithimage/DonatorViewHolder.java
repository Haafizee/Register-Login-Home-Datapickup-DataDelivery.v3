package com.perdatech.databasewithimage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DonatorViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView name, dob, address;
    public DonatorViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.cardName);
        dob = itemView.findViewById(R.id.cardDob);
        address = itemView.findViewById(R.id.cardUsername);
        imageView = itemView.findViewById(R.id.cardImage);
    }
}
