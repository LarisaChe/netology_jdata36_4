package ru.netology.service;


import org.springframework.stereotype.Service;
import ru.netology.model.Person;
import ru.netology.repository.PersonRepository;

import java.util.List;


@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getPersons(String city) {
        return repository.getPersonsByCity(city);
    }

    public Person getPersonById(Long id) {
        return repository.getPersonById(id);
    }
}
