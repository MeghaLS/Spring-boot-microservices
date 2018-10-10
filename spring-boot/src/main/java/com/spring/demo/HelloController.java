package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/hi/{name}")
    @ResponseBody
    public String hi(@PathVariable("name") String name) {
        return "Hi " + name;
    }

    //http://localhost:8080/tata?name=Ram
    @GetMapping("/tata")
    @ResponseBody
    public String bye(@RequestParam("name") String name, @RequestParam("name2") String name2) {
        return "Bye Bye " + name + name2;
    }
}
