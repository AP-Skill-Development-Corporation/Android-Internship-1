package com.example.cherry.exampledb.RDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Rdao {

    @Query("Select * from Students")
    List<Rtable> getAll();

    @Insert
    void insertData(Rtable rtable);

    @Update
    void updateData(Rtable rtable);

    @Delete
    void deleteData(Rtable rtable);
}
