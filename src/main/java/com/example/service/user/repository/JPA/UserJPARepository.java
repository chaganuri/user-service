package com.example.service.user.repository.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.service.user.model.User;
import com.example.service.user.repository.custom.UserRepositoryCustom;

public interface UserJPARepository extends JpaRepository<User, Long>{
	
	//Method Implementation by keywords and properties
	public List<User> findByName(String name);
	
	//Named Query defined in User Entity
	public List<User> findByNameLower(String name);
	
	//Defining the Query
	@Query("SELECT u FROM User u WHERE LOWER(u.address) = LOWER(:address)")
    public List<User> findByLocation(@Param("address") String address);


}
