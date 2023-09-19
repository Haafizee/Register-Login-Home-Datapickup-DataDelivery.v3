package com.perdatech.databasewithimage.DataModel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DonatorDAO {

    @Query("SELECT * from Donators")
    List<Donator> getAllDonators();

    @Insert
    void insertDonator(Donator donator);

    @Update
    void updateDonator(Donator donator);

    @Delete
    void deleteDonator(Donator donator);
}
