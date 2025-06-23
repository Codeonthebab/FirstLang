package com.polymorphism;
class A {
	private int x = 100;
	private int y = 200;
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void disp() {
		System.out.println("x : " +x+ ", y :" +y);
	}
}

class B extends A{
	private int y = 300;
	private int z = 400;
	
	public void setY(int y) {
		this.y = y;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
	@Override // 명시적으로 써주는게 좋다(?)
	public void disp () {
		super.disp();
		System.out.println("y : "+y+", z: "+z);
	}
}

public class ABtest {

	public static void main(String[] args) {
		A a = new B();
		a.disp();
		System.out.println();
		a.setX(1);
		a.disp();
		System.out.println();
		
		a.setY(2); // y값은 A클래스와 B클래스 모두 가지고 있기 때문에
		// 오버라이딩 규칙에 의거하여 B 클래스 setY()메소드가 실행된다
		a.disp();
		
		//a.setZ(3);
		B b = new B();
		b.setZ(3);
		b.disp();
		}
}
