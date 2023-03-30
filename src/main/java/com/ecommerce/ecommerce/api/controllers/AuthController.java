package com.ecommerce.ecommerce.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.bussiness.abstracts.AuthService;
import com.ecommerce.ecommerce.core.utilities.results.Result;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService){
		super();
		this.authService = authService;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody String username,@RequestBody String password) {
		return this.authService.login(username, password);
	}
	
	@PostMapping("/register")
	public Result register(){
		return null;
	}
}
