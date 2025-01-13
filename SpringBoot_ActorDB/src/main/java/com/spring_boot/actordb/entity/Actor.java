package com.spring_boot.actordb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int actorId;
	private String ActorName;
	private int age;
	private String industry;
	private String nationality;
	
	
	public int getActorId() {
		return actorId;
	}
	public String getActorName() {
		return ActorName;
	}
	public int getAge() {
		return age;
	}
	public String getIndustry() {
		return industry;
	}
	public String getNationality() {
		return nationality;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public void setActorName(String actorName) {
		ActorName = actorName;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

}
