package com.springboot.mongo.khang.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.domain.khang.todo.TodoItem;

@Service
public interface TodoRepository extends MongoRepository<TodoItem , String> {

	public List<TodoItem> findByPersonId(String personId);
	
	public TodoItem findByName (String name);
}
