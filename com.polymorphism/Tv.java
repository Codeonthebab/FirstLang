package com.polymorphism;
/*
 * 	[다형성 : polymorphism]
 * 	  (1) 여러 가지 형태를 가질 수 있는 능력을 의미함
 * 	  (2) 자바에서는 한 타입의 참조 변수로 
 * 		  여러 타입의 객체를 참조할 수 있도록 함으로써 다형성을 구현한다.
 * 	  (3) 
 * 
 * 	- 조상 클래스의 참조 변수로 자손 클래스의 인스턴스를 참조할 수 있도록 하는 것
 * 
 */
public class Tv {

	boolean power;
	int channel;
	
	void power () { power = !power; }
	void channelUp () { ++channel; }
	void channelDown () { --channel; }
}
