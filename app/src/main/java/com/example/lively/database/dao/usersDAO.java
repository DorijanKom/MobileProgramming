package com.example.lively.database.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lively.database.tables.Users;

import java.util.List;

public interface usersDAO {
    @Query("SELECT * FROM users")
    public List<Users> getAllUserss();

    @Query("SELECT * FROM users WHERE id=:id")
    public Users getUsersBYID(long id);

    @Insert()
    public void addUsers(Users users);

    @Update
    public void updateUsers(Users users);

    @Delete
    public void deleteUsers(Users users);
}
