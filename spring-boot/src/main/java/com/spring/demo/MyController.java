package com.spring.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @GetMapping("/lunch")
    public String eat() {
        return "monday";
    }
    @PostMapping("/processname")
    public String process(@RequestParam("firstName") String firstName, Model model) {
        String message = "Hello " + firstName;
        model.addAttribute("message", firstName);
        return "result";
    }
}
