package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findPersonById(Integer id);
    List<Person> findAll();

}
