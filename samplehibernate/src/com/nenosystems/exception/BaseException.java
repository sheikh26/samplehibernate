package com.nenosystems.exception;

public class BaseException extends Exception {

	private String messageKey = null;

	public BaseException() {
		this("exception.undefined");
	}

	public BaseException(String messageKey) {

		this.messageKey = messageKey;

	}

	/**
	 * @return the messageKey
	 */
	public String getMessageKey() {
		return messageKey;
	}

	/**
	 * @paparam messageKey
	 *            the messageKey to set
	 */
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

}
