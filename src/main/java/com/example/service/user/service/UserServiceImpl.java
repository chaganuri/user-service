package com.example.service.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.user.model.User;
import com.example.service.user.repository.UserRepository;
import com.example.service.user.repository.CRUD.UserCRUDInterface;
import com.example.service.user.repository.JPA.UserJPARepository;
import com.example.service.user.repository.custom.UserRepositoryCustom;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserJPARepository userJPARepository;
	
	@Autowired
	UserCRUDInterface userCRUDRepository;
	
	@Autowired
	UserRepositoryCustom userRepositoryCustom;
	
	@Override
	public User findById(Long Id) {
		return userRepository.findById(Id);
	}
	
	
	public Optional<User> findByIdCRUD(Long Id) {
		return userCRUDRepository.findById(Id);
	}
	
	public Iterable<User> findAll() {
		return userCRUDRepository.findAll();
	}
	
	public boolean isUserExists(Long Id) {
		return userCRUDRepository.existsById(Id);
	}

	@Override
	public List<User> getUserByName(String name) {
		
		return userJPARepository.findByName(name);
	}
	public List<User> getUserByNameLowercase(String name){
		
		return userJPARepository.findByNameLower(name);
	}
	
	public List<User> getUserByLocation(String address){
		
		return userJPARepository.findByLocation(address);
	}
	
	public List<User> getUserByNameOrAddress(String name, String city){
		
		return userRepositoryCustom.getUsersByNameOrCity(name,city);
	}
	
	
	

}
