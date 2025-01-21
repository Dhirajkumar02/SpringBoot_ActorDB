package com.spring_boot.actordb.seviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot.actordb.entity.Actor;
import com.spring_boot.actordb.exception.ActorNotFoundByIdException;
import com.spring_boot.actordb.repository.ActorRepository;
import com.spring_boot.actordb.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {
	@Autowired
	private ActorRepository actorRepository;

	@Override
	public Actor addActor(Actor actor) {
		return actorRepository.save(actor);
	}

	@Override
	public List<Actor> findAllActors(){
		List<Actor> actors = actorRepository.findAll();

		if (actors.isEmpty()) {
			return null;
		} else {
			return actors;
		}

	}

	@Override
	public Actor deleteActorById(int actorId) {
		// Using Lambda Expression
//		return actorRepository.findById(actorId)
//		.map(actor -> {
//				actorRepository.delete(actor);
//				return actor;
//		}).orElseThrow( () -> new RuntimeException("Failed to find User"));
		
//		.ifPresentOrElse(actor -> actorRepository.delete(actor), () -> {
//				throw new RuntimeException("Failed to find User") }));
		
		// 1st ways
//		if (actorRepository.existsById(actorId)) {
//			actorRepository.deleteById(actorId);
//			System.out.println("Actor Data Deleted Successsfully!");
//		} else {
//			throw new RuntimeException("Actor not found with ID: " + actorId);
//		}
		
		// 2nd Way i.e Functional ways
		Optional<Actor> optional = actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor actor = optional.get();
			actorRepository.delete(actor);
			
			return actor;
		}else {
			throw new RuntimeException("Actor not found with ID: " + actorId);
		}
	}

	@Override
	public Actor updateActorById(Actor actor) {
		Optional<Actor> optional = actorRepository.findById(actor.getActorId());
		if(optional.isPresent()) {
			Actor exActor = optional.get();
			exActor.setActorName(actor.getActorName());
			exActor.setAge(actor.getAge());
			exActor.setIndustry(actor.getIndustry());
			exActor.setNationality(actor.getNationality());
			
			return actorRepository.save(exActor);
		}else {
			throw new RuntimeException("Failed to update Actor");
		}
		
	}

	@Override
	public Actor findActorById(int actorId) {
//		System.err.println("Finding actor by Id "+actorId);
//		return actorRepository.findById(actorId).orElseThrow( () -> new RuntimeException("Failed to find User"));
		
		Optional<Actor> optional = actorRepository.findById(actorId);
		
		if (optional.isPresent()) {
			Actor actor = optional.get();
			return actor;
		} else {
			throw new ActorNotFoundByIdException("Failed to find Actor");
		}
	}

	@Override
	public List<Actor> findByActorName(String actorName) {
		List<Actor> actors = actorRepository.findByActorName(actorName);
		if(actors.isEmpty()) {
			return null;
		}
		return actors;
	}

}
