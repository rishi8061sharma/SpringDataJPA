package com.hwlmsp.springboot; 
import org.springframework.amqp.rabbit.core.RabbitTemplate; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
/* 
 * @Author : Rishi Sharma
 * @company : HWL Advanced Technology Private Limited
 * */ 
@Service 
public class BookStoreService { 
	@Autowired 
	private RabbitTemplate rabbitTemplate;
	public void placeOrder(Order order) { 
		System.out.println("BookStoreService - placeOrder()"); 
		rabbitTemplate.convertAndSend("myorder.exchange","myorder.key", order); 
	} 
}