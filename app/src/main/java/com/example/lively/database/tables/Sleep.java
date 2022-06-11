package com.example.lively.database.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sleep")
public class Sleep {
    @PrimaryKey(autoGenerate = true)
    private long SleepID;
    private int sleptFor;
    private int setSleeptime;
    private int sleepIn;
    private Double avgSleep;

    public long getId() {
        return SleepID;
    }

    public void setId(long id) {
        this.SleepID = id;
    }

    public int getSleptFor() {
        return sleptFor;
    }

    public int getSetSleeptime() {
        return setSleeptime;
    }

    public void setSetSleeptime(int setSleeptime) {
        this.setSleeptime = setSleeptime;
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
