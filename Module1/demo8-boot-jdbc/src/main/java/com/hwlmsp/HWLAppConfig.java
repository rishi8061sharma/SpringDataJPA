package com.hwlmsp;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hwlmsp.dao.HaiDAO;
import com.hwlmsp.dao.HelloDAO;
import com.hwlmsp.service.HaiService;
import com.hwlmsp.service.HelloService;


/*@Configuration
@ComponentScan
@EnableAutoConfiguration */

/*@SpringBootApplication(scanBasePackages = {
 "com.hwlmsp"		
})*/
@SpringBootApplication
public class HWLAppConfig {
    //place where you define beans
	@Bean(name="myhaiDAO")
	public HaiDAO getHaiDAO(){
		return new HaiDAO();
	}
	
	@Bean(name="myhaiService")
	public HaiService getHaiService() {
		return new HaiService();
	}
	
	
	
}
