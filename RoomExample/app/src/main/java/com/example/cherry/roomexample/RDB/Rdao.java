package com.example.cherry.roomexample.RDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Rdao {

    @Query("Select * from Rtable")
    List<Rtable> getall();

    @Insert
    void insert(Rtable rtable);

    @Delete
    void delete(Rtable rtable);

    @Update
    void update(Rtable rtable);
}
