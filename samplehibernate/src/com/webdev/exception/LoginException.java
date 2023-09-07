package com.webdev.exception;

public class LoginException extends Exception {
	
	public LoginException() {
		super("login.invalid.user");

	}
	
	public LoginException(String messageKey) {
		super(messageKey);

	}
}
