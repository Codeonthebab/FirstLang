package com.polyexam;

public class Tv extends ProDuct {

	public Tv() {
		// 부모 클래스의 생성자를 호출한거임
		super(100); // 100만원 선언!
	}
	
	@Override
	public String toString () {
		return "Tv";
	}

}
