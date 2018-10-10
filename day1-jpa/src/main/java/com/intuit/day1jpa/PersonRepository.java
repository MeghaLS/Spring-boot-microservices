package com.intuit.day1jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByNameAndAge(String name, int age);

    @Query("select p from Person p where p.age > :p1")
    List<Person> findAllWithAgeGreaterThan(@Param("p1") int age);

    @Query("select p from Person p where p.name like CONCAT(:p1,'%')")
    List<Person> findAllNameStartsWith(@Param("p1") String startsWith);
}
