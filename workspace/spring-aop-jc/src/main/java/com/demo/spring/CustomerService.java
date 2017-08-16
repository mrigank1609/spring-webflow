package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Service
public class CustomerService {

	@Autowired
	@Qualifier("jpa")
	CustDao dao;

	public void setDao(CustDao dao) {
		this.dao = dao;
	}
	
	public String registerCustomer(int custId, String custName) {
		System.out.println("register Customer called..");
		dao.insertCustomer(custId, custName);
		if(custId==0)
		throw new UnsupportedOperationException();
		return "Customer Registered Successfully..";
	}
}
