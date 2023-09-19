package com.perdatech.databasewithimage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView tname, tcategory;
    Button regstaffbtn, regdonatorbtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        regstaffbtn = findViewById(R.id.regstaffbtn);
        regdonatorbtn = findViewById(R.id.regdonatorbtn);

        tname = findViewById(R.id.name);
        tcategory = findViewById(R.id.category);
        String name = getIntent().getStringExtra("name");
        String category = getIntent().getStringExtra("category");
        tname.setText(name);
        tcategory.setText(category);

        regstaffbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(Home.this, MainActivity.class);
                startActivity(u);
            }
        });

        regdonatorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(Home.this, DonatorActivity.class);
                startActivity(d);
            }
        });
    }
}