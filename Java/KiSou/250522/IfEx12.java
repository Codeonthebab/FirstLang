package com.condition;
import java.util.*;

/* [문]
 * 		사용자로부터 알파벳 한 문자를 입력받고, 
 * 		입력받은 알파벳이 모음일 경우만 출력하는 프로그램을 구현하시오.
 * 		
 * 		단, 대소문자 모두를 적용하도록 한다.
 * 		또한, 알파벳 이외의 문자가 입력되면 입력 오류를 출력한다.
 * 		[알파벳 모음 : a, e, i, o, u]
 * 
 *  [출력물]
 *  	알파벳 한 문자입력 : A
 *  	==> 모음 OK
 *  
 *  [출력물2]
 *  	알파벳 한 문자입력 : B
 *  	==> 
 *  
 *  [출력물3]
 *  	문자입력 : 1
 *  	==> 입력 오류!
 *
 */
public class IfEx12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char moum;
		
		System.out.print("알파벳 한 문자입력 : ");
		moum = sc.next().charAt(0);
	
		if((moum >= 'A' && moum <= 'Z')||(moum >=97 && moum  <= 122)) {
			if ((moum == 'a'||moum == 'i'||moum == 'u'||moum == 'e'||moum == 'o')) 
				System.out.println("== > 모음 OK");
			else  
			System.out.println("==> ");
		} else {
			System.out.println("==> 입력 오류!");
		} sc.close();
	}
}
	/*	
	if ((moum == 'a')||(moum == 'i')||(moum == 'u')||(moum == 'e')||(moum == 'o')||(moum == 'A')||(moum == 'I')||(moum == 'U')||(moum == 'E')||(moum == 'O')) {
		System.out.println("==> 모음 OK");
	} else if ((moum == 'b')||(moum == 'c')||(moum == 'd')||(moum == 'f')||(moum == 'g')||(moum == 'h')||(moum == 'j')||(moum == 'k')||(moum == 'l')||(moum == 'm')||(moum == 'n')||(moum == 'p')||(moum == 'q')||(moum == 'r')||(moum == 's')||(moum == 't')||(moum == 'v')||(moum == 'x')||(moum == 'y')||(moum == 'z')||(moum == 'B')||(moum == 'C')||(moum == 'D')||(moum == 'F')||(moum == 'G')||(moum == 'H')||(moum == 'J')||(moum == 'K')||(moum == 'L')||(moum == 'M')||(moum == 'N')||(moum == 'P')||(moum == 'Q')||(moum == 'R')||(moum == 'S')||(moum == 'T')||(moum == 'V')||(moum == 'X')||(moum == 'Y')||(moum == 'Z')) {
		System.out.println("==> ");
	} else
		System.out.println("==> 입력 오류!");
	sc.close();
	*/