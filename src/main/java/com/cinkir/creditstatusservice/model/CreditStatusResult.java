package com.cinkir.creditstatusservice.model;

public class CreditStatusResult {
	
	private boolean isApproved;
	private int limit;
	
	public CreditStatusResult(boolean isApproved, int limit) {
		this.isApproved = isApproved;
		this.limit = limit;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
