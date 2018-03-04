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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.khang.task.Task;
import com.springboot.mongo.khang.core.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@GetMapping("/model")
	public @ResponseBody ResponseEntity<?> getTaskModel() throws Exception {
		Task task = new Task();
		task.setKey("Project AEM");
		task.setName("Implement new feature");
		
		return ResponseEntity.ok(task);
	}
	
	@PostMapping("")
	public @ResponseBody ResponseEntity<?> createNewTask(@RequestBody Task task) throws Exception {
		return ResponseEntity.ok(taskService.createTask(task));
	}
	
	@PutMapping("/{Id}")
	public @ResponseBody ResponseEntity<?> updateTask(@PathVariable("Id") String id , 
			@RequestBody Task task) throws Exception {
		
		Optional<Task> isTaskSaved = taskService.findTaskById(id);
		if(!isTaskSaved.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(taskService.updateTask(task));
	}
	
	@GetMapping("/{Id}")
	public @ResponseBody ResponseEntity<?> findTaskById(@PathVariable("Id") String id) throws Exception {
		
		Optional<Task> isTaskSaved = taskService.findTaskById(id);
		if(!isTaskSaved.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(isTaskSaved.get());		
	}
	
	@DeleteMapping("/{Id}")
	public @ResponseBody ResponseEntity<?> deleteTaskById(@PathVariable("Id") String id) throws Exception {
		Optional<Task> isTaskSaved = taskService.findTaskById(id);
		if(!isTaskSaved.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		taskService.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
