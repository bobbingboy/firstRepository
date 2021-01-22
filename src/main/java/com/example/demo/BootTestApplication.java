package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"tw.example.demo","tw.bobbyko.model","tw.bobbyko.controller","tw.bobbyko.repos"})
//@EntityScan({"tw.example.demo","tw.bobbyko.model","tw.bobbyko.controller","tw.bobbyko.repos"})
public class BootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootTestApplication.class, args);
	}

}
