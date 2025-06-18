package com.exam;
/*
*  [문 6] 
*   더하기, 빼기, 곱하기, 나누기를 수행하는 클래스를 만들어 각 클래스 마다 int 타입의 a, b 라는 
*   2개의 필드 를 갖으며 피연산자 값을 각 객체 내의 메소드를 이용하여 저장한다.
*   int calculate()메소드는 연산을 수행하고 결과를 리턴하는 메소드
*
*	main()메소드에서는 두 정수와 연산자를 입력받고 Add, Sub, Mul, Div 이 중 연산을 수행할 수 있는 
*	객체를 생성하고, setValue()메소드와 calculate() 메소드를 호출하여 결과를 출력하도록 실행하시오.
*
*	[실행결과]
*	두 정수와 연산자 입력 : 5 7 +
*	5 + 7 = 12
*	     
*/
public class Exam04Mul {
	
	private int a;
	private int b;
	
	public void setValue (int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int calculate () {
		return a*b;
	}
		
}
