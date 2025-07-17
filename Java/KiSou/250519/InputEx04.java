package com.ioex;
//  문자 하나 이상일 때를 문자열로 처리
/* 
 * InputStreamReader is = new InputStreamReader(System.in);
 * BufferedReader br = new BuferredReader(is)
 * 		 String name = br.readLine();
 * 
 * 
 */
import java.io.*;
public class InputEx04 {

	public static void main(String[] args) throws IOException {
		
		String name;
		String age;
		String addr;
		String tel;
		
		// 객체생성
		
	/*	InputStreamReader is = new InputSteamReader(System.in);
	*	bufferedReader br = new bufferedReader(is);
	*/
		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름 입력 : ");
		name=br.readLine();
		System.out.print("나이 입력 : ");
		age=br.readLine();
		System.out.print("주소 입력 : ");
		addr=br.readLine();
		System.out.print("전화번호 입력 : ");
		tel =br.readLine();
		
		// 출력 처리
		
		System.out.println("나의 이름은 "+name+"이고,\n 나이는 "
		+age+"세, \n주소는 "+addr+"이며, 전화 번호는"+tel+"입니다.");
	}
}
