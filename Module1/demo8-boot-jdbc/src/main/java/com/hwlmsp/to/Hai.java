package com.hwlmsp.to;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Hai {

	@Autowired(required = false)
	DataSource ds;
	
	@Autowired(required = false)
	JdbcTemplate jTemp;
	
	public Hai() {
		System.out.println(" inside Hai Constructor ");
		System.out.println(" A. "+ds);
		System.out.println(" B. "+jTemp);
	}
}
