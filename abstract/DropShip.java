package com.abstractEx;

public class DropShip extends Unit{
	
	void load () {}
	void unload () {}
	
	@Override
	void move(int x, int y) {
		System.out.println("x : "+x+ " y : "+y);
	}
	
}
