package com.hwlmsp.springboot;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface CustomerDAO {
	
	public List<Customer>getCustomersByCity1(String city);
	public List<Customer>getCustomersByCity2(String city);
	public List<Customer>getCustomersByCity3(String city);
	public List<Customer>getCustomersByCity4(String city);
	
	public List<Customer>getCustomersByCity(String city);
	public List<Customer>getCustomersByEmail(String email);
	public List<Customer>getCustomers(String email, String city);
}
