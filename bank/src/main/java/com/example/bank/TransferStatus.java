package com.example.bank;

public enum TransferStatus {
    OK("Success"), BALANCEFAILURE("Insufficient balance"), ERR("Something went wrong");

    private String description;
    TransferStatus(String description) {
        this.description = description;
    }
}
