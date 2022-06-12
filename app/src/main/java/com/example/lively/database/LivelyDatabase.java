package com.example.lively.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.lively.database.dao.usersDAO;
import com.example.lively.database.tables.Users;

@Database(entities = {Users.class},version = 2)
public abstract class LivelyDatabase extends RoomDatabase {
    private static LivelyDatabase INSTANCE=null;
    public abstract usersDAO usersDAO();

    public static LivelyDatabase getDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context, LivelyDatabase.class,"lively_database").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}