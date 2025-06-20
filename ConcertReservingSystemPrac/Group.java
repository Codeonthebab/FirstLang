package com.concertExam;
import java.util.Scanner;

public class Group {
	// 'S' , 'A' , 'B' 석을 나타내는 문자
	private char type;
	// 현재 등급의 좌석 객체 배열 선언
	private Seat[] seats;
	private Scanner sc = new Scanner (System.in);
	
	public Group (char type, int num) {
		this.type = type;
		seats = new Seat[num]; // 시트는 넘버만큼 초기화 시킴
		
		for (int i=0; i<seats.length; i++) {
			seats [i] = new Seat(); // 시트를 생성하는 배열 
		}
	}
	
	// 현재 등급의 좌석 예약 메소드
	public boolean reserve () {
		int no;
		String name;
		show();
		
		System.out.print("이름 : ");
		name = sc.next();
		System.out.print("번호 : ");
		no = sc.nextInt();
		
		if (no < 1 || no >= seats.length) {
			System.out.println("잘못된 좌석 번호 입니다.");
			return false;
		}
		if (seats[no - 1].isOccupied()) { // 이미 좌석이 예약되어 있을 경우 표기
			System.out.println("예약된 좌석 번호 입니다.");
			return false;
		}
		// 이름으로 예약
		seats[no - 1].reserve(name);
		return true;
	}
	// 현재 등급의 좌석 예약취소 메소드
	public boolean cancel () {
		show();
		System.out.print("취소할 분의 이름 : ");
		String name = sc.next();
		if (name != null) {
			for (int i = 0; i < seats.length; i++) {
				if (seats[i].match(name)) {
					seats[i].cancel();
					return true;
				}
			}
			System.out.print("예약자 이름을 찾을 수 없습니다.");
		}
		return false;
	}
	// 현재 등급의 좌석 출력
	public void show () {
		System.out.print(type+ " >> ");
		for (int i = 0; i < seats.length; i++) {
			if (seats[i].isOccupied()) { // 예약이 완료 되었을 경우
				System.out.print(seats[i].getName());
			} else { // 예약자가 없는 경우
				System.out.print("---");
			}
		}
		System.out.println();
	}
}