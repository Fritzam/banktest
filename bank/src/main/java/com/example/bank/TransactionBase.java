package com.example.bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TransactionBase {
    private ArrayList<Transaction> transactionsList = new ArrayList<>();

    public void addTransactionToBase(Transaction transaction) {
        transactionsList.add(transaction);
    }
    public ArrayList<Transaction> getTransactionsList() {return transactionsList;}
    public void purgeList() {
        this.transactionsList.clear();
    }


}
