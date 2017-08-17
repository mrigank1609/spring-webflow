package com.demo.spring;

import java.util.List;

public interface EmpDao {
	public String save(Emp e);
	public Emp findById(int id);
	public List<Emp> getAllEmps();
}
