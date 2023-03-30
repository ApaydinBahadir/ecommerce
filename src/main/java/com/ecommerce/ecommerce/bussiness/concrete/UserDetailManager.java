package com.ecommerce.ecommerce.bussiness.concrete;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dataAccess.abstracts.UserDao;
import com.ecommerce.ecommerce.entities.concrete.User;
import com.ecommerce.ecommerce.security.JwtUserDetails;

@Service
public class UserDetailManager implements UserDetailsService {

	private UserDao userDao;

	public UserDetailManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		return JwtUserDetails.create(user);
	}
	
	public UserDetails loadUserByUserId(Integer id) throws UsernameNotFoundException {
		User user = userDao.findByUserId(id);
		return JwtUserDetails.create(user);
	}

}
