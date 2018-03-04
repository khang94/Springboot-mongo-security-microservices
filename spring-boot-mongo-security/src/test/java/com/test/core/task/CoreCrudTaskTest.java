package com.test.core.task;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.domain.khang.task.Task;
import com.springboot.mongo.khang.core.application.MainApplication;
import com.springboot.mongo.khang.core.services.TaskService;

@ContextConfiguration(classes = MainApplication.class)
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CoreCrudTaskTest {

	@Autowired
	private TaskService taskService;

	@Test
	public void saveTask() throws Exception {
		Task task = new Task();
		task.setKey("TaskA");
		task.setName("Implement new feature");

		taskService.createTask(task);
		assertThat(taskService.findTaskById(task.getId()).get().getKey()).isEqualTo(task.getKey());
	}
	
	@Test
	public void getTask() throws Exception {
		
		this.saveTask();
		
		Task task = new Task();
		task.setKey("TaskA");
		task.setName("Implement new feature");

		assertThat(taskService.findTaskByKey(task.getKey()).getKey()).isEqualTo(task.getKey());
	}
	
	@Test
	public void updateTask() throws Exception {
		
		// Save Task with Task A
		this.saveTask();
		
		// Find Task saved
		Task task = taskService.findTaskByKey("TaskA");
		
		// Update to task b
		task.setKey("TaskB");
		
		// Update
		taskService.updateTask(task);

		assertThat(taskService.findTaskByKey(task.getKey()).getKey()).isEqualTo("TaskB");
		
	}
	
	@Test
	public void deleteTask() throws Exception {
		
		// Save Task with key Task A
		this.saveTask();
		
		// Find Task saved
		Task task = taskService.findTaskByKey("TaskA");
		
		// Delete
		taskService.deleteTask(task.getId());

		assertThat(taskService.findTaskById(task.getId()).isPresent()).isEqualTo(false);
	}
}
