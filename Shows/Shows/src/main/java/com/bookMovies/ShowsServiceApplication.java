package com.bookMovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.bookMovies.client")
public class ShowsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowsServiceApplication.class, args);
	}

}
