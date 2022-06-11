package com.example.lively.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lively.database.tables.Exercise;
import com.example.lively.database.tables.Sleep;

import java.util.List;

@Dao
public interface exerciseDAO {
    @Query("SELECT * FROM exercise")
    public List<Exercise> getAllExercises();

    @Query("SELECT * FROM exercise WHERE exerciseID=:id")
    public Exercise getExerciseBYID(long id);

    @Insert()
    public void addExercise(Exercise exercise);

    @Update
    public void updateExercise(Exercise exercise);

    @Delete
    public void deleteExercise(Exercise exercise);
}
