package com.ecommerce.ecommerce.bussiness.concrete;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.bussiness.abstracts.UserService;
import com.ecommerce.ecommerce.dataAccess.abstracts.UserDao;
import com.ecommerce.ecommerce.entities.concrete.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
