package com.spring_boot.actordb.exception;

public class ActorsNotFoundException extends RuntimeException {
	private final String message;

	public ActorsNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
