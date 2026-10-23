package com.main.ticket_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketApiApplication.class, args);
		// How to insert global JWT login?
		// How to configure CORS?
		// Is there any other factor involving security here?
	}

}
