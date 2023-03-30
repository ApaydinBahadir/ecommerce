package com.ecommerce.ecommerce.bussiness.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.bussiness.abstracts.AuthService;
import com.ecommerce.ecommerce.bussiness.abstracts.UserService;
import com.ecommerce.ecommerce.core.utilities.results.ErrorResult;
import com.ecommerce.ecommerce.core.utilities.results.Result;
import com.ecommerce.ecommerce.core.utilities.results.SuccessResult;
import com.ecommerce.ecommerce.entities.concrete.Role;
import com.ecommerce.ecommerce.entities.concrete.User;
import com.ecommerce.ecommerce.security.JwtTokenProvider;

@Service
public class AuthManager implements AuthService {

	private AuthenticationManager authenticationManager;

	private JwtTokenProvider jwtTokenProvider;

	private UserService userService;

	@Autowired
	public AuthManager(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider,
			UserService userService) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.userService = userService;
	}

	@Override
	public String login(String username, String password) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
		Authentication auth = authenticationManager.authenticate(authToken);
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwtToken = jwtTokenProvider.generateJwtToken(auth);
		return "Bearer " + jwtToken;

	}

	@Override
	public Result register(String username, String password) {
		if(userService.findByUsername(username) != null)
			return new ErrorResult("This username exists");
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		user.setRole(Role.normalUser);
		return new SuccessResult("This user registered");
	}

}
