package com.duckncheap.notifier;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableRabbit
@EntityScan(basePackages = "com.duckncheap.shared.model")
public class NotifierApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotifierApplication.class, args);
	}
}
