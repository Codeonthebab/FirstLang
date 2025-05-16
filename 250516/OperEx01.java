package com.operex;

public class OperEx01 {

	public static void main(String[] args) {
		int x=10;
		int y=++x; //선 연산 후 대입
		// x++ -> 선 대입 후 연
		System.out.println("x :"+ x);
		System.out.println("y :"+ y);
	}

}
