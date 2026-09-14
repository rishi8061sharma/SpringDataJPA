package com.hwlmsp.to;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Hello {

	@Autowired(required = false)
	DataSource ds;
	
	@Autowired(required = false)
	JdbcTemplate jTemp;
	
	public Hello() {
		System.out.println(" inside Hello Constructor ");
		System.out.println(" A. "+ds);
		System.out.println(" B. "+jTemp);
	}
}
