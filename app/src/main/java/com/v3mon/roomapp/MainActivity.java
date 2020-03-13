package com.v3mon.roomapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.menu_title_text)
    TextView title;

    @BindView(R.id.menu_clients_button)
    Button clientsButton;

    @BindView(R.id.menu_raffles_button)
    Button raffleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ButterKnife.bind(this);
    }

    @OnClick(R.id.menu_clients_button)
    public void startClients(){
        Intent clients = new Intent(this, ClientsActivity.class);
        startActivity(clients);
    }

    @OnClick(R.id.menu_raffles_button)
    public void startRaffles(){
        Intent raffles = new Intent(this, RafflesActivity.class);
        startActivity(raffles);
    }
}
