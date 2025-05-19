package com.ioex;
import java.io.*;
public class InputEx02 {

	public static void main(String[] args) throws IOException{
		System.out.print("문자 입력 : ");
		char ch = (char) System.in.read(); 
		// char ch = (char) *문자 출력을 위한 char 활용
		// System.in.read(); 로 입력 받은 값을 정수 값 그대로 활용하기 위함
		
		// [* System.in.read();는 아스키 코드 출력 관련]
		// 문자를 출력 시킬 때 오류가 발생했을 경우.
		// throws IOException{ } 을 활용하여 
		// Java 버츄얼 머신에 오류 교정을 맡긴다
		
		System.out.println(ch);
		
	}

}
