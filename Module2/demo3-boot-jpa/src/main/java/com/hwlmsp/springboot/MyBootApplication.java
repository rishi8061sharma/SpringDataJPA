package com.hwlmsp.springboot;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

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
		/*Customer cust1 = new Customer("hai", "hai@hwlmsp.com", 65758 , "Hyd");
		custDAO.addCustomer(cust1);
		
		//2. Update Customer
		Customer cust2 = new Customer(10, "Raj kapoor", "raj.kapoor@hwlmsp.com", 887766 , "Delhi");
        custDAO.updateCustomer(cust2); */
		
        /*//3. Get Customer By Cid
        Customer cust3 =   custDAO.getCustomersByCid(10);
        System.out.println("  cust3 :::: "+cust3);
        
        Customer cust4 =   custDAO.getCustomersByCid(88);
        System.out.println("  cust4 :::: "+cust4);
        
        custDAO.deleteCustomer(1);
        custDAO.deleteCustomer(101);
	    //2. get All Customers
		List<Customer>mylist = custDAO.getAllCustomers();
		mylist.forEach(myCust -> System.out.println(myCust));
		System.out.println("============================"); 

		//3. Get Customers by City
		List<Customer>mylist1 = custDAO.getAllCustomersByCity("Blore");
		System.out.println("   ---mylist1---- ");
		mylist1.forEach(myCust -> System.out.println(myCust));
		
		//4. Get Customers by City
		List<Customer>mylist2 = custDAO.getAllCustomersByCity1("Blore");
		System.out.println("   ---mylist2---- ");
		mylist2.forEach(myCust -> System.out.println(myCust));
		
		//4. Get Customer by email
		Customer cust = custDAO.getCustomerByEmail("rishi@hwlmsp.com");
		System.out.println(" cust  object is "+cust); */
		
		/* 5. Mulitple record on the same email id raise exception 
		Caused by: javax.persistence.NonUniqueResultException: query did not return a unique result: 2 */
		/* Customer cust1 = custDAO.getCustomerByEmail("rahul@hwlmsp.com");
		System.out.println(" cust  object is "+cust1); */
	/*	System.out.println("============================"); 
		
		//6. Get Customers by phone
		List<Customer>mylist  = custDAO.getCustomersByPhone(33442);
		System.out.println(" cust  object is ");
		mylist.forEach(myCust -> System.out.println(myCust));
		
		//7. Get Customers by Email and Phone
		mylist  = custDAO.getCustomersByEmailAndPhone("shankar@hwlmsp.com", 33442);
		System.out.println(" cust  object is ");
		mylist.forEach(myCust -> System.out.println(myCust));
		System.out.println("   ---------------------------------   "); */
		
		//8 Get Customers by Email Or Phone
		/*List<Customer>mylist  = custDAO.getCustomersByEmailOrPhone("hello@hwlmsp.com", 99999);
		System.out.println(" cust  object is ");
		mylist.forEach(myCust -> System.out.println(myCust)); */
		
		//9 Map of email and phone Using SQL, 
		Map<String, Integer>myMap  = custDAO.getCustomersInfo("Blore");
	    System.out.println(" myMap  :::: "+myMap);
		System.out.println(" ==== Done ===== ");
		
	
		System.out.println(" ==== Done ===== ");
	}

	public static void main(String[] args) {
       SpringApplication.run(MyBootApplication.class, args);
	}
}
