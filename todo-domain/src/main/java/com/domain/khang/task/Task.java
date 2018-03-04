package com.domain.khang.task;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Task {

	@Id
	private String id;
	
	private String name;
	private String reporter;
	private String assignee;
	
	private String key;
	private String summary;
	
	private String priority;
	private String status;
	
	private Date createdDate;
	private Date updatedDate;
}
