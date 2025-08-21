package com.demo.SpringBootDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.payment.PaymentProject.PaymentService;

@Component
public class BankService {

//	@Autowired
	private ITokenGenerator tokenGenerator; 
	
	private PaymentService paymentService;

//	public BankService() { 
//		System.out.println("Bank Service default constructor"); 
//	} 
//	@Autowired
	
	public BankService(@Qualifier("ob") 
		final ITokenGenerator tokenGenerator,  
		final PaymentService paymentService)
	{
		System.out.println("Bank service param cosntructor");
		this.tokenGenerator = tokenGenerator;
		this.paymentService = paymentService;
	} 
	public ITokenGenerator getTokenGenerator() {
		return tokenGenerator; 

	} 
	
	public PaymentService getPaymentService() {
		return paymentService;
	}
	//@Autowired
	public void setTokenGenerator(ITokenGenerator tokenGenerator) {
		this.tokenGenerator = tokenGenerator; 
	} 
	public void getTokenValue(){ 
		System.out.println(tokenGenerator.generateToken());
		System.out.println(paymentService.makePayment(1000, 10));
	}

}
