package com.exam;
import java.util.*;
/*
*  [문 6] 
*   더하기, 빼기, 곱하기, 나누기를 수행하는 클래스를 만들어 각 클래스 마다 int 타입의 a, b 라는 
*   2개의 필드 를 갖으며 피연산자 값을 각 객체 내의 메소드를 이용하여 저장한다.
*   int calculate()메소드는 연산을 수행하고 결과를 리턴하는 메소드
*
*	main()메소드에서는 두 정수와 연산자를 입력받고 Add, Sub, Mul,Div 이 중 연산을 수행할 수 있는 
*	객체를 생성하고, setValue()메소드와 calculate() 메소드를 호출하여 결과를 출력하도록 실행하시오.
*
*	[실행결과]
*	두 정수와 연산자 입력 : 5 7 +
*	5 + 7 = 12
*	     
*/
public class Exam04 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in); 
		
		System.out.print("두 정수와 연산자 입력 : ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		char ca = sc.next().charAt(0);
		
		switch (ca) {
		case '+' :
			Exam04Add add = new Exam04Add();
			add.setValue(n1, n2);
			System.out.printf("%2d + %2d = %2d", n1, n2, add.calculate());
			break;
		case '-' :
			Exam04Sub sub = new Exam04Sub();
			sub.setValue(n1, n2);
			System.out.printf("%2d + %2d = %2d",n1, n2, sub.calculate());
			break;
		case '*' :
			Exam04Mul mul = new Exam04Mul();
			mul.setValue(n1, n2);
			System.out.printf("%2d + %2d = %2d",n1, n2, mul.calculate());
			break;
		case '/' :
			Exam04Div div = new Exam04Div();
			div.setValue(n1, n2);
			System.out.printf("%2d + %2d = %2d",n1, n2,div.calculate());
			break;
		}
		sc.close();
	}
}