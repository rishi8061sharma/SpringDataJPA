package com.hwlmsp.springboot;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public void updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
      entityManager.merge(cust);
	}

	@Override
	public void deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		// not used getReference
    Customer cust = entityManager.find(Customer.class, cid);
    if(cust != null)
	   entityManager.remove(cust);	
	}

	@Override
	public Customer getCustomersByCid(int cid) {
		// TODO Auto-generated method stub
		// getReference throwing Exception when id is not available
	//Customer cust = entityManager.getReference(Customer.class, cid);
	//System.out.println("  In CustomerDAOImpl: "+cust);
	Customer cust = entityManager.find(Customer.class, cid);
	return cust;
	
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		String JPAQL = "from Customer cust";
		Query query = entityManager.createQuery(JPAQL, Customer.class);
		List<Customer>mylist = query.getResultList(); 
		return mylist;
	}

	@Override
	public List<Customer> getAllCustomersByCity(String city) {
		// TODO Auto-generated method stub
		String JPAQL = "from Customer cust where cust.city = ?1";
		Query query = entityManager.createQuery(JPAQL, Customer.class);
		query = query.setParameter(1, city);
		List<Customer>mylist = query.getResultList(); 
		return mylist;
	}

	@Override
	public List<Customer> getAllCustomersByCity1(String city) {
		// TODO Auto-generated method stub
		String JPAQL = "from Customer cust where cust.city = ?1";
		return entityManager.createQuery(JPAQL, Customer.class)
				             .setParameter(1, city).getResultList();
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		String JPAQL = "from Customer cust where cust.email = ?1";
		return entityManager.createQuery(JPAQL, Customer.class)
				             .setParameter(1, email).getSingleResult();
	}

	@Override
	public List<Customer> getCustomersByPhone(int phone) {
		// TODO Auto-generated method stub
	String JPAQL = "from Customer cust where cust.phone = ?1";
	return entityManager.createQuery(JPAQL, Customer.class)
			             .setParameter(1, phone).getResultList();
	}

	@Override
	public List<Customer> getCustomersByEmailAndPhone(String email, int phone) {
		// TODO Auto-generated method stub
		String JPAQL = "from Customer cust where cust.email = ?1 and cust.phone = ?2";
		return entityManager.createQuery(JPAQL, Customer.class)
				             .setParameter(1, email)
				             .setParameter(2, phone).getResultList();
	}

	@Override
	public List<Customer> getCustomersByEmailOrPhone(String email, int phone) {
		// TODO Auto-generated method stub
		String JPAQL = "from Customer cust where cust.email = ?1 or cust.phone = ?2";
		return entityManager.createQuery(JPAQL, Customer.class)
				             .setParameter(1, email)
				             .setParameter(2, phone).getResultList();
	}

	@Override
	public List<Customer> getAllCustomers1() {
		// TODO Auto-generated method stub
		String SQL = "select * from mycustomers"; 
		return entityManager.createNativeQuery(SQL, Customer.class)
				            .getResultList();
	}

	@Override
	public BigInteger getCustomersCount() {
		// TODO Auto-generated method stub
		String SQL = "select count(*) from mycustomers"; 
		return (BigInteger) entityManager.createNativeQuery(SQL)
				.getSingleResult();
	}

	@Override
	public BigInteger getCustomersCountByCity(String city) {
		// TODO Auto-generated method stub
		String SQL = "select count(*) from mycustomers cust where cust.city = ?1"; 
		return (BigInteger) entityManager.createNativeQuery(SQL)
				.setParameter(1, city)
				.getSingleResult();
	}

	@Override
	public int getCustomerPhoneByEmail(String email) {
		// TODO Auto-generated method stub
		String SQL = "select phone from mycustomers cust where cust.email = ?1"; 
		return (Integer)entityManager.createNativeQuery(SQL)
				.setParameter(1, email)
				.getSingleResult();
	}

	@Override
	public String getCustomerCityByEmail(String email) {
		// TODO Auto-generated method stub
		String SQL = "select city from mycustomers cust where cust.email = ?1"; 
		return (String)entityManager.createNativeQuery(SQL)
				.setParameter(1, email)
				.getSingleResult();
	}

	@Override
	public List<Customer> getCustomers(String city, String email, int phone) {
		// TODO Auto-generated method stub
		String JPAQL = "from Customer cust where cust.city = ?1 and cust.email = ?2 and cust.phone = ?3";
		return entityManager.createQuery(JPAQL, Customer.class)
						     .setParameter(1, city)
				             .setParameter(2, email)
				             .setParameter(3, phone)
				             .getResultList();
	}

	public Map<String, Integer> getCustomersInfo(String city){
		String SQL = "select email, phone from mycustomers cust where cust.city = ?1";
		List myList = entityManager.createNativeQuery(SQL)
						     .setParameter(1, city)
				             .getResultList();
		Map<String, Integer> mymap = new HashMap<String, Integer>();
		
		System.out.println(myList.size());
		for(Object obj : myList) {
			Object myobj[] = (Object[]) obj;
			//System.out.println(myobj[0]+"\t"+myobj[1]);
			mymap.put((String)myobj[0],(Integer)myobj[1]);
		}
		return mymap;
	}
	
	
	}
