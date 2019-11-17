package com.example.finalexam07600445;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


    @Entity(tableName="item")
    public class regisitem {
        @PrimaryKey(autoGenerate = true)
        public  int id;

        @ColumnInfo(name="fullname")
        public String fullname;


        @ColumnInfo(name="userregis")
        public String userregis;

        @ColumnInfo(name="passregis")
        public String passregis;


        public regisitem(String fullname, String userregis ,String passregis) {
            this.fullname=fullname;
            this.userregis=userregis;
            this.passregis=passregis;

        }
    }

}

}
