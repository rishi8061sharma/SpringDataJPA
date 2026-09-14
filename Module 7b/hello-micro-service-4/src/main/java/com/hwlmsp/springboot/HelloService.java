package com.hwlmsp.springboot;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired 
	RabbitTemplate rabbitTemplate; 
	
	public void sendMessage(String helloMsg) { 
		System.out.println("HelloService - sendMessage()"); 
		MessageProperties messageProps = new MessageProperties(); 
		messageProps.setHeader("myheader", "JLC2"); 
		MessageConverter messageConverter = new SimpleMessageConverter(); 
		Message message = messageConverter.toMessage(helloMsg, messageProps); 
		rabbitTemplate.send("myhello.exchange-4", "" , message); 
	}
	
}
