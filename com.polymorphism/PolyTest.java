package com.polymorphism;
import java.util.Scanner;

class MyPoint {
	private int x;
	private int y;
	
	protected static Scanner sc;
	
	static { // 모두 변형, 사용 가능
		sc = new Scanner (System.in);
	}
	protected MyPoint() {
		System.out.print("x : ");
		this.x = sc.nextInt();
		System.out.print("y : ");
		this.y = sc.nextInt();
	}
	protected void disp () {
		System.out.println();
		System.out.println("점 (x, y) : ("+x+", "+y+")");
	}
}

class circle extends MyPoint {
	private int r;
	
	public circle () {
		super();
		System.out.println("r : ");
		this.r = sc.nextInt();
	}
	
	protected void disp() {
		super.disp();
		System.out.println(" 반지름 r : " +this.r);
	}
}

class Rect extends MyPoint {
	private int w;
	private int h;
	
	public Rect () {
		super ();
		System.out.println("w : ");
		this.w = sc.nextInt();
		System.out.println("h : ");
		this.h = sc.nextInt();
	}
	
	protected void disp () {
		
		super.disp();
		System.out.println("가로 : "+this.w+ ", 세로 : "+this.h);
	}
}
/*
 *  	1. 10개의 도형을 입력 받는다
 *  	2. 그 도형은 원과 사각형 어느 것이어도 좋음
 *  	 	(*원을 6개 입력하고 사각형을 4개를 입력해도 됨)
 *  	3. 사용자가 원하는 도형을 입력할 수 있도록 한다
 *  	4. 입력받는 도중에 사용자가 현재까지 입력된 도형을
 *  	   보려는 경우 보여 주어야 한다
 *  	5. 언제든 프로그램은 종료할 수 있어야만 한다
 *  
 */
public class PolyTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		MyPoint [] mp = new MyPoint [10];
		for (int i = 0; i<mp.length; i++ ) {
			System.out.println();
			System.out.print("1. 원 2. 사각형 3. 보기 4. 종료 : ");
			int n = sc.nextInt();
			
			if (n == 1 ) {
				mp [i] = new circle () ;
			} else if (n  ==2) {
				mp [i] = new Rect () ;
			} else if (n == 3) {
				System.out.println();
				System.out.print(" ========== 보기 ===========");
				for (int j = 0; j < i; j++) {
					mp[j].disp();
				}
				System.out.println(" =========== 보기 ============");
				System.out.println();
				i--;
				// 보기일 경우 입력한 것이 아니므로 i 값을 증가된 것을 감소시킴
			} else if (n == 4) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}	
		System.out.println();
	}
}
