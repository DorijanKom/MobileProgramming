package com.example.lively.database.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "exercise")
public class Exercise {
    @PrimaryKey(autoGenerate = true)
    private long exerciseID;
    private int exerciseTime;
    private int nextExercise;
    private Double avgExercise;

    public long getId() {
        return exerciseID;
    }

    public void setId(long id) {
        this.exerciseID = id;
    }

    public int getExerciseTime() {
        return exerciseTime;
    }

    public void setExerciseTime(int exerciseTime) {
        this.exerciseTime = exerciseTime;
    }

    public int getNextExercise() {
        return nextExercise;
    }

    public void setNextExercise(int nextExercise) {
        this.nextExercise = nextExercise;
    }

    public Double getAvgExercise() {
        return avgExercise;
    }

    public void setAvgExercise(Double avgExercise) {
        this.avgExercise = avgExercise;
    }
}
