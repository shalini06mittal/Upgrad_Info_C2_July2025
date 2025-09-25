package com.demo.SpringSecurityDemo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.SpringSecurityDemo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Optional<Customer> findByEmail(String email);
}
