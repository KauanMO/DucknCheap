package com.DucknCheap;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class NotifierApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotifierApplication.class, args);
	}
}
