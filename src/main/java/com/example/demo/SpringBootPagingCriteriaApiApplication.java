package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.example"})
public class SpringBootPagingCriteriaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPagingCriteriaApiApplication.class, args);
	}

}
