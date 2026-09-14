package com.hwlmsp.springboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
	List<Customer> getCustomersByCname(String cname); 
	 List<Customer> getCustomersByEmail(String email); 
	 List<Customer> readCustomersByPhone(int phone); 
	 List<Customer> findCustomersByCity(String city); 
	 
	 List<Customer> getCustomersByEmailAndPhone(String email, int phone); 
	 List<Customer> getCustomersByEmailOrPhone(String email, int phone); 
	 
	 List<Customer> getCustomersByCnameLike(String cname); 
	 List<Customer> getCustomersByCnameStartsWith(String cname); 
	 List<Customer> getCustomersByEmailEndsWith(String email); 
	 List<Customer> getCustomersByCnameContains(String email); 
	 
	 List<Customer> getCustomersByCityIn(String... cities); 
	 List<Customer> getCustomersByCityNotIn(String... cities); 
	 long countCustomersByCity(String city); 
	 long countCustomersByCityIn(String... cities); 
	 long countCustomersByCityNotIn(String... cities); 
	 long countCustomersByCnameLike(String cname); 
	 long countCustomersByEmailNull(); 
	 long countCustomersByEmailNotNull(); 
	 List<Customer> getCustomersByEmailNull(); 
	 List<Customer> getCustomersByEmailNotNull(); 
	 List<Customer> getCustomersByBalance(double bal); 
	 List<Customer> getCustomersByBalanceIsBetween(double bal1, double bal2); 
	 List<Customer> getCustomersByBalanceIsGreaterThan(double bal); 
	 
	 List<Customer> getCustomersByBalanceLessThan(double bal); 
	 List<Customer> getCustomersByBalanceGreaterThanEqual(double bal); 
	 List<Customer> getCustomersByBalanceLessThanEqual(double bal); 

}
