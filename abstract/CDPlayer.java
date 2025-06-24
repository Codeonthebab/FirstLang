package com.abstractEx;

public class CDPlayer extends Player {
	
	@Override
	void play(int pos) {
		// TODO Auto-generated method stub
		
	}
	public CDPlayer() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	void stop () {
	}
	
	int currentTrack;
	
	void nextTrack() {
		currentTrack++;
	}
	
	void preTrack () {
		if(currentTrack > 1) {
			currentTrack --;
		}
	}
}
