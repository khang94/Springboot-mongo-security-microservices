package com.springboot.mongo.consumer.khang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongo.consumer.khang.services.TodoService;

@RestController
@RequestMapping("todo")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@PostMapping("/create")
	public @ResponseBody ResponseEntity<?> createTodo (@RequestParam("personId") String personId ,
			@RequestParam("taskId") String taskId, @RequestParam("todo") String todo) throws Exception{
		
		return ResponseEntity.ok(todoService.createTodo(personId, taskId, todo));
	}
}
