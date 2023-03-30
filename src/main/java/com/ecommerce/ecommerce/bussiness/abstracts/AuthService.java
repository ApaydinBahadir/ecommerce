package com.ecommerce.ecommerce.bussiness.abstracts;

import com.ecommerce.ecommerce.core.utilities.results.Result;

public interface AuthService {
	public String login(String username, String password);

	public Result register(String username, String password);
}
