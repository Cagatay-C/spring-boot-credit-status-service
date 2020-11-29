package com.cinkir.creditstatusservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinkir.creditstatusservice.dao.CreditStatusDAO;
import com.cinkir.creditstatusservice.entity.CreditApplication;

@Service
public class CreditStatusServiceImpl implements CreditStatusService{
	
	private CreditStatusDAO creditStatusDAO;
	
	@Autowired
	public CreditStatusServiceImpl(CreditStatusDAO creditStatusDAO) {
		this.creditStatusDAO = creditStatusDAO;
	}

	@Override
	@Transactional
	public void save(CreditApplication theApplication) {
		this.creditStatusDAO.save(theApplication);
	}
}
