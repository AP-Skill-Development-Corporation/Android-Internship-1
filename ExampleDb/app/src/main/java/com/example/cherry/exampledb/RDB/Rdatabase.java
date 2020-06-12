package com.example.cherry.exampledb.RDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Rtable.class},version = 1,exportSchema = false)
public abstract class Rdatabase extends RoomDatabase {
    public abstract Rdao rdao();
}
