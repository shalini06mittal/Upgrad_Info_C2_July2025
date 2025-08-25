package com.demo.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.demo.SpringBootDemo.aop.CustomerServiceImpl;
import com.demo.SpringBootDemo.aop.EmpService;
import com.demo.SpringBootDemo.service.BankService;
import com.demo.SpringBootDemo.service.ITokenGenerator;
import com.demo.SpringBootDemo.service.RandomTokenGenerator;

// is an opinionated framework
@SpringBootApplication
@EnableAspectJAutoProxy
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
		
//		BankService service = context.getBean(BankService.class);
//		System.out.println(service.getTokenGenerator());
//		System.out.println(service.getPaymentService());
//		service.getTokenValue();
//		service.getTokenValue();
//		service.getTokenValue();
//		service.getTokenValue();
		
		EmpService service = context.getBean(EmpService.class);
		System.out.println(service.getClass().getName());

		CustomerServiceImpl serviceImpl = context.getBean(CustomerServiceImpl.class);
		System.out.println(serviceImpl.getClass().getName());
		service.applyNow();
		
//		serviceImpl.applyForChequeBook(102);
//		
//		serviceImpl.balance(234);
//		
		try {
			service.applyThen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

}
