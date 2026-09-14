package com.hwlmsp.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
     NamedParameterJdbcTemplate namedJtemp;
   
	
	@Override
	public void addCustomer(Customer cust) {
		// TODO Auto-generated method stub
		String sql = "insert into mycustomers values(:mycid,:mycname,:myemail,:myphone,:mycity)";
		Map<String, Object> params = new HashMap<>();
		params.put("mycid", cust.getCid());
		params.put("mycname", cust.getCname());
		params.put("myemail", cust.getEmail());
		params.put("myphone", cust.getPhone());
		params.put("mycity", cust.getCity());
		namedJtemp.update(sql, params);
    }

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		String SQL = "select * from mycustomers";
		List<Customer>mylist = namedJtemp.query(SQL, new CustomerRowMapper());
		return mylist;
	}

	@Override
	public List<Customer> getCustomersByCity(String city) {
		// TODO Auto-generated method stub
		String SQL = "select * from mycustomers where city=:mycity";
		Map<String, Object> params = new HashMap<>();
		params.put("mycity", city);
		List<Customer>mylist = namedJtemp.query(SQL,params, new CustomerRowMapper());
		return mylist;
	}

	@Override
	public String getCustomerEmailByPhone(int phone) {
		// TODO Auto-generated method stub
		String SQL = "select email from mycustomers where phone=:myphone";
		Map<String, Object> params = new HashMap<>();
		params.put("myphone", phone);
		String email = namedJtemp.queryForObject(SQL,params, String.class);
		return email;
	}

	@Override
	/*  Input parameter is Map then always go to NamedParameter Jdbc Template
	 * 
	 */
	public void addCustomer(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String sql = "insert into mycustomers values(:mycid,:mycname,:myemail,:myphone,:mycity)";
		namedJtemp.update(sql, map);
		
	}

}
