package com.v3mon.roomapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.v3mon.roomapp.util.LocalDateTimeConverter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(tableName = "raffles",
        foreignKeys =
        @ForeignKey(entity = Client.class,
                childColumns = "winner_id",
                parentColumns = "id")
)
@TypeConverters(LocalDateTimeConverter.class)
public class Raffle implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Long id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "winner_id", index = true)
    private Long winnerId;

    @ColumnInfo(name = "creation_date_time")
    private LocalDateTime creationDateTime;

    @ColumnInfo(name = "raffling_date_time")
    private LocalDateTime rafflingDateTime;

    @ColumnInfo(name = "is_active")
    private Boolean isActive;

    @ColumnInfo(name = "is_completed")
    private Boolean isCompleted;

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getRafflingDateTime() {
        return rafflingDateTime;
    }

    public void setRafflingDateTime(LocalDateTime rafflingDateTime) {
        this.rafflingDateTime = rafflingDateTime;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
