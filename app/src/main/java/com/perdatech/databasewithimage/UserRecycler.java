package com.perdatech.databasewithimage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.perdatech.databasewithimage.DataModel.User;
import com.perdatech.databasewithimage.DataModel.DataConverter;
import com.perdatech.databasewithimage.DataModel.User;

import java.util.List;

public class UserRecycler extends RecyclerView.Adapter<UserViewHolder> {

    List<User>data;
    public UserRecycler(List<User>users){
        data = users;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.user_item_layout,
                viewGroup,
                false
        );
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = data.get(position);
        holder.imageView.setImageBitmap(DataConverter.convertByteArray2Image(user.getImage()));
        holder.name.setText(user.getFullname());
        holder.dob.setText(String.valueOf(user.getDob()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
