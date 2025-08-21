package com.demo.SpringBootDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.payment.PaymentProject.PaymentService;

@Configuration
public class AppConfig {
	
	public AppConfig() {
		System.out.println("App config constructor");
	}

	@Bean
	public PaymentService paymentService() {
		System.out.println("bean called");
		return new PaymentService();
	}
}
