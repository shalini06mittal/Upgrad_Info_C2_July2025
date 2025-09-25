package com.demo.SpringSecurityDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.SpringSecurityDemo.entity.Customer;
import com.demo.SpringSecurityDemo.repo.CustomerRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostConstruct
	void initialize() {
		repo.save(new Customer(1, "user@a.com", encoder.encode("12345"),"user"));
		repo.save(new Customer(2, "admin@a.com", encoder.encode("54321"),"admin"));
	}
	
}
