package com.perdatech.databasewithimage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.perdatech.databasewithimage.DataModel.Consumer;
import com.perdatech.databasewithimage.DataModel.DataConverter;

import java.util.List;

public class ConsumerRecycler extends RecyclerView.Adapter<ConsumerViewHolder> {

    List<Consumer>data;
    public ConsumerRecycler(List<Consumer> consumers){
        data = consumers;
    }


    @NonNull
    @Override
    public ConsumerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.user_item_layout,
                viewGroup,
                false
        );
        return new ConsumerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsumerViewHolder holder, int position) {
        Consumer consumer = data.get(position);
        holder.imageView.setImageBitmap(DataConverter.convertByteArray2Image(consumer.getImage()));
        holder.name.setText(consumer.getFullname());
        holder.dob.setText(String.valueOf(consumer.getDob()));
        holder.address.setText(consumer.getUsername());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
