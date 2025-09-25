package com.demo.SpringSecurityDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	
	//@Bean
	UserDetailsService userDetails() {
		UserDetails user1 = User
				.withUsername("shalini").password("{noop}sh123").roles("user")
				
				.build();
		System.out.println(user1.getPassword());
		UserDetails user2 = User
				.withUsername("admin").password(encodePassword().encode("admin123")).roles("admin")
				
				.build();
		System.out.println(user2.getPassword());
		return new InMemoryUserDetailsManager(user1, user2);
	}

	@Bean
	PasswordEncoder encodePassword() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
//		http.authorizeHttpRequests( (requests) -> requests.anyRequest().authenticated());
		
		//http.authorizeHttpRequests( (requests) -> requests.anyRequest().denyAll());
		
		
		http.authorizeHttpRequests( (requests) -> 
				requests
				.requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
				.requestMatchers("/welcome","/contact","/h2-console/**").permitAll()		
				)
		.csrf(csrf -> csrf
                .ignoringRequestMatchers(("/h2-console/**")) // Disable CSRF for H2 console
            )
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.sameOrigin()) // Allow H2 console to be loaded in a frame
            );
		http.formLogin(withDefaults());
		//http.httpBasic(withDefaults());
		return http.build();
	}
	
}
