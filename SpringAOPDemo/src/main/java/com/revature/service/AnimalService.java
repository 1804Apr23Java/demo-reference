package com.revature.service;

public abstract class AnimalService {
	
	//how fast is the animal?
	public abstract int getSpeed();
	
	//is the animal hungry?
	public abstract Boolean isFull();
	public abstract void setFull(Boolean full);
	
	//what happens if you upset the animal
	public abstract void animalChasesYou();
	
	public void animalCatchesYou() {
		System.out.println("Hope it's not hungry.");
	}

}
