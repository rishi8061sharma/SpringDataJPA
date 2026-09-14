package com.hwlmsp.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.context.annotation.Bean; 
import org.springframework.web.servlet.config.annotation.*; 
import com.google.common.base.Predicates; 
import springfox.documentation.builders.PathSelectors; 
import springfox.documentation.builders.RequestHandlerSelectors; 
import springfox.documentation.service.ApiInfo; 
import springfox.documentation.service.Contact; 
import springfox.documentation.spi.DocumentationType; 
import springfox.documentation.spring.web.plugins.Docket; 


public class JLCApplicationConfig  implements WebMvcConfigurer{

	private ApiInfo getHWLApiDetails() { 
		return new ApiInfo("HWL  Bank API", 
		"Customer and Account API - part of HwlBank", "1.1", 
		"Free to use ", 
		new Contact("Rishi Sharma", "https://www.hwlmsp.com", "rishi.sharma@hwlmsp.com"), 
		"API Under Free Licence", 
		"https://www.hwlmsp.com"); 
		} 

	@Bean 
	public Docket myHWLApp() { 
	return new Docket(
			DocumentationType.SWAGGER_2)
			.select()
			.paths(PathSelectors.any()) 
	.apis(
			Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build() 
	.apiInfo(getHWLApiDetails()); 
	} 
	
	 
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) { 
	//enabling swagger-ui
	registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/METAINF/resources/"); 
	// enable bootstrap	
	registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/METAINF/resources/webjars/"); 
	}
}
