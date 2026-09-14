package com.hwlmsp.springboot;
import org.springframework.amqp.rabbit.annotation.RabbitListener; 
import org.springframework.stereotype.Service;

@Service 
public class OrderService { 
 
 @RabbitListener(queues = "myorder.queue-1") 
 public void onOrderPlaced1(Order myorder) { 
 System.out.println("OrderService --onOrderPlaced for Queue1"); 
 System.out.println("------------------------- "); 
 System.out.println("Order Info: "+myorder); 
 System.out.println("------------------------- "); 
 } 
 
 @RabbitListener(queues = "myorder.queue-2") 
 public void onOrderPlaced2(Order myorder) { 
 System.out.println("OrderService --onOrderPlaced for Queue2"); 
 System.out.println("------------------------- "); 
 System.out.println("Order Info: "+myorder); 
 System.out.println("------------------------- "); 
 } 
} 
