package com.abstractEx;

public interface Fightable extends Movable, Attackable{

@Override
default void attack(Unit u) {
	// TODO Auto-generated method stub	
}

@Override
	default void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
