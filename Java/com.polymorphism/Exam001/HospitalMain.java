package com.polymorphism;

public class HospitalMain {

	public static void main(String[] args) {
		Hospital h = new Hospital () ;
		Animal dog = new Dog ();
		Animal Neko = new Neko ();
		Animal tiger = new Tiger ();
		
		h.inject(dog);
		h.inject(Neko);
		h.inject(tiger);
	}
}