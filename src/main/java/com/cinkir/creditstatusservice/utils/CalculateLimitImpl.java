package com.cinkir.creditstatusservice.utils;

import com.cinkir.creditstatusservice.entity.CreditApplication;
import com.cinkir.creditstatusservice.model.CreditScore;

public class CalculateLimitImpl implements CalculateLimit{
	CreditApplication creditApplication = null;
	CreditScore creditScore = null;
	
	public static int LIMIT_FACTOR = 4;
	
	public CalculateLimitImpl(CreditApplication creditApplication, CreditScore creditScore) {
		this.creditApplication = creditApplication;
		this.creditScore = creditScore;
	}

	@Override
	public void calculate() {
		if(creditScore.getScore() <= 500) {
			creditApplication.setCreditResult("denied");
			creditApplication.setLimit(0);
		} else if((creditScore.getScore() > 500 && creditScore.getScore() < 1000) 
				&& creditApplication.getSalaryInMonth() < 5000) {
			creditApplication.setCreditResult("approved");
			creditApplication.setLimit(10000);
		} else if(creditScore.getScore() >= 1000) {
			creditApplication.setCreditResult("approved");
			creditApplication.setLimit(creditApplication.getSalaryInMonth() * LIMIT_FACTOR);
		}	
	}
}
