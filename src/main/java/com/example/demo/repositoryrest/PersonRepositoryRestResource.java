package com.example.demo.repositoryrest;

import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepositoryRestResource extends
        PagingAndSortingRepository<Person, Integer>, CrudRepository<Person, Integer> {

    List<Person> findByLastName(@Param("name") String name);

}
