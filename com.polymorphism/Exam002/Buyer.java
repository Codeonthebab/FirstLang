package com.polyexam;
import java.util.Vector;

public class Buyer { // 고객 : 물건을 사는 사람
	int money = 1000; // 천만원 소지 중
	int bonusPoint = 0;
	// 구입한 제품을 저장하기 위한 예열 선언
	// ProDuct[] item = new ProDuct [10];
	// int i = 0;
	// 구입한 제품을 저장하는 사용할 Vector 객체를 선언
	Vector <ProDuct> item = new Vector<>();
	// Vector <Object> item = new Vector<>(); 로 쓸 수도 있다.
	
	
	public void buy (ProDuct p) { //프로덕트로 만든 클래스. 매개변수의 다형성
		
		if (money < p.price) {
			System.out.println("잔액이 너무나 부족하여 물건을 구매할 수 없습니다.");
			return ;
		}
		// 가지고 있는 돈이 구입한 제품 가격보다 많은 경우
		// 제품을 구매하고 소유한 돈은 차감된다
		
		// 가지고 있는 돈에서 제품 가격을 뺀다
		money -= p.price;
		// 제품 보너스 포인트를 추가한다
		bonusPoint += p.bonusPoint;
		//item[i++] = p;
		item.add(p); // 구매한 제품을 Vector에 저장함
		System.out.println(p+ "을(를) 구입 하셨습니다.");
	}
	
	// 구매한 제품이 불량 또는 마음에 안든 경우, 환불 처리하는 기능
	public void refund (ProDuct p) {
		if (item.remove(p)) { // 구매한 제품을 Vector에서 제거함
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을/를 반품 하셨습니다. ");
			// 환불에 성공한 경우
		} else { // 환불에 실패한 경우
			System.out.println("구매한 제품 중 해당 제품이 존재하지 않습니다.");
		}
	}
	

	// 구매한 물품에 대한 정보를 요약해 줌
	public void summary() {
		// 구입한 물품의 가격 합계
		int sum = 0;
		// 구입한 물품 목록
		String itemList = "";
		
		if (item.isEmpty()) { // item.isEmpty() == null 이랑 같은 메소드
			System.out.println("구매한 제품이 존재하지 않습니다.");
			return;
		}
		
		// 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만듦
		/* 객체 배열에 사용한 반복문
		for (int i = 0; i<item.length; i++) {
			if (item [i] == null) break;
			sum += item[i].price;
			// itemList += item[i]+", "; // ,도 반복문 안에 추가되서 제거하기 위한 명령문
			itemList += (i==0) ? ""+item[i] : ", "+ item[i];
		}
		*/
		for (int i = 0; i<item.size(); i++) {
			ProDuct p = item.get(i);
			sum += p.price;
			itemList += (i==0) ? ""+p : ", "+ p;
		}
		
		System.out.println("구입하신 물품의 총 금액은 "+sum+ "만원 입니다. ");
		System.out.println("구입한신 제품은 "+itemList+ " 입니다.");
	}
}