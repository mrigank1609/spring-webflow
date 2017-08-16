package com.demo.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

		Mail mail = (Mail) ctx.getBean("mail");
		System.out.println(mail.getMessage().getBody());
		List<String> addrList = mail.getToAddress();
		for (String s : addrList) {
			System.out.println(s);
		}
	}
}
