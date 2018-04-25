package com.revature.oop;

public class Cat extends Animal implements Domestic {

	@Override
	String makeNoise() {
		return "meow";
	}

	@Override
	public void pet() {
		System.out.println("petting cat");
		
	}

}
