package com.excp;
/*
 * 	[예외 처리] 
 * 	정의 : 프로그램 실행 시 발생할 수 있는 예외에 대비한 코드를 작성하는 것
 * 	목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행 상태를 유지하는 것
 * 	
 * 	[예외를 처리하기 위한 try ~ catch 문]
 * 	try {
 *	// 예외가 발생할 가능성이 있는 코드를 작성
 *	} catch (Exception e1) {
 *	// Exception e1의 오류가 발생했을 경우 이를 처리하기 위한 코드를 작성
 *	} catch (Exception e2) {
 *	// Exception e2의 오류가 발생했을 경우 이를 처리하기 위한 코드를 작성
 *	}
 */
public class ExceptionEx03 {
	public static void main (String [] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch (ArithmeticException ae) {
			if (ae instanceof ArithmeticException) {
				System.out.println("true");
			}
			System.out.println(5);
		}
		catch (Exception e) {
			//e.printStackTrace();
			//System.out.println(e.getMessage());
			/*
			 *   printStackTrace();
			 *   - 예외 발생 당시의 호출 스택에 있었던 메소드 정보와
			 *     예외 메시지를 화면에 출력함
			 *   getMessage(); 
			 *   - 발생한 예외 클래스의 인스턴스에 저장된 메시지를 가져온다
			 *   
			 */
			System.out.println(e.getMessage());
		}
		System.out.println(6);
	}
}
