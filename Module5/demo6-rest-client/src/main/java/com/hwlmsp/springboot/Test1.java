package com.hwlmsp.springboot;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Test1 {

	public static void main(String[] args) 
	{
		RestTemplate restTemp = new RestTemplate(); 
		String URL1 = "http://localhost:12345/mycustomer/custId/123"; //Success 
		String URL2 = "http://localhost:12345/mycustomer/custId/12"; //Failure 
		ResponseEntity<Customer> respEntity=null; 
		try { 
			respEntity = restTemp.exchange(URL2, HttpMethod.GET,  HttpEntity.EMPTY,  Customer.class); 
			Customer cust = respEntity.getBody(); 
			System.out.println(cust); 
		}catch(Exception ex) { 
			System.out.println("1."+ respEntity); 
			System.out.println("2."+ ex.getMessage()); 
			System.out.println("3.-----Customer Id Not Found-----"); 
		} 
		System.out.println("Done");
	}

}
