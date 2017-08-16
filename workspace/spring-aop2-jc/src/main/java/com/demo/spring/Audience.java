package com.demo.spring;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {
	@Before("execution(* com..spring.Perf*.perform(..))")
	public void takeSeat() {
		System.out.println("Audience takes seat....");
	}

	@Before("execution(* com..spring.Perf*.perform(..))")
	public void switchOffMobile() {
		System.out.println("Audience switches of mobiles....");
	}

	@AfterReturning("execution(* com..spring.Perf*.perform(..))")
	public void applaud() {
		System.out.println("Clap Clap Clap!....");
	}

	@AfterThrowing(throwing = "e", pointcut = "execution(* com..spring.Perf*.perform(..))")
	public void demandRefund(PerformerException e) {
		System.out.println("Bad performance ... refund our money..");
	}
}
