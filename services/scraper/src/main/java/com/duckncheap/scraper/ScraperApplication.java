package com.duckncheap.scraper;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableRabbit
@EnableScheduling
@SpringBootApplication
@EntityScan(basePackages = "com.duckncheap.shared.model")
@EnableJpaRepositories({
        "com.duckncheap.scraper.repository",
        "com.duckncheap.shared.repository"
})
public class ScraperApplication {
	public static void main(String[] args) {
		SpringApplication.run(ScraperApplication.class, args);
	}
}
