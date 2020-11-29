package com.cinkir.creditstatusservice;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cinkir.creditstatusservice.entity.CreditApplication;
import com.cinkir.creditstatusservice.model.CreditScore;
import com.cinkir.creditstatusservice.utils.CalculateLimit;
import com.cinkir.creditstatusservice.utils.CalculateLimitImpl;

public class CalculateLimitTest {
	
	CreditApplication creditApplication = new CreditApplication(1, "Cagatay", 
			"Cinkir", "12345678911","5342348795", "", 1000, 0);
	
	CreditScore creditScore = new CreditScore("12345678911", 1000);
	CalculateLimit calculateLimit = new CalculateLimitImpl(creditApplication,creditScore);
	
	@Test
	void testCalculateLimit() {
		calculateLimit.calculate();
		int limit = creditApplication.getLimit();
		assertEquals(4000, limit);
		
		creditScore.setCreditScore(500);
		calculateLimit.calculate();
		limit = creditApplication.getLimit();
		assertEquals(0, limit);
		
		creditScore.setCreditScore(750);
		calculateLimit.calculate();
		limit = creditApplication.getLimit();
		assertEquals(10000,limit);
	}
}
