package com.example.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceUnitTests {

    private ClientBase clientBase;
    private TransactionBase transactionBase;
    private Service service;

    @BeforeEach
    void setUp() {
        clientBase = new ClientBase();
        transactionBase = new TransactionBase();
        service = new Service(clientBase, transactionBase);

    }

    @AfterEach
    void purgeLists() {
        clientBase.purgeList();
        Client.resetID();
    }

    @Test
    void shouldBeValidTransfer() {
        clientBase.addClient(12000);
        boolean isValid = service.validTransfer(1, 1000);
        assertThat(isValid).isTrue();
    }

    @Test
    void shouldNotBeValidTransfer() {
        clientBase.addClient(12000);
        boolean isValid = service.validTransfer(1, 13000);
        assertThat(isValid).isFalse();
    }

    @Test
    void shouldWithdrawA1000() {
        clientBase.addClient(12000);
        service.transferMoney(1, 1000);
        double current_balance = clientBase.getClient(1).getAccountBalance();
        assertThat(current_balance).isEqualTo(11000);

    }

    @Test
    void shouldThrowInsufficientFoundsException() {
        assertThrows(IllegalArgumentException.class, () -> {
           clientBase.addClient(12000);
           service.transferMoney(1, 13000);
        });
    }

    @Test
    void shouldReturnTransactionReport() {
        clientBase.addClient(12000);
        TransactionReport report = service.transferMoney(1, 1000);
        assertThat(report).isInstanceOf(TransactionReport.class);
    }

    @Test
    void shouldAddTo20000() {
        clientBase.addClient(12000);
        TransactionReport final_balance = service.addToBalance(1, 8000);
        assertThat(final_balance.getCurrentBalance()).isEqualTo(20000);
    }

    @Test
    void shouldHaveFailedStatus() {
        clientBase.addClient(12000);
        TransactionReport failed_status = service.addToBalance(1, -20000);
        assertThat(failed_status.getTransferStatus()).isEqualTo(TransferStatus.ERR);
    }

    @Test
    void shouldHaveOKStatus() {
        clientBase.addClient(12000);
        TransactionReport ok_status = service.addToBalance(1, 15000);
        assertThat(ok_status.getTransferStatus()).isEqualTo(TransferStatus.OK);
    }
    @Test
    void shouldReturnProperStatus() {
        clientBase.addClient(12000);
        TransactionReport status = service.transferMoney(1, 5000);
        assertThat(status.TransactionInfo()).isEqualTo(
        "Client ID: " + "1" + "\nCurrent balance: " + "7000.0" + "\nTransaction status: " + "OK"
        );
    }

}
