package com.example.bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class ClientBase {
    ArrayList<Client> clientList = new ArrayList<>();

    public void addClient(float initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be lower than 0.");
        } else if (initialBalance >= 0) {
            clientList.add(new Client(initialBalance));
        }
    }

    public void purgeList() {
        clientList.clear();
    }


}
