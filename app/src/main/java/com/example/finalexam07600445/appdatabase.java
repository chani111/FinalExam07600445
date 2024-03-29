package com.example.finalexam07600445;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {regisitem.class}, exportSchema = false, version = 1)
public abstract class appdatabase extends RoomDatabase {

    private static final String DB_NAME = "place.db";

    public abstract Operation placeDao();

    private static appdatabase mInstance;

    public static synchronized appdatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room
                    .databaseBuilder(
                            context.getApplicationContext(),
                            appdatabase.class,
                            DB_NAME
                    )
                    .build();
        }
        return mInstance;
    }
}