package com.polymorphism;

public class CarTest {

	public static void main(String[] args) {
		FireEngine f;
		Ambulance a;

		// a = (Ambulance)f; 
		// f = (FireEngine)a; 
		// 에러 : 상속 관계가 클래스 간의 형변환은 불가능함
      
		Car car = null;

		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		fe.water();
		car = fe; // car = (Car)fe로 업캐스팅 (형변환이 생략됨)
		// car = fe; = new FireEngine();

		// car.water(); 
		// 컴파일 에러: Car 클래스의 참조변수로 water()메소들을 호출할 수 없다.

		fe2 = (FireEngine)car; // 다운 캐스팅 --> 형병한 생략 가능
		fe2.water();

		System.out.println("-------------------------------");
		// Car c = new Car();
		Car c = new FireEngine();
		Car c2 = null;
		FireEngine fee = null;

		c.drive();
        // fee = c; 이렇게하면 에러가 남
		fee = (FireEngine)c;
		// 컴파일은 에러 없음, 하지만 실행시 에러발생
		// 형변환 오류 발생

		// 컴파일할때 참조변수간에 타입만 체크하기 때문에 실행시 생성될 인스턴스 타입에 대해서는 전혀알지 못함
		// 그래서 컴파일시에는 문제가 없지만 실행시에는 에러가 발생하여 비정상인 종료를 한다.

		fee.drive();
		c2 = fee;
		c2.drive();
	}
}
