package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.model.Person;
import ru.netology.service.PersonService;
import java.util.List;

@RestController
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
        public List<Person> getPersonsFromOneCity(@RequestParam("city") String city) {
        return service.getPersons(city);
    }


    @GetMapping("/persons/by-id")
    public Person getPersonById(@RequestParam("id") Long id) {
        return service.getPersonById(id);
    }
}
