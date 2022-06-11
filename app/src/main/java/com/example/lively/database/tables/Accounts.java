package com.example.lively.database.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "accounts")
public class Accounts {
    @PrimaryKey(autoGenerate = true)
    private long AccountID;
    private String userName;
    private String email;
    private String password;

    public Accounts(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public long getAccountID() {
        return AccountID;
    }

    public void setAccountID(long accountID) {
        AccountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
