package com.hwlmsp.springboot;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RestController; 

@RestController
public class AccountController {

	@Autowired 
	AccountService accountService; 

	@PostMapping("/addAccount") 
	public String addAccount(@RequestBody Account acc) { 
		System.out.println("AC-addAccount()"); 
		accountService.addAccount(acc); 
		String msg = "Account Added successfully"; 
		return msg; 
	}

	@GetMapping("/myaccount/{accno}") 
	public Account getAccountByAccno(@PathVariable("accno") int accno) { 
		System.out.println("AC-getAccountByAccno()" + accno); 
		Account acc = accountService.getAccountByAccno(accno); 
		return acc; 
	} 

	@PutMapping("/mydeposit") 
	public void deposit(@RequestBody TxInfo txInfo) { 
		System.out.println("AC-deposit()"); 
		accountService.deposit(txInfo); 
	} 

	@PutMapping("/mywithdraw") 
	public void withdraw(@RequestBody TxInfo txInfo) { 
		System.out.println("AC-withdraw()"); 
		accountService.withdraw(txInfo); 
	} 

	@DeleteMapping("/deleteAccount/{accno}") 
	public String deleteAccount(@PathVariable int accno) { 
		System.out.println("AC-deleteAccount()"); 
		accountService.deleteAccount(accno); 
		String msg = "Account Deleted successfully"; 
		return msg; 
	} 

	@GetMapping("/myaccounts") 
	public List<Account> getAllAccounts() { 
		System.out.println("AC-getAllAccounts()"); 
		List<Account> accList = accountService.getAllAccounts(); 
		return accList; 
	} 

	@GetMapping("/myaccounts/city/{city}") 
	public List<Account> getAccountsByCity(@PathVariable String city) { 
		System.out.println("AC-getAllAccounts()"); 
		List<Account> accList = accountService.getAccountsByCity(city); 
		return accList; 
	} 

	@GetMapping("/myaccounts/bcode/{bcode}") 
	public List<Account> getAccountsByBcode(@PathVariable String bcode) { 
		System.out.println("AC-getAllAccounts()"); 
		List<Account> accList = accountService.getAccountsByBcode(bcode); 
		return accList; 
	}
}
