package com.spring_boot.actordb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_boot.actordb.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
	//save()
	//delete()
	//findById()
	//findAll()
	//deleteById()

}
