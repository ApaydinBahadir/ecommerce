package com.ecommerce.ecommerce.core.utilities.results;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Result {
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		super();
		this.success = success;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
}
