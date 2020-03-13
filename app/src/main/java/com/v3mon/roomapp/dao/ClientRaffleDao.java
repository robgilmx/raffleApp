package com.v3mon.roomapp.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.v3mon.roomapp.model.Client;
import com.v3mon.roomapp.model.ClientRaffle;
import com.v3mon.roomapp.model.Raffle;

import java.util.List;

@Dao
public interface ClientRaffleDao {
    public interface ClientRaffleJoinDao {
        @Insert
        void insert(ClientRaffle clientRaffleJoin);

        @Query("SELECT * FROM clients " +
                "INNER JOIN clients_raffles " +
                "ON clients.id=clients_raffles.client_id " +
                "WHERE clients_raffles.raffle_id=:raffleId")
        List<Client> getClientsForRaffle(final int raffleId);

        @Query("SELECT * FROM raffles " +
                "INNER JOIN clients_raffles " +
                "ON raffles.id=clients_raffles.raffle_id " +
                "WHERE clients_raffles.client_id=:clientId")
        List<Raffle> getRafflesForClient(final int clientId);
    }

}
