package com.springboot.mongo.khang.core.common;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class DataHelper {

	public String generateRandomUUID() throws Exception {
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();
		
		return randomUUIDString;
	}
}
