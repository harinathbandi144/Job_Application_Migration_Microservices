package com.jobapplicaton.configservicer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigservicerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigservicerApplication.class, args);
	}

}
