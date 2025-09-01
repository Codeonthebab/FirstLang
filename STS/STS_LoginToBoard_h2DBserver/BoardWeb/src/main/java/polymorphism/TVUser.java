package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


/*
 *    GenericXmlApplicationContext
 *      - 파일 시스템이나 클래스 경로에 있는 xml 설정 파일을 로딩하여 구동하는 컨테이너임
 *    
 *    XmlWebApplicationContext
 *    - 웹기반의 스프링 어플리케이션을 개발할 때 사용하는 컨테이너임
 */


public class TVUser {

	public static void main(String[] args) {
	
		
		// 1. Spring 컨테이너를 구동함
	
		AbstractApplicationContext factory = 
		new GenericXmlApplicationContext("applicationContext.xml");
		
		// Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
		/*
		TV tv1 =(TV) factory.getBean("tv");
		TV tv2 =(TV) factory.getBean("tv");
		TV tv3 =(TV) factory.getBean("tv");
		*/
		TV tv =(TV) factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	
		//3.Spring 컨테이너를 종료함
		factory.close();
		
		/*
		TV tv1 = new SamsungTV();
		//TV tv2 = new SamsungTV();
		//TV tv3 = new SamsungTV();
		TV tv2 = tv1;
		TV tv3 = tv2;
		*/
	
		
		
		
		
		
		
		
	}

}
