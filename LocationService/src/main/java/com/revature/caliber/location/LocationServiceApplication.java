package com.revature.caliber.location;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LocationServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LocationServiceApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {}
}
