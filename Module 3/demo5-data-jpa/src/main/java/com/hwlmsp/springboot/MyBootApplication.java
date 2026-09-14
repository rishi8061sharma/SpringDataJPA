package com.hwlmsp.springboot;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
		//1. getAllCustomers - phoneSort
		/*Sort phoneSort = Sort.by(Order.asc("phone"));
		mylist=custDAO.getAllCustomers(phoneSort); 
		mylist.forEach(System.out::println); 
		System.out.println(" ----------------------------------- ");
		//2. getAllCustomers - nameSort
		Sort nameSort = Sort.by(Order.asc("cname"));
		mylist=custDAO.getAllCustomers(nameSort); 
		mylist.forEach(System.out::println); 
		
		System.out.println(" ----------------------------------- ");
		//3. findAll - nameSort
		mylist=custDAO.findAll(nameSort); 
		mylist.forEach(System.out::println); 
		
		System.out.println(" ----------------------------------- ");
		//4. findCustomersByCity - sort by phone
		mylist = custDAO.findCustomersByCity("Blore", phoneSort);
		mylist.forEach(System.out::println); 
		
		//5. findCustomersByCity - sort by name
		mylist = custDAO.findCustomersByCity("Blore", nameSort);
		mylist.forEach(System.out::println); 
			*/
	/*	Pageable myPage1 = PageRequest.of(0,5);
		mylist = custDAO.getAllCustomers(myPage1);
		mylist.forEach(System.out::println); */
		
		System.out.println("   -------------------------------");
		/* Pageable and Sort not possible together because Pageable also implementing sortable
		 * 
		 * 
		 Sort nameSort = Sort.by(Order.asc("cname"));
		Pageable myPage1_2 = PageRequest.of(0,5);
		mylist = custDAO.getAllCustomers(myPage1_2, nameSort);
		mylist.forEach(System.out::println); 
		*/
		System.out.println("  ---------------------------------");
		Pageable myPage2 = PageRequest.of(0,5);
		mylist = custDAO.findCustomersByCity("Blore", myPage2);
		mylist.forEach(System.out::println); 
		System.out.println("  ---------------------------------");
		
		//5. findCustomersByCity  Paging and- sort by name
		System.out.println("  Paging and Sort by Name ");
		Sort nameSort = Sort.by(Order.asc("cname"));
		Pageable myPage3 = PageRequest.of(0,5, nameSort);
		mylist = custDAO.findCustomersByCity("Blore", myPage3);
		mylist.forEach(System.out::println); 
		
		//6 findCustomerByCity Paging
			System.out.println("  Paging by city ");
			Pageable myPage4 = PageRequest.of(0,5);
			mylist = custDAO.findCustomersByCity("Blore", myPage4);
			mylist.forEach(System.out::println); 
				
		//6 findCustomerByCity Paging and sort by email
		System.out.println("  Paging by city and Sort by Email ");
		Sort emailSort = Sort.by(Order.asc("email"));
		Pageable myPage5 = PageRequest.of(0,5, emailSort);
		mylist = custDAO.findCustomersByCity("Blore", myPage5);
		mylist.forEach(System.out::println); 
		System.out.println("Done!!!");
		
	}

	public static void main(String[] args) {
       SpringApplication.run(MyBootApplication.class, args);
	}
}
