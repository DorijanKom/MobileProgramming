package com.example.lively.database.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sleep")
public class Sleep {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private int sleptFor;
    private int sleepIn;

    private Double avgSleep;

    public Sleep(int sleptFor) {
        this.sleptFor = sleptFor;
        this.sleepIn = 0;
        this.avgSleep = 0.0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSleptFor() {
        return sleptFor;
    }

    public void setSleptFor(int sleptFor) {
        this.sleptFor = sleptFor;
    }

    public int getSleepIn() {
        return sleepIn;
    }

    public void setSleepIn(int sleepIn) {
        this.sleepIn = sleepIn;
    }


    public Double getAvgSleep() {
        return avgSleep;
    }

    public void setAvgSleep(Double avgSleep) {
        this.avgSleep = avgSleep;
    }
}
