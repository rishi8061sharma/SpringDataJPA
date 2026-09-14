package com.hwlmsp.springboot;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;


@SpringBootApplication
public class MyBootApplication implements CommandLineRunner {

	@Autowired
	CustomerDAO custDAO;

	public void run(String... args) throws Exception {
		List<Customer> mylist=null; 
        //1. fetchCustomersByCity
		/*
	    mylist = custDAO.fetchCustomersByCity("Hyd");
		mylist.forEach(System.out::println);
        System.out.println("--------------------------------------------------"); */
        
        //2. fetchCustomersByPhone
		/*mylist = custDAO.fetchCustomersByPhone(444);
		mylist.forEach(System.out::println);
		System.out.println("---------------------------------------------------"); */
		
		//3. fetchCustomersByBal
		/* mylist = custDAO.fetchCustomersByBal(18000);
		 mylist.forEach(System.out::println);
	     System.out.println("--------------------------------------------------"); */
		
       //4. fetchCustomersByBalGTE
	     /*mylist = custDAO.fetchCustomersByBalGTE(18000);
		 mylist.forEach(System.out::println);
	     System.out.println("--------------------------------------------------");  */
	     
	     //5. fetchCustomersByBalLTE
	    /* mylist = custDAO.fetchCustomersByBalLTE(18000);
		 mylist.forEach(System.out::println);
	     System.out.println("--------------------------------------------------");  */
		
		//6. fetchCustomersByBalRange
		   /*  mylist = custDAO.fetchCustomersByBalRange(25000, 35000);
		     mylist.forEach(System.out::println);
	        System.out.println("--------------------------------------------------");  */
	        
	      //7. fetchCustomersByEmailAndPhone1
		   /*  mylist = custDAO.fetchCustomersByEmailAndPhone1("rakesh@jlc.com",999 );
		        mylist.forEach(System.out::println);
	            System.out.println("--------------------------------------------------"); */
		
		   //8. fetchCustomersByEmailOrPhone1
			/*  mylist = custDAO.fetchCustomersByEmailOrPhone1("rakesh@jlc.com",999 );
		         mylist.forEach(System.out::println);
		         System.out.println("--------------------------------------------------");  */
		
		  //9. fetchCustomersByCitiesIN
			/* mylist = custDAO.fetchCustomersByCitiesIN("Blore", "Delhi");
	         mylist.forEach(System.out::println);
	         System.out.println("--------------------------------------------------");  */
		    
			//10. fetchCustomersByCitiesNIN
			 mylist = custDAO.fetchCustomersByCitiesNIN("Hyd", "Delhi");
	         mylist.forEach(System.out::println);
	         System.out.println("--------------------------------------------------"); 
		     System.out.println(" ==== Done ===== ");
	}

	public static void main(String[] args) {
       SpringApplication.run(MyBootApplication.class, args);
	}
}
