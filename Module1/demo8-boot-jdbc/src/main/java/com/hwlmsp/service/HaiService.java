package com.hwlmsp.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class HaiService {

	@Autowired(required = false)
	DataSource ds;
	
	@Autowired(required = false)
	JdbcTemplate jTemp;
	
	public HaiService(){
		System.out.println(" HaiService D.C ");
		System.out.println(" A. "+ds);
		System.out.println(" B. "+jTemp);
	}
}
