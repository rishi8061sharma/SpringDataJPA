package com.hwlmsp.springboot;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface CustomerDAO {
    public void addCustomer(Customer cust);
	public void updateCustomer(Customer cust);
	public void deleteCustomer(int cid);
	public Customer getCustomersByCid(int cid);
	
	public List<Customer>getAllCustomers();
	public List<Customer>getAllCustomers1();
	
	public List<Customer>getAllCustomersByCity(String city);
	public List<Customer>getAllCustomersByCity1(String city);
	public Customer getCustomerByEmail(String email);
	public List<Customer> getCustomersByPhone(int phone);
	public List<Customer> getCustomersByEmailAndPhone(String email, int phone);
	public List<Customer> getCustomersByEmailOrPhone(String email, int phone);

	public BigInteger getCustomersCount();
	public BigInteger getCustomersCountByCity(String city);
	
	public int getCustomerPhoneByEmail(String email);
	public String getCustomerCityByEmail(String email);
	
	public List<Customer> getCustomers(String city, String email, int phone);
	
	public Map<String, Integer> getCustomersInfo(String city);
	
}
