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
		//1. getCustomersByCname 
		/*mylist=custDAO.getCustomersByCname("Hello"); 
		mylist.forEach(System.out::println); 
		System.out.println("--------------------------------");*/
		
		//2. getCustomersByEmail 
		/*mylist=custDAO.getCustomersByEmail("sd@jlc.com"); 
		mylist.forEach(System.out::println);  */
		
		//3. readCustomersByPhone 
		/*mylist=custDAO.readCustomersByPhone(777); 
		mylist.forEach(System.out::println); 
		System.out.println("--------------------------------");*/
		
		//4. findCustomersByCity 
		/*mylist=custDAO.findCustomersByCity("Hyd"); 
		mylist.forEach(System.out::println); 
		System.out.println("--------------------------------"); */
		
		//5. getCustomersByEmailAndPhone 
		/*mylist=custDAO.getCustomersByEmailAndPhone("hello@jlc.com", 333); 
		mylist.forEach(System.out::println); 
		System.out.println("--------------------------------"); */
		
		//6. getCustomersByEmailOrPhone 
		/*mylist=custDAO.getCustomersByEmailOrPhone("hello@jlc.com", 444); 
		mylist.forEach(System.out::println); 
		System.out.println("--------------------------------");  */
		
		//7. getCustomersByCityIn 
		/*mylist=custDAO.getCustomersByCityIn("Hyd","Blore"); 
		mylist.forEach(System.out::println); 
		System.out.println("--------------------------------"); */
		
		//8. getCustomersByCityNotIn 
		/*mylist=custDAO.getCustomersByCityNotIn("Hyd","Blore"); 
		mylist.forEach(System.out::println); */
		
		//9. countCustomersByCity 
		/*long count=custDAO.countCustomersByCity("Hyd"); 
		System.out.println(count); 
		System.out.println("--------------------------------");*/
		
		//10. countCustomersByCityIn 
		/*long count=custDAO.countCustomersByCityIn("Hyd","Delhi"); 
		System.out.println(count); 
		System.out.println("--------------------------------"); */
		
		//11. getCustomersByCityNotIn 
		/*long count=custDAO.countCustomersByCityNotIn("Blore"); 
		System.out.println(count); 
		System.out.println("--------------------------------"); */
		
		//12. getCustomersByBalance 
		/*mylist=custDAO.getCustomersByBalance(18000); 
		mylist.forEach(System.out::println); 
		System.out.println("--------------------------------"); */
		
		//13. getCustomersByBalanceIsBetween 
		/*mylist=custDAO.getCustomersByBalanceIsBetween(10000,20000); 
		mylist.forEach(System.out::println); 
		System.out.println("--------------------------------"); */
		
		//14. getCustomersByBalanceIsGreaterThan 
		/*mylist=custDAO.getCustomersByBalanceIsGreaterThan(20000); 
		mylist.forEach(System.out::println); 
		System.out.println("--------------------------------"); */
		
		//15. getCustomersByBalanceLessThan 
		/*mylist=custDAO.getCustomersByBalanceLessThan(15000); 
		mylist.forEach(System.out::println); 
		System.out.println("--------------------------------"); */
		
		
		//16. getCustomersByBalanceGreaterThanEqual 
		/*mylist=custDAO.getCustomersByBalanceGreaterThanEqual(20000); 
		mylist.forEach(System.out::println); 
		System.out.println("--------------------------------"); */


		//17. getCustomersByBalanceLessThanEqual 
		mylist=custDAO.getCustomersByBalanceLessThanEqual(15000); 
		mylist.forEach(System.out::println); 
		System.out.println("--------------------------------"); 


		
		System.out.println(" ==== Done ===== ");
	}

	public static void main(String[] args) {
       SpringApplication.run(MyBootApplication.class, args);
	}
}
