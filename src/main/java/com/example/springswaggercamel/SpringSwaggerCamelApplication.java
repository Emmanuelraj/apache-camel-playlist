package com.example.springswaggercamel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringSwaggerCamelApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(SpringSwaggerCamelApplication.class, args);
	}

}
