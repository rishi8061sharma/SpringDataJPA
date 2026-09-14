package com.hwlmsp.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ApplicationContext ctx = new AnnotationConfigApplicationContext(HWLAppConfig.class);
      CustomerDAO custDAO = (CustomerDAO)ctx.getBean("custDAO");
	  Customer cust = new Customer(106, "tusar", "tusar@hwlmsp.com", 99999 , "Blore");
	  custDAO.addCustomer(cust);
	  
	  List<Customer>mylist = custDAO.getAllCustomers();
	  mylist.forEach(myCust -> System.out.println(myCust));
	  System.out.println("============================");  
	  List<Customer>mylist1 = custDAO.getCustomersByCity("Delhi");
	  mylist1.forEach(myCust -> System.out.println(myCust));
	  System.out.println(" ==== Done ===== ");
	  
	}

}
