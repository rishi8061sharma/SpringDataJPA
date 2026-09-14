package com.hwlmsp.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public void addCustomer(Customer cust) {
		// TODO Auto-generated method stub
		mongoTemplate.save(cust);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Customer.class);
	}

}
