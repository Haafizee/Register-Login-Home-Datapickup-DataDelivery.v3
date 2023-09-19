package com.perdatech.databasewithimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.perdatech.databasewithimage.DataModel.ConsumerDAO;
import com.perdatech.databasewithimage.DataModel.ConsumerDatabase;

public class ShowConsumersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ConsumerDAO consumerDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_users);

        recyclerView = findViewById(R.id.userRecyclerView);

        consumerDAO = ConsumerDatabase.getDBInstance(this).consumerDAO();

        ConsumerRecycler consumerRecycler = new ConsumerRecycler(consumerDAO.getAllUsers());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(consumerRecycler);
    }
}