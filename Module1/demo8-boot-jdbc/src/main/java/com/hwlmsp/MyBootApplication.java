package com.hwlmsp;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.hwlmsp.dao.HaiDAO;
import com.hwlmsp.dao.HelloDAO;
import com.hwlmsp.service.HaiService;
import com.hwlmsp.service.HelloService;
import com.hwlmsp.to.Hai;
import com.hwlmsp.to.Hello;

@SpringBootApplication
public class MyBootApplication implements CommandLineRunner {
   
	@Autowired
	ApplicationContext ctx;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jTemp;
	
	@Autowired
	NamedParameterJdbcTemplate npjTemp;
	
	@Autowired
	DataSourceTransactionManager txManager;
	
	@Autowired
	HelloDAO helloDAO;
	
	@Autowired
	HelloService helloService;
	
	@Autowired
	HaiDAO haiDAO;
	
	@Autowired
	HaiService haiService;
	
	@Autowired
	Hello hello;
	
	@Autowired
	Hai hai;
	
	public void run(String... args) throws Exception {
		System.out.println(" inside run method ");
		System.out.println(" 1. "+ctx);
	    System.out.println(" 2. Bean count: "+ctx.getBeanDefinitionCount());
	    System.out.println(" 3. "+dataSource);
	    System.out.println(" 4. "+jTemp);
	    System.out.println(" 5. "+npjTemp);
	    System.out.println(" 6. "+txManager);
	    System.out.println(" 7. "+helloDAO);
	    System.out.println(" 8. "+helloService);
	    System.out.println(" 9. "+haiDAO);
	    System.out.println(" 10. "+haiService);
	    System.out.println(" 11. "+hello);
	    System.out.println(" 12. "+hai);
	    System.out.println("  -----------------------------------  ");
	    System.out.println(" 13. Bean count: "+ctx.getBeanDefinitionCount());
	    String beanNames[] = ctx.getBeanDefinitionNames();
	    for (String beanName : beanNames) {
			System.out.println("  beanName :::  "+beanName);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("  Main method starts ");
		SpringApplication.run(MyBootApplication.class, args);
		System.out.println("  Main method end ");
	}

	
	@Bean(name="myHai")
	public Hai getHai() {
		return new Hai();
	}
	
	@Bean(name="myHello")
	public Hello getHello() {
		return new Hello();
	}
	
	@Bean(name="myHai2")
	public Hai getHai2() {
		return new Hai();
	}
	
	@Bean(name="myHello2")
	public Hello getHello2() {
		return new Hello();
	}
}
