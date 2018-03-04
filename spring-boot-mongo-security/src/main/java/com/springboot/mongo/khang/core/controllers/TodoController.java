package com.springboot.mongo.khang.core.controllers;

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

import com.domain.khang.todo.TodoItem;
import com.springboot.mongo.khang.core.services.TodoService;

@RestController
@RequestMapping("todo/core")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@PostMapping("/create")
	public @ResponseBody ResponseEntity<?> createTodo (@RequestParam("personId") String personId ,
			@RequestParam("taskId") String taskId, @RequestParam("todo") String todo) throws Exception{
		
		return ResponseEntity.ok(todoService.createTodoItem(personId, taskId, todo));
	}
	
	@PutMapping("/{Id}")
	public @ResponseBody ResponseEntity<?> updateTodo (@RequestBody TodoItem todoBody ,
				@PathVariable("Id") String id) throws Exception {
		
		Optional<TodoItem> todoSaved = todoService.getTodoById(id);
		if(!todoSaved.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		TodoItem todoUpdated = todoService.updateTodo(todoBody);
		
		return new ResponseEntity<>(todoUpdated ,HttpStatus.OK);
	}
	
	@GetMapping("/{Id}")
	public @ResponseBody ResponseEntity<?> getTodo (@PathVariable("Id") String id) throws Exception {
		
		Optional<TodoItem> todoSaved = todoService.getTodoById(id);
		if(!todoSaved.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<>(todoSaved.get() ,HttpStatus.OK);
	}
	
	@DeleteMapping("/{Id}")
	public @ResponseBody ResponseEntity<?> deleteTodo (@PathVariable("Id") String id) throws Exception {
		
		Optional<TodoItem> todoSaved = todoService.getTodoById(id);
		if(!todoSaved.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		todoService.deleteTodo(id);
		return new ResponseEntity<>(todoSaved.get() ,HttpStatus.OK);
	}
	
	
}
