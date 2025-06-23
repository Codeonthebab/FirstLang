package com.polymorphism;

public class Dog extends Animal {
	private String name; 
	public Dog () {
		name = getClass().getSimpleName();
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String Scream() {
		return "깨깽~ 깽깽 ~" ;
	}
	
}
