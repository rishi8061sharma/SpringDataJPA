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
		System.out.println( " sub class of CustDAO "+custDAO.getClass());
		
		//1. save method - inserting Records
		/*Customer cust = new Customer("Mahila Jaywardana", "mahila/jaywardana@hwlmsp.com", 5567234 , "Hyd");
	    custDAO.save(cust);
	    System.out.println(cust.getCid());
	
		
		//2. saveAndFlush() - A) inserts if P.K not given
		Customer cust = new Customer("Sanath Jaysurya", "sanath.jaysurya@hwlmsp.com", 346890 , "Blore");
	    custDAO.saveAndFlush(cust);
	  
		
		//3. saveAndFlush() - B) updates if P.K given and present
		Customer cust = new Customer(15, "Mahila Fernades", "mahila.fernades@hwlmsp.com", 5567234 , "Hyd");
	    custDAO.saveAndFlush(cust);
	    System.out.println(cust.getCid()); 
		
		//4. saveAndFlush() - C) insert  if P.K given and not present
		Customer cust = new Customer(18, "vikram", "vikram@hwlmsp.com", 55555 , "Blore");
	    custDAO.saveAndFlush(cust); 
		
		//5. findAll()
		List<Customer> mylist = custDAO.findAll();
	    mylist.stream().forEach(System.out::println);	
	    
	    //6. findAll
	    List<Integer>myIds = Arrays.asList(11,12,13,14);
	    List<Customer> mylist = custDAO.findAllById(myIds);
	    mylist.stream().forEach(System.out::println);	
	    
	    //7 count 
	    long count = custDAO.count();
	    System.out.println("  count   ::::: "+count);
		
		//8. 
		Customer cust1 = new Customer("pratiksha", "pratiksha@hwlmsp.com", 999433, "Hyd");
		Customer cust2 = new Customer("parvati", "parvati@hwlmsp.com", 666333, "Blore");
		Customer cust3 = new Customer("ravindra", "ravindra@hwlmsp.com", 774422, "Blore");
		 List<Customer>custList = Arrays.asList(cust1, cust2, cust3);
		 custDAO.saveAll(custList);*/
		
		/*Optional<Customer> myOps = custDAO.findById(7);
		myOps.ifPresent(System.out::println);
		
		Customer cust = custDAO.getOne(7);
	//	System.out.println(cust);
		
		Customer cust2 = custDAO.getById(77);
		//System.out.println(cust2);*/
		System.out.println(custDAO.existsById(7));
		System.out.println(custDAO.existsById(77));
		
		Optional<Customer> myOps = custDAO.findById(15);
		//old style of java code
		/*if(myOps.isPresent()) {
			Customer cust = myOps.get();
			custDAO.delete(cust);
		}*/
		
		//functional Programming
	/*	myOps.ifPresent(cust -> custDAO.delete(cust)); */
		
		/*custDAO.deleteById(14);*/
		/*Customer cus1 = custDAO.getById(18);
		Customer cus2 = custDAO.getById(19);
		Customer cus3 = custDAO.getById(21);
		List<Customer>myCustIds = Arrays.asList(cus1,cus2,cus3);
		custDAO.deleteAll(myCustIds);
		Customer cus1 = custDAO.getById(18);
		Customer cus2 = custDAO.getById(19);
		Customer cus3 = custDAO.getById(21);
		List<Customer>myCustIds = Arrays.asList(cus1,cus2,cus3);
		custDAO.deleteAllInBatch(myCustIds);
		*/
		/*
		List<Integer>myIds = Arrays.asList(10, 11, 12);
		//custDAO.deleteAllById(myIds);
		custDAO.deleteAllByIdInBatch(myIds);
		*/
		
		//custDAO.deleteAll();
		//custDAO.deleteAllInBatch();
		System.out.println(" ==== Done ===== ");
	}

	public static void main(String[] args) {
       SpringApplication.run(MyBootApplication.class, args);
	}
}
