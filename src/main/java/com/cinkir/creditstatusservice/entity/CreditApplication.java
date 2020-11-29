package com.cinkir.creditstatusservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credit_application")
public class CreditApplication {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_no")
	private String identityNO;
	
	@Column(name="phone_no")
	private String phoneNO;
	
	@Column(name="credit_result")
	private String creditResult;
	
	@Column(name="salary_in_month")
	private int salaryInMonth;
	
	@Column(name="credit_limit")
	private int limit;

	public CreditApplication() {

	}

	public CreditApplication(int id, String firstName, String lastName, String identityNO, String phoneNO,
			String creditResult, int salaryInMonth, int limit) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNO = identityNO;
		this.phoneNO = phoneNO;
		this.creditResult = creditResult;
		this.salaryInMonth = salaryInMonth;
		this.limit = limit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentityNO() {
		return identityNO;
	}

	public void setIdentityNO(String identityNO) {
		this.identityNO = identityNO;
	}

	public String getPhoneNO() {
		return phoneNO;
	}

	public void setPhoneNO(String phoneNO) {
		this.phoneNO = phoneNO;
	}

	public String getCreditResult() {
		return creditResult;
	}

	public void setCreditResult(String creditResult) {
		this.creditResult = creditResult;
	}

	public int getSalaryInMonth() {
		return salaryInMonth;
	}

	public void setSalaryInMonth(int salaryInMonth) {
		this.salaryInMonth = salaryInMonth;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "CreditApplication [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", identityNO="
				+ identityNO + ", phoneNO=" + phoneNO + ", creditResult=" + creditResult + ", salaryInMonth="
				+ salaryInMonth + ", limit=" + limit + "]";
	}
	
}
