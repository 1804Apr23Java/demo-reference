package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //not autowiring!! Just defining my bean with annotations
public class AutowiredBear extends Bear {

	@Autowired
	private Cave cave;
	
	@Override
	public Cave getCave() {
		return this.cave;
	}
	
	@Override
	public void methodInBear() {
		System.out.println("method in AutowiredBear. this bear is: " + this.toString());
		System.out.println("cave: " + cave.toString());
		
	}

}
