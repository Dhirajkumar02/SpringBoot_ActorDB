package com.spring_boot.actordb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot.actordb.entity.Actor;
import com.spring_boot.actordb.exception.ActorNotFoundByIdException;
import com.spring_boot.actordb.service.ActorService;
import com.spring_boot.actordb.utility.ResponseStructure;

//@Controller
//@ResponseBody
@RestController
public class ActorController {

	@Autowired
	private ActorService actorService;
	// ActorService ac = new ActorServiceImpl();

//	private Map<String, Object> sendResponse(int status, String message, Actor data){
//		return Map.of(
//				"status", status,
//				"message", message,
//				"data", data
//
//				);
//	}

	//	@RequestMapping(value = "/actors" , method = RequestMethod.POST)
	@PostMapping("/actors")
	public ResponseStructure<Actor> addActor(@RequestBody Actor actor) {
		actor = actorService.addActor(actor);
		return ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", actor);

	}

	//	@RequestMapping(value = "/actors" , method = RequestMethod.GET)
	@GetMapping("/actors")
	public ResponseEntity<ResponseStructure<List<Actor>>>  findAllActors() {
		List<Actor> actors = actorService.findAllActors();
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.body(ResponseStructure.create(HttpStatus.FOUND.value(), "Actors Found", actors));

	}

	//	@RequestMapping(value = "/find-actors" , method = RequestMethod.GET)
	@GetMapping("/find-actor")
	public ResponseEntity<ResponseStructure<Actor>>  findActorById(@RequestParam int actorId) {
		Actor actor = actorService.findActorById(actorId);
//		ResponseStructure structure = ResponseStructure.create(HttpStatus.FOUND.value(), "Actor Found", actor);
//		return new ResponseEntity<ResponseStructure<Actor>>(structure, HttpStatus.FOUND);
		
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.create(HttpStatus.FOUND.value(), "Actor Found", actor));
	}

	// 1st approach to handle exception
	//	@ExceptionHandler
	//	public String handleActorNotFoundByIdException(ActorNotFoundByIdException ex) {
	//		return ex.getMessage();
	//	}
	//	
	//	@ExceptionHandler
	//	public Map<String, Object> handleActorNotFoundByIdException(ActorNotFoundByIdException ex){
	////		Map<String, Object> response = new HashMap<String, Object>();
	////		response.put("status", 404);
	////		response.put("message", ex.getMessage());
	////		response.put("rootCause", "Actor not found by the given id");
	////		return response;
	//		
	//		return Map.of(
	//				"status", 404,
	//				"message", ex.getMessage(),
	//				"rootCause", "Actor not found by the given Id"
	//				);
	//	}


	//	@RequestMapping(value = "/actors" , method = RequestMethod.PUT)
	@PutMapping("/update-actor")
	public ResponseStructure<Actor> updateActorById(@RequestBody Actor actor) {
		actor = actorService.updateActorById(actor);
		return ResponseStructure.create(HttpStatus.FOUND.value(), "Actor Updated", actor);
	}

	//	@RequestMapping(value = "/actors" , method = RequestMethod.DELETE)
	@DeleteMapping("/actors")
	public ResponseStructure<Actor> deleteActorById(@RequestParam int actorId) {
		Actor actor = actorService.deleteActorById(actorId);
		return ResponseStructure.create(HttpStatus.OK.value(), "Actor Deleted", actor);

	}
	
	@GetMapping("/actors/name")
	public List<Actor> findByActorName(String actorName) {
		return actorService.findByActorName(actorName);
	}


}
