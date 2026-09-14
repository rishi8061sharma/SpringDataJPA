package com.hwlmsp.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    JdbcTemplate jtemp;
	
	@Override
	public void addCustomer(Customer cust) {
		// TODO Auto-generated method stub
		String sql = "insert into mycustomers values(?,?,?,?,?)";
		jtemp.update(sql, cust.getCid(), cust.getCname(), cust.getEmail(), cust.getPhone(), cust.getCity());
    }

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		String SQL = "select * from mycustomers";
		List<Customer>mylist = jtemp.query(SQL, new CustomerRowMapper());
		return mylist;
	}

	@Override
	public List<Customer> getCustomersByCity(String city) {
		// TODO Auto-generated method stub
		String SQL = "select * from mycustomers where city=?";
		List<Customer>mylist = jtemp.query(SQL, new CustomerRowMapper(), city);
		return mylist;
	}

}
