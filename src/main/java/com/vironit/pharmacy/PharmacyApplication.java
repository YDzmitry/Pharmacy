package com.vironit.pharmacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication//(exclude = JpaRepositoriesAutoConfiguration.class)
public class PharmacyApplication {
	public static void main(String[] args) {
		SpringApplication.run(PharmacyApplication.class, args);
	}
}
