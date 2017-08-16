package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		CustomerService custService = (CustomerService) ctx.getBean("customerService");
		String resp = custService.registerCustomer(0, "Rocky");
		System.out.println(resp);

	}
}
