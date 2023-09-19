package com.perdatech.databasewithimage.DataModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Donators")
public class Donator {
    @PrimaryKey(autoGenerate = true)
    int uid;
    @ColumnInfo(name = "Name")
    String fullname;
    @ColumnInfo(name = "Donator_Name")
    String username;
    String password;
    Date dob;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    byte[] image;

    public int getUid() {
        return uid;
    }

    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getDob() {
        return dob;
    }

    public byte[] getImage() {
        return image;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
