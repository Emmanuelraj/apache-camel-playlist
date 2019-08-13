package com.example.apachecamel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com.example.apachecamel.component")
public class ApacheCamelApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(ApacheCamelApplication.class, args);
	}

}
