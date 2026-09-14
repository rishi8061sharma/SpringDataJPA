package com.hwlmsp.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
public class HWLWebConfig implements WebMvcConfigurer{ 
	
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) { 
	registry.addResourceHandler("/webjars/**") 
	.addResourceLocations("classpath:/META-INF/resources/webjars/"); 
	} 

	 
}
