package com.hwlmsp.springboot;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerDAO extends JpaRepository<Customer, Integer> {	
	@Query(value = "from Customer cust where city=?1") 
	List<Customer> findCustomersByCity(String city, Sort sort); 
	
	@Query(value = "from Customer cust") 
	List<Customer> getAllCustomers(Sort sort); 
	
	@Query(value = "from Customer cust where city=?1") 
	List<Customer> findCustomersByCity(String city, Pageable pageable); 
	
	@Query(value = "from Customer cust") 
	List<Customer> getAllCustomers(Pageable pageable); 
	
/*	@Query(value = "from Customer cust") 
	List<Customer> getAllCustomers(Pageable pageable, Sort sort); */
}
