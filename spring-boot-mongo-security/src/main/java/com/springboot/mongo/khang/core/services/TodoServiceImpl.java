package com.springboot.mongo.khang.core.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.domain.khang.todo.TodoItem;
import com.springboot.mongo.khang.core.common.DataHelper;
import com.springboot.mongo.khang.core.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;

	@Autowired
	DataHelper dataHelper;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public TodoItem createTodoItem(String personId, String taskId, String todo) throws Exception {

		TodoItem todoItem = new TodoItem();

		// Generate UID
		todoItem.setId(dataHelper.generateRandomUUID());

		todoItem.setName(todo);
		todoItem.setPersonId(personId);
		todoItem.setTaskId(taskId);

		todoItem.setIsCompleted(false);
		
		todoItem.setCreatedDate(new Date());
		todoItem.setUpdatedDate(new Date());

		return todoRepository.save(todoItem);
	}
	
	@Override
	public Optional<TodoItem> getTodoById (String id) throws Exception {
		return Optional.ofNullable(todoRepository.findOne(id));
	}
	
	@Override
	public TodoItem updateTodo(TodoItem todoItem) throws Exception {
		
		// Update modified date
		todoItem.setUpdatedDate(new Date());
		
		return todoRepository.save(todoItem);
	}
	
	@Override
	public void deleteTodo(String id) throws Exception {
		todoRepository.delete(id);
	}

	@Override
	public List<TodoItem> findAllTaskByPersonId(String personId) throws Exception {
		return todoRepository.findByPersonId(personId);
	}
	
	@Override
	public TodoItem findByName(String name) throws Exception {
		return todoRepository.findByName(name);
	}

	@Override
	public List<TodoItem> findAllTaskByPersonIdPaging(String personId, String sort, Integer from, Integer to,
			String sortBy) throws Exception {

		final Pageable pageableRequest = new PageRequest(from, to);
		Sort sortDetail = new Sort(sort.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC, sortBy);

		Query query = new Query();
		query.addCriteria(Criteria.where("personId").is(personId));
		query.with(pageableRequest);
		query.with(sortDetail);

		return mongoTemplate.find(query, TodoItem.class);
	}

}
