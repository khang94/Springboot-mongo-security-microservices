package com.springboot.mongo.khang.core.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.khang.person.Person;
import com.springboot.mongo.khang.core.repository.PersonRepository;

@Service
public class DataLoader {

	@Autowired
	private PersonRepository personRepository;
	
	@PostConstruct
	private void initDefaultPerson() {
		
		personRepository.deleteAll();
		
		Person admin = new Person();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setIsEnable(true);
		admin.setIsAccountNonExpired(true);
		admin.setIsAccountNonLocked(true);
		admin.setIsCredentialNonExpired(true);
		admin.setRole("ROLE_ADMIN");
		
		// Save account
		personRepository.save(admin);
	}
}
