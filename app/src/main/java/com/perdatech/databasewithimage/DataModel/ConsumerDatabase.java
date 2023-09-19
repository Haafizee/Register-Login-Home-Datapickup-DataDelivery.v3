package com.perdatech.databasewithimage.DataModel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Consumer.class}, version = 3, exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class ConsumerDatabase extends RoomDatabase {
    private static ConsumerDatabase userDB = null;
    public abstract ConsumerDAO consumerDAO();

    public static synchronized ConsumerDatabase getDBInstance(Context context){
        if(userDB == null){
            userDB = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ConsumerDatabase.class,
                    "user19b2"
            )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return userDB;
    }
}
