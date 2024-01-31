package com.example.bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.NoSuchElementException;


@Component
public class ClientBase {
    ArrayList<Client> clientList = new ArrayList<>();

    public void addClient(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be lower than 0.");
        } else if (initialBalance >= 0) {
            clientList.add(new Client(initialBalance));
        }
    }

    public void purgeList() {
        clientList.clear();
    }
    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public Client getClient(int ID) {
        for (Client client: clientList) {
            if (client.getID() == ID) {
                return client;
            }
        }
        throw new NoSuchElementException("Client identified as: " + ID + " doesn't exist.");
    }


}
