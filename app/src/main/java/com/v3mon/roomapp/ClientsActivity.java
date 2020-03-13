package com.v3mon.roomapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.v3mon.roomapp.controller.ClientController;
import com.v3mon.roomapp.model.Client;
import com.v3mon.roomapp.util.AppExecutors;
import com.v3mon.roomapp.views.ClientAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClientsActivity extends AppCompatActivity {


    @BindView(R.id.client_recycler_view)
    RecyclerView recyclerView;

    ClientAdapter clientAdapter;
    ClientController clientController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);
        ButterKnife.bind(this);
        clientController = new ClientController(this.getApplicationContext());
        clientAdapter = new ClientAdapter();
        recyclerView.setAdapter(clientAdapter);
        loadClientsFromDB();
    }

    private void loadClientsFromDB() {
        AppExecutors.getInstance().diskIO().execute(() -> {
            final List<Client> clients = clientController.findAll();
            runOnUiThread(() -> {
              clientAdapter.setClientList(clients);
              clientAdapter.notifyDataSetChanged();
              recyclerView.setAdapter(clientAdapter);
            });
        });
    }

    @OnClick(R.id.client_add_button)
    public void startClientEditor(){
        Intent clientEditor = new Intent(this, ClientEditorActivity.class);
        startActivity(clientEditor);
    }
}
