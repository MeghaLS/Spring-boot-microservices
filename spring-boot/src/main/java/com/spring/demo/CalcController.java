package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calc")
public class CalcController {
    @Autowired
    private MathHelper mathHelper;

    @Autowired
    private List<String> operations;
    @GetMapping("/add/{num1}/{num2}")
    public Integer add(@PathVariable("num1") Integer
                               num1,@PathVariable("num2") Integer
                               num2 ) {
        return mathHelper.add(num1, num2);
    }

    @GetMapping("/operations")
    public List<String> getOperations() {
        return operations;
    }

    @GetMapping("/square/{num1}")
    public Integer square(@PathVariable("num1") Integer num ) {
        return mathHelper.square(num);
    }

    @PutMapping("/subtract/{num1}/{num2}")
    public Integer subtract(@PathVariable("num1") Integer num1, @PathVariable("num2") Integer num2) {
        return mathHelper.subtract(num1, num2);
    }

    @PostMapping("/product")
    public Integer product(@RequestParam("num1") Integer num1, @RequestParam("num2") Integer num2) {
        return mathHelper.product(num1, num2);
    }
}
