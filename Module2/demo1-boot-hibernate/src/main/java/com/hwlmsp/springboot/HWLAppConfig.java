package com.hwlmsp.springboot;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class HWLAppConfig {

	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource myDataSource){
		Properties myprops = new Properties();
		myprops.put("hibernate.show_sql", "true");
		myprops.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		//myprops.put("hibernate.hbm2ddl.auto", "update"); // will not use in production
		LocalSessionFactoryBean mySessionFactory
		        = new LocalSessionFactoryBean();
        mySessionFactory.setDataSource(myDataSource); //1
	    mySessionFactory.setHibernateProperties(myprops);//2
		mySessionFactory.setPackagesToScan("com.hwlmsp.springboot"); //3
	    return mySessionFactory;
	}
	
	@Bean 	
	public HibernateTemplate getHibernateTemplate(SessionFactory mySessionFactory){
		return new HibernateTemplate(mySessionFactory);
	}
	
	@Bean 	
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory mySessionFactory){
		return new HibernateTransactionManager(mySessionFactory);
	}
	
}
