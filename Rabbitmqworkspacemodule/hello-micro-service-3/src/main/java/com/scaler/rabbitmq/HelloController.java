package com.scaler.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;


	@GetMapping(value="/myhello/{name}")
	 public String getMessage(@PathVariable String name) {
	 System.out.println("HelloController - getMessage()");

	 String msg = "Hello "+name+" - Welcome to JLC ";
	 helloService.sendMessage(msg);
	 return msg;
	 }
}
