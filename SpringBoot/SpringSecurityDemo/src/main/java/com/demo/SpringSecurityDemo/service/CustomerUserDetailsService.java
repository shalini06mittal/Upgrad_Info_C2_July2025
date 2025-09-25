package com.demo.SpringSecurityDemo.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.SpringSecurityDemo.entity.Customer;
import com.demo.SpringSecurityDemo.repo.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {
	
	private final CustomerRepository customerRepository;

	
	public CustomerUserDetailsService(CustomerRepository customerRepository) {
		System.out.println("UDS ");
		this.customerRepository = customerRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("customer repo "+customerRepository);
		System.out.println("customer username "+username);
		
		Customer customer = customerRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("USer details not found for user "+username));
		
		List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customer.getRole()));
		return new User(customer.getEmail(), customer.getPwd(), authorities);
	}
	
}
