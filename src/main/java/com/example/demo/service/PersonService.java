package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    Optional<Person> findPersonById(Integer id);

    List<Person> findAll();

}
