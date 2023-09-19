package com.perdatech.databasewithimage.DataModel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Donator.class}, version = 1, exportSchema = false)
@TypeConverters(DataConverter.class)
public abstract class DonatorDatabase extends RoomDatabase {
    private static DonatorDatabase donatorDB = null;
    public abstract DonatorDAO donatorDAO();

    public static synchronized DonatorDatabase getDBInstance(Context context){
        if(donatorDB == null){
            donatorDB = Room.databaseBuilder(
                    context.getApplicationContext(),
                    DonatorDatabase.class,
                    "user20b2"
            )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return donatorDB;
    }
}
