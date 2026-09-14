package com.hwlmsp.springboot;

import org.springframework.web.client.RestTemplate;

public class Test4 {

	public static void main(String[] args) {
		
		RestTemplate restTemp = new RestTemplate();
		
		String URL="http://localhost:12345/myhello1"; 
		
		Hello reqBody = new Hello(0,  "Nazeer",  null);
		Hello hello = restTemp.postForObject( URL,  reqBody, Hello.class); 
		
		System.out.println(hello); 
	}

}
