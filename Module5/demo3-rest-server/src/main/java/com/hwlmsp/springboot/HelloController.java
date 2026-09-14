package com.hwlmsp.springboot;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class HelloController {

	//@GetMapping(value="/myhello1", produces =  {"application/json"})
/*	@GetMapping(value="/myhello1")
	public Hello getMessage1() throws IOException { 
	System.out.println("HelloController - getMessage1() => GET"); 
	Hello hello =new Hello(101,"Rishi Sharma", "I am getMessage1" );
	return hello; 
	} 
*/
	/*
	@GetMapping(value="/myhello1")
	public Hello getMessage1(HttpServletResponse response) throws IOException { 
	System.out.println("HelloController - getMessage1() => GET"); 
	Hello hello =new Hello(101,"Rishi Sharma", "I am getMessage1" );
	response.sendError(905);
	//response.setStatus(905);
	return hello; 
	} 
	*/
	
	@GetMapping(value="/myhello1")
	public Hello getMessage1(HttpServletRequest request) throws IOException { 
	System.out.println("HelloController - getMessage1() => GET"); 
	Hello hello =new Hello(101,"Rishi Sharma", "I am getMessage1" );
	//Reading Request Headers
	Enumeration< String> enms = request.getHeaderNames();
	List<String> headerNames = Collections.list(enms);
	for (String headerName : headerNames) {
		System.out.println(headerName+"\t"+request.getHeader(headerName));
	}
	
	return hello; 
	}	

	@GetMapping(value="/myhello2", produces =  {"application/json"}) 
	public ResponseEntity<Hello> getMessage2(HttpServletRequest request) throws IOException { 
	System.out.println("HelloController - getMessage2() => GET"); 
	//Accessing Request Headers 
	Enumeration<String> enms= request.getHeaderNames(); 
	
	List<String> headerNames = Collections.list(enms); 
	for(String headerName : headerNames) { 
	System.out.println(headerName+"\t"+ request.getHeader(headerName)); 
	} 
	
	//Preparing Response Body 
	Hello respBody = new Hello(109,"Rishi Sharma", "I am getMessage2" ); 
	
	//Preparing Response Headers 
	HttpHeaders respHeaders = new HttpHeaders(); 
	//respHeaders.setContentType(MediaType.APPLICATION_XML); 
	respHeaders.add("my-teamLead", "Tusar Das"); 
	respHeaders.set("my-company", "HWL Advanced Technology Private Limited"); 
	respHeaders.set("my-access-token", "HWL12345"); 
	
	ResponseEntity<Hello> respEntity = 
	new ResponseEntity<Hello>(respBody,respHeaders, HttpStatus.OK); 
	return respEntity; 
	} 
	
	@PostMapping(value="/myhello1") 
	public Hello getMessage1(@RequestBody Hello hello) throws IOException { 
		
		System.out.println("HelloController - getMessage1() => POST"); 
		
		hello.setId(12345); 
		
		hello.setMessage("I am getMessage1() = POST"); 
		
		return hello; 
	} 

	@PostMapping(value="/myhello2") 
	public ResponseEntity<Hello> getMessage2(@RequestBody Hello body , HttpServletRequest request) throws IOException { 
		 System.out.println("HelloController - getMessage2() => POST"); 
		
		 //Accessing Request Headers 
		Enumeration<String> enms= request.getHeaderNames(); 

		List<String> headerNames = Collections.list(enms); 

		for(String headerName : headerNames) { 
			System.out.println(headerName+"\t"+ request.getHeader(headerName)); 
		} 

		//Preparing Response Body 
		body.setId(12345); 
		
		body.setMessage("I am getMessage2() = POST"); 

		//Preparing Response Headers 
		HttpHeaders respHeaders = new HttpHeaders(); 
		//respHeaders.setContentType(MediaType.APPLICATION_XML); 
		respHeaders.add("my-teamLead", "Tusar Das"); 
		respHeaders.set("my-company", "HWL Advanced Technology Private Limited"); 
		respHeaders.set("my-access-token", "HWL12345"); 

		ResponseEntity<Hello> respEntity = 
				new ResponseEntity<Hello>(body, respHeaders, HttpStatus.OK); 

		return respEntity; 

	}

}
