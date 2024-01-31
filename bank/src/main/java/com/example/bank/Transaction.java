package com.example.bank;


public class Transaction {

    private Client client;
    private double amount;
    private TransferStatus transferStatus;

    Transaction(Client client, double amount) {
        this.client = client;
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public double getAmount() {
        return amount;
    }

    public TransferStatus getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(TransferStatus transferStatus) {
        this.transferStatus = transferStatus;
    }

}
