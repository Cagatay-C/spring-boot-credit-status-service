package com.cinkir.creditstatusservice.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinkir.creditstatusservice.entity.CreditApplication;

@Repository
public class CreditStatusDAOImpl implements CreditStatusDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public CreditStatusDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(CreditApplication theCreditApplication) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theCreditApplication);
	}
}
