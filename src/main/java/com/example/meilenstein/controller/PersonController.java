package com.example.meilenstein.controller;

import com.example.meilenstein.model.Person;
import com.example.meilenstein.repositorys.PersonRepository;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@Builder
@CrossOrigin
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping("/add")
    public Person createPerson(@RequestBody Person person) {
        Person user = new Person();
        person.setFirstName(user.getFirstName());
        person.setLastName(user.getLastName());
        return personRepository.save(person);
    }
}
