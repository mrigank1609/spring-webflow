package com.demo.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MYDEPT")
public class Dept {
	@Id
	@Column(name = "DNO")
	private int deptNo;
	@Column(name = "MANAGER")
	private String manager;
	@Column(name = "DNAME")
	private String deptName;
	
	@OneToMany
	@JoinColumn(name = "DNO")
	private Set<Emp> empList = new HashSet<Emp>();

	public Dept() {
		// TODO Auto-generated constructor stub
	}

	public Dept(int deptNo, String manager, String deptName) {
		this.deptNo = deptNo;
		this.manager = manager;
		this.deptName = deptName;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(Set<Emp> empList) {
		this.empList = empList;
	}

}
