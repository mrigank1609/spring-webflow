package com.demo.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@Column(name = "USERNAME")
	@NotEmpty
	@Size(min=4,max=12)
	private String userName;
	@Column(name = "PASSWORD")
	@NotEmpty
	@Size(min=4,max=12)
	private String password;

	public User() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
