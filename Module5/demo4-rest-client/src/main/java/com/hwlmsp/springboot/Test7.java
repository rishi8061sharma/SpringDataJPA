package com.hwlmsp.springboot;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Test7 {

	public static void main(String[] args) {
		RestTemplate restTemp = new RestTemplate(); 
		String URL = "http://localhost:12345/myaccounts/city/Blore"; 
		ResponseEntity<List> respEntity = restTemp.getForEntity(URL, List.class); 
		List<Map<String, String>> accList = respEntity.getBody(); 
		for (Map<String, String> mymap : accList) { 
		System.out.println(mymap); 
		} 
		System.out.println("Done"); 

	}

}
