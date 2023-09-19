package com.perdatech.databasewithimage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "userId")
    String userId;

    @ColumnInfo(name = "password")
    String password;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "category")
    String category;

    @ColumnInfo(name = "option1category")
    String option1category;

    @ColumnInfo(name = "option2category")
    String option2category;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOption1category() {
        return option1category;
    }

    public void setOption1category(String option1category) {
        this.option1category = option1category;
    }

    public String getOption2category() {
        return option2category;
    }

    public void setOption2category(String option2category) {
        this.option2category = option2category;
    }
}
