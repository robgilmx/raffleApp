package com.v3mon.roomapp.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "clients_raffles",
        primaryKeys = { "raffle_id", "client_id" },
        foreignKeys = {
        @ForeignKey(entity = Client.class,
            parentColumns = "id",
            childColumns = "client_id"),
        @ForeignKey(entity = Raffle.class,
                parentColumns = "id",
                childColumns = "raffle_id")
})
public class ClientRaffle implements Serializable {
    @ColumnInfo(name = "raffle_id", index = true)
    @NonNull
    private Long raffleId;

    @ColumnInfo(name = "client_id", index = true)
    @NonNull
    private Long userId;


    @ColumnInfo(name = "reference")
    private String reference = "";

    @NonNull
    public Long getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Long userId) {
        this.userId = userId;
    }

    @NonNull
    public Long getRaffleId() {
        return raffleId;
    }

    public void setRaffleId(@NonNull Long raffleId) {
        this.raffleId = raffleId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
