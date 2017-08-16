package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.demo.spring" })
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean
	public CustomerService customerService() {
		CustomerService c = new CustomerService();
		return c;
	}

}
