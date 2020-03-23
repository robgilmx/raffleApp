package com.v3mon.roomapp.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.v3mon.roomapp.ClientEditorActivity;
import com.v3mon.roomapp.R;
import com.v3mon.roomapp.controller.ClientController;
import com.v3mon.roomapp.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {

    private static final String TAG = "ClientAdapter";
    private List<Client> clientList = new ArrayList<>();
    private ClientController clientController;
    private Context context;

    public ClientAdapter() {
    }

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.client_item, parent, false);
        ClientViewHolder clientViewHolder = new ClientViewHolder(view);
        context = parent.getContext();
        clientController = new ClientController(context);
        return clientViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        Client client = clientList.get(position);
        checkButtonStatus(holder, client.isActive());
        holder.clientName.setText(client.getFirstName() + " " + client.getLastName());
        holder.editButton.setOnClickListener(v -> {
            Intent clientEditorIntent = new Intent(context, ClientEditorActivity.class);
            clientEditorIntent.putExtra(ClientEditorActivity.CLIENT_EXTRA, client);
            context.startActivity(clientEditorIntent);
        });
        holder.deleteButton.setOnClickListener(v -> {
            confirmClientDeletion(client, position);
        });
        holder.disableButton.setOnClickListener(v -> {
            client.setIsActive(!client.isActive());
            clientController.update(client);
            checkButtonStatus(holder, client.isActive());
        });
    }

    private void confirmClientDeletion(Client client, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(context.getString(R.string.delete_client_question));
        builder.setNegativeButton(R.string.no, null);
        builder.setPositiveButton(R.string.yes, (dialog, which) -> {
            clientList.remove(position);
            clientController.delete(client);
        });
    }


    @Override
    public int getItemCount() {
        return clientList.size();
    }

    class ClientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView clientName;
        ImageButton disableButton, editButton, deleteButton;

        public ClientViewHolder(@NonNull View clientItemView){
            super(clientItemView);
            clientName = clientItemView.findViewById(R.id.client_item_name);
            disableButton = clientItemView.findViewById(R.id.client_item_disable);
            editButton = clientItemView.findViewById(R.id.client_item_edit);
            deleteButton = clientItemView.findViewById(R.id.client_item_delete);
        }

        @Override
        public void onClick(View v) {
            Log.d("Adapter","Clicked");
        }
    }

    private void checkButtonStatus(ClientViewHolder holder, boolean status){
        if (status){
            holder.disableButton.setBackgroundColor(ContextCompat.getColor(context, R.color.background));
        } else {
            holder.disableButton.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
        }
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
        notifyDataSetChanged();
    }
}
