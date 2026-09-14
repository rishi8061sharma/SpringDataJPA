package com.hwlmsp.springboot;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2
public class MyBootApplication {

	public static void main(String as[]) { 
		 SpringApplication.run(MyBootApplication.class, as); 
		 } 
}
