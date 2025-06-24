package com.polymorphism;

public class TvTest {

	public static void main(String[] args) {
		
		// Tv t = new Tv ();
		CaptionTv c = new CaptionTv();
		// CaptionTv 인스턴스 멤버 중, Tv 클래스에 정의되지 않은 멤버, Txt, Caption은
		// 참조 변수 t로는 사용이 불가하다, 하지만
		// c는 둘다 사용이 가능하다.
		
		Tv t = new CaptionTv(); 
		// 부모 클래스의 참조 변수를 이용하면 자식 클래스의 인스턴스를 참조한다.
		
		// 참조 변수 t로는 CaptionTv 인스턴스의 모든 멤버를 사용할 수 없다.
		
		
		/* [형 변환 : 업 캐스팅]
		 * 	자손 타입 --> 조상 타입으로 형 변환됨 (형 변환 생략 가능)
		 * 
		 * [다운 캐스팅]
		 * 	자손 타입 <-- 조상 타입으로 형 변환됨 (형변이 생략 불가 : 명시해야 함)  
		 */
	}
}
