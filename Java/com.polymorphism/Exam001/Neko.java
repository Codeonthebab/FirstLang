package com.polymorphism;

public class Neko extends Animal {
	private String name;
	
	public Neko () {
		name = getClass().getSimpleName();
	}
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String Scream() {
		
		return "냐오오오옹" ;
	}
}
