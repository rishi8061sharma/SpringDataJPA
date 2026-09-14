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
	AccountDAO accountDAO;

	public void run(String... args) throws Exception {
		logger.debug("Demo5 - run() Starts");
		logger.info("Demo5 - run() Starts");
		logger.warn("Demo5 - run() Starts");
		
		/*System.out.println(accountDAO.getBalance(101));
		System.out.println(accountDAO.getBalance(102));
		System.out.println(accountDAO.getBalance(103));
		System.out.println("  -------------------------  ");
		System.out.println(accountDAO.getBalance(101));
		accountDAO.deposit(101, 5000);
		System.out.println(accountDAO.getBalance(101));
		accountDAO.withdraw(101, 5000);
		System.out.println(accountDAO.getBalance(101));*/
		try {
		System.out.println(accountDAO.getBalance(103));
		System.out.println(accountDAO.getBalance(101));
		accountDAO.fundsTransfer(103, 101, 15500 );
		System.out.println(accountDAO.getBalance(101));
		System.out.println(accountDAO.getBalance(103));
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(" ==== Done ===== ");
		logger.debug("Demo5 - run() ends ");
		logger.info("Demo5 - run() ends ");
		logger.warn("Demo5 - run() ends ");
	}

	public static void main(String[] args) {
		logger.debug("Demo5 - main() Starts");
		logger.info("Demo5 - main() Starts");
		logger.warn("Demo5 - main() Starts");
		
       SpringApplication.run(MyBootApplication.class, args);
       
       logger.debug("Demo5 - main() Ends ");
       logger.info("Demo5 - main() Ends");
       logger.warn("Demo5 - main() Ends");
	}
}
