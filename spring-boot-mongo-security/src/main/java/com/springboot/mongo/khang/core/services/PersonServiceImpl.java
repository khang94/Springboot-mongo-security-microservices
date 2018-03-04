package com.springboot.mongo.khang.core.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.khang.person.Person;
import com.domain.khang.todo.TodoItem;
import com.springboot.mongo.khang.core.common.DataHelper;
import com.springboot.mongo.khang.core.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	DataHelper dataHelper;
	
	@Autowired
	TodoService todoService;

	@Override
	public Person save(Person person) throws Exception {

		// Generate id
		person.setId(dataHelper.generateRandomUUID());
		
		// Create Date
		person.setCreatedDate(new Date());
		person.setUpdatedDate(new Date());
		
		return personRepository.save(person);
	}
	
	@Override
	public Person update(Person person) throws Exception {
		
		// Update date
		person.setUpdatedDate(new Date());
		
		return personRepository.save(person);
	}
	
	@Override
	public void delete(String id) throws Exception {
		personRepository.delete(id);
	}

	@Override
	public Optional<Person> findPersonById(String id) throws Exception {
		Optional<Person> person = Optional.ofNullable(personRepository.findOne(id));
		return person;
	}
	
	@Override
	public List<TodoItem> findTaskByPersonId (String personId) throws Exception {
		return todoService.findAllTaskByPersonId(personId);
	}
	
	@Override
	public Person findPersonByUsername(String username) throws Exception {
		return personRepository.findByUsername(username);
	}
	
	@Override
	public List<TodoItem> findTaskPagingByPersonId (String personId , Integer from ,
			Integer to , String sort , String sortBy) throws Exception {
		return todoService.findAllTaskByPersonIdPaging(personId, sort, from, to , sortBy);
	}
}
