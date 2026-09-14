package com.hwlmsp.springboot;

import java.util.Optional;

public interface CustomerService {
	public Optional<Customer> findCustomerById(int cid);
	public Optional<Customer> getCustomerById(int cid);

}
