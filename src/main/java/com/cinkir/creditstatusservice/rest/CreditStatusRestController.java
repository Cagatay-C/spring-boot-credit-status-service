package com.cinkir.creditstatusservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cinkir.creditstatusservice.entity.CreditApplication;
import com.cinkir.creditstatusservice.model.CreditScore;
import com.cinkir.creditstatusservice.model.CreditStatusResult;
import com.cinkir.creditstatusservice.service.CreditStatusService;
import com.cinkir.creditstatusservice.utils.CalculateLimit;
import com.cinkir.creditstatusservice.utils.CalculateLimitImpl;
import com.cinkir.creditstatusservice.utils.Sms;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class CreditStatusRestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	private CreditStatusService creditStatusService;
	
	@Autowired
	public CreditStatusRestController(CreditStatusService creditStatusService) {
		this.creditStatusService = creditStatusService;
	}

	@PostMapping("/creditStatus")
	public CreditStatusResult retrieveCreditStatus(@RequestBody CreditApplication creditApplication) {
		boolean isApproved = false;
		String messageToClient="";
		
		CreditScore creditScore = restTemplate.getForObject("http://localhost:8082/api/creditScore/" + 
				creditApplication.getIdentityNO(), CreditScore.class);
		
		CalculateLimit calculateLimit = new CalculateLimitImpl(creditApplication, creditScore);
		calculateLimit.calculate();
		creditApplication.setId(0);
		creditStatusService.save(creditApplication);
		
		if(creditApplication.getCreditResult().equals("approved")) {
			isApproved = true;
			messageToClient = "Credit request has been approved.";
		} else {
			messageToClient = "Credit request has been denied.";
		}
	
		Sms sms = new Sms(env.getProperty("API_KEY"),env.getProperty("API_SECRET"));
		sms.sendMessage("905342469830", messageToClient);
		
		return new CreditStatusResult(isApproved, creditApplication.getLimit());
	}
}	
