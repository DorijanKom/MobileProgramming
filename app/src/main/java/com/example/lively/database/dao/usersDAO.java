package com.example.lively.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lively.database.tables.Users;

import java.util.List;

@Dao
public interface usersDAO {
    @Query("SELECT * FROM users")
    public List<Users> getAllUsers();

    @Query("SELECT * FROM users WHERE Userid=:id")
    public Users getUsersBYID(long id);

    @Insert()
    public void addUsers(Users users);

    @Update
    public void updateUsers(Users users);

    @Delete
    public void deleteUsers(Users users);
}
