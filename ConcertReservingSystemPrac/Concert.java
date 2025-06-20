package com.concertExam;
import java.util.Scanner;

public class Concert {
	private Scanner sc;
	private String hallname;
	private Group[] group = new Group[3];
	
	public Concert (String hallname) {
		sc = new Scanner(System.in); 
		this.hallname = hallname;
		group[0] = new Group('S', 10);
		group[0] = new Group('A', 10);
		group[0] = new Group('B', 10);
	}
	
	// 콘서트 예약
	public void reserve() {
		System.out.print("좌석구분 S(1), A(2), B(3) : ");
		int type = sc.nextInt();
		if (type < 1 || type > 3) {
			System.out.print( " 잘못된 좌석 타입 입력입니다. ");
			return ;
		}
		group [type-1].reserve();	
	}
	
	public void search () {
		for(int i = 0; i < group.length; i++) {
			group[i].show();
		}
		System.out.print(" <<<<<<< 조회를 완료하였습니다. >>>>>>> ");
	}
	
	public void cancel () {
		System.out.print("좌석구분 S(1), A(2), B(3) : ");
		int type = sc.nextInt();
		if (type < 1 || type > 3) {
			System.out.print( " 잘못된 좌석 타입 입력입니다. ");
			return ;
		}
		group [type-1].cancel();	
	}
	
	public void run () { // concert의 예약/취소/검색
		System.out.println(hallname + "예약 시스템 입니다.");
		int menu = 0;
		
		while (menu != 4) { 
			System.out.print("1: 예약, 2: 조회, 3: 취소 , 4: 종료 ");
			menu = sc.nextInt();
			
			switch (menu) {
			case 1 :
				reserve ();
				break;
			case 2 :
				search ();				
				break;
			case 3 :
				cancel ();				
				break;
			case 4 :
				System.out.println("프로그램을 종료합니다");
				break;
				default :
					System.out.println("잘못 입력하셨습니다. ");
			}
			
		}
	}
}
