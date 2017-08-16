package com.demo.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JpaDaoImpl implements Dao {

	@Autowired
	EntityManagerFactory emf;

	@Override
	@Transactional(transactionManager="txManager")
	public String save(Emp e) {
		EntityManager em = emf.createEntityManager();
		Dept dept=em.find(Dept.class, 10);
		e.setDept(dept);
		em.persist(e);
		return "success";
	}

}
