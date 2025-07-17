package com.abstractEx;

public class Marine extends Unit {
	/*
	int x, y;
	void move (int x, int y) {}
	void stop () {}
	*/
	void SteamPack() {}
	
	@Override
	void move(int x, int y) {
		System.out.println("x : "+x+ " y : "+y);
	}
}
