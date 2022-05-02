package com.proyecto.pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PackApplication {

	public static void main(String[] args) {

		SpringApplication.run(PackApplication.class, args);
	}

}
