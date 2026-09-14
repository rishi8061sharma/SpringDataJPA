package com.hwlmsp.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyBootApplication  implements CommandLineRunner{

	@Autowired
	ApplicationContext ctx;
	
	
	public static void main(String[] args) {
		 System.out.println(" Boot App - Begin");
		 SpringApplication.run(MyBootApplication.class, args);
		 System.out.println(" Boot App - End");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ctx.getClass());
	}
}
