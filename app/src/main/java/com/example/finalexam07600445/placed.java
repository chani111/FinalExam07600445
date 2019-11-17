package com.example.finalexam07600445;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.finalexam07600445.regisitem;

import java.util.List;

@Dao
public interface placed {
    @Query("SELECT * FROM item")
    List<regisitem>getAll();

    @Insert
    void insert(regisitem place);


}
