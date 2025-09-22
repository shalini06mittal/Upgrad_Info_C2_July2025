package com.demo.SpringSecurityDemo.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// d31ff258-fa32-462c-9dcd-524d771835ac
@RestController
public class WelcomeController {

	public WelcomeController() {
		System.out.println("Welcome controller");
	}
	@GetMapping("/welcome")
	public String sayWelcome() {
		return "Hey from welcome controller ";
	}
}
