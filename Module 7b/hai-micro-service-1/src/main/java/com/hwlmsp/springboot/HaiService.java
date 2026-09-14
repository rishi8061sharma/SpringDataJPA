package com.hwlmsp.springboot;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HaiService {

	@RabbitListener(queues = "myhello-queue-1") 
	 public void onMessageArrived1(String helloMsg) { 
	 System.out.println("HaiService - onMessageArrived for Queue1"); 
	 System.out.println("-------------------"); 
	 System.out.println("Message : "+ helloMsg); 
	 System.out.println("-------------------"); 
	 }
	
	@RabbitListener(queues = "myhello-queue-2") 
	 public void onMessageArrived2(String helloMsg) { 
	 System.out.println("HaiService - onMessageArrived for Queue2"); 
	 System.out.println("-------------------"); 
	 System.out.println("Message : "+ helloMsg); 
	 System.out.println("-------------------"); 
	 } 
	 
	 @RabbitListener(queues = "myhello-queue-3") 
	 public void onMessageArrived3(String helloMsg) { 
	 System.out.println("HaiService - onMessageArrived for Queue3"); 
	 System.out.println("-------------------"); 
	 System.out.println("Message : "+ helloMsg); 
	 System.out.println("-------------------"); 
	 }
}
