package com.cinkir.creditstatusservice.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;

public class Sms {
	
	private NexmoClient client;
	
	public Sms(String API_KEY, String API_SECRET) {
		client = new NexmoClient.Builder()
				  .apiKey(API_KEY)
				  .apiSecret(API_SECRET)
				  .build(); 
	}
	

	public void sendMessage(String phoneNO, String messageToSend) {
		TextMessage message = new TextMessage("Vonage APIs", phoneNO, messageToSend);
		
		SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);		
		for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
			System.out.println(responseMessage);
		}
	}
}

