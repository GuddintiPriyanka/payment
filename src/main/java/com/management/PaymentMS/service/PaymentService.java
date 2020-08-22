package com.management.PaymentMS.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.management.PaymentMS.dto.PaymentDTO;
import com.management.PaymentMS.entity.Payment;
import com.management.PaymentMS.repository.PaymentRepository;



@Service
public class PaymentService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	public PaymentRepository paymentrepo;
	
	
	
	
	//view list of payments based on phoneno
	public List<Double> getpayments(String phonenumber) {
		List<Payment> payment = paymentrepo.findByPhonenumber(phonenumber);
		List<Double> paymentlist= new ArrayList<>();
		
		
		for (Payment pay : payment) {
			PaymentDTO paymentdetailsDTO = PaymentDTO.valueOf(pay);
		
			
			LocalDate today=LocalDate.now();
			PaymentDTO paymentdto =PaymentDTO.valueOf(pay);
			LocalDate duration=paymentdto.getDuration();
			
			if(duration.isBefore(today)){
				
				paymentlist.add(paymentdetailsDTO.getDueamount());
				
			
		    }
			else 
			{
			paymentdto.setDueamount(((paymentdto.getDueamount())/12)*
		    		(paymentdto.getDuration().getMonthValue()-today.getMonthValue()));
		    
		   
			paymentlist.add(paymentdto.getDueamount());
			}
			
			
		}
		return paymentlist;
	}




	//make a new payment
	public void makePayment(String phonenumber, PaymentDTO paymentDTO) {
		logger.info("Payment request for customer {} with data {}", phonenumber, paymentDTO);
		paymentDTO.setPhonenumber(phonenumber);
		Payment payment= paymentDTO.createEntity();
		paymentrepo.save(payment);
	}





	

	
		
		


}