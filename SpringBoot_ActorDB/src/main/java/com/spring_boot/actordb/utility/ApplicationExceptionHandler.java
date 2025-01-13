package com.spring_boot.actordb.utility;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring_boot.actordb.exception.ActorNotFoundByIdException;
import com.spring_boot.actordb.exception.ActorsNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
//	private Map<String, Object> sendResponse(int status, String message, String rootCause){
//		return Map.of(
//				"status", status,
//				"message", message,
//				"rootCause", rootCause
//				);
//
//	}
//	// 1st approach to handle exception
//	//		@ExceptionHandler
//	//		public String handleActorNotFoundByIdException(ActorNotFoundByIdException ex) {
//	//			return ex.getMessage();
//	//		}
//
//	@ExceptionHandler
//	public Map<String, Object> handleActorNotFoundByIdException(ActorNotFoundByIdException ex){
//		//			Map<String, Object> response = new HashMap<String, Object>();
//		//			response.put("status", 404);
//		//			response.put("message", ex.getMessage());
//		//			response.put("rootCause", "Actor not found by the given id");
//		//			return response;
//
//		// Using static method
//		//		return Map.of(
//		//				"status", 404,
//		//				"message", ex.getMessage(),
//		//				"rootCause", "Actor not found by the given Id"
//		//				);
//
//		return this.sendResponse(404, ex.getMessage(), "Actor not found by the given Id");
//	}
//	
//	@ExceptionHandler
//	public Map<String, Object> handleActorsNotFound(ActorsNotFoundException ex){
//		 return this.sendResponse(404, ex.getMessage(), "Actors not present");
//	}

	
	@ExceptionHandler
	public ErrorStructure handleActorNotFoundById(ActorNotFoundByIdException ex) {
		return ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Actor not found by the given Id");
	}
	
	@ExceptionHandler
	public ErrorStructure handleActorNotFound(ActorsNotFoundException ex) {
		return ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Actors not Present");
	}

}
