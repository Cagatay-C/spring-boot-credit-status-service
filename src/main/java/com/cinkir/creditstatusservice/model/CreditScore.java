package com.cinkir.creditstatusservice.model;

public class CreditScore {

	private int id;
	private String identityNO;
	private int score;
	
	public CreditScore() {
		
	}

	public CreditScore(String identityNO, int score) {
		this.identityNO = identityNO;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentityNO() {
		return identityNO;
	}

	public void setIdentityNO(String identityNO) {
		this.identityNO = identityNO;
	}

	public int getScore() {
		return score;
	}

	public void setCreditScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "CreditScore [id=" + id + ", identityNO=" + identityNO + ", score=" + score + "]";
	}
	
}
