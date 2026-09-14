package com.scaler.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScalerAppConfig {

	@Bean(name="myHelloExchange")
	Exchange createHelloExchange(){
		return ExchangeBuilder.topicExchange("myhello-exchange-3").build();
	}

	@Bean(name="myHelloQueue1")
	Queue createHelloQueue1(){
		return QueueBuilder.durable("myhello-queue-1").build();
	}

	@Bean
	Binding helloBinding1(Queue myHelloQueue1, TopicExchange myHelloExchange){
		return BindingBuilder.bind(myHelloQueue1)
				.to(myHelloExchange)
				.with("myhello.*");
	}



	@Bean(name="myHelloQueue2")
	Queue createHelloQueue2(){
		return QueueBuilder.durable("myhello-queue-2").build();
	}

	@Bean
	Binding helloBinding2(Queue myHelloQueue2, TopicExchange myHelloExchange){
		return BindingBuilder.bind(myHelloQueue2)
				.to(myHelloExchange)
				.with("myhello.#");
	}

	@Bean(name="myHelloQueue3")
	Queue createHelloQueue3(){
		return QueueBuilder.durable("myhello-queue-3").build();
	}

	@Bean
	Binding helloBinding3(Queue myHelloQueue3, TopicExchange myHelloExchange){
		return BindingBuilder.bind(myHelloQueue3)
				.to(myHelloExchange)
				.with("myhello.key.*");
	}

}
