package com.springboot.mongo.consumer.khang.gateway;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.domain.khang.todo.TodoItem;
import com.springboot.mongo.consumer.khang.config.AppConfig;
import com.springboot.mongo.consumer.khang.config.DataHelper;

@Service
public class TodoGateway {

	public static final Logger LOGGER = LoggerFactory.getLogger(TodoGateway.class);

	@Autowired
	AppConfig appConfig;

	@Autowired
	DataHelper dataHelper;

	public TodoItem createTaskForPerson(String personId, String taskId, String todo) throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		// Get url
		String urlParams = "?personId=" + personId + "&&taskId=" + taskId + "&&todo=" + todo;
		String url = appConfig.getCoreUrl() + urlParams;

		// Build security header
		Map<String, String> headersMap = new HashMap<String, String>();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.add("Authorization",
				dataHelper.buildAuthorizationToken(appConfig.getUsername(), appConfig.getPassword()));
		headers.setContentType(MediaType.APPLICATION_JSON);
		for (String header : headers.keySet()) {
			headersMap.put(header, headers.getFirst(header));
		}

		// Build Request Entity
		HttpEntity<TodoItem> todoEntity = new HttpEntity<>(headers);

		// Execute Request
		ResponseEntity<TodoItem> responseTodo = null;
		try {
			responseTodo = restTemplate.exchange(url, HttpMethod.POST, todoEntity, TodoItem.class,
					new ParameterizedTypeReference<TodoItem>() {
					});
		} catch (Exception ex) {
			LOGGER.info("Error {}" + ex.getMessage());
		}

		return responseTodo.getBody();
	}

}
