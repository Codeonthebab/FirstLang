package com.list;

import java.util.Stack;

public class StackEx01 {
	
	public static Stack back = new Stack () ;
	public static Stack forward = new Stack ();
	
	public static void goURL (String url) {
		back.push(url);
		
		if(!forward.empty()) {
			forward.clear();
		}
	}
	
	public static void goBack () {
		if (!forward.empty()) {
			back.push(forward.pop());
		}
	}
	
	public static void goForward () {
		if (!back.empty()) {
			forward.push(back.pop());
		}
	}
	
	public static void main(String[] args) {
		goURL("https://www.naver.com");
		goURL("https://www.google.jp");
		goURL("https://www.yahoo.jp");
		goURL("https://www.aliExpress.cn");
		
		printStatus();
		goBack();
		System.out.println("=== 뒤로 가기 버튼을 누른 후 ===");
		printStatus();
		
		goForward();
		System.out.println("=== 앞으로 가기 버튼을 누른 후 ===");
		printStatus();
		
		goForward();
		System.out.println("=== 앞으로 가기 버튼을 누른 후 ===");
		printStatus();
	}

	public static void printStatus () {
		System.out.println("back : " +back );
		System.out.println("forward : "+forward);
		System.out.println("현재 화면은 "+back.peek()+" 입니다.");
		System.out.println();
		
		
	}
}
