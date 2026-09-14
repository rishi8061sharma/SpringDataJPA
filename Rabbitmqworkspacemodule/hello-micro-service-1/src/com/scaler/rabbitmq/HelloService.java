package com.scaler.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	RabbitTemplate  rabbitTemplate;

	public void sendMessage(String helloMsg) {
		System.out.println("  HelloService - sendMessage ");
		rabbitTemplate.convertAndSend("myHelloExchange", "myhello.key.1", helloMsg);
	}
}
