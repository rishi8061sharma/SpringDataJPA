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
	CustomerDAO custDAO;

	public void run(String... args) throws Exception {
		List<Customer> mylist=null; 
		//1. getCustomersNyEmailAndPhone1 
		mylist=custDAO. getCustomersNyEmailAndPhone1("hello@jlc",12345); 
		mylist.forEach(System.out::println); 
		//2. getCustomersNyEmailAndPhone2 
		mylist=custDAO. getCustomersNyEmailAndPhone2("hello@jlc",12345); 
		mylist.forEach(System.out::println); 
		//3. getCustomersNyEmailOrPhone1 
		mylist=custDAO.getCustomersNyEmailOrPhone1("hello@jlc",12345); 
		mylist.forEach(System.out::println); 
		//4. getCustomersNyEmailOrPhone2 
		mylist=custDAO.getCustomersNyEmailOrPhone2("hello@jlc",12345); 
		mylist.forEach(System.out::println); 
		//5. findCustomersByCity1 
		mylist=custDAO.findCustomersByCity1("Blore"); 
		mylist.forEach(System.out::println); 
		//6. findCustomersByCity2 
		mylist=custDAO.findCustomersByCity2("Blore"); 
		mylist.forEach(System.out::println); 
		//7. findAllCustomers1 
		mylist=custDAO.findAllCustomers1(); 
		mylist.forEach(System.out::println); 
		//8. findAllCustomers2 
		mylist=custDAO.findAllCustomers2(); 
		mylist.forEach(System.out::println); 
		//9. findCustomersByPhone1 
		mylist=custDAO.findCustomersByPhone1(12345); 
		mylist.forEach(System.out::println); 
		//10. findCustomersByPhone2 
		mylist=custDAO.findCustomersByPhone2(12345); 
		mylist.forEach(System.out::println); 
		System.out.println("Done!!!");

	}

	public static void main(String[] args) {
       SpringApplication.run(MyBootApplication.class, args);
	}
}
