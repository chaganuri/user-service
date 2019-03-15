package com.example.service.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.user.model.User;
import com.example.service.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value ="/user/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") long id) {
		return userService.findById(id);
		
	}
	
	@RequestMapping(value ="/findUser/{id}", method = RequestMethod.GET)
	public Optional<User> findByIdCRUD(@PathVariable("id") long id) {
		return userService.findByIdCRUD(id);
		
	}
	
	@RequestMapping(value ="/checkUser/{id}", method = RequestMethod.GET)
	public String isUserExists(@PathVariable("id") long id) {
		return userService.isUserExists(id) ? "Yes, User Exists.": "No, User does not Exists";
		
	}
	@RequestMapping(value ="/userByName/{name}", method = RequestMethod.GET)
	public List<User> getUserByName(@PathVariable("name") String name) {
		return userService.getUserByName(name);
		
	}
	
	@RequestMapping(value ="/userByLowerName/{name}", method = RequestMethod.GET)
	public List<User> getUserByNameLowerCase(@PathVariable("name") String name) {
		return userService.getUserByName(name);
		
	}
	@RequestMapping(value ="/userByLocation/{address}", method = RequestMethod.GET)
	public List<User> getUserByLocation(@PathVariable("address") String address) {
		return userService.getUserByLocation(address);
		
	}
	@RequestMapping(value ="/userByLocationXML/{address}", method = RequestMethod.GET,produces="application/xml")
	public List<User> getUserByLocationXML(@PathVariable("address") String address) {
		System.out.println("UserController.getUserByLocationXML():hai");
		return userService.getUserByLocation(address);
		
	}
	@RequestMapping(value ="/userByNameOrAddress", method = RequestMethod.GET)
	public List<User> getUsersByNameOrAddress(@RequestParam(value ="name", required=false) String name, 
											  @RequestParam(value = "address",required = false) String address) {
		
		return userService.getUserByNameOrAddress(name, address);
		
	}
}

