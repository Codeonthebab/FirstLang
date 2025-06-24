package com.polyexam;

public class PolyExam03 {

	public static void main(String[] args) {

		Buyer b = new Buyer ();
		
		Tv tv = new Tv() ;
		ComPuter c = new ComPuter();
		Audio au = new Audio ();
		
		b.buy(tv);
		b.buy(c);
		b.buy(au);
		b.summary();
		System.out.println();
		
		b.refund(au);
		b.summary();
		
		
	}
}