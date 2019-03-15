package com.example.service.user.repository.custom;

import java.util.List;

import com.example.service.user.model.User;

public interface UserRepositoryCustom {
	List<User> getUsersByNameOrCity(String name, String city);

}
