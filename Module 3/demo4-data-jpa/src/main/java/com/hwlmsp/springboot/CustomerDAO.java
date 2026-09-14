package com.hwlmsp.springboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
	@Query(value = "from Customer cust where email=?1 and phone=?2") 
	List<Customer> getCustomersNyEmailAndPhone1(String email, int phone); 
	@Query(value = "select * from mycustomers cust where email=?1 and phone=?2", 
	nativeQuery = true) 
	List<Customer> getCustomersNyEmailAndPhone2(String email, int phone); 
	@Query(value = "from Customer cust where email=?1 or phone=?2") 
	List<Customer> getCustomersNyEmailOrPhone1(String email, int phone); 
	@Query(value = "select * from mycustomers cust where email=?1 or phone=?2", 
	nativeQuery = true) 
	List<Customer> getCustomersNyEmailOrPhone2(String email, int phone); 
	@Query(value = "from Customer cust where city=?1 order by cname desc") 
	List<Customer> findCustomersByCity1(String city); 
	@Query(value = "select * from myustomers cust where city=?1 order by cname desc", 
	nativeQuery = true) 
	List<Customer> findCustomersByCity2(String city); 
	@Query(value = "from Customer cust order by cname asc") 
	List<Customer> findAllCustomers1(); 
	@Query(value = "select * from myustomers cust order by cname asc", nativeQuery = true) 
	List<Customer> findAllCustomers2(); 
	@Query(value = "from Customer cust where cust.phone = :myphone") 
	List<Customer> findCustomersByPhone1(@Param("myphone") long phone); 
	@Query(value = "select * from customers where cust.phone = :myphone", nativeQuery 
	= true) 
	List<Customer> findCustomersByPhone2(@Param("myphone") long phone);
}
