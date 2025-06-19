package com.gaming;
/*
 * [문]
 * 	n명이 참가하는 끝말잇기 게임 프로그래밍을 구현하시오.
 * 	처음 단어는 '아버지'이며 n명의 참가자들은 순서대로 자신의 단어를 입력합니다.
 * 	끝말잇기에서 끝말이 틀린 경우 게임을 끝내고 게임에서 진 참가자를 화면에 출력한다
 * 	프로그램에서는 시간 지연을 구현하지 않아도 됩니다.
 * 	그렇지만 참가자들이 스스로 시간을 재보도록 하는 것도 좋겠다.
 * 	이 문제의 핵심은 여러개의 객체와 배열을 사용해보는 것이다.
 * 
 * [문제 풀이 참고사항]
 * 	main() 함수를 포함한 WordApp 클래스와 각 선수를 나타내는 Player 클래스를 작성하고,
 * 	실행 중에는 WordGameApp 객체 하나와 선수 숫자 만큼의 Player 객체를 생성하면 된다.
* 	
* 	실행은 run() 메소드 -> run() 메소드에선 선수 숫자만큼 Player 객체를 배열로 생성한다.
* 	Player 클래스는 게임 참가자의 이름 필드와 사용자로부터 단어를 입력받는 메소드 getWordFromUser()
* 	끝말잇기의 성공여부와 게임을 계속할 지를 판별하는 checkSuccess() 메소드를 구현한다.
* 
*  	문자열의 마지막 문자와 첫번째 문자는 다음과 같은 방법으로 알아 낼 수 있다.
*  
*  	String word = "아버지";
*  	int lastIndex = word.length()-1; // 마지막 문자에 대한 인덱스 형성
*  	char lastChar = word.charAt(lastIndex); // 마지막 문자
*  	char firstChar = word.charAt(0); //첫번째 문자 
 */
public class WordApp {

	public static void main(String[] args) {
		WordGameApp game = new WordGameApp();
		game.run();

	}
}
