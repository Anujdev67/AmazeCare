package com.hexaware.amazecare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmazecareApplication {

	/**
	 * Bootstraps the Spring Boot application and starts the embedded web server.
	 * This is the single entry point used in local runs, Docker containers, and cloud
	 * deployments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(AmazecareApplication.class, args);
	}

}
