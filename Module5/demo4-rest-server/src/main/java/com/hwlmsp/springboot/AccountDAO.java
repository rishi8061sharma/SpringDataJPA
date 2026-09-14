package com.hwlmsp.springboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, Integer> {

	public List<Account> getAccountsByCity(String city); 
	
	 public List<Account> getAccountsByBcode(String bcode);
	 
}
