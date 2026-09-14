package com.hwlmsp.springboot;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding; 
import org.springframework.amqp.core.BindingBuilder; 
import org.springframework.amqp.core.Exchange; 
import org.springframework.amqp.core.ExchangeBuilder; 
import org.springframework.amqp.core.FanoutExchange; 
import org.springframework.amqp.core.Queue; 
import org.springframework.amqp.core.QueueBuilder; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.context.annotation.Bean; 
/* 
*@Author : Rishi Sharma
 * @company : HWL Advanced Technology Private Limited
* */

@SpringBootApplication
public class JLCAppConfig {
	@Bean
	Queue queue() {
	    return new AnonymousQueue();
	}
	
	@Bean(name="myorderExchange") 
	 Exchange createOrderExchange() { 
	 return ExchangeBuilder.fanoutExchange("myorder.exchange").build(); 
	 } 
	 
	
	@Bean(name="myorderQueue1") 
	 Queue createOrderQueue1() { 
	 return QueueBuilder.durable("myorder.queue-1").build(); 
	 } 
	 
	
	@Bean(name="myorderQueue2") 
	 Queue createOrderQueue2() { 
	 return QueueBuilder.durable("myorder.queue-2").build(); 
	 } 
	 
	@Bean 
	 Binding orderBinding1(Queue myorderQueue1, FanoutExchange myorderExchange) { 
	 return BindingBuilder.bind(myorderQueue1) 
	 .to(myorderExchange); 
	 } 
	 
	 @Bean 
	 Binding orderBinding2(Queue myorderQueue2, FanoutExchange myorderExchange) { 
	 return BindingBuilder.bind(myorderQueue2) 
	 .to(myorderExchange); 
	 } 

}
