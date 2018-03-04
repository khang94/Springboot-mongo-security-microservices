package com.springboot.mongo.khang.core.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.domain.khang.person.Person;

public class CustomUserDetail implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Person person;
	
	public CustomUserDetail(Person person) {
		this.person = person;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return this.person.getPassword();
	}

	@Override
	public String getUsername() {
		return this.person.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.person.getIsAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.person.getIsAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.person.getIsCredentialNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return this.person.getIsEnable();
	}

}
