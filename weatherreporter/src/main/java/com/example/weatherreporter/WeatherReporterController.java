package com.example.weatherreporter;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherReporterController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openweathermap.url}")
    private String openWeatherMapUrl;

    @GetMapping("/temperature/{city}")
    public double getTemperature(@PathVariable String city) throws InterruptedException {
        double temperature = 0.0;
        String url = openWeatherMapUrl + city;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String json = responseEntity.getBody();
        JSONObject jsonObject = new JSONObject(json);
        temperature = jsonObject.getJSONObject("main").getDouble("temp");
        return temperature;
    }
}