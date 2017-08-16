package com.demo.spring;

public class CustDaoMockJpaImpl implements CustDao {

	public String insertCustomer(int id, String name) {
		System.out.println("Customer inserted using JPA...");
		return "success";
	}

}
