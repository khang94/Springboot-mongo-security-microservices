package com.test.core.todo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.domain.khang.todo.TodoItem;
import com.springboot.mongo.khang.core.application.MainApplication;
import com.springboot.mongo.khang.core.services.TodoService;

@ContextConfiguration(classes = MainApplication.class)
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CoreCrudTodoTest {

	@Autowired
	private TodoService todoService;

	@Test
	public void saveTodoItem() throws Exception {
		TodoItem todo = new TodoItem();
		todo.setName("TodoA");

		todo = todoService.createTodoItem("1", "1", "TodoA");
		assertThat(todoService.getTodoById(todo.getId()).get().getName()).isEqualTo(todo.getName());
	}
	
	@Test
	public void getTodoItem() throws Exception {
		
		this.saveTodoItem();
		
		TodoItem todo = new TodoItem();
		todo.setName("TodoA");

		assertThat(todoService.findByName(todo.getName()).getName()).isEqualTo(todo.getName());
	}
	
	@Test
	public void updateTodoItem() throws Exception {
		
		// Save TodoItem with TodoItem A
		this.saveTodoItem();
		
		// Find TodoItem saved
		TodoItem todo = todoService.findByName("TodoA");
		
		// Update to todo b
		todo.setName("TodoB");
		
		// Update
		todoService.updateTodo(todo);

		assertThat(todoService.getTodoById(todo.getId()).get().getName()).isEqualTo("TodoB");
		
	}
	
	@Test
	public void deleteTodoItem() throws Exception {
		
		// Save TodoItem with key TodoItem A
		this.saveTodoItem();
		
		// Find TodoItem saved
		TodoItem todo = todoService.findByName("TodoA");
		
		// Delete todo
		todoService.deleteTodo(todo.getId());

		assertThat(todoService.getTodoById(todo.getId()).isPresent()).isEqualTo(false);
	}
}
