package com.hwlmsp.springboot;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired 
	RabbitTemplate rabbitTemplate; 
	
	public void sendMessage(String helloMsg) { 
	System.out.println("HelloService - sendMessage"); 
	
	//rabbitTemplate.convertAndSend("myhello-exchange-3", "myhello", helloMsg); 
	//rabbitTemplate.convertAndSend("myhello-exchange-3", "myhello.key1", helloMsg); 
	rabbitTemplate.convertAndSend("myhello-exchange-3", "myhello.key.1", helloMsg); 
	}
	
}
