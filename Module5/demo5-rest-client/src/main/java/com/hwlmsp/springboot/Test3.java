package com.hwlmsp.springboot;
import java.util.List; 
import java.util.Map; 
import org.springframework.http.HttpEntity; 
import org.springframework.http.HttpMethod; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.client.RestTemplate; 

public class Test3 {

	public static void main(String[] args) {
		RestTemplate restTemp = new RestTemplate(); 
		String URL1 = "http://localhost:12345/mycustomer/city/Blore"; // Success 
		String URL2 = "http://localhost:12345/mycustomer/city/Jaipur"; // Failure 
		ResponseEntity<List> respEntity=null; 
		try { 
		respEntity = restTemp.exchange(URL2,HttpMethod.GET, HttpEntity.EMPTY, List.class); 
		List<Map<String,String>> mylist = respEntity.getBody() ; 
		if (!mylist.isEmpty()) { 
		for(Map mymap : mylist) 
		System.out.println(mymap); 
		} 
		}catch(Exception ex) { 
		System.out.println("1."+ respEntity); 
		System.out.println("2."+ ex.getMessage()); 
		System.out.println("3.-----No Customers with Given City-----"); 
		} 
		System.out.println("Done"); 

	}

}
