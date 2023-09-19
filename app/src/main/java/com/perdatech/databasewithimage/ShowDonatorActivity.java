package com.perdatech.databasewithimage;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.perdatech.databasewithimage.DataModel.DonatorDAO;
import com.perdatech.databasewithimage.DataModel.DonatorDatabase;

public class ShowDonatorActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DonatorDAO donatorDAO;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_donators);

        recyclerView = findViewById(R.id.donatorRecyclerView);

        donatorDAO = DonatorDatabase.getDBInstance(this).donatorDAO();

        DonatorRecycler donatorRecycler = new DonatorRecycler(donatorDAO.getAllDonators());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(donatorRecycler);
    }
}