package com.list;
import java.util.*;
public class HashMapEx02 {

	public static void main(String[] args) {
		HashMap <String, String> map = new HashMap <> ();
		map.put("admin", "1234");
		map.put("asdf", "1111");
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("id와 password를 입력해줏쎄요.");
			System.out.print("ID : ");
			String id = sc.nextLine().trim();
			System.out.print("PW : ");
			String pw = sc.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("입력하신 ID는 존재하지 않습니다. 다시 입력해주세요.");
				continue;
			}
			if (!map.get(id).equals(pw)) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			} else {
				System.out.println("해당 ID로 로그인 하셨습니다.");
				break;
			}
		}
	}
}
