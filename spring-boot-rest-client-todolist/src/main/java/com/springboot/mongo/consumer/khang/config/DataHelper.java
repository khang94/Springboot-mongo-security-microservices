package com.springboot.mongo.consumer.khang.config;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

@Service
public class DataHelper {

	public String buildAuthorizationToken(String username , String password) throws Exception {
		
		String auth = username + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64( 
           auth.getBytes(Charset.forName("US-ASCII")) );
        String authHeader = "Basic " + new String( encodedAuth );
        return authHeader;
	}
}
