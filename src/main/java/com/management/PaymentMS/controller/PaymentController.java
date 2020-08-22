package com.management.PaymentMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.management.PaymentMS.dto.PaymentDTO;
import com.management.PaymentMS.repository.PaymentRepository;
import com.management.PaymentMS.service.PaymentService;




@RestController
@CrossOrigin
@EnableAutoConfiguration
public class PaymentController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	public PaymentService paymentService;
	
	@Autowired
	PaymentRepository paymentRepo;
	
	//Make a new Payment
		@PostMapping(value = "/customers/{phonenumber}/payment", consumes = MediaType.APPLICATION_JSON_VALUE)
		public void makePayment(@PathVariable String phonenumber, @RequestBody PaymentDTO paymentDTO) {
			logger.info("Payment request for customer {} with data {}", phonenumber, paymentDTO);
			paymentService.makePayment(phonenumber, paymentDTO);
		}
	
		
	//view payments based on phonenumber
	@GetMapping(value = "/customers/{phonenumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Double> getCustomerPaymentDetails(@PathVariable String phonenumber) {
        logger.info("Paymentdetails request for customer {}", phonenumber);
        logger.info("======Request received=====");
        return paymentService.getpayments(phonenumber);
    }

}