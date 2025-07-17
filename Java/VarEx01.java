package com.variable;
	/* 변수와 상수의 개념
	 * 	
	 *	변수 : 상수를 저장하거나 보관하는 공간 (메모리)
	 * 	상수 : 항상 동일한 의미의 가치를 가지는 개체
	 * 	
	 *	변수명 : 변수에 대한 특정 이름 (이름을 지정한다 생각)
	 *	자료형 : 변수의 크기를 미리 만들어 놓은 크기의 약속
	 *	
	 *	기본 자료형과 참조 자료형
	 *	
	 *	기본 자료형
	 *		자바 컴파일러에 의해서 해석되는 자료형
	 *		기본 자료형 : 8개 
	 *		(byte, short, int, long, float, double, boolean, char)
	 *		
	 *		1byte, 2byte (boolean, char)
	 *		정수
	 *		1bytem 2byte, 4byte, 8byte(byte, short, int, long)
	 *		실수
	 *		4byte, 8byte (float, double)
	 *
	 *	참조 자료형 (referece data type)
	 *		- 자바 API (Application Programming interface)
	 *		  프로그래머에 의해서 만들어진 클래스를 자료형으로 선언하는 경우 (배열, 클래스) 

	 */

class AA {
	int a;
}
public class VarEx01 {

	public static void main(String[] args) {
		
		AA a; //클래스
		a = new AA();
		a.a=10;
		
		int[]aa = new int[3]; //배열
		aa[0] = 10;
		aa[1] = 10;
		aa[2] = 10;
		
		for(int i = 0; i < aa.length; i++) {
			System.out.println(aa[i]);
			
		}
	}

}
