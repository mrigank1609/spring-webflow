package com.demo.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		EmpService service = (EmpService) ctx.getBean("empService");
		//System.out.println(service.registerEmp(124, "James", "Hyderabad", 20000));
		
		List<Emp> empList=service.getAll();
		for(Emp e:empList){
			System.out.println(e);
		}

	}

}
