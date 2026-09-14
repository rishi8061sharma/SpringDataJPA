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
		//Insert 9 Records 
	/*	Customer cust1 = new Customer("Harish", "harish@hwlmsp.com", 555, "Hyd",9000); 
		Customer cust2 = new Customer("Raj", "raj@hwlmsp.com", 222, "Blore",25000); 
		Customer cust3 = new Customer("Mohan", "mohan@hwlmsp.com", 333, "Hyd",15000); 
		Customer cust4 = new Customer("Aakash", "aakash@hwlmsp.com", 888, "Blore",15000); 
		Customer cust5 = new Customer("Mohit", "mohit@hwlmsp.com", 12345, "Delhi",9000); 
		Customer cust6 = new Customer("Rahul", "rahul@hwlmsp.com", 12345, "Blore",18000); 
		Customer cust7 = new Customer("Sachin", "sachin@hwlmsp.com", 333, "Delhi",17000); 
		Customer cust8 = new Customer("Shikar", "shikar@hwlmsp.com", 12345, "Hyd",23000); 
		Customer cust9 = new Customer("Shabhaaz", "shabhaaz@hwlmsp.com", 12345, "Hyd",23000); 
		List<Customer> custList = 
		Arrays.asList(cust1,cust2,cust3,cust4,cust5,cust6,cust7,cust8,cust9); 
		custDAO.saveAll(custList); */
		
		
		
		List<Customer> mylist=null; 
		//1. getCustomersByCname 
		/*	mylist=custDAO.getCustomersByCname("Sri"); 
		mylist.forEach(System.out::println); 
		//2. getCustomersByEmail 
		mylist=custDAO.getCustomersByEmail("hello@hwlmsp.com"); 
		mylist.forEach(System.out::println); 
		//3. readCustomersByPhone 
		mylist=custDAO.readCustomersByPhone(12345); 
		mylist.forEach(System.out::println); 
		//4. findCustomersByCity 
		mylist=custDAO.findCustomersByCity("Hyd"); 
		mylist.forEach(System.out::println);
		//5. getCustomersByEmailAndPhone 
		mylist=custDAO.getCustomersByEmailAndPhone("hello@hwlmsp.com", 12345); 
		mylist.forEach(System.out::println); 
		//6. getCustomersByEmailAndPhone 
		mylist=custDAO.getCustomersByEmailOrPhone("hello@hwlmsp.com", 12345); 
		mylist.forEach(System.out::println);  */ 
		//7. getCustomersByCnameLike 
		/*mylist=custDAO.getCustomersByCnameLike("sr%"); 
		mylist.forEach(System.out::println); 
		//8. getCustomersByCnameStartsWith 
		mylist=custDAO.getCustomersByCnameStartsWith("sd"); 
		mylist.forEach(System.out::println); 
		//9. getCustomersByEmailEndsWith 
		mylist=custDAO.getCustomersByEmailEndsWith("@cc"); 
		mylist.forEach(System.out::println); 
		//10. getCustomersByEmailContains 
		mylist=custDAO.getCustomersByCnameContains("jlc"); 
		mylist.forEach(System.out::println); 
		//11. getCustomersByCityIn 
		mylist=custDAO.getCustomersByCityIn("Hyd","Delhi"); 
		mylist.forEach(System.out::println); 
		//12. getCustomersByCityNotIn 
		mylist=custDAO.getCustomersByCityNotIn("Hyd","Delhi"); 
		mylist.forEach(System.out::println); 
		//13. countCustomersByCity 
		long count=custDAO.countCustomersByCity("Hyd"); 
		System.out.println(count); 
		//14. countCustomersByCityIn 
		count=custDAO.countCustomersByCityIn("Hyd","Delhi"); 
		System.out.println(count); 
		//15. getCustomersByCityNotIn 
		count=custDAO.countCustomersByCityNotIn("Blore"); 
		System.out.println(count); 
		//16. countCustomersByEmailNull 
		count=custDAO.countCustomersByEmailNull(); 
		System.out.println(count); 
		//17. countCustomersByEmailNotNull 
		count=custDAO.countCustomersByEmailNotNull(); 
		System.out.println(count);
		//18. getCustomersByEmailNull 
		mylist=custDAO.getCustomersByEmailNull(); 
		mylist.forEach(System.out::println); 
		//19. getCustomersByEmailNotNull 
		mylist=custDAO.getCustomersByEmailNotNull(); 
		mylist.forEach(System.out::println); 
		//20. getCustomersByBalance 
		mylist=custDAO.getCustomersByBalance(15000); 
		mylist.forEach(System.out::println); 
		//21. getCustomersByBalanceIsBetween 
		mylist=custDAO.getCustomersByBalanceIsBetween(10000,20000); 
		mylist.forEach(System.out::println); 
		//22. getCustomersByBalanceIsGreaterThan 
		mylist=custDAO.getCustomersByBalanceIsGreaterThan(20000); 
		mylist.forEach(System.out::println); 
		//23. getCustomersByBalanceLessThan 
		mylist=custDAO.getCustomersByBalanceLessThan(10000); 
		mylist.forEach(System.out::println); 
		//24. getCustomersByBalanceGreaterThanEqual 
		mylist=custDAO.getCustomersByBalanceGreaterThanEqual(20000); 
		mylist.forEach(System.out::println); 
		//25. getCustomersByBalanceLessThanEqual 
		mylist=custDAO.getCustomersByBalanceLessThanEqual(10000); 
		mylist.forEach(System.out::println); */
		System.out.println("Done!!!");

	}

	public static void main(String[] args) {
       SpringApplication.run(MyBootApplication.class, args);
	}
}
