package com.example.service.user.repository.CRUD;

import org.springframework.data.repository.CrudRepository;

import com.example.service.user.model.User;

public interface UserCRUDInterface extends CrudRepository<User, Long>{

}
