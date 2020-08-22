package com.management.PaymentMS.entity;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="payment")
public class Payment{
	
	


	@Id
	@Column(name="PAYMENTID",nullable=false)
	Integer paymentid;

	
	@Column(name="DUEAMOUNT",nullable = false, length=10)
	Double dueamount;
	
	
	
	
	@Column(name="PHONENUMBER", nullable = false)
	String phonenumber;
	
	
	@Column(name="PASSWORD", nullable = false)
	String password;
	
	
	@Column(name="POLICYNUMBER", nullable = false)
	String policynumber;
	
	
	@Column(name="ACCOUNTTYPE", nullable = false)
	String accountType;
	
	
	@Column(name="DURATION", nullable = false)
	LocalDate duration;
	
	
	
	


	
	public Integer getPaymentid() {
		return paymentid;
	}


	public void setPaymentid(Integer paymentid) {
		this.paymentid = paymentid;
	}


	public Double getDueamount() {
		return dueamount;
	}


	public void setDueamount(Double dueamount) {
		this.dueamount = dueamount;
	}

	

	
	public LocalDate getDuration() {
		return duration;
	}


	public void setDuration(LocalDate duration) {
		this.duration = duration;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPolicynumber() {
		return policynumber;
	}


	public void setPolicynumber(String policynumber) {
		this.policynumber = policynumber;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


}
