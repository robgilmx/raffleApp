package com.v3mon.roomapp.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.v3mon.roomapp.dao.ClientDao;
import com.v3mon.roomapp.dao.ClientRaffleDao;
import com.v3mon.roomapp.dao.RaffleDao;
import com.v3mon.roomapp.model.Client;
import com.v3mon.roomapp.model.ClientRaffle;
import com.v3mon.roomapp.model.Raffle;

@Database(entities = {Client.class, ClientRaffle.class, Raffle.class},
        exportSchema = false,
        version = 2)
public abstract class AppDatabase extends RoomDatabase {
    private static final String RAFFLES_DB = "raffles_db";
    private static AppDatabase instance;




    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null){
            instance =
                    Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    RAFFLES_DB).fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract ClientDao clientDao();
    public abstract RaffleDao raffleDao();
    public abstract ClientRaffleDao clientRaffleDao();
}
