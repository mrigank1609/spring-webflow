package com.demo.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJpaMain {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		Dao dao=(Dao)ctx.getBean("jpaDaoImpl");
		
		Emp e= new Emp(505, "Vikram", "Mumbai", 68000);
		dao.save(e);

	}

}
