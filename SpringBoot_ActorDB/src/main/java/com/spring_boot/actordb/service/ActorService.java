package com.spring_boot.actordb.service;

import java.util.List;

import com.spring_boot.actordb.entity.Actor;

public interface ActorService {
	
	public Actor addActor(Actor actor);

	public List<Actor> findAllActors();
	
	public Actor updateActorById(Actor actor);

	public Actor findActorById(int actorId);
	
	public Actor deleteActorById(int actorId);
	
	public List<Actor> findByActorName(String actorName);

}
