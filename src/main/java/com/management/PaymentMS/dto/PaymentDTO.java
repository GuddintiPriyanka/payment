package com.management.PaymentMS.dto;

import java.time.LocalDate;

import com.management.PaymentMS.entity.Payment;

public class PaymentDTO {

	Integer paymentid;
	Double dueamount;
	String phonenumber;
	String password;
	String policynumber;
	String accounttype;
	LocalDate duration;
	
	
	

	public LocalDate getDuration() {
		return duration;
	}


	public void setDuration(LocalDate duration) {
		this.duration = duration;
	}


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


	public String getAccounttype() {
		return accounttype;
	}


	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}


	
	public PaymentDTO() {
		super();
		
	}
	
	
	// Converts Entity into DTO
	public static PaymentDTO valueOf(Payment payment) {
		
		PaymentDTO paymentDTO=new PaymentDTO();
		
		paymentDTO.setPaymentid(payment.getPaymentid());
		paymentDTO.setAccounttype(payment.getAccountType());
		paymentDTO.setDueamount(payment.getDueamount());
		paymentDTO.setPassword(payment.getPassword());
		paymentDTO.setPhonenumber(payment.getPhonenumber());
		paymentDTO.setPolicynumber(payment.getPolicynumber());
		paymentDTO.setDuration(payment.getDuration());
		

		return paymentDTO;
	}
	

	//Creates an entity
	public Payment createEntity() {
		Payment payment = new Payment();
		
		payment.setDueamount(this.getDueamount());
		payment.setAccountType(this.getAccounttype());
		payment.setPassword(this.getPassword());
		payment.setPaymentid(this.getPaymentid());
		payment.setPhonenumber(this.getPhonenumber());
		payment.setPolicynumber(this.getPolicynumber());
		payment.setDuration(this.getDuration());
		return payment;
	}


	@Override
	public String toString() {
		return "PaymentDTO [paymentid=" + paymentid + ", dueamount=" + dueamount + ", phonenumber=" + phonenumber
				+ ", password=" + password + ", policynumber=" + policynumber + ", accounttype=" + accounttype
				+ ", duration=" + duration + "]";
	}


	

	


}