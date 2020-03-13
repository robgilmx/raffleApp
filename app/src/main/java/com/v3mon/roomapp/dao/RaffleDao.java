package com.v3mon.roomapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.v3mon.roomapp.model.Client;

import java.util.List;

@Dao
public interface RaffleDao {

    @Query("select * from clients")
    List<Client> findAll();

    @Query("select * from clients where is_active = 'true'")
    List<Client> findAllActive();

    @Insert
    void save(Client client);

    @Update
    void update(Client client);

    @Delete
    void delete(Client client);
}
