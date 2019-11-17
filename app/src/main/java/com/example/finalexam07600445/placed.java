package com.example.finalexam07600445;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.finalexam07600445.db;

import java.util.List;

@Dao
public interface placed {
    @Query("SELECT * FROM place")
    List<db>getAllPlace();

    @Insert
    void insertPlace(db place);


}
