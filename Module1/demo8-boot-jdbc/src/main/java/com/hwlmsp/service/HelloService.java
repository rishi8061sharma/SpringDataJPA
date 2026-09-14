package com.hwlmsp.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired(required = false)
	DataSource ds;
	
	@Autowired(required = false)
	JdbcTemplate jTemp;
	
	public HelloService(){
		System.out.println(" HelloService D.C ");
		System.out.println(" A. "+ds);
		System.out.println(" B. "+jTemp);
	}
}
