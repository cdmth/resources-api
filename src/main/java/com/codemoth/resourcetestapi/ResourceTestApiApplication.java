package com.codemoth.resourcetestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.codemoth.resourcetestapi"})
public class ResourceTestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceTestApiApplication.class, args);
	}

}

