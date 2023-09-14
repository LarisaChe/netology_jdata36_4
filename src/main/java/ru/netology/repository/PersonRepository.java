package ru.netology.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.netology.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import java.util.stream.Collectors;

@Repository
public class PersonRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private static final String queryStr = read("queryPersonsByCity.sql");

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> getPersonsByCity(String city) {
        List<Person> resultList = (List<Person>) entityManager.createNativeQuery(queryStr, Person.class)
                .setParameter("paramCity", city)
                .getResultList();
        return resultList;
    }

    public Person getPersonById(Long id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }

}
