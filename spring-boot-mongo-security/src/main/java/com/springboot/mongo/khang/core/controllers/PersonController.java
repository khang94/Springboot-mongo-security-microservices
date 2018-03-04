package com.springboot.mongo.khang.core.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.khang.person.Person;
import com.domain.khang.todo.TodoItem;
import com.springboot.mongo.khang.core.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	PersonService personService;

    @GetMapping("/model")
    public @ResponseBody ResponseEntity<?> getPersonModel() {
    		
    		Person person = new Person();
    		person.setFirstName("Khang");
    		person.setLastName("Mai");
    		
    		List<Person> persons = new ArrayList<Person>();
    		persons.add(person);
    		
    		return ResponseEntity.ok(persons);
        
    }
    
    @PostMapping("")
    public @ResponseBody ResponseEntity<?> savePerson(@RequestBody Person person) throws Exception {
    		return ResponseEntity.ok(personService.save(person));
    }
    
    @PutMapping("/{Id}")
    public @ResponseBody ResponseEntity<?> updatePerson(@PathVariable("Id") String id, 
    			@RequestBody Person person) throws Exception {
    		
    		Optional<Person> isPersonSaved = personService.findPersonById(id);
    		if(!isPersonSaved.isPresent()) {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    		
    		return ResponseEntity.ok(personService.update(person));
    }
    
    @DeleteMapping("/{Id}")
    public @ResponseBody ResponseEntity<?> deletePerson(@PathVariable("Id") String id) throws Exception {
    		
    		Optional<Person> isPersonSaved = personService.findPersonById(id);
    		if(!isPersonSaved.isPresent()) {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    		
    		personService.delete(id);
    		
    		return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/{Id}")
    public @ResponseBody ResponseEntity<?> findPersonById(@PathVariable("Id") String id) throws Exception {
    		
    		Optional<Person> person = personService.findPersonById(id);
    		if(!person.isPresent()) {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    	
		return ResponseEntity.ok(person.get());
    }
    
    @GetMapping("/{Id}/todo")
    public @ResponseBody ResponseEntity<?> findAllTaskOfPerson(@PathVariable("Id") String id , Principal user) throws Exception {
    		
    		System.out.println(user.getName());
    		List<TodoItem> todos = personService.findTaskByPersonId(id);
    		return ResponseEntity.ok(todos);
    }
    
    @GetMapping("/{Id}/todo/paging")
    public @ResponseBody ResponseEntity<?> findAllTaskPaging(@PathVariable("Id") String id,
    			@RequestParam(name = "fromIndex" , required = false , defaultValue = "0") Integer from,
    			@RequestParam(name = "toIndex" , required = false , defaultValue = "1") Integer to,
    			@RequestParam(name = "sortBy" , required = false , defaultValue = "name") String sortBy,
    			@RequestParam(name = "sortType" , required = false , defaultValue = "ASC") String sortType) throws Exception {
    		
    		List<TodoItem> todos = personService.findTaskPagingByPersonId(id, from, to, sortType ,sortBy);
    		return ResponseEntity.ok(todos);
    }
}
