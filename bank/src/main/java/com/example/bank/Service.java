package com.example.bank;

import org.springframework.stereotype.Component;

@Component
public class Service {

    private final ClientBase clientBase;
    private final TransactionBase transactionBase;

    Service(ClientBase clientBase, TransactionBase transactionBase) {
        this.clientBase = clientBase;
        this.transactionBase = transactionBase;
    }


    public TransactionReport transferMoney(int ID, double transferAmount) {
        Client client = clientBase.getClient(ID);
        Transaction transaction = new Transaction(client, transferAmount);

        if (!validTransfer(ID, transferAmount)) {
            transaction.setTransferStatus(TransferStatus.BALANCEFAILURE);
            transactionBase.addTransactionToBase(transaction);
            throw new IllegalArgumentException("Insufficient founds.");
        } else if (validTransfer(ID, transferAmount)) {
            transaction.setTransferStatus(TransferStatus.OK);
            transactionBase.addTransactionToBase(transaction);
            client.setAccountBalance(client.getAccountBalance() - transferAmount);
        }
        return generateTransactionReport(client.getID(), client.getAccountBalance(), transaction.getTransferStatus());
    }

    public TransactionReport addToBalance(int ID, double transferAmount) {
        Client client = clientBase.getClient(ID);
        Transaction transaction = new Transaction(client, transferAmount);
        if (transferIsPositive(transferAmount)) {
            transaction.setTransferStatus(TransferStatus.OK);
            client.setAccountBalance(client.getAccountBalance() + transferAmount);
        } else {
            transaction.setTransferStatus(TransferStatus.ERR);
        }
        return generateTransactionReport(client.getID(), client.getAccountBalance(), transaction.getTransferStatus());
    }

    public boolean validTransfer(int ID, double amount) {
        if (clientBase.getClient(ID).getAccountBalance() - amount > 0) {
            return true;
        }
        return false;
    }

    public boolean transferIsPositive(double transferAmount) {
        return transferAmount > 0;
    }

    public TransactionReport generateTransactionReport(int ID, double currentBalance, TransferStatus transferStatus) {
        return new TransactionReport(ID, currentBalance, transferStatus);
    }








}
