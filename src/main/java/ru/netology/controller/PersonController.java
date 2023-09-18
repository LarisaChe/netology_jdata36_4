package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.model.Person;
import ru.netology.service.PersonService;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
        public List<Person> getPersonsFromOneCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/persons/younger-than-age") //younger-than-age
    public List<Person> getPersonsYoungerAge(@RequestParam("age") int age) {
        return service.getPersonsYoungerAge(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.getPersonsByNameAndSurname(name, surname);
    }

    @GetMapping("/persons/by-id")
    public Person getPersonById(@RequestParam("id") Long id) {
        return service.getPersonById(id);
    }

    @GetMapping("/persons/all-sort-by-surname")
    public List<Person> getPersonsSortBySurname(){
        return service.getPersonsSortBySurname();
    }
}
