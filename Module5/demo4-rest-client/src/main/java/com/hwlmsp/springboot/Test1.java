package com.hwlmsp.springboot;

import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Test1 {

	public static void main(String[] args) {
		RestTemplate restTemp=new RestTemplate(); 
		String URL="http://localhost:12345/addAccount"; 
		Account acc=new Account("SA","B-99",75000,"Hyd"); 
		String msg=restTemp.postForObject(URL, acc, String.class); 
		System.out.println(msg); 
		System.out.println("Done"); 
	}

}
