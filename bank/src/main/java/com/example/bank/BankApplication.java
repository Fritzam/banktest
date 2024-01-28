package com.example.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	private final ClientBase clientBase;
	private final Service service;

	public BankApplication(ClientBase clientBase, Service service) {
		this.clientBase = clientBase;
		this.service = service;
	}
}
