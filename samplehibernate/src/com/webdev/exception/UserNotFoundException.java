package com.webdev.exception;

public class UserNotFoundException extends BaseException {
	
	public UserNotFoundException() {
		super("login.invalid.user");

	}
	
	public UserNotFoundException(String messageKey) {
		super(messageKey);

	}
}
