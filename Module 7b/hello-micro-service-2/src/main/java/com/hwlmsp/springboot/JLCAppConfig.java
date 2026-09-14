package com.hwlmsp.springboot;

import org.springframework.amqp.core.Binding; 
import org.springframework.amqp.core.BindingBuilder; 
import org.springframework.amqp.core.DirectExchange; 
import org.springframework.amqp.core.Exchange; 
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue; 
import org.springframework.amqp.core.QueueBuilder; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JLCAppConfig {
	
	@Bean(name = "myHelloExchange") 
	 Exchange createHelloExchange() { 
	 return ExchangeBuilder.fanoutExchange("myhello-exchange-2").build(); 
	 }
	
	@Bean(name = "myHelloQueue1") 
	 Queue createHelloQueue1() { 
	 return QueueBuilder.durable("myhello-queue-1").build(); 
	 } 
	 
	 @Bean(name = "myHelloQueue2") 
	 Queue createHelloQueue2() { 
	 return QueueBuilder.durable("myhello-queue-2").build(); 
	 } 
	 
	 @Bean(name = "myHelloQueue3") 
	 Queue createHelloQueue3() { 
	 return QueueBuilder.durable("myhello-queue-3").build(); 
	 } 
	 
	 @Bean 
	 Binding helloBinding1(Queue myHelloQueue1, FanoutExchange myHelloExchange) { 
	 return BindingBuilder.bind(myHelloQueue1) 
	 .to(myHelloExchange);
	 } 
	 
	 @Bean 
	 Binding helloBinding2(Queue myHelloQueue2, FanoutExchange myHelloExchange) { 
	 return BindingBuilder.bind(myHelloQueue2) 
	 .to(myHelloExchange) ;
	 } 
	 
	 @Bean 
	 Binding helloBinding3(Queue myHelloQueue3, FanoutExchange myHelloExchange) { 
	 return BindingBuilder.bind(myHelloQueue3) 
	 .to(myHelloExchange);
	 } 

}
