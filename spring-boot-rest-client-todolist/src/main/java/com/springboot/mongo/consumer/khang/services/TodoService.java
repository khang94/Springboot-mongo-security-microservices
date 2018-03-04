package com.springboot.mongo.consumer.khang.services;

import com.domain.khang.todo.TodoItem;

public interface TodoService {

	/**
	 * Create todo by call to core application by Rest Template
	 * @param personId
	 * @param taskId
	 * @param todo
	 * @return
	 * @throws Exception
	 */
	TodoItem createTodo(String personId, String taskId, String todo) throws Exception;

}
