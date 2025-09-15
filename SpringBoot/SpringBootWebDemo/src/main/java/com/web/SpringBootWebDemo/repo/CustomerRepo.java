package com.web.SpringBootWebDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.SpringBootWebDemo.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
