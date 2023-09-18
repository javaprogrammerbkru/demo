package com.example.demo.advise;

import com.example.demo.exception.PersonNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonExceptionController {

    private final Logger logger = LoggerFactory.getLogger
            (PersonExceptionController.class);

    @ExceptionHandler(value = PersonNotFoundException.class)
    public ResponseEntity<String> exception(
            PersonNotFoundException exception) {

        logger.error("ERROR: " + exception.getMessage(), exception);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Person not found");
    }
}
