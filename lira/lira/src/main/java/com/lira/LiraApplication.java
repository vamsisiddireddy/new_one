package com.lira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class LiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiraApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LiraApplication.class);
    }

	
}
