package com.challenge.sprinter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.challenge.sprinter.")
public class SprinterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinterApplication.class, args);
	}

}
