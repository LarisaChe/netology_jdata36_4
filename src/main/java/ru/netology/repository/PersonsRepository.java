package ru.netology.repository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.netology.model.Person;

import java.util.List;

import java.util.Optional;


@Repository
public class PersonsRepository {

    private final PersonRepository personRepository;


    public PersonsRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        List<Person> resultList = personRepository.findByCityOfLiving(city, Sort.by(Sort.Order.asc("name")));
        //resultList.forEach(System.out::println);
        return resultList;
    }

    public Person getPersonById(Long id) {
        var person = personRepository.findById(id);
        return person.get();
    }

    public List<Person> getPersonsYoungerAge(int age) {
        List<Person> resultList = personRepository.findByAgeLessThanOrderByAge(age);
        return resultList;
    }

    public Optional<Person> getPersonsByNameAndSurname(String name, String surname) {
        Optional<Person> resultList = personRepository.findByNameAndSurname(name, surname);
        return resultList;
    }

    public List<Person> getPersonsSortBySurname(){
        List<Person> resultList = personRepository.findAll(Sort.by(Sort.Order.asc("surname")));
        return resultList;
    }
}
