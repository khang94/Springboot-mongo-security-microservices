/**
 * @Author Khang  01/03/2018
 */
package com.springboot.mongo.khang.core.services;

import java.util.List;
import java.util.Optional;

import com.domain.khang.todo.TodoItem;

public interface TodoService {

	/**
	 * Create todo item
	 * @param personId
	 * @param taskId
	 * @param todo
	 * @return
	 * @throws Exception
	 */
	TodoItem createTodoItem(String personId, String taskId, String todo) throws Exception;

	/**
	 * Find of task which was delegate tos person
	 * @param personId
	 * @return
	 * @throws Exception
	 */
	List<TodoItem> findAllTaskByPersonId(String personId) throws Exception;

	/**
	 * Find task of person & sorting & page
	 * @param personId
	 * @param sort
	 * @param from
	 * @param to
	 * @return
	 * @throws Exception
	 */
	List<TodoItem> findAllTaskByPersonIdPaging(String personId, String sort, 
			Integer from, Integer to , String sortBy)
			throws Exception;

	/**
	 * Update todo by ID
	 * @param todoItem
	 * @return
	 * @throws Exception
	 */
	TodoItem updateTodo(TodoItem todoItem) throws Exception;

	/**
	 * Get todo by id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Optional<TodoItem> getTodoById(String id) throws Exception;

	/**
	 * Delete todo by id
	 * @param id
	 * @throws Exception
	 */
	void deleteTodo(String id) throws Exception;

	/**
	 * Find todo by name
	 * @param name
	 * @return
	 * @throws Exception
	 */
	TodoItem findByName(String name) throws Exception;

}
