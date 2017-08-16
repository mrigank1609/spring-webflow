package com.demo.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public class CustDaoMockJpaImpl implements CustDao {

	public String insertCustomer(int id, String name) {
		System.out.println("Customer inserted using JPA...");
		return "success";
	}

}
