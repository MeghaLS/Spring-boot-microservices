package com.intuit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	//http://localhost:8080/hi/Sam
	
	@GetMapping("/hi/{name}")
	@ResponseBody
	public String hi(@PathVariable("name") String name) {
		return "Hi " + name;
	}
	
	//http://localhost:8080/tata?name=Ram
	@GetMapping("/tata")
	@ResponseBody
	public String bye(@RequestParam("name") String name) {
		return "Bye Bye " + name; 
	}
	
	
}
