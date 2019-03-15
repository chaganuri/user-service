package com.example.service.user.service;

import java.util.List;
import java.util.Optional;

import com.example.service.user.model.User;


public interface UserService {
	
	public User findById(Long Id);
	public Optional<User> findByIdCRUD(Long Id);
	public Iterable<User> findAll();
	public boolean isUserExists(Long Id);
	public List<User> getUserByName(String name);
	public List<User> getUserByNameLowercase(String name);
	public List<User> getUserByLocation(String address);
	public List<User> getUserByNameOrAddress(String name, String city);
	

}
