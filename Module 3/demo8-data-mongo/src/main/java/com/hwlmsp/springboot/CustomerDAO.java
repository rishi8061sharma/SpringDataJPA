package com.hwlmsp.springboot;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends MongoRepository<Customer, String> {

	@Query("{'city': ?0}")
	List<Customer> fetchCustomersByCity(String city); 
	
	@Query("{'city': {$in:?0}}")
	List<Customer> fetchCustomersByCitiesIN(String...myCity); 
	
	@Query("{'city': {$nin:?0}}")
	List<Customer> fetchCustomersByCitiesNIN(String...myCity); 

	@Query("{'phone': ?0}")
	List<Customer> fetchCustomersByPhone(int  phones); 

	@Query("{'balance': ?0}")
	 List<Customer> fetchCustomersByBal(double bal); 
    
	@Query("{'balance': {$gte:?0}}")
	 List<Customer> fetchCustomersByBalGTE(double bal); 
	 
	@Query("{'balance': {$lte:?0}}")
	 List<Customer> fetchCustomersByBalLTE(double bal); 
	
	@Query("{$and : [{'balance': {$gte: ?0}} , {'balance': {$lte: ?1}}]}")
	 List<Customer> fetchCustomersByBalRange(double bal1, double bal2);
	
	// @Query("{'email': ?0, 'phone': ?1}")
	 @Query("{$and : [{'email': ?0}, {'phone': ?1}] }")
	 List<Customer> fetchCustomersByEmailAndPhone1(String email, int phone);

	 @Query("{$or : [{'email': ?0}, {'phone': ?1}] }")
	 List<Customer> fetchCustomersByEmailOrPhone1(String email, int phone); 

	 /*
    
    	

	List<Customer> findAllCustomers1(); 
	
	List<Customer> findCustomersByPhone1(@Param("myphone") long phone); 
	
	List<Customer> findCustomersByPhone2(@Param("myphone") long phone);
	*/
}
