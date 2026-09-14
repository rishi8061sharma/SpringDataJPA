package com.hwlmsp.springboot;

import java.util.List; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.http.converter.HttpMessageConverter; 
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; 


@SpringBootApplication 
public class JLCAppConfig implements WebMvcConfigurer{

	@Override 
	public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters) { 
		System.out.println("--------Server Side Converters------------"); 
		for (HttpMessageConverter<?> myconverter : messageConverters) { 
			System.out.println(myconverter); 
		} 
	} 

}
