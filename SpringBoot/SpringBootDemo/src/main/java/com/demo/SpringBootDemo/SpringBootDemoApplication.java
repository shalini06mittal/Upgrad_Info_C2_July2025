package com.demo.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.SpringBootDemo.service.BankService;
import com.demo.SpringBootDemo.service.ITokenGenerator;
import com.demo.SpringBootDemo.service.RandomTokenGenerator;

// is an opinionated framework
@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello Spring");
		
		
		ApplicationContext context = 
		SpringApplication.run(SpringBootDemoApplication.class, args);
		
		//ITokenGenerator gen = new RandomTokenGenerator();
		
//		for(String beanName :context.getBeanDefinitionNames())
//		{
//			System.out.println(beanName);
//		}
		
//		ITokenGenerator gen = context.getBean(RandomTokenGenerator.class);
//		
//		System.out.println(gen.generateToken());
		
		BankService service = context.getBean(BankService.class);
		System.out.println(service.getTokenGenerator());
		System.out.println(service.getPaymentService());
		service.getTokenValue();
		service.getTokenValue();
		service.getTokenValue();
		service.getTokenValue();

	}

}
