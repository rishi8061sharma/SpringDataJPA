package com.hwlmsp.springboot;

import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class Test6 {

	public static void main(String[] args) {
		RestTemplate restTemp = new RestTemplate(); 
		String URL = "http://localhost:12345/myaccounts"; 
		List<Map<String, String>> accList = restTemp.getForObject(URL, List.class); 
		for (Map<String, String> mymap : accList) { 
		System.out.println(mymap); 
		} 
		System.out.println("Done"); 


	}

}
