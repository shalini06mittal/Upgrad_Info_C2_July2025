package com.web.SpringBootWebDemo.restapi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/")
public class HelloController {
//http://localhost:8080/greet
	@GetMapping("/greet")
	public String greeter() {
		return "Good Morning";
	}
	
	//http://localhost:8080/?name=shalini&city=Mumbai
	@GetMapping
	public String greeter(String name, 
			
		@RequestParam(required = false) String city) {
		if(name !=null)
			return "Good Morning "+name.toUpperCase() +" "+city;
		return "Good Morning Guest";
	}
	@PostMapping
	public String post() {
		return "Good evening";
	}
	@PutMapping
	public String put() {
		return "Good afternnon";
	}
	@DeleteMapping
	public String delete() {
		return "Good night";
	}
}
