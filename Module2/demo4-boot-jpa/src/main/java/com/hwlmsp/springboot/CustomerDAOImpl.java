package com.hwlmsp.springboot;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {
    
	@PersistenceContext
	EntityManager entityManager;
 
    public List<Customer> getCustomersByCity1(String city){
    	String JPAQL = "from Customer cust where cust.city=:mycity";
    	List<Customer> myList =
    	 entityManager
    			.createQuery(JPAQL, Customer.class)
    	        .setParameter("mycity", city)
    	        .setFirstResult(0)
    	        .setMaxResults(3)
    	        .getResultList();
    	return myList;
    }
    
    public List<Customer> getCustomersByCity2(String city){
    	String SQL = "select * from mycustomers cust where cust.city=:mycity";
    	List<Customer> myList =
    							entityManager
				    			.createNativeQuery(SQL, Customer.class)
				    	        .setParameter("mycity", city)
				    	        .setFirstResult(0)
				    	        .setMaxResults(3)
				    	        .getResultList();
      return myList;
    }
    
	    public List<Customer> getCustomersByCity3(String city){
	    	return entityManager.createNamedQuery("customerByCity-A")
    	                        .setParameter("mycity", city)
	    	                    .getResultList();
	    }

		@Override
		public List<Customer> getCustomersByCity4(String city) {
			// TODO Auto-generated method stub
			return entityManager.createNamedQuery("customerByCity-B")
					               .setParameter(1, city)
					               .getResultList();
		}

		@Override
		public List<Customer> getCustomersByCity(String myCity) {
			// TODO Auto-generated method stub
			CriteriaBuilder cbuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Customer> mycriteria = cbuilder.createQuery(Customer.class);
			Root<Customer> myroot = mycriteria.from(Customer.class);
			Predicate cityPredicate = cbuilder.equal(myroot.get("city"), myCity);
			mycriteria.where(cityPredicate);
			return entityManager.createQuery(mycriteria)
					            .setFirstResult(0)
					            .setMaxResults(3)
					            .getResultList();
		}

		@Override
		public List<Customer> getCustomersByEmail(String myEmail) {
			// TODO Auto-generated method stub
			CriteriaBuilder cbuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Customer> mycriteria = cbuilder.createQuery(Customer.class);
			Root<Customer> myroot = mycriteria.from(Customer.class);
			Predicate emailPredicate = cbuilder.equal(myroot.get("email"), myEmail);
			mycriteria.where(emailPredicate);
			return entityManager.createQuery(mycriteria)
					            .setFirstResult(0)
					            .setMaxResults(3)
					            .getResultList();
		}

		@Override
		public List<Customer> getCustomers(String myCity, String myEmail) {
			// TODO Auto-generated method stub
			CriteriaBuilder cbuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Customer> mycriteria = cbuilder.createQuery(Customer.class);
			Root<Customer> myroot = mycriteria.from(Customer.class);
			Predicate cityPredicate = cbuilder.equal(myroot.get("city"), myCity);
			Predicate emailPredicate = cbuilder.equal(myroot.get("email"), myEmail);
			mycriteria.where(cityPredicate, emailPredicate);
			return entityManager.createQuery(mycriteria)
					           // .setFirstResult(0)
					            //.setMaxResults(3)
					            .getResultList();
		}
	
}
