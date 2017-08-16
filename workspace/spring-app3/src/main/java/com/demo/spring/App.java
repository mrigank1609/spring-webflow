package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

		CustomerService custService = (CustomerService) ctx.getBean("customerService");
		String resp = custService.registerCustomer(100, "Rocky");
		System.out.println(resp);

	}
}
