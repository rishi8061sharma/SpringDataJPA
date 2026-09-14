package com.hwlmsp.springboot;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class HelloController {

	@GetMapping(value = "/myhello") 
	public String getMessage1() { 
		System.out.println("HelloController - getMessage1()"); 
		String msg = "Hello , I am getMessage1"; 
		return msg; 
	}
	
	@GetMapping(value = "/myhello/{name}") 
	public String getMessage2(@PathVariable String name) { 
		System.out.println("HelloController - getMessage2()"); 
		String msg = "Hello " + name + " !!! - I am getMessage2"; 
		return msg; 
	} 
	
	@GetMapping(value = "/myhello/name/{name}", produces = { "application/json" }) 
	public Hello getMessage3(@PathVariable String name) { 
		System.out.println("HelloController - getMessage3()"); 
		Hello hello = new Hello(101, name, "I am getMessage3"); 
		return hello; 
	} 

	@GetMapping(value = "/myhello/name/{name}/message/{msg}", produces = 
		{"application/xml" }) 
	public Hello getMessage4(@PathVariable String name, @PathVariable String msg) { 
		System.out.println("HelloController - getMessage4()"); 
		Hello hello = new Hello(109, name, msg); 
		return hello; 
	}
	
	@GetMapping(value = "/myhello1/name/{name}", 
			produces = { "application/xml", "application/json" }) 
	public Hello getMessage5(@PathVariable String name) { 
		System.out.println("HelloController - getMessage5()"); 
		Hello hello = new Hello(12345, name, "I am getMessage5"); 
		return hello; 
	}
	
	@GetMapping(value = "/myhello1") 
	public Hello getMessage6(@RequestParam(required = false) String name) { 
		System.out.println("HelloController - getMessage6()"); 
		Hello hello = new Hello(12345, name, "I am getMessage6"); 
		return hello; 
	}
	
}
