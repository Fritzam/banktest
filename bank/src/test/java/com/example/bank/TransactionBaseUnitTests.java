package com.example.bank;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionBaseUnitTests {
    TransactionBase transactionBase;
    @BeforeEach
    void setUp() {
        transactionBase = new TransactionBase();
    }

    @Test
    void checkTransactionAddedToList() {
        Client client = new Client(12000);
        Transaction transaction = new Transaction(client, 5000);
        transactionBase.addTransactionToBase(transaction);
        assertThat(transactionBase.getTransactionsList()).isNotEmpty();
    }

}
