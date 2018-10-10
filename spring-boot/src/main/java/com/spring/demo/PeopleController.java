package com.spring.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PeopleController {

    @PostMapping("/save")
    public String save(@RequestBody Person person) {
        return "Saved: " + person.getName() + ", " + person.getAge();
    }

    @GetMapping("/all")
    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Sam", 12));
        persons.add(new Person("Ram", 22));
        persons.add(new Person("Mary", 25));
        return persons;
    }
}
