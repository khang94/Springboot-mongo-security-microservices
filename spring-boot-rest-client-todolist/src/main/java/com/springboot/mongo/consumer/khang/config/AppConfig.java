package com.springboot.mongo.consumer.khang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class AppConfig {

	@Value("${core.url}")
	private String coreUrl;
	
	@Value("${user.security.default.username}")
	private String username;
	
	@Value("${user.security.default.password}")
	private String password;
	
}
