package com.intuit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.domain.Calculator;

@RestController
@RequestMapping("/calc")
public class CalcController {

	@Autowired
	private List<String> operations;
	
	@Autowired
	private Calculator calculator;
	
	@GetMapping("/operations")
	public List<String> getOperations() {
		return operations;
	}
	
	@GetMapping("/add/{a}/{b}")
	public int add(@PathVariable int a, @PathVariable int b) {
		return calculator.add(a, b);
	}
	
	@GetMapping("/square/{num}")
	public int square(@PathVariable int num) {
		return calculator.square(num);
	}
	
	@PutMapping("/subtract/{a}/{b}")
	public int subtract(@PathVariable int a, @PathVariable int b) {
		return calculator.subtract(a, b);
	}
	
	@PostMapping("/product")
	public int product(@RequestParam("num1") int a, @RequestParam("num2") int b) {
		return calculator.multiply(a, b);
	}
	
	
}
