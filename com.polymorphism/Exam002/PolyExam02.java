package com.polyexam;

public class PolyExam02 {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new ComPuter());
		b.buy(new Audio());
		
		b.summary();

	}

}
