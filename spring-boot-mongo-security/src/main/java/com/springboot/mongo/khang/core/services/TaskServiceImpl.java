package com.springboot.mongo.khang.core.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.khang.task.Task;
import com.springboot.mongo.khang.core.common.DataHelper;
import com.springboot.mongo.khang.core.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	DataHelper dataHelper;
	
	@Override
	public Task createTask (Task task) throws Exception {
		
		// Generate id
		task.setId(dataHelper.generateRandomUUID());
		
		// Update time
		task.setCreatedDate(new Date());
		task.setUpdatedDate(new Date());
		
		return taskRepository.save(task);
	}
	
	@Override
	public Task updateTask (Task task) throws Exception {
		
		// Update time
		task.setUpdatedDate(new Date());
		
		return taskRepository.save(task);
	}
	
	@Override
	public Optional<Task> findTaskById(String id) throws Exception {
		Optional<Task> taskSaved = Optional.ofNullable(taskRepository.findOne(id));
		return taskSaved;
	}
	
	@Override
	public void deleteTask(String id) throws Exception {
		taskRepository.delete(id);
	}
	
	@Override
	public Task findTaskByKey(String key) throws Exception {
		return taskRepository.findTaskByKey(key);
	}
}
