package com.perdatech.databasewithimage.DataModel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ConsumerDAO {

    @Query("SELECT * from Consumers")
    List<Consumer> getAllUsers();

    @Insert
    void insertUser(Consumer consumer);

    @Update
    void updateUser(Consumer consumer);

    @Delete
    void deleteUser(Consumer consumer);
}
