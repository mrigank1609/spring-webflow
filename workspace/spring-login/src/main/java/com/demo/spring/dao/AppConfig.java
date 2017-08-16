package com.demo.spring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages={"com.demo."})
public class AppConfig {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/demo1");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(dataSource());
		return jt;
	}

}
