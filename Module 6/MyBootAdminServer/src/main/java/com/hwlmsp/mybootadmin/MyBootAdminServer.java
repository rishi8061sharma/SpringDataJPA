package com.hwlmsp.mybootadmin;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
@SpringBootApplication
@EnableAdminServer
public class MyBootAdminServer {

	public static void main(String as[]) { 
		 SpringApplication.run(MyBootAdminServer.class, as); 
		 } 
}
