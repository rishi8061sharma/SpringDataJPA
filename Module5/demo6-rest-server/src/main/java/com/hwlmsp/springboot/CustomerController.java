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
		Customer cust = customerService.getCustomerByCid(custId); 
		return cust; 
	} 

	@GetMapping(value = "/mycustomer/phone/{phone}") 
	public ResponseEntity<Customer> getCustomerByPhone(@PathVariable("phone") long phone) { 
		System.out.println("CC-getCustomerByPhone() - " + phone); 
		Customer cust = customerService.getCustomerByPhone(phone); 
		ResponseEntity<Customer> respEntity = 
				new ResponseEntity<Customer>(cust ,HttpHeaders.EMPTY,HttpStatus.OK); 
		return respEntity; 
	} 

	@GetMapping(value = "/mycustomer/city/{city}") 
	public ResponseEntity<List<Customer>> getCustomersByCity(@PathVariable("city") String city) { 
		System.out.println("CC-getCustomersByCity() - " + city); 
		List<Customer> custList =new ArrayList<>(); 
		custList = customerService.getCustomersByCity(city); 
		ResponseEntity<List<Customer>> respEntity = 
				new ResponseEntity<List<Customer>>(custList ,HttpHeaders.EMPTY,HttpStatus.OK); 
		return respEntity; 
	}

}
