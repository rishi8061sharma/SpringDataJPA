package com.hwlmsp.springboot;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;


@SpringBootApplication
public class MyBootApplication implements CommandLineRunner {

	@Autowired
	CustomerDAO custDAO;

	public void run(String... args) throws Exception {
		List<Customer> mylist=null; 
	    mylist = custDAO.getAllCustomers();
		mylist.forEach(System.out::println); 
		System.out.println(" ------------------------------- ");
		Customer cust1 = new Customer(107, "Tusar", "tusar@hwlmsp.com", 876, "Hyd", 32500);
		custDAO.addCustomer(cust1);
		System.out.println(" ------------------------------- ");
		mylist = custDAO.getAllCustomers();
		mylist.forEach(System.out::println); 
		System.out.println(" ------------------------------- ");
		System.out.println("Done!!!");
	}

	public static void main(String[] args) {
       SpringApplication.run(MyBootApplication.class, args);
	}
}
