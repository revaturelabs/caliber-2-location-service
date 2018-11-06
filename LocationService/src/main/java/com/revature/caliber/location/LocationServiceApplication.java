package com.revature.caliber.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages={"com.revature.caliber"})
@EnableDiscoveryClient
public class LocationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationServiceApplication.class, args);

	}
}
