package com.demo.spring;

public class CustDaoMockHibImpl implements CustDao {

	public String insertCustomer(int id, String name) {
		System.out.println("Customer inserted using Hibernate...");
		return "success";
	}

}
