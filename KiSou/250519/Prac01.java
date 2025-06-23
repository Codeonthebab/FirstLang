package com.ioex;
import java.util.*;
public class Prac01 {
/* 사용자에게 정보를 받을 예정,
 * 생산자, 나이, 공급 도시, 공급 예정에 대해 물어볼 것
 * 맞는지 안 맞는지 확인까지 받을 것
 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		
		String name, city;
		int c;
		boolean supply;
		
		System.out.print("생산자 : ");
		name = sc.next();
		System.out.print("나이 : ");
		c = sc.nextInt();
		System.out.print("도시 : ");
		city = sc.next();
		System.out.println("공급 예정? : (True/False)");
		supply = sc.nextBoolean();

		System.out.println("생산자는 "+name+"이며, 나이는 "+c+"입니다.");
		System.out.println("도시는 "+city+"이며, 공급 예정은 "+supply+"입니다.");
		System.out.println("맞으면 True/ 아니면 False를 입력해주세요.");
		
		
		
		System.out.println(" (True/False)");
		supply = sc.nextBoolean();
			
	}

}
