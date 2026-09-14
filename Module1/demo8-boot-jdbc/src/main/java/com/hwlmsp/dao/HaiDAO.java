package com.hwlmsp.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class HaiDAO {

	@Autowired(required = false)
	DataSource ds;
	
	@Autowired(required = false)
	JdbcTemplate jTemp;
	
	public HaiDAO() {
		System.out.println("HaiDAO -D.C");
		System.out.println(" A. "+ds);
		System.out.println(" B. "+jTemp);
	} 
}
