package com.demo.spring.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.demo.spring.model.User;

@Service
public class Authenticator {

	@PersistenceContext
	EntityManager em;

	public String checkUser(String userName, String password) {
		User userFromDb = em.find(User.class, userName);
		if (userFromDb != null) {
			if (password.equals(userFromDb.getPassword())) {
				return "valid";
			} else {
				return "invalid";
			}
		} else {
			return "invalid";
		}
	}
}
