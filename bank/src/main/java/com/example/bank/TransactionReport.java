package com.example.bank;

public class TransactionReport {
    private final int ID;
    private final double currentBalance;
    private final TransferStatus transferStatus;

    TransactionReport(int ID, double currentBalance, TransferStatus transferStatus) {
        this.ID = ID;
        this.currentBalance = currentBalance;
        this.transferStatus = transferStatus;
    }

    public int getID() {
        return ID;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public TransferStatus getTransferStatus() {
        return transferStatus;
    }
    public String TransactionInfo() {
        return "Client ID: " + this.getID() + "\nCurrent balance: " + this.getCurrentBalance()
                + "\nTransaction status: " + this.getTransferStatus();
    }
}
