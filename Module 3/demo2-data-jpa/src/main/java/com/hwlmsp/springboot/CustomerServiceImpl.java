package com.hwlmsp.springboot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO custDAO;
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public Optional<Customer> findCustomerById(int cid) {
		Optional<Customer>  custOpts   =  custDAO.findById(cid);
		return custOpts;
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
	public Optional<Customer> getCustomerById(int cid) {
		Optional<Customer>  custOpts = null;
		try {
			Customer cust  = custDAO.getById(cid);
			//System.out.println(cust);
			cust.getCname();
			custOpts   = Optional.of(cust);
		}catch(Exception e) {
			e.printStackTrace();
			custOpts   = Optional.empty();
		}
		return custOpts;
	}

}
