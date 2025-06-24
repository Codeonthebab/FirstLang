package com.abstractEx;

public class AbstractExam {

	public static void main(String[] args) {
		Unit [] u = new Unit [4];
		u[0] = new Marine();
		u[1] = new Siz();
		u[2] = new Marine();
		u[3] = new DropShip();
		
		for (int i = 0; i < u.length; i++) {
			u[i].move(100, 200);
		}
		
	}

}
