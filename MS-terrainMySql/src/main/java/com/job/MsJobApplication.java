package com.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsJobApplication.class, args);
	}

}
