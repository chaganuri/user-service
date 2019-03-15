package com.example.service.user.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.service.user.model.User;

@Repository
public class UserRepository {
	
	/*
	 * Spring boot does the AutoConfigation of h3 databse datsource - 
	 * By Identifying the h2 database in classpath it creates the datasource object and 
	 * that will be passed as arg to JdbcTemplate class constructor by @Autowired annotation.
	 *  
	 */
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	public User findById(Long Id) {
		return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE id =?", new Object[] {Id}, new BeanPropertyRowMapper<User>(User.class));
		
	}

}
