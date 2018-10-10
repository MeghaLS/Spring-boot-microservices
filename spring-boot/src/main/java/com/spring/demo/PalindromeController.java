package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
public class PalindromeController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String renderInputContent() {
        return "palindrome";
    }
    @PostMapping("/processString")
    @ResponseBody
    public String getIsPalindrome(@RequestParam("inputString") String inputString) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://172.28.89.39:8082/"+inputString, HttpMethod.GET, entity, String.class).getBody();
    }

}
