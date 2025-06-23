package com.ioex;
import java.io.*;
public class InputEx01 {

	public static void main(String[] args) throws IOException{
		// 예외 전가 : 실행할 때 실행 메소드가 알아서 처리하게끔 위임
		// (*에러가 발생했다면 알아서 처리하도록 시키는 것)		
		// throws -> 예외 전가 메소드 가로 뒤에 처리해야함
		// 아스키 코드값 출력 때 사용할 수 있다
		
	try {
		// 아스키 코드 값을 입력 받아서 처리하는 명령어
		
		System.out.print("문자 입력 :");
		int i = System.in.read();
		System.out.println();
		System.out.println("ASCII 코드 값 :" +i);
		
	} catch (IOException e) {
		e.printStackTrace(); // (*error가 발생하면 이것을 출력해라)
	}
	}

}
