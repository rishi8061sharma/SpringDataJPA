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
		//1. findAll - phoneSort
		/*Sort phoneSort = Sort.by(Order.desc("phone"));
		mylist=custDAO.findAll(phoneSort); 
		mylist.forEach(System.out::println); 
		System.out.println(" ----------------------------------- "); */
		
		//2. findAll - nameSort
		/*Sort nameSort = Sort.by(Order.asc("cname"));
		mylist=custDAO.findAll(nameSort); 
		mylist.forEach(System.out::println); 
		System.out.println(" ----------------------------------- "); */
		
		//3. fetchCustomersByCity -
		/*Sort emailSort = Sort.by(Order.desc("email"));
		mylist = custDAO.fetchCustomersByCity("Blore", emailSort);
		mylist.forEach(System.out::println); 
		System.out.println("   --------------------------------------"); */
		
		List<Customer> custList=null; 
		Page<Customer> pageList=null;  
		Pageable myPage1 = PageRequest.of(0,3);
		pageList = custDAO.findAll(myPage1);
		pageList.forEach(System.out::println); 
		System.out.println("   -------------------------------");
		
			
	
		/* Pageable and Sort not possible together because Pageable also implementing sortable */
		Sort emailSort = Sort.by(Order.desc("email"));
		Pageable myPage2 = PageRequest.of(0,3, emailSort);
		pageList = custDAO.findAll(myPage2);
		pageList.forEach(System.out::println); 
		System.out.println("  ---------------------------------");
		
		Pageable myPage3 = PageRequest.of(0,3);
		custList = custDAO.fetchCustomersByCity("Blore", myPage3);
		custList.forEach(System.out::println); 
		System.out.println("  ---------------------------------");
		
		//5. fetchCustomersByCity  Paging and- sort by email
		System.out.println("  Paging and Sort by email ");
		Pageable myPage4 = PageRequest.of(0,5, emailSort);
		mylist = custDAO.fetchCustomersByCity("Blore", myPage4);
		mylist.forEach(System.out::println); 
		
		//6 findCustomerByCity Paging
		/*	System.out.println("  Paging by city ");
			Pageable myPage4 = PageRequest.of(0,5);
			mylist = custDAO.findCustomersByCity("Blore", myPage4);
			mylist.forEach(System.out::println);  */
				
		//6 findCustomerByCity Paging and sort by email
		/*System.out.println("  Paging by city and Sort by Email ");
		Sort emailSort = Sort.by(Order.asc("email"));
		Pageable myPage5 = PageRequest.of(0,5, emailSort);
		mylist = custDAO.findCustomersByCity("Blore", myPage5);
		mylist.forEach(System.out::println);  */
		System.out.println("Done!!!");
	}

	public static void main(String[] args) {
       SpringApplication.run(MyBootApplication.class, args);
	}
}
