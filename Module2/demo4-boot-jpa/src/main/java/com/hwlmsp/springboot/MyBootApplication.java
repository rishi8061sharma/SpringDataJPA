package com.hwlmsp.springboot;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBootApplication implements CommandLineRunner {

	static Logger logger =  LoggerFactory.getLogger(MyBootApplication.class);
	@Autowired
	CustomerDAO custDAO;

	public void run(String... args) throws Exception {
		logger.debug("Demo4 - run() Starts");
		logger.info("Demo4 - run() Starts");
		logger.warn("Demo4 - run() Starts");
		
		//1. Customer By City-JPAQL
		List<Customer>mylist1 = custDAO.getCustomersByCity1("Blore");
		for(Customer mycust : mylist1) {
			System.out.println(mycust);
		}
		
		logger.info("  --------------------------");
		//2. Customer By City-Native-QL
		mylist1 = custDAO.getCustomersByCity2("Blore");
		for(Customer mycust : mylist1) {
			System.out.println(mycust);
		}
		
		logger.info("  ----------------------------");
		
		//3. Customer By City3-Named-JPA-QL
		mylist1 = custDAO.getCustomersByCity3("Blore");
		for(Customer mycust : mylist1) {
			System.out.println(mycust);
		}
		
		logger.info("  ----------------------------");
		
		//4. Customer By City4-Named-Native-QL
		mylist1 = custDAO.getCustomersByCity4("Blore");
		for(Customer mycust : mylist1) {
			System.out.println(mycust);
		}
		
		logger.info("  ----------------------------");
		
		//5. Customer By City4-Criteria Queries
		mylist1 =  custDAO.getCustomersByCity("Blore");
		for(Customer mycust : mylist1) {
			System.out.println(mycust);
		}
		
		logger.info("  ----------------------------");
		
		//6. Customer By Email-Criteria Queries
		mylist1 =  custDAO.getCustomersByEmail("hello@hwlmsp.com");
		for(Customer mycust : mylist1) {
			System.out.println(mycust);
		}
		
		logger.info("  ----------------------------");
		
		//7. Customer By City and Email-Criteria Queries
		mylist1 =  custDAO.getCustomers("Blore", "hello@hwlmsp.com");
		for(Customer mycust : mylist1) {
			System.out.println(mycust);
		}
		
		System.out.println(" ==== Done ===== ");
		logger.debug("Demo4 - run() ends ");
		logger.info("Demo4 - run() ends ");
		logger.warn("Demo4 - run() ends ");
	}

	public static void main(String[] args) {
		logger.debug("Demo4 - main() Starts");
		logger.info("Demo4 - main() Starts");
		logger.warn("Demo4 - main() Starts");
		
       SpringApplication.run(MyBootApplication.class, args);
       
       logger.debug("Demo4 - main() Ends ");
       logger.info("Demo4 - main() Ends");
       logger.warn("Demo4 - main() Ends");
	}
}
