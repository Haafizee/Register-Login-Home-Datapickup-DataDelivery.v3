package com.perdatech.databasewithimage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.perdatech.databasewithimage.DataModel.DataConverter;
import com.perdatech.databasewithimage.DataModel.Donator;
import com.perdatech.databasewithimage.DataModel.DonatorDAO;
import com.perdatech.databasewithimage.DataModel.DonatorDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DonatorActivity extends AppCompatActivity {

    ImageView imageView;
    Bitmap bmpImage;
    EditText name, uName, pas, dob;
    DonatorDAO donatorDAO;
    Button saveUser, showUser;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.userImage);
        bmpImage = null;

        name = findViewById(R.id.fullName);
        uName = findViewById(R.id.userName);
        pas = findViewById(R.id.userPassword);
        dob = findViewById(R.id.userDob);
        saveUser = (Button) findViewById(R.id.saveUser);
        showUser = findViewById(R.id.showUser);

        donatorDAO = DonatorDatabase.getDBInstance(this).donatorDAO();

        saveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || uName.getText().toString().isEmpty() || pas.getText().toString().isEmpty() || dob.getText().toString().isEmpty() ||bmpImage == null) {
//                    Toast.makeText(
//                            this,
//                            "user Data is Missing",
//                            Toast.LENGTH_SHORT
//                    ).show();
                }else {
                    Donator donator = new Donator();
                    donator.setFullname(name.getText().toString());
                    donator.setUsername(uName.getText().toString());
                    donator.setPassword(pas.getText().toString());
                    donator.setImage(DataConverter.convertImage2ByteArray(bmpImage));
            try {
                donator.setDob(new SimpleDateFormat("dd/mm/yyyy").parse(dob.getText().toString()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
                    donatorDAO.insertDonator(donator);
//                    Toast.makeText(
//                            this,
//                            "Insert Successfull",
//                            Toast.LENGTH_SHORT
//                    ).show();
                }

            }
        });

        showUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DonatorActivity.this, ShowDonatorActivity.class);
                startActivity(intent);
            }
        });
    }
    final int CAMERA_INTENT = 51;

    public void takepicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, CAMERA_INTENT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CAMERA_INTENT:
//                if(requestCode == Activity.RESULT_OK){
                bmpImage = (Bitmap) data.getExtras().get("data");
                if(bmpImage != null){
                    imageView.setImageBitmap(bmpImage);
                } else {
                    Toast.makeText(
                            this,
                            "Bitmap is Null",
                            Toast.LENGTH_SHORT
                    ).show();
                }
//                } else {
//                    Toast.makeText(
//                            this,
//                            "Result OK",
//                            Toast.LENGTH_SHORT
//                    ).show();
//                }
                break;
        }
    }

//    public void saveUser(View view) {
////        User user = new User();
////        if (name.getText().toString().isEmpty() || uName.getText().toString().isEmpty() || pas.getText().toString().isEmpty() || dob.getText().toString().isEmpty() ||bmpImage == null) {
////            Toast.makeText(
////                    this,
////                    "user Data is Missing",
////                    Toast.LENGTH_SHORT
////            ).show();
////        }else {
////            User user = new User();
////            user.setFullname(name.getText().toString());
////            user.setUsername(uName.getText().toString());
////            user.setPassword(pas.getText().toString());
////            user.setImage(DataConverter.convertImage2ByteArray(bmpImage));
//////            try {
//////                user.setDob(new SimpleDateFormat("dd/mm/yyyy").parse(dob.getText().toString()));
//////            } catch (ParseException e) {
//////                throw new RuntimeException(e);
//////            }
////            userDAO.insertUser(user);
////            Toast.makeText(
////                    this,
////                    "Insert Successfull",
////                    Toast.LENGTH_SHORT
////            ).show();
////        }
//    }
//
//    public void showUser(View view) {
////        Intent intent = new Intent(this, ShowUsersActivity.class);
////        startActivity(intent);
//    }
}