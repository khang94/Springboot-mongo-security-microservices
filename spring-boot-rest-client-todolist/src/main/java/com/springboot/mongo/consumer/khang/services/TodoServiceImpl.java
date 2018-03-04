package com.springboot.mongo.consumer.khang.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.khang.todo.TodoItem;
import com.springboot.mongo.consumer.khang.gateway.TodoGateway;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	TodoGateway todoGateway;
	
	@Override
	public TodoItem createTodo(String personId , String taskId ,String todo) throws Exception {
		return todoGateway.createTaskForPerson(personId, taskId, todo);
	}
	
}
