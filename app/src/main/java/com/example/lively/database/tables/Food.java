package com.example.lively.database.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "food")
public class Food {
    @PrimaryKey(autoGenerate = true)
    private long FoodID;
    private int nextMeal;
    private int waterInterval;

    public long getFoodID() {
        return FoodID;
    }

    public void setFoodID(long foodID) {
        FoodID = foodID;
    }

    public int getNextMeal() {
        return nextMeal;
    }

    public void setNextMeal(int nextMeal) {
        this.nextMeal = nextMeal;
    }

    public int getWaterInterval() {
        return waterInterval;
    }

    public void setWaterInterval(int waterInterval) {
        this.waterInterval = waterInterval;
    }
}
