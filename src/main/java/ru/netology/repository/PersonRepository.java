package ru.netology.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByCityOfLiving(String cityOfLiving, Sort sort);

    List<Person> findByAgeLessThanOrderByAge(Integer age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}
