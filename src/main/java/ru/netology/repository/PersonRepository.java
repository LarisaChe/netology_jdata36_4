package ru.netology.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT p.id, p.name, p.surname, p.age, p.phone_number, p.city_of_living FROM person p WHERE UPPER(p.city_of_living) = UPPER(:paramCity) order by p.name",
            nativeQuery = true)
    List<Person> findByCityOfLiving(@Param("paramCity") String cityOfLiving);

    @Query(value = "SELECT p.id, p.name, p.surname, p.age, p.phone_number, p.city_of_living  FROM person p WHERE p.age <= ? order by p.age desc", nativeQuery = true)
    List<Person> findByAgeLessThanOrderByAge(Integer age);

    @Query(value = "SELECT p.id, p.name, p.surname, p.age, p.phone_number, p.city_of_living  FROM person p WHERE UPPER(p.name) = UPPER(:name) and UPPER(p.surname) = UPPER(:surname)", nativeQuery = true)
    Optional<Person> findByNameAndSurname(@Param("name")String name, @Param("surname")String surname);
}
