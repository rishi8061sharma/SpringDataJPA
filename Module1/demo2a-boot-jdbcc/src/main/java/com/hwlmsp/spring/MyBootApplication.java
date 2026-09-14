package com.hwlmsp.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBootApplication implements CommandLineRunner {

	@Autowired
	CustomerDAO custDAO;



	public void run(String... args) throws Exception {
		//1. Add the Customer
		Customer cust = new Customer(110, "harish", "harish@hwlmsp.com", 222222 , "Delhi");
		custDAO.addCustomer(cust);

		//2. get All Customers
		List<Customer>mylist = custDAO.getAllCustomers();
		mylist.forEach(myCust -> System.out.println(myCust));
		System.out.println("============================"); 

		//3 Get Customers by City
		List<Customer>mylist1 = custDAO.getCustomersByCity("Delhi");
		mylist1.forEach(myCust -> System.out.println(myCust));
		System.out.println(" ==== Done ===== ");
	}

	public static void main(String[] args) {
       SpringApplication.run(MyBootApplication.class, args);
	}
}
