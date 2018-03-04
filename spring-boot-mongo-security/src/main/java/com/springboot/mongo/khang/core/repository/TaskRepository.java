package com.springboot.mongo.khang.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.domain.khang.task.Task;

@Service
public interface TaskRepository extends MongoRepository<Task , String> {

	Task findTaskByKey(String key);
}
