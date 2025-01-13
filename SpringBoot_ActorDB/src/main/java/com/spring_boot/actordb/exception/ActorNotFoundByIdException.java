package com.spring_boot.actordb.exception;

public class ActorNotFoundByIdException extends RuntimeException {
	private final String message;

	public ActorNotFoundByIdException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
