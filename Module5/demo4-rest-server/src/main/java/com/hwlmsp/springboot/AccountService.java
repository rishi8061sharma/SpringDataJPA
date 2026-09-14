package com.hwlmsp.springboot;

import java.util.List;

public interface AccountService {
        
	 public void deposit(TxInfo txInfo); 
	 public void withdraw(TxInfo txInfo); 
	 public void deleteAccount(int accno); 
	 public void addAccount(Account acc); 
	 public Account getAccountByAccno(int accno); 
	 public List<Account> getAllAccounts();
	 public List<Account> getAccountsByCity(String city); 
	 public List<Account> getAccountsByBcode(String bcode);
}
