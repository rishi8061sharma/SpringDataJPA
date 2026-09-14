package com.hwlmsp.springboot;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.ResponseBody; 

@Controller 
public class HelloController {

	@RequestMapping(value="/myhello", method = RequestMethod.GET) 
	@ResponseBody 
	public String getMessage1() { 
		System.out.println("HelloController - getMessage1()"); 
		String msg = "Hello , I am getMessage1"; 
		return msg; 
	}

	@RequestMapping(value="/myhello/{name}", method = RequestMethod.GET) 
	@ResponseBody 
	public String getMessage2(@PathVariable String name) { 
		System.out.println("HelloController - getMessage2()"); 
		String msg = "Hello "+name+" !!! - I am getMessage2"; 
		return msg; 
	}

	@RequestMapping(value="/myhello/name/{name}",method = 
			RequestMethod.GET,produces = {"application/json"}) 
	@ResponseBody 
	public Hello getMessage3(@PathVariable String name) { 
		System.out.println("HelloController - getMessage3()"); 
		Hello hello =new Hello(101,name, "I am getMessage3" ); 
		return hello; 
	}

	@RequestMapping(value="/myhello/name/{name}/message/{msg}", 
			method = RequestMethod.GET,produces = {"application/xml"}) 
	@ResponseBody 
	public Hello getMessage4(@PathVariable String name,@PathVariable String msg) { 
		System.out.println("HelloController - getMessage4()"); 
		Hello hello =new Hello(109,name, msg); 
		return hello; 
	}

	@RequestMapping(value="/myhello1/name/{name}", 
			method = RequestMethod.GET, produces = {"application/xml","application/json"}) 
	@ResponseBody 
	public Hello getMessage5(@PathVariable String name) { 
		System.out.println("HelloController - getMessage5()"); 
		Hello hello =new Hello(12345,name, "I am getMessage5"); 
		return hello; 
	}

	@RequestMapping(value="/myhello1", method = RequestMethod.GET) 
	@ResponseBody 
	public Hello getMessage6(@RequestParam(required = false) String name) { 
		System.out.println("HelloController - getMessage6()"); 
		Hello hello =new Hello(12345,name, "I am getMessage6"); 
		return hello; 
	} 
}
