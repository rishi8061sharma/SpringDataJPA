package com.hwlmsp.spring;

import java.util.List;
import java.util.Map;

public interface CustomerDAO {

	public void addCustomer(Customer cust);
	public void addCustomer(Map<String, Object>map);
	public List<Customer> getAllCustomers();
	public List<Customer>getCustomersByCity(String city);
	public String getCustomerEmailByPhone(int phone);
}
