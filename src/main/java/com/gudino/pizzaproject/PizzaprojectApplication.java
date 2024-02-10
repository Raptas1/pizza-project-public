package com.gudino.pizzaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gudino"})
public class PizzaprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaprojectApplication.class, args);
	}

}
