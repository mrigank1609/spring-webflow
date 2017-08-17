package com.demo.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmpDaoJPAImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public String save(Emp e) {

		try {
			em.persist(e);
			return "JPA: Emp with id " + e.getEmpId() + " saved";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Data Couldnot be saved...";
		}
	}

	@Override
	public Emp findById(int id) {
		Emp e = em.find(Emp.class, id);
		return e;
	}

	@Override
	public List<Emp> getAllEmps() {
		Query query = em.createQuery("SELECT e from Emp e");
		List<Emp> empList = query.getResultList();
		return empList;
	}

}
