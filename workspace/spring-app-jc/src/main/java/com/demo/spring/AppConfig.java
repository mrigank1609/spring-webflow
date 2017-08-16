package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.demo.spring" })
public class AppConfig {
	
	@Bean
	public CustomerService customerService() {
		CustomerService c = new CustomerService();
		return c;
	}

}
