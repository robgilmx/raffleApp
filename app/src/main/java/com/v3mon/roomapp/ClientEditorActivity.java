package com.v3mon.roomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.v3mon.roomapp.controller.ClientController;
import com.v3mon.roomapp.model.Client;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClientEditorActivity extends AppCompatActivity {
    public static final String CLIENT_EXTRA = "Client";

    @BindView(R.id.first_name_input)
    EditText firstNameInput;
    @BindView(R.id.last_name_input)
    EditText lastNameInput;

    Client client;
    ClientController clientController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_editor);
        ButterKnife.bind(this);
        clientController = new ClientController(this);
        client = (Client) getIntent().getSerializableExtra(CLIENT_EXTRA);
    }


    @OnClick(R.id.save_client_button)
    public void saveOrUpdateClient(){
        if (client == null){
            client = new Client();
            client.setFirstName(Objects.requireNonNull(firstNameInput.getText()).toString());
            client.setLastName(Objects.requireNonNull(lastNameInput.getText()).toString());
            clientController.save(client);
        }else{
            client.setFirstName(Objects.requireNonNull(firstNameInput.getText()).toString());
            client.setLastName(Objects.requireNonNull(lastNameInput.getText()).toString());
            clientController.update(client);
        }
    }

}
