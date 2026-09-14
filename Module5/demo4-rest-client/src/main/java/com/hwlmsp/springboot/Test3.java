package com.hwlmsp.springboot;

import org.springframework.web.client.RestTemplate;

public class Test3 {

	public static void main(String[] args) {
		RestTemplate restTemp=new RestTemplate(); 
		String URL="http://localhost:12345/mydeposit"; 
		TxInfo txInfo=new TxInfo(101, 5000); 
		restTemp.put(URL,txInfo) ; 
		System.out.println("Done"); 

	}

}
