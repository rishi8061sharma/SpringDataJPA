package com.hwlmsp.springboot;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime; 
import java.util.ArrayList; 
import java.util.List;
import org.springframework.http.HttpHeaders; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RestController; 
import org.springframework.web.server.ResponseStatusException; 

@RestController  
public class CustomerController {

	@Autowired
	CustomerService customerService; 

	@GetMapping("/mycustomer/custId/{custId}") 
	public Customer getCustomerByCid(@PathVariable("custId") int custId) { 
		System.out.println("CC-getCustomerByCid() - " + custId); 
		Customer cust = null; 
		try { 
			cust = customerService.getCustomerByCid(custId); 
		} catch (CustomerIDNotFoundException ex) { 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "My customer ID Not Found", ex); 
			// ResponseStatusException introduced in Spring5 
		} 
		return cust; 
	}


	@GetMapping(value = "/mycustomer/phone/{phone}") 
	public ResponseEntity<?> getCustomerByPhone(@PathVariable("phone") long phone) { 
		System.out.println("CC-getCustomerByPhone() - " + phone); 
		HttpHeaders respHeaders = new HttpHeaders(); 
		Customer cust = null; 
		try { 
			cust = customerService.getCustomerByPhone(phone); 
			respHeaders.add("message", "Phone Number Found"); 
			return new ResponseEntity<>(cust, respHeaders, HttpStatus.OK); 
		} catch (InvalidPhoneNumberException ex) { 
			respHeaders.add("message", "Phone Number Not Found"); 
		} 

		MyErrorMessage errMsg = new MyErrorMessage(); 
		errMsg.setMytimestamp(LocalDateTime.now()); 
		errMsg.setMyerror(" Phone Number Not Found"); 
		errMsg.setMystatus(HttpStatus.FORBIDDEN.value()); 
		return new ResponseEntity<>(errMsg, respHeaders, HttpStatus.FORBIDDEN); 
	}


	@GetMapping(value = "/mycustomer/city/{city}") 
	public ResponseEntity<?> getCustomersByCity(@PathVariable("city") String city) { 
		System.out.println("CC-getCustomersByCity() - " + city); 
		HttpHeaders respHeaders = new HttpHeaders(); 
		List<Customer> custList = new ArrayList<>(); 
		try { 
			custList = customerService.getCustomersByCity(city); 
			respHeaders.add("message", "Customers Found"); 
			return new ResponseEntity<>(custList, respHeaders, HttpStatus.OK); 
		} catch (CityNotFoundException ex) { 
			respHeaders.add("message", "Customers Not Found"); 
		} 
		MyErrorMessage errMsg = new MyErrorMessage(); 
		errMsg.setMytimestamp(LocalDateTime.now()); 
		errMsg.setMyerror(" No Customers with given City"); 
		errMsg.setMystatus(HttpStatus.BAD_REQUEST.value()); 
		return new ResponseEntity<>(errMsg, HttpStatus.BAD_REQUEST); 
	} 


}
