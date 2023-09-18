package ru.netology.service;


import org.springframework.stereotype.Service;
import ru.netology.model.Person;
import ru.netology.repository.PersonsRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService {

    private final PersonsRepository repository;

    public PersonService(PersonsRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

    public Person getPersonById(Long id) {
        return repository.getPersonById(id);
    }

    public List<Person> getPersonsYoungerAge(int age) {
        return repository.getPersonsYoungerAge(age);
    }

    public Optional<Person> getPersonsByNameAndSurname(String name, String surname) {
        return repository.getPersonsByNameAndSurname(name, surname);
    }

    public List<Person> getPersonsSortBySurname(){
        return repository.getPersonsSortBySurname();
    }
}
