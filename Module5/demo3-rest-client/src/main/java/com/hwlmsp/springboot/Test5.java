package com.hwlmsp.springboot;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Test5 {

	public static void main(String[] args) {

		RestTemplate restTemp = new RestTemplate(); 

		String URL="http://localhost:12345/myhello1";
		
		Hello reqBody = new Hello(0, "Ravi Thapa", null);

		//ResponseEntity = ResponseHeaders + ResponseBody
		ResponseEntity<Hello> respEntity = restTemp.postForEntity(URL, reqBody,  Hello.class); 

		int statusCode = respEntity.getStatusCodeValue(); 

		System.out.println(statusCode); 

		if(statusCode ==200) { 
			//Success 
			//Access Response Headers 
			HttpHeaders respHeaders = respEntity.getHeaders(); 

			System.out.println(respHeaders); 

			String contentType = respHeaders.getContentType().toString(); 

			System.out.println(contentType); 

			//Access Response Body 
			Hello hello = (Hello) respEntity.getBody(); 

			System.out.println(hello); 

		}
		else { 

			//Failure 
			System.out.println(respEntity.getStatusCode()); 

		}

	}

}
