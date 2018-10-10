package com.example.day03;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
public class WeatherController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${weather.service.url}")
    private String weatherURL;

    @GetMapping("/")
    public String renderPage() {
        return "index";
    }
    @HystrixCommand(fallbackMethod = "getTemperatureFromCache", commandProperties = {
            @HystrixProperty(name= "execution.isolation.thread.timeoutInMilliseconds", value="5000")
    })
    @PostMapping("/weather")
    @ResponseBody
    public String getTemperature(@RequestParam String city) {
        System.out.println("In the default method");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(weatherURL + city, String.class);
        String response = responseEntity.getBody();
        return response;
    }

    public String getTemperatureFromCache(String city) {
        System.out.println("In the fallback method");
        return "Weather reporter service is down. Unable to fetch temperature of " + city;
    }

}
