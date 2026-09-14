package com.hwlmsp.springboot;

import java.util.Collections; 
import org.springframework.http.HttpEntity; 
import org.springframework.http.HttpHeaders; 
import org.springframework.http.HttpMethod; 
import org.springframework.http.MediaType; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.client.RestTemplate; 

public class Test3 {

	public static void main(String[] args) {

		RestTemplate restTemp = new RestTemplate(); 
		String URL="http://localhost:12345/myhello2"; 
		//Add Request Headers 
		HttpHeaders reqHeaders = new HttpHeaders(); 
		//reqHeaders.setContentType(MediaType.APPLICATION_XML); 
		//reqHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML)); 
		reqHeaders.setContentType(MediaType.APPLICATION_JSON); 
		reqHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); 
		reqHeaders.add("company-ceo", "Nadir Gulzar"); 
		reqHeaders.set("company-name", "HWL"); 
		HttpEntity request = new HttpEntity(reqHeaders); 
		ResponseEntity<Hello> respEntity = restTemp.exchange(URL,HttpMethod.GET, request, 
		Hello.class);
		//Access Response Headers 
		HttpHeaders respHeaders = respEntity.getHeaders(); 
		System.out.println(respHeaders); 
		for( String headerName : respHeaders.keySet()) { 
			System.out.println(headerName+"\t"+respHeaders.get(headerName)); 
		} 
		//Access Response Body 
		Hello hello = (Hello) respEntity.getBody(); 
		System.out.println(hello); 
	} 

}


