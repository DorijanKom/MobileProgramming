package com.example.lively.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lively.database.tables.Accounts;

import java.util.List;

@Dao
public interface accountsDAO {
    @Query("SELECT * FROM accounts")
    public List<Accounts> getAllAccounts();

    @Query("SELECT * FROM accounts WHERE AccountID=:id")
    public Accounts getAccountsBYID(long id);

    @Insert()
    public void addAccounts(Accounts accounts);

    @Update
    public void updateAccounts(Accounts accounts);

    @Delete
    public void deleteAccounts(Accounts accounts);
}
