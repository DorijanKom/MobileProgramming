package com.example.lively.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lively.database.tables.Accounts;
import com.example.lively.database.tables.Sleep;
import com.example.lively.database.tables.Users;

@Database(entities = {Users.class, Accounts.class, Sleep.class},version = 1)
public abstract class LivelyDatabase extends RoomDatabase {
    private static LivelyDatabase INSTANCE=null;
    public abstract LivelyDatabase usersDAO();
    public abstract LivelyDatabase accountsDAO();
    public abstract LivelyDatabase sleepDAO();

    public static LivelyDatabase getDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context, LivelyDatabase.class,"lively_database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
