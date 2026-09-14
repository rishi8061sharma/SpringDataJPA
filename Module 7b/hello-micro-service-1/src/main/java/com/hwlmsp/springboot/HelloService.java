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
	rabbitTemplate.convertAndSend("myhello-exchange-1", "myhello.key.2", helloMsg); 
	}
	
}
