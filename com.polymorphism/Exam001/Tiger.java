package com.polymorphism;

public class Tiger extends Animal {
	private String name;
	
	public Tiger () {
		name = getClass().getSimpleName();
	}
	@Override
	public String Scream() {
		// TODO Auto-generated method stub
		return "어흐흐흫ㅇ~ " ;
	}
	public String getName() {
		return name;
	}
	
}
