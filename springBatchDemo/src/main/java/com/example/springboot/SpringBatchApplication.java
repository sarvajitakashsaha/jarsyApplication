package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBatchApplication {

	public static void main(String[] args) {
		System.out.println("spring Batch Demo");
		SpringApplication.run(SpringBatchApplication.class, args);
	}

}
