package com.test.core.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.domain.khang.person.Person;
import com.springboot.mongo.khang.core.application.MainApplication;
import com.springboot.mongo.khang.core.services.PersonService;

@ContextConfiguration(classes = MainApplication.class)
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CoreCrudPersonTest {

	@Autowired
	private PersonService personService;

	@Test
	public void savePerson() throws Exception {
		Person person = new Person();
		person.setUsername("Khang");
		person.setPassword("123456");

		personService.save(person);
		assertThat(personService.findPersonById(person.getId()).get()).isEqualTo(person);
		// Mockito.when(personService.findPersonById(person.getId()).get().getUsername()).thenReturn(person.getUsername());
	}
	
	@Test
	public void getPerson() throws Exception {
		
		this.savePerson();
		
		Person person = new Person();
		person.setUsername("Khang");
		person.setPassword("123456");

		assertThat(personService.findPersonByUsername(person.getUsername()).getUsername()).isEqualTo(person.getUsername());
	}
	
	@Test
	public void updatePerson() throws Exception {
		
		// Save person with username Khang
		this.savePerson();
		
		// Find person saved
		Person person = personService.findPersonByUsername("Khang");
		person.setUsername("KhangUpdated");
		
		// Update
		personService.update(person);

		assertThat(personService.findPersonByUsername(person.getUsername()).getUsername()).isEqualTo(person.getUsername());
		
	}
	
	@Test
	public void deletePerson() throws Exception {
		
		// Save person with username Khang
		this.savePerson();
		
		// Find person saved
		Person person = personService.findPersonByUsername("Khang");
		
		// Update
		personService.delete(person.getId());

		assertThat(personService.findPersonByUsername(person.getUsername())).isEqualTo(null);
		
	}
	

}
