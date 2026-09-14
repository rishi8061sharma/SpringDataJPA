package com.hwlmsp.springboot;

import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Test1 {

	public static void main(String[] args) {
		RestTemplate restTemp = new RestTemplate();
		String URL="http://localhost:12345/myhello1"; 
		Hello hello = restTemp.getForObject(URL, Hello.class); 
		System.out.println(hello); 
		/*List<HttpMessageConverter<?>> messageConvertersList = restTemp.getMessageConverters();
		System.out.println("--------Client Side Converters------------"); 
		for (HttpMessageConverter<?> myconverter : messageConvertersList) { 
			System.out.println(myconverter); 
		}*/ 
	}

}
