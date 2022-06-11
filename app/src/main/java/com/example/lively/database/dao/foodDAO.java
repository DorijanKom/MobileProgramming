package com.example.lively.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lively.database.tables.Food;
import com.example.lively.database.tables.Sleep;

import java.util.List;

@Dao
public interface foodDAO {
    @Query("SELECT * FROM food")
    public List<Food> getAllFoods();

    @Query("SELECT * FROM food WHERE FoodID=:id")
    public Food getFoodBYID(long id);

    @Insert()
    public void addFood(Food food);

    @Update
    public void updateFood(Food food);

    @Delete
    public void deleteFood(Food food);
}
