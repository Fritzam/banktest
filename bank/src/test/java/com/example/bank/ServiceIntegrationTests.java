package com.example.bank;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ServiceIntegrationTests {

    @MockBean
    private TransactionBase transactionBase;

    @MockBean
    private ClientBase clientBase;

    @Autowired
    private TransferService transferService;

    @Test
    void shouldBeValidTransfer() {
        Client mock = Mockito.mock(Client.class);
        when(clientBase.getClient(1)).thenReturn(mock);
        when(mock.getAccountBalance()).thenReturn(8000.0);
        assertThat(transferService.validTransfer(1, 7000)).isTrue();
    }

    @Test
    void shouldNotBeAValidTransfer() {
        Client mock = Mockito.mock(Client.class);
        when(clientBase.getClient(1)).thenReturn(mock);
        when(mock.getAccountBalance()).thenReturn(8000.0);
        assertThat(transferService.validTransfer(1, 20000)).isFalse();
    }

    @Test
    void shouldNotTransferMoney() {
        Client clientMock = Mockito.mock(Client.class);
        when(clientBase.getClient(1)).thenReturn(clientMock);
        when(clientMock.getAccountBalance()).thenReturn(8000.0);
        assertThrows(IllegalArgumentException.class, () -> transferService.transferMoney(1, 12000));
    }

    @Test
    void shouldTransferMoney() {
        Client clientMock = Mockito.mock(Client.class);
        when(clientBase.getClient(1)).thenReturn(clientMock);
        when(clientMock.getAccountBalance()).thenReturn(8000.0);
        transferService.transferMoney(1, 5000);
        verify(clientMock).setAccountBalance(3000);
    }

    @Test
    void shouldAddToBalance() {
        Client clientMock = Mockito.mock(Client.class);
        when(clientBase.getClient(1)).thenReturn(clientMock);
        when(clientMock.getAccountBalance()).thenReturn(8000.0);
        transferService.addToBalance(1, 2000.0);
        verify(clientMock).setAccountBalance(10000.0);
    }

    @Test
    void shouldReturnProperReport() {
        Client clientMock = Mockito.mock(Client.class);
        Transaction transactionMock = Mockito.mock(Transaction.class);

        when(clientBase.getClient(1)).thenReturn(clientMock);
        when(clientMock.getID()).thenReturn(1);
        when(clientMock.getAccountBalance()).thenReturn(2000.0);
        when(transactionMock.getTransferStatus()).thenReturn(TransferStatus.OK);

        TransactionReport report = transferService.addToBalance(1, 8000);

        assertThat(report.getID()).isEqualTo(1);
        assertThat(report.getCurrentBalance()).isEqualTo(2000.0);
        assertThat(report.getTransferStatus()).isEqualTo(TransferStatus.OK);

    }



}
