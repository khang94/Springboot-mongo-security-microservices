package com.springboot.mongo.khang.core.services;

import java.util.List;
import java.util.Optional;

import com.domain.khang.person.Person;
import com.domain.khang.todo.TodoItem;

public interface PersonService {

	/**
	 * Save person 
	 * @param person
	 * @return
	 * @throws Exception
	 */
	Person save(Person person) throws Exception;
	
	/**
	 * Find person by id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Optional<Person> findPersonById(String id) throws Exception;

	/**
	 * Update person
	 * @param person
	 * @return
	 * @throws Exception
	 */
	Person update(Person person) throws Exception;

	/**
	 * Delete person by id
	 * @param id
	 * @throws Exception
	 */
	void delete(String id) throws Exception;

	/**
	 * Find task by person Id
	 * @param personId
	 * @return
	 * @throws Exception
	 */
	List<TodoItem> findTaskByPersonId(String personId) throws Exception;

	/**
	 * Find all task paging of person
	 * @param personId
	 * @param from
	 * @param to
	 * @param sort
	 * @return
	 * @throws Exception
	 */
	List<TodoItem> findTaskPagingByPersonId(String personId, Integer from, Integer to, String sort , String sortBy) throws Exception;

	/**
	 * Find person by username
	 * @param username
	 * @return
	 * @throws Exception
	 */
	Person findPersonByUsername(String username) throws Exception;

}
