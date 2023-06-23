package com.nenosystems.exception;


public class ModuleNotFoundException extends BaseException {
	
	public ModuleNotFoundException() {
		super("module.invalid");

	}
	
	public ModuleNotFoundException(String messageKey) {
		super(messageKey);

	}
}
