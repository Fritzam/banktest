package com.example.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

public class ClientBaseUnitTests {
    private ClientBase clientBase;
    @BeforeEach
    void setUp() {
        clientBase = new ClientBase();
    }

    @AfterEach
    void clearList() {
        clientBase.purgeList();
    }

    @Test
    void shouldAddUser() {
        clientBase.addClient(12000);
        assertThat(clientBase.getClientList().get(0).getID()).isEqualTo(1);
    }

    @Test
    void shouldFindUserOfID1() {
        clientBase.addClient(12000);
        assertThat(clientBase.getClientList().get(0).getID()).isEqualTo(2);
    }

    @Test
    void checkExceptionOnNegativeBalance() {
        assertThrows(IllegalArgumentException.class, () -> {
            clientBase.addClient(-12.0);
        });
    }
}
