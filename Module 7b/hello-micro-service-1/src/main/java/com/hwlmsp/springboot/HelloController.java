package com.hwlmsp.springboot;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*; 

@RestController  
public class HelloController {

	@Autowired
	HelloService helloService; 
	
	@GetMapping(value = "/myhello/{name}") 
	public String getMessage(@PathVariable String name) { 
	System.out.println("HelloController - getMessage()"); 
	String msg = "Hello " + name + " - Welcome to JLC !!!"; 
	helloService.sendMessage(msg); 
	return msg; 
	}
	
}
