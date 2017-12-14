package com.jim.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class SpringbootAsyncSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAsyncSampleApplication.class, args);
	}
}
