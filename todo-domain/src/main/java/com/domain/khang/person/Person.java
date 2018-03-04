package com.domain.khang.person;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Person {

	@Id
	private String id;
	
	private String username;
	private String password;
	
	// Security of account
	private Boolean isAccountNonExpired;
	private Boolean isAccountNonLocked;
	private Boolean isCredentialNonExpired;
	private Boolean isEnable;
	
	private String firstName;
	private String lastName;
	private String fullName;

	private String phone;
	private String address;

	private String teamName;

	private String position;
	private String level;
	private String role;

	private Date dateJoin;

	private Date createdDate;
	private Date updatedDate;

}
