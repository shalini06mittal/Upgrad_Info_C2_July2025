package com.web.SpringBootWebDemo.restapi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8080
@RestController // @Controller + @ResponseBody
@RequestMapping("/api")
public class HelloController {
	//http://localhost:8080/api
	@GetMapping("/greet")
	public String greeter() {
		return "Good Morning";
	}
	
	//http://localhost:8080/api
	//http://localhost:8080/api?name=shalini&city=Mumbai
	// ? -> optional paramter : filtering options
	@GetMapping
	public String greeter(@RequestParam(name = "username") String name, 
			
		@RequestParam(required = true) String city) {
		if(name !=null || city != null)
			return "Good Morning "+ (name == null ? "" :name.toUpperCase()) +" "+city;
		return "Good Morning Guest";
	}
	
	@PostMapping
	public String post() {
		return "Good evening - POSt";
	}
	@PutMapping
	public String put() {
		return "Good afternnon - PUT";
	}
	@DeleteMapping
	public String delete() {
		return "Good night - DELETE";
	}
}
