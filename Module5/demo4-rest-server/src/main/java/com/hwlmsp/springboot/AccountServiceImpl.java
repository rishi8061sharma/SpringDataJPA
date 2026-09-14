package com.hwlmsp.springboot;

import java.util.List;
import java.util.List; 
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 

@Service 
@Transactional 
public class AccountServiceImpl implements AccountService { 
	@Autowired 
	AccountDAO accountDAO; 
	
	@Override 
	public void addAccount(Account acc) { 
		System.out.println("ADAO-addAccount()"); 
		accountDAO.save(acc); 
	} 
	
	@Override 
	public Account getAccountByAccno(int accno) { 
		System.out.println("ADAO-getAccountByAccno()"); 
		Optional<Account> opt=accountDAO.findById(accno); 
		Account acc=null; 
		if(opt.isPresent()) { 
			acc=opt.get(); 
		} 
		return acc; 
	} 
	
	@Override 
	public void deposit(TxInfo txInfo) { 
		System.out.println("ADAO-deposit()"); 
		Optional<Account> opt=accountDAO.findById(txInfo.getAccno()); 
		if(opt.isPresent()) { 
			Account acc=opt.get(); 
			double updatedBal=acc.getBalance()+txInfo.getAmount(); 
			acc.setBalance(updatedBal); 
			accountDAO.save(acc); 
		} 
	} 
	
	@Override 
	public void withdraw(TxInfo txInfo) { 
		System.out.println("ADAO-withdraw()"); 
		Optional<Account> opt=accountDAO.findById(txInfo.getAccno()); 
		if(opt.isPresent()) { 
			Account acc=opt.get(); 
			double updatedBal=acc.getBalance()-txInfo.getAmount(); 
			acc.setBalance(updatedBal); 
			accountDAO.save(acc); 
		} 
	} 
	
	@Override 
	public void deleteAccount(int accno) { 
		System.out.println("ADAO-deleteAccount()"); 
		accountDAO.deleteById(accno); 
	} 
	
	@Override 
	public List<Account> getAllAccounts() { 
		System.out.println("ADAO-getAllAccounts()"); 
		return accountDAO.findAll(); 
	}

	@Override 
	public List<Account> getAccountsByCity(String city) { 
	System.out.println("ADAO-getAccountsByCity()"); 
	return accountDAO.getAccountsByCity(city); 
	} 

	@Override 
	public List<Account> getAccountsByBcode(String bcode) { 
	System.out.println("ADAO-getAccountsByBcode()"); 
	return accountDAO.getAccountsByBcode(bcode); 
	}
	
}