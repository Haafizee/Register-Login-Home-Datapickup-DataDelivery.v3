package com.perdatech.databasewithimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Arrays;

public class Register extends AppCompatActivity {

    EditText userId, password, name;
    Button register;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        RadioGroup radioGroup = findViewById(R.id.category);

//
        final String[] selectedCategory = {""};
        // Create a variable to hold the selected category
//        final String[] selectedCategory = {Arrays.toString(new String[]{""})};

//         Set up a listener to detect the selected category
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.option1category) {
                    selectedCategory[0] = "Consumer";
                } else if (checkedId == R.id.option2category) {
                    selectedCategory[0] = "Donator";
                }
                // Add more conditions for additional categories as needed
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating User Entity
                UserEntity userEntity = new UserEntity();
                userEntity.setUserId(userId.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setName(name.getText().toString());
                userEntity.setCategory(Arrays.toString(selectedCategory));

                if (validateInput(userEntity)) {
                    //Insert Operation
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Register User Operation
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();

                } else {
                    Toast.makeText(getApplicationContext(), "Fill all fields", Toast.LENGTH_SHORT).show();
                }
            }

        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
    private Boolean validateInput(UserEntity userEntity) {
        if (userEntity.getUserId().isEmpty() ||
                userEntity.getPassword().isEmpty() ||
                userEntity.getName().isEmpty() || userEntity.getCategory().isEmpty()) {
            return false;
        }return true;
    }
}