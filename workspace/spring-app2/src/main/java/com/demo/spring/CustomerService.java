package com.demo.spring;

public class CustomerService {

	CustDao dao;

	public void setDao(CustDao dao) {
		this.dao = dao;
	}
	
	public String registerCustomer(int custId, String custName) {
		dao.insertCustomer(custId, custName);
		return "Customer Registered Successfully..";
	}
}
