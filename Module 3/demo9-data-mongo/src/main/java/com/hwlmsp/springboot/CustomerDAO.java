package com.hwlmsp.springboot;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends MongoRepository<Customer, String> {

	@Query("{'city' : ?0}") 
	List<Customer> fetchCustomersByCity(String city, Sort sort); 
	
	@Query("{'city' : ?0}") 
	List<Customer> fetchCustomersByCity(String city, Pageable pageable); 
	
}
