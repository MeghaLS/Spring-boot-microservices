package com.intuit.day1jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/loadAll")
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public  String delete(@PathVariable int id) {
        if(personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return "deleted";
        }
        return "Not deleted";
    }

    @GetMapping("findAgeGreaterThan/{age}")
    public List<Person> findAgeGreaterThan(@PathVariable int age) {
        return personRepository.findAllWithAgeGreaterThan(age);
    }

    @GetMapping("findNameStartsWith/{startInput}")
    public List<Person> findAgeGreaterThan(@PathVariable String startInput) {
        return personRepository.findAllNameStartsWith(startInput);
    }

    @PutMapping("/update/{id}/{age}")
    public String updateAge(@PathVariable int id, @PathVariable int age) {
        if(personRepository.existsById(id)) {
            Person person = personRepository.findById(id).get();
            person.setAge(age);
            personRepository.save(person);
            return "Updated";

        }
        return "Invalid id, cant update";
    }

    @PostMapping("/save/{name}/{age}")
    public String save(@PathVariable  String name, @PathVariable int age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        personRepository.save(person);
        return "Saved";
    }

    @GetMapping("/")
    public String get(){
        return "hi";
    }
}
