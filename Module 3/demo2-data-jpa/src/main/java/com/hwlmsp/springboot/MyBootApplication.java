package com.hwlmsp.springboot;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBootApplication implements CommandLineRunner {
@Autowired
CustomerService customerService;
	
	public void run(String... args) throws Exception {
		
		customerService.findCustomerById(7)
		.ifPresent(System.out::println);
		
		customerService.findCustomerById(77)
		.ifPresent(System.out::println);
		
		customerService.getCustomerById(7)
		.ifPresent(System.out::println);
		
		customerService.getCustomerById(77)
		.ifPresent(System.out::println);
		
		System.out.println(" ==== Done ===== ");
	}

	public static void main(String[] args) {
       SpringApplication.run(MyBootApplication.class, args);
	}
}
