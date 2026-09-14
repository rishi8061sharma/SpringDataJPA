package com.hwlmsp.springboot;
import java.util.List;


import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO{

	 public void addCustomer(Customer cust);
	 
	 public List<Customer>getAllCustomers();
	 
	
}
