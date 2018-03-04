package com.springboot.mongo.khang.core.services;

import java.util.Optional;

import com.domain.khang.task.Task;

public interface TaskService {

	/**
	 * Create task
	 * @param task
	 * @return
	 * @throws Exception
	 */
	Task createTask(Task task) throws Exception;

	/**
	 * Update task
	 * @param task
	 * @return
	 * @throws Exception
	 */
	Task updateTask(Task task) throws Exception;

	/**
	 * Find task by id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Optional<Task> findTaskById(String id) throws Exception;

	/**
	 * Delete task
	 * @param id
	 * @throws Exception
	 */
	void deleteTask(String id) throws Exception;

	/**
	 * Find task by key
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Task findTaskByKey(String key) throws Exception;

}
