package com.example.api_task_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class ApiTaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTaskManagerApplication.class, args);
	}

}
