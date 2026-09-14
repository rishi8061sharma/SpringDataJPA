package com.hwlmsp.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyBootApplication extends SpringBootServletInitializer
{ 
	 public static void main(String[] args) { 
	 SpringApplication.run(MyBootApplication.class, args); 
	 } 
	 @Override 
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { 
	 return builder.sources(MyBootApplication.class); 
	 } 
	
} 
