package com.demo.SpringBootDemo.aop;

import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl {

	public CustomerServiceImpl() {
		System.out.println("Customer service constructor called");
	}
	
	public void applyForChequeBook(long accno) {
		System.out.println("apply for cheque book called.. "+ accno);
	}
	
	public void stopCheque(long accno) {
		System.out.println("stop cheque called.. "+ accno);
	}
	public void applyForCreditCard(String name , double salary) {
		System.out.println("apply for credit cardcalled.. "+ name+ " "+salary);
	}
	@Log
	public double balance(long accno) {
		System.out.println("balance method called "+accno);
		return 9999.99;
	}
}
