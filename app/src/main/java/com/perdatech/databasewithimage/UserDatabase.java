package com.perdatech.databasewithimage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 2)
public abstract class UserDatabase extends RoomDatabase {
    public static final String dbName = "user";
    private static UserDatabase userDatabase;
    public static synchronized UserDatabase getUserDatabase(Context context){
        if(userDatabase == null) {
            userDatabase = Room.databaseBuilder(context, UserDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return userDatabase;
    }

    public abstract UserDao userDao();
}
