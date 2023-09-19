package com.perdatech.databasewithimage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ConsumerViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView name, dob, address;
    public ConsumerViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.cardName);
        dob = itemView.findViewById(R.id.cardDob);
        address = itemView.findViewById(R.id.cardUsername);
        imageView = itemView.findViewById(R.id.cardImage);
    }
}
