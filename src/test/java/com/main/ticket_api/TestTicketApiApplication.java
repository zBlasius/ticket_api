package com.main.ticket_api;

import org.springframework.boot.SpringApplication;

public class TestTicketApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(TicketApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
