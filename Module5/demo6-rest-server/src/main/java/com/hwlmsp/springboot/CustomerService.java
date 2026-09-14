package com.hwlmsp.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	public Customer getCustomerByCid(int custId) { 
		Customer cust = null; 
		if (custId >= 100) { 
		cust = new Customer(custId, "Rishi Sharma", "rishi@hwlmsp.com", 12345, "Blore"); 
		} else { 
		throw new CustomerIDNotFoundException(); 
		} 
		return cust; 
		} 
	
	public Customer getCustomerByPhone(long phone) { 
		Customer cust = null; 
		if (phone >= 50000) { 
			cust = new Customer(109, "Tusar Das", "tusar.das@hwlmsp.com", phone, "Blore"); 
		} else { 
			throw new InvalidPhoneNumberException(); 
		} 
		return cust; 
	} 

	public List<Customer> getCustomersByCity(String city) { 
		List<Customer> custList = new ArrayList(); 
		if (city.equals("Blore")) { 
		custList.add(new Customer(101, "Rishi", "rishi.sharma@hwlmsp.com", 111, city)); 
		custList.add(new Customer(102, "Tusar", "tusar@hwlmsp.com", 222, city)); 
		custList.add(new Customer(103, "Nazeer", "nazeer@hwlmsp.com", 333, city)); 
		custList.add(new Customer(104, "Rakesh", "rakesh@hwlmsp.com", 444, city)); 
		custList.add(new Customer(105, "Milind", "milind@hwlmsp.com", 555, city)); 
		custList.add(new Customer(106, "Subhani", "subhani@hwlmsp.com", 555, city)); 
		} else { 
		throw new CityNotFoundException(); 
		} 
		return custList; 
		} 
	
}
