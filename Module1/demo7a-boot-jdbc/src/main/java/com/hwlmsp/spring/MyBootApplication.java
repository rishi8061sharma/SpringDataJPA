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
		Customer cust = new Customer(121, "Raj", "rajh@hwlmsp.com", 535678 , "Hyd");
		custDAO.addCustomer(cust);

		//2. get All Customers
		List<Customer>mylist1 = custDAO.getAllCustomers();
		mylist1.forEach(myCust -> System.out.println(myCust));
		System.out.println("============================"); 

		//3 Get Customers by City
		List<Customer>mylist2 = custDAO.getCustomersByCity("Delhi");
		mylist2.forEach(myCust -> System.out.println(myCust));
		System.out.println("============================"); 
		//4 Get Customers Email by Phone Number
		/*This is appropriate method only when only fetch email on the basis of phone
		 * but we have to fetch Customer Object then get email it is facing
		 *   performance issue 1. Heap Memory 2. Band Width
		 *   Network Band Width : lot of data fetch of customer, more band width then request 
		 *   processing is slow, less bandth width mean request processing is fast.
		 */
		String email = custDAO.getCustomerEmailByPhone(535678);
		System.out.println("  email  :::  "+email);
		System.out.println(" ==== Done ===== ");
	}

	public static void main(String[] args) {
		SpringApplication.run(MyBootApplication.class, args);
	}
}
