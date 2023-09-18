package com.example.demo.controller;

import com.example.demo.exception.PersonNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    private final Logger logger =
            LoggerFactory.getLogger(MainController.class);

    @Value("${title.message}")
    private String title;

    private PersonService personService;

    @Autowired
    public MainController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/getAll")
    public Person getAll() {
        Optional<Person> person = personService.findPersonById(3);
        return person.orElse(
                new Person(999, "first222222", "last2222222222")
        );
    }

    @GetMapping("/findAll")
    public List<Person> findAll() {
        logger.trace("Trace------------------- /findAll ------------------");
        logger.info(title);
        return personService.findAll();
    }

    @PostMapping("/postNew")
    public Person postNew(@RequestBody Person person) {
        logger.info("----------------------------");
        logger.info(person.toString());
        logger.info("----------------------------");
        return person;
    }

    @GetMapping("/testExc")
    public Person testExc() {
        throw new PersonNotFoundException();
    }

}
