package com.demo.SpringBootDemo.aop;

import org.springframework.stereotype.Component;

@Component
public class EmpService {

	public EmpService() {
		System.out.println("Emp ervice const");
	}
	public String applyNow() {
		System.out.println("Emp service apply now called");
		return "Done";
	}
	public String applyThen() throws Exception {
		System.out.println("Emp service apply then called");
		throw new Exception("Emp service threw exception");
	}
}
