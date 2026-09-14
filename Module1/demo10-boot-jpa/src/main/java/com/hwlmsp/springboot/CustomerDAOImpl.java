package com.hwlmsp.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {
    
	@PersistenceContext
	EntityManager entityManager;
    
	@Override
	public void addCustomer(Customer cust) {
		// TODO Auto-generated method stub
	     entityManager.persist(cust);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
	    String jpaQL = "from Customer cust";
		List<Customer>mylist = entityManager.createQuery(jpaQL, Customer.class)
                               .getResultList();
		return mylist;
	}

	@Override
	public List<Customer> getCustomersByCity(String city) {
		// TODO Auto-generated method stub
		String jpaQL = " from Customer cust where cust.city = ?1";
		List<Customer>mylist = entityManager.createQuery(jpaQL, Customer.class)
				               .setParameter(1, city)
				               .getResultList();
		return mylist;
	}

}
