package com.gaming;
import java.util.*;
public class WordGameApp {
	
	private Player [] player;
	private String startWord = "아버지";
	
	Scanner sc = new Scanner(System.in);
	
	public void run() {
		System.out.print("시작 인원은 ? ==> ");
		int startPeople = sc.nextInt();
		player = new Player [startPeople];
		
		System.out.print("참가자 이름은? ==> ");
		for (int i = 0; i < player.length; i++) {
			System.out.print((i+1)+"번째 이름 ==> ");
			String name = sc.next();
			player [i] = new Player (name);
		}
		System.out.println("선수 입장");
		System.out.println("끝말잇기 시작은 [" +startWord+ "] 입니다.");
		
		String StartingWord = startWord ;
		
		while (true) {
			
			for (int i = 0; i < player.length; i++ ) {
				Player user = player [i];
				String inputWord = user.getWordFromUser();
				
				char lastChar = StartingWord.charAt(StartingWord.length()-1);
				char firstChar = inputWord.charAt(0);
				
				if (lastChar != firstChar) {
	                System.out.println(user.getName() + "님이 졌습니다.");
	                return; // run() 메소드를 완전히 종료시켜 게임을 끝냄
	            }
				StartingWord = inputWord;	
	            }
			}
		}	
	
	public void checkSuccess() {
		
        }
	}

