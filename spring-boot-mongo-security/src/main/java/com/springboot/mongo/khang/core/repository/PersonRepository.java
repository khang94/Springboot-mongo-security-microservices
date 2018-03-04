package com.springboot.mongo.khang.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

import com.domain.khang.person.Person;

@Service
@RepositoryRestResource(collectionResourceRel = "personsRest", path = "personsRest")
public interface PersonRepository extends MongoRepository<Person , String>  {

	Person findByUsername(String username);
}
