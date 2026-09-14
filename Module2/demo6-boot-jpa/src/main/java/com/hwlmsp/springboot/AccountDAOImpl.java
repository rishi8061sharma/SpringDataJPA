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
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Repository
@Transactional
public class AccountDAOImpl implements AccountDAO {
    
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	PlatformTransactionManager txManager;

	@Override
	public double getBalance(int accno) {
		System.out.println(txManager.getClass());
		Account accountObj =  entityManager.find(Account.class, accno);
		double bal = 0.0;
		if(accountObj != null) {
		   bal = accountObj.getBalance();
		}else {
		  throw new InvalidAccountNumberException();	
		}
		return bal;
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED, 
	propagation = Propagation.REQUIRED)
	public void deposit(int accno, double amount) {
		    //Operation Starts
			Account account =  entityManager.find(Account.class, accno);
		    if(account != null) {
			   account.setBalance(account.getBalance()+amount);
			   entityManager.merge(account);
			}else {
			  throw new InvalidAccountNumberException();	
			}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, 
	propagation = Propagation.REQUIRED)
	public void withdraw(int accno, double amount) {
		    //Operation Starts
			Account account =  entityManager.find(Account.class, accno);
		    if(account != null) {
		       double currBal = account.getBalance();
		       if(currBal >= amount+5000){
		    	   account.setBalance(currBal-amount);
				   entityManager.merge(account);	   
		       }else{
		    	   throw new InsufficientFundsException();
		       }
			}else {
			  throw new InvalidAccountNumberException();	
			}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, 
			propagation = Propagation.REQUIRED)
	public void fundsTransfer(int saccno, int daccno, double amount) {
	        System.out.println(getBalance(daccno));
			deposit(daccno, amount);
			System.out.println(getBalance(daccno));
			withdraw(saccno, amount);
	}
 
  
}
