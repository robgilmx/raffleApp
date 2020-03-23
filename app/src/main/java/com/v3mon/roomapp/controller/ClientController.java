package com.v3mon.roomapp.controller;

import android.content.Context;

import com.v3mon.roomapp.dao.ClientDao;
import com.v3mon.roomapp.model.Client;
import com.v3mon.roomapp.util.AppDatabase;

import java.util.Arrays;
import java.util.List;

public class ClientController {
    ClientDao clientDao;

    public ClientController(Context context) {
        clientDao = AppDatabase.getInstance(context).clientDao();
    }

    public void save(Client client){
        clientDao.insert(client);
    }

    public List<Long> saveAll(List<Client> client){
        return clientDao.saveAll(client);
    }

    public void update(Client client){
        clientDao.update(client);
    }

    public void delete(Client client){
        clientDao.delete(client);
    }

    public List<Client> findAll(){
        return Arrays.asList(clientDao.loadAllUsers());
    }
}
