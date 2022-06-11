package com.example.lively.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lively.database.tables.Sleep;
import java.util.List;

@Dao
public interface sleepDAO {
    @Query("SELECT * FROM sleep")
    public List<Sleep> getAllSleeps();

    @Query("SELECT * FROM sleep WHERE SleepID=:id")
    public Sleep getSleepBYID(long id);

    @Insert()
    public void addSleep(Sleep sleep);

    @Update
    public void updateSleep(Sleep sleep);

    @Delete
    public void deleteSleep(Sleep sleep);
}
