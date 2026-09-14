package com.hwlmsp.springboot;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    HibernateTemplate htemp;
    
	
	@Override
	public void addCustomer(Customer cust) {
		// TODO Auto-generated method stub
	     htemp.save(cust);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer>mylist = htemp.loadAll(Customer.class);
		return mylist;
	}

	@Override
	public List<Customer> getCustomersByCity(String city) {
		// TODO Auto-generated method stub
		/*String HQL = "from Customer cust where cust.city=?";
		List<Customer>mylist = (List<Customer>)htemp.find(HQL, city);
		*/
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc = dc.add(Restrictions.eq("city", city));
		List<Customer>mylist = (List<Customer>)htemp.findByCriteria(dc);
		return mylist;
	}

}
