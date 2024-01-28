package com.example.bank;

public class Client {
    private static int ID = 0;
    private float accountBalance;

    Client(float accountBalance) {
        ID++;
        this.accountBalance = accountBalance;
    }

    public static int getID() {
        return ID;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }
}
