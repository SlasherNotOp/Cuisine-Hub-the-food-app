package com.Food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.Food"})
public class FoodAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAppApplication.class, args);
	}

}
