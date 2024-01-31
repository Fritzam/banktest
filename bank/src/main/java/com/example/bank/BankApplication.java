package com.example.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	private final ClientBase clientBase;
	private final TransactionBase transactionBase;
	private final TransferService transferService;

	public BankApplication(ClientBase clientBase, TransferService transferService, TransactionBase transactionBase) {
		this.clientBase = clientBase;
		this.transferService = transferService;
		this.transactionBase = transactionBase;
		execProcess();

	}

	public void execProcess() {
		clientBase.addClient(12500);
	}
}
