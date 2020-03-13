package com.v3mon.roomapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.UUID;

@Entity(tableName = "clients")
public class Client implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private Long id;
    @ColumnInfo(name = "first_name")
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;
    @ColumnInfo(name = "is_active")
    private Boolean isActive = true;

    public Client() {
        this.id = UUID.randomUUID().getMostSignificantBits();
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long mId) {
        this.id = mId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String mFirstName) {
        this.firstName = mFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String mLastName) {
        this.lastName = mLastName;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setIsActive(Boolean mIsActive) {
        this.isActive = mIsActive;
    }
}
