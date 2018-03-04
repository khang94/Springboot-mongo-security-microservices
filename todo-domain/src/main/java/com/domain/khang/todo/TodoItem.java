package com.domain.khang.todo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class TodoItem {
	
	@Id
	private String id;
	private String name;
	private String category;
	private Boolean isCompleted;
	private String taskId;
	private String personId;
	
	private Date createdDate;
	private Date updatedDate;
}
