package com.ecommerce.ecommerce.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.entities.concrete.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User findByUsername(String username);

	User findByUserId(Integer id);	
}
