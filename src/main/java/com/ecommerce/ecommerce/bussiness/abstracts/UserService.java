package com.ecommerce.ecommerce.bussiness.abstracts;

import com.ecommerce.ecommerce.entities.concrete.User;

public interface UserService{
	User findByUsername(String username);
}
