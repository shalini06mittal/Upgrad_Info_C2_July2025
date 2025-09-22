package com.demo.SpringSecurityDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
//		http.authorizeHttpRequests( (requests) -> requests.anyRequest().authenticated());
		
		//http.authorizeHttpRequests( (requests) -> requests.anyRequest().denyAll());
		
		
		http.authorizeHttpRequests( (requests) -> 
				requests
				.requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
				.requestMatchers("/welcome","/contact").permitAll()		
				);
		
		http.formLogin(withDefaults());
		return http.build();
	}
	
}
