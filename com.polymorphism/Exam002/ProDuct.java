package com.polyexam;

public class ProDuct { // 제품 클래스
	int price; // 제품 가격
	int bonusPoint; // 제품 구매시 제공 보너스 점수
	
	public ProDuct () {
		price = 0;
		bonusPoint = 0;
	}
	
	public ProDuct (int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0); // 보너스 10% 제공 
	}

}
