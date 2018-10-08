package com.intuit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//http://localhost:8080/greet

@Controller
public class HelloController {

	@GetMapping("/greet")
	@ResponseBody
	public String hello() {
		return "Hello there";
	}
	
	@PostMapping("/bye")
	@ResponseBody
	public String bye() {
		return "Bye Bye";
	}
	
}
