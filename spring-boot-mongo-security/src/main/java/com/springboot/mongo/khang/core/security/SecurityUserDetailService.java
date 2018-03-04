package com.springboot.mongo.khang.core.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.domain.khang.person.Person;
import com.springboot.mongo.khang.core.repository.PersonRepository;

@Component
public class SecurityUserDetailService implements UserDetailsService{
	
	@Autowired
	PersonRepository personRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Person user = personRepo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException( "Name not found!" );
		}
		
	    List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
	    //CustomUserDetail userDetail = new CustomUserDetail(user);
	    
	    return new User(user.getUsername(), user.getPassword(), authorities );
	}
	
	

}
