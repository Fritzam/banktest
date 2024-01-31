package com.example.bank;

public class Client {
    private static int ID = 0;
    private int id;
    private double accountBalance;

    Client(double accountBalance) {
        this.id = ID++;
        this.accountBalance = accountBalance;
    }
    public int getID() {
        return ID;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public static void resetID() {
        ID = 0;
    }
}
