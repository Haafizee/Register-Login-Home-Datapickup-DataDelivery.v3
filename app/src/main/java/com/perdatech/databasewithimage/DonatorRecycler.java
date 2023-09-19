package com.perdatech.databasewithimage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.perdatech.databasewithimage.DataModel.DataConverter;
import com.perdatech.databasewithimage.DataModel.Donator;

import java.util.List;

public class DonatorRecycler extends RecyclerView.Adapter<DonatorViewHolder> {

    List<Donator> data;
    public DonatorRecycler(List<Donator> donators){
        data = donators;
    }


    @NonNull
    @Override
    public DonatorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.user_item_layout,
                viewGroup,
                false
        );
        return new DonatorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonatorViewHolder holder, int position) {
        Donator user = data.get(position);
        holder.imageView.setImageBitmap(DataConverter.convertByteArray2Image(user.getImage()));
        holder.name.setText(user.getFullname());
        holder.address.setText(user.getUsername());
        holder.dob.setText(String.valueOf(user.getDob()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
