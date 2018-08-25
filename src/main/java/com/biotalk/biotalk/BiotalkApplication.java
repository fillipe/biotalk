package com.biotalk.biotalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // (exclude = { SecurityAutoConfiguration.class })
public class BiotalkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiotalkApplication.class, args);
	}
}
